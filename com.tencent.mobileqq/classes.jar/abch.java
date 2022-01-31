import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.data.DynamicAvatar;
import com.tencent.mobileqq.util.DynamicFaceDrawable;

public class abch
  implements Runnable
{
  public abch(DynamicAvatarManager paramDynamicAvatarManager, DynamicFaceDrawable paramDynamicFaceDrawable, long paramLong) {}
  
  public void run()
  {
    DynamicAvatar localDynamicAvatar = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.a(this.jdField_a_of_type_ComTencentMobileqqUtilDynamicFaceDrawable.c, this.jdField_a_of_type_ComTencentMobileqqUtilDynamicFaceDrawable.a);
    if (localDynamicAvatar != null)
    {
      localDynamicAvatar.playTimeStamp = this.jdField_a_of_type_Long;
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.a(localDynamicAvatar);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     abch
 * JD-Core Version:    0.7.0.1
 */