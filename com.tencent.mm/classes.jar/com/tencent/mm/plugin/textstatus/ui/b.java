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
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/ui/MMCardDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "layoutCustom", "Landroid/widget/LinearLayout;", "viewBack", "Landroid/view/View;", "getLayoutCustom", "initUI", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "setCustomView", "customView", "plugin-textstatus_release"})
public class b
  extends Dialog
{
  LinearLayout GcD;
  
  public b(Context paramContext)
  {
    super(paramContext, 2131821025);
    AppMethodBeat.i(216365);
    AppMethodBeat.o(216365);
  }
  
  protected void initUI()
  {
    AppMethodBeat.i(216364);
    Window localWindow = getWindow();
    if (localWindow != null) {
      localWindow.setWindowAnimations(2131821529);
    }
    setContentView(LayoutInflater.from(getContext()).inflate(2131493361, null, false));
    this.GcD = ((LinearLayout)findViewById(2131303087));
    findViewById(2131299644).setOnClickListener((View.OnClickListener)new a(this));
    AppMethodBeat.o(216364);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(216362);
    super.onCreate(paramBundle);
    initUI();
    AppMethodBeat.o(216362);
  }
  
  protected void onStart()
  {
    AppMethodBeat.i(216363);
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
      AppMethodBeat.o(216363);
      return;
    }
    AppMethodBeat.o(216363);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(216361);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      a.b("com/tencent/mm/plugin/textstatus/ui/MMCardDialog$initUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.GcE.dismiss();
      a.a(this, "com/tencent/mm/plugin/textstatus/ui/MMCardDialog$initUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(216361);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.b
 * JD-Core Version:    0.7.0.1
 */