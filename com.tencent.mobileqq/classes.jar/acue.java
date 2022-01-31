import android.text.TextUtils;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabel;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;

public class acue
  extends awlr
{
  public acue(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void a(boolean paramBoolean, String paramString, PersonalityLabel paramPersonalityLabel, byte[] paramArrayOfByte, int paramInt)
  {
    if ((!TextUtils.equals(paramString, this.a.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a)) || (this.a.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard == null)) {}
    while (paramInt != 0) {
      return;
    }
    this.a.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.personalityLabel = paramPersonalityLabel;
    this.a.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.vPersonalityLabelV2 = paramArrayOfByte;
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.a.jdField_a_of_type_Awmk, true, new String[] { "map_key_personality_label_board" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acue
 * JD-Core Version:    0.7.0.1
 */