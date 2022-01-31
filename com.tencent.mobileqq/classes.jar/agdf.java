import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.avatar.dynamicavatar.VasFaceManager;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import java.util.HashMap;

public class agdf
  implements Runnable
{
  public agdf(ProfileHeaderView paramProfileHeaderView, ProfileActivity.AllInOne paramAllInOne, int paramInt, String paramString) {}
  
  public void run()
  {
    Object localObject = (ImageView)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.get("map_key_face");
    if ((localObject instanceof DynamicAvatarView))
    {
      ((DynamicAvatarView)localObject).setFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 200, true, true, true, false, 3);
      localObject = (View)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.get("map_key_face_stoke");
      if (localObject != null) {
        ((View)localObject).setVisibility(VasFaceManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agdf
 * JD-Core Version:    0.7.0.1
 */