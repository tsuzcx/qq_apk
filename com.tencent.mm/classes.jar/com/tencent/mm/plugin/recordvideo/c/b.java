package com.tencent.mm.plugin.recordvideo.c;

import android.content.Context;
import android.opengl.EGLContext;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.xlabeffect.XEffectConfig;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/config/CameraContainerProcess;", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "previewPlugin", "Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;", "(Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;)V", "getConfigProvider", "()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "setConfigProvider", "(Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;)V", "daemonChecker", "Lcom/tencent/mm/media/widget/camerarecordview/daemon/DaemonChecker;", "getDaemonChecker", "()Lcom/tencent/mm/media/widget/camerarecordview/daemon/DaemonChecker;", "setDaemonChecker", "(Lcom/tencent/mm/media/widget/camerarecordview/daemon/DaemonChecker;)V", "mute", "", "getMute", "()Z", "setMute", "(Z)V", "needEffect", "getPreviewPlugin", "()Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;", "setPreviewPlugin", "(Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;)V", "previewRenderer", "Lcom/tencent/mm/plugin/recordvideo/render/XEffectRenderer;", "getPreviewRenderer", "()Lcom/tencent/mm/plugin/recordvideo/render/XEffectRenderer;", "setPreviewRenderer", "(Lcom/tencent/mm/plugin/recordvideo/render/XEffectRenderer;)V", "recordVideoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "recorderRenderer", "Lcom/tencent/mm/plugin/recordvideo/render/RecorderTextureRenderer;", "getRecorderRenderer", "()Lcom/tencent/mm/plugin/recordvideo/render/RecorderTextureRenderer;", "setRecorderRenderer", "(Lcom/tencent/mm/plugin/recordvideo/render/RecorderTextureRenderer;)V", "getCameraPreviewView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "getContext", "Landroid/content/Context;", "getDaemonVideoTransPara", "getEncodeConfig", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRecordRenderer", "getRecordScene", "", "getRecorder", "Lcom/tencent/mm/media/widget/recorder/IMediaRecorder;", "getResolutionLimit", "getVideoTransPara", "initCameraConfig", "", "isMute", "useCpuCrop", "useDaemonRecorder", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public class b
  implements com.tencent.mm.media.widget.camerarecordview.d.a
{
  public static final b.a NGr;
  private CameraPreviewGLSurfaceView GoC;
  private VideoTransPara NGp;
  private com.tencent.mm.media.widget.camerarecordview.a.a NGs;
  private final boolean NGt;
  private com.tencent.mm.plugin.recordvideo.e.c NGu;
  public com.tencent.mm.plugin.recordvideo.e.b NGv;
  public boolean nLP;
  public RecordConfigProvider oaV;
  
  static
  {
    AppMethodBeat.i(75363);
    NGr = new b.a((byte)0);
    AppMethodBeat.o(75363);
  }
  
  public b(RecordConfigProvider paramRecordConfigProvider, CameraPreviewGLSurfaceView paramCameraPreviewGLSurfaceView)
  {
    AppMethodBeat.i(75362);
    this.oaV = paramRecordConfigProvider;
    this.GoC = paramCameraPreviewGLSurfaceView;
    paramRecordConfigProvider = this.GoC.getContext();
    s.s(paramRecordConfigProvider, "previewPlugin.context");
    this.NGs = new com.tencent.mm.media.widget.camerarecordview.a.a(paramRecordConfigProvider);
    paramRecordConfigProvider = com.tencent.mm.plugin.recordvideo.util.f.Obq;
    com.tencent.mm.plugin.recordvideo.util.f.j(this.oaV);
    this.NGp = ((VideoTransPara)this.oaV.oXZ.clone());
    if (h.isInit())
    {
      paramRecordConfigProvider = h.NHb;
      paramRecordConfigProvider = h.gHw();
      if (paramRecordConfigProvider != null) {
        this.NGp = ((VideoTransPara)paramRecordConfigProvider.clone());
      }
    }
    float f;
    if (this.oaV.NHO == 1)
    {
      if (!h.isInit())
      {
        paramRecordConfigProvider = com.tencent.mm.plugin.recordvideo.model.a.NIt;
        int i = com.tencent.mm.plugin.recordvideo.model.a.getDisplayHeight();
        paramRecordConfigProvider = com.tencent.mm.plugin.recordvideo.model.a.NIt;
        int j = com.tencent.mm.plugin.recordvideo.model.a.gHH();
        this.NGp.width = (j * this.NGp.height / i);
        Log.i("MicroMsg.CameraContainerProcess", "SightRecordConfig init failed, fix videoPara");
      }
      paramRecordConfigProvider = com.tencent.mm.media.b.b.nxK;
      if (!com.tencent.mm.media.b.b.boA())
      {
        if (this.oaV.scene != 2) {
          break label367;
        }
        f = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yVo, 6.0F);
        this.NGp.videoBitrate = ((int)(this.NGp.videoBitrate * f));
        Log.i("MicroMsg.CameraContainerProcess", "final kbps: " + f + "  " + this.NGp.videoBitrate);
      }
    }
    if ((this.oaV.NIn.XKq) || (this.oaV.NIn.XKr)) {}
    for (boolean bool = true;; bool = false)
    {
      this.NGt = bool;
      paramRecordConfigProvider = com.tencent.mm.media.widget.a.c.nGn;
      com.tencent.mm.media.widget.a.c.uo(this.oaV.scene);
      Log.i("MicroMsg.CameraContainerProcess", "init CameraContainerProcess, scene: " + this.oaV.scene + "   " + this.NGp);
      AppMethodBeat.o(75362);
      return;
      label367:
      if (this.oaV.scene == 1)
      {
        f = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yVn, 8.0F);
        this.NGp.videoBitrate = ((int)(this.NGp.videoBitrate * f));
        Log.i("MicroMsg.CameraContainerProcess", "final kbps: " + f + "  " + this.NGp.videoBitrate);
        break;
      }
      this.NGp.videoBitrate = 8000000;
      Log.i("MicroMsg.CameraContainerProcess", s.X("final kbps: $2  ", Integer.valueOf(this.NGp.videoBitrate)));
      break;
    }
  }
  
  protected final void a(com.tencent.mm.plugin.recordvideo.e.c paramc)
  {
    this.NGu = paramc;
  }
  
  public final boolean aGe()
  {
    return this.nLP;
  }
  
  public final boolean bun()
  {
    AppMethodBeat.i(75356);
    Object localObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.acOC, Integer.valueOf(-1));
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(75356);
      throw ((Throwable)localObject);
    }
    int i = ((Integer)localObject).intValue();
    Log.i("MicroMsg.CameraContainerProcess", s.X("cuttype : ", Integer.valueOf(i)));
    switch (i)
    {
    default: 
      if (MultiProcessMMKV.getSingleDefault().getBoolean("mediacodec_create_error", false))
      {
        localObject = com.tencent.mm.plugin.recordvideo.util.d.Obm;
        com.tencent.mm.plugin.recordvideo.util.d.BC(true);
        AppMethodBeat.o(75356);
        return true;
      }
      break;
    case 1: 
      localObject = com.tencent.mm.plugin.recordvideo.util.d.Obm;
      com.tencent.mm.plugin.recordvideo.util.d.BC(false);
      AppMethodBeat.o(75356);
      return false;
    case 2: 
      localObject = com.tencent.mm.plugin.recordvideo.util.d.Obm;
      com.tencent.mm.plugin.recordvideo.util.d.BC(true);
      AppMethodBeat.o(75356);
      return true;
    }
    if (h.isInit()) {
      localObject = h.NHb;
    }
    for (localObject = Boolean.valueOf(h.gHz());; localObject = this.oaV.NHN)
    {
      com.tencent.mm.plugin.recordvideo.util.d locald = com.tencent.mm.plugin.recordvideo.util.d.Obm;
      s.s(localObject, "cpuCrop");
      com.tencent.mm.plugin.recordvideo.util.d.BC(((Boolean)localObject).booleanValue());
      boolean bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(75356);
      return bool;
    }
  }
  
  public final boolean buo()
  {
    AppMethodBeat.i(279761);
    s.u(this, "this");
    AppMethodBeat.o(279761);
    return false;
  }
  
  public boolean bup()
  {
    boolean bool = true;
    AppMethodBeat.i(75361);
    if (bun())
    {
      Log.i("MicroMsg.CameraContainerProcess", "useDaemonRecorder false");
      localObject = com.tencent.mm.plugin.recordvideo.util.d.Obm;
      com.tencent.mm.plugin.recordvideo.util.d.BD(false);
      AppMethodBeat.o(75361);
      return false;
    }
    if ((this.oaV.scene == 2) || (this.oaV.scene == 1))
    {
      localObject = this.NGs;
      Log.i("MicroMsg.DaemonChecker", "info: enable:[" + ((com.tencent.mm.media.widget.camerarecordview.a.a)localObject).enable + "] ramConfig:[" + ((com.tencent.mm.media.widget.camerarecordview.a.a)localObject).nJO + "] blackModelList:[" + ((com.tencent.mm.media.widget.camerarecordview.a.a)localObject).nJP + ']');
      if ((((com.tencent.mm.media.widget.camerarecordview.a.a)localObject).enable) && (((com.tencent.mm.media.widget.camerarecordview.a.a)localObject).bub())) {}
      for (;;)
      {
        Log.i("MicroMsg.CameraContainerProcess", s.X("useDaemonRecorder ", Boolean.valueOf(bool)));
        localObject = com.tencent.mm.plugin.recordvideo.util.d.Obm;
        com.tencent.mm.plugin.recordvideo.util.d.BD(bool);
        AppMethodBeat.o(75361);
        return bool;
        bool = false;
      }
    }
    Object localObject = com.tencent.mm.plugin.recordvideo.util.d.Obm;
    com.tencent.mm.plugin.recordvideo.util.d.BD(false);
    Log.i("MicroMsg.CameraContainerProcess", "scene " + this.oaV.scene + " not use DaemonRecorder");
    AppMethodBeat.o(75361);
    return false;
  }
  
  protected final com.tencent.mm.media.widget.camerarecordview.a.a gHl()
  {
    return this.NGs;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.e.c gHm()
  {
    return this.NGu;
  }
  
  public com.tencent.mm.media.widget.camerarecordview.preview.b getCameraPreviewView()
  {
    return (com.tencent.mm.media.widget.camerarecordview.preview.b)this.GoC;
  }
  
  public Context getContext()
  {
    AppMethodBeat.i(75359);
    Context localContext = this.GoC.getContext();
    s.s(localContext, "previewPlugin.context");
    AppMethodBeat.o(75359);
    return localContext;
  }
  
  public VideoTransPara getDaemonVideoTransPara()
  {
    AppMethodBeat.i(75360);
    VideoTransPara localVideoTransPara = this.oaV.oXZ;
    s.s(localVideoTransPara, "configProvider.videoParam");
    AppMethodBeat.o(75360);
    return localVideoTransPara;
  }
  
  public com.tencent.mm.media.widget.camerarecordview.b.a getEncodeConfig()
  {
    AppMethodBeat.i(75358);
    com.tencent.mm.media.widget.camerarecordview.b.a locala = (com.tencent.mm.media.widget.camerarecordview.b.a)new b(this);
    AppMethodBeat.o(75358);
    return locala;
  }
  
  public com.tencent.mm.media.j.a getPreviewRenderer()
  {
    AppMethodBeat.i(279748);
    Object localObject;
    if (this.NGt) {
      if (this.NGu == null)
      {
        this.NGu = new com.tencent.mm.plugin.recordvideo.e.c();
        this.NGv = new com.tencent.mm.plugin.recordvideo.e.b();
        localObject = this.NGu;
        if (localObject != null) {
          ((com.tencent.mm.plugin.recordvideo.e.c)localObject).NQZ = ((m)new c(this));
        }
      }
    }
    while (this.NGt)
    {
      localObject = (com.tencent.mm.media.j.a)this.NGu;
      AppMethodBeat.o(279748);
      return localObject;
      this.NGu = null;
      this.NGv = null;
    }
    s.u((com.tencent.mm.media.widget.camerarecordview.d.a)this, "this");
    AppMethodBeat.o(279748);
    return null;
  }
  
  public com.tencent.mm.media.j.a getRecordRenderer()
  {
    AppMethodBeat.i(279750);
    if (this.NGt)
    {
      com.tencent.mm.media.j.a locala = (com.tencent.mm.media.j.a)this.NGv;
      AppMethodBeat.o(279750);
      return locala;
    }
    s.u((com.tencent.mm.media.widget.camerarecordview.d.a)this, "this");
    AppMethodBeat.o(279750);
    return null;
  }
  
  public int getRecordScene()
  {
    return this.oaV.scene;
  }
  
  public com.tencent.mm.media.widget.c.b getRecorder()
  {
    Object localObject = null;
    AppMethodBeat.i(182843);
    if (this.NGt)
    {
      VideoTransPara localVideoTransPara = getVideoTransPara();
      com.tencent.mm.media.j.a locala = (com.tencent.mm.media.j.a)this.NGv;
      EGLContext localEGLContext = getCameraPreviewView().getEGLContext();
      s.checkNotNull(localEGLContext);
      com.tencent.mm.plugin.recordvideo.e.c localc = this.NGu;
      if (localc == null) {}
      for (;;)
      {
        s.checkNotNull(localObject);
        localObject = (com.tencent.mm.media.widget.c.b)new com.tencent.mm.media.widget.c.c(localVideoTransPara, locala, localEGLContext, ((com.tencent.mm.media.g.d)localObject).nAF);
        AppMethodBeat.o(182843);
        return localObject;
        localObject = localc.bgF();
      }
    }
    s.u((com.tencent.mm.media.widget.camerarecordview.d.a)this, "this");
    AppMethodBeat.o(182843);
    return null;
  }
  
  public int getResolutionLimit()
  {
    AppMethodBeat.i(75357);
    if (h.isInit())
    {
      h localh = h.NHb;
      i = h.gHy();
      AppMethodBeat.o(75357);
      return i;
    }
    int i = this.oaV.nFY;
    AppMethodBeat.o(75357);
    return i;
  }
  
  public VideoTransPara getVideoTransPara()
  {
    AppMethodBeat.i(75355);
    if (h.isInit())
    {
      localObject = h.NHb;
      localObject = h.gHw();
      if ((localObject != null) && ((((VideoTransPara)localObject).width != this.NGp.width) || (((VideoTransPara)localObject).height != this.NGp.height)))
      {
        this.NGp.width = ((VideoTransPara)localObject).width;
        this.NGp.height = ((VideoTransPara)localObject).height;
      }
    }
    Object localObject = this.NGp;
    AppMethodBeat.o(75355);
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/recordvideo/config/CameraContainerProcess$getEncodeConfig$1", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getFilePath", "", "getRecordType", "", "getThumbPath", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.media.widget.camerarecordview.b.a
  {
    b(b paramb) {}
    
    public final int buc()
    {
      AppMethodBeat.i(75352);
      if (MultiProcessMMKV.getSingleDefault().getBoolean("mediacodec_create_error", false))
      {
        AppMethodBeat.o(75352);
        return 1;
      }
      if (h.isInit())
      {
        h localh = h.NHb;
        i = h.gHx();
        AppMethodBeat.o(75352);
        return i;
      }
      int i = this.NGw.oaV.recordType;
      AppMethodBeat.o(75352);
      return i;
    }
    
    public final String bud()
    {
      AppMethodBeat.i(75354);
      String str = this.NGw.oaV.thumbPath;
      s.s(str, "configProvider.thumbPath");
      AppMethodBeat.o(75354);
      return str;
    }
    
    public final String getFilePath()
    {
      AppMethodBeat.i(75353);
      String str = this.NGw.oaV.NId;
      s.s(str, "configProvider.inputVideoPath");
      AppMethodBeat.o(75353);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "width", "", "height"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements m<Integer, Integer, ah>
  {
    c(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.c.b
 * JD-Core Version:    0.7.0.1
 */