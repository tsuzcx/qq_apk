import android.content.Intent;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.tools.ErrMsg;

class aalp
  extends WtloginObserver
{
  aalp(aalo paramaalo) {}
  
  public void OnGetStViaSMSVerifyLogin(String paramString, long paramLong1, int paramInt1, long paramLong2, int paramInt2, byte[] paramArrayOfByte, ErrMsg paramErrMsg)
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
      aalo.a(this.a);
    } while (aalo.a(this.a) == null);
    paramString = new Intent(aalo.a(this.a), LoginActivity.class);
    paramString.putExtra("uin", aalo.a(this.a));
    paramString.putExtra("tab_index", MainFragment.b);
    paramString.addFlags(131072);
    aalo.a(this.a).startActivity(paramString);
    aalo.a(this.a).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aalp
 * JD-Core Version:    0.7.0.1
 */