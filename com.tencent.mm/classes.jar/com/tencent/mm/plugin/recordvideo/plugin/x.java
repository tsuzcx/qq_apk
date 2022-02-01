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
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.f.b.a.lz;
import com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar.a;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.b;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.c;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.d;
import com.tencent.mm.plugin.recordvideo.b.b;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.h;
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
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "layout", "Landroid/widget/RelativeLayout;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/RelativeLayout;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "captureHint", "Landroid/widget/TextView;", "enablePicture", "", "forceBringToFront", "getForceBringToFront", "()Z", "setForceBringToFront", "(Z)V", "hideHintRunnable", "Ljava/lang/Runnable;", "initMaxRecordTime", "", "getInitMaxRecordTime", "()I", "setInitMaxRecordTime", "(I)V", "isNeedCountdown", "isWaitForCountdown", "lastTakePictureTime", "", "getLayout", "()Landroid/widget/RelativeLayout;", "setLayout", "(Landroid/widget/RelativeLayout;)V", "maxRecordTimeMS", "getMaxRecordTimeMS", "setMaxRecordTimeMS", "normalVideoHint", "permissionJumper", "Landroid/view/View;", "progressChangeCallBack", "Lkotlin/Function1;", "Ljava/util/ArrayList;", "", "Lkotlin/ParameterName;", "name", "subProgress", "", "getProgressChangeCallBack", "()Lkotlin/jvm/functions/Function1;", "setProgressChangeCallBack", "(Lkotlin/jvm/functions/Function1;)V", "recordButton", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightRecordButton;", "recordColor", "recordHintRes", "getRecordHintRes", "setRecordHintRes", "recordHintTips", "", "getRecordHintTips", "()Ljava/lang/String;", "setRecordHintTips", "(Ljava/lang/String;)V", "showJumperRunnable", "Ljava/util/concurrent/Future;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "takePictureMinInterval", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "changeRecordDuration", "time", "dismissPermissionHint", "enable", "getSubProgress", "", "hideHint", "initConfig", "config", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "needCountdown", "need", "onAttach", "onDetach", "onPause", "prepareDelete", "delete", "recordFinish", "finish", "recordTimeNotEnough", "removeCurrentProgress", "verify", "removeSelectProgress", "index", "reset", "restoreRecordDuration", "setEnableSubProgress", "isFullscreenMode", "setEnableType", "setHint", "wording", "setHintRes", "res", "setNormalVideoHint", "setSubVideoHint", "setVisibility", "visibility", "showHint", "strRes", "autoHide", "strWording", "showPermissionAfterHint", "clickListener", "Landroid/view/View$OnClickListener;", "showRecordMaxTimeHint", "hitStr", "showRecordShortHint", "showRecordShotHintMusic", "minDuration", "showRecordStartMusicHint", "showRecordTipHint", "startRecord", "Companion", "plugin-recordvideo_release"})
public final class x
  implements u
{
  public static final a HOt;
  d APl;
  public RelativeLayout EmK;
  public MMSightRecordButton FhM;
  private final View HOf;
  public int HOg;
  public int HOh;
  private boolean HOi;
  private final int HOj;
  private long HOk;
  private boolean HOl;
  private boolean HOm;
  private int HOn;
  public kotlin.g.a.b<? super ArrayList<Float>, kotlin.x> HOo;
  private Future<?> HOp;
  public boolean HOq;
  public int HOr;
  private String HOs;
  private int jwh;
  private final MMHandler knk;
  public final TextView uYC;
  private final Runnable uYG;
  
  static
  {
    AppMethodBeat.i(224362);
    HOt = new a((byte)0);
    AppMethodBeat.o(224362);
  }
  
  public x(RelativeLayout paramRelativeLayout, d paramd)
  {
    AppMethodBeat.i(75629);
    this.EmK = paramRelativeLayout;
    this.APl = paramd;
    paramRelativeLayout = this.EmK.findViewById(b.e.record_button);
    p.j(paramRelativeLayout, "layout.findViewById(R.id.record_button)");
    this.FhM = ((MMSightRecordButton)paramRelativeLayout);
    paramRelativeLayout = this.EmK.findViewById(b.e.capture_hint);
    p.j(paramRelativeLayout, "layout.findViewById(R.id.capture_hint)");
    this.uYC = ((TextView)paramRelativeLayout);
    paramRelativeLayout = this.EmK.findViewById(b.e.capture_permission_jump);
    p.j(paramRelativeLayout, "layout.findViewById(R.id.capture_permission_jump)");
    this.HOf = paramRelativeLayout;
    this.knk = new MMHandler(Looper.getMainLooper());
    this.HOg = 10000;
    this.HOh = this.HOg;
    this.HOj = 500;
    this.HOk = -1L;
    this.HOn = b.h.mmsight_capture_hint;
    this.uYG = ((Runnable)new c(this));
    this.HOq = true;
    this.HOr = b.h.record_hint_hold_to_record;
    this.HOs = "";
    this.FhM.setSimpleTapCallback((MMSightRecordButton.d)new MMSightRecordButton.d()
    {
      public final void cYu()
      {
        AppMethodBeat.i(75613);
        x.a(this.HOu);
        AppMethodBeat.o(75613);
      }
    });
    AppMethodBeat.o(75629);
  }
  
  private final void aS(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(224352);
    String str = this.EmK.getContext().getString(paramInt);
    p.j(str, "layout.context.getString(strRes)");
    ci(str, true);
    AppMethodBeat.o(224352);
  }
  
  private final void ci(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(224354);
    if (this.HOf.getVisibility() == 0)
    {
      AppMethodBeat.o(224354);
      return;
    }
    this.EmK.removeCallbacks(this.uYG);
    this.uYC.setText((CharSequence)paramString);
    this.uYC.setVisibility(0);
    this.uYC.animate().alpha(1.0F).start();
    if (paramBoolean) {
      this.EmK.postDelayed(this.uYG, 3000L);
    }
    AppMethodBeat.o(224354);
  }
  
  private final void e(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(224309);
    Boolean localBoolean = paramRecordConfigProvider.HKX;
    p.j(localBoolean, "config.enablePicture");
    this.HOi = localBoolean.booleanValue();
    localBoolean = paramRecordConfigProvider.HKX;
    p.j(localBoolean, "config.enablePicture");
    if (localBoolean.booleanValue())
    {
      this.uYC.setText(b.h.mmsight_capture_hint_picture);
      this.FhM.setSimpleTapCallback((MMSightRecordButton.d)new f(this));
    }
    localBoolean = paramRecordConfigProvider.HKY;
    p.j(localBoolean, "config.enableVideo");
    if (localBoolean.booleanValue())
    {
      this.uYC.setText(b.h.mmsight_capture_hint_sight);
      this.FhM.setLongPressCallback((MMSightRecordButton.b)new g(this));
      this.FhM.setLongPressScrollCallback((MMSightRecordButton.c)new h(this));
    }
    localBoolean = paramRecordConfigProvider.HKX;
    p.j(localBoolean, "config.enablePicture");
    if (localBoolean.booleanValue())
    {
      localBoolean = paramRecordConfigProvider.HKY;
      p.j(localBoolean, "config.enableVideo");
      if (localBoolean.booleanValue())
      {
        this.HOn = b.h.mmsight_capture_hint;
        fwY();
      }
    }
    if (!paramRecordConfigProvider.HKX.booleanValue())
    {
      paramRecordConfigProvider = paramRecordConfigProvider.HKY;
      p.j(paramRecordConfigProvider, "config.enableVideo");
      if (paramRecordConfigProvider.booleanValue())
      {
        this.HOn = b.h.mmsight_capture_hint_tap_or_long_press_sight;
        fwY();
        this.FhM.eUo();
        this.FhM.setSimpleTapCallback(null);
      }
    }
    AppMethodBeat.o(224309);
  }
  
  private void fwX()
  {
    AppMethodBeat.i(224320);
    this.uYC.setText(b.h.record_type_subvideo_tip);
    AppMethodBeat.o(224320);
  }
  
  private void fwY()
  {
    AppMethodBeat.i(224322);
    this.uYC.setText(this.HOn);
    AppMethodBeat.o(224322);
  }
  
  private final void wA(boolean paramBoolean)
  {
    AppMethodBeat.i(224358);
    this.FhM.setTouchEnable(false);
    this.knk.postDelayed((Runnable)new d(this), 1500L);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("PARAM_1_BOOLEAN", paramBoolean);
    this.APl.a(d.c.HRh, localBundle);
    AppMethodBeat.o(224358);
  }
  
  public final void Xg(int paramInt)
  {
    AppMethodBeat.i(224344);
    this.FhM.Xg(paramInt);
    AppMethodBeat.o(224344);
  }
  
  public final void aq(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(224343);
    this.FhM.uo(paramBoolean1);
    if (paramBoolean1) {
      fwX();
    }
    for (;;)
    {
      if ((paramBoolean1) && (paramBoolean2)) {
        this.FhM.eUp();
      }
      AppMethodBeat.o(224343);
      return;
      fwY();
    }
  }
  
  public final void bRC()
  {
    AppMethodBeat.i(224317);
    if (!this.HOl)
    {
      AppMethodBeat.o(224317);
      return;
    }
    this.HOl = false;
    d.b.a(this.APl, d.c.HRg);
    Context localContext;
    if (this.jwh == 0)
    {
      localContext = this.EmK.getContext();
      p.j(localContext, "layout.context");
    }
    for (int i = localContext.getResources().getColor(b.b.wechat_green);; i = this.jwh)
    {
      this.FhM.a(this.HOg, i, (MMSightCircularProgressBar.a)new k(this));
      AppMethodBeat.o(224317);
      return;
    }
  }
  
  public final void bbp()
  {
    AppMethodBeat.i(75627);
    this.EmK.setVisibility(0);
    AppMethodBeat.o(75627);
  }
  
  public final void c(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(224319);
    p.k(paramRecordConfigProvider, "config");
    this.HOh = paramRecordConfigProvider.HLb;
    this.HOg = (paramRecordConfigProvider.HLb + 250);
    UICustomParam localUICustomParam = paramRecordConfigProvider.HKT;
    if (localUICustomParam != null) {}
    for (int i = localUICustomParam.jwh;; i = 0)
    {
      this.jwh = i;
      e(paramRecordConfigProvider);
      AppMethodBeat.o(224319);
      return;
    }
  }
  
  public final void d(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(224334);
    p.k(paramOnClickListener, "clickListener");
    if (this.uYC.getVisibility() == 0)
    {
      Future localFuture = this.HOp;
      if (localFuture != null) {
        localFuture.cancel(true);
      }
      this.HOp = ((Future)h.ZvG.n((Runnable)new i(this), 2000L));
    }
    for (;;)
    {
      this.HOf.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(224334);
      return;
      this.HOf.setVisibility(0);
    }
  }
  
  public final void fwZ()
  {
    AppMethodBeat.i(224337);
    Future localFuture = this.HOp;
    if (localFuture != null) {
      localFuture.cancel(true);
    }
    this.HOf.setVisibility(4);
    AppMethodBeat.o(224337);
  }
  
  public final void fxa()
  {
    AppMethodBeat.i(224338);
    if (this.HOi)
    {
      d.b.a(this.APl, d.c.HRo);
      AppMethodBeat.o(224338);
      return;
    }
    fxb();
    AppMethodBeat.o(224338);
  }
  
  public final void fxb()
  {
    AppMethodBeat.i(224340);
    aS(b.h.record_hint_record_too_short, true);
    AppMethodBeat.o(224340);
  }
  
  public final void fxc()
  {
    AppMethodBeat.i(224349);
    if (((CharSequence)this.HOs).length() > 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      ci(this.HOs, true);
      AppMethodBeat.o(224349);
      return;
    }
    aS(this.HOr, true);
    AppMethodBeat.o(224349);
  }
  
  public final List<Float> getSubProgress()
  {
    AppMethodBeat.i(224347);
    List localList = this.FhM.getSubProgress();
    p.j(localList, "recordButton.subProgress");
    AppMethodBeat.o(224347);
    return localList;
  }
  
  public final String name()
  {
    AppMethodBeat.i(224363);
    String str = getClass().getName();
    AppMethodBeat.o(224363);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    return false;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(75628);
    this.EmK.setVisibility(4);
    AppMethodBeat.o(75628);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(224357);
    this.FhM.stopRecord();
    AppMethodBeat.o(224357);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(224366);
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
    u.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(224366);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset()
  {
    AppMethodBeat.i(75626);
    this.FhM.eUn();
    this.FhM.setTouchEnable(true);
    this.knk.removeCallbacksAndMessages(null);
    if (!com.tencent.mm.pluginsdk.permission.b.f(this.FhM.getContext(), new String[] { "android.permission.RECORD_AUDIO" })) {
      d((View.OnClickListener)new e(this));
    }
    AppMethodBeat.o(75626);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(224360);
    this.FhM.setVisibility(paramInt);
    if (this.HOq) {
      this.EmK.bringToFront();
    }
    AppMethodBeat.o(224360);
  }
  
  public final void up(boolean paramBoolean)
  {
    AppMethodBeat.i(224348);
    this.FhM.up(paramBoolean);
    AppMethodBeat.o(224348);
  }
  
  public final void wz(boolean paramBoolean)
  {
    AppMethodBeat.i(224298);
    this.HOi = paramBoolean;
    if (this.HOi)
    {
      this.uYC.setText(b.h.mmsight_capture_hint_picture);
      this.FhM.setSimpleTapCallback((MMSightRecordButton.d)new b(this));
      AppMethodBeat.o(224298);
      return;
    }
    this.uYC.setText(b.h.mmsight_capture_hint_sight);
    this.FhM.setSimpleTapCallback(null);
    AppMethodBeat.o(224298);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onSimpleTap"})
  static final class b
    implements MMSightRecordButton.d
  {
    b(x paramx) {}
    
    public final void cYu()
    {
      AppMethodBeat.i(218508);
      if ((x.c(this.HOu) == -1L) || (Util.ticksToNow(x.c(this.HOu)) > x.d(this.HOu)))
      {
        Log.i("MicroMsg.MMRecordUI", "onSimpleTap %s", new Object[] { Util.getStack().toString() });
        d.b.a(this.HOu.APl, d.c.HRo);
        x.a(this.HOu, Util.currentTicks());
        AppMethodBeat.o(218508);
        return;
      }
      Log.i("MicroMsg.MMRecordUI", "onSimpleTap too often! %s", new Object[] { Util.getStack().toString() });
      AppMethodBeat.o(218508);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(x paramx) {}
    
    public final void run()
    {
      AppMethodBeat.i(75615);
      x.h(this.HOu).animate().alpha(0.0F).withEndAction((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(75614);
          x.h(this.HOv.HOu).setVisibility(4);
          AppMethodBeat.o(75614);
        }
      }).start();
      AppMethodBeat.o(75615);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(x paramx) {}
    
    public final void run()
    {
      AppMethodBeat.i(75616);
      x.g(this.HOu).showLoading();
      AppMethodBeat.o(75616);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(x paramx) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(216572);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin$reset$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = x.g(this.HOu).getContext();
      if (paramView == null)
      {
        paramView = new t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(216572);
        throw paramView;
      }
      paramView = (Activity)paramView;
      localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin$reset$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin$reset$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin$reset$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(216572);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onSimpleTap"})
  static final class f
    implements MMSightRecordButton.d
  {
    f(x paramx) {}
    
    public final void cYu()
    {
      AppMethodBeat.i(218491);
      if ((x.c(this.HOu) == -1L) || (Util.ticksToNow(x.c(this.HOu)) > x.d(this.HOu)))
      {
        Log.i("MicroMsg.MMRecordUI", "onSimpleTap %s", new Object[] { Util.getStack().toString() });
        d.b.a(this.HOu.APl, d.c.HRo);
        x.a(this.HOu, Util.currentTicks());
        AppMethodBeat.o(218491);
        return;
      }
      Log.i("MicroMsg.MMRecordUI", "onSimpleTap too often! %s", new Object[] { Util.getStack().toString() });
      AppMethodBeat.o(218491);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin$setEnableType$2", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightRecordButton$LongPressCallback;", "onLongPress", "", "onLongPressFinish", "onPressDown", "plugin-recordvideo_release"})
  public static final class g
    implements MMSightRecordButton.b
  {
    public final void cYs()
    {
      AppMethodBeat.i(222731);
      Log.i("MicroMsg.RecordButtonPlugin", "onLongPressFinish");
      if (x.i(this.HOu))
      {
        x.a(this.HOu, false);
        d.b.a(this.HOu.APl, d.c.HRB);
        AppMethodBeat.o(222731);
        return;
      }
      x.b(this.HOu);
      AppMethodBeat.o(222731);
    }
    
    public final void cYt()
    {
      AppMethodBeat.i(222726);
      Object localObject = x.e(this.HOu);
      if (localObject != null) {
        ((Future)localObject).cancel(true);
      }
      x.f(this.HOu).setVisibility(4);
      localObject = new int[2];
      x.g(this.HOu).getLocationOnScreen((int[])localObject);
      Bundle localBundle = new Bundle();
      localBundle.putInt("PARAM_PREPARE_CAMERA_ZOOM_LOCATION_INT", localObject[1]);
      this.HOu.APl.a(d.c.HRc, localBundle);
      x.h(this.HOu).animate().alpha(0.0F).withEndAction((Runnable)new a(this)).start();
      localObject = c.HUw;
      c.acr(2);
      localObject = c.HUw;
      c.acq(2);
      localObject = c.HUw;
      c.fxr().anh();
      AppMethodBeat.o(222726);
    }
    
    public final void dJ()
    {
      AppMethodBeat.i(222728);
      x.a(this.HOu, true);
      if ((x.j(this.HOu)) && (x.g(this.HOu).eUr()))
      {
        d.b.a(this.HOu.APl, d.c.HRA);
        AppMethodBeat.o(222728);
        return;
      }
      this.HOu.bRC();
      AppMethodBeat.o(222728);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(x.g paramg) {}
      
      public final void run()
      {
        AppMethodBeat.i(228283);
        x.h(this.HOw.HOu).setVisibility(4);
        AppMethodBeat.o(228283);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin$setEnableType$3", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightRecordButton$LongPressScrollCallback;", "onScrollDown", "", "factor", "", "onScrollUp", "plugin-recordvideo_release"})
  public static final class h
    implements MMSightRecordButton.c
  {
    public final void Ka(int paramInt)
    {
      AppMethodBeat.i(222863);
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_BOOLEAN", true);
      localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_SCROLL_BOOLEAN", true);
      localBundle.putInt("PARAM_PREPARE_CAMERA_ZOOM_FACTOR_INT", paramInt);
      this.HOu.APl.a(d.c.HRd, localBundle);
      AppMethodBeat.o(222863);
    }
    
    public final void Kb(int paramInt)
    {
      AppMethodBeat.i(222864);
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_BOOLEAN", false);
      localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_SCROLL_BOOLEAN", true);
      localBundle.putInt("PARAM_PREPARE_CAMERA_ZOOM_FACTOR_INT", paramInt);
      this.HOu.APl.a(d.c.HRd, localBundle);
      AppMethodBeat.o(222864);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(x paramx) {}
    
    public final void run()
    {
      AppMethodBeat.i(218708);
      x.h(this.HOu).setVisibility(4);
      x.f(this.HOu).setVisibility(0);
      AppMethodBeat.o(218708);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin$startRecord$1", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightCircularProgressBar$ProgressCallback;", "onProgress", "", "subProgress", "Ljava/util/ArrayList;", "", "onProgressFinish", "finish", "", "plugin-recordvideo_release"})
  public static final class k
    implements MMSightCircularProgressBar.a
  {
    public final void Z(ArrayList<Float> paramArrayList)
    {
      AppMethodBeat.i(216812);
      p.k(paramArrayList, "subProgress");
      kotlin.g.a.b localb = this.HOu.HOo;
      if (localb != null)
      {
        localb.invoke(paramArrayList);
        AppMethodBeat.o(216812);
        return;
      }
      AppMethodBeat.o(216812);
    }
    
    public final void mV(boolean paramBoolean)
    {
      AppMethodBeat.i(216813);
      Log.i("MicroMsg.RecordButtonPlugin", "onProgressFinish");
      x.b(this.HOu, paramBoolean);
      AppMethodBeat.o(216813);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.x
 * JD-Core Version:    0.7.0.1
 */