package com.tencent.mm.plugin.recordvideo.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView;
import com.tencent.mm.modelcontrol.VideoTransPara;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/config/AppCameraContainerProcess;", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "recordVideoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "previewPlugin", "Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;", "videoPath", "", "(Lcom/tencent/mm/modelcontrol/VideoTransPara;Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;Ljava/lang/String;)V", "getPreviewPlugin", "()Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;", "setPreviewPlugin", "(Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;)V", "getRecordVideoTransPara", "()Lcom/tencent/mm/modelcontrol/VideoTransPara;", "setRecordVideoTransPara", "(Lcom/tencent/mm/modelcontrol/VideoTransPara;)V", "getVideoPath", "()Ljava/lang/String;", "setVideoPath", "(Ljava/lang/String;)V", "getCameraPreviewView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "getContext", "Landroid/content/Context;", "getEncodeConfig", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getRecordScene", "", "getResolutionLimit", "getVideoTransPara", "initCameraConfig", "", "useCpuCrop", "", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements com.tencent.mm.media.widget.camerarecordview.d.a
{
  public static final a.a NGo;
  private CameraPreviewGLSurfaceView GoC;
  public VideoTransPara NGp;
  public String videoPath;
  
  static
  {
    AppMethodBeat.i(75350);
    NGo = new a.a((byte)0);
    AppMethodBeat.o(75350);
  }
  
  public a(VideoTransPara paramVideoTransPara, CameraPreviewGLSurfaceView paramCameraPreviewGLSurfaceView, String paramString)
  {
    AppMethodBeat.i(75349);
    this.NGp = paramVideoTransPara;
    this.GoC = paramCameraPreviewGLSurfaceView;
    this.videoPath = paramString;
    AppMethodBeat.o(75349);
  }
  
  public final boolean aGe()
  {
    AppMethodBeat.i(279724);
    s.u(this, "this");
    AppMethodBeat.o(279724);
    return false;
  }
  
  public final boolean bun()
  {
    return false;
  }
  
  public final boolean buo()
  {
    AppMethodBeat.i(279710);
    s.u(this, "this");
    AppMethodBeat.o(279710);
    return false;
  }
  
  public final boolean bup()
  {
    AppMethodBeat.i(279728);
    s.u(this, "this");
    AppMethodBeat.o(279728);
    return false;
  }
  
  public final com.tencent.mm.media.widget.camerarecordview.preview.b getCameraPreviewView()
  {
    return (com.tencent.mm.media.widget.camerarecordview.preview.b)this.GoC;
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(75348);
    Context localContext = this.GoC.getContext();
    s.s(localContext, "previewPlugin.context");
    AppMethodBeat.o(75348);
    return localContext;
  }
  
  public final VideoTransPara getDaemonVideoTransPara()
  {
    AppMethodBeat.i(75351);
    VideoTransPara localVideoTransPara = com.tencent.mm.media.widget.camerarecordview.d.a.a.a(this);
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
    AppMethodBeat.i(279715);
    s.u(this, "this");
    AppMethodBeat.o(279715);
    return null;
  }
  
  public final com.tencent.mm.media.j.a getRecordRenderer()
  {
    AppMethodBeat.i(279717);
    s.u(this, "this");
    AppMethodBeat.o(279717);
    return null;
  }
  
  public final int getRecordScene()
  {
    return 9;
  }
  
  public final com.tencent.mm.media.widget.c.b getRecorder()
  {
    AppMethodBeat.i(279721);
    s.u(this, "this");
    AppMethodBeat.o(279721);
    return null;
  }
  
  public final int getResolutionLimit()
  {
    AppMethodBeat.i(75346);
    if (h.isInit())
    {
      h localh = h.NHb;
      i = h.gHy();
      AppMethodBeat.o(75346);
      return i;
    }
    int i = this.NGp.width;
    AppMethodBeat.o(75346);
    return i;
  }
  
  public final VideoTransPara getVideoTransPara()
  {
    AppMethodBeat.i(75345);
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
    AppMethodBeat.o(75345);
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/recordvideo/config/AppCameraContainerProcess$getEncodeConfig$1", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getFilePath", "", "getRecordType", "", "getThumbPath", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.media.widget.camerarecordview.b.a
  {
    b(a parama) {}
    
    public final int buc()
    {
      AppMethodBeat.i(75343);
      if (h.isInit())
      {
        h localh = h.NHb;
        int i = h.gHx();
        AppMethodBeat.o(75343);
        return i;
      }
      AppMethodBeat.o(75343);
      return 2;
    }
    
    public final String bud()
    {
      AppMethodBeat.i(75344);
      String str = s.X((String)n.a((CharSequence)this.NGq.videoPath, new String[] { "." }).get(0), "_thumb.jpg");
      AppMethodBeat.o(75344);
      return str;
    }
    
    public final String getFilePath()
    {
      return this.NGq.videoPath;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.c.a
 * JD-Core Version:    0.7.0.1
 */