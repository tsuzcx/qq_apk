import android.graphics.SurfaceTexture;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.mediacodec.utils.ShortVideoExceptionReporter;
import com.tencent.qphone.base.util.QLog;

public class agxf
  implements Runnable
{
  public agxf(CameraCaptureView paramCameraCaptureView, SurfaceTexture paramSurfaceTexture) {}
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.updateTexImage();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.requestRender();
      return;
    }
    catch (Exception localException)
    {
      do
      {
        QLog.e("CameraCaptureView", 2, localException, new Object[0]);
      } while (CameraCaptureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView));
      ShortVideoExceptionReporter.a(localException);
      CameraCaptureView.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     agxf
 * JD-Core Version:    0.7.0.1
 */