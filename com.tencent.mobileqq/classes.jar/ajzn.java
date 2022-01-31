import android.app.Activity;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.troop.widget.AvatarWallViewPagerAdapter;
import mqq.util.WeakReference;

public class ajzn
  implements Runnable
{
  public ajzn(AvatarWallViewPagerAdapter paramAvatarWallViewPagerAdapter, URLImageView paramURLImageView, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    Object localObject;
    Setting localSetting;
    do
    {
      do
      {
        return;
        localObject = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        localSetting = (Setting)((EntityManager)localObject).a(Setting.class, "troop_" + this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.jdField_a_of_type_JavaLangString);
        ((EntityManager)localObject).a();
      } while (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.jdField_a_of_type_MqqUtilWeakReference == null);
      localObject = (Activity)this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.jdField_a_of_type_MqqUtilWeakReference.get();
    } while ((localObject == null) || (((Activity)localObject).isFinishing()));
    ((Activity)localObject).runOnUiThread(new ajzo(this, localSetting));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajzn
 * JD-Core Version:    0.7.0.1
 */