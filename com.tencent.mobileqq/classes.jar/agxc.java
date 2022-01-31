import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;

public class agxc
  implements Runnable
{
  public agxc(CameraCaptureView paramCameraCaptureView) {}
  
  public void run()
  {
    Toast.makeText(BaseApplicationImpl.getContext(), "麦克风被禁用", 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     agxc
 * JD-Core Version:    0.7.0.1
 */