package com.tencent.mm.plugin.textstatus.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/ui/MMImmerseDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "layoutCustom", "Landroid/widget/LinearLayout;", "viewBack", "Landroid/view/View;", "initUI", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "setCustomView", "customView", "plugin-textstatus_release"})
public class c
  extends Dialog
{
  LinearLayout GcD;
  
  public c(Context paramContext)
  {
    super(paramContext, 2131820869);
    AppMethodBeat.i(216370);
    AppMethodBeat.o(216370);
  }
  
  protected void initUI()
  {
    AppMethodBeat.i(216369);
    View localView = LayoutInflater.from(getContext()).inflate(2131495071, null, false);
    setContentView(localView);
    Window localWindow = getWindow();
    if (localWindow != null) {
      localWindow.setNavigationBarColor(0);
    }
    localWindow = getWindow();
    if (localWindow != null) {
      localWindow.setType(1000);
    }
    localView.findViewById(2131299644).setOnClickListener((View.OnClickListener)new a(this));
    this.GcD = ((LinearLayout)findViewById(2131303087));
    AppMethodBeat.o(216369);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(216367);
    super.onCreate(paramBundle);
    initUI();
    AppMethodBeat.o(216367);
  }
  
  protected void onStart()
  {
    AppMethodBeat.i(216368);
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
    if (localWindow != null)
    {
      localWindow.setLayout(-1, -1);
      AppMethodBeat.o(216368);
      return;
    }
    AppMethodBeat.o(216368);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(c paramc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(216366);
      b localb = new b();
      localb.bm(paramView);
      a.b("com/tencent/mm/plugin/textstatus/ui/MMImmerseDialog$initUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.GcF.dismiss();
      a.a(this, "com/tencent/mm/plugin/textstatus/ui/MMImmerseDialog$initUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(216366);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.c
 * JD-Core Version:    0.7.0.1
 */