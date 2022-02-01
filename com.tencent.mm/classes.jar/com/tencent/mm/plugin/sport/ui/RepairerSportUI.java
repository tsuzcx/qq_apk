package com.tencent.mm.plugin.sport.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.gw;
import com.tencent.mm.autogen.a.gw.b;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sport.b.b;
import com.tencent.mm.plugin.sport.b.c;
import com.tencent.mm.plugin.sport.b.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.co;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sport/ui/RepairerSportUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-sport_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RepairerSportUI
  extends MMActivity
{
  private final String TAG = "MicroMsg.Repairer.RepairerSportUI";
  
  private static final void a(RepairerSportUI paramRepairerSportUI, View paramView)
  {
    AppMethodBeat.i(263956);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramRepairerSportUI);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/sport/ui/RepairerSportUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRepairerSportUI, "this$0");
    paramView = n.bJF(((MMEditText)paramRepairerSportUI.findViewById(b.b.value_et)).getText().toString());
    if (paramView == null) {}
    for (int i = 1;; i = paramView.intValue())
    {
      paramView = Calendar.getInstance();
      paramView.set(11, 0);
      paramView.set(12, 0);
      paramView.set(13, 0);
      long l1 = paramView.getTimeInMillis();
      long l2 = System.currentTimeMillis();
      ((com.tencent.mm.plugin.sport.a.b)h.ax(com.tencent.mm.plugin.sport.a.b.class)).b("", "gh_43f2581f6fd6", (int)(l1 / 1000L), (int)(l2 / 1000L), i, co.jcP());
      Toast.makeText((Context)paramRepairerSportUI, b.e.app_modify_success, 0).show();
      a.a(new Object(), "com/tencent/mm/plugin/sport/ui/RepairerSportUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(263956);
      return;
    }
  }
  
  private static final boolean a(RepairerSportUI paramRepairerSportUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(263953);
    s.u(paramRepairerSportUI, "this$0");
    paramRepairerSportUI.finish();
    AppMethodBeat.o(263953);
    return false;
  }
  
  private static final void b(RepairerSportUI paramRepairerSportUI, View paramView)
  {
    AppMethodBeat.i(263962);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramRepairerSportUI);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/sport/ui/RepairerSportUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRepairerSportUI, "this$0");
    paramView = new Intent();
    paramView.putExtra("rawUrl", "https://fm.m.tencent.com/an:mhr/sports/");
    c.b((Context)paramRepairerSportUI, "webview", ".ui.tools.WebviewMpUI", paramView);
    a.a(new Object(), "com/tencent/mm/plugin/sport/ui/RepairerSportUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(263962);
  }
  
  private static final void c(RepairerSportUI paramRepairerSportUI, View paramView)
  {
    AppMethodBeat.i(263970);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramRepairerSportUI);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/sport/ui/RepairerSportUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRepairerSportUI, "this$0");
    paramView = new gw();
    paramView.hHt.action = 3;
    paramView.publish();
    Log.i(paramRepairerSportUI.TAG, "getconfig:  " + paramView.hHu.hHy + ' ' + paramView.hHu.config);
    a.a(new Object(), "com/tencent/mm/plugin/sport/ui/RepairerSportUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(263970);
  }
  
  private static final void d(RepairerSportUI paramRepairerSportUI, View paramView)
  {
    AppMethodBeat.i(263976);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramRepairerSportUI);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/sport/ui/RepairerSportUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRepairerSportUI, "this$0");
    paramView = new gw();
    paramView.hHt.action = 2;
    paramView.publish();
    Log.i(paramRepairerSportUI.TAG, "getconfig:  " + paramView.hHu.hHy + ' ' + paramView.hHu.config);
    a.a(new Object(), "com/tencent/mm/plugin/sport/ui/RepairerSportUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(263976);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return b.c.sport_reset_step_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(264010);
    super.onCreate(paramBundle);
    setMMTitle(b.e.exdevice_wechat_sport);
    setBackBtn(new RepairerSportUI..ExternalSyntheticLambda0(this));
    findViewById(b.b.ok_btn).setOnClickListener(new RepairerSportUI..ExternalSyntheticLambda1(this));
    findViewById(b.b.open_btn).setOnClickListener(new RepairerSportUI..ExternalSyntheticLambda2(this));
    findViewById(b.b.get_sport_config_btn).setOnClickListener(new RepairerSportUI..ExternalSyntheticLambda4(this));
    findViewById(b.b.get_sport_config_btn).setOnClickListener(new RepairerSportUI..ExternalSyntheticLambda3(this));
    AppMethodBeat.o(264010);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.ui.RepairerSportUI
 * JD-Core Version:    0.7.0.1
 */