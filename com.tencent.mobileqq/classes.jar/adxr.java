import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.mobileqq.activity.VerifyPhoneNumActivity;
import com.tencent.qphone.base.util.QLog;

class adxr
  extends azov
{
  adxr(adxp paramadxp) {}
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoLoginHelper", 2, "onUploadContact  isSuccess = " + paramBoolean);
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoLoginHelper", 2, "RegisterQQNumberActivity onGetBindUinWithPhone isSuccess = " + paramBoolean1 + "; isBindOk = " + paramBoolean2 + ";hadbind = " + paramBoolean3 + ";uin =" + paramString);
    }
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        adxp.a(this.a, true);
        adxp.b(this.a);
      }
      do
      {
        return;
        if ((!paramBoolean3) || (TextUtils.isEmpty(paramString))) {
          break;
        }
        adxp.a(this.a);
      } while (adxp.a(this.a) == null);
      Intent localIntent = new Intent(adxp.a(this.a), VerifyPhoneNumActivity.class);
      localIntent.putExtra("phonenum", this.a.a);
      localIntent.putExtra("key", this.a.b);
      localIntent.putExtra("uin", adxp.a(this.a));
      localIntent.putExtra("key_register_sign", adxp.a(this.a));
      localIntent.putExtra("key_register_binduin", paramString);
      adxp.a(this.a).startActivity(localIntent);
      adxp.a(this.a).finish();
      return;
      adxp.b(this.a);
      return;
    }
    adxp.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adxr
 * JD-Core Version:    0.7.0.1
 */