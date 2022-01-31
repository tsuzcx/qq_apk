import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;

public class ahpy
  implements Runnable
{
  public ahpy(CameraCaptureView paramCameraCaptureView) {}
  
  public void run()
  {
    Toast.makeText(BaseApplicationImpl.getContext(), "麦克风被禁用", 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahpy
 * JD-Core Version:    0.7.0.1
 */