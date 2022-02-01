package com.tencent.mm.plugin.recordvideo.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.g.b.a.jq;
import com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar.a;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.b;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.c;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.d;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "layout", "Landroid/widget/RelativeLayout;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/RelativeLayout;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "captureHint", "Landroid/widget/TextView;", "enablePicture", "", "forceBringToFront", "getForceBringToFront", "()Z", "setForceBringToFront", "(Z)V", "hideHintRunnable", "Ljava/lang/Runnable;", "initMaxRecordTime", "", "getInitMaxRecordTime", "()I", "setInitMaxRecordTime", "(I)V", "isNeedCountdown", "isWaitForCountdown", "lastTakePictureTime", "", "getLayout", "()Landroid/widget/RelativeLayout;", "setLayout", "(Landroid/widget/RelativeLayout;)V", "maxRecordTimeMS", "getMaxRecordTimeMS", "setMaxRecordTimeMS", "permissionJumper", "Landroid/view/View;", "progressChangeCallBack", "Lkotlin/Function1;", "Ljava/util/ArrayList;", "", "Lkotlin/ParameterName;", "name", "subProgress", "", "getProgressChangeCallBack", "()Lkotlin/jvm/functions/Function1;", "setProgressChangeCallBack", "(Lkotlin/jvm/functions/Function1;)V", "recordButton", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightRecordButton;", "recordColor", "recordHintRes", "getRecordHintRes", "setRecordHintRes", "recordHintTips", "", "getRecordHintTips", "()Ljava/lang/String;", "setRecordHintTips", "(Ljava/lang/String;)V", "showJumperRunnable", "Ljava/util/concurrent/Future;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "takePictureMinInterval", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "changeRecordDuration", "time", "dismissPermissionHint", "enable", "getSubProgress", "", "hideHint", "initConfig", "config", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "needCountdown", "need", "onAttach", "onDetach", "onPause", "prepareDelete", "delete", "recordFinish", "finish", "recordTimeNotEnough", "removeCurrentProgress", "verify", "removeSelectProgress", "index", "reset", "restoreRecordDuration", "setEnableSubProgress", "isFullscreenMode", "setEnableType", "setHint", "wording", "setHintRes", "res", "setNormalVideoHint", "setSubVideoHint", "setVisibility", "visibility", "showHint", "strRes", "autoHide", "strWording", "showPermissionAfterHint", "clickListener", "Landroid/view/View$OnClickListener;", "showRecordMaxTimeHint", "hitStr", "showRecordShortHint", "showRecordShotHintMusic", "minDuration", "showRecordStartMusicHint", "showRecordTipHint", "startRecord", "Companion", "plugin-recordvideo_release"})
public final class w
  implements t
{
  public static final w.a BRE;
  private Future<?> BRA;
  public boolean BRB;
  public int BRC;
  private String BRD;
  private final View BRr;
  public int BRs;
  public int BRt;
  private boolean BRu;
  private final int BRv;
  private long BRw;
  private boolean BRx;
  public boolean BRy;
  public kotlin.g.a.b<? super ArrayList<Float>, x> BRz;
  private int gLS;
  private final MMHandler hAk;
  public final TextView rsX;
  private final Runnable rtb;
  d wgr;
  private RelativeLayout yIR;
  public MMSightRecordButton zCQ;
  
  static
  {
    AppMethodBeat.i(237340);
    BRE = new w.a((byte)0);
    AppMethodBeat.o(237340);
  }
  
  public w(RelativeLayout paramRelativeLayout, d paramd)
  {
    AppMethodBeat.i(75629);
    this.yIR = paramRelativeLayout;
    this.wgr = paramd;
    paramRelativeLayout = this.yIR.findViewById(2131306699);
    p.g(paramRelativeLayout, "layout.findViewById(R.id.record_button)");
    this.zCQ = ((MMSightRecordButton)paramRelativeLayout);
    paramRelativeLayout = this.yIR.findViewById(2131298003);
    p.g(paramRelativeLayout, "layout.findViewById(R.id.capture_hint)");
    this.rsX = ((TextView)paramRelativeLayout);
    paramRelativeLayout = this.yIR.findViewById(2131298004);
    p.g(paramRelativeLayout, "layout.findViewById(R.id.capture_permission_jump)");
    this.BRr = paramRelativeLayout;
    this.hAk = new MMHandler(Looper.getMainLooper());
    this.BRs = 10000;
    this.BRt = this.BRs;
    this.BRv = 500;
    this.BRw = -1L;
    this.rtb = ((Runnable)new c(this));
    this.BRB = true;
    this.BRC = 2131764282;
    this.BRD = "";
    this.zCQ.setSimpleTapCallback((MMSightRecordButton.d)new MMSightRecordButton.d()
    {
      public final void cJK()
      {
        AppMethodBeat.i(75613);
        w.a(this.BRF);
        AppMethodBeat.o(75613);
      }
    });
    AppMethodBeat.o(75629);
  }
  
  private final void aL(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(237333);
    String str = this.yIR.getContext().getString(paramInt);
    p.g(str, "layout.context.getString(strRes)");
    bY(str, true);
    AppMethodBeat.o(237333);
  }
  
  private final void bY(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(237335);
    if (this.BRr.getVisibility() == 0)
    {
      AppMethodBeat.o(237335);
      return;
    }
    this.yIR.removeCallbacks(this.rtb);
    this.rsX.setText((CharSequence)paramString);
    this.rsX.setVisibility(0);
    this.rsX.animate().alpha(1.0F).start();
    if (paramBoolean) {
      this.yIR.postDelayed(this.rtb, 3000L);
    }
    AppMethodBeat.o(237335);
  }
  
  private final void c(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(237319);
    Boolean localBoolean = paramRecordConfigProvider.BOr;
    p.g(localBoolean, "config.enablePicture");
    this.BRu = localBoolean.booleanValue();
    localBoolean = paramRecordConfigProvider.BOr;
    p.g(localBoolean, "config.enablePicture");
    if (localBoolean.booleanValue())
    {
      this.rsX.setText(2131763065);
      this.zCQ.setSimpleTapCallback((MMSightRecordButton.d)new f(this));
    }
    localBoolean = paramRecordConfigProvider.BOs;
    p.g(localBoolean, "config.enableVideo");
    if (localBoolean.booleanValue())
    {
      this.rsX.setText(2131763066);
      this.zCQ.setLongPressCallback((MMSightRecordButton.b)new g(this));
      this.zCQ.setLongPressScrollCallback((MMSightRecordButton.c)new h(this));
    }
    localBoolean = paramRecordConfigProvider.BOr;
    p.g(localBoolean, "config.enablePicture");
    if (localBoolean.booleanValue())
    {
      paramRecordConfigProvider = paramRecordConfigProvider.BOs;
      p.g(paramRecordConfigProvider, "config.enableVideo");
      if (paramRecordConfigProvider.booleanValue()) {
        this.rsX.setText(2131763064);
      }
    }
    AppMethodBeat.o(237319);
  }
  
  private void eKE()
  {
    AppMethodBeat.i(237322);
    this.rsX.setText(2131764315);
    AppMethodBeat.o(237322);
  }
  
  private void eKF()
  {
    AppMethodBeat.i(237323);
    this.rsX.setText(2131763064);
    AppMethodBeat.o(237323);
  }
  
  private final void te(boolean paramBoolean)
  {
    AppMethodBeat.i(237337);
    this.zCQ.setTouchEnable(false);
    this.hAk.postDelayed((Runnable)new d(this), 1500L);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("PARAM_1_BOOLEAN", paramBoolean);
    this.wgr.a(d.c.BUw, localBundle);
    AppMethodBeat.o(237337);
  }
  
  public final void QS(int paramInt)
  {
    AppMethodBeat.i(237328);
    this.zCQ.QS(paramInt);
    AppMethodBeat.o(237328);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(237321);
    p.h(paramRecordConfigProvider, "config");
    this.BRt = paramRecordConfigProvider.BOv;
    this.BRs = (paramRecordConfigProvider.BOv + 250);
    UICustomParam localUICustomParam = paramRecordConfigProvider.BOn;
    if (localUICustomParam != null) {}
    for (int i = localUICustomParam.gLS;; i = 0)
    {
      this.gLS = i;
      c(paramRecordConfigProvider);
      AppMethodBeat.o(237321);
      return;
    }
  }
  
  public final void aSs()
  {
    AppMethodBeat.i(75627);
    this.yIR.setVisibility(0);
    AppMethodBeat.o(75627);
  }
  
  public final void ae(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(237327);
    this.zCQ.rk(paramBoolean1);
    if (paramBoolean1) {
      eKE();
    }
    for (;;)
    {
      if ((paramBoolean1) && (paramBoolean2)) {
        this.zCQ.ekG();
      }
      AppMethodBeat.o(237327);
      return;
      eKF();
    }
  }
  
  public final void bFT()
  {
    AppMethodBeat.i(237320);
    if (!this.BRx)
    {
      AppMethodBeat.o(237320);
      return;
    }
    this.BRx = false;
    d.b.a(this.wgr, d.c.BUv);
    Context localContext;
    if (this.gLS == 0)
    {
      localContext = this.yIR.getContext();
      p.g(localContext, "layout.context");
    }
    for (int i = localContext.getResources().getColor(2131101414);; i = this.gLS)
    {
      this.zCQ.a(this.BRs, i, (MMSightCircularProgressBar.a)new k(this));
      AppMethodBeat.o(237320);
      return;
    }
  }
  
  public final void c(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(237324);
    p.h(paramOnClickListener, "clickListener");
    if (this.rsX.getVisibility() == 0)
    {
      Future localFuture = this.BRA;
      if (localFuture != null) {
        localFuture.cancel(true);
      }
      this.BRA = ((Future)h.RTc.n((Runnable)new i(this), 2000L));
    }
    for (;;)
    {
      this.BRr.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(237324);
      return;
      this.BRr.setVisibility(0);
    }
  }
  
  public final void eKG()
  {
    AppMethodBeat.i(237325);
    Future localFuture = this.BRA;
    if (localFuture != null) {
      localFuture.cancel(true);
    }
    this.BRr.setVisibility(4);
    AppMethodBeat.o(237325);
  }
  
  public final void eKH()
  {
    AppMethodBeat.i(237326);
    if (this.BRu)
    {
      d.b.a(this.wgr, d.c.BUD);
      AppMethodBeat.o(237326);
      return;
    }
    b(this);
    AppMethodBeat.o(237326);
  }
  
  public final void eKI()
  {
    AppMethodBeat.i(237331);
    if (((CharSequence)this.BRD).length() > 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      bY(this.BRD, true);
      AppMethodBeat.o(237331);
      return;
    }
    aL(this.BRC, true);
    AppMethodBeat.o(237331);
  }
  
  public final List<Float> getSubProgress()
  {
    AppMethodBeat.i(237329);
    List localList = this.zCQ.getSubProgress();
    p.g(localList, "recordButton.subProgress");
    AppMethodBeat.o(237329);
    return localList;
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    return false;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(75628);
    this.yIR.setVisibility(4);
    AppMethodBeat.o(75628);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(237336);
    this.zCQ.stopRecord();
    AppMethodBeat.o(237336);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(237341);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(237341);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset()
  {
    AppMethodBeat.i(75626);
    this.zCQ.ekF();
    this.zCQ.setTouchEnable(true);
    this.hAk.removeCallbacksAndMessages(null);
    if (!com.tencent.mm.pluginsdk.permission.b.e(this.zCQ.getContext(), new String[] { "android.permission.RECORD_AUDIO" })) {
      c((View.OnClickListener)new e(this));
    }
    AppMethodBeat.o(75626);
  }
  
  public final void rl(boolean paramBoolean)
  {
    AppMethodBeat.i(237330);
    this.zCQ.rl(paramBoolean);
    AppMethodBeat.o(237330);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(237339);
    this.zCQ.setVisibility(paramInt);
    if (this.BRB) {
      this.yIR.bringToFront();
    }
    AppMethodBeat.o(237339);
  }
  
  public final void td(boolean paramBoolean)
  {
    AppMethodBeat.i(237318);
    this.BRu = paramBoolean;
    if (this.BRu)
    {
      this.rsX.setText(2131763065);
      this.zCQ.setSimpleTapCallback((MMSightRecordButton.d)new b(this));
      AppMethodBeat.o(237318);
      return;
    }
    this.rsX.setText(2131763066);
    this.zCQ.setSimpleTapCallback(null);
    AppMethodBeat.o(237318);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onSimpleTap"})
  static final class b
    implements MMSightRecordButton.d
  {
    b(w paramw) {}
    
    public final void cJK()
    {
      AppMethodBeat.i(237304);
      if ((w.d(this.BRF) == -1L) || (Util.ticksToNow(w.d(this.BRF)) > w.e(this.BRF)))
      {
        Log.i("MicroMsg.MMRecordUI", "onSimpleTap %s", new Object[] { Util.getStack().toString() });
        d.b.a(this.BRF.wgr, d.c.BUD);
        w.a(this.BRF, Util.currentTicks());
        AppMethodBeat.o(237304);
        return;
      }
      Log.i("MicroMsg.MMRecordUI", "onSimpleTap too often! %s", new Object[] { Util.getStack().toString() });
      AppMethodBeat.o(237304);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(w paramw) {}
    
    public final void run()
    {
      AppMethodBeat.i(75615);
      w.i(this.BRF).animate().alpha(0.0F).withEndAction((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(75614);
          w.i(this.BRG.BRF).setVisibility(4);
          AppMethodBeat.o(75614);
        }
      }).start();
      AppMethodBeat.o(75615);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(w paramw) {}
    
    public final void run()
    {
      AppMethodBeat.i(75616);
      w.h(this.BRF).showLoading();
      AppMethodBeat.o(75616);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(w paramw) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(237305);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin$reset$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = w.h(this.BRF).getContext();
      if (paramView == null)
      {
        paramView = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(237305);
        throw paramView;
      }
      paramView = (Activity)paramView;
      localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin$reset$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin$reset$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin$reset$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(237305);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onSimpleTap"})
  static final class f
    implements MMSightRecordButton.d
  {
    f(w paramw) {}
    
    public final void cJK()
    {
      AppMethodBeat.i(237306);
      if ((w.d(this.BRF) == -1L) || (Util.ticksToNow(w.d(this.BRF)) > w.e(this.BRF)))
      {
        Log.i("MicroMsg.MMRecordUI", "onSimpleTap %s", new Object[] { Util.getStack().toString() });
        d.b.a(this.BRF.wgr, d.c.BUD);
        w.a(this.BRF, Util.currentTicks());
        AppMethodBeat.o(237306);
        return;
      }
      Log.i("MicroMsg.MMRecordUI", "onSimpleTap too often! %s", new Object[] { Util.getStack().toString() });
      AppMethodBeat.o(237306);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin$setEnableType$2", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightRecordButton$LongPressCallback;", "onLongPress", "", "onLongPressFinish", "onPressDown", "plugin-recordvideo_release"})
  public static final class g
    implements MMSightRecordButton.b
  {
    public final void cJI()
    {
      AppMethodBeat.i(237310);
      Log.i("MicroMsg.RecordButtonPlugin", "onLongPressFinish");
      if (w.j(this.BRF))
      {
        w.a(this.BRF, false);
        d.b.a(this.BRF.wgr, d.c.BUO);
        AppMethodBeat.o(237310);
        return;
      }
      w.c(this.BRF);
      AppMethodBeat.o(237310);
    }
    
    public final void cJJ()
    {
      AppMethodBeat.i(237308);
      Object localObject = w.f(this.BRF);
      if (localObject != null) {
        ((Future)localObject).cancel(true);
      }
      w.g(this.BRF).setVisibility(4);
      localObject = new int[2];
      w.h(this.BRF).getLocationOnScreen((int[])localObject);
      Bundle localBundle = new Bundle();
      localBundle.putInt("PARAM_PREPARE_CAMERA_ZOOM_LOCATION_INT", localObject[1]);
      this.BRF.wgr.a(d.c.BUr, localBundle);
      w.i(this.BRF).animate().alpha(0.0F).withEndAction((Runnable)new a(this)).start();
      localObject = c.BXI;
      c.VI(2);
      localObject = c.BXI;
      c.VH(2);
      localObject = c.BXI;
      c.eKY().ahL();
      AppMethodBeat.o(237308);
    }
    
    public final void jK()
    {
      AppMethodBeat.i(237309);
      w.a(this.BRF, true);
      if ((w.k(this.BRF)) && (w.h(this.BRF).ekI()))
      {
        d.b.a(this.BRF.wgr, d.c.BUN);
        AppMethodBeat.o(237309);
        return;
      }
      this.BRF.bFT();
      AppMethodBeat.o(237309);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(w.g paramg) {}
      
      public final void run()
      {
        AppMethodBeat.i(237307);
        w.i(this.BRH.BRF).setVisibility(4);
        AppMethodBeat.o(237307);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin$setEnableType$3", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightRecordButton$LongPressScrollCallback;", "onScrollDown", "", "factor", "", "onScrollUp", "plugin-recordvideo_release"})
  public static final class h
    implements MMSightRecordButton.c
  {
    public final void Gt(int paramInt)
    {
      AppMethodBeat.i(237311);
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_BOOLEAN", true);
      localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_SCROLL_BOOLEAN", true);
      localBundle.putInt("PARAM_PREPARE_CAMERA_ZOOM_FACTOR_INT", paramInt);
      this.BRF.wgr.a(d.c.BUs, localBundle);
      AppMethodBeat.o(237311);
    }
    
    public final void Gu(int paramInt)
    {
      AppMethodBeat.i(237312);
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_BOOLEAN", false);
      localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_SCROLL_BOOLEAN", true);
      localBundle.putInt("PARAM_PREPARE_CAMERA_ZOOM_FACTOR_INT", paramInt);
      this.BRF.wgr.a(d.c.BUs, localBundle);
      AppMethodBeat.o(237312);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(w paramw) {}
    
    public final void run()
    {
      AppMethodBeat.i(237313);
      w.i(this.BRF).setVisibility(4);
      w.g(this.BRF).setVisibility(0);
      AppMethodBeat.o(237313);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin$startRecord$1", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightCircularProgressBar$ProgressCallback;", "onProgress", "", "subProgress", "Ljava/util/ArrayList;", "", "onProgressFinish", "finish", "", "plugin-recordvideo_release"})
  public static final class k
    implements MMSightCircularProgressBar.a
  {
    public final void Z(ArrayList<Float> paramArrayList)
    {
      AppMethodBeat.i(237316);
      p.h(paramArrayList, "subProgress");
      kotlin.g.a.b localb = this.BRF.BRz;
      if (localb != null)
      {
        localb.invoke(paramArrayList);
        AppMethodBeat.o(237316);
        return;
      }
      AppMethodBeat.o(237316);
    }
    
    public final void lK(boolean paramBoolean)
    {
      AppMethodBeat.i(237317);
      Log.i("MicroMsg.RecordButtonPlugin", "onProgressFinish");
      w.b(this.BRF, paramBoolean);
      AppMethodBeat.o(237317);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.w
 * JD-Core Version:    0.7.0.1
 */