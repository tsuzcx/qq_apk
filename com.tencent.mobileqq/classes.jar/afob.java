import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.ocr.OCRShareHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class afob
  implements ActionSheet.OnButtonClickListener
{
  int jdField_a_of_type_Int = -1;
  String jdField_a_of_type_JavaLangString = "";
  
  public afob(OCRShareHelper paramOCRShareHelper) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if ((OCRShareHelper.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRShareHelper) != null) && (OCRShareHelper.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRShareHelper).isShowing())) {
        OCRShareHelper.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRShareHelper).dismiss();
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        ReportController.b(null, "dc00898", "", "", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, 0, 0, "", "", "", "");
      }
      return;
      OCRShareHelper.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRShareHelper, 1, OCRShareHelper.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRShareHelper));
      this.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_JavaLangString = "0X80082EB";
      continue;
      OCRShareHelper.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRShareHelper, 2, OCRShareHelper.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRShareHelper));
      this.jdField_a_of_type_Int = 2;
      this.jdField_a_of_type_JavaLangString = "0X80082EC";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afob
 * JD-Core Version:    0.7.0.1
 */