package com.tencent.mm.plugin.repairer.ui.demo;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.repairer.ui.BaseRepairerUI;
import com.tencent.mm.plugin.repairer.ui.b.c;
import com.tencent.mm.plugin.repairer.ui.b.d;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/demo/RepairerSeparationControllerUI;", "Lcom/tencent/mm/plugin/repairer/ui/BaseRepairerUI;", "()V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDefaultClick", "v", "Landroid/view/View;", "onMainlandClick", "onOverseaClick", "Companion", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RepairerSeparationControllerUI
  extends BaseRepairerUI
{
  public static final RepairerSeparationControllerUI.a Oxz;
  
  static
  {
    AppMethodBeat.i(278580);
    Oxz = new RepairerSeparationControllerUI.a((byte)0);
    AppMethodBeat.o(278580);
  }
  
  private static final boolean a(RepairerSeparationControllerUI paramRepairerSeparationControllerUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(278571);
    s.u(paramRepairerSeparationControllerUI, "this$0");
    paramRepairerSeparationControllerUI.finish();
    AppMethodBeat.o(278571);
    return true;
  }
  
  public final int getLayoutId()
  {
    return b.d.OvR;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(278604);
    super.onCreate(paramBundle);
    setBackBtn(new RepairerSeparationControllerUI..ExternalSyntheticLambda0(this));
    TextView localTextView = (TextView)findViewById(b.c.OuT);
    if (MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).decodeInt("repairer_separation_use_default_agreement", 1) == 1) {
      paramBundle = (CharSequence)"主体：未进行特殊设置";
    }
    for (;;)
    {
      localTextView.setText(paramBundle);
      AppMethodBeat.o(278604);
      return;
      if (MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).decodeInt("repairer_separation_agreement", -1) == 1) {
        paramBundle = (CharSequence)"主体：海外用户";
      } else if (MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).decodeInt("repairer_separation_agreement", -1) == 0) {
        paramBundle = (CharSequence)"主体：大陆用户";
      } else {
        paramBundle = (CharSequence)"主体：无法识别？联系nalecyxu";
      }
    }
  }
  
  public final void onDefaultClick(View paramView)
  {
    AppMethodBeat.i(278626);
    s.u(paramView, "v");
    h.jXD();
    MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).encode("repairer_separation_use_default_agreement", 1);
    Toast.makeText((Context)this, (CharSequence)"已清除设置，请重启", 0).show();
    AppMethodBeat.o(278626);
  }
  
  public final void onMainlandClick(View paramView)
  {
    AppMethodBeat.i(278620);
    s.u(paramView, "v");
    h.jXD();
    MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).encode("repairer_separation_use_default_agreement", 0);
    MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).encode("repairer_separation_agreement", 0);
    Toast.makeText((Context)this, (CharSequence)"切换大陆主体，请重启", 0).show();
    AppMethodBeat.o(278620);
  }
  
  public final void onOverseaClick(View paramView)
  {
    AppMethodBeat.i(278614);
    s.u(paramView, "v");
    h.jXD();
    MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).encode("repairer_separation_use_default_agreement", 0);
    MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).encode("repairer_separation_agreement", 1);
    Toast.makeText((Context)this, (CharSequence)"切换海外主体，请重启", 0).show();
    AppMethodBeat.o(278614);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.RepairerSeparationControllerUI
 * JD-Core Version:    0.7.0.1
 */