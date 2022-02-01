package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.w;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MultiSelectContactView
  extends LinearLayout
{
  private RecyclerView DnZ;
  private HashSet<String> Doa;
  private Animation Dob;
  private int Doc;
  private c Dod;
  private d Doe;
  private e Dof;
  int Dog;
  boolean Doh;
  MMEditText Doi;
  ImageView Doj;
  private View fvu;
  private LayoutInflater iMw;
  private ArrayList<String> rpr;
  
  public MultiSelectContactView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(102785);
    this.rpr = new ArrayList();
    this.Doc = 0;
    this.Dog = getResources().getDimensionPixelSize(2131165239);
    this.Doh = false;
    this.iMw = LayoutInflater.from(paramContext);
    this.iMw.inflate(2131494988, this, true);
    this.DnZ = ((RecyclerView)findViewById(2131302625));
    getContext();
    paramAttributeSet = new LinearLayoutManager();
    paramAttributeSet.setOrientation(0);
    this.DnZ.setLayoutManager(paramAttributeSet);
    this.DnZ.setAdapter(new a());
    this.Doa = new HashSet();
    this.Dob = AnimationUtils.loadAnimation(paramContext, 2130772047);
    this.fvu = findViewById(2131304239);
    setBackgroundColor(ao.aJ(getContext(), 2130968579));
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(102774);
        AppMethodBeat.o(102774);
      }
    });
    AppMethodBeat.o(102785);
  }
  
  private void cu(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(102794);
    int i = this.rpr.indexOf(paramString);
    if ((i >= 0) && (i < this.rpr.size()))
    {
      this.Doa.remove(this.rpr.remove(i));
      this.DnZ.getAdapter().cl(i);
    }
    eMW();
    eMV();
    if ((paramBoolean) && (this.Dod != null)) {
      this.Dod.O(1, paramString);
    }
    AppMethodBeat.o(102794);
  }
  
  private void eMU()
  {
    AppMethodBeat.i(102791);
    if (this.DnZ.getChildCount() == 1)
    {
      AppMethodBeat.o(102791);
      return;
    }
    View localView = this.DnZ.getChildAt(this.DnZ.getChildCount() - 2);
    if (this.Doh)
    {
      if (localView == null)
      {
        AppMethodBeat.o(102791);
        return;
      }
      this.Doh = false;
      localView = localView.findViewById(2131302160);
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
    AppMethodBeat.o(102791);
  }
  
  private void eMV()
  {
    AppMethodBeat.i(102793);
    int i = Math.max(this.Dog * 2, this.DnZ.getWidth() - (this.rpr.size() + 1) * this.Dog);
    if ((getInputText() != null) && (getInputText().getWidth() != i)) {
      getInputText().setWidth(i);
    }
    AppMethodBeat.o(102793);
  }
  
  private void eMW()
  {
    AppMethodBeat.i(102795);
    View localView;
    if (getSearchIcon() != null)
    {
      localView = getSearchIcon();
      if (this.DnZ.getAdapter().getItemCount() > 1) {
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
  
  public final void aGU(String paramString)
  {
    AppMethodBeat.i(102789);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(102789);
      return;
    }
    eMU();
    if (this.Doa.contains(paramString))
    {
      cu(paramString, false);
      AppMethodBeat.o(102789);
      return;
    }
    aGW(paramString);
    AppMethodBeat.o(102789);
  }
  
  public final void aGV(String paramString)
  {
    AppMethodBeat.i(102790);
    if (paramString != null)
    {
      cu(paramString, false);
      AppMethodBeat.o(102790);
      return;
    }
    AppMethodBeat.o(102790);
  }
  
  public final void aGW(String paramString)
  {
    AppMethodBeat.i(102792);
    this.Doa.add(paramString);
    this.rpr.add(paramString);
    int i = this.DnZ.getAdapter().getItemCount();
    this.DnZ.getAdapter().ck(i - 2);
    RecyclerView localRecyclerView = this.DnZ;
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i - 1, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.aeD(), "com/tencent/mm/pluginsdk/ui/MultiSelectContactView", "addContact", "(Ljava/lang/String;Z)V", "Undefined", "scrollToPosition", "(I)V");
    localRecyclerView.ca(((Integer)locala.lR(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/pluginsdk/ui/MultiSelectContactView", "addContact", "(Ljava/lang/String;Z)V", "Undefined", "scrollToPosition", "(I)V");
    eMW();
    eMV();
    if (this.Dod != null) {
      this.Dod.O(0, paramString);
    }
    AppMethodBeat.o(102792);
  }
  
  public void clearFocus()
  {
    AppMethodBeat.i(102787);
    getInputText().clearFocus();
    eMU();
    AppMethodBeat.o(102787);
  }
  
  public final void gR(List<String> paramList)
  {
    AppMethodBeat.i(102788);
    this.rpr.clear();
    this.Doa.clear();
    this.rpr.addAll(paramList);
    this.Doa.addAll(paramList);
    this.DnZ.getAdapter().arg.notifyChanged();
    int i = this.DnZ.getAdapter().getItemCount();
    paramList = this.DnZ;
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i - 1, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(paramList, locala.aeD(), "com/tencent/mm/pluginsdk/ui/MultiSelectContactView", "multiSelectChanged", "(Ljava/util/List;)V", "Undefined", "scrollToPosition", "(I)V");
    paramList.ca(((Integer)locala.lR(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(paramList, "com/tencent/mm/pluginsdk/ui/MultiSelectContactView", "multiSelectChanged", "(Ljava/util/List;)V", "Undefined", "scrollToPosition", "(I)V");
    eMW();
    eMV();
    AppMethodBeat.o(102788);
  }
  
  public EditText getInputText()
  {
    return this.Doi;
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
    b localb = (b)this.DnZ.j(this.DnZ.getAdapter().getItemCount() - 1, false);
    AppMethodBeat.o(102797);
    return localb;
  }
  
  public View getSearchIcon()
  {
    return this.Doj;
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
    this.Dod = paramc;
  }
  
  public void setOnSearchTextChangeListener(d paramd)
  {
    this.Doe = paramd;
  }
  
  public void setOnSearchTextFouceChangeListener(e parame)
  {
    this.Dof = parame;
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
  
  final class b
    extends RecyclerView.w
  {
    ImageView fxQ;
    
    public b(View paramView, int paramInt)
    {
      super();
      AppMethodBeat.i(102784);
      if (paramInt != 1)
      {
        this.fxQ = ((ImageView)paramView.findViewById(2131296996));
        paramInt = MultiSelectContactView.this.Dog;
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(paramInt, paramInt);
        localLayoutParams.rightMargin = MultiSelectContactView.this.getResources().getDimensionPixelSize(2131165187);
        paramView.setLayoutParams(localLayoutParams);
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(102779);
            MultiSelectContactView.a(MultiSelectContactView.this, (String)paramAnonymousView.getTag());
            AppMethodBeat.o(102779);
          }
        });
        AppMethodBeat.o(102784);
        return;
      }
      MultiSelectContactView.this.Doj = ((ImageView)paramView.findViewById(2131302627));
      MultiSelectContactView.this.Doi = ((MMEditText)paramView.findViewById(2131302626));
      MultiSelectContactView.this.Doi.setWidth(MultiSelectContactView.this.getResources().getDisplayMetrics().widthPixels - MultiSelectContactView.this.Dog * 2);
      com.tencent.mm.ui.tools.b.c.d(MultiSelectContactView.this.Doi).acw(100).a(null);
      MultiSelectContactView.this.Doi.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(102780);
          MultiSelectContactView.c(MultiSelectContactView.this);
          if (MultiSelectContactView.d(MultiSelectContactView.this) != null) {
            MultiSelectContactView.d(MultiSelectContactView.this).aGX(paramAnonymousCharSequence.toString());
          }
          AppMethodBeat.o(102780);
        }
      });
      MultiSelectContactView.this.Doi.setOnKeyListener(new View.OnKeyListener()
      {
        public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(102781);
          if ((paramAnonymousInt == 67) && (paramAnonymousKeyEvent.getAction() == 0) && (MultiSelectContactView.this.getInputText().getSelectionStart() == 0) && (MultiSelectContactView.this.getInputText().getSelectionEnd() == 0)) {
            MultiSelectContactView.e(MultiSelectContactView.this);
          }
          AppMethodBeat.o(102781);
          return false;
        }
      });
      MultiSelectContactView.this.Doi.clearFocus();
      MultiSelectContactView.this.Doi.setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(102782);
          if (MultiSelectContactView.f(MultiSelectContactView.this) != null) {
            MultiSelectContactView.f(MultiSelectContactView.this).eMX();
          }
          AppMethodBeat.o(102782);
        }
      });
      MultiSelectContactView.this.Doi.post(new Runnable()
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
    public abstract void O(int paramInt, String paramString);
  }
  
  public static abstract interface d
  {
    public abstract void aGX(String paramString);
  }
  
  public static abstract interface e
  {
    public abstract void eMX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.MultiSelectContactView
 * JD-Core Version:    0.7.0.1
 */