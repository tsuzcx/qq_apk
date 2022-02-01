package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.selectcontact.a.a;
import com.tencent.mm.plugin.selectcontact.a.b;
import com.tencent.mm.plugin.selectcontact.a.c;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.f;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MultiSelectContactView
  extends LinearLayout
{
  private RecyclerView RcY;
  private HashSet<String> RcZ;
  private Animation Rda;
  private int Rdb;
  private c Rdc;
  private d Rdd;
  private e Rde;
  int Rdf;
  boolean Rdg;
  MMEditText Rdh;
  private View jac;
  private LayoutInflater mYa;
  private ArrayList<String> xMG;
  ImageView xOf;
  
  public MultiSelectContactView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(102785);
    this.xMG = new ArrayList();
    this.Rdb = 0;
    this.Rdf = getResources().getDimensionPixelSize(a.c.ContactAvatarSize);
    this.Rdg = false;
    this.mYa = LayoutInflater.from(paramContext);
    this.mYa.inflate(a.f.muti_select_contact_view, this, true);
    this.RcY = ((RecyclerView)findViewById(a.e.mutiselectcontact_avatar_recyclerview));
    getContext();
    paramAttributeSet = new LinearLayoutManager();
    paramAttributeSet.setOrientation(0);
    this.RcY.setLayoutManager(paramAttributeSet);
    this.RcY.setAdapter(new a());
    this.RcZ = new HashSet();
    this.Rda = AnimationUtils.loadAnimation(paramContext, a.a.fast_faded_in);
    this.jac = findViewById(a.e.root);
    setBackgroundColor(paramContext.getResources().getColor(a.b.BG_2));
    setOnClickListener(new MultiSelectContactView.1(this));
    AppMethodBeat.o(102785);
  }
  
  private void dm(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(102794);
    int i = this.xMG.indexOf(paramString);
    if ((i >= 0) && (i < this.xMG.size()))
    {
      this.RcZ.remove(this.xMG.remove(i));
      this.RcY.getAdapter().cN(i);
    }
    hjH();
    hjG();
    if ((paramBoolean) && (this.Rdc != null)) {
      this.Rdc.V(1, paramString);
    }
    AppMethodBeat.o(102794);
  }
  
  private void hjF()
  {
    AppMethodBeat.i(102791);
    if (this.RcY.getChildCount() == 1)
    {
      AppMethodBeat.o(102791);
      return;
    }
    View localView = this.RcY.getChildAt(this.RcY.getChildCount() - 2);
    if (this.Rdg)
    {
      if (localView == null)
      {
        AppMethodBeat.o(102791);
        return;
      }
      this.Rdg = false;
      localView = localView.findViewById(a.e.mask);
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
    AppMethodBeat.o(102791);
  }
  
  private void hjG()
  {
    AppMethodBeat.i(102793);
    int i = Math.max(this.Rdf * 2, this.RcY.getWidth() - (this.xMG.size() + 1) * this.Rdf);
    if ((getInputText() != null) && (getInputText().getWidth() != i)) {
      getInputText().setWidth(i);
    }
    AppMethodBeat.o(102793);
  }
  
  private void hjH()
  {
    AppMethodBeat.i(102795);
    View localView;
    if (getSearchIcon() != null)
    {
      localView = getSearchIcon();
      if (this.RcY.getAdapter().getItemCount() > 1) {
        break label46;
      }
    }
    label46:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(102795);
      return;
    }
  }
  
  public final void bqR(String paramString)
  {
    AppMethodBeat.i(102789);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(102789);
      return;
    }
    hjF();
    if (this.RcZ.contains(paramString))
    {
      dm(paramString, false);
      AppMethodBeat.o(102789);
      return;
    }
    bqT(paramString);
    AppMethodBeat.o(102789);
  }
  
  public final void bqS(String paramString)
  {
    AppMethodBeat.i(102790);
    if (paramString != null)
    {
      dm(paramString, false);
      AppMethodBeat.o(102790);
      return;
    }
    AppMethodBeat.o(102790);
  }
  
  public final void bqT(String paramString)
  {
    AppMethodBeat.i(102792);
    this.RcZ.add(paramString);
    this.xMG.add(paramString);
    int i = this.RcY.getAdapter().getItemCount();
    this.RcY.getAdapter().cM(i - 2);
    RecyclerView localRecyclerView = this.RcY;
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i - 1, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(localRecyclerView, locala.aFh(), "com/tencent/mm/pluginsdk/ui/MultiSelectContactView", "addContact", "(Ljava/lang/String;Z)V", "Undefined", "scrollToPosition", "(I)V");
    localRecyclerView.scrollToPosition(((Integer)locala.sf(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localRecyclerView, "com/tencent/mm/pluginsdk/ui/MultiSelectContactView", "addContact", "(Ljava/lang/String;Z)V", "Undefined", "scrollToPosition", "(I)V");
    hjH();
    hjG();
    if (this.Rdc != null) {
      this.Rdc.V(0, paramString);
    }
    AppMethodBeat.o(102792);
  }
  
  public void clearFocus()
  {
    AppMethodBeat.i(102787);
    getInputText().clearFocus();
    hjF();
    AppMethodBeat.o(102787);
  }
  
  public EditText getInputText()
  {
    return this.Rdh;
  }
  
  public String getSearchContent()
  {
    AppMethodBeat.i(102796);
    String str = getInputText().getText().toString();
    AppMethodBeat.o(102796);
    return str;
  }
  
  public b getSearchHolder()
  {
    AppMethodBeat.i(102797);
    b localb = (b)this.RcY.i(this.RcY.getAdapter().getItemCount() - 1, false);
    AppMethodBeat.o(102797);
    return localb;
  }
  
  public View getSearchIcon()
  {
    return this.xOf;
  }
  
  public final void hjD()
  {
    AppMethodBeat.i(187003);
    if (this.Rdh != null)
    {
      this.Rdh.setHintTextColor(getResources().getColor(a.b.BW_100_Alpha_0_3));
      this.Rdh.setTextColor(getResources().getColor(a.b.BW_100_Alpha_0_3));
    }
    AppMethodBeat.o(187003);
  }
  
  public final void hjE()
  {
    AppMethodBeat.i(187007);
    if (this.jac != null) {
      this.jac.setBackgroundColor(getResources().getColor(a.b.Dark_2));
    }
    AppMethodBeat.o(187007);
  }
  
  public final void jk(List<String> paramList)
  {
    AppMethodBeat.i(102788);
    this.xMG.clear();
    this.RcZ.clear();
    this.xMG.addAll(paramList);
    this.RcZ.addAll(paramList);
    this.RcY.getAdapter().alc.notifyChanged();
    int i = this.RcY.getAdapter().getItemCount();
    paramList = this.RcY;
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i - 1, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(paramList, locala.aFh(), "com/tencent/mm/pluginsdk/ui/MultiSelectContactView", "multiSelectChanged", "(Ljava/util/List;)V", "Undefined", "scrollToPosition", "(I)V");
    paramList.scrollToPosition(((Integer)locala.sf(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(paramList, "com/tencent/mm/pluginsdk/ui/MultiSelectContactView", "multiSelectChanged", "(Ljava/util/List;)V", "Undefined", "scrollToPosition", "(I)V");
    hjH();
    hjG();
    AppMethodBeat.o(102788);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(102786);
    super.onAttachedToWindow();
    AppMethodBeat.o(102786);
  }
  
  public void setHiddenSearchWord(String paramString) {}
  
  public void setOnContactDeselectListener(c paramc)
  {
    this.Rdc = paramc;
  }
  
  public void setOnSearchTextChangeListener(d paramd)
  {
    this.Rdd = paramd;
  }
  
  public void setOnSearchTextFouceChangeListener(e parame)
  {
    this.Rde = parame;
  }
  
  final class a
    extends RecyclerView.a<MultiSelectContactView.b>
  {
    a() {}
    
    public final int getItemCount()
    {
      AppMethodBeat.i(102776);
      int i = MultiSelectContactView.b(MultiSelectContactView.this).size();
      AppMethodBeat.o(102776);
      return i + 1;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(102775);
      if (paramInt == getItemCount() - 1)
      {
        AppMethodBeat.o(102775);
        return 1;
      }
      AppMethodBeat.o(102775);
      return 0;
    }
  }
  
  class b
    extends RecyclerView.v
  {
    ImageView jiu;
    
    public b(View paramView, int paramInt)
    {
      super();
      AppMethodBeat.i(102784);
      if (paramInt != 1)
      {
        this.jiu = ((ImageView)paramView.findViewById(a.e.avatar));
        paramInt = MultiSelectContactView.this.Rdf;
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(paramInt, paramInt);
        localLayoutParams.rightMargin = MultiSelectContactView.this.getResources().getDimensionPixelSize(a.c.BasicPaddingSize);
        paramView.setLayoutParams(localLayoutParams);
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(102779);
            b localb = new b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/MultiSelectContactView$ContactHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            MultiSelectContactView.a(MultiSelectContactView.this, (String)paramAnonymousView.getTag());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/MultiSelectContactView$ContactHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(102779);
          }
        });
        AppMethodBeat.o(102784);
        return;
      }
      MultiSelectContactView.this.xOf = ((ImageView)paramView.findViewById(a.e.mutiselectcontact_searchicon));
      MultiSelectContactView.this.Rdh = ((MMEditText)paramView.findViewById(a.e.mutiselectcontact_edittext));
      MultiSelectContactView.this.Rdh.setWidth(MultiSelectContactView.this.getResources().getDisplayMetrics().widthPixels - MultiSelectContactView.this.Rdf * 2);
      com.tencent.mm.ui.tools.b.c.i(MultiSelectContactView.this.Rdh).axx(100).a(null);
      MultiSelectContactView.this.Rdh.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(102780);
          MultiSelectContactView.c(MultiSelectContactView.this);
          if (MultiSelectContactView.d(MultiSelectContactView.this) != null) {
            MultiSelectContactView.d(MultiSelectContactView.this).bqU(paramAnonymousCharSequence.toString());
          }
          AppMethodBeat.o(102780);
        }
      });
      MultiSelectContactView.this.Rdh.setOnKeyListener(new View.OnKeyListener()
      {
        public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(102781);
          b localb = new b();
          localb.bn(paramAnonymousView);
          localb.sg(paramAnonymousInt);
          localb.bn(paramAnonymousKeyEvent);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/MultiSelectContactView$ContactHolder$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.aFi());
          if ((paramAnonymousInt == 67) && (paramAnonymousKeyEvent.getAction() == 0) && (MultiSelectContactView.this.getInputText().getSelectionStart() == 0) && (MultiSelectContactView.this.getInputText().getSelectionEnd() == 0)) {
            MultiSelectContactView.e(MultiSelectContactView.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/pluginsdk/ui/MultiSelectContactView$ContactHolder$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
          AppMethodBeat.o(102781);
          return false;
        }
      });
      MultiSelectContactView.this.Rdh.clearFocus();
      MultiSelectContactView.this.Rdh.setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(102782);
          if (MultiSelectContactView.f(MultiSelectContactView.this) != null) {
            MultiSelectContactView.f(MultiSelectContactView.this).hjI();
          }
          AppMethodBeat.o(102782);
        }
      });
      MultiSelectContactView.this.Rdh.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(102783);
          MultiSelectContactView.g(MultiSelectContactView.this);
          AppMethodBeat.o(102783);
        }
      });
      AppMethodBeat.o(102784);
    }
  }
  
  public static abstract interface c
  {
    public abstract void V(int paramInt, String paramString);
  }
  
  public static abstract interface d
  {
    public abstract void bqU(String paramString);
  }
  
  public static abstract interface e
  {
    public abstract void hjI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.MultiSelectContactView
 * JD-Core Version:    0.7.0.1
 */