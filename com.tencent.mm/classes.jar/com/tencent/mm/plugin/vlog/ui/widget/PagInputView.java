package com.tencent.mm.plugin.vlog.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.vlog.a.c;
import com.tencent.mm.plugin.vlog.a.f;
import com.tencent.mm.plugin.vlog.a.g;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.InsectRelativeLayout;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/widget/PagInputView;", "Lcom/tencent/mm/ui/widget/InsectRelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "closeView", "Landroid/view/View;", "doneView", "inputView", "Landroid/widget/EditText;", "lastBottom", "showImeRunnable", "Ljava/lang/Runnable;", "textChangeCallback", "Lkotlin/Function1;", "", "", "Lcom/tencent/mm/plugin/vlog/ui/widget/ChangeTextCallback;", "getTextChangeCallback", "()Lkotlin/jvm/functions/Function1;", "setTextChangeCallback", "(Lkotlin/jvm/functions/Function1;)V", "waitKeyBoardShown", "cancel", "confirm", "getResult", "", "insectBottom", "bottom", "isShow", "setImeVisibility", "visible", "setShow", "show", "setup", "text", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PagInputView
  extends InsectRelativeLayout
{
  private final View Usk;
  private final View Usl;
  private final EditText Usm;
  private kotlin.g.a.b<? super Boolean, ah> Usn;
  private int yml;
  private boolean ymm;
  private final Runnable ymo;
  
  public PagInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(281727);
    AppMethodBeat.o(281727);
  }
  
  public PagInputView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(281722);
    View.inflate(paramContext, a.g.editor_pag_input_view, (ViewGroup)this);
    setBackgroundResource(a.c.story_editor_text_panel_bg);
    paramContext = findViewById(a.f.edit_input_close);
    s.s(paramContext, "findViewById(R.id.edit_input_close)");
    this.Usk = paramContext;
    paramContext = findViewById(a.f.edit_input_done);
    s.s(paramContext, "findViewById(R.id.edit_input_done)");
    this.Usl = paramContext;
    paramContext = findViewById(a.f.edit_text_input);
    s.s(paramContext, "findViewById(R.id.edit_text_input)");
    this.Usm = ((EditText)paramContext);
    this.Usm.setOnFocusChangeListener(new PagInputView..ExternalSyntheticLambda3(this));
    this.Usk.setOnClickListener(new PagInputView..ExternalSyntheticLambda1(this));
    this.Usl.setOnClickListener(new PagInputView..ExternalSyntheticLambda0(this));
    setOnClickListener(new PagInputView..ExternalSyntheticLambda2(this));
    this.ymo = new PagInputView..ExternalSyntheticLambda4(this);
    AppMethodBeat.o(281722);
  }
  
  private static final void a(PagInputView paramPagInputView)
  {
    AppMethodBeat.i(281763);
    s.u(paramPagInputView, "this$0");
    InputMethodManager localInputMethodManager = (InputMethodManager)paramPagInputView.getContext().getSystemService("input_method");
    if (localInputMethodManager != null) {
      localInputMethodManager.showSoftInput((View)paramPagInputView.Usm, 0);
    }
    AppMethodBeat.o(281763);
  }
  
  private static final void a(PagInputView paramPagInputView, View paramView)
  {
    AppMethodBeat.i(281740);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramPagInputView);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/vlog/ui/widget/PagInputView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramPagInputView, "this$0");
    paramPagInputView = paramPagInputView.Usn;
    if (paramPagInputView != null) {
      paramPagInputView.invoke(Boolean.FALSE);
    }
    a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/widget/PagInputView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(281740);
  }
  
  private static final void a(PagInputView paramPagInputView, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(281735);
    s.u(paramPagInputView, "this$0");
    paramPagInputView.setImeVisibility(paramBoolean);
    AppMethodBeat.o(281735);
  }
  
  private static final void b(PagInputView paramPagInputView, View paramView)
  {
    AppMethodBeat.i(281747);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramPagInputView);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/vlog/ui/widget/PagInputView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramPagInputView, "this$0");
    paramPagInputView = paramPagInputView.Usn;
    if (paramPagInputView != null) {
      paramPagInputView.invoke(Boolean.TRUE);
    }
    a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/widget/PagInputView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(281747);
  }
  
  private static final void c(PagInputView paramPagInputView, View paramView)
  {
    AppMethodBeat.i(281757);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramPagInputView);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/vlog/ui/widget/PagInputView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramPagInputView, "this$0");
    paramPagInputView.Usm.requestFocus();
    paramPagInputView.setImeVisibility(true);
    a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/widget/PagInputView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(281757);
  }
  
  private final void setImeVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(281731);
    if (paramBoolean)
    {
      post(this.ymo);
      AppMethodBeat.o(281731);
      return;
    }
    removeCallbacks(this.ymo);
    InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    if (localInputMethodManager != null) {
      localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
    }
    AppMethodBeat.o(281731);
  }
  
  public final boolean La(int paramInt)
  {
    AppMethodBeat.i(281825);
    this.yml = paramInt;
    if (paramInt > bf.bk(getContext())) {
      paramInt = 1;
    }
    while (this.ymm) {
      if (paramInt != 0)
      {
        this.ymm = false;
        AppMethodBeat.o(281825);
        return false;
        paramInt = 0;
      }
      else
      {
        AppMethodBeat.o(281825);
        return true;
      }
    }
    AppMethodBeat.o(281825);
    return false;
  }
  
  public final String getResult()
  {
    AppMethodBeat.i(281809);
    String str = this.Usm.getText().toString();
    AppMethodBeat.o(281809);
    return str;
  }
  
  public final kotlin.g.a.b<Boolean, ah> getTextChangeCallback()
  {
    return this.Usn;
  }
  
  public final void setShow(boolean paramBoolean)
  {
    AppMethodBeat.i(281817);
    if (paramBoolean)
    {
      setVisibility(0);
      setPadding(0, 0, 0, this.yml);
      this.Usm.requestFocus();
      AppMethodBeat.o(281817);
      return;
    }
    this.Usm.clearFocus();
    this.ymm = true;
    setVisibility(8);
    AppMethodBeat.o(281817);
  }
  
  public final void setTextChangeCallback(kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    this.Usn = paramb;
  }
  
  public final void setup(String paramString)
  {
    AppMethodBeat.i(281804);
    s.u(paramString, "text");
    this.Usm.setText((CharSequence)paramString);
    this.Usm.setSelection(0, paramString.length());
    AppMethodBeat.o(281804);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.widget.PagInputView
 * JD-Core Version:    0.7.0.1
 */