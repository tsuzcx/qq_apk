import android.os.Handler;
import com.tencent.biz.common.util.OpenIdObserver;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.agent.BindGroupActivity;
import com.tencent.qphone.base.util.QLog;

public class aklh
  extends OpenIdObserver
{
  public aklh(BindGroupActivity paramBindGroupActivity) {}
  
  protected void a(boolean paramBoolean, OpenID paramOpenID)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BindGroupActivity", 2, "-->onGetOpenId, isSuccess: " + paramBoolean + " data: " + paramOpenID.toString());
    }
    if ((this.a.isFinishing()) || (this.a.jdField_c_of_type_Boolean)) {}
    do
    {
      return;
      this.a.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.hide();
      if (this.a.a != null) {
        this.a.a.removeCallbacksAndMessages(null);
      }
      if ((paramBoolean) && (paramOpenID != null) && (paramOpenID.openID != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("BindGroupActivity", 2, "openIdObserver success");
        }
        this.a.jdField_c_of_type_JavaLangString = paramOpenID.openID;
        if (!paramOpenID.openID.equals(this.a.jdField_b_of_type_JavaLangString))
        {
          this.a.b();
          return;
        }
        this.a.a();
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("BindGroupActivity", 2, "openIdObserver fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aklh
 * JD-Core Version:    0.7.0.1
 */