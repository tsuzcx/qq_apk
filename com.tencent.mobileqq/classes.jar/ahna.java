import android.graphics.SurfaceTexture;
import com.tencent.mobileqq.richmedia.capture.view.SplitEffectsCameraCaptureView;

public class ahna
  implements Runnable
{
  public ahna(SplitEffectsCameraCaptureView paramSplitEffectsCameraCaptureView, SurfaceTexture paramSurfaceTexture) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture == this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView.jdField_a_of_type_AndroidGraphicsSurfaceTexture)
    {
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.updateTexImage();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView.requestRender();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahna
 * JD-Core Version:    0.7.0.1
 */