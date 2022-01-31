import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.mobileqq.activity.VerifyPhoneNumActivity;
import com.tencent.qphone.base.util.QLog;

class aacb
  extends atog
{
  aacb(aabz paramaabz) {}
  
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
        aabz.a(this.a, true);
        aabz.b(this.a);
      }
      do
      {
        return;
        if ((!paramBoolean3) || (TextUtils.isEmpty(paramString))) {
          break;
        }
        aabz.a(this.a);
      } while (aabz.a(this.a) == null);
      Intent localIntent = new Intent(aabz.a(this.a), VerifyPhoneNumActivity.class);
      localIntent.putExtra("phonenum", this.a.a);
      localIntent.putExtra("key", this.a.b);
      localIntent.putExtra("uin", aabz.a(this.a));
      localIntent.putExtra("key_register_sign", aabz.a(this.a));
      localIntent.putExtra("key_register_binduin", paramString);
      aabz.a(this.a).startActivity(localIntent);
      aabz.a(this.a).finish();
      return;
      aabz.b(this.a);
      return;
    }
    aabz.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aacb
 * JD-Core Version:    0.7.0.1
 */