import android.content.Intent;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.tools.ErrMsg;

class adxq
  extends WtloginObserver
{
  adxq(adxp paramadxp) {}
  
  public void onGetStViaSMSVerifyLogin(String paramString, long paramLong1, int paramInt1, long paramLong2, int paramInt2, byte[] paramArrayOfByte, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("AutoLoginHelper", 2, "OnGetStViaSMSVerifyLogin  userAccount = " + paramString + " ret=" + paramInt2);
      if (paramErrMsg != null) {
        QLog.d("AutoLoginHelper", 2, "OnGetStViaSMSVerifyLogin  errMsg = " + paramErrMsg.getMessage());
      }
    }
    if (paramInt2 == 0) {}
    do
    {
      return;
      adxp.a(this.a);
    } while (adxp.a(this.a) == null);
    paramString = new Intent(adxp.a(this.a), LoginActivity.class);
    paramString.putExtra("uin", adxp.a(this.a));
    paramString.putExtra("tab_index", MainFragment.b);
    paramString.addFlags(131072);
    adxp.a(this.a).startActivity(paramString);
    adxp.a(this.a).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adxq
 * JD-Core Version:    0.7.0.1
 */