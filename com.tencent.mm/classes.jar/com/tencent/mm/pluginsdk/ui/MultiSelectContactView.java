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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MultiSelectContactView
  extends LinearLayout
{
  private RecyclerView ETf;
  private HashSet<String> ETg;
  private Animation ETh;
  private int ETi;
  private c ETj;
  private d ETk;
  private e ETl;
  int ETm;
  boolean ETn;
  MMEditText ETo;
  ImageView ETp;
  private View fOB;
  private LayoutInflater jfG;
  private ArrayList<String> sec;
  
  public MultiSelectContactView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(102785);
    this.sec = new ArrayList();
    this.ETi = 0;
    this.ETm = getResources().getDimensionPixelSize(2131165239);
    this.ETn = false;
    this.jfG = LayoutInflater.from(paramContext);
    this.jfG.inflate(2131494988, this, true);
    this.ETf = ((RecyclerView)findViewById(2131302625));
    getContext();
    paramAttributeSet = new LinearLayoutManager();
    paramAttributeSet.setOrientation(0);
    this.ETf.setLayoutManager(paramAttributeSet);
    this.ETf.setAdapter(new a());
    this.ETg = new HashSet();
    this.ETh = AnimationUtils.loadAnimation(paramContext, 2130772047);
    this.fOB = findViewById(2131304239);
    setBackgroundColor(paramContext.getResources().getColor(2131099650));
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(102774);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/MultiSelectContactView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/MultiSelectContactView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(102774);
      }
    });
    AppMethodBeat.o(102785);
  }
  
  private void cz(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(102794);
    int i = this.sec.indexOf(paramString);
    if ((i >= 0) && (i < this.sec.size()))
    {
      this.ETg.remove(this.sec.remove(i));
      this.ETf.getAdapter().cl(i);
    }
    fbV();
    fbU();
    if ((paramBoolean) && (this.ETj != null)) {
      this.ETj.Q(1, paramString);
    }
    AppMethodBeat.o(102794);
  }
  
  private void fbT()
  {
    AppMethodBeat.i(102791);
    if (this.ETf.getChildCount() == 1)
    {
      AppMethodBeat.o(102791);
      return;
    }
    View localView = this.ETf.getChildAt(this.ETf.getChildCount() - 2);
    if (this.ETn)
    {
      if (localView == null)
      {
        AppMethodBeat.o(102791);
        return;
      }
      this.ETn = false;
      localView = localView.findViewById(2131302160);
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
    AppMethodBeat.o(102791);
  }
  
  private void fbU()
  {
    AppMethodBeat.i(102793);
    int i = Math.max(this.ETm * 2, this.ETf.getWidth() - (this.sec.size() + 1) * this.ETm);
    if ((getInputText() != null) && (getInputText().getWidth() != i)) {
      getInputText().setWidth(i);
    }
    AppMethodBeat.o(102793);
  }
  
  private void fbV()
  {
    AppMethodBeat.i(102795);
    View localView;
    if (getSearchIcon() != null)
    {
      localView = getSearchIcon();
      if (this.ETf.getAdapter().getItemCount() > 1) {
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
  
  public final void aMx(String paramString)
  {
    AppMethodBeat.i(102789);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(102789);
      return;
    }
    fbT();
    if (this.ETg.contains(paramString))
    {
      cz(paramString, false);
      AppMethodBeat.o(102789);
      return;
    }
    aMz(paramString);
    AppMethodBeat.o(102789);
  }
  
  public final void aMy(String paramString)
  {
    AppMethodBeat.i(102790);
    if (paramString != null)
    {
      cz(paramString, false);
      AppMethodBeat.o(102790);
      return;
    }
    AppMethodBeat.o(102790);
  }
  
  public final void aMz(String paramString)
  {
    AppMethodBeat.i(102792);
    this.ETg.add(paramString);
    this.sec.add(paramString);
    int i = this.ETf.getAdapter().getItemCount();
    this.ETf.getAdapter().ck(i - 2);
    RecyclerView localRecyclerView = this.ETf;
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i - 1, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.ahp(), "com/tencent/mm/pluginsdk/ui/MultiSelectContactView", "addContact", "(Ljava/lang/String;Z)V", "Undefined", "scrollToPosition", "(I)V");
    localRecyclerView.ca(((Integer)locala.mq(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/pluginsdk/ui/MultiSelectContactView", "addContact", "(Ljava/lang/String;Z)V", "Undefined", "scrollToPosition", "(I)V");
    fbV();
    fbU();
    if (this.ETj != null) {
      this.ETj.Q(0, paramString);
    }
    AppMethodBeat.o(102792);
  }
  
  public void clearFocus()
  {
    AppMethodBeat.i(102787);
    getInputText().clearFocus();
    fbT();
    AppMethodBeat.o(102787);
  }
  
  public EditText getInputText()
  {
    return this.ETo;
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
    b localb = (b)this.ETf.j(this.ETf.getAdapter().getItemCount() - 1, false);
    AppMethodBeat.o(102797);
    return localb;
  }
  
  public View getSearchIcon()
  {
    return this.ETp;
  }
  
  public final void hd(List<String> paramList)
  {
    AppMethodBeat.i(102788);
    this.sec.clear();
    this.ETg.clear();
    this.sec.addAll(paramList);
    this.ETg.addAll(paramList);
    this.ETf.getAdapter().asY.notifyChanged();
    int i = this.ETf.getAdapter().getItemCount();
    paramList = this.ETf;
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i - 1, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(paramList, locala.ahp(), "com/tencent/mm/pluginsdk/ui/MultiSelectContactView", "multiSelectChanged", "(Ljava/util/List;)V", "Undefined", "scrollToPosition", "(I)V");
    paramList.ca(((Integer)locala.mq(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(paramList, "com/tencent/mm/pluginsdk/ui/MultiSelectContactView", "multiSelectChanged", "(Ljava/util/List;)V", "Undefined", "scrollToPosition", "(I)V");
    fbV();
    fbU();
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
    this.ETj = paramc;
  }
  
  public void setOnSearchTextChangeListener(d paramd)
  {
    this.ETk = paramd;
  }
  
  public void setOnSearchTextFouceChangeListener(e parame)
  {
    this.ETl = parame;
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
    ImageView fRd;
    
    public b(View paramView, int paramInt)
    {
      super();
      AppMethodBeat.i(102784);
      if (paramInt != 1)
      {
        this.fRd = ((ImageView)paramView.findViewById(2131296996));
        paramInt = MultiSelectContactView.this.ETm;
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(paramInt, paramInt);
        localLayoutParams.rightMargin = MultiSelectContactView.this.getResources().getDimensionPixelSize(2131165187);
        paramView.setLayoutParams(localLayoutParams);
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(102779);
            b localb = new b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/MultiSelectContactView$ContactHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            MultiSelectContactView.a(MultiSelectContactView.this, (String)paramAnonymousView.getTag());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/MultiSelectContactView$ContactHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(102779);
          }
        });
        AppMethodBeat.o(102784);
        return;
      }
      MultiSelectContactView.this.ETp = ((ImageView)paramView.findViewById(2131302627));
      MultiSelectContactView.this.ETo = ((MMEditText)paramView.findViewById(2131302626));
      MultiSelectContactView.this.ETo.setWidth(MultiSelectContactView.this.getResources().getDisplayMetrics().widthPixels - MultiSelectContactView.this.ETm * 2);
      com.tencent.mm.ui.tools.b.c.d(MultiSelectContactView.this.ETo).aeU(100).a(null);
      MultiSelectContactView.this.ETo.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(102780);
          MultiSelectContactView.c(MultiSelectContactView.this);
          if (MultiSelectContactView.d(MultiSelectContactView.this) != null) {
            MultiSelectContactView.d(MultiSelectContactView.this).aMA(paramAnonymousCharSequence.toString());
          }
          AppMethodBeat.o(102780);
        }
      });
      MultiSelectContactView.this.ETo.setOnKeyListener(new View.OnKeyListener()
      {
        public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(102781);
          b localb = new b();
          localb.bd(paramAnonymousView);
          localb.mr(paramAnonymousInt);
          localb.bd(paramAnonymousKeyEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/MultiSelectContactView$ContactHolder$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.ahq());
          if ((paramAnonymousInt == 67) && (paramAnonymousKeyEvent.getAction() == 0) && (MultiSelectContactView.this.getInputText().getSelectionStart() == 0) && (MultiSelectContactView.this.getInputText().getSelectionEnd() == 0)) {
            MultiSelectContactView.e(MultiSelectContactView.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/pluginsdk/ui/MultiSelectContactView$ContactHolder$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
          AppMethodBeat.o(102781);
          return false;
        }
      });
      MultiSelectContactView.this.ETo.clearFocus();
      MultiSelectContactView.this.ETo.setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(102782);
          if (MultiSelectContactView.f(MultiSelectContactView.this) != null) {
            MultiSelectContactView.f(MultiSelectContactView.this).fbW();
          }
          AppMethodBeat.o(102782);
        }
      });
      MultiSelectContactView.this.ETo.post(new Runnable()
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
    public abstract void Q(int paramInt, String paramString);
  }
  
  public static abstract interface d
  {
    public abstract void aMA(String paramString);
  }
  
  public static abstract interface e
  {
    public abstract void fbW();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.MultiSelectContactView
 * JD-Core Version:    0.7.0.1
 */