import android.widget.RelativeLayout;
import com.tencent.mobileqq.customviews.PicProgressView;
import com.tencent.qphone.base.util.QLog;

class agqh
  implements axjj
{
  agqh(agqg paramagqg, agql paramagql, String paramString) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_Agql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null)
    {
      this.jdField_a_of_type_Agql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setVisibility(8);
      this.jdField_a_of_type_Agql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Agql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.b(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Agql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProcessor(null);
      ((RelativeLayout)this.jdField_a_of_type_Agql.jdField_a_of_type_AndroidViewView).removeView(this.jdField_a_of_type_Agql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
      this.jdField_a_of_type_Agql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
    }
  }
  
  public void a(axjg paramaxjg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicItemBuilder", 2, "dealFileSaveUI onSaveComplete");
    }
    if (paramaxjg != null)
    {
      if (paramaxjg.jdField_a_of_type_Int != 0) {
        break label133;
      }
      axjh.a(this.jdField_a_of_type_Agqg.a);
    }
    for (;;)
    {
      paramaxjg.jdField_a_of_type_Axjf.b(this);
      if (this.jdField_a_of_type_Agql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null)
      {
        this.jdField_a_of_type_Agql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setVisibility(8);
        this.jdField_a_of_type_Agql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Agql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.b(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Agql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProcessor(null);
        ((RelativeLayout)this.jdField_a_of_type_Agql.jdField_a_of_type_AndroidViewView).removeView(this.jdField_a_of_type_Agql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
        this.jdField_a_of_type_Agql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
      }
      return;
      label133:
      axjh.b(this.jdField_a_of_type_Agqg.a);
    }
  }
  
  public void a(axjg paramaxjg, int paramInt)
  {
    if (this.jdField_a_of_type_Agql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null)
    {
      this.jdField_a_of_type_Agql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(paramInt);
      this.jdField_a_of_type_Agql.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.invalidate();
    }
  }
  
  public void b(axjg paramaxjg) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agqh
 * JD-Core Version:    0.7.0.1
 */