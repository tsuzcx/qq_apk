import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.ocr.OCRRecognitionResultActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;

public class agfh
  implements ActionSheet.OnButtonClickListener
{
  public agfh(OCRRecognitionResultActivity paramOCRRecognitionResultActivity, ArrayList paramArrayList, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      paramView = (String)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      if (QLog.isColorLevel()) {
        QLog.i("OCRRecognitionResultActivity", 2, "selectLanguage: " + paramView + "    mLastLanguage: " + OCRRecognitionResultActivity.d(this.jdField_a_of_type_ComTencentMobileqqOcrOCRRecognitionResultActivity));
      }
      if (!TextUtils.equals(paramView, OCRRecognitionResultActivity.d(this.jdField_a_of_type_ComTencentMobileqqOcrOCRRecognitionResultActivity)))
      {
        OCRRecognitionResultActivity.d(this.jdField_a_of_type_ComTencentMobileqqOcrOCRRecognitionResultActivity, paramView);
        OCRRecognitionResultActivity.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRRecognitionResultActivity, paramView);
      }
    }
    if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agfh
 * JD-Core Version:    0.7.0.1
 */