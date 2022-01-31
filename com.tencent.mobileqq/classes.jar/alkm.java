import android.text.TextUtils;
import com.tencent.mobileqq.data.DynamicAvatar;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class alkm
  extends alkk
{
  alkm(alkl paramalkl) {}
  
  protected void a(boolean paramBoolean1, alkf paramalkf, Long paramLong, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean2)
  {
    String str4 = alkl.a(paramInt2, paramInt1, String.valueOf(paramLong), paramInt3);
    if (!paramBoolean1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.dynamicAvatar", 2, "onGetDynamicAvatarInfo not success: " + paramInt1 + " " + paramLong + " " + paramInt2);
      }
      alkl.a(this.a, str4, null, null);
      return;
    }
    if ((paramalkf != null) && (paramalkf.a != null) && (!paramalkf.a.isEmpty())) {}
    for (paramalkf = DynamicAvatar.convertFrom((alkg)paramalkf.a.get(0));; paramalkf = null)
    {
      if (paramalkf == null)
      {
        alkl.a(this.a, str4, null, null);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.dynamicAvatar", 2, "onGetDynamicAvatarInfo: " + paramalkf);
      }
      String str2 = alkl.a(paramInt2, paramInt3, paramalkf);
      String str3 = alkl.a(paramInt2, 640, paramalkf);
      String str1 = str3;
      paramLong = str2;
      if (TextUtils.isEmpty(str2))
      {
        str1 = str3;
        paramLong = str2;
        if (paramBoolean2)
        {
          paramLong = alkl.a(17, paramInt3, paramalkf);
          str1 = alkl.a(17, 640, paramalkf);
        }
      }
      alkl.a(this.a, str4, paramLong, str1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alkm
 * JD-Core Version:    0.7.0.1
 */