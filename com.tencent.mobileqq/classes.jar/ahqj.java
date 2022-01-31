import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.CaptureParam;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.RenderBuffer;
import java.util.Map;

public class ahqj
  implements Runnable
{
  public ahqj(CameraCaptureView paramCameraCaptureView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a.containsKey(CameraCaptureView.CaptureParam.c)) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a.put(CameraCaptureView.CaptureParam.c, new RenderBuffer(this.jdField_a_of_type_Int, this.b, 33984));
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a.containsKey(CameraCaptureView.CaptureParam.d)) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a.put(CameraCaptureView.CaptureParam.d, new RenderBuffer(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.f, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.g, 33984));
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a.containsKey(CameraCaptureView.CaptureParam.e)) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a.put(CameraCaptureView.CaptureParam.e, new RenderBuffer(this.c, this.d, 33984));
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a.containsKey(CameraCaptureView.CaptureParam.f)) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a.put(CameraCaptureView.CaptureParam.f, new RenderBuffer(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.h, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.i, 33984));
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.d(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahqj
 * JD-Core Version:    0.7.0.1
 */