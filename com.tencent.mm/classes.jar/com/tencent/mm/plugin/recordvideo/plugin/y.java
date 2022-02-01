package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.plugin.comm.b.e;
import com.tencent.mm.plugin.comm.b.e.a;
import com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar.a;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.b;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.c;
import com.tencent.mm.plugin.recordvideo.b.b;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.h;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "layout", "Landroid/widget/RelativeLayout;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/RelativeLayout;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "captureHint", "Landroid/widget/TextView;", "enablePicture", "", "forceBringToFront", "getForceBringToFront", "()Z", "setForceBringToFront", "(Z)V", "hideHintRunnable", "Ljava/lang/Runnable;", "initMaxRecordTime", "", "getInitMaxRecordTime", "()I", "setInitMaxRecordTime", "(I)V", "isNeedCountdown", "isWaitForCountdown", "lastTakePictureTime", "", "getLayout", "()Landroid/widget/RelativeLayout;", "setLayout", "(Landroid/widget/RelativeLayout;)V", "maxRecordTimeMS", "getMaxRecordTimeMS", "setMaxRecordTimeMS", "normalVideoHint", "permissionJumper", "Landroid/view/View;", "progressChangeCallBack", "Lkotlin/Function1;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "Lkotlin/ParameterName;", "name", "subProgress", "", "getProgressChangeCallBack", "()Lkotlin/jvm/functions/Function1;", "setProgressChangeCallBack", "(Lkotlin/jvm/functions/Function1;)V", "recordButton", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightRecordButton;", "getRecordButton", "()Lcom/tencent/mm/plugin/mmsight/ui/MMSightRecordButton;", "setRecordButton", "(Lcom/tencent/mm/plugin/mmsight/ui/MMSightRecordButton;)V", "recordColor", "recordHintContent", "", "kotlin.jvm.PlatformType", "showJumperRunnable", "Ljava/util/concurrent/Future;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "takePictureMinInterval", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "changeRecordDuration", "time", "changeToClickRecord", "changeToNormalRecord", "changeToSubRecord", "dismissPermissionHint", "enable", "getSubProgress", "", "hideHint", "initConfig", "config", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "needCountdown", "need", "onAttach", "onBackPress", "onDetach", "onPause", "prepareDelete", "delete", "recordFinish", "finish", "recordTimeNotEnough", "removeCurrentProgress", "verify", "removeSelectProgress", "index", "reset", "restoreRecordDuration", "setEnableSubProgress", "isFullscreenMode", "setEnableType", "setHint", "wording", "setNormalVideoHint", "setSubVideoHint", "setVisibility", "visibility", "showHint", "strRes", "autoHide", "strWording", "showPermissionAfterHint", "clickListener", "Landroid/view/View$OnClickListener;", "showRecordShortHint", "showRecordShotHintMusic", "minDuration", "showRecordStartMusicHint", "showRecordTipHint", "startRecord", "updateHintWithRes", "resId", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class y
  implements v
{
  public static final y.a NKV;
  com.tencent.mm.plugin.recordvideo.plugin.parent.a GrC;
  public RelativeLayout Kft;
  public MMSightRecordButton Ldl;
  private final View NKW;
  public int NKX;
  public int NKY;
  private boolean NKZ;
  private final int NLa;
  private long NLb;
  private boolean NLc;
  private boolean NLd;
  private int NLe;
  public kotlin.g.a.b<? super ArrayList<Float>, ah> NLf;
  private Future<?> NLg;
  public boolean NLh;
  private String NLi;
  private int lZz;
  private final MMHandler mRi;
  public final TextView ykN;
  private final Runnable ykR;
  
  static
  {
    AppMethodBeat.i(280744);
    NKV = new y.a((byte)0);
    AppMethodBeat.o(280744);
  }
  
  public y(RelativeLayout paramRelativeLayout, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    AppMethodBeat.i(75629);
    this.Kft = paramRelativeLayout;
    this.GrC = parama;
    paramRelativeLayout = this.Kft.findViewById(b.e.record_button);
    s.s(paramRelativeLayout, "layout.findViewById(R.id.record_button)");
    this.Ldl = ((MMSightRecordButton)paramRelativeLayout);
    paramRelativeLayout = this.Kft.findViewById(b.e.capture_hint);
    s.s(paramRelativeLayout, "layout.findViewById(R.id.capture_hint)");
    this.ykN = ((TextView)paramRelativeLayout);
    paramRelativeLayout = this.Kft.findViewById(b.e.capture_permission_jump);
    s.s(paramRelativeLayout, "layout.findViewById(R.id.capture_permission_jump)");
    this.NKW = paramRelativeLayout;
    this.mRi = new MMHandler(Looper.getMainLooper());
    this.NKX = 10000;
    this.NKY = this.NKX;
    this.NLa = 500;
    this.NLb = -1L;
    this.NLe = b.h.mmsight_capture_hint;
    this.ykR = new y..ExternalSyntheticLambda6(this);
    this.NLh = true;
    this.NLi = com.tencent.mm.cd.a.bt(this.Kft.getContext(), b.h.record_hint_hold_to_record);
    this.Ldl.setSimpleTapCallback(new y..ExternalSyntheticLambda2(this));
    AppMethodBeat.o(75629);
  }
  
  private final void AZ(boolean paramBoolean)
  {
    AppMethodBeat.i(280613);
    this.Ldl.setTouchEnable(false);
    this.mRi.postDelayed(new y..ExternalSyntheticLambda8(this), 1500L);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("PARAM_1_BOOLEAN", paramBoolean);
    this.GrC.a(a.c.NNN, localBundle);
    this.Ldl.announceForAccessibility((CharSequence)com.tencent.mm.cd.a.bt(this.Ldl.getContext(), b.h.aging_record_btn_video));
    AppMethodBeat.o(280613);
  }
  
  private static final void K(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(280686);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(280686);
  }
  
  private static final void a(y paramy, View paramView)
  {
    AppMethodBeat.i(280693);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramy);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramy, "this$0");
    paramy = paramy.Ldl.getContext();
    if (paramy == null)
    {
      paramy = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(280693);
      throw paramy;
    }
    com.tencent.mm.pluginsdk.permission.b.lx((Context)paramy);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(280693);
  }
  
  private static final void b(y paramy)
  {
    AppMethodBeat.i(280624);
    s.u(paramy, "this$0");
    paramy.ykN.setVisibility(4);
    AppMethodBeat.o(280624);
  }
  
  private static final void c(y paramy)
  {
    AppMethodBeat.i(280634);
    s.u(paramy, "this$0");
    paramy.ykN.animate().alpha(0.0F).withEndAction(new y..ExternalSyntheticLambda5(paramy)).start();
    AppMethodBeat.o(280634);
  }
  
  private static final void d(y paramy)
  {
    AppMethodBeat.i(280643);
    s.u(paramy, "this$0");
    paramy.gIM();
    AppMethodBeat.o(280643);
  }
  
  private static final void e(y paramy)
  {
    AppMethodBeat.i(280654);
    s.u(paramy, "this$0");
    if ((paramy.NLb == -1L) || (Util.ticksToNow(paramy.NLb) > paramy.NLa))
    {
      Log.i("MicroMsg.MMRecordUI", "onSimpleTap %s", new Object[] { Util.getStack().toString() });
      a.b.a(paramy.GrC, a.c.NNU);
      paramy.NLb = Util.currentTicks();
      AppMethodBeat.o(280654);
      return;
    }
    Log.i("MicroMsg.MMRecordUI", "onSimpleTap too often! %s", new Object[] { Util.getStack().toString() });
    AppMethodBeat.o(280654);
  }
  
  private static final void f(y paramy)
  {
    AppMethodBeat.i(280665);
    s.u(paramy, "this$0");
    if ((paramy.NLb == -1L) || (Util.ticksToNow(paramy.NLb) > paramy.NLa))
    {
      Log.i("MicroMsg.MMRecordUI", "onSimpleTap %s", new Object[] { Util.getStack().toString() });
      a.b.a(paramy.GrC, a.c.NNU);
      paramy.NLb = Util.currentTicks();
    }
    for (;;)
    {
      e.xfd.a("SnsPublishProcess", "endSessionShot", Integer.valueOf(1), com.tencent.mm.plugin.comm.b.c.xeT);
      AppMethodBeat.o(280665);
      return;
      Log.i("MicroMsg.MMRecordUI", "onSimpleTap too often! %s", new Object[] { Util.getStack().toString() });
    }
  }
  
  private static final void g(y paramy)
  {
    AppMethodBeat.i(280676);
    s.u(paramy, "this$0");
    paramy.ykN.setVisibility(4);
    paramy.NKW.setVisibility(0);
    AppMethodBeat.o(280676);
  }
  
  private void gIF()
  {
    AppMethodBeat.i(280599);
    this.ykN.setText(b.h.record_type_subvideo_tip);
    AppMethodBeat.o(280599);
  }
  
  private void gIG()
  {
    AppMethodBeat.i(280605);
    this.ykN.setText(this.NLe);
    AppMethodBeat.o(280605);
  }
  
  private final void h(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(280596);
    Boolean localBoolean = paramRecordConfigProvider.NHV;
    s.s(localBoolean, "config.enablePicture");
    this.NKZ = localBoolean.booleanValue();
    localBoolean = paramRecordConfigProvider.NHV;
    s.s(localBoolean, "config.enablePicture");
    if (localBoolean.booleanValue())
    {
      this.ykN.setText(b.h.mmsight_capture_hint_picture);
      this.Ldl.setSimpleTapCallback(new y..ExternalSyntheticLambda4(this));
    }
    localBoolean = paramRecordConfigProvider.NHW;
    s.s(localBoolean, "config.enableVideo");
    if (localBoolean.booleanValue())
    {
      this.ykN.setText(b.h.mmsight_capture_hint_sight);
      this.Ldl.setLongPressCallback((MMSightRecordButton.b)new b(this));
      this.Ldl.setLongPressScrollCallback((MMSightRecordButton.c)new c(this));
    }
    localBoolean = paramRecordConfigProvider.NHV;
    s.s(localBoolean, "config.enablePicture");
    if (localBoolean.booleanValue())
    {
      localBoolean = paramRecordConfigProvider.NHW;
      s.s(localBoolean, "config.enableVideo");
      if (localBoolean.booleanValue())
      {
        this.NLe = b.h.mmsight_capture_hint;
        gIG();
      }
    }
    if (!paramRecordConfigProvider.NHV.booleanValue())
    {
      paramRecordConfigProvider = paramRecordConfigProvider.NHW;
      s.s(paramRecordConfigProvider, "config.enableVideo");
      if (paramRecordConfigProvider.booleanValue()) {
        gIL();
      }
    }
    AppMethodBeat.o(280596);
  }
  
  private static final void h(y paramy)
  {
    AppMethodBeat.i(280700);
    s.u(paramy, "this$0");
    paramy.Ldl.showLoading();
    AppMethodBeat.o(280700);
  }
  
  public final void AY(boolean paramBoolean)
  {
    AppMethodBeat.i(280844);
    this.NKZ = paramBoolean;
    if (this.NKZ)
    {
      this.ykN.setText(b.h.mmsight_capture_hint_picture);
      this.Ldl.setSimpleTapCallback(new y..ExternalSyntheticLambda3(this));
      AppMethodBeat.o(280844);
      return;
    }
    this.ykN.setText(b.h.mmsight_capture_hint_sight);
    this.Ldl.setSimpleTapCallback(null);
    AppMethodBeat.o(280844);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(280956);
    v.a.a(this, paramRecordConfigProvider);
    AppMethodBeat.o(280956);
  }
  
  public final void aJ(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(280878);
    this.Ldl.yB(paramBoolean1);
    if (paramBoolean1) {
      gIF();
    }
    for (;;)
    {
      if ((paramBoolean1) && (paramBoolean2)) {
        this.Ldl.gdc();
      }
      AppMethodBeat.o(280878);
      return;
      gIG();
    }
  }
  
  public final void abi(int paramInt)
  {
    AppMethodBeat.i(280884);
    this.Ldl.abi(paramInt);
    AppMethodBeat.o(280884);
  }
  
  public final void agA(int paramInt)
  {
    AppMethodBeat.i(280835);
    this.NLi = com.tencent.mm.cd.a.bt(this.Kft.getContext(), paramInt);
    AppMethodBeat.o(280835);
  }
  
  public final void agB(int paramInt)
  {
    AppMethodBeat.i(280875);
    Context localContext = this.Ldl.getContext();
    paramInt = (int)(paramInt / 1000.0F);
    k.a(localContext, localContext.getString(b.h.record_short_hint_music, new Object[] { Integer.valueOf(paramInt) }), "", localContext.getString(b.h.record_restart_capture), y..ExternalSyntheticLambda0.INSTANCE);
    AppMethodBeat.o(280875);
  }
  
  public final void agC(int paramInt)
  {
    AppMethodBeat.i(280928);
    String str = this.Kft.getContext().getString(paramInt);
    s.s(str, "layout.context.getString(strRes)");
    cH(str, true);
    AppMethodBeat.o(280928);
  }
  
  public final void bwk()
  {
    AppMethodBeat.i(75627);
    s.u((v)this, "this");
    this.Kft.setVisibility(0);
    AppMethodBeat.o(75627);
  }
  
  public final void cH(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(280931);
    s.u(paramString, "strWording");
    if (this.NKW.getVisibility() == 0)
    {
      AppMethodBeat.o(280931);
      return;
    }
    this.Kft.removeCallbacks(this.ykR);
    this.ykN.setText((CharSequence)paramString);
    this.ykN.setVisibility(0);
    this.ykN.animate().alpha(1.0F).start();
    this.Kft.postDelayed(this.ykR, 3000L);
    AppMethodBeat.o(280931);
  }
  
  public final void d(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(280864);
    s.u(paramOnClickListener, "clickListener");
    if (this.ykN.getVisibility() == 0)
    {
      Future localFuture = this.NLg;
      if (localFuture != null) {
        localFuture.cancel(true);
      }
      this.NLg = ((Future)h.ahAA.o(new y..ExternalSyntheticLambda7(this), 2000L));
    }
    for (;;)
    {
      this.NKW.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(280864);
      return;
      this.NKW.setVisibility(0);
    }
  }
  
  public final void dpe()
  {
    AppMethodBeat.i(280853);
    if (!this.NLc)
    {
      AppMethodBeat.o(280853);
      return;
    }
    this.NLc = false;
    a.b.a(this.GrC, a.c.NNM);
    if (this.lZz == 0) {}
    for (int i = this.Kft.getContext().getResources().getColor(b.b.wechat_green);; i = this.lZz)
    {
      this.Ldl.a(this.NKX, i, (MMSightCircularProgressBar.a)new d(this));
      AppMethodBeat.o(280853);
      return;
    }
  }
  
  public final void e(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(280858);
    s.u(paramRecordConfigProvider, "config");
    this.NKY = paramRecordConfigProvider.NHZ;
    this.NKX = (paramRecordConfigProvider.NHZ + 250);
    UICustomParam localUICustomParam = paramRecordConfigProvider.NHR;
    if (localUICustomParam == null) {}
    for (int i = 0;; i = localUICustomParam.lZz)
    {
      this.lZz = i;
      h(paramRecordConfigProvider);
      AppMethodBeat.o(280858);
      return;
    }
  }
  
  public final void gIH()
  {
    AppMethodBeat.i(280868);
    Future localFuture = this.NLg;
    if (localFuture != null) {
      localFuture.cancel(true);
    }
    this.NKW.setVisibility(4);
    AppMethodBeat.o(280868);
  }
  
  public final void gII()
  {
    AppMethodBeat.i(280871);
    if (this.NKZ)
    {
      a.b.a(this.GrC, a.c.NNU);
      AppMethodBeat.o(280871);
      return;
    }
    agC(b.h.record_hint_record_too_short);
    AppMethodBeat.o(280871);
  }
  
  public final void gIJ()
  {
    AppMethodBeat.i(280904);
    AY(false);
    agA(b.h.record_type_subvideo_tip);
    String str = this.NLi;
    s.s(str, "recordHintContent");
    cH(str, true);
    this.Ldl.Lce = true;
    aJ(true, true);
    AppMethodBeat.o(280904);
  }
  
  public final void gIK()
  {
    AppMethodBeat.i(280912);
    AY(true);
    agA(b.h.mmsight_capture_hint);
    String str = this.NLi;
    s.s(str, "recordHintContent");
    cH(str, true);
    this.Ldl.Lce = false;
    aJ(false, true);
    AppMethodBeat.o(280912);
  }
  
  public final void gIL()
  {
    AppMethodBeat.i(280918);
    agA(b.h.mmsight_capture_hint_tap_or_long_press_sight);
    String str = this.NLi;
    s.s(str, "recordHintContent");
    cH(str, true);
    this.Ldl.Lce = true;
    this.Ldl.setSimpleTapCallback(null);
    AppMethodBeat.o(280918);
  }
  
  public final void gIM()
  {
    AppMethodBeat.i(280922);
    String str = this.NLi;
    s.s(str, "recordHintContent");
    cH(str, true);
    AppMethodBeat.o(280922);
  }
  
  public final List<Float> getSubProgress()
  {
    AppMethodBeat.i(280891);
    List localList = this.Ldl.getSubProgress();
    s.s(localList, "recordButton.subProgress");
    AppMethodBeat.o(280891);
    return localList;
  }
  
  public final String name()
  {
    AppMethodBeat.i(280961);
    String str = v.a.b(this);
    AppMethodBeat.o(280961);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(280966);
    s.u(this, "this");
    AppMethodBeat.o(280966);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(280942);
    if (this.Ldl.nJm)
    {
      this.Ldl.stopRecord();
      AppMethodBeat.o(280942);
      return true;
    }
    s.u((v)this, "this");
    AppMethodBeat.o(280942);
    return false;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(75628);
    s.u((v)this, "this");
    this.Kft.setVisibility(4);
    AppMethodBeat.o(75628);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(280937);
    s.u((v)this, "this");
    this.Ldl.stopRecord();
    AppMethodBeat.o(280937);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(280974);
    v.a.a(this, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(280974);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(280979);
    s.u(this, "this");
    AppMethodBeat.o(280979);
  }
  
  public final void release()
  {
    AppMethodBeat.i(280985);
    s.u(this, "this");
    AppMethodBeat.o(280985);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(75626);
    this.Ldl.gdb();
    this.Ldl.setTouchEnable(true);
    this.mRi.removeCallbacksAndMessages(null);
    if (!com.tencent.mm.pluginsdk.permission.b.g(this.Ldl.getContext(), new String[] { "android.permission.RECORD_AUDIO" })) {
      d(new y..ExternalSyntheticLambda1(this));
    }
    AppMethodBeat.o(75626);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(280949);
    s.u((v)this, "this");
    this.Ldl.setVisibility(paramInt);
    if (this.NLh) {
      this.Kft.bringToFront();
    }
    AppMethodBeat.o(280949);
  }
  
  public final void yC(boolean paramBoolean)
  {
    AppMethodBeat.i(280897);
    this.Ldl.yC(paramBoolean);
    AppMethodBeat.o(280897);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin$setEnableType$2", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightRecordButton$LongPressCallback;", "onLongPress", "", "onLongPressFinish", "onPressDown", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements MMSightRecordButton.b
  {
    b(y paramy) {}
    
    private static final void n(y paramy)
    {
      AppMethodBeat.i(280444);
      s.u(paramy, "this$0");
      y.k(paramy).setVisibility(4);
      AppMethodBeat.o(280444);
    }
    
    public final void dEK()
    {
      AppMethodBeat.i(280461);
      Log.i("MicroMsg.RecordButtonPlugin", "onLongPressFinish");
      if (y.m(this.NLj))
      {
        y.a(this.NLj, false);
        a.b.a(this.NLj.GrC, a.c.NOh);
      }
      for (;;)
      {
        e.xfd.a("SnsPublishProcess", "endSessionShot", Integer.valueOf(1), com.tencent.mm.plugin.comm.b.c.xeT);
        AppMethodBeat.o(280461);
        return;
        y.a(this.NLj);
      }
    }
    
    public final void dEL()
    {
      AppMethodBeat.i(280456);
      Object localObject = y.i(this.NLj);
      if (localObject != null) {
        ((Future)localObject).cancel(true);
      }
      y.j(this.NLj).setVisibility(4);
      localObject = new int[2];
      this.NLj.Ldl.getLocationOnScreen((int[])localObject);
      Bundle localBundle = new Bundle();
      localBundle.putInt("PARAM_PREPARE_CAMERA_ZOOM_LOCATION_INT", localObject[1]);
      this.NLj.GrC.a(a.c.NNI, localBundle);
      y.k(this.NLj).animate().alpha(0.0F).withEndAction(new y.b..ExternalSyntheticLambda0(this.NLj)).start();
      localObject = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.agH(2);
      localObject = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.agG(2);
      localObject = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.gJg().jkV = 1L;
      AppMethodBeat.o(280456);
    }
    
    public final void eI()
    {
      int j = 1;
      AppMethodBeat.i(280459);
      y.a(this.NLj, true);
      if (y.l(this.NLj))
      {
        MMSightRecordButton localMMSightRecordButton = this.NLj.Ldl;
        int i = j;
        if (localMMSightRecordButton.Lbz) {
          if (!localMMSightRecordButton.getSubProgress().isEmpty()) {
            break label79;
          }
        }
        label79:
        for (i = j; i != 0; i = 0)
        {
          a.b.a(this.NLj.GrC, a.c.NOg);
          AppMethodBeat.o(280459);
          return;
        }
      }
      this.NLj.dpe();
      AppMethodBeat.o(280459);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin$setEnableType$3", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightRecordButton$LongPressScrollCallback;", "onScrollDown", "", "factor", "", "onScrollUp", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements MMSightRecordButton.c
  {
    c(y paramy) {}
    
    public final void KY(int paramInt)
    {
      AppMethodBeat.i(280446);
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_BOOLEAN", true);
      localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_SCROLL_BOOLEAN", true);
      localBundle.putInt("PARAM_PREPARE_CAMERA_ZOOM_FACTOR_INT", paramInt);
      this.NLj.GrC.a(a.c.NNJ, localBundle);
      AppMethodBeat.o(280446);
    }
    
    public final void KZ(int paramInt)
    {
      AppMethodBeat.i(280453);
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_BOOLEAN", false);
      localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_SCROLL_BOOLEAN", true);
      localBundle.putInt("PARAM_PREPARE_CAMERA_ZOOM_FACTOR_INT", paramInt);
      this.NLj.GrC.a(a.c.NNJ, localBundle);
      AppMethodBeat.o(280453);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin$startRecord$1", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightCircularProgressBar$ProgressCallback;", "onProgress", "", "subProgress", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "onProgressFinish", "finish", "", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements MMSightCircularProgressBar.a
  {
    d(y paramy) {}
    
    public final void ad(ArrayList<Float> paramArrayList)
    {
      AppMethodBeat.i(280443);
      s.u(paramArrayList, "subProgress");
      kotlin.g.a.b localb = this.NLj.NLf;
      if (localb != null) {
        localb.invoke(paramArrayList);
      }
      AppMethodBeat.o(280443);
    }
    
    public final void ov(boolean paramBoolean)
    {
      AppMethodBeat.i(280447);
      Log.i("MicroMsg.RecordButtonPlugin", "onProgressFinish");
      y.b(this.NLj, paramBoolean);
      AppMethodBeat.o(280447);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.y
 * JD-Core Version:    0.7.0.1
 */