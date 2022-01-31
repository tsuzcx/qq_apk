import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.capture.fragment.CameraCaptureFragment;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.PhotoCaptureResult;

public class ahic
  implements Runnable
{
  public ahic(CameraCaptureFragment paramCameraCaptureFragment, CameraCaptureView.PhotoCaptureResult paramPhotoCaptureResult) {}
  
  public void run()
  {
    Toast.makeText(BaseApplicationImpl.getContext(), "onPhotoCaptured : " + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$PhotoCaptureResult.a, 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahic
 * JD-Core Version:    0.7.0.1
 */