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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/widget/PagInputView;", "Lcom/tencent/mm/ui/widget/InsectRelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "closeView", "Landroid/view/View;", "doneView", "inputView", "Landroid/widget/EditText;", "lastBottom", "showImeRunnable", "Ljava/lang/Runnable;", "textChangeCallback", "Lkotlin/Function1;", "", "", "Lcom/tencent/mm/plugin/vlog/ui/widget/ChangeTextCallback;", "getTextChangeCallback", "()Lkotlin/jvm/functions/Function1;", "setTextChangeCallback", "(Lkotlin/jvm/functions/Function1;)V", "waitKeyBoardShown", "cancel", "confirm", "getResult", "", "insectBottom", "bottom", "isShow", "setImeVisibility", "visible", "setShow", "show", "setup", "text", "plugin-vlog_release"})
public final class PagInputView
  extends InsectRelativeLayout
{
  private final View BUO;
  private final View BUP;
  private final EditText BUQ;
  private d.g.a.b<? super Boolean, z> BUR;
  private int pXd;
  private boolean pXe;
  private final Runnable pXg;
  
  public PagInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(196890);
    AppMethodBeat.o(196890);
  }
  
  public PagInputView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(196889);
    View.inflate(paramContext, 2131496450, (ViewGroup)this);
    setBackgroundResource(2131100978);
    paramContext = findViewById(2131308268);
    p.g(paramContext, "findViewById(R.id.edit_input_close)");
    this.BUO = paramContext;
    paramContext = findViewById(2131308269);
    p.g(paramContext, "findViewById(R.id.edit_input_done)");
    this.BUP = paramContext;
    paramContext = findViewById(2131308272);
    p.g(paramContext, "findViewById(R.id.edit_text_input)");
    this.BUQ = ((EditText)paramContext);
    this.BUQ.setOnFocusChangeListener((View.OnFocusChangeListener)new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(196879);
        PagInputView.a(this.BUS, paramAnonymousBoolean);
        AppMethodBeat.o(196879);
      }
    });
    this.BUO.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196880);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/vlog/ui/widget/PagInputView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        PagInputView.a(this.BUS);
        a.a(this, "com/tencent/mm/plugin/vlog/ui/widget/PagInputView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(196880);
      }
    });
    this.BUP.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196881);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/vlog/ui/widget/PagInputView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        PagInputView.b(this.BUS);
        a.a(this, "com/tencent/mm/plugin/vlog/ui/widget/PagInputView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(196881);
      }
    });
    setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196882);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/vlog/ui/widget/PagInputView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        PagInputView.c(this.BUS).requestFocus();
        PagInputView.a(this.BUS, true);
        a.a(this, "com/tencent/mm/plugin/vlog/ui/widget/PagInputView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(196882);
      }
    });
    this.pXg = ((Runnable)new a(this));
    AppMethodBeat.o(196889);
  }
  
  private final void setImeVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(196887);
    if (paramBoolean)
    {
      post(this.pXg);
      AppMethodBeat.o(196887);
      return;
    }
    removeCallbacks(this.pXg);
    InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    if (localInputMethodManager != null)
    {
      localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
      AppMethodBeat.o(196887);
      return;
    }
    AppMethodBeat.o(196887);
  }
  
  public final boolean Cy(int paramInt)
  {
    AppMethodBeat.i(196888);
    this.pXd = paramInt;
    if (paramInt > ar.ej(getContext())) {
      paramInt = 1;
    }
    while (this.pXe) {
      if (paramInt != 0)
      {
        this.pXe = false;
        AppMethodBeat.o(196888);
        return false;
        paramInt = 0;
      }
      else
      {
        AppMethodBeat.o(196888);
        return true;
      }
    }
    AppMethodBeat.o(196888);
    return false;
  }
  
  public final String getResult()
  {
    AppMethodBeat.i(196885);
    String str = this.BUQ.getText().toString();
    AppMethodBeat.o(196885);
    return str;
  }
  
  public final d.g.a.b<Boolean, z> getTextChangeCallback()
  {
    return this.BUR;
  }
  
  public final void setShow(boolean paramBoolean)
  {
    AppMethodBeat.i(196886);
    if (paramBoolean)
    {
      setVisibility(0);
      setPadding(0, 0, 0, this.pXd);
      this.BUQ.requestFocus();
      AppMethodBeat.o(196886);
      return;
    }
    this.BUQ.clearFocus();
    this.pXe = true;
    setVisibility(8);
    AppMethodBeat.o(196886);
  }
  
  public final void setTextChangeCallback(d.g.a.b<? super Boolean, z> paramb)
  {
    this.BUR = paramb;
  }
  
  public final void setup(String paramString)
  {
    AppMethodBeat.i(196884);
    p.h(paramString, "text");
    this.BUQ.setText((CharSequence)paramString);
    this.BUQ.setSelection(0, paramString.length());
    AppMethodBeat.o(196884);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(PagInputView paramPagInputView) {}
    
    public final void run()
    {
      AppMethodBeat.i(196883);
      InputMethodManager localInputMethodManager = (InputMethodManager)this.BUS.getContext().getSystemService("input_method");
      if (localInputMethodManager != null)
      {
        localInputMethodManager.showSoftInput((View)PagInputView.c(this.BUS), 0);
        AppMethodBeat.o(196883);
        return;
      }
      AppMethodBeat.o(196883);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.widget.PagInputView
 * JD-Core Version:    0.7.0.1
 */