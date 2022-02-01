package com.tencent.mm.plugin.textstatus.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.textstatus.a.e;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.plugin.textstatus.a.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/ui/MMCardDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "layoutCustom", "Landroid/widget/LinearLayout;", "viewBack", "Landroid/view/View;", "dismissByCloseBtn", "", "dismissBySpace", "getLayoutCustom", "initUI", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "setCustomView", "customView", "show", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public class c
  extends Dialog
{
  private LinearLayout TvE;
  
  public c(Context paramContext)
  {
    super(paramContext, a.i.Thl);
    AppMethodBeat.i(291351);
    AppMethodBeat.o(291351);
  }
  
  private static final void a(c paramc, View paramView)
  {
    AppMethodBeat.i(291364);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramc);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/textstatus/ui/MMCardDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramc, "this$0");
    paramc.hIm();
    a.a(new Object(), "com/tencent/mm/plugin/textstatus/ui/MMCardDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(291364);
  }
  
  private static final void b(c paramc, View paramView)
  {
    AppMethodBeat.i(291369);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramc);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/textstatus/ui/MMCardDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramc, "this$0");
    paramc.hIn();
    a.a(new Object(), "com/tencent/mm/plugin/textstatus/ui/MMCardDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(291369);
  }
  
  protected void hIm()
  {
    AppMethodBeat.i(291407);
    dismiss();
    AppMethodBeat.o(291407);
  }
  
  protected void hIn()
  {
    AppMethodBeat.i(291415);
    dismiss();
    AppMethodBeat.o(291415);
  }
  
  public final LinearLayout hIo()
  {
    return this.TvE;
  }
  
  protected void initUI()
  {
    AppMethodBeat.i(291403);
    Object localObject = getWindow();
    if (localObject != null) {
      ((Window)localObject).setWindowAnimations(a.i.Thm);
    }
    localObject = LayoutInflater.from(getContext()).inflate(a.f.TeY, null, false);
    setContentView((View)localObject);
    if ((localObject instanceof RelativeLayout)) {
      ((RelativeLayout)localObject).addView((View)new a(this, getContext()));
    }
    this.TvE = ((LinearLayout)findViewById(a.e.layout_custom));
    findViewById(a.e.dialog_container).setOnClickListener(new c..ExternalSyntheticLambda0(this));
    findViewById(a.e.Tdc).setOnClickListener(new c..ExternalSyntheticLambda1(this));
    AppMethodBeat.o(291403);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(291390);
    super.onCreate(paramBundle);
    initUI();
    AppMethodBeat.o(291390);
  }
  
  protected void onStart()
  {
    AppMethodBeat.i(291398);
    super.onStart();
    Window localWindow = getWindow();
    if (localWindow != null) {
      localWindow.addFlags(67108864);
    }
    localWindow = getWindow();
    if (localWindow != null) {
      localWindow.setDimAmount(0.5F);
    }
    localWindow = getWindow();
    if (localWindow != null) {
      localWindow.setLayout(-1, -1);
    }
    AppMethodBeat.o(291398);
  }
  
  public final void setCustomView(View paramView)
  {
    AppMethodBeat.i(291425);
    s.u(paramView, "customView");
    LinearLayout localLinearLayout = this.TvE;
    if (localLinearLayout != null) {
      localLinearLayout.addView(paramView, -1, -2);
    }
    AppMethodBeat.o(291425);
  }
  
  public void show()
  {
    AppMethodBeat.i(291442);
    if (Build.VERSION.SDK_INT >= 21)
    {
      Window localWindow = getWindow();
      if (localWindow != null) {
        localWindow.addFlags(-2147483648);
      }
    }
    super.show();
    AppMethodBeat.o(291442);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/ui/MMCardDialog$initUI$1", "Landroid/view/View;", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends View
  {
    a(c paramc, Context paramContext)
    {
      super();
    }
    
    protected final void onConfigurationChanged(Configuration paramConfiguration)
    {
      AppMethodBeat.i(291775);
      super.onConfigurationChanged(paramConfiguration);
      this.TvF.dismiss();
      AppMethodBeat.o(291775);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.c
 * JD-Core Version:    0.7.0.1
 */