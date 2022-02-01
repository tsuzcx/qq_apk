package com.tencent.mm.plugin.recordvideo.b;

import android.content.Context;
import android.opengl.EGLContext;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView;
import com.tencent.mm.media.widget.camerarecordview.preview.e;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.xlabeffect.XEffectConfig;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/config/CameraContainerProcess;", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "previewPlugin", "Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;", "(Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;)V", "getConfigProvider", "()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "setConfigProvider", "(Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;)V", "daemonChecker", "Lcom/tencent/mm/media/widget/camerarecordview/daemon/DaemonChecker;", "getDaemonChecker", "()Lcom/tencent/mm/media/widget/camerarecordview/daemon/DaemonChecker;", "setDaemonChecker", "(Lcom/tencent/mm/media/widget/camerarecordview/daemon/DaemonChecker;)V", "mute", "", "getMute", "()Z", "setMute", "(Z)V", "needEffect", "getPreviewPlugin", "()Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;", "setPreviewPlugin", "(Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;)V", "previewRenderer", "Lcom/tencent/mm/plugin/recordvideo/render/XEffectRenderer;", "getPreviewRenderer", "()Lcom/tencent/mm/plugin/recordvideo/render/XEffectRenderer;", "setPreviewRenderer", "(Lcom/tencent/mm/plugin/recordvideo/render/XEffectRenderer;)V", "recordVideoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "recorderRenderer", "Lcom/tencent/mm/plugin/recordvideo/render/RecorderTextureRenderer;", "getRecorderRenderer", "()Lcom/tencent/mm/plugin/recordvideo/render/RecorderTextureRenderer;", "setRecorderRenderer", "(Lcom/tencent/mm/plugin/recordvideo/render/RecorderTextureRenderer;)V", "getCameraPreviewView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "getContext", "Landroid/content/Context;", "getDaemonVideoTransPara", "getEncodeConfig", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRecordRenderer", "getRecordScene", "", "getRecorder", "Lcom/tencent/mm/media/widget/recorder/IMediaRecorder;", "getResolutionLimit", "getVideoTransPara", "initCameraConfig", "", "isMute", "useCpuCrop", "useDaemonRecorder", "Companion", "plugin-recordvideo_release"})
public class b
  implements com.tencent.mm.media.widget.camerarecordview.d.a
{
  public static final a HJw;
  private CameraPreviewGLSurfaceView ALD;
  public RecordConfigProvider ALV;
  private VideoTransPara HJp;
  private com.tencent.mm.media.widget.camerarecordview.a.a HJs;
  private final boolean HJt;
  private com.tencent.mm.plugin.recordvideo.c.b HJu;
  public com.tencent.mm.plugin.recordvideo.c.a HJv;
  public boolean lhf;
  
  static
  {
    AppMethodBeat.i(75363);
    HJw = new a((byte)0);
    AppMethodBeat.o(75363);
  }
  
  public b(RecordConfigProvider paramRecordConfigProvider, CameraPreviewGLSurfaceView paramCameraPreviewGLSurfaceView)
  {
    AppMethodBeat.i(75362);
    this.ALV = paramRecordConfigProvider;
    this.ALD = paramCameraPreviewGLSurfaceView;
    paramRecordConfigProvider = this.ALD.getContext();
    p.j(paramRecordConfigProvider, "previewPlugin.context");
    this.HJs = new com.tencent.mm.media.widget.camerarecordview.a.a(paramRecordConfigProvider);
    paramRecordConfigProvider = com.tencent.mm.plugin.recordvideo.e.d.IeU;
    paramRecordConfigProvider = this.ALV;
    p.k(paramRecordConfigProvider, "configProvider");
    if (TextUtils.isEmpty((CharSequence)paramRecordConfigProvider.HLi)) {
      paramRecordConfigProvider.HLi = com.tencent.mm.plugin.recordvideo.e.d.fzw();
    }
    if (TextUtils.isEmpty((CharSequence)paramRecordConfigProvider.HLh)) {
      paramRecordConfigProvider.HLh = com.tencent.mm.plugin.recordvideo.e.d.fzx();
    }
    if (TextUtils.isEmpty((CharSequence)paramRecordConfigProvider.HLf)) {
      paramRecordConfigProvider.HLf = com.tencent.mm.plugin.recordvideo.e.d.fzu();
    }
    com.tencent.mm.plugin.recordvideo.e.d.g(paramRecordConfigProvider);
    paramRecordConfigProvider = this.ALV.mfk.clone();
    if (paramRecordConfigProvider == null)
    {
      paramRecordConfigProvider = new t("null cannot be cast to non-null type com.tencent.mm.modelcontrol.VideoTransPara");
      AppMethodBeat.o(75362);
      throw paramRecordConfigProvider;
    }
    this.HJp = ((VideoTransPara)paramRecordConfigProvider);
    if (h.isInit())
    {
      paramRecordConfigProvider = h.HKf;
      paramRecordConfigProvider = h.fvI();
      if (paramRecordConfigProvider != null)
      {
        paramRecordConfigProvider = paramRecordConfigProvider.clone();
        if (paramRecordConfigProvider == null)
        {
          paramRecordConfigProvider = new t("null cannot be cast to non-null type com.tencent.mm.modelcontrol.VideoTransPara");
          AppMethodBeat.o(75362);
          throw paramRecordConfigProvider;
        }
        this.HJp = ((VideoTransPara)paramRecordConfigProvider);
      }
    }
    float f;
    if (this.ALV.HKQ == 1)
    {
      if (!h.isInit())
      {
        paramRecordConfigProvider = com.tencent.mm.plugin.recordvideo.model.a.HLt;
        int i = com.tencent.mm.plugin.recordvideo.model.a.getDisplayHeight();
        paramRecordConfigProvider = com.tencent.mm.plugin.recordvideo.model.a.HLt;
        int j = com.tencent.mm.plugin.recordvideo.model.a.fvZ();
        this.HJp.width = (j * this.HJp.height / i);
        Log.i("MicroMsg.CameraContainerProcess", "SightRecordConfig init failed, fix videoPara");
      }
      paramRecordConfigProvider = com.tencent.mm.media.b.b.kSf;
      if (!com.tencent.mm.media.b.b.aTW())
      {
        if (this.ALV.scene != 2) {
          break label468;
        }
        f = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vFP, 2.0F);
        this.HJp.videoBitrate = ((int)(this.HJp.videoBitrate * f));
        Log.i("MicroMsg.CameraContainerProcess", "final kbps: " + f + "  " + this.HJp.videoBitrate);
      }
    }
    if ((this.ALV.HLp.QPr) || (this.ALV.HLp.QPs)) {}
    for (boolean bool = true;; bool = false)
    {
      this.HJt = bool;
      Log.i("MicroMsg.CameraContainerProcess", "init CameraContainerProcess, scene: " + this.ALV.scene + "   " + this.HJp);
      AppMethodBeat.o(75362);
      return;
      label468:
      if (this.ALV.scene == 1)
      {
        f = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vFO, 2.0F);
        this.HJp.videoBitrate = ((int)(this.HJp.videoBitrate * f));
        Log.i("MicroMsg.CameraContainerProcess", "final kbps: " + f + "  " + this.HJp.videoBitrate);
        break;
      }
      this.HJp.videoBitrate = 8000000;
      Log.i("MicroMsg.CameraContainerProcess", "final kbps: $2  " + this.HJp.videoBitrate);
      break;
    }
  }
  
  protected final void a(com.tencent.mm.plugin.recordvideo.c.b paramb)
  {
    this.HJu = paramb;
  }
  
  public final boolean aZo()
  {
    AppMethodBeat.i(75356);
    Object localObject = com.tencent.mm.kernel.h.aHG();
    p.j(localObject, "MMKernel.storage()");
    localObject = ((f)localObject).aHp().get(ar.a.Vnh, Integer.valueOf(-1));
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(75356);
      throw ((Throwable)localObject);
    }
    int i = ((Integer)localObject).intValue();
    Log.i("MicroMsg.CameraContainerProcess", "cuttype : ".concat(String.valueOf(i)));
    if (i == 1)
    {
      localObject = com.tencent.mm.plugin.recordvideo.e.c.IeQ;
      com.tencent.mm.plugin.recordvideo.e.c.xb(false);
      AppMethodBeat.o(75356);
      return false;
    }
    if (i == 2)
    {
      localObject = com.tencent.mm.plugin.recordvideo.e.c.IeQ;
      com.tencent.mm.plugin.recordvideo.e.c.xb(true);
      AppMethodBeat.o(75356);
      return true;
    }
    if (MultiProcessMMKV.getSingleDefault().getBoolean("mediacodec_create_error", false))
    {
      localObject = com.tencent.mm.plugin.recordvideo.e.c.IeQ;
      com.tencent.mm.plugin.recordvideo.e.c.xb(true);
      AppMethodBeat.o(75356);
      return true;
    }
    if (h.isInit()) {
      localObject = h.HKf;
    }
    for (localObject = Boolean.valueOf(h.fvL());; localObject = this.ALV.HKP)
    {
      com.tencent.mm.plugin.recordvideo.e.c localc = com.tencent.mm.plugin.recordvideo.e.c.IeQ;
      p.j(localObject, "cpuCrop");
      com.tencent.mm.plugin.recordvideo.e.c.xb(((Boolean)localObject).booleanValue());
      boolean bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(75356);
      return bool;
    }
  }
  
  public final boolean aZp()
  {
    return false;
  }
  
  public boolean aZq()
  {
    boolean bool = true;
    AppMethodBeat.i(75361);
    if (aZo())
    {
      Log.i("MicroMsg.CameraContainerProcess", "useDaemonRecorder false");
      localObject = com.tencent.mm.plugin.recordvideo.e.c.IeQ;
      com.tencent.mm.plugin.recordvideo.e.c.xc(false);
      AppMethodBeat.o(75361);
      return false;
    }
    if ((this.ALV.scene == 2) || (this.ALV.scene == 1))
    {
      localObject = this.HJs;
      Log.i("MicroMsg.DaemonChecker", "info: enable:[" + ((com.tencent.mm.media.widget.camerarecordview.a.a)localObject).enable + "] ramConfig:[" + ((com.tencent.mm.media.widget.camerarecordview.a.a)localObject).lfd + "] blackModelList:[" + ((com.tencent.mm.media.widget.camerarecordview.a.a)localObject).lfe + ']');
      if ((((com.tencent.mm.media.widget.camerarecordview.a.a)localObject).enable) && (((com.tencent.mm.media.widget.camerarecordview.a.a)localObject).aZc())) {}
      for (;;)
      {
        Log.i("MicroMsg.CameraContainerProcess", "useDaemonRecorder ".concat(String.valueOf(bool)));
        localObject = com.tencent.mm.plugin.recordvideo.e.c.IeQ;
        com.tencent.mm.plugin.recordvideo.e.c.xc(bool);
        AppMethodBeat.o(75361);
        return bool;
        bool = false;
      }
    }
    Object localObject = com.tencent.mm.plugin.recordvideo.e.c.IeQ;
    com.tencent.mm.plugin.recordvideo.e.c.xc(false);
    Log.i("MicroMsg.CameraContainerProcess", "scene " + this.ALV.scene + " not use DaemonRecorder");
    AppMethodBeat.o(75361);
    return false;
  }
  
  public final boolean aeg()
  {
    return this.lhf;
  }
  
  protected final com.tencent.mm.media.widget.camerarecordview.a.a fvw()
  {
    return this.HJs;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.c.b fvx()
  {
    return this.HJu;
  }
  
  public e getCameraPreviewView()
  {
    return (e)this.ALD;
  }
  
  public Context getContext()
  {
    AppMethodBeat.i(75359);
    Context localContext = this.ALD.getContext();
    p.j(localContext, "previewPlugin.context");
    AppMethodBeat.o(75359);
    return localContext;
  }
  
  public VideoTransPara getDaemonVideoTransPara()
  {
    AppMethodBeat.i(75360);
    VideoTransPara localVideoTransPara = this.ALV.mfk;
    p.j(localVideoTransPara, "configProvider.videoParam");
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
    AppMethodBeat.i(216078);
    Object localObject;
    if (this.HJt) {
      if (this.HJu == null)
      {
        this.HJu = new com.tencent.mm.plugin.recordvideo.c.b();
        this.HJv = new com.tencent.mm.plugin.recordvideo.c.a();
        localObject = this.HJu;
        if (localObject != null) {
          ((com.tencent.mm.plugin.recordvideo.c.b)localObject).HUh = ((m)new c(this));
        }
      }
    }
    while (this.HJt)
    {
      localObject = (com.tencent.mm.media.j.a)this.HJu;
      AppMethodBeat.o(216078);
      return localObject;
      this.HJu = null;
      this.HJv = null;
    }
    AppMethodBeat.o(216078);
    return null;
  }
  
  public com.tencent.mm.media.j.a getRecordRenderer()
  {
    if (this.HJt) {
      return (com.tencent.mm.media.j.a)this.HJv;
    }
    return null;
  }
  
  public int getRecordScene()
  {
    return this.ALV.scene;
  }
  
  public com.tencent.mm.media.widget.c.b getRecorder()
  {
    Object localObject = null;
    AppMethodBeat.i(182843);
    if (this.HJt)
    {
      VideoTransPara localVideoTransPara = getVideoTransPara();
      com.tencent.mm.media.j.a locala = (com.tencent.mm.media.j.a)this.HJv;
      EGLContext localEGLContext = getCameraPreviewView().getEGLContext();
      if (localEGLContext == null) {
        p.iCn();
      }
      com.tencent.mm.plugin.recordvideo.c.b localb = this.HJu;
      if (localb != null) {
        localObject = localb.vcv;
      }
      if (localObject == null) {
        p.iCn();
      }
      localObject = (com.tencent.mm.media.widget.c.b)new com.tencent.mm.media.widget.c.c(localVideoTransPara, locala, localEGLContext, ((com.tencent.mm.media.g.d)localObject).kVj);
      AppMethodBeat.o(182843);
      return localObject;
    }
    AppMethodBeat.o(182843);
    return null;
  }
  
  public int getResolutionLimit()
  {
    AppMethodBeat.i(75357);
    if (h.isInit())
    {
      h localh = h.HKf;
      i = h.fvK();
      AppMethodBeat.o(75357);
      return i;
    }
    int i = this.ALV.laT;
    AppMethodBeat.o(75357);
    return i;
  }
  
  public VideoTransPara getVideoTransPara()
  {
    AppMethodBeat.i(75355);
    if (h.isInit())
    {
      localObject = h.HKf;
      localObject = h.fvI();
      if ((localObject != null) && ((((VideoTransPara)localObject).width != this.HJp.width) || (((VideoTransPara)localObject).height != this.HJp.height)))
      {
        this.HJp.width = ((VideoTransPara)localObject).width;
        this.HJp.height = ((VideoTransPara)localObject).height;
      }
    }
    Object localObject = this.HJp;
    AppMethodBeat.o(75355);
    return localObject;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/config/CameraContainerProcess$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/recordvideo/config/CameraContainerProcess$getEncodeConfig$1", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getFilePath", "", "getRecordType", "", "getThumbPath", "plugin-recordvideo_release"})
  public static final class b
    implements com.tencent.mm.media.widget.camerarecordview.b.a
  {
    public final int aZd()
    {
      AppMethodBeat.i(75352);
      if (MultiProcessMMKV.getSingleDefault().getBoolean("mediacodec_create_error", false))
      {
        AppMethodBeat.o(75352);
        return 1;
      }
      if (h.isInit())
      {
        h localh = h.HKf;
        i = h.fvJ();
        AppMethodBeat.o(75352);
        return i;
      }
      int i = this.HJx.ALV.recordType;
      AppMethodBeat.o(75352);
      return i;
    }
    
    public final String aZe()
    {
      AppMethodBeat.i(75354);
      String str = this.HJx.ALV.thumbPath;
      p.j(str, "configProvider.thumbPath");
      AppMethodBeat.o(75354);
      return str;
    }
    
    public final String getFilePath()
    {
      AppMethodBeat.i(75353);
      String str = this.HJx.ALV.HLf;
      p.j(str, "configProvider.inputVideoPath");
      AppMethodBeat.o(75353);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "width", "", "height", "invoke"})
  static final class c
    extends q
    implements m<Integer, Integer, x>
  {
    c(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.b.b
 * JD-Core Version:    0.7.0.1
 */