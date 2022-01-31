import com.tencent.mobileqq.armap.ARGLSurfaceView;
import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.armap.config.POICheckHander.Listener;
import com.tencent.mobileqq.armap.config.POIModelConfig;

public class abgd
  implements POICheckHander.Listener
{
  public abgd(ARMapActivity paramARMapActivity) {}
  
  public void a(POIModelConfig paramPOIModelConfig, long paramLong)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView != null) && (this.a.jdField_a_of_type_ComTencentMobileqqArmapMapARMapEngine != null) && (paramPOIModelConfig.isVaild())) {
      this.a.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView.queueEvent(new abge(this, paramLong, paramPOIModelConfig));
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView != null) && (this.a.jdField_a_of_type_ComTencentMobileqqArmapMapARMapEngine != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView.queueEvent(new abgf(this, paramString3, paramLong, paramString1, paramString2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abgd
 * JD-Core Version:    0.7.0.1
 */