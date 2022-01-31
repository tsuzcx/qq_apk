import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileShoppingPhotoInfo;
import com.tencent.mobileqq.profile.view.PhotoViewForShopping;

public class agcu
  implements Runnable
{
  public agcu(PhotoViewForShopping paramPhotoViewForShopping, ProfileCardInfo paramProfileCardInfo) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a != null))
    {
      ProfileShoppingPhotoInfo localProfileShoppingPhotoInfo = ProfileShoppingPhotoInfo.getPhotoInfo(this.jdField_a_of_type_ComTencentMobileqqProfileViewPhotoViewForShopping.a, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a);
      if ((localProfileShoppingPhotoInfo != null) && (PhotoViewForShopping.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewPhotoViewForShopping) != null))
      {
        Message localMessage = Message.obtain();
        localMessage.what = 200;
        localMessage.obj = localProfileShoppingPhotoInfo;
        PhotoViewForShopping.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewPhotoViewForShopping).sendMessage(localMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agcu
 * JD-Core Version:    0.7.0.1
 */