package com.tencent.mm.plugin.vlog.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.InsectRelativeLayout;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/widget/PagInputView;", "Lcom/tencent/mm/ui/widget/InsectRelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "closeView", "Landroid/view/View;", "doneView", "inputView", "Landroid/widget/EditText;", "lastBottom", "showImeRunnable", "Ljava/lang/Runnable;", "textChangeCallback", "Lkotlin/Function1;", "", "", "Lcom/tencent/mm/plugin/vlog/ui/widget/ChangeTextCallback;", "getTextChangeCallback", "()Lkotlin/jvm/functions/Function1;", "setTextChangeCallback", "(Lkotlin/jvm/functions/Function1;)V", "waitKeyBoardShown", "cancel", "confirm", "getResult", "", "insectBottom", "bottom", "isShow", "setImeVisibility", "visible", "setShow", "show", "setup", "text", "plugin-vlog_release"})
public final class PagInputView
  extends InsectRelativeLayout
{
  private final View GQo;
  private final View GQp;
  private final EditText GQq;
  private kotlin.g.a.b<? super Boolean, x> GQr;
  private int ruG;
  private boolean ruH;
  private final Runnable ruJ;
  
  public PagInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(192197);
    AppMethodBeat.o(192197);
  }
  
  public PagInputView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(192196);
    View.inflate(paramContext, 2131493891, (ViewGroup)this);
    setBackgroundResource(2131101208);
    paramContext = findViewById(2131299831);
    p.g(paramContext, "findViewById(R.id.edit_input_close)");
    this.GQo = paramContext;
    paramContext = findViewById(2131299832);
    p.g(paramContext, "findViewById(R.id.edit_input_done)");
    this.GQp = paramContext;
    paramContext = findViewById(2131299842);
    p.g(paramContext, "findViewById(R.id.edit_text_input)");
    this.GQq = ((EditText)paramContext);
    this.GQq.setOnFocusChangeListener((View.OnFocusChangeListener)new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(192186);
        PagInputView.a(this.GQs, paramAnonymousBoolean);
        AppMethodBeat.o(192186);
      }
    });
    this.GQo.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(192187);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/vlog/ui/widget/PagInputView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        PagInputView.a(this.GQs);
        a.a(this, "com/tencent/mm/plugin/vlog/ui/widget/PagInputView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(192187);
      }
    });
    this.GQp.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(192188);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/vlog/ui/widget/PagInputView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        PagInputView.b(this.GQs);
        a.a(this, "com/tencent/mm/plugin/vlog/ui/widget/PagInputView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(192188);
      }
    });
    setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(192189);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/vlog/ui/widget/PagInputView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        PagInputView.c(this.GQs).requestFocus();
        PagInputView.a(this.GQs, true);
        a.a(this, "com/tencent/mm/plugin/vlog/ui/widget/PagInputView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(192189);
      }
    });
    this.ruJ = ((Runnable)new a(this));
    AppMethodBeat.o(192196);
  }
  
  private final void setImeVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(192194);
    if (paramBoolean)
    {
      post(this.ruJ);
      AppMethodBeat.o(192194);
      return;
    }
    removeCallbacks(this.ruJ);
    InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    if (localInputMethodManager != null)
    {
      localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
      AppMethodBeat.o(192194);
      return;
    }
    AppMethodBeat.o(192194);
  }
  
  public final boolean Gv(int paramInt)
  {
    AppMethodBeat.i(192195);
    this.ruG = paramInt;
    if (paramInt > au.aD(getContext())) {
      paramInt = 1;
    }
    while (this.ruH) {
      if (paramInt != 0)
      {
        this.ruH = false;
        AppMethodBeat.o(192195);
        return false;
        paramInt = 0;
      }
      else
      {
        AppMethodBeat.o(192195);
        return true;
      }
    }
    AppMethodBeat.o(192195);
    return false;
  }
  
  public final String getResult()
  {
    AppMethodBeat.i(192192);
    String str = this.GQq.getText().toString();
    AppMethodBeat.o(192192);
    return str;
  }
  
  public final kotlin.g.a.b<Boolean, x> getTextChangeCallback()
  {
    return this.GQr;
  }
  
  public final void setShow(boolean paramBoolean)
  {
    AppMethodBeat.i(192193);
    if (paramBoolean)
    {
      setVisibility(0);
      setPadding(0, 0, 0, this.ruG);
      this.GQq.requestFocus();
      AppMethodBeat.o(192193);
      return;
    }
    this.GQq.clearFocus();
    this.ruH = true;
    setVisibility(8);
    AppMethodBeat.o(192193);
  }
  
  public final void setTextChangeCallback(kotlin.g.a.b<? super Boolean, x> paramb)
  {
    this.GQr = paramb;
  }
  
  public final void setup(String paramString)
  {
    AppMethodBeat.i(192191);
    p.h(paramString, "text");
    this.GQq.setText((CharSequence)paramString);
    this.GQq.setSelection(0, paramString.length());
    AppMethodBeat.o(192191);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(PagInputView paramPagInputView) {}
    
    public final void run()
    {
      AppMethodBeat.i(192190);
      InputMethodManager localInputMethodManager = (InputMethodManager)this.GQs.getContext().getSystemService("input_method");
      if (localInputMethodManager != null)
      {
        localInputMethodManager.showSoftInput((View)PagInputView.c(this.GQs), 0);
        AppMethodBeat.o(192190);
        return;
      }
      AppMethodBeat.o(192190);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.widget.PagInputView
 * JD-Core Version:    0.7.0.1
 */