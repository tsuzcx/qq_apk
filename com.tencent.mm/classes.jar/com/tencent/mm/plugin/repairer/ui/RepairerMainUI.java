package com.tencent.mm.plugin.repairer.ui;

import android.app.Activity;
import android.os.Bundle;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.service.FloatBallHelper;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.statecenter.UIStateCenter;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/RepairerMainUI;", "Lcom/tencent/mm/plugin/repairer/ui/BaseRepairerPrefUI;", "()V", "floatBallHelper", "Lcom/tencent/mm/plugin/repairer/ui/floatball/RepairerFloatBallHelper;", "getFloatBallHelper", "()Lcom/tencent/mm/plugin/repairer/ui/floatball/RepairerFloatBallHelper;", "floatBallHelper$delegate", "Lkotlin/Lazy;", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "Companion", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RepairerMainUI
  extends BaseRepairerPrefUI
{
  public static final a Owo;
  private static final HashSet<Activity> Owq;
  private final j Owp;
  
  static
  {
    AppMethodBeat.i(277919);
    Owo = new a((byte)0);
    Owq = new HashSet();
    AppMethodBeat.o(277919);
  }
  
  public RepairerMainUI()
  {
    AppMethodBeat.i(277890);
    this.Owp = k.cm((kotlin.g.a.a)new RepairerMainUI.b(this));
    AppMethodBeat.o(277890);
  }
  
  private static final void a(RepairerMainUI paramRepairerMainUI)
  {
    AppMethodBeat.i(277909);
    s.u(paramRepairerMainUI, "this$0");
    paramRepairerMainUI.gNd().B(true, 2);
    AppMethodBeat.o(277909);
  }
  
  private com.tencent.mm.plugin.repairer.ui.b.a gNd()
  {
    AppMethodBeat.i(277900);
    com.tencent.mm.plugin.repairer.ui.b.a locala = (com.tencent.mm.plugin.repairer.ui.b.a)this.Owp.getValue();
    AppMethodBeat.o(277900);
    return locala;
  }
  
  private static final void gNe() {}
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(277964);
    if (!gNd().zX(2)) {
      finish();
    }
    AppMethodBeat.o(277964);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(277938);
    super.onCreate(paramBundle);
    if ((CrashReportFactory.hasDebuger()) && (CrashReportFactory.isMonkeyEnv())) {
      Owq.add(this);
    }
    paramBundle = getStateCenter();
    if (paramBundle != null) {
      paramBundle.process((q)this, (kotlin.g.a.b)c.Ows);
    }
    setTitleBarClickListener(new RepairerMainUI..ExternalSyntheticLambda0(this), RepairerMainUI..ExternalSyntheticLambda1.INSTANCE);
    gNd().J(25, "Repairer");
    gNd().ahU("微信维修厂");
    AppMethodBeat.o(277938);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(277960);
    super.onDestroy();
    gNd().onDestroy();
    AppMethodBeat.o(277960);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(277951);
    super.onPause();
    gNd().bhW();
    AppMethodBeat.o(277951);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(277943);
    super.onResume();
    gNd().coi();
    AppMethodBeat.o(277943);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/RepairerMainUI$Companion;", "", "()V", "sUILeaksRoutineEnsuranceRef", "Ljava/util/HashSet;", "Landroid/app/Activity;", "getSUILeaksRoutineEnsuranceRef$annotations", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "state", "Lcom/tencent/mm/plugin/repairer/ui/state/RepairerState;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<com.tencent.mm.plugin.repairer.ui.d.b, ah>
  {
    public static final c Ows;
    
    static
    {
      AppMethodBeat.i(277928);
      Ows = new c();
      AppMethodBeat.o(277928);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.RepairerMainUI
 * JD-Core Version:    0.7.0.1
 */