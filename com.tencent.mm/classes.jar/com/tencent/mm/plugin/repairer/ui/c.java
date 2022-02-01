package com.tencent.mm.plugin.repairer.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.c.a;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/RepairerSetValueDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "Lcom/tencent/mm/ui/widget/InputPanelHelper$OnInputPanelChange;", "dialogContext", "Landroid/content/Context;", "title", "", "initValue", "onValueSetListener", "Lcom/tencent/mm/plugin/repairer/ui/OnValueSetListener;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/repairer/ui/OnValueSetListener;)V", "getDialogContext", "()Landroid/content/Context;", "setDialogContext", "(Landroid/content/Context;)V", "getInitValue", "()Ljava/lang/String;", "okBtn", "Landroid/widget/Button;", "getOkBtn", "()Landroid/widget/Button;", "setOkBtn", "(Landroid/widget/Button;)V", "getOnValueSetListener", "()Lcom/tencent/mm/plugin/repairer/ui/OnValueSetListener;", "getTitle", "valueEt", "Landroid/widget/EditText;", "getValueEt", "()Landroid/widget/EditText;", "setValueEt", "(Landroid/widget/EditText;)V", "hideVKB", "", "initContentView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onInputPanelChange", "isKeyboardShow", "", "keyboardHeight", "", "showVKB", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends e
  implements c.a
{
  private Context MHM;
  private final a OwA;
  private EditText OwB;
  private final String Owz;
  private Button nhC;
  private final String title;
  
  public c(Context paramContext, String paramString1, String paramString2, a parama)
  {
    super(paramContext, b.g.Own);
    AppMethodBeat.i(277942);
    this.MHM = paramContext;
    this.title = paramString1;
    this.Owz = paramString2;
    this.OwA = parama;
    AppMethodBeat.o(277942);
  }
  
  private static final void a(c paramc)
  {
    AppMethodBeat.i(277961);
    s.u(paramc, "this$0");
    Object localObject = paramc.MHM.getSystemService("input_method");
    if (localObject == null)
    {
      paramc = new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
      AppMethodBeat.o(277961);
      throw paramc;
    }
    ((InputMethodManager)localObject).showSoftInput((View)paramc.OwB, 0);
    AppMethodBeat.o(277961);
  }
  
  private static final void a(c paramc, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(277972);
    s.u(paramc, "this$0");
    paramDialogInterface = paramc.MHM.getSystemService("input_method");
    if (paramDialogInterface == null)
    {
      paramc = new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
      AppMethodBeat.o(277972);
      throw paramc;
    }
    paramDialogInterface = (InputMethodManager)paramDialogInterface;
    paramc = paramc.OwB;
    if (paramc == null) {}
    for (paramc = null;; paramc = paramc.getWindowToken())
    {
      paramDialogInterface.hideSoftInputFromWindow(paramc, 0);
      AppMethodBeat.o(277972);
      return;
    }
  }
  
  private static final void a(c paramc, View paramView)
  {
    AppMethodBeat.i(277966);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/RepairerSetValueDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramc, "this$0");
    paramView = paramc.OwB;
    if (paramView != null)
    {
      paramView = paramView.getText();
      if (paramView != null)
      {
        paramView = paramView.toString();
        if (paramView != null)
        {
          localObject = paramc.OwA;
          if (localObject != null) {
            ((a)localObject).aUk(paramView);
          }
        }
      }
    }
    paramc.dismiss();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/RepairerSetValueDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(277966);
  }
  
  private static final boolean a(c paramc, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(277948);
    s.u(paramc, "this$0");
    paramc.cancel();
    AppMethodBeat.o(277948);
    return true;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(277999);
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
      paramBundle.setWindowAnimations(b.g.BottomToTopSlowAnimation);
    }
    paramBundle = LayoutInflater.from(this.MHM).inflate(b.d.Owb, null, false);
    setContentView(paramBundle, new ViewGroup.LayoutParams(-1, -1));
    ((TextView)paramBundle.findViewById(b.c.title_tv)).setText((CharSequence)this.title);
    this.OwB = ((EditText)paramBundle.findViewById(b.c.value_et));
    this.nhC = ((Button)paramBundle.findViewById(b.c.ok_btn));
    Object localObject = this.OwB;
    if (localObject != null) {
      ((EditText)localObject).requestFocus();
    }
    localObject = this.Owz;
    if (localObject != null)
    {
      EditText localEditText = this.OwB;
      if (localEditText != null) {
        localEditText.setText((CharSequence)localObject);
      }
      localEditText = this.OwB;
      if (localEditText != null) {
        localEditText.setSelection(((String)localObject).length());
      }
    }
    paramBundle.findViewById(b.c.empty_area_view).setOnTouchListener(new c..ExternalSyntheticLambda2(this));
    setCancelable(true);
    paramBundle = (InputPanelLinearLayout)findViewById(b.c.input_container);
    if (paramBundle != null) {
      paramBundle.setExternalListener((c.a)this);
    }
    h.ahAA.o(new c..ExternalSyntheticLambda3(this), 128L);
    paramBundle = this.nhC;
    if (paramBundle != null) {
      paramBundle.setOnClickListener(new c..ExternalSyntheticLambda1(this));
    }
    setOnDismissListener(new c..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(277999);
  }
  
  public final void onInputPanelChange(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(278005);
    View localView;
    if (paramBoolean)
    {
      localView = findViewById(b.c.input_container);
      if (localView != null)
      {
        localView.setPadding(0, 0, 0, paramInt);
        AppMethodBeat.o(278005);
      }
    }
    else
    {
      localView = findViewById(b.c.input_container);
      if (localView != null) {
        localView.setPadding(0, 0, 0, 0);
      }
    }
    AppMethodBeat.o(278005);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.c
 * JD-Core Version:    0.7.0.1
 */