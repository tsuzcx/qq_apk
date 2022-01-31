import android.widget.RelativeLayout;
import com.tencent.mobileqq.customviews.PicProgressView;
import com.tencent.qphone.base.util.QLog;

class adku
  implements aryp
{
  adku(adkt paramadkt, adla paramadla, String paramString) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_Adla.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null)
    {
      this.jdField_a_of_type_Adla.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setVisibility(8);
      this.jdField_a_of_type_Adla.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Adla.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.b(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Adla.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProcessor(null);
      ((RelativeLayout)this.jdField_a_of_type_Adla.jdField_a_of_type_AndroidViewView).removeView(this.jdField_a_of_type_Adla.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
      this.jdField_a_of_type_Adla.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
    }
  }
  
  public void a(arym paramarym)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicItemBuilder", 2, "dealFileSaveUI onSaveComplete");
    }
    if (paramarym != null)
    {
      if (paramarym.jdField_a_of_type_Int != 0) {
        break label133;
      }
      aryn.a(this.jdField_a_of_type_Adkt.a);
    }
    for (;;)
    {
      paramarym.jdField_a_of_type_Aryl.b(this);
      if (this.jdField_a_of_type_Adla.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null)
      {
        this.jdField_a_of_type_Adla.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setVisibility(8);
        this.jdField_a_of_type_Adla.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Adla.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.b(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Adla.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProcessor(null);
        ((RelativeLayout)this.jdField_a_of_type_Adla.jdField_a_of_type_AndroidViewView).removeView(this.jdField_a_of_type_Adla.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
        this.jdField_a_of_type_Adla.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
      }
      return;
      label133:
      aryn.b(this.jdField_a_of_type_Adkt.a);
    }
  }
  
  public void a(arym paramarym, int paramInt)
  {
    if (this.jdField_a_of_type_Adla.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null)
    {
      this.jdField_a_of_type_Adla.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(paramInt);
      this.jdField_a_of_type_Adla.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.invalidate();
    }
  }
  
  public void b(arym paramarym) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adku
 * JD-Core Version:    0.7.0.1
 */