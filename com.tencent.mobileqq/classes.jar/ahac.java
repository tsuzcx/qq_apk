import android.opengl.GLSurfaceView.EGLConfigChooser;
import android.opengl.GLSurfaceView.EGLContextFactory;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.FlowDecodeScreenSurfaceBase;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.FlowDecodeScreenSurfaceBase.EglHelper.FakeGLSurfaceView;

public class ahac
  implements FlowDecodeScreenSurfaceBase.EglHelper.FakeGLSurfaceView
{
  public ahac(FlowDecodeScreenSurfaceBase paramFlowDecodeScreenSurfaceBase) {}
  
  public GLSurfaceView.EGLConfigChooser a()
  {
    return new ahag(this.a, true);
  }
  
  public GLSurfaceView.EGLContextFactory a()
  {
    return new ahad(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahac
 * JD-Core Version:    0.7.0.1
 */