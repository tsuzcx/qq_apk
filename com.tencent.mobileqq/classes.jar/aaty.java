import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.businessCard.activity.CardPicGalleryActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import java.util.ArrayList;

public class aaty
  extends bajp
{
  public aaty(FriendProfileCardActivity paramFriendProfileCardActivity, int paramInt)
  {
    super(paramInt);
  }
  
  public void a()
  {
    Intent localIntent = new Intent(this.a, CardPicGalleryActivity.class);
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.b)) {
      localIntent.putExtra("extra_default", 2130844815);
    }
    localArrayList.add(this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.b);
    localIntent.putExtra("extra_mode", 2);
    localIntent.putExtra("is_from_mine_profile", true);
    localIntent.putStringArrayListExtra("business_card_pics", localArrayList);
    if (this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.e == 0) {}
    for (int i = this.a.jdField_a_of_type_Atwx.a.defaultCardId;; i = 0)
    {
      localIntent.putExtra("default_card_id", i);
      this.a.startActivity(localIntent);
      this.a.overridePendingTransition(2130772286, 0);
      this.a.b(1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaty
 * JD-Core Version:    0.7.0.1
 */