import com.tencent.mobileqq.richmedia.capture.view.CommonPatternInfo;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import java.io.File;

public class agxv
  implements Runnable
{
  public agxv(EffectsCameraCaptureView paramEffectsCameraCaptureView, boolean paramBoolean, CommonPatternInfo paramCommonPatternInfo) {}
  
  public void run()
  {
    String str1;
    String str2;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.a != null)
    {
      if (!this.jdField_a_of_type_Boolean) {
        break label114;
      }
      str1 = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCommonPatternInfo.e + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCommonPatternInfo.c + File.separator;
      str2 = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCommonPatternInfo.e + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCommonPatternInfo.b + File.separator;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.a.a(str1, str2);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.a.b();
      return;
      label114:
      str1 = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCommonPatternInfo.e + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCommonPatternInfo.c + File.separator;
      str2 = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCommonPatternInfo.e + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCommonPatternInfo.b + File.separator;
      String str3 = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCommonPatternInfo.e + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCommonPatternInfo.d + File.separator;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.a.a(str1, str2, str3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     agxv
 * JD-Core Version:    0.7.0.1
 */