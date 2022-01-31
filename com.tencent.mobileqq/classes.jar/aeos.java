import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager;
import com.tencent.mobileqq.nearby.profilecard.NearbyAuthVideoPlayerFragment;
import com.tencent.qphone.base.util.QLog;

public class aeos
  implements Runnable
{
  public aeos(NearbyAuthVideoPlayerFragment paramNearbyAuthVideoPlayerFragment, String paramString) {}
  
  public void run()
  {
    if (NearbyAuthVideoPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyAuthVideoPlayerFragment) != null)
    {
      NearbyAuthVideoPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyAuthVideoPlayerFragment).a(this.jdField_a_of_type_JavaLangString);
      return;
    }
    QLog.i("NearbyAuthVideoPlayerFragment", 1, "mDynamicAvatarDownloadManager is NULL!!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeos
 * JD-Core Version:    0.7.0.1
 */