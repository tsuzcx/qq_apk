package com.tencent.mm.plugin.recordvideo.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.c.b;
import com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView;
import com.tencent.mm.media.widget.camerarecordview.preview.e;
import com.tencent.mm.modelcontrol.VideoTransPara;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/config/AppCameraContainerProcess;", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "recordVideoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "previewPlugin", "Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;", "videoPath", "", "(Lcom/tencent/mm/modelcontrol/VideoTransPara;Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;Ljava/lang/String;)V", "getPreviewPlugin", "()Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;", "setPreviewPlugin", "(Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;)V", "getRecordVideoTransPara", "()Lcom/tencent/mm/modelcontrol/VideoTransPara;", "setRecordVideoTransPara", "(Lcom/tencent/mm/modelcontrol/VideoTransPara;)V", "getVideoPath", "()Ljava/lang/String;", "setVideoPath", "(Ljava/lang/String;)V", "getCameraPreviewView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "getContext", "Landroid/content/Context;", "getEncodeConfig", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getRecordScene", "", "getResolutionLimit", "getVideoTransPara", "initCameraConfig", "", "useCpuCrop", "", "Companion", "plugin-recordvideo_release"})
public final class a
  implements com.tencent.mm.media.widget.camerarecordview.d.a
{
  public static final a.a BML;
  public VideoTransPara BMK;
  public String videoPath;
  private CameraPreviewGLSurfaceView wcV;
  
  static
  {
    AppMethodBeat.i(75350);
    BML = new a.a((byte)0);
    AppMethodBeat.o(75350);
  }
  
  public a(VideoTransPara paramVideoTransPara, CameraPreviewGLSurfaceView paramCameraPreviewGLSurfaceView, String paramString)
  {
    AppMethodBeat.i(75349);
    this.BMK = paramVideoTransPara;
    this.wcV = paramCameraPreviewGLSurfaceView;
    this.videoPath = paramString;
    AppMethodBeat.o(75349);
  }
  
  public final boolean Zx()
  {
    return false;
  }
  
  public final boolean aQw()
  {
    return false;
  }
  
  public final boolean aQx()
  {
    return false;
  }
  
  public final boolean aQy()
  {
    return false;
  }
  
  public final e getCameraPreviewView()
  {
    return (e)this.wcV;
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(75348);
    Context localContext = this.wcV.getContext();
    p.g(localContext, "previewPlugin.context");
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
  
  public final com.tencent.mm.media.j.a getPreviewRenderer()
  {
    return null;
  }
  
  public final com.tencent.mm.media.j.a getRecordRenderer()
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
      g localg = g.BNx;
      i = g.eJA();
      AppMethodBeat.o(75346);
      return i;
    }
    int i = this.BMK.width;
    AppMethodBeat.o(75346);
    return i;
  }
  
  public final VideoTransPara getVideoTransPara()
  {
    AppMethodBeat.i(75345);
    if (g.isInit())
    {
      localObject = g.BNx;
      localObject = g.eJy();
      if ((localObject != null) && ((((VideoTransPara)localObject).width != this.BMK.width) || (((VideoTransPara)localObject).height != this.BMK.height)))
      {
        this.BMK.width = ((VideoTransPara)localObject).width;
        this.BMK.height = ((VideoTransPara)localObject).height;
      }
    }
    Object localObject = this.BMK;
    AppMethodBeat.o(75345);
    return localObject;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/recordvideo/config/AppCameraContainerProcess$getEncodeConfig$1", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getFilePath", "", "getRecordType", "", "getThumbPath", "plugin-recordvideo_release"})
  public static final class b
    implements com.tencent.mm.media.widget.camerarecordview.b.a
  {
    public final int aQm()
    {
      AppMethodBeat.i(75343);
      if (g.isInit())
      {
        g localg = g.BNx;
        int i = g.eJz();
        AppMethodBeat.o(75343);
        return i;
      }
      AppMethodBeat.o(75343);
      return 2;
    }
    
    public final String aQn()
    {
      AppMethodBeat.i(75344);
      String str = (String)n.b((CharSequence)this.BMM.videoPath, new String[] { "." }).get(0) + "_thumb.jpg";
      AppMethodBeat.o(75344);
      return str;
    }
    
    public final String getFilePath()
    {
      return this.BMM.videoPath;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.b.a
 * JD-Core Version:    0.7.0.1
 */