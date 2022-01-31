import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarConfig;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarInfoHandler;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicUtils;
import com.tencent.mobileqq.data.DynamicAvatar;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.util.DynamicFaceDrawable;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class abjf
  implements Runnable
{
  public abjf(DynamicAvatarManager paramDynamicAvatarManager, DynamicFaceDrawable paramDynamicFaceDrawable, String paramString) {}
  
  public void run()
  {
    synchronized (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.c)
    {
      bool1 = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.c.contains(this.jdField_a_of_type_ComTencentMobileqqUtilDynamicFaceDrawable.jdField_b_of_type_MqqUtilWeakReference);
      if (bool1)
      {
        if (DynamicFaceDrawable.jdField_b_of_type_Boolean) {}
        synchronized (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.c)
        {
          this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.c.remove(this.jdField_a_of_type_ComTencentMobileqqUtilDynamicFaceDrawable.jdField_b_of_type_MqqUtilWeakReference);
          synchronized (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.d)
          {
            if (!this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.d.contains(this.jdField_a_of_type_ComTencentMobileqqUtilDynamicFaceDrawable.jdField_b_of_type_MqqUtilWeakReference)) {
              this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.d.add(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.d.size(), this.jdField_a_of_type_ComTencentMobileqqUtilDynamicFaceDrawable.jdField_b_of_type_MqqUtilWeakReference);
            }
            if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqUtilDynamicFaceDrawable.jdField_b_of_type_JavaLangString)) {
              if (!this.jdField_a_of_type_ComTencentMobileqqUtilDynamicFaceDrawable.g) {
                break label678;
              }
            }
          }
        }
      }
    }
    DynamicAvatar localDynamicAvatar;
    try
    {
      ??? = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.a(this.jdField_a_of_type_ComTencentMobileqqUtilDynamicFaceDrawable.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilDynamicFaceDrawable.jdField_a_of_type_JavaLangString);
      if ((??? != null) && ((this.jdField_a_of_type_ComTencentMobileqqUtilDynamicFaceDrawable.e == 1) || (this.jdField_a_of_type_ComTencentMobileqqUtilDynamicFaceDrawable.e == 0))) {
        if (this.jdField_a_of_type_ComTencentMobileqqUtilDynamicFaceDrawable.e == 0) {
          if (!DynamicAvatarManager.a(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager).i)
          {
            bool1 = true;
            if ((!bool1) || (!DynamicUtils.a(System.currentTimeMillis(), ((DynamicAvatar)???).playTimeStamp))) {
              break label402;
            }
            bool2 = true;
            if (!bool2) {
              break label414;
            }
            if (QLog.isColorLevel()) {
              QLog.i("Q.dynamicAvatar", 2, "oneDayOnce:" + bool1 + " playedSameDay:" + bool2 + " uin:" + this.jdField_a_of_type_JavaLangString);
            }
          }
        }
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      synchronized (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.c)
      {
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.c.remove(this.jdField_a_of_type_ComTencentMobileqqUtilDynamicFaceDrawable.jdField_b_of_type_MqqUtilWeakReference);
          return;
          localObject3 = finally;
          throw localObject3;
          localObject4 = finally;
          throw localObject4;
          localObject5 = finally;
          throw localObject5;
          localNullPointerException = localNullPointerException;
          if (QLog.isColorLevel()) {
            QLog.i("Q.dynamicAvatar", 2, localNullPointerException.getMessage(), localNullPointerException);
          }
          localDynamicAvatar = null;
          continue;
          bool1 = false;
          continue;
          if (!DynamicAvatarManager.a(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager).j) {
            bool1 = true;
          } else {
            bool1 = false;
          }
        }
        label402:
        boolean bool2 = false;
      }
    }
    label414:
    Setting localSetting = DynamicAvatarManager.a(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager, this.jdField_a_of_type_ComTencentMobileqqUtilDynamicFaceDrawable.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilDynamicFaceDrawable.jdField_a_of_type_JavaLangString);
    boolean bool1 = DynamicAvatarManager.a(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager, localDynamicAvatar, localSetting, this.jdField_a_of_type_ComTencentMobileqqUtilDynamicFaceDrawable.jdField_b_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.i("Q.dynamicAvatar", 2, "execute loadDynamicAvatarInfo runnable. isNeed2GetDynamicAvatarInfo: " + bool1);
    }
    if ((bool1) || (this.jdField_a_of_type_ComTencentMobileqqUtilDynamicFaceDrawable.g)) {
      try
      {
        ((DynamicAvatarInfoHandler)DynamicAvatarManager.a(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager).getBusinessHandler(97)).a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqUtilDynamicFaceDrawable.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqUtilDynamicFaceDrawable.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilDynamicFaceDrawable.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilDynamicFaceDrawable.d, this.jdField_a_of_type_ComTencentMobileqqUtilDynamicFaceDrawable.jdField_c_of_type_Boolean);
        return;
      }
      catch (Exception localException)
      {
        synchronized (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.c)
        {
          this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.c.remove(this.jdField_a_of_type_ComTencentMobileqqUtilDynamicFaceDrawable.jdField_b_of_type_MqqUtilWeakReference);
          return;
        }
      }
    }
    String str = DynamicAvatarManager.a(this.jdField_a_of_type_ComTencentMobileqqUtilDynamicFaceDrawable.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilDynamicFaceDrawable.d, (DynamicAvatar)???);
    ??? = DynamicAvatarManager.a(this.jdField_a_of_type_ComTencentMobileqqUtilDynamicFaceDrawable.jdField_b_of_type_Int, 640, (DynamicAvatar)???);
    if (QLog.isColorLevel()) {
      QLog.i("Q.dynamicAvatar", 2, "execute loadDynamicAvatarInfo runnable. url : " + str);
    }
    DynamicAvatarManager.a(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager, this.jdField_a_of_type_JavaLangString, str, (String)???);
    return;
    label678:
    DynamicAvatarManager.a(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqUtilDynamicFaceDrawable.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqUtilDynamicFaceDrawable.jdField_c_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abjf
 * JD-Core Version:    0.7.0.1
 */