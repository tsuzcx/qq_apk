import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mobileqq.activity.VerifyCodeActivity;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.ServerNotifyObserver;

public class afjs
  extends ServerNotifyObserver
{
  public afjs(VerifyCodeActivity paramVerifyCodeActivity) {}
  
  public void onReceiveVerifyCode(String paramString1, int paramInt, String paramString2, byte[] paramArrayOfByte)
  {
    QLog.d("VerifyCodeActivity", 1, "onReceiveVerifyCode");
    this.a.b = false;
    if (this.a.jdField_a_of_type_Boolean)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setText("");
      QQToast.a(this.a.getApplicationContext(), 1, this.a.getString(2131719899), 0).a();
    }
    this.a.jdField_a_of_type_MqqObserverServerNotifyObserver.setKey(paramString1);
    this.a.jdField_a_of_type_MqqObserverServerNotifyObserver.setSeq(paramInt);
    this.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
    if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString() != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString().length() > 4)) {
      VerifyCodeActivity.a(this.a, true);
    }
    if (paramArrayOfByte != null)
    {
      this.a.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(bgyo.a(paramArrayOfByte, 0, paramArrayOfByte.length));
      this.a.a(false);
      return;
    }
    Toast.makeText(this.a.getApplicationContext(), this.a.getString(2131719896), 1).show();
  }
  
  public void onVerifyClose()
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     afjs
 * JD-Core Version:    0.7.0.1
 */