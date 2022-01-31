import android.text.TextUtils;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarInfo;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarInfo.OneUinHeadInfo;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarInfoObserver;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.data.DynamicAvatar;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class abje
  extends DynamicAvatarInfoObserver
{
  public abje(DynamicAvatarManager paramDynamicAvatarManager) {}
  
  protected void a(boolean paramBoolean1, DynamicAvatarInfo paramDynamicAvatarInfo, Long paramLong, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean2)
  {
    String str4 = DynamicAvatarManager.a(paramInt2, paramInt1, String.valueOf(paramLong), paramInt3);
    if (!paramBoolean1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.dynamicAvatar", 2, "onGetDynamicAvatarInfo not success: " + paramInt1 + " " + paramLong + " " + paramInt2);
      }
      DynamicAvatarManager.a(this.a, str4, null, null);
      return;
    }
    if ((paramDynamicAvatarInfo != null) && (paramDynamicAvatarInfo.a != null) && (!paramDynamicAvatarInfo.a.isEmpty())) {}
    for (paramDynamicAvatarInfo = DynamicAvatar.convertFrom((DynamicAvatarInfo.OneUinHeadInfo)paramDynamicAvatarInfo.a.get(0));; paramDynamicAvatarInfo = null)
    {
      if (paramDynamicAvatarInfo == null)
      {
        DynamicAvatarManager.a(this.a, str4, null, null);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.dynamicAvatar", 2, "onGetDynamicAvatarInfo: " + paramDynamicAvatarInfo);
      }
      String str2 = DynamicAvatarManager.a(paramInt2, paramInt3, paramDynamicAvatarInfo);
      String str3 = DynamicAvatarManager.a(paramInt2, 640, paramDynamicAvatarInfo);
      String str1 = str3;
      paramLong = str2;
      if (TextUtils.isEmpty(str2))
      {
        str1 = str3;
        paramLong = str2;
        if (paramBoolean2)
        {
          paramLong = DynamicAvatarManager.a(17, paramInt3, paramDynamicAvatarInfo);
          str1 = DynamicAvatarManager.a(17, 640, paramDynamicAvatarInfo);
        }
      }
      DynamicAvatarManager.a(this.a, str4, paramLong, str1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abje
 * JD-Core Version:    0.7.0.1
 */