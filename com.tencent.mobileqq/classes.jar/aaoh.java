import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.arengine.ARCloudMarkerRecogResult;
import com.tencent.mobileqq.ar.arengine.ARMarkerResourceManager;
import com.tencent.mobileqq.ar.arengine.ARMarkerResourceManager.ARMarkerResourceCallback;
import com.tencent.mobileqq.ar.arengine.ARResourceManagerTools.ARResourceCallback;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;

public class aaoh
  implements ARResourceManagerTools.ARResourceCallback
{
  public aaoh(ARMarkerResourceManager paramARMarkerResourceManager, ARMarkerResourceManager.ARMarkerResourceCallback paramARMarkerResourceCallback, ArCloudConfigInfo paramArCloudConfigInfo, ARCloudMarkerRecogResult paramARCloudMarkerRecogResult) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager$ARMarkerResourceCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager$ARMarkerResourceCallback.o();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager$ARMarkerResourceCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager$ARMarkerResourceCallback.a(paramInt);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    int j = 0;
    int i = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager$ARMarkerResourceCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager$ARMarkerResourceCallback.a(paramBoolean, paramInt, this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo);
    }
    if (paramInt == 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager.jdField_d_of_type_Long = (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager.jdField_a_of_type_Long);
      localARMarkerResourceManager = this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager;
      if (paramBoolean)
      {
        paramInt = i;
        localARMarkerResourceManager.jdField_a_of_type_Int = paramInt;
      }
    }
    while (paramInt != 3) {
      for (;;)
      {
        return;
        paramInt = 1;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager.g = (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager.jdField_a_of_type_Long);
    ARMarkerResourceManager localARMarkerResourceManager = this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager;
    if (paramBoolean) {}
    for (paramInt = j;; paramInt = 1)
    {
      localARMarkerResourceManager.jdField_b_of_type_Int = paramInt;
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager$ARMarkerResourceCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager$ARMarkerResourceCallback.a(paramBoolean, this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo);
    }
    this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager.jdField_b_of_type_Long = System.currentTimeMillis();
    ARMarkerResourceManager localARMarkerResourceManager = this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localARMarkerResourceManager.jdField_d_of_type_Int = i;
      this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager.d();
      if (paramBoolean)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_b_of_type_Int != 1) {
          ARMarkerResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager, this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.a.a, this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudMarkerRecogResult);
        }
        ARMarkerResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager, this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaoh
 * JD-Core Version:    0.7.0.1
 */