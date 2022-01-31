import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.CaptureParam;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.RenderBuffer;
import java.util.Map;

public class ahqi
  implements Runnable
{
  public ahqi(CameraCaptureView paramCameraCaptureView) {}
  
  public void run()
  {
    if (!this.a.a.containsKey(CameraCaptureView.CaptureParam.b)) {
      this.a.a.put(CameraCaptureView.CaptureParam.b, new RenderBuffer(this.a.n, this.a.o, 33984));
    }
    this.a.d(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahqi
 * JD-Core Version:    0.7.0.1
 */