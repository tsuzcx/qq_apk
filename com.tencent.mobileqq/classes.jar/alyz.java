import android.text.TextUtils;
import com.tencent.mobileqq.data.DynamicAvatar;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class alyz
  extends alyx
{
  alyz(alyy paramalyy) {}
  
  protected void a(boolean paramBoolean1, alys paramalys, Long paramLong, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean2)
  {
    String str4 = alyy.a(paramInt2, paramInt1, String.valueOf(paramLong), paramInt3);
    if (!paramBoolean1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.dynamicAvatar", 2, "onGetDynamicAvatarInfo not success: " + paramInt1 + " " + paramLong + " " + paramInt2);
      }
      alyy.a(this.a, str4, null, null);
      return;
    }
    if ((paramalys != null) && (paramalys.a != null) && (!paramalys.a.isEmpty())) {}
    for (paramalys = DynamicAvatar.convertFrom((alyt)paramalys.a.get(0));; paramalys = null)
    {
      if (paramalys == null)
      {
        alyy.a(this.a, str4, null, null);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.dynamicAvatar", 2, "onGetDynamicAvatarInfo: " + paramalys);
      }
      String str2 = alyy.a(paramInt2, paramInt3, paramalys);
      String str3 = alyy.a(paramInt2, 640, paramalys);
      String str1 = str3;
      paramLong = str2;
      if (TextUtils.isEmpty(str2))
      {
        str1 = str3;
        paramLong = str2;
        if (paramBoolean2)
        {
          paramLong = alyy.a(17, paramInt3, paramalys);
          str1 = alyy.a(17, 640, paramalys);
        }
      }
      alyy.a(this.a, str4, paramLong, str1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alyz
 * JD-Core Version:    0.7.0.1
 */