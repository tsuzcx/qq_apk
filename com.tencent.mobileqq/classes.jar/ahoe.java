import android.opengl.GLSurfaceView.EGLConfigChooser;
import android.opengl.GLSurfaceView.EGLContextFactory;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.FlowDecodeScreenSurfaceBase;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.FlowDecodeScreenSurfaceBase.EglHelper.FakeGLSurfaceView;

public class ahoe
  implements FlowDecodeScreenSurfaceBase.EglHelper.FakeGLSurfaceView
{
  public ahoe(FlowDecodeScreenSurfaceBase paramFlowDecodeScreenSurfaceBase) {}
  
  public GLSurfaceView.EGLConfigChooser a()
  {
    return new ahoi(this.a, true);
  }
  
  public GLSurfaceView.EGLContextFactory a()
  {
    return new ahof(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahoe
 * JD-Core Version:    0.7.0.1
 */