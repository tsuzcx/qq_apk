import android.os.Looper;
import android.view.View;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.profile.ProfileShoppingPhotoInfo;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class aldp
  implements Runnable
{
  public aldp(ProfileCardMoreInfoView paramProfileCardMoreInfoView, Card paramCard) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a == null)) {}
    Object localObject;
    do
    {
      return;
      localObject = ProfileShoppingPhotoInfo.getPhotoInfo(this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a);
    } while (localObject == null);
    if ((!ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a)) || (this.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (this.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId == ProfileCardTemplate.h) || ("0".equals(((ProfileShoppingPhotoInfo)localObject).bindShoppingNo)))
    {
      localObject = (View)this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_JavaUtilHashMap.remove("map_key_shopping_photo");
      return;
    }
    new MqqHandler(Looper.getMainLooper()).post(new aldq(this, (ProfileShoppingPhotoInfo)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aldp
 * JD-Core Version:    0.7.0.1
 */