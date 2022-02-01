package com.tencent.mm.plugin.recordvideo.plugin.parent;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.lifecycle.j.a;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.b.b.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.f;
import com.tencent.mm.plugin.recordvideo.c;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.ac;
import com.tencent.mm.plugin.recordvideo.plugin.ad;
import com.tencent.mm.plugin.recordvideo.plugin.y;
import com.tencent.mm.plugin.recordvideo.plugin.z;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d<-Lkotlin.ah;>;
import kotlin.g.a.m;
import kotlin.r;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.b.g;
import kotlinx.coroutines.b.h;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/CameraKitPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/RecordCheckAudioPermissionPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "Landroidx/lifecycle/LifecycleOwner;", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener$OrienChangeCallback;", "Lcom/tencent/mm/media/camera/CustomRenderCallback;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "cameraSwitchPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/RecordSwitchCameraPlugin;", "cameraUsage", "Lcom/tencent/mm/media/camera/view/ICameraUsage;", "closePlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/RecordClosePlugin;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "orientationPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/RecordOrientationPlugin;", "recordPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin;", "recorder", "Lcom/tencent/mm/plugin/recordvideo/recorder/CameraKitRecorder;", "checkAudioPermission", "", "getLifecycle", "Landroidx/lifecycle/Lifecycle;", "glCreate", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "glRelease", "glRender", "Lcom/tencent/mm/media/globject/GLTextureObject;", "texture", "(Lcom/tencent/mm/media/globject/GLTextureObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initLogic", "makeRecordVideoFullScreen", "observeCameraStatus", "onAttach", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDetach", "onOrientationChange", "orientation", "", "onPause", "onResume", "registerPlugin", "release", "reset", "setPluginVisibility", "visible", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "takePictureAndJump", "updateRecordTipByAudioPermission", "permission", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class CameraKitPluginLayout
  extends RecordCheckAudioPermissionPluginLayout
  implements q, com.tencent.mm.media.camera.d, com.tencent.mm.plugin.mmsight.model.d.a, a
{
  public static final CameraKitPluginLayout.a NNt;
  private final y FiN;
  private final com.tencent.mm.plugin.recordvideo.d.a Fin;
  private final ad Fip;
  private final ac Fiq;
  private com.tencent.mm.plugin.recordvideo.activity.a Fiu;
  private final com.tencent.mm.media.camera.view.d NNu;
  private final z NNv;
  private final androidx.lifecycle.s nvu;
  private RecordConfigProvider oaV;
  
  static
  {
    AppMethodBeat.i(281083);
    NNt = new CameraKitPluginLayout.a((byte)0);
    AppMethodBeat.o(281083);
  }
  
  public CameraKitPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(281042);
    this.nvu = new androidx.lifecycle.s((q)this);
    this.Fin = new com.tencent.mm.plugin.recordvideo.d.a();
    this.Fiq = new ac(paramContext);
    LayoutInflater.from(paramContext).inflate(b.f.camerakit_plugin_layout, (ViewGroup)this, true);
    paramContext = findViewById(b.e.camera_view);
    kotlin.g.b.s.s(paramContext, "findViewById(R.id.camera_view)");
    this.NNu = ((com.tencent.mm.media.camera.view.d)paramContext);
    this.NNu.n((q)this);
    this.NNu.setCustomRender((com.tencent.mm.media.camera.d)this);
    kotlinx.coroutines.j.a(getScope(), null, null, (m)new b(this, null), 3);
    this.FiN = new y((RelativeLayout)this, (a)this);
    this.FiN.NLh = false;
    paramContext = findViewById(b.e.switch_camera);
    kotlin.g.b.s.s(paramContext, "findViewById(R.id.switch_camera)");
    this.Fip = new ad((ImageView)paramContext, (a)this);
    paramContext = findViewById(b.e.close_plugin);
    kotlin.g.b.s.s(paramContext, "findViewById(R.id.close_plugin)");
    this.NNv = new z((WeImageView)paramContext, (a)this);
    this.Fiq.KUU = ((com.tencent.mm.plugin.mmsight.model.d.a)this);
    getPluginList().add(this.NNv);
    getPluginList().add(this.Fip);
    getPluginList().add(this.Fiq);
    AppMethodBeat.o(281042);
  }
  
  private static final void a(CameraKitPluginLayout paramCameraKitPluginLayout, View paramView)
  {
    AppMethodBeat.i(281057);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramCameraKitPluginLayout);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/plugin/parent/CameraKitPluginLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramCameraKitPluginLayout, "this$0");
    paramCameraKitPluginLayout.setCheckAudioPermission(true);
    paramCameraKitPluginLayout = paramCameraKitPluginLayout.getContext();
    if (paramCameraKitPluginLayout == null)
    {
      paramCameraKitPluginLayout = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(281057);
      throw paramCameraKitPluginLayout;
    }
    com.tencent.mm.pluginsdk.permission.b.lx((Context)paramCameraKitPluginLayout);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/recordvideo/plugin/parent/CameraKitPluginLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(281057);
  }
  
  private final Object al(kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(281050);
    if ((paramd instanceof d))
    {
      localObject1 = (d)paramd;
      if ((((d)localObject1).label & 0x80000000) != 0) {
        ((d)localObject1).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super ah>)localObject1;; paramd = new d(this, paramd))
    {
      localObject1 = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(281050);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject1);
    Object localObject1 = this.NNu;
    int i = -this.Fiq.NLn;
    paramd.L$0 = this;
    paramd.label = 1;
    Object localObject2 = com.tencent.mm.media.camera.view.d.a.a((com.tencent.mm.media.camera.view.d)localObject1, (i + 360) % 360, paramd);
    localObject1 = localObject2;
    paramd = this;
    if (localObject2 == locala)
    {
      AppMethodBeat.o(281050);
      return locala;
      paramd = (CameraKitPluginLayout)paramd.L$0;
      ResultKt.throwOnFailure(localObject1);
    }
    localObject1 = (r)localObject1;
    if (((Number)((r)localObject1).bsC).intValue() == 0)
    {
      localObject2 = paramd.oaV;
      kotlin.g.b.s.checkNotNull(localObject2);
      localObject2 = ((RecordConfigProvider)localObject2).NIf;
      BitmapUtil.saveBitmapToImage((Bitmap)((r)localObject1).bsD, 100, Bitmap.CompressFormat.JPEG, (String)localObject2, true);
      localObject1 = com.tencent.mm.media.widget.camerarecordview.b.b.nJT;
      kotlin.g.b.s.s(localObject2, "path");
      localObject1 = b.a.Hc((String)localObject2);
      paramd = paramd.Fiu;
      if (paramd != null) {
        paramd.a(1, (com.tencent.mm.media.widget.camerarecordview.b.b)localObject1);
      }
    }
    paramd = ah.aiuX;
    AppMethodBeat.o(281050);
    return paramd;
  }
  
  private final void setPluginVisibility(int paramInt)
  {
    AppMethodBeat.i(281053);
    this.NNv.setVisibility(paramInt);
    this.Fip.setVisibility(paramInt);
    this.FiN.setVisibility(paramInt);
    AppMethodBeat.o(281053);
  }
  
  public final Object a(com.tencent.mm.media.g.d paramd, kotlin.d.d<? super com.tencent.mm.media.g.d> paramd1)
  {
    AppMethodBeat.i(281154);
    paramd = this.Fin.a(paramd, paramd1);
    AppMethodBeat.o(281154);
    return paramd;
  }
  
  public final void a(com.tencent.mm.plugin.recordvideo.activity.a parama, RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(281097);
    kotlin.g.b.s.u(parama, "navigator");
    kotlin.g.b.s.u(paramRecordConfigProvider, "configProvider");
    super.a(parama, paramRecordConfigProvider);
    c localc = c.NDb;
    c.f(paramRecordConfigProvider);
    this.Fiu = parama;
    this.oaV = paramRecordConfigProvider;
    parama = com.tencent.mm.ui.bg.bf(getContext());
    int i = parama.x;
    int j = parama.y;
    parama = paramRecordConfigProvider.oXZ;
    parama.height = (j * parama.width / i);
    Log.i("MicroMsg.CameraKitPluginLayout", "makeRecordVideoFullScreen width:" + parama.width + " height:" + parama.height);
    parama = com.tencent.mm.plugin.recordvideo.util.f.Obq;
    com.tencent.mm.plugin.recordvideo.util.f.j(paramRecordConfigProvider);
    this.FiN.e(paramRecordConfigProvider);
    this.Fin.i(paramRecordConfigProvider);
    this.NNu.setCameraKitSetting(new com.tencent.mm.media.camera.d.f());
    AppMethodBeat.o(281097);
  }
  
  public final void a(a.c paramc, final Bundle paramBundle)
  {
    AppMethodBeat.i(281104);
    kotlin.g.b.s.u(paramc, "status");
    Log.i("MicroMsg.CameraKitPluginLayout", "status : " + paramc + "  param: " + paramBundle);
    kotlinx.coroutines.j.a(getScope(), (kotlin.d.f)kotlinx.coroutines.bg.kCi(), null, (m)new c(paramc, this, paramBundle, null), 2);
    AppMethodBeat.o(281104);
  }
  
  public final void bwk()
  {
    AppMethodBeat.i(281128);
    super.bwk();
    setPluginVisibility(0);
    AppMethodBeat.o(281128);
  }
  
  protected final boolean eLi()
  {
    AppMethodBeat.i(281143);
    boolean bool2 = super.eLi();
    com.tencent.mm.plugin.recordvideo.d.a locala = this.Fin;
    if (!bool2) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      locala.setMute(bool1);
      AppMethodBeat.o(281143);
      return bool2;
    }
  }
  
  public final androidx.lifecycle.j getLifecycle()
  {
    return (androidx.lifecycle.j)this.nvu;
  }
  
  protected final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(281138);
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = this.oaV;
    if (paramConfiguration == null)
    {
      AppMethodBeat.o(281138);
      return;
    }
    c localc = c.NDb;
    c.f(paramConfiguration);
    this.Fin.i(paramConfiguration);
    AppMethodBeat.o(281138);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(281131);
    super.onDetach();
    setPluginVisibility(4);
    AppMethodBeat.o(281131);
  }
  
  public final void onOrientationChange(int paramInt)
  {
    AppMethodBeat.i(281140);
    this.Fip.cX(paramInt);
    AppMethodBeat.o(281140);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(281123);
    Log.i("MicroMsg.CameraKitPluginLayout", "onPause");
    super.onPause();
    try
    {
      this.nvu.a(j.a.ON_PAUSE);
      AppMethodBeat.o(281123);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.CameraKitPluginLayout", (Throwable)localException, "handleLifecycleEvent error", new Object[0]);
      AppMethodBeat.o(281123);
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(281119);
    Log.i("MicroMsg.CameraKitPluginLayout", "onResume");
    super.onResume();
    try
    {
      this.nvu.a(j.a.ON_RESUME);
      if (getCheckAudioPermission())
      {
        Object localObject = getContext();
        if (localObject == null)
        {
          localObject = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(281119);
          throw ((Throwable)localObject);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.CameraKitPluginLayout", (Throwable)localException, "handleLifecycleEvent error", new Object[0]);
      }
      tr(com.tencent.mm.pluginsdk.permission.b.g((Context)localException, new String[] { "android.permission.RECORD_AUDIO" }));
      AppMethodBeat.o(281119);
    }
  }
  
  public final Object p(kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(281151);
    paramd = this.Fin.p(paramd);
    if (paramd == kotlin.d.a.a.aiwj)
    {
      AppMethodBeat.o(281151);
      return paramd;
    }
    paramd = ah.aiuX;
    AppMethodBeat.o(281151);
    return paramd;
  }
  
  public final Object q(kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(281156);
    paramd = this.Fin.q(paramd);
    if (paramd == kotlin.d.a.a.aiwj)
    {
      AppMethodBeat.o(281156);
      return paramd;
    }
    paramd = ah.aiuX;
    AppMethodBeat.o(281156);
    return paramd;
  }
  
  public final void release()
  {
    AppMethodBeat.i(281133);
    super.release();
    try
    {
      this.nvu.a(j.a.ON_DESTROY);
      ar.a(getScope(), this + " release.");
      AppMethodBeat.o(281133);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.CameraKitPluginLayout", (Throwable)localException, "handleLifecycleEvent error", new Object[0]);
      }
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(281136);
    super.reset();
    this.Fin.reset();
    this.FiN.reset();
    AppMethodBeat.o(281136);
  }
  
  public final void tr(boolean paramBoolean)
  {
    AppMethodBeat.i(281149);
    com.tencent.mm.plugin.recordvideo.d.a locala = this.Fin;
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      locala.setMute(bool);
      if (!paramBoolean) {
        break;
      }
      this.FiN.gIH();
      AppMethodBeat.o(281149);
      return;
    }
    this.FiN.d(new CameraKitPluginLayout..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(281149);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    b(CameraKitPluginLayout paramCameraKitPluginLayout, kotlin.d.d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(281017);
      paramObject = (kotlin.d.d)new b(this.NNw, paramd);
      AppMethodBeat.o(281017);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(281013);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(281013);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (g)CameraKitPluginLayout.a(this.NNw).getCameraState();
        h localh = (h)new b(this.NNw);
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        if (paramObject.a(localh, locald) == locala)
        {
          AppMethodBeat.o(281013);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(281013);
      return paramObject;
    }
    
    @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements h<r<? extends com.tencent.mm.media.camera.view.a, ? extends Bundle>>
    {
      public b(CameraKitPluginLayout paramCameraKitPluginLayout) {}
      
      public final Object a(r<? extends com.tencent.mm.media.camera.view.a, ? extends Bundle> paramr, kotlin.d.d<? super ah> paramd)
      {
        AppMethodBeat.i(281079);
        paramr = (r)paramr;
        paramd = (com.tencent.mm.media.camera.view.a)paramr.bsC;
        if (CameraKitPluginLayout.b.a.$EnumSwitchMapping$0[paramd.ordinal()] == 1)
        {
          paramr = (Bundle)paramr.bsD;
          if (paramr != null) {
            break label66;
          }
        }
        label66:
        for (boolean bool = false;; bool = paramr.getBoolean("camera_boolean"))
        {
          CameraKitPluginLayout.b(this.NNw).Ba(bool);
          paramr = ah.aiuX;
          AppMethodBeat.o(281079);
          return paramr;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    c(a.c paramc, CameraKitPluginLayout paramCameraKitPluginLayout, Bundle paramBundle, kotlin.d.d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(281030);
      paramObject = (kotlin.d.d)new c(this.Fiw, jdField_this, paramBundle, paramd);
      AppMethodBeat.o(281030);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(281022);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(281022);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.Fiw;
        switch (CameraKitPluginLayout.c.a.$EnumSwitchMapping$0[paramObject.ordinal()])
        {
        default: 
          Log.i("MicroMsg.CameraKitPluginLayout", kotlin.g.b.s.X("unknown status ", this.Fiw));
        }
        break;
      }
      for (;;)
      {
        paramObject = ah.aiuX;
        AppMethodBeat.o(281022);
        return paramObject;
        paramObject = (kotlin.d.f)kotlinx.coroutines.bg.kCh();
        Object localObject = (m)new k(jdField_this, null)
        {
          int label;
          
          public final kotlin.d.d<ah> create(Object paramAnonymousObject, kotlin.d.d<?> paramAnonymousd)
          {
            AppMethodBeat.i(281060);
            paramAnonymousObject = (kotlin.d.d)new 1(this.NNw, paramAnonymousd);
            AppMethodBeat.o(281060);
            return paramAnonymousObject;
          }
          
          public final Object invokeSuspend(Object paramAnonymousObject)
          {
            AppMethodBeat.i(281056);
            kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
            switch (this.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(281056);
              throw paramAnonymousObject;
            }
            ResultKt.throwOnFailure(paramAnonymousObject);
            CameraKitPluginLayout.c(this.NNw).setVisibility(4);
            paramAnonymousObject = ah.aiuX;
            AppMethodBeat.o(281056);
            return paramAnonymousObject;
          }
        };
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        if (l.a(paramObject, (m)localObject, locald) == locala)
        {
          AppMethodBeat.o(281022);
          return locala;
          ResultKt.throwOnFailure(paramObject);
        }
        int i = -CameraKitPluginLayout.d(jdField_this).NLn;
        boolean bool = CameraKitPluginLayout.d(jdField_this).isLandscape();
        paramObject = CameraKitPluginLayout.e(jdField_this);
        if (bool) {}
        for (bool = true;; bool = false)
        {
          paramObject.bu((i + 360) % 360, bool);
          break;
        }
        paramObject = (kotlin.d.f)kotlinx.coroutines.bg.kCh();
        localObject = (m)new k(jdField_this, null)
        {
          int label;
          
          public final kotlin.d.d<ah> create(Object paramAnonymousObject, kotlin.d.d<?> paramAnonymousd)
          {
            AppMethodBeat.i(281058);
            paramAnonymousObject = (kotlin.d.d)new 2(this.NNw, paramAnonymousd);
            AppMethodBeat.o(281058);
            return paramAnonymousObject;
          }
          
          public final Object invokeSuspend(Object paramAnonymousObject)
          {
            AppMethodBeat.i(281054);
            kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
            switch (this.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(281054);
              throw paramAnonymousObject;
            }
            ResultKt.throwOnFailure(paramAnonymousObject);
            CameraKitPluginLayout.c(this.NNw).setVisibility(0);
            paramAnonymousObject = ah.aiuX;
            AppMethodBeat.o(281054);
            return paramAnonymousObject;
          }
        };
        locald = (kotlin.d.d)this;
        this.label = 2;
        if (l.a(paramObject, (m)localObject, locald) == locala)
        {
          AppMethodBeat.o(281022);
          return locala;
          ResultKt.throwOnFailure(paramObject);
        }
        paramObject = CameraKitPluginLayout.e(jdField_this);
        localObject = (kotlin.d.d)this;
        this.label = 3;
        localObject = paramObject.G((kotlin.d.d)localObject);
        paramObject = localObject;
        if (localObject == locala)
        {
          AppMethodBeat.o(281022);
          return locala;
          ResultKt.throwOnFailure(paramObject);
        }
        paramObject = (r)paramObject;
        Log.i("MicroMsg.CameraKitPluginLayout", "stopRecord result:" + ((Number)paramObject.bsC).intValue() + " info:" + paramObject.bsD);
        switch (((Number)paramObject.bsC).intValue())
        {
        default: 
          break;
        case -4: 
          paramObject = jdField_this;
          localObject = (kotlin.d.d)this;
          this.label = 4;
          if (CameraKitPluginLayout.a(paramObject, (kotlin.d.d)localObject) == locala)
          {
            AppMethodBeat.o(281022);
            return locala;
          }
          break;
        case 0: 
          localObject = CameraKitPluginLayout.f(jdField_this);
          if (localObject != null)
          {
            ((com.tencent.mm.plugin.recordvideo.activity.a)localObject).a(2, (com.tencent.mm.media.widget.camerarecordview.b.b)paramObject.bsD);
            continue;
            ResultKt.throwOnFailure(paramObject);
            continue;
            paramObject = jdField_this;
            localObject = (kotlin.d.d)this;
            this.label = 5;
            if (CameraKitPluginLayout.a(paramObject, (kotlin.d.d)localObject) == locala)
            {
              AppMethodBeat.o(281022);
              return locala;
              ResultKt.throwOnFailure(paramObject);
              continue;
              CameraKitPluginLayout.a(jdField_this).switchCamera();
              continue;
              if (paramBundle != null)
              {
                paramObject = paramBundle;
                localObject = jdField_this;
                if (paramObject.getBoolean("PARAM_PREPARE_CAMERA_ZOOM_BOOLEAN", false)) {
                  CameraKitPluginLayout.a((CameraKitPluginLayout)localObject).bof();
                } else {
                  CameraKitPluginLayout.a((CameraKitPluginLayout)localObject).bog();
                }
              }
            }
          }
          break;
        }
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    d(CameraKitPluginLayout paramCameraKitPluginLayout, kotlin.d.d<? super d> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(281007);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = CameraKitPluginLayout.a(this.NNw, (kotlin.d.d)this);
      AppMethodBeat.o(281007);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.parent.CameraKitPluginLayout
 * JD-Core Version:    0.7.0.1
 */