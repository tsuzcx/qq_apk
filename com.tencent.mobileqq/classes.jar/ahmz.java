import com.tencent.mobileqq.richmedia.capture.view.SplitEffectsCameraCaptureView;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.RenderBuffer;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;

public class ahmz
  implements Runnable
{
  public ahmz(SplitEffectsCameraCaptureView paramSplitEffectsCameraCaptureView) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer = new RenderBuffer(this.a.f, this.a.g, 33984);
    this.a.k = this.a.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.a();
    if ((this.a.h) && (this.a.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.a(this.a.f, this.a.g, this.a.getWidth(), this.a.getHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahmz
 * JD-Core Version:    0.7.0.1
 */