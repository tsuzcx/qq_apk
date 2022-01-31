import android.opengl.GLSurfaceView.EGLConfigChooser;
import android.opengl.GLSurfaceView.EGLContextFactory;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.FlowDecodeScreenSurfaceBase;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.FlowDecodeScreenSurfaceBase.EglHelper.FakeGLSurfaceView;

public class ahsw
  implements FlowDecodeScreenSurfaceBase.EglHelper.FakeGLSurfaceView
{
  public ahsw(FlowDecodeScreenSurfaceBase paramFlowDecodeScreenSurfaceBase) {}
  
  public GLSurfaceView.EGLConfigChooser a()
  {
    return new ahta(this.a, true);
  }
  
  public GLSurfaceView.EGLContextFactory a()
  {
    return new ahsx(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahsw
 * JD-Core Version:    0.7.0.1
 */