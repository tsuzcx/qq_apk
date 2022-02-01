import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.mobileqq.activity.VerifyPhoneNumActivity;
import com.tencent.qphone.base.util.QLog;

class adld
  extends azip
{
  adld(adlb paramadlb) {}
  
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
        adlb.a(this.a, true);
        adlb.b(this.a);
      }
      do
      {
        return;
        if ((!paramBoolean3) || (TextUtils.isEmpty(paramString))) {
          break;
        }
        adlb.a(this.a);
      } while (adlb.a(this.a) == null);
      Intent localIntent = new Intent(adlb.a(this.a), VerifyPhoneNumActivity.class);
      localIntent.putExtra("phonenum", this.a.a);
      localIntent.putExtra("key", this.a.b);
      localIntent.putExtra("uin", adlb.a(this.a));
      localIntent.putExtra("key_register_sign", adlb.a(this.a));
      localIntent.putExtra("key_register_binduin", paramString);
      adlb.a(this.a).startActivity(localIntent);
      adlb.a(this.a).finish();
      return;
      adlb.b(this.a);
      return;
    }
    adlb.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adld
 * JD-Core Version:    0.7.0.1
 */