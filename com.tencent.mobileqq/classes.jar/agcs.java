import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.qphone.base.util.QLog;

class agcs
  extends naq
{
  agcs(agcf paramagcf) {}
  
  protected void a(boolean paramBoolean, OpenID paramOpenID)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MainAssistObserver", 2, "-->onGetOpenId, isSuccess: " + paramBoolean + " data: " + paramOpenID.toString() + " mOpenId = " + this.a.jdField_b_of_type_JavaLangString);
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.isFinishing()) || (this.a.c)) {}
    do
    {
      do
      {
        return;
        if (this.a.jdField_a_of_type_Bcqf != null) {
          this.a.jdField_a_of_type_Bcqf.hide();
        }
        if (this.a.jdField_b_of_type_AndroidOsHandler != null) {
          this.a.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        }
        if ((!paramBoolean) || (paramOpenID == null) || (paramOpenID.openID == null)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MainAssistObserver", 2, "openIdObserver success");
        }
      } while ((TextUtils.isEmpty(this.a.jdField_b_of_type_JavaLangString)) || (paramOpenID.openID.equals(this.a.jdField_b_of_type_JavaLangString)));
      this.a.i();
      return;
    } while (!QLog.isColorLevel());
    QLog.d("MainAssistObserver", 2, "openIdObserver fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agcs
 * JD-Core Version:    0.7.0.1
 */