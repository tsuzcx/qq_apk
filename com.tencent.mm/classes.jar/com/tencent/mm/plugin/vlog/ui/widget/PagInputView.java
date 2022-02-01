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
import com.tencent.mm.plugin.vlog.a.c;
import com.tencent.mm.plugin.vlog.a.f;
import com.tencent.mm.plugin.vlog.a.g;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.widget.InsectRelativeLayout;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/widget/PagInputView;", "Lcom/tencent/mm/ui/widget/InsectRelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "closeView", "Landroid/view/View;", "doneView", "inputView", "Landroid/widget/EditText;", "lastBottom", "showImeRunnable", "Ljava/lang/Runnable;", "textChangeCallback", "Lkotlin/Function1;", "", "", "Lcom/tencent/mm/plugin/vlog/ui/widget/ChangeTextCallback;", "getTextChangeCallback", "()Lkotlin/jvm/functions/Function1;", "setTextChangeCallback", "(Lkotlin/jvm/functions/Function1;)V", "waitKeyBoardShown", "cancel", "confirm", "getResult", "", "insectBottom", "bottom", "isShow", "setImeVisibility", "visible", "setShow", "show", "setup", "text", "plugin-vlog_release"})
public final class PagInputView
  extends InsectRelativeLayout
{
  private final View NGe;
  private final View NGf;
  private final EditText NGg;
  private kotlin.g.a.b<? super Boolean, x> NGh;
  private int vak;
  private boolean vam;
  private final Runnable vao;
  
  public PagInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(249435);
    AppMethodBeat.o(249435);
  }
  
  public PagInputView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(249434);
    View.inflate(paramContext, a.g.editor_pag_input_view, (ViewGroup)this);
    setBackgroundResource(a.c.story_editor_text_panel_bg);
    paramContext = findViewById(a.f.edit_input_close);
    p.j(paramContext, "findViewById(R.id.edit_input_close)");
    this.NGe = paramContext;
    paramContext = findViewById(a.f.edit_input_done);
    p.j(paramContext, "findViewById(R.id.edit_input_done)");
    this.NGf = paramContext;
    paramContext = findViewById(a.f.edit_text_input);
    p.j(paramContext, "findViewById(R.id.edit_text_input)");
    this.NGg = ((EditText)paramContext);
    this.NGg.setOnFocusChangeListener((View.OnFocusChangeListener)new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(225275);
        PagInputView.a(this.NGi, paramAnonymousBoolean);
        AppMethodBeat.o(225275);
      }
    });
    this.NGe.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(228804);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/vlog/ui/widget/PagInputView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        PagInputView.a(this.NGi);
        a.a(this, "com/tencent/mm/plugin/vlog/ui/widget/PagInputView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(228804);
      }
    });
    this.NGf.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(232454);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/vlog/ui/widget/PagInputView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        PagInputView.b(this.NGi);
        a.a(this, "com/tencent/mm/plugin/vlog/ui/widget/PagInputView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(232454);
      }
    });
    setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(227944);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/vlog/ui/widget/PagInputView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        PagInputView.c(this.NGi).requestFocus();
        PagInputView.a(this.NGi, true);
        a.a(this, "com/tencent/mm/plugin/vlog/ui/widget/PagInputView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(227944);
      }
    });
    this.vao = ((Runnable)new a(this));
    AppMethodBeat.o(249434);
  }
  
  private final void setImeVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(249429);
    if (paramBoolean)
    {
      post(this.vao);
      AppMethodBeat.o(249429);
      return;
    }
    removeCallbacks(this.vao);
    InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    if (localInputMethodManager != null)
    {
      localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
      AppMethodBeat.o(249429);
      return;
    }
    AppMethodBeat.o(249429);
  }
  
  public final boolean Kc(int paramInt)
  {
    AppMethodBeat.i(249431);
    this.vak = paramInt;
    if (paramInt > ax.aB(getContext())) {
      paramInt = 1;
    }
    while (this.vam) {
      if (paramInt != 0)
      {
        this.vam = false;
        AppMethodBeat.o(249431);
        return false;
        paramInt = 0;
      }
      else
      {
        AppMethodBeat.o(249431);
        return true;
      }
    }
    AppMethodBeat.o(249431);
    return false;
  }
  
  public final String getResult()
  {
    AppMethodBeat.i(249426);
    String str = this.NGg.getText().toString();
    AppMethodBeat.o(249426);
    return str;
  }
  
  public final kotlin.g.a.b<Boolean, x> getTextChangeCallback()
  {
    return this.NGh;
  }
  
  public final void setShow(boolean paramBoolean)
  {
    AppMethodBeat.i(249428);
    if (paramBoolean)
    {
      setVisibility(0);
      setPadding(0, 0, 0, this.vak);
      this.NGg.requestFocus();
      AppMethodBeat.o(249428);
      return;
    }
    this.NGg.clearFocus();
    this.vam = true;
    setVisibility(8);
    AppMethodBeat.o(249428);
  }
  
  public final void setTextChangeCallback(kotlin.g.a.b<? super Boolean, x> paramb)
  {
    this.NGh = paramb;
  }
  
  public final void setup(String paramString)
  {
    AppMethodBeat.i(249424);
    p.k(paramString, "text");
    this.NGg.setText((CharSequence)paramString);
    this.NGg.setSelection(0, paramString.length());
    AppMethodBeat.o(249424);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(PagInputView paramPagInputView) {}
    
    public final void run()
    {
      AppMethodBeat.i(227847);
      InputMethodManager localInputMethodManager = (InputMethodManager)this.NGi.getContext().getSystemService("input_method");
      if (localInputMethodManager != null)
      {
        localInputMethodManager.showSoftInput((View)PagInputView.c(this.NGi), 0);
        AppMethodBeat.o(227847);
        return;
      }
      AppMethodBeat.o(227847);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.widget.PagInputView
 * JD-Core Version:    0.7.0.1
 */