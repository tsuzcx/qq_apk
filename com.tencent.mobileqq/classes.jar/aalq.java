import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.mobileqq.activity.VerifyPhoneNumActivity;
import com.tencent.qphone.base.util.QLog;

class aalq
  extends aumg
{
  aalq(aalo paramaalo) {}
  
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
        aalo.a(this.a, true);
        aalo.b(this.a);
      }
      do
      {
        return;
        if ((!paramBoolean3) || (TextUtils.isEmpty(paramString))) {
          break;
        }
        aalo.a(this.a);
      } while (aalo.a(this.a) == null);
      Intent localIntent = new Intent(aalo.a(this.a), VerifyPhoneNumActivity.class);
      localIntent.putExtra("phonenum", this.a.a);
      localIntent.putExtra("key", this.a.b);
      localIntent.putExtra("uin", aalo.a(this.a));
      localIntent.putExtra("key_register_sign", aalo.a(this.a));
      localIntent.putExtra("key_register_binduin", paramString);
      aalo.a(this.a).startActivity(localIntent);
      aalo.a(this.a).finish();
      return;
      aalo.b(this.a);
      return;
    }
    aalo.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aalq
 * JD-Core Version:    0.7.0.1
 */