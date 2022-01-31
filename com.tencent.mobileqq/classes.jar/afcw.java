import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qphone.base.util.QLog;

public class afcw
  implements Runnable
{
  public afcw(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity, String paramString) {}
  
  public void run()
  {
    if (NearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity) != null)
    {
      NearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity).a(this.jdField_a_of_type_JavaLangString);
      return;
    }
    QLog.i("Q.nearby_people_card.", 1, "mDynamicAvatarDownloadManager is NULL!!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afcw
 * JD-Core Version:    0.7.0.1
 */