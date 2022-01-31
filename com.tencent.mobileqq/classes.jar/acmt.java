import android.os.Looper;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.ControlerCallback;
import com.tencent.mobileqq.filemanager.data.FilePreviewDataReporter;
import com.tencent.mobileqq.filemanager.widget.FileWebView;
import com.tencent.qphone.base.util.QLog;

public class acmt
  implements FilePreviewActivity.ControlerCallback
{
  public acmt(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if (this.a.c) {}
    do
    {
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_f_of_type_Long = System.currentTimeMillis();
      }
      this.a.c = true;
      if (!paramBoolean)
      {
        if ((paramString3 != null) && (paramString3.length() > 0)) {
          this.a.jdField_b_of_type_AndroidWidgetTextView.setText(paramString3);
        }
        for (;;)
        {
          this.a.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          this.a.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(null);
          this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          this.a.jdField_f_of_type_Boolean = true;
          this.a.stopTitleProgress();
          if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter != null)
          {
            this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_a_of_type_Boolean = false;
            this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_c_of_type_Long = (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_f_of_type_Long - this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_e_of_type_Long);
            this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_e_of_type_JavaLangString = String.valueOf(paramLong);
            this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.i = paramString3;
            this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_d_of_type_JavaLangString = paramString6;
            this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_d_of_type_Long = (System.currentTimeMillis() - this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_a_of_type_Long);
            this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.a();
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("<FileAssistant>FilePreviewActivity", 2, "OnCSReplay[false],retMsg[" + paramString3 + "]");
          return;
          this.a.jdField_b_of_type_AndroidWidgetTextView.setText("文档加载失败，请稍后重试。");
        }
      }
      this.a.h = paramString1;
      this.a.i = paramString2;
      this.a.jdField_f_of_type_JavaLangString = paramString4;
      this.a.g = paramString5;
      this.a.jdField_b_of_type_JavaLangString = ("http://" + paramString1 + ":" + paramString2 + "/ftn_doc_previewer/" + this.a.j);
      this.a.k = paramString6;
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_a_of_type_Boolean = true;
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.g = paramString4;
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.i = "";
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_f_of_type_Long = System.currentTimeMillis();
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_c_of_type_Long = (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_f_of_type_Long - this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_e_of_type_Long);
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_c_of_type_JavaLangString = paramString1;
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_f_of_type_JavaLangString = this.a.jdField_b_of_type_JavaLangString;
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_d_of_type_JavaLangString = paramString6;
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_d_of_type_Long = (System.currentTimeMillis() - this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_a_of_type_Long);
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.a();
      }
      if (this.a.jdField_b_of_type_JavaLangString == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("<FileAssistant>FilePreviewActivity", 2, "mPreviewUrl is null ,threadid[" + Thread.currentThread().getId() + "], mainId[" + Looper.getMainLooper().getThread().getId() + "]");
        }
        this.a.finish();
        return;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.loadUrl(this.a.jdField_b_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.i("<FileAssistant>FilePreviewActivity", 2, "time[" + System.currentTimeMillis() + "]OnCSReplay mWebView.loadUrl(" + this.a.jdField_b_of_type_JavaLangString + ")");
      }
    } while (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter == null);
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_e_of_type_Long = System.currentTimeMillis();
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.l = "2";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acmt
 * JD-Core Version:    0.7.0.1
 */