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

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/config/AppCameraContainerProcess;", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "recordVideoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "previewPlugin", "Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;", "videoPath", "", "(Lcom/tencent/mm/modelcontrol/VideoTransPara;Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;Ljava/lang/String;)V", "getPreviewPlugin", "()Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;", "setPreviewPlugin", "(Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;)V", "getRecordVideoTransPara", "()Lcom/tencent/mm/modelcontrol/VideoTransPara;", "setRecordVideoTransPara", "(Lcom/tencent/mm/modelcontrol/VideoTransPara;)V", "getVideoPath", "()Ljava/lang/String;", "setVideoPath", "(Ljava/lang/String;)V", "getCameraPreviewView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "getContext", "Landroid/content/Context;", "getEncodeConfig", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getRecordScene", "", "getResolutionLimit", "getVideoTransPara", "useCpuCrop", "", "Companion", "plugin-recordvideo_release"})
public final class a
  implements com.tencent.mm.media.widget.camerarecordview.d.a
{
  public static final a.a woR;
  private CameraPreviewGLSurfaceView rQU;
  public String videoPath;
  public VideoTransPara woQ;
  
  static
  {
    AppMethodBeat.i(75350);
    woR = new a.a((byte)0);
    AppMethodBeat.o(75350);
  }
  
  public a(VideoTransPara paramVideoTransPara, CameraPreviewGLSurfaceView paramCameraPreviewGLSurfaceView, String paramString)
  {
    AppMethodBeat.i(75349);
    this.woQ = paramVideoTransPara;
    this.rQU = paramCameraPreviewGLSurfaceView;
    this.videoPath = paramString;
    AppMethodBeat.o(75349);
  }
  
  public final boolean Nw()
  {
    return false;
  }
  
  public final boolean auW()
  {
    return false;
  }
  
  public final boolean auX()
  {
    return false;
  }
  
  public final boolean auY()
  {
    return false;
  }
  
  public final e getCameraPreviewView()
  {
    return (e)this.rQU;
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(75348);
    Context localContext = this.rQU.getContext();
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
      g localg = g.wpE;
      i = g.dvb();
      AppMethodBeat.o(75346);
      return i;
    }
    int i = this.woQ.width;
    AppMethodBeat.o(75346);
    return i;
  }
  
  public final VideoTransPara getVideoTransPara()
  {
    AppMethodBeat.i(75345);
    if (g.isInit())
    {
      localObject = g.wpE;
      localObject = g.duZ();
      if ((localObject != null) && ((((VideoTransPara)localObject).width != this.woQ.width) || (((VideoTransPara)localObject).height != this.woQ.height)))
      {
        this.woQ.width = ((VideoTransPara)localObject).width;
        this.woQ.height = ((VideoTransPara)localObject).height;
      }
    }
    Object localObject = this.woQ;
    AppMethodBeat.o(75345);
    return localObject;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/recordvideo/config/AppCameraContainerProcess$getEncodeConfig$1", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getFilePath", "", "getRecordType", "", "getThumbPath", "plugin-recordvideo_release"})
  public static final class b
    implements com.tencent.mm.media.widget.camerarecordview.b.a
  {
    public final int auM()
    {
      AppMethodBeat.i(75343);
      if (g.isInit())
      {
        g localg = g.wpE;
        int i = g.dva();
        AppMethodBeat.o(75343);
        return i;
      }
      AppMethodBeat.o(75343);
      return 2;
    }
    
    public final String auN()
    {
      AppMethodBeat.i(75344);
      String str = (String)n.b((CharSequence)this.woS.videoPath, new String[] { "." }).get(0) + "_thumb.jpg";
      AppMethodBeat.o(75344);
      return str;
    }
    
    public final String getFilePath()
    {
      return this.woS.videoPath;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.b.a
 * JD-Core Version:    0.7.0.1
 */