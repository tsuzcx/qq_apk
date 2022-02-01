package com.tencent.mm.plugin.repairer.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.e;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/repairer/ui/RepairerSetValueDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "Lcom/tencent/mm/ui/widget/InputPanelHelper$OnInputPanelChange;", "dialogContext", "Landroid/content/Context;", "title", "", "initValue", "onValueSetListener", "Lcom/tencent/mm/plugin/repairer/ui/OnValueSetListener;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/repairer/ui/OnValueSetListener;)V", "getDialogContext", "()Landroid/content/Context;", "setDialogContext", "(Landroid/content/Context;)V", "getInitValue", "()Ljava/lang/String;", "okBtn", "Landroid/widget/Button;", "getOkBtn", "()Landroid/widget/Button;", "setOkBtn", "(Landroid/widget/Button;)V", "getOnValueSetListener", "()Lcom/tencent/mm/plugin/repairer/ui/OnValueSetListener;", "getTitle", "valueEt", "Landroid/widget/EditText;", "getValueEt", "()Landroid/widget/EditText;", "setValueEt", "(Landroid/widget/EditText;)V", "hideVKB", "", "initContentView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onInputPanelChange", "isKeyboardShow", "", "keyboardHeight", "", "showVKB", "ui-repairer_release"})
public final class c
  extends e
  implements com.tencent.mm.ui.widget.c.a
{
  Context GKX;
  EditText Ixf;
  private final String Ixg;
  final a Ixh;
  private Button kEt;
  private final String title;
  
  public c(Context paramContext, String paramString1, String paramString2, a parama)
  {
    super(paramContext, b.e.IwW);
    AppMethodBeat.i(227454);
    this.GKX = paramContext;
    this.title = paramString1;
    this.Ixg = paramString2;
    this.Ixh = parama;
    AppMethodBeat.o(227454);
  }
  
  public final void h(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(227451);
    if (paramBoolean)
    {
      localView = findViewById(b.a.input_container);
      if (localView != null)
      {
        localView.setPadding(0, 0, 0, paramInt);
        AppMethodBeat.o(227451);
        return;
      }
      AppMethodBeat.o(227451);
      return;
    }
    View localView = findViewById(b.a.input_container);
    if (localView != null)
    {
      localView.setPadding(0, 0, 0, 0);
      AppMethodBeat.o(227451);
      return;
    }
    AppMethodBeat.o(227451);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(227447);
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle.setLayout(-1, -1);
    }
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle.addFlags(67108864);
    }
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle.setDimAmount(0.5F);
    }
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle.setWindowAnimations(b.e.BottomToTopSlowAnimation);
    }
    paramBundle = LayoutInflater.from(this.GKX).inflate(b.b.IwT, null, false);
    setContentView(paramBundle, new ViewGroup.LayoutParams(-1, -1));
    Object localObject = paramBundle.findViewById(b.a.title_tv);
    p.j(localObject, "view.findViewById<TextView>(R.id.title_tv)");
    ((TextView)localObject).setText((CharSequence)this.title);
    this.Ixf = ((EditText)paramBundle.findViewById(b.a.value_et));
    this.kEt = ((Button)paramBundle.findViewById(b.a.ok_btn));
    localObject = this.Ixf;
    if (localObject != null) {
      ((EditText)localObject).requestFocus();
    }
    localObject = this.Ixg;
    if (localObject != null)
    {
      EditText localEditText = this.Ixf;
      if (localEditText != null) {
        localEditText.setText((CharSequence)localObject);
      }
      localEditText = this.Ixf;
      if (localEditText != null) {
        localEditText.setSelection(((String)localObject).length());
      }
    }
    paramBundle.findViewById(b.a.empty_area_view).setOnTouchListener((View.OnTouchListener)new a(this));
    setCancelable(true);
    paramBundle = (InputPanelLinearLayout)findViewById(b.a.input_container);
    if (paramBundle != null) {
      paramBundle.setExternalListener((com.tencent.mm.ui.widget.c.a)this);
    }
    h.ZvG.n((Runnable)new b(this), 128L);
    paramBundle = this.kEt;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new c(this));
    }
    setOnDismissListener((DialogInterface.OnDismissListener)new d(this));
    AppMethodBeat.o(227447);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class a
    implements View.OnTouchListener
  {
    a(c paramc) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(227206);
      this.Ixi.cancel();
      AppMethodBeat.o(227206);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(227391);
      Object localObject1 = this.Ixi;
      Object localObject2 = ((c)localObject1).GKX.getSystemService("input_method");
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        AppMethodBeat.o(227391);
        throw ((Throwable)localObject1);
      }
      ((InputMethodManager)localObject2).showSoftInput((View)((c)localObject1).Ixf, 0);
      AppMethodBeat.o(227391);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(c paramc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(226633);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/RepairerSetValueDialog$initContentView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      paramView = this.Ixi.Ixf;
      if (paramView != null)
      {
        paramView = paramView.getText();
        if (paramView != null)
        {
          paramView = paramView.toString();
          if (paramView != null)
          {
            localObject = this.Ixi.Ixh;
            if (localObject != null) {
              ((a)localObject).aWU(paramView);
            }
          }
        }
      }
      this.Ixi.dismiss();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/repairer/ui/RepairerSetValueDialog$initContentView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(226633);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class d
    implements DialogInterface.OnDismissListener
  {
    d(c paramc) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(226983);
      paramDialogInterface = this.Ixi;
      Object localObject = paramDialogInterface.GKX.getSystemService("input_method");
      if (localObject == null)
      {
        paramDialogInterface = new t("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        AppMethodBeat.o(226983);
        throw paramDialogInterface;
      }
      localObject = (InputMethodManager)localObject;
      paramDialogInterface = paramDialogInterface.Ixf;
      if (paramDialogInterface != null) {}
      for (paramDialogInterface = paramDialogInterface.getWindowToken();; paramDialogInterface = null)
      {
        ((InputMethodManager)localObject).hideSoftInputFromWindow(paramDialogInterface, 0);
        AppMethodBeat.o(226983);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.c
 * JD-Core Version:    0.7.0.1
 */