import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadModule;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadResource;

public class akbf
  extends akbg
{
  bgod jdField_a_of_type_Bgod;
  PreloadModule jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadModule;
  PreloadResource jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadResource;
  
  public akbf(PreloadResource paramPreloadResource, PreloadModule paramPreloadModule, bgod parambgod)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadResource = paramPreloadResource;
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadModule = paramPreloadModule;
    this.jdField_a_of_type_Bgod = parambgod;
  }
  
  public void a(PreloadManager paramPreloadManager)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadResource != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadResource.handleFlowConfig(paramPreloadManager, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadModule, this.jdField_a_of_type_Bgod);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akbf
 * JD-Core Version:    0.7.0.1
 */