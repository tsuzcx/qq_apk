import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ahlk
  implements Camera.AutoFocusCallback
{
  public ahlk(CameraCaptureView paramCameraCaptureView, File paramFile, int paramInt, boolean paramBoolean) {}
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "requestFocus when capture : " + paramBoolean);
    }
    CameraCaptureView.a().a(this.jdField_a_of_type_JavaIoFile, new Rect(0, 0, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.b), this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahlk
 * JD-Core Version:    0.7.0.1
 */