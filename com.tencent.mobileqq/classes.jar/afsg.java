import android.widget.RelativeLayout;
import com.tencent.mobileqq.customviews.PicProgressView;
import com.tencent.qphone.base.util.QLog;

class afsg
  implements auls
{
  afsg(afsf paramafsf, afsl paramafsl, String paramString) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_Afsl.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null)
    {
      this.jdField_a_of_type_Afsl.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setVisibility(8);
      this.jdField_a_of_type_Afsl.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Afsl.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.b(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Afsl.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProcessor(null);
      ((RelativeLayout)this.jdField_a_of_type_Afsl.jdField_a_of_type_AndroidViewView).removeView(this.jdField_a_of_type_Afsl.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
      this.jdField_a_of_type_Afsl.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
    }
  }
  
  public void a(aulp paramaulp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicItemBuilder", 2, "dealFileSaveUI onSaveComplete");
    }
    if (paramaulp != null)
    {
      if (paramaulp.jdField_a_of_type_Int != 0) {
        break label133;
      }
      aulq.a(this.jdField_a_of_type_Afsf.a);
    }
    for (;;)
    {
      paramaulp.jdField_a_of_type_Aulo.b(this);
      if (this.jdField_a_of_type_Afsl.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null)
      {
        this.jdField_a_of_type_Afsl.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setVisibility(8);
        this.jdField_a_of_type_Afsl.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Afsl.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.b(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Afsl.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProcessor(null);
        ((RelativeLayout)this.jdField_a_of_type_Afsl.jdField_a_of_type_AndroidViewView).removeView(this.jdField_a_of_type_Afsl.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
        this.jdField_a_of_type_Afsl.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
      }
      return;
      label133:
      aulq.b(this.jdField_a_of_type_Afsf.a);
    }
  }
  
  public void a(aulp paramaulp, int paramInt)
  {
    if (this.jdField_a_of_type_Afsl.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null)
    {
      this.jdField_a_of_type_Afsl.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(paramInt);
      this.jdField_a_of_type_Afsl.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.invalidate();
    }
  }
  
  public void b(aulp paramaulp) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afsg
 * JD-Core Version:    0.7.0.1
 */