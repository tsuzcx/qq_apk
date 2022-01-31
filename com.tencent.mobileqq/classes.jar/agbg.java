import android.text.TextUtils;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ocr.OCRHandler;
import com.tencent.mobileqq.ocr.OCRRecognitionResultActivity;
import com.tencent.mobileqq.ocr.ui.OCRTextSearchActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class agbg
  implements ActionMode.Callback
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  
  public agbg(OCRRecognitionResultActivity paramOCRRecognitionResultActivity, TextView paramTextView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView == null) {}
    int i;
    int j;
    String str;
    do
    {
      return null;
      i = this.jdField_a_of_type_AndroidWidgetTextView.getSelectionStart();
      j = this.jdField_a_of_type_AndroidWidgetTextView.getSelectionEnd();
      str = this.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
    } while ((TextUtils.isEmpty(str)) || (i >= j) || (i < 0) || (j > str.length()));
    return str.substring(i, j);
  }
  
  public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131375615)
    {
      paramActionMode = a();
      if (QLog.isColorLevel()) {
        QLog.d("OCRRecognitionResultActivity", 2, "onLongClick translate " + paramActionMode);
      }
      if (TextUtils.isEmpty(paramActionMode)) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRRecognitionResultActivity, 1, "还未选中任何文字", 0).a();
      }
    }
    while (paramMenuItem.getItemId() != 2131375616)
    {
      return false;
      OCRRecognitionResultActivity.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRRecognitionResultActivity, paramActionMode);
      OCRRecognitionResultActivity.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRRecognitionResultActivity, 0, "正在翻译...");
      ((OCRHandler)this.jdField_a_of_type_ComTencentMobileqqOcrOCRRecognitionResultActivity.app.a(113)).a(paramActionMode);
      return true;
    }
    paramActionMode = a();
    if (QLog.isColorLevel()) {
      QLog.d("OCRRecognitionResultActivity", 2, "onLongClick search " + paramActionMode);
    }
    if (TextUtils.isEmpty(paramActionMode))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRRecognitionResultActivity, 1, "还未选中任何文字", 0).a();
      return false;
    }
    OCRTextSearchActivity.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRRecognitionResultActivity, paramActionMode);
    this.jdField_a_of_type_ComTencentMobileqqOcrOCRRecognitionResultActivity.overridePendingTransition(2131034132, 0);
    return true;
  }
  
  public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    paramActionMode = paramActionMode.getMenuInflater();
    if (paramActionMode != null) {
      paramActionMode.inflate(2131820547, paramMenu);
    }
    return true;
  }
  
  public void onDestroyActionMode(ActionMode paramActionMode) {}
  
  public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agbg
 * JD-Core Version:    0.7.0.1
 */