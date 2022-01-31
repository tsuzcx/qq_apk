import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.mobileqq.businessCard.activity.FlowCameraPhotoActivity;
import com.tencent.mobileqq.businessCard.data.CardOCRInfo;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class abvf
  implements Runnable
{
  abvf(abve paramabve) {}
  
  public void run()
  {
    int k = 2;
    if ((this.a.a.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo != null) && (this.a.a.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo.jdField_a_of_type_Int != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.w("BusinessCard_FlowCameraPhotoActivity", 2, "ocr error " + this.a.a.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo.toString() + "errorCode=" + this.a.a.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo.jdField_a_of_type_Int);
      }
      this.a.a.e();
      BusinessCardUtils.a(this.a.a.app.getCurrentAccountUin(), this.a.a.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo.jdField_a_of_type_Int, -1, false, 0L);
      QQToast.a(this.a.a, 2131437099, 1).a();
      return;
    }
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("BusinessCard_FlowCameraPhotoActivity", 2, "ocr sucess! time: " + (l - this.a.a.jdField_a_of_type_Long) + " result:" + this.a.a.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo.toString());
    }
    if (this.a.a.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo != null) {
      if ((this.a.a.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo.b.size() <= 0) || (TextUtils.isEmpty((CharSequence)this.a.a.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo.b.get(0)))) {
        break label566;
      }
    }
    label554:
    label566:
    for (int i = 1;; i = 0)
    {
      if (!TextUtils.isEmpty(this.a.a.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo.jdField_a_of_type_JavaLangString)) {}
      for (int j = 1;; j = 0)
      {
        if ((j == 0) || (i == 0)) {
          if (j != 0) {
            i = k;
          }
        }
        for (;;)
        {
          BusinessCardUtils.a(this.a.a.app.getCurrentAccountUin(), 0, i, true, l - this.a.a.jdField_a_of_type_Long);
          this.a.a.e();
          this.a.a.g();
          Intent localIntent;
          if (this.a.a.e)
          {
            localIntent = this.a.a.getIntent();
            localIntent.putExtra("extra_return_ocr_info", this.a.a.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo);
            localIntent.putExtra("extra_need_report_edit", true);
            this.a.a.setResult(-1, localIntent);
          }
          for (;;)
          {
            if (this.a.a.isFinishing()) {
              break label554;
            }
            this.a.a.finish();
            return;
            if (i != 0)
            {
              i = 3;
              break;
            }
            i = 4;
            break;
            localIntent = new Intent(this.a.a, BusinessCardEditActivity.class);
            localIntent.putExtra("mode_type", 1);
            localIntent.putExtra("is_edit_mode", true);
            localIntent.putExtra("cur_ocr_info", this.a.a.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo);
            localIntent.putExtra("extra_need_report_edit", true);
            this.a.a.startActivity(localIntent);
          }
          break;
          i = 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abvf
 * JD-Core Version:    0.7.0.1
 */