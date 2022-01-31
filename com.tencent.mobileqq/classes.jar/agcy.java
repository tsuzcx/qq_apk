import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

public class agcy
  implements Handler.Callback
{
  public agcy(ProfileHeaderView paramProfileHeaderView) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(ProfileHeaderView.jdField_a_of_type_JavaLangString, 4, String.format(Locale.getDefault(), "mUICallback [%d]", new Object[] { Integer.valueOf(paramMessage.what) }));
    }
    if (ProfileHeaderView.d == paramMessage.what)
    {
      if (QLog.isColorLevel()) {
        QLog.d(ProfileHeaderView.jdField_a_of_type_JavaLangString, 2, "ProfileHeaderView handleMessage msg what is check tips time=" + this.a.c);
      }
      if ((this.a.b.get()) && (this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
        this.a.k(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
      }
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return true;
          if (ProfileHeaderView.f == paramMessage.what)
          {
            this.a.a(false);
            return true;
          }
          if (ProfileHeaderView.g != paramMessage.what) {
            break;
          }
          localObject = (View)this.a.jdField_a_of_type_JavaUtilHashMap.get("map_key_avatar_pendant");
        } while (!(localObject instanceof ImageView));
        localObject = (ImageView)localObject;
        paramMessage = (ExtensionInfo)paramMessage.obj;
        if ((paramMessage != null) && (paramMessage.isPendantValid()))
        {
          this.a.jdField_a_of_type_Long = paramMessage.pendantId;
          AvatarPendantManager localAvatarPendantManager = (AvatarPendantManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(45);
          ((ImageView)localObject).setVisibility(0);
          if (AvatarPendantUtil.a(this.a.jdField_a_of_type_Long))
          {
            localAvatarPendantManager.a(this.a.jdField_a_of_type_Long).a((View)localObject, 2, PendantInfo.c, paramMessage.uin, paramMessage.pendantDiyId);
            return true;
          }
          localAvatarPendantManager.a(this.a.jdField_a_of_type_Long).a((View)localObject, 1, PendantInfo.c, paramMessage.uin, paramMessage.pendantDiyId);
          return true;
        }
        ((ImageView)localObject).setVisibility(4);
        this.a.jdField_a_of_type_Long = 0L;
        return true;
        if (paramMessage.what == 1004)
        {
          this.a.d(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
          return true;
        }
      } while (paramMessage.what != 1005);
      localObject = (TextView)this.a.jdField_a_of_type_JavaUtilHashMap.get("map_key_medal_num");
    } while (localObject == null);
    ((TextView)localObject).setText((String)paramMessage.obj);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agcy
 * JD-Core Version:    0.7.0.1
 */