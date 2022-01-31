import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class afhx
  implements Runnable
{
  public afhx(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void run()
  {
    if ((!NetworkUtil.d(BaseApplication.getContext())) && (this.a.k)) {}
    byte[] arrayOfByte;
    long l;
    do
    {
      do
      {
        return;
      } while (NearbyPeopleProfileActivity.a(this.a) == null);
      arrayOfByte = NearbyPeopleProfileActivity.a(this.a).vSeed;
      l = NearbyPeopleProfileActivity.a(this.a).feedPreviewTime;
      if (this.a.jdField_a_of_type_Long > 0L)
      {
        NearbyProfileUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler, this.a.app, this.a.jdField_a_of_type_Long, null, this.a.d, arrayOfByte, l, true, this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Long);
        return;
      }
    } while (StringUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
    NearbyProfileUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler, this.a.app, 0L, this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.a.d, arrayOfByte, l, true, this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afhx
 * JD-Core Version:    0.7.0.1
 */