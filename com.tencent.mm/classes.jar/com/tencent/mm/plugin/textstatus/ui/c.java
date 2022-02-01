package com.tencent.mm.plugin.textstatus.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.textstatus.b.e;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.b.i;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/ui/MMCardDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "layoutCustom", "Landroid/widget/LinearLayout;", "viewBack", "Landroid/view/View;", "getLayoutCustom", "initUI", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "setCustomView", "customView", "show", "plugin-textstatus_release"})
public class c
  extends Dialog
{
  private LinearLayout MJv;
  
  public c(Context paramContext)
  {
    super(paramContext, b.i.Mzm);
    AppMethodBeat.i(232099);
    AppMethodBeat.o(232099);
  }
  
  public final LinearLayout gmu()
  {
    return this.MJv;
  }
  
  protected void initUI()
  {
    AppMethodBeat.i(232094);
    Object localObject = getWindow();
    if (localObject != null) {
      ((Window)localObject).setWindowAnimations(b.i.Mzn);
    }
    localObject = LayoutInflater.from(getContext()).inflate(b.f.MxB, null, false);
    setContentView((View)localObject);
    if ((localObject instanceof RelativeLayout)) {
      ((RelativeLayout)localObject).addView((View)new a(this, getContext()));
    }
    this.MJv = ((LinearLayout)findViewById(b.e.MvP));
    findViewById(b.e.dialog_container).setOnClickListener((View.OnClickListener)new b(this));
    AppMethodBeat.o(232094);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(232092);
    super.onCreate(paramBundle);
    initUI();
    AppMethodBeat.o(232092);
  }
  
  protected void onStart()
  {
    AppMethodBeat.i(232093);
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
      AppMethodBeat.o(232093);
      return;
    }
    AppMethodBeat.o(232093);
  }
  
  public final void setCustomView(View paramView)
  {
    AppMethodBeat.i(232095);
    p.k(paramView, "customView");
    LinearLayout localLinearLayout = this.MJv;
    if (localLinearLayout != null)
    {
      localLinearLayout.addView(paramView, -1, -2);
      AppMethodBeat.o(232095);
      return;
    }
    AppMethodBeat.o(232095);
  }
  
  public void show()
  {
    AppMethodBeat.i(232098);
    if (Build.VERSION.SDK_INT >= 21)
    {
      Window localWindow = getWindow();
      if (localWindow != null) {
        localWindow.addFlags(-2147483648);
      }
    }
    super.show();
    AppMethodBeat.o(232098);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/textstatus/ui/MMCardDialog$initUI$1", "Landroid/view/View;", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "plugin-textstatus_release"})
  public static final class a
    extends View
  {
    a(Context paramContext)
    {
      super();
    }
    
    protected final void onConfigurationChanged(Configuration paramConfiguration)
    {
      AppMethodBeat.i(233677);
      super.onConfigurationChanged(paramConfiguration);
      this.MJw.dismiss();
      AppMethodBeat.o(233677);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(c paramc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(234609);
      b localb = new b();
      localb.bn(paramView);
      a.c("com/tencent/mm/plugin/textstatus/ui/MMCardDialog$initUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.MJw.dismiss();
      a.a(this, "com/tencent/mm/plugin/textstatus/ui/MMCardDialog$initUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(234609);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.c
 * JD-Core Version:    0.7.0.1
 */