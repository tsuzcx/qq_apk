import android.widget.RelativeLayout;
import com.tencent.mobileqq.customviews.PicProgressView;
import com.tencent.qphone.base.util.QLog;

class ahbf
  implements axqa
{
  ahbf(ahbe paramahbe, ahbj paramahbj, String paramString) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_Ahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null)
    {
      this.jdField_a_of_type_Ahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setVisibility(8);
      this.jdField_a_of_type_Ahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Ahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.b(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Ahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProcessor(null);
      ((RelativeLayout)this.jdField_a_of_type_Ahbj.jdField_a_of_type_AndroidViewView).removeView(this.jdField_a_of_type_Ahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
      this.jdField_a_of_type_Ahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
    }
  }
  
  public void a(axpx paramaxpx)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicItemBuilder", 2, "dealFileSaveUI onSaveComplete");
    }
    if (paramaxpx != null)
    {
      if (paramaxpx.jdField_a_of_type_Int != 0) {
        break label133;
      }
      axpy.a(this.jdField_a_of_type_Ahbe.a);
    }
    for (;;)
    {
      paramaxpx.jdField_a_of_type_Axpw.b(this);
      if (this.jdField_a_of_type_Ahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null)
      {
        this.jdField_a_of_type_Ahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setVisibility(8);
        this.jdField_a_of_type_Ahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Ahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.b(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Ahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProcessor(null);
        ((RelativeLayout)this.jdField_a_of_type_Ahbj.jdField_a_of_type_AndroidViewView).removeView(this.jdField_a_of_type_Ahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
        this.jdField_a_of_type_Ahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
      }
      return;
      label133:
      axpy.b(this.jdField_a_of_type_Ahbe.a);
    }
  }
  
  public void a(axpx paramaxpx, int paramInt)
  {
    if (this.jdField_a_of_type_Ahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null)
    {
      this.jdField_a_of_type_Ahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(paramInt);
      this.jdField_a_of_type_Ahbj.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.invalidate();
    }
  }
  
  public void b(axpx paramaxpx) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahbf
 * JD-Core Version:    0.7.0.1
 */