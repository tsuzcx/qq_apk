import android.text.TextUtils;
import com.tencent.mobileqq.data.DynamicAvatar;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class alza
  extends alyy
{
  alza(alyz paramalyz) {}
  
  protected void a(boolean paramBoolean1, alyt paramalyt, Long paramLong, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean2)
  {
    String str4 = alyz.a(paramInt2, paramInt1, String.valueOf(paramLong), paramInt3);
    if (!paramBoolean1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.dynamicAvatar", 2, "onGetDynamicAvatarInfo not success: " + paramInt1 + " " + paramLong + " " + paramInt2);
      }
      alyz.a(this.a, str4, null, null);
      return;
    }
    if ((paramalyt != null) && (paramalyt.a != null) && (!paramalyt.a.isEmpty())) {}
    for (paramalyt = DynamicAvatar.convertFrom((alyu)paramalyt.a.get(0));; paramalyt = null)
    {
      if (paramalyt == null)
      {
        alyz.a(this.a, str4, null, null);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.dynamicAvatar", 2, "onGetDynamicAvatarInfo: " + paramalyt);
      }
      String str2 = alyz.a(paramInt2, paramInt3, paramalyt);
      String str3 = alyz.a(paramInt2, 640, paramalyt);
      String str1 = str3;
      paramLong = str2;
      if (TextUtils.isEmpty(str2))
      {
        str1 = str3;
        paramLong = str2;
        if (paramBoolean2)
        {
          paramLong = alyz.a(17, paramInt3, paramalyt);
          str1 = alyz.a(17, 640, paramalyt);
        }
      }
      alyz.a(this.a, str4, paramLong, str1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alza
 * JD-Core Version:    0.7.0.1
 */