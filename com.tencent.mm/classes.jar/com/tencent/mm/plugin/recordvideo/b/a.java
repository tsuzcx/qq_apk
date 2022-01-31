package com.tencent.mm.plugin.recordvideo.b;

import a.f.b.j;
import a.l;
import a.v;
import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.media.widget.b.b;
import com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.af;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/recordvideo/config/CameraContainerProcess;", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "previewPlugin", "Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;", "(Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;)V", "getConfigProvider", "()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "setConfigProvider", "(Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;)V", "getPreviewPlugin", "()Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;", "setPreviewPlugin", "(Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;)V", "recordVideoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "getCameraPreviewView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "getContext", "Landroid/content/Context;", "getEncodeConfig", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getResolutionLimit", "", "getVideoTransPara", "useCpuCrop", "", "Companion", "plugin-recordvideo_release"})
public final class a
  implements com.tencent.mm.media.widget.camerarecordview.c.a
{
  public static final a.a qaS;
  RecordConfigProvider qaF;
  private VideoTransPara qaQ;
  private CameraPreviewGLSurfaceView qaR;
  
  static
  {
    AppMethodBeat.i(150571);
    qaS = new a.a((byte)0);
    AppMethodBeat.o(150571);
  }
  
  public a(RecordConfigProvider paramRecordConfigProvider, CameraPreviewGLSurfaceView paramCameraPreviewGLSurfaceView)
  {
    AppMethodBeat.i(150570);
    this.qaF = paramRecordConfigProvider;
    this.qaR = paramCameraPreviewGLSurfaceView;
    paramRecordConfigProvider = com.tencent.mm.plugin.recordvideo.d.a.qfv;
    paramRecordConfigProvider = this.qaF;
    j.q(paramRecordConfigProvider, "configProvider");
    if (TextUtils.isEmpty((CharSequence)paramRecordConfigProvider.qbD)) {
      paramRecordConfigProvider.qbD = com.tencent.mm.plugin.recordvideo.d.a.cgD();
    }
    if (TextUtils.isEmpty((CharSequence)paramRecordConfigProvider.qbC)) {
      paramRecordConfigProvider.qbC = com.tencent.mm.plugin.recordvideo.d.a.cgE();
    }
    if (TextUtils.isEmpty((CharSequence)paramRecordConfigProvider.qbA)) {
      paramRecordConfigProvider.qbA = com.tencent.mm.plugin.recordvideo.d.a.cgC();
    }
    if (TextUtils.isEmpty((CharSequence)paramRecordConfigProvider.qbB)) {
      paramRecordConfigProvider.qbB = com.tencent.mm.plugin.recordvideo.d.a.cgC();
    }
    if (TextUtils.isEmpty((CharSequence)paramRecordConfigProvider.thumbPath))
    {
      paramCameraPreviewGLSurfaceView = paramRecordConfigProvider.qbB;
      j.p(paramCameraPreviewGLSurfaceView, "configProvider.outputVideoPath");
      paramRecordConfigProvider.thumbPath = com.tencent.mm.plugin.recordvideo.d.a.Yb(paramCameraPreviewGLSurfaceView);
    }
    paramRecordConfigProvider = this.qaF.qbq.clone();
    if (paramRecordConfigProvider == null)
    {
      paramRecordConfigProvider = new v("null cannot be cast to non-null type com.tencent.mm.modelcontrol.VideoTransPara");
      AppMethodBeat.o(150570);
      throw paramRecordConfigProvider;
    }
    this.qaQ = ((VideoTransPara)paramRecordConfigProvider);
    paramRecordConfigProvider = c.qbf;
    if (c.isInit())
    {
      paramRecordConfigProvider = c.qbf;
      paramRecordConfigProvider = c.cgj();
      if (paramRecordConfigProvider != null)
      {
        paramRecordConfigProvider = paramRecordConfigProvider.clone();
        if (paramRecordConfigProvider == null)
        {
          paramRecordConfigProvider = new v("null cannot be cast to non-null type com.tencent.mm.modelcontrol.VideoTransPara");
          AppMethodBeat.o(150570);
          throw paramRecordConfigProvider;
        }
        this.qaQ = ((VideoTransPara)paramRecordConfigProvider);
      }
    }
    float f;
    if (this.qaF.qbp == 1)
    {
      paramRecordConfigProvider = c.qbf;
      if (!c.isInit())
      {
        paramRecordConfigProvider = af.hQ(ah.getContext());
        int i = paramRecordConfigProvider.y;
        int j = paramRecordConfigProvider.x;
        this.qaQ.width = (j * this.qaQ.height / i);
      }
      if (this.qaF.scene != 2) {
        break label442;
      }
      f = ((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.lVW, 2.0F);
      this.qaQ.videoBitrate = ((int)(this.qaQ.videoBitrate * f));
      ab.i("MicroMsg.CameraContainerProcess", "final kbps: " + f + "  " + this.qaQ.videoBitrate);
    }
    for (;;)
    {
      ab.i("MicroMsg.CameraContainerProcess", "init CameraContainerProcess, scene: " + this.qaF.scene + "   " + this.qaQ);
      AppMethodBeat.o(150570);
      return;
      label442:
      if (this.qaF.scene == 1)
      {
        f = ((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.lVV, 2.0F);
        this.qaQ.videoBitrate = ((int)(this.qaQ.videoBitrate * f));
        ab.i("MicroMsg.CameraContainerProcess", "final kbps: " + f + "  " + this.qaQ.videoBitrate);
      }
      else
      {
        this.qaQ.videoBitrate *= 2;
        ab.i("MicroMsg.CameraContainerProcess", "final kbps: $2  " + this.qaQ.videoBitrate);
      }
    }
  }
  
  public final boolean DP()
  {
    return false;
  }
  
  public final boolean Xn()
  {
    AppMethodBeat.i(150566);
    Object localObject = c.qbf;
    if (c.isInit())
    {
      localObject = c.qbf;
      bool = c.cgm();
      AppMethodBeat.o(150566);
      return bool;
    }
    localObject = this.qaF.qbn;
    j.p(localObject, "configProvider.useCPUCrop");
    boolean bool = ((Boolean)localObject).booleanValue();
    AppMethodBeat.o(150566);
    return bool;
  }
  
  public final boolean Xo()
  {
    return false;
  }
  
  public final com.tencent.mm.media.widget.camerarecordview.preview.c getCameraPreviewView()
  {
    return (com.tencent.mm.media.widget.camerarecordview.preview.c)this.qaR;
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(150569);
    Context localContext = this.qaR.getContext();
    j.p(localContext, "previewPlugin.context");
    AppMethodBeat.o(150569);
    return localContext;
  }
  
  public final com.tencent.mm.media.widget.camerarecordview.a.a getEncodeConfig()
  {
    AppMethodBeat.i(150568);
    com.tencent.mm.media.widget.camerarecordview.a.a locala = (com.tencent.mm.media.widget.camerarecordview.a.a)new a.b(this);
    AppMethodBeat.o(150568);
    return locala;
  }
  
  public final com.tencent.mm.media.h.a getPreviewRenderer()
  {
    return null;
  }
  
  public final com.tencent.mm.media.h.a getRecordRenderer()
  {
    return null;
  }
  
  public final b getRecorder()
  {
    return null;
  }
  
  public final int getResolutionLimit()
  {
    AppMethodBeat.i(150567);
    c localc = c.qbf;
    if (c.isInit())
    {
      localc = c.qbf;
      i = c.cgl();
      AppMethodBeat.o(150567);
      return i;
    }
    int i = this.qaF.eZQ;
    AppMethodBeat.o(150567);
    return i;
  }
  
  public final VideoTransPara getVideoTransPara()
  {
    AppMethodBeat.i(150565);
    Object localObject = c.qbf;
    if (c.isInit())
    {
      localObject = c.qbf;
      localObject = c.cgj();
      if ((localObject != null) && ((((VideoTransPara)localObject).width != this.qaQ.width) || (((VideoTransPara)localObject).height != this.qaQ.height)))
      {
        this.qaQ.width = ((VideoTransPara)localObject).width;
        this.qaQ.height = ((VideoTransPara)localObject).height;
      }
    }
    localObject = this.qaQ;
    AppMethodBeat.o(150565);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.b.a
 * JD-Core Version:    0.7.0.1
 */