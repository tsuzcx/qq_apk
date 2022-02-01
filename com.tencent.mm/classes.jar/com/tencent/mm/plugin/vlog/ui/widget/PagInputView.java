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
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.InsectRelativeLayout;
import d.g.b.p;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/widget/PagInputView;", "Lcom/tencent/mm/ui/widget/InsectRelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "closeView", "Landroid/view/View;", "doneView", "inputView", "Landroid/widget/EditText;", "lastBottom", "showImeRunnable", "Ljava/lang/Runnable;", "textChangeCallback", "Lkotlin/Function1;", "", "", "Lcom/tencent/mm/plugin/vlog/ui/widget/ChangeTextCallback;", "getTextChangeCallback", "()Lkotlin/jvm/functions/Function1;", "setTextChangeCallback", "(Lkotlin/jvm/functions/Function1;)V", "waitKeyBoardShown", "cancel", "confirm", "getResult", "", "insectBottom", "bottom", "isShow", "setImeVisibility", "visible", "setShow", "show", "setup", "text", "plugin-vlog_release"})
public final class PagInputView
  extends InsectRelativeLayout
{
  private final View Cmp;
  private final View Cmq;
  private final EditText Cmr;
  private d.g.a.b<? super Boolean, z> Cms;
  private int qdI;
  private boolean qdJ;
  private final Runnable qdL;
  
  public PagInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(192353);
    AppMethodBeat.o(192353);
  }
  
  public PagInputView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(192352);
    View.inflate(paramContext, 2131496450, (ViewGroup)this);
    setBackgroundResource(2131100978);
    paramContext = findViewById(2131308268);
    p.g(paramContext, "findViewById(R.id.edit_input_close)");
    this.Cmp = paramContext;
    paramContext = findViewById(2131308269);
    p.g(paramContext, "findViewById(R.id.edit_input_done)");
    this.Cmq = paramContext;
    paramContext = findViewById(2131308272);
    p.g(paramContext, "findViewById(R.id.edit_text_input)");
    this.Cmr = ((EditText)paramContext);
    this.Cmr.setOnFocusChangeListener((View.OnFocusChangeListener)new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(192342);
        PagInputView.a(this.Cmt, paramAnonymousBoolean);
        AppMethodBeat.o(192342);
      }
    });
    this.Cmp.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(192343);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/vlog/ui/widget/PagInputView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        PagInputView.a(this.Cmt);
        a.a(this, "com/tencent/mm/plugin/vlog/ui/widget/PagInputView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(192343);
      }
    });
    this.Cmq.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(192344);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/vlog/ui/widget/PagInputView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        PagInputView.b(this.Cmt);
        a.a(this, "com/tencent/mm/plugin/vlog/ui/widget/PagInputView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(192344);
      }
    });
    setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(192345);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/vlog/ui/widget/PagInputView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        PagInputView.c(this.Cmt).requestFocus();
        PagInputView.a(this.Cmt, true);
        a.a(this, "com/tencent/mm/plugin/vlog/ui/widget/PagInputView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(192345);
      }
    });
    this.qdL = ((Runnable)new a(this));
    AppMethodBeat.o(192352);
  }
  
  private final void setImeVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(192350);
    if (paramBoolean)
    {
      post(this.qdL);
      AppMethodBeat.o(192350);
      return;
    }
    removeCallbacks(this.qdL);
    InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    if (localInputMethodManager != null)
    {
      localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
      AppMethodBeat.o(192350);
      return;
    }
    AppMethodBeat.o(192350);
  }
  
  public final boolean CK(int paramInt)
  {
    AppMethodBeat.i(192351);
    this.qdI = paramInt;
    if (paramInt > ar.en(getContext())) {
      paramInt = 1;
    }
    while (this.qdJ) {
      if (paramInt != 0)
      {
        this.qdJ = false;
        AppMethodBeat.o(192351);
        return false;
        paramInt = 0;
      }
      else
      {
        AppMethodBeat.o(192351);
        return true;
      }
    }
    AppMethodBeat.o(192351);
    return false;
  }
  
  public final String getResult()
  {
    AppMethodBeat.i(192348);
    String str = this.Cmr.getText().toString();
    AppMethodBeat.o(192348);
    return str;
  }
  
  public final d.g.a.b<Boolean, z> getTextChangeCallback()
  {
    return this.Cms;
  }
  
  public final void setShow(boolean paramBoolean)
  {
    AppMethodBeat.i(192349);
    if (paramBoolean)
    {
      setVisibility(0);
      setPadding(0, 0, 0, this.qdI);
      this.Cmr.requestFocus();
      AppMethodBeat.o(192349);
      return;
    }
    this.Cmr.clearFocus();
    this.qdJ = true;
    setVisibility(8);
    AppMethodBeat.o(192349);
  }
  
  public final void setTextChangeCallback(d.g.a.b<? super Boolean, z> paramb)
  {
    this.Cms = paramb;
  }
  
  public final void setup(String paramString)
  {
    AppMethodBeat.i(192347);
    p.h(paramString, "text");
    this.Cmr.setText((CharSequence)paramString);
    this.Cmr.setSelection(0, paramString.length());
    AppMethodBeat.o(192347);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(PagInputView paramPagInputView) {}
    
    public final void run()
    {
      AppMethodBeat.i(192346);
      InputMethodManager localInputMethodManager = (InputMethodManager)this.Cmt.getContext().getSystemService("input_method");
      if (localInputMethodManager != null)
      {
        localInputMethodManager.showSoftInput((View)PagInputView.c(this.Cmt), 0);
        AppMethodBeat.o(192346);
        return;
      }
      AppMethodBeat.o(192346);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.widget.PagInputView
 * JD-Core Version:    0.7.0.1
 */