package com.tencent.mm.plugin.recordvideo.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.c.b;
import com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView;
import com.tencent.mm.media.widget.camerarecordview.preview.e;
import com.tencent.mm.modelcontrol.VideoTransPara;
import d.g.b.k;
import d.l;
import d.n.n;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/config/AppCameraContainerProcess;", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "recordVideoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "previewPlugin", "Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;", "videoPath", "", "(Lcom/tencent/mm/modelcontrol/VideoTransPara;Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;Ljava/lang/String;)V", "getPreviewPlugin", "()Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;", "setPreviewPlugin", "(Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;)V", "getRecordVideoTransPara", "()Lcom/tencent/mm/modelcontrol/VideoTransPara;", "setRecordVideoTransPara", "(Lcom/tencent/mm/modelcontrol/VideoTransPara;)V", "getVideoPath", "()Ljava/lang/String;", "setVideoPath", "(Ljava/lang/String;)V", "getCameraPreviewView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "getContext", "Landroid/content/Context;", "getEncodeConfig", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getRecordScene", "", "getResolutionLimit", "getVideoTransPara", "useCpuCrop", "", "Companion", "plugin-recordvideo_release"})
public final class a
  implements com.tencent.mm.media.widget.camerarecordview.d.a
{
  public static final a vgf;
  private CameraPreviewGLSurfaceView vcT;
  public VideoTransPara vge;
  public String videoPath;
  
  static
  {
    AppMethodBeat.i(75350);
    vgf = new a((byte)0);
    AppMethodBeat.o(75350);
  }
  
  public a(VideoTransPara paramVideoTransPara, CameraPreviewGLSurfaceView paramCameraPreviewGLSurfaceView, String paramString)
  {
    AppMethodBeat.i(75349);
    this.vge = paramVideoTransPara;
    this.vcT = paramCameraPreviewGLSurfaceView;
    this.videoPath = paramString;
    AppMethodBeat.o(75349);
  }
  
  public final boolean Ny()
  {
    return false;
  }
  
  public final boolean aof()
  {
    return false;
  }
  
  public final boolean aog()
  {
    return false;
  }
  
  public final boolean aoh()
  {
    return false;
  }
  
  public final e getCameraPreviewView()
  {
    return (e)this.vcT;
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(75348);
    Context localContext = this.vcT.getContext();
    k.g(localContext, "previewPlugin.context");
    AppMethodBeat.o(75348);
    return localContext;
  }
  
  public final VideoTransPara getDaemonVideoTransPara()
  {
    AppMethodBeat.i(75351);
    VideoTransPara localVideoTransPara = getVideoTransPara();
    AppMethodBeat.o(75351);
    return localVideoTransPara;
  }
  
  public final com.tencent.mm.media.widget.camerarecordview.b.a getEncodeConfig()
  {
    AppMethodBeat.i(75347);
    com.tencent.mm.media.widget.camerarecordview.b.a locala = (com.tencent.mm.media.widget.camerarecordview.b.a)new b(this);
    AppMethodBeat.o(75347);
    return locala;
  }
  
  public final com.tencent.mm.media.i.a getPreviewRenderer()
  {
    return null;
  }
  
  public final com.tencent.mm.media.i.a getRecordRenderer()
  {
    return null;
  }
  
  public final int getRecordScene()
  {
    return 9;
  }
  
  public final b getRecorder()
  {
    return null;
  }
  
  public final int getResolutionLimit()
  {
    AppMethodBeat.i(75346);
    if (g.isInit())
    {
      g localg = g.vgS;
      i = g.dhu();
      AppMethodBeat.o(75346);
      return i;
    }
    int i = this.vge.width;
    AppMethodBeat.o(75346);
    return i;
  }
  
  public final VideoTransPara getVideoTransPara()
  {
    AppMethodBeat.i(75345);
    if (g.isInit())
    {
      localObject = g.vgS;
      localObject = g.dhs();
      if ((localObject != null) && ((((VideoTransPara)localObject).width != this.vge.width) || (((VideoTransPara)localObject).height != this.vge.height)))
      {
        this.vge.width = ((VideoTransPara)localObject).width;
        this.vge.height = ((VideoTransPara)localObject).height;
      }
    }
    Object localObject = this.vge;
    AppMethodBeat.o(75345);
    return localObject;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/config/AppCameraContainerProcess$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/recordvideo/config/AppCameraContainerProcess$getEncodeConfig$1", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getFilePath", "", "getRecordType", "", "getThumbPath", "plugin-recordvideo_release"})
  public static final class b
    implements com.tencent.mm.media.widget.camerarecordview.b.a
  {
    public final int anW()
    {
      AppMethodBeat.i(75343);
      if (g.isInit())
      {
        g localg = g.vgS;
        int i = g.dht();
        AppMethodBeat.o(75343);
        return i;
      }
      AppMethodBeat.o(75343);
      return 2;
    }
    
    public final String anX()
    {
      AppMethodBeat.i(75344);
      String str = (String)n.b((CharSequence)this.vgg.videoPath, new String[] { "." }).get(0) + "_thumb.jpg";
      AppMethodBeat.o(75344);
      return str;
    }
    
    public final String getFilePath()
    {
      return this.vgg.videoPath;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.b.a
 * JD-Core Version:    0.7.0.1
 */