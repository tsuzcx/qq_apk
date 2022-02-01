import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadModule;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadResource;

public class akwy
  extends akwz
{
  bhyn jdField_a_of_type_Bhyn;
  PreloadModule jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadModule;
  PreloadResource jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadResource;
  
  public akwy(PreloadResource paramPreloadResource, PreloadModule paramPreloadModule, bhyn parambhyn)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadResource = paramPreloadResource;
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadModule = paramPreloadModule;
    this.jdField_a_of_type_Bhyn = parambhyn;
  }
  
  public void a(PreloadManager paramPreloadManager)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadResource != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadResource.handleFlowConfig(paramPreloadManager, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadModule, this.jdField_a_of_type_Bhyn);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akwy
 * JD-Core Version:    0.7.0.1
 */