package com.tencent.mm.plugin.recordvideo.plugin.parent;

import a.l;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.model.c.a;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.r;
import com.tencent.mm.plugin.recordvideo.plugin.s;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.plugin.u;
import com.tencent.mm.plugin.recordvideo.plugin.v;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/RecordPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener$OrienChangeCallback;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "albumPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/RecordAlbumPlugin;", "cameraSwitchPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/RecordSwitchCameraPlugin;", "closePlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/RecordClosePlugin;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "orientationEventListener", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener;", "previewPlugin", "Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;", "process", "Lcom/tencent/mm/plugin/recordvideo/config/CameraContainerProcess;", "recordController", "Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer;", "recordPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin;", "touchFocusPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/RecordFocusPlugin;", "initLogic", "", "onOrientationChange", "orientation", "", "onPause", "onResume", "release", "reset", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-recordvideo_release"})
public final class RecordPluginLayout
  extends BasePluginLayout
  implements c.a, d
{
  public static final RecordPluginLayout.a qfo;
  private com.tencent.mm.plugin.mmsight.model.c oPM;
  private RecordConfigProvider qaF;
  private final CameraPreviewGLSurfaceView qaR;
  private com.tencent.mm.plugin.recordvideo.activity.a qdK;
  private final s qfh;
  private final t qfi;
  private final r qfj;
  private final v qfk;
  private final u qfl;
  private com.tencent.mm.plugin.recordvideo.b.a qfm;
  private com.tencent.mm.media.widget.camerarecordview.a qfn;
  
  static
  {
    AppMethodBeat.i(150831);
    qfo = new RecordPluginLayout.a((byte)0);
    AppMethodBeat.o(150831);
  }
  
  public RecordPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(150830);
    this.oPM = new com.tencent.mm.plugin.mmsight.model.c(paramContext);
    LayoutInflater.from(paramContext).inflate(2130970548, (ViewGroup)this, true);
    paramContext = findViewById(2131827123);
    a.f.b.j.p(paramContext, "findViewById(R.id.preview_plugin)");
    this.qaR = ((CameraPreviewGLSurfaceView)paramContext);
    paramContext = findViewById(2131827124);
    a.f.b.j.p(paramContext, "findViewById(R.id.record_plugin)");
    this.qfh = new s((RelativeLayout)paramContext, (d)this);
    paramContext = findViewById(2131827125);
    a.f.b.j.p(paramContext, "findViewById(R.id.close_plugin)");
    this.qfi = new t(paramContext, (d)this);
    paramContext = findViewById(2131821758);
    a.f.b.j.p(paramContext, "findViewById(R.id.switch_camera)");
    this.qfk = new v((ImageView)paramContext, (d)this);
    this.qfl = new u((View)this, (d)this);
    paramContext = findViewById(2131827126);
    a.f.b.j.p(paramContext, "findViewById(R.id.story_choose_from_album)");
    this.qfj = new r((ImageView)paramContext, (d)this);
    getPluginList().add(this.qfh);
    getPluginList().add(this.qfi);
    getPluginList().add(this.qfj);
    getPluginList().add(this.qfk);
    getPluginList().add(this.qfl);
    paramContext = this.oPM;
    if (paramContext != null) {
      paramContext.a((c.a)this);
    }
    paramContext = this.oPM;
    if (paramContext != null)
    {
      paramContext.enable();
      AppMethodBeat.o(150830);
      return;
    }
    AppMethodBeat.o(150830);
  }
  
  public final void a(com.tencent.mm.plugin.recordvideo.activity.a parama, RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(150823);
    a.f.b.j.q(parama, "navigator");
    a.f.b.j.q(paramRecordConfigProvider, "configProvider");
    if (a.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(4) }).contains(Integer.valueOf(paramRecordConfigProvider.scene)))
    {
      if (paramRecordConfigProvider.qbq == null) {
        paramRecordConfigProvider.qbq = new SightParams(paramRecordConfigProvider.scene, 0).fcu;
      }
      localObject = paramRecordConfigProvider.qbq;
      if (localObject != null)
      {
        ab.i("MicroMsg.RecordPluginLayout", "initLogic init SightRecordConfig ");
        com.tencent.mm.plugin.recordvideo.b.c localc = com.tencent.mm.plugin.recordvideo.b.c.qbf;
        com.tencent.mm.plugin.recordvideo.b.c.d((VideoTransPara)localObject);
      }
    }
    this.qdK = parama;
    this.qaF = paramRecordConfigProvider;
    this.qfm = new com.tencent.mm.plugin.recordvideo.b.a(paramRecordConfigProvider, this.qaR);
    parama = this.qfm;
    if (parama == null) {
      a.f.b.j.ebi();
    }
    this.qfn = new com.tencent.mm.media.widget.camerarecordview.a((com.tencent.mm.media.widget.camerarecordview.c.a)parama);
    parama = this.qfn;
    if (parama != null) {
      parama.gq(1000L);
    }
    this.qfh.a(paramRecordConfigProvider);
    parama = this.qfj;
    Object localObject = paramRecordConfigProvider.qbw;
    a.f.b.j.p(localObject, "configProvider.enableAlbum");
    parama.enable = ((Boolean)localObject).booleanValue();
    parama = this.qfj;
    localObject = paramRecordConfigProvider.qbw;
    a.f.b.j.p(localObject, "configProvider.enableAlbum");
    if (((Boolean)localObject).booleanValue()) {}
    for (int i = 0;; i = 8)
    {
      parama.setVisibility(i);
      parama = new StringBuilder("configProvider:").append(paramRecordConfigProvider).append(", config:");
      paramRecordConfigProvider = com.tencent.mm.plugin.recordvideo.b.c.qbf;
      ab.i("MicroMsg.RecordPluginLayout", com.tencent.mm.plugin.recordvideo.b.c.cgi());
      AppMethodBeat.o(150823);
      return;
    }
  }
  
  public final void a(d.c paramc, Bundle paramBundle)
  {
    float f2 = 0.0F;
    int i = 0;
    AppMethodBeat.i(150824);
    a.f.b.j.q(paramc, "status");
    ab.i("MicroMsg.RecordPluginLayout", "status : ".concat(String.valueOf(paramc)));
    switch (e.bLo[paramc.ordinal()])
    {
    default: 
      ab.i("MicroMsg.RecordPluginLayout", "unknown status ".concat(String.valueOf(paramc)));
      AppMethodBeat.o(150824);
      return;
    case 1: 
      paramc = this.qfn;
      if (paramc != null)
      {
        paramBundle = this.oPM;
        if (paramBundle == null) {
          break label203;
        }
      }
      for (boolean bool = paramBundle.isLandscape();; bool = false)
      {
        paramBundle = this.oPM;
        if (paramBundle != null) {
          i = paramBundle.getOrientation();
        }
        paramc.g(bool, i);
        this.qfi.setVisibility(8);
        this.qfj.setVisibility(8);
        paramc = com.tencent.mm.plugin.recordvideo.b.c.qbf;
        com.tencent.mm.plugin.recordvideo.b.c.cgn();
        paramc = com.tencent.mm.plugin.recordvideo.c.b.qfu;
        com.tencent.mm.plugin.recordvideo.c.b.p("KEY_START_RECORD_MS_LONG", Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(150824);
        return;
      }
    case 2: 
      paramc = this.qfn;
      if ((paramc != null) && (!paramc.c((a.f.a.b)new RecordPluginLayout.c(this))))
      {
        paramc = this.qfh;
        if (!paramc.qcQ) {
          break label281;
        }
        d.b.a(paramc.qbI, d.c.qer);
      }
      for (;;)
      {
        this.qfi.setVisibility(0);
        this.qfj.setVisibility(0);
        AppMethodBeat.o(150824);
        return;
        paramc.Cq(2131302356);
      }
    case 3: 
      if (paramBundle != null)
      {
        paramc = this.qfn;
        if (paramc != null)
        {
          paramc.kk(paramBundle.getInt("PARAM_PREPARE_CAMERA_ZOOM_LOCATION_INT"));
          AppMethodBeat.o(150824);
          return;
        }
        AppMethodBeat.o(150824);
        return;
      }
      AppMethodBeat.o(150824);
      return;
    case 4: 
      if (paramBundle != null)
      {
        paramc = this.qfn;
        if (paramc != null)
        {
          paramc.a(paramBundle.getBoolean("PARAM_PREPARE_CAMERA_ZOOM_BOOLEAN", false), paramBundle.getBoolean("PARAM_PREPARE_CAMERA_ZOOM_SCROLL_BOOLEAN", true), paramBundle.getInt("PARAM_PREPARE_CAMERA_ZOOM_FACTOR_INT"));
          AppMethodBeat.o(150824);
          return;
        }
      }
      AppMethodBeat.o(150824);
      return;
    case 5: 
      paramc = this.qfn;
      if (paramc != null)
      {
        paramc.WN();
        AppMethodBeat.o(150824);
        return;
      }
      AppMethodBeat.o(150824);
      return;
    case 6: 
      label203:
      if (paramBundle != null) {}
      label281:
      for (float f1 = paramBundle.getFloat("PARAM_POINT_X");; f1 = 0.0F)
      {
        if (paramBundle != null) {
          f2 = paramBundle.getFloat("PARAM_POINT_Y");
        }
        paramc = this.qfn;
        if (paramc == null) {
          break;
        }
        paramc.b(f1, f2, this.qaR.getWidth(), this.qaR.getHeight());
        AppMethodBeat.o(150824);
        return;
      }
      AppMethodBeat.o(150824);
      return;
    }
    long l = bo.yB();
    paramc = com.tencent.mm.plugin.recordvideo.c.b.qfu;
    com.tencent.mm.plugin.recordvideo.c.b.p("KEY_START_RECORD_MS_LONG", Long.valueOf(System.currentTimeMillis()));
    paramc = this.qfn;
    if (paramc != null)
    {
      paramc.d((a.f.a.b)new RecordPluginLayout.d(this, l));
      AppMethodBeat.o(150824);
      return;
    }
    AppMethodBeat.o(150824);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(150827);
    super.onPause();
    ab.i("MicroMsg.RecordPluginLayout", "onPause");
    Object localObject = this.qfn;
    if (localObject != null) {
      ((com.tencent.mm.media.widget.camerarecordview.a)localObject).stopPreview();
    }
    localObject = this.oPM;
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.mmsight.model.c)localObject).disable();
      AppMethodBeat.o(150827);
      return;
    }
    AppMethodBeat.o(150827);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(150826);
    super.onResume();
    Object localObject1 = this.oPM;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.mmsight.model.c)localObject1).enable();
    }
    com.tencent.mm.media.widget.camerarecordview.a locala = this.qfn;
    if (locala != null)
    {
      Object localObject2 = (Iterable)a.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(2) });
      localObject1 = this.qaF;
      if (localObject1 != null) {}
      for (localObject1 = Integer.valueOf(((RecordConfigProvider)localObject1).scene);; localObject1 = null)
      {
        if (a.a.j.a((Iterable)localObject2, localObject1))
        {
          localObject1 = this.qaF;
          if (localObject1 != null)
          {
            localObject1 = ((RecordConfigProvider)localObject1).qbq;
            if (localObject1 != null)
            {
              ab.i("MicroMsg.RecordPluginLayout", "onResume init SightRecordConfig");
              localObject2 = com.tencent.mm.plugin.recordvideo.b.c.qbf;
              com.tencent.mm.plugin.recordvideo.b.c.d((VideoTransPara)localObject1);
            }
          }
        }
        com.tencent.mm.media.widget.camerarecordview.a.a(locala, false, (a.f.a.b)new RecordPluginLayout.b(locala), 1);
        AppMethodBeat.o(150826);
        return;
      }
    }
    AppMethodBeat.o(150826);
  }
  
  public final void release()
  {
    Object localObject2 = null;
    AppMethodBeat.i(150828);
    super.release();
    ab.i("MicroMsg.RecordPluginLayout", "release");
    Object localObject1 = this.qfn;
    if (localObject1 != null) {
      ((com.tencent.mm.media.widget.camerarecordview.a)localObject1).release();
    }
    localObject1 = this.oPM;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.mmsight.model.c)localObject1).disable();
    }
    localObject1 = this.oPM;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.mmsight.model.c)localObject1).a(null);
    }
    this.oPM = null;
    localObject1 = this.qaF;
    if (localObject1 != null) {}
    for (localObject1 = ((RecordConfigProvider)localObject1).qbA;; localObject1 = null)
    {
      e.deleteFile((String)localObject1);
      RecordConfigProvider localRecordConfigProvider = this.qaF;
      localObject1 = localObject2;
      if (localRecordConfigProvider != null) {
        localObject1 = localRecordConfigProvider.qbC;
      }
      e.deleteFile((String)localObject1);
      AppMethodBeat.o(150828);
      return;
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(150825);
    this.qfh.oPm.bRO();
    AppMethodBeat.o(150825);
  }
  
  public final void zr(int paramInt)
  {
    AppMethodBeat.i(150829);
    if (paramInt < 0)
    {
      AppMethodBeat.o(150829);
      return;
    }
    float f;
    if ((paramInt == 90) || (paramInt == 270)) {
      if (paramInt == 270) {
        f = 90.0F;
      }
    }
    v localv;
    for (;;)
    {
      localv = this.qfk;
      if ((localv.enable) && (localv.qcZ != f) && (AppForegroundDelegate.bXk.AX())) {
        break;
      }
      AppMethodBeat.o(150829);
      return;
      f = -90.0F;
      continue;
      f = paramInt;
    }
    ab.i("MicroMsg.RecordSwitchCameraPlugin", "updateOrientation " + f + "  " + localv.mCy.getRotation());
    localv.qcZ = f;
    localv.mCy.animate().cancel();
    localv.mCy.animate().rotation(f).setDuration(100L).start();
    AppMethodBeat.o(150829);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.parent.RecordPluginLayout
 * JD-Core Version:    0.7.0.1
 */