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
import com.tencent.mm.plugin.textstatus.b.e;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.b.i;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/ui/MMImmerseDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "layoutCustom", "Landroid/widget/LinearLayout;", "viewBack", "Landroid/view/View;", "initUI", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "setCustomView", "customView", "plugin-textstatus_release"})
public class d
  extends Dialog
{
  private LinearLayout MJv;
  
  public d(Context paramContext)
  {
    super(paramContext, b.i.Mzl);
    AppMethodBeat.i(236248);
    AppMethodBeat.o(236248);
  }
  
  protected void initUI()
  {
    AppMethodBeat.i(236245);
    View localView = LayoutInflater.from(getContext()).inflate(b.f.MxC, null, false);
    setContentView(localView);
    Window localWindow = getWindow();
    if (localWindow != null) {
      localWindow.setNavigationBarColor(0);
    }
    localWindow = getWindow();
    if (localWindow != null) {
      localWindow.setType(1000);
    }
    localView.findViewById(b.e.dialog_container).setOnClickListener((View.OnClickListener)new d.a(this));
    this.MJv = ((LinearLayout)findViewById(b.e.MvP));
    AppMethodBeat.o(236245);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(236242);
    super.onCreate(paramBundle);
    initUI();
    AppMethodBeat.o(236242);
  }
  
  protected void onStart()
  {
    AppMethodBeat.i(236243);
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
      AppMethodBeat.o(236243);
      return;
    }
    AppMethodBeat.o(236243);
  }
  
  public final void setCustomView(View paramView)
  {
    AppMethodBeat.i(236246);
    p.k(paramView, "customView");
    LinearLayout localLinearLayout = this.MJv;
    if (localLinearLayout != null)
    {
      localLinearLayout.addView(paramView, -1, -2);
      AppMethodBeat.o(236246);
      return;
    }
    AppMethodBeat.o(236246);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.d
 * JD-Core Version:    0.7.0.1
 */