import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.util.DynamicFaceDrawable;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.util.WeakReference;

public class abci
  implements Runnable
{
  public abci(DynamicAvatarManager paramDynamicAvatarManager, DynamicFaceDrawable paramDynamicFaceDrawable) {}
  
  public void run()
  {
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.a)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.a.remove(this.jdField_a_of_type_ComTencentMobileqqUtilDynamicFaceDrawable.b)) {
          return;
        }
        i = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.a.size() - 1;
        if (i >= 0)
        {
          if (((WeakReference)this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.a.get(i)).get() != null) {
            break label226;
          }
          this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.a.remove(i);
          break label226;
        }
        i = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.b.size() - 1;
        if (i >= 0)
        {
          WeakReference localWeakReference = (WeakReference)this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.b.remove(i);
          if ((localWeakReference == null) || (localWeakReference.get() == null) || (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.a.contains(localWeakReference))) {
            break label233;
          }
          boolean bool = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.a((DynamicFaceDrawable)localWeakReference.get());
          if (QLog.isColorLevel()) {
            QLog.i("Q.dynamicAvatar", 2, "onPlayFinished to play. result : " + bool);
          }
          if (bool) {
            this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.a.add(localWeakReference);
          }
          return;
        }
      }
      return;
      label226:
      i -= 1;
      continue;
      label233:
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     abci
 * JD-Core Version:    0.7.0.1
 */