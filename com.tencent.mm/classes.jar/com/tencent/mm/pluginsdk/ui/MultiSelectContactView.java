package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.v;
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
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MultiSelectContactView
  extends LinearLayout
{
  ImageView Aww;
  int KcA;
  boolean KcB;
  public MMEditText KcC;
  private RecyclerView Kct;
  private HashSet<String> Kcu;
  private Animation Kcv;
  private int Kcw;
  private MultiSelectContactView.c Kcx;
  private d Kcy;
  private e Kcz;
  private View gvQ;
  private LayoutInflater kgB;
  private ArrayList<String> uae;
  
  public MultiSelectContactView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(102785);
    this.uae = new ArrayList();
    this.Kcw = 0;
    this.KcA = getResources().getDimensionPixelSize(2131165243);
    this.KcB = false;
    this.kgB = LayoutInflater.from(paramContext);
    this.kgB.inflate(2131495802, this, true);
    this.Kct = ((RecyclerView)findViewById(2131305123));
    getContext();
    paramAttributeSet = new LinearLayoutManager();
    paramAttributeSet.setOrientation(0);
    this.Kct.setLayoutManager(paramAttributeSet);
    this.Kct.setAdapter(new a());
    this.Kcu = new HashSet();
    this.Kcv = AnimationUtils.loadAnimation(paramContext, 2130772059);
    this.gvQ = findViewById(2131307157);
    setBackgroundColor(paramContext.getResources().getColor(2131099650));
    setOnClickListener(new MultiSelectContactView.1(this));
    AppMethodBeat.o(102785);
  }
  
  private void cY(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(102794);
    int i = this.uae.indexOf(paramString);
    if ((i >= 0) && (i < this.uae.size()))
    {
      this.Kcu.remove(this.uae.remove(i));
      this.Kct.getAdapter().ck(i);
    }
    goS();
    goR();
    if ((paramBoolean) && (this.Kcx != null)) {
      this.Kcx.T(1, paramString);
    }
    AppMethodBeat.o(102794);
  }
  
  private void goQ()
  {
    AppMethodBeat.i(102791);
    if (this.Kct.getChildCount() == 1)
    {
      AppMethodBeat.o(102791);
      return;
    }
    View localView = this.Kct.getChildAt(this.Kct.getChildCount() - 2);
    if (this.KcB)
    {
      if (localView == null)
      {
        AppMethodBeat.o(102791);
        return;
      }
      this.KcB = false;
      localView = localView.findViewById(2131304501);
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
    AppMethodBeat.o(102791);
  }
  
  private void goR()
  {
    AppMethodBeat.i(102793);
    int i = Math.max(this.KcA * 2, this.Kct.getWidth() - (this.uae.size() + 1) * this.KcA);
    if ((getInputText() != null) && (getInputText().getWidth() != i)) {
      getInputText().setWidth(i);
    }
    AppMethodBeat.o(102793);
  }
  
  private void goS()
  {
    AppMethodBeat.i(102795);
    View localView;
    if (getSearchIcon() != null)
    {
      localView = getSearchIcon();
      if (this.Kct.getAdapter().getItemCount() > 1) {
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
  
  public final void bev(String paramString)
  {
    AppMethodBeat.i(102789);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(102789);
      return;
    }
    goQ();
    if (this.Kcu.contains(paramString))
    {
      cY(paramString, false);
      AppMethodBeat.o(102789);
      return;
    }
    bex(paramString);
    AppMethodBeat.o(102789);
  }
  
  public final void bew(String paramString)
  {
    AppMethodBeat.i(102790);
    if (paramString != null)
    {
      cY(paramString, false);
      AppMethodBeat.o(102790);
      return;
    }
    AppMethodBeat.o(102790);
  }
  
  public final void bex(String paramString)
  {
    AppMethodBeat.i(102792);
    this.Kcu.add(paramString);
    this.uae.add(paramString);
    int i = this.Kct.getAdapter().getItemCount();
    this.Kct.getAdapter().cj(i - 2);
    RecyclerView localRecyclerView = this.Kct;
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i - 1, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.axQ(), "com/tencent/mm/pluginsdk/ui/MultiSelectContactView", "addContact", "(Ljava/lang/String;Z)V", "Undefined", "scrollToPosition", "(I)V");
    localRecyclerView.scrollToPosition(((Integer)locala.pG(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/pluginsdk/ui/MultiSelectContactView", "addContact", "(Ljava/lang/String;Z)V", "Undefined", "scrollToPosition", "(I)V");
    goS();
    goR();
    if (this.Kcx != null) {
      this.Kcx.T(0, paramString);
    }
    AppMethodBeat.o(102792);
  }
  
  public void clearFocus()
  {
    AppMethodBeat.i(102787);
    getInputText().clearFocus();
    goQ();
    AppMethodBeat.o(102787);
  }
  
  public EditText getInputText()
  {
    return this.KcC;
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
    b localb = (b)this.Kct.k(this.Kct.getAdapter().getItemCount() - 1, false);
    AppMethodBeat.o(102797);
    return localb;
  }
  
  public View getSearchIcon()
  {
    return this.Aww;
  }
  
  public final void it(List<String> paramList)
  {
    AppMethodBeat.i(102788);
    this.uae.clear();
    this.Kcu.clear();
    this.uae.addAll(paramList);
    this.Kcu.addAll(paramList);
    this.Kct.getAdapter().atj.notifyChanged();
    int i = this.Kct.getAdapter().getItemCount();
    paramList = this.Kct;
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i - 1, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(paramList, locala.axQ(), "com/tencent/mm/pluginsdk/ui/MultiSelectContactView", "multiSelectChanged", "(Ljava/util/List;)V", "Undefined", "scrollToPosition", "(I)V");
    paramList.scrollToPosition(((Integer)locala.pG(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(paramList, "com/tencent/mm/pluginsdk/ui/MultiSelectContactView", "multiSelectChanged", "(Ljava/util/List;)V", "Undefined", "scrollToPosition", "(I)V");
    goS();
    goR();
    AppMethodBeat.o(102788);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(102786);
    super.onAttachedToWindow();
    AppMethodBeat.o(102786);
  }
  
  public void setHiddenSearchWord(String paramString) {}
  
  public void setOnContactDeselectListener(MultiSelectContactView.c paramc)
  {
    this.Kcx = paramc;
  }
  
  public void setOnSearchTextChangeListener(d paramd)
  {
    this.Kcy = paramd;
  }
  
  public void setOnSearchTextFouceChangeListener(e parame)
  {
    this.Kcz = parame;
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
    extends RecyclerView.v
  {
    ImageView gyr;
    
    public b(View paramView, int paramInt)
    {
      super();
      AppMethodBeat.i(102784);
      if (paramInt != 1)
      {
        this.gyr = ((ImageView)paramView.findViewById(2131297119));
        paramInt = MultiSelectContactView.this.KcA;
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(paramInt, paramInt);
        localLayoutParams.rightMargin = MultiSelectContactView.this.getResources().getDimensionPixelSize(2131165190);
        paramView.setLayoutParams(localLayoutParams);
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(102779);
            b localb = new b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/MultiSelectContactView$ContactHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            MultiSelectContactView.a(MultiSelectContactView.this, (String)paramAnonymousView.getTag());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/MultiSelectContactView$ContactHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(102779);
          }
        });
        AppMethodBeat.o(102784);
        return;
      }
      MultiSelectContactView.this.Aww = ((ImageView)paramView.findViewById(2131305125));
      MultiSelectContactView.this.KcC = ((MMEditText)paramView.findViewById(2131305124));
      MultiSelectContactView.this.KcC.setWidth(MultiSelectContactView.this.getResources().getDisplayMetrics().widthPixels - MultiSelectContactView.this.KcA * 2);
      com.tencent.mm.ui.tools.b.c.f(MultiSelectContactView.this.KcC).aoq(100).a(null);
      MultiSelectContactView.this.KcC.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(102780);
          MultiSelectContactView.c(MultiSelectContactView.this);
          if (MultiSelectContactView.d(MultiSelectContactView.this) != null) {
            MultiSelectContactView.d(MultiSelectContactView.this).bey(paramAnonymousCharSequence.toString());
          }
          AppMethodBeat.o(102780);
        }
      });
      MultiSelectContactView.this.KcC.setOnKeyListener(new View.OnKeyListener()
      {
        public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(102781);
          b localb = new b();
          localb.bm(paramAnonymousView);
          localb.pH(paramAnonymousInt);
          localb.bm(paramAnonymousKeyEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/MultiSelectContactView$ContactHolder$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.axR());
          if ((paramAnonymousInt == 67) && (paramAnonymousKeyEvent.getAction() == 0) && (MultiSelectContactView.this.getInputText().getSelectionStart() == 0) && (MultiSelectContactView.this.getInputText().getSelectionEnd() == 0)) {
            MultiSelectContactView.e(MultiSelectContactView.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/pluginsdk/ui/MultiSelectContactView$ContactHolder$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
          AppMethodBeat.o(102781);
          return false;
        }
      });
      MultiSelectContactView.this.KcC.clearFocus();
      MultiSelectContactView.this.KcC.setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(102782);
          if (MultiSelectContactView.f(MultiSelectContactView.this) != null) {
            MultiSelectContactView.f(MultiSelectContactView.this).goT();
          }
          AppMethodBeat.o(102782);
        }
      });
      MultiSelectContactView.this.KcC.post(new Runnable()
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
  
  public static abstract interface d
  {
    public abstract void bey(String paramString);
  }
  
  public static abstract interface e
  {
    public abstract void goT();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.MultiSelectContactView
 * JD-Core Version:    0.7.0.1
 */