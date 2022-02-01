package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup.LayoutParams;
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
  public ArrayList<String> BmO;
  ImageView Boh;
  private RecyclerView XZe;
  private HashSet<String> XZf;
  private Animation XZg;
  private int XZh;
  private c XZi;
  private d XZj;
  private e XZk;
  int XZl;
  boolean XZm;
  MMEditText XZn;
  private View lBX;
  private LayoutInflater pUI;
  
  public MultiSelectContactView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(102785);
    this.BmO = new ArrayList();
    this.XZh = 0;
    this.XZl = getResources().getDimensionPixelSize(a.c.ContactAvatarSize);
    this.XZm = false;
    this.pUI = LayoutInflater.from(paramContext);
    this.pUI.inflate(a.f.muti_select_contact_view, this, true);
    this.XZe = ((RecyclerView)findViewById(a.e.mutiselectcontact_avatar_recyclerview));
    getContext();
    paramAttributeSet = new LinearLayoutManager();
    paramAttributeSet.setOrientation(0);
    this.XZe.setLayoutManager(paramAttributeSet);
    this.XZe.setAdapter(new a());
    this.XZf = new HashSet();
    this.XZg = AnimationUtils.loadAnimation(paramContext, a.a.fast_faded_in);
    this.lBX = findViewById(a.e.root);
    setBackgroundColor(paramContext.getResources().getColor(a.b.BG_2));
    setOnClickListener(new MultiSelectContactView.1(this));
    AppMethodBeat.o(102785);
  }
  
  private void iKx()
  {
    AppMethodBeat.i(102791);
    if (this.XZe.getChildCount() == 1)
    {
      AppMethodBeat.o(102791);
      return;
    }
    View localView = this.XZe.getChildAt(this.XZe.getChildCount() - 2);
    if (this.XZm)
    {
      if (localView == null)
      {
        AppMethodBeat.o(102791);
        return;
      }
      this.XZm = false;
      localView = localView.findViewById(a.e.mask);
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
    AppMethodBeat.o(102791);
  }
  
  private void iKy()
  {
    AppMethodBeat.i(102793);
    if (this.BmO.size() == 0) {}
    for (int i = com.tencent.mm.cd.a.ms(getContext()) - this.XZl * 2;; i = Math.max(this.XZl * 2, this.XZe.getWidth() - (this.BmO.size() + 1) * this.XZl))
    {
      if ((getInputText() != null) && (getInputText().getLayoutParams().width != i))
      {
        getInputText().getLayoutParams().width = i;
        getInputText().setWidth(i);
        getInputText().invalidate();
      }
      AppMethodBeat.o(102793);
      return;
    }
  }
  
  private void iKz()
  {
    AppMethodBeat.i(102795);
    View localView;
    if (getSearchIcon() != null)
    {
      localView = getSearchIcon();
      if (this.XZe.getAdapter().getItemCount() > 1) {
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
  
  public final void bqG(String paramString)
  {
    AppMethodBeat.i(102789);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(102789);
      return;
    }
    iKx();
    if (this.XZf.contains(paramString))
    {
      dW(paramString, false);
      AppMethodBeat.o(102789);
      return;
    }
    bqI(paramString);
    AppMethodBeat.o(102789);
  }
  
  public final void bqH(String paramString)
  {
    AppMethodBeat.i(102790);
    if (paramString != null)
    {
      dW(paramString, false);
      AppMethodBeat.o(102790);
      return;
    }
    AppMethodBeat.o(102790);
  }
  
  public final void bqI(String paramString)
  {
    AppMethodBeat.i(102792);
    this.XZf.add(paramString);
    this.BmO.add(paramString);
    int i = this.XZe.getAdapter().getItemCount();
    this.XZe.getAdapter().fW(i - 2);
    RecyclerView localRecyclerView = this.XZe;
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i - 1, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(localRecyclerView, locala.aYi(), "com/tencent/mm/pluginsdk/ui/MultiSelectContactView", "addContact", "(Ljava/lang/String;Z)V", "Undefined", "scrollToPosition", "(I)V");
    localRecyclerView.scrollToPosition(((Integer)locala.sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localRecyclerView, "com/tencent/mm/pluginsdk/ui/MultiSelectContactView", "addContact", "(Ljava/lang/String;Z)V", "Undefined", "scrollToPosition", "(I)V");
    iKz();
    iKy();
    if (this.XZi != null) {
      this.XZi.ad(0, paramString);
    }
    AppMethodBeat.o(102792);
  }
  
  public void clearFocus()
  {
    AppMethodBeat.i(102787);
    getInputText().clearFocus();
    iKx();
    AppMethodBeat.o(102787);
  }
  
  public final void dW(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(102794);
    int i = this.BmO.indexOf(paramString);
    if ((i >= 0) && (i < this.BmO.size()))
    {
      this.XZf.remove(this.BmO.remove(i));
      this.XZe.getAdapter().fX(i);
    }
    iKz();
    iKy();
    if ((paramBoolean) && (this.XZi != null)) {
      this.XZi.ad(1, paramString);
    }
    AppMethodBeat.o(102794);
  }
  
  public EditText getInputText()
  {
    return this.XZn;
  }
  
  public String getSearchContent()
  {
    AppMethodBeat.i(102796);
    if (getInputText() != null)
    {
      String str = getInputText().getText().toString();
      AppMethodBeat.o(102796);
      return str;
    }
    AppMethodBeat.o(102796);
    return "";
  }
  
  public b getSearchHolder()
  {
    AppMethodBeat.i(102797);
    b localb = (b)this.XZe.w(this.XZe.getAdapter().getItemCount() - 1, false);
    AppMethodBeat.o(102797);
    return localb;
  }
  
  public View getSearchIcon()
  {
    return this.Boh;
  }
  
  public final void iKA()
  {
    AppMethodBeat.i(245107);
    getInputText().setText("");
    AppMethodBeat.o(245107);
  }
  
  public final void iKv()
  {
    AppMethodBeat.i(245083);
    if (this.XZn != null)
    {
      this.XZn.setHintTextColor(getResources().getColor(a.b.BW_100_Alpha_0_3));
      this.XZn.setTextColor(getResources().getColor(a.b.BW_100_Alpha_0_3));
    }
    AppMethodBeat.o(245083);
  }
  
  public final void iKw()
  {
    AppMethodBeat.i(245086);
    if (this.lBX != null) {
      this.lBX.setBackgroundColor(getResources().getColor(a.b.Dark_2));
    }
    AppMethodBeat.o(245086);
  }
  
  public final void mv(List<String> paramList)
  {
    AppMethodBeat.i(102788);
    this.BmO.clear();
    this.XZf.clear();
    this.BmO.addAll(paramList);
    this.XZf.addAll(paramList);
    this.XZe.getAdapter().bZE.notifyChanged();
    int i = this.XZe.getAdapter().getItemCount();
    paramList = this.XZe;
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i - 1, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(paramList, locala.aYi(), "com/tencent/mm/pluginsdk/ui/MultiSelectContactView", "multiSelectChanged", "(Ljava/util/List;)V", "Undefined", "scrollToPosition", "(I)V");
    paramList.scrollToPosition(((Integer)locala.sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(paramList, "com/tencent/mm/pluginsdk/ui/MultiSelectContactView", "multiSelectChanged", "(Ljava/util/List;)V", "Undefined", "scrollToPosition", "(I)V");
    iKz();
    iKy();
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
    this.XZi = paramc;
  }
  
  public void setOnSearchTextChangeListener(d paramd)
  {
    this.XZj = paramd;
  }
  
  public void setOnSearchTextFouceChangeListener(e parame)
  {
    this.XZk = parame;
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
    ImageView lKK;
    
    public b(View paramView, int paramInt)
    {
      super();
      AppMethodBeat.i(102784);
      if (paramInt != 1)
      {
        this.lKK = ((ImageView)paramView.findViewById(a.e.avatar));
        paramInt = MultiSelectContactView.this.XZl;
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(paramInt, paramInt);
        localLayoutParams.rightMargin = MultiSelectContactView.this.getResources().getDimensionPixelSize(a.c.BasicPaddingSize);
        paramView.setLayoutParams(localLayoutParams);
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(102779);
            b localb = new b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/MultiSelectContactView$ContactHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            MultiSelectContactView.a(MultiSelectContactView.this, (String)paramAnonymousView.getTag());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/MultiSelectContactView$ContactHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(102779);
          }
        });
        AppMethodBeat.o(102784);
        return;
      }
      MultiSelectContactView.this.Boh = ((ImageView)paramView.findViewById(a.e.mutiselectcontact_searchicon));
      MultiSelectContactView.c(MultiSelectContactView.this);
      MultiSelectContactView.this.XZn = ((MMEditText)paramView.findViewById(a.e.mutiselectcontact_edittext));
      com.tencent.mm.ui.tools.b.c.i(MultiSelectContactView.this.XZn).aEg(100).a(null);
      MultiSelectContactView.this.XZn.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(102780);
          MultiSelectContactView.d(MultiSelectContactView.this);
          if (MultiSelectContactView.e(MultiSelectContactView.this) != null) {
            MultiSelectContactView.e(MultiSelectContactView.this).bqJ(paramAnonymousCharSequence.toString());
          }
          AppMethodBeat.o(102780);
        }
      });
      MultiSelectContactView.this.XZn.setOnKeyListener(new View.OnKeyListener()
      {
        public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(102781);
          b localb = new b();
          localb.cH(paramAnonymousView);
          localb.sc(paramAnonymousInt);
          localb.cH(paramAnonymousKeyEvent);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/MultiSelectContactView$ContactHolder$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.aYj());
          if ((paramAnonymousInt == 67) && (paramAnonymousKeyEvent.getAction() == 0) && (MultiSelectContactView.this.getInputText().getSelectionStart() == 0) && (MultiSelectContactView.this.getInputText().getSelectionEnd() == 0)) {
            MultiSelectContactView.f(MultiSelectContactView.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/pluginsdk/ui/MultiSelectContactView$ContactHolder$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
          AppMethodBeat.o(102781);
          return false;
        }
      });
      MultiSelectContactView.this.XZn.clearFocus();
      MultiSelectContactView.this.XZn.setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(102782);
          if (MultiSelectContactView.g(MultiSelectContactView.this) != null) {
            MultiSelectContactView.g(MultiSelectContactView.this).JC(paramAnonymousBoolean);
          }
          AppMethodBeat.o(102782);
        }
      });
      MultiSelectContactView.this.XZn.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(102783);
          MultiSelectContactView.h(MultiSelectContactView.this);
          AppMethodBeat.o(102783);
        }
      });
      AppMethodBeat.o(102784);
    }
  }
  
  public static abstract interface c
  {
    public abstract void ad(int paramInt, String paramString);
  }
  
  public static abstract interface d
  {
    public abstract void bqJ(String paramString);
  }
  
  public static abstract interface e
  {
    public abstract void JC(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.MultiSelectContactView
 * JD-Core Version:    0.7.0.1
 */