import android.widget.RelativeLayout;
import com.tencent.mobileqq.customviews.PicProgressView;
import com.tencent.qphone.base.util.QLog;

class afwv
  implements auqb
{
  afwv(afwu paramafwu, afxa paramafxa, String paramString) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_Afxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null)
    {
      this.jdField_a_of_type_Afxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setVisibility(8);
      this.jdField_a_of_type_Afxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Afxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.b(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Afxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProcessor(null);
      ((RelativeLayout)this.jdField_a_of_type_Afxa.jdField_a_of_type_AndroidViewView).removeView(this.jdField_a_of_type_Afxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
      this.jdField_a_of_type_Afxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
    }
  }
  
  public void a(aupy paramaupy)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicItemBuilder", 2, "dealFileSaveUI onSaveComplete");
    }
    if (paramaupy != null)
    {
      if (paramaupy.jdField_a_of_type_Int != 0) {
        break label133;
      }
      aupz.a(this.jdField_a_of_type_Afwu.a);
    }
    for (;;)
    {
      paramaupy.jdField_a_of_type_Aupx.b(this);
      if (this.jdField_a_of_type_Afxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null)
      {
        this.jdField_a_of_type_Afxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setVisibility(8);
        this.jdField_a_of_type_Afxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Afxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.b(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Afxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProcessor(null);
        ((RelativeLayout)this.jdField_a_of_type_Afxa.jdField_a_of_type_AndroidViewView).removeView(this.jdField_a_of_type_Afxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
        this.jdField_a_of_type_Afxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
      }
      return;
      label133:
      aupz.b(this.jdField_a_of_type_Afwu.a);
    }
  }
  
  public void a(aupy paramaupy, int paramInt)
  {
    if (this.jdField_a_of_type_Afxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null)
    {
      this.jdField_a_of_type_Afxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(paramInt);
      this.jdField_a_of_type_Afxa.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.invalidate();
    }
  }
  
  public void b(aupy paramaupy) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afwv
 * JD-Core Version:    0.7.0.1
 */