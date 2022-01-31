import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.data.MessageForPLNews;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;

class adkr
  implements View.OnClickListener
{
  adkr(adkq paramadkq, MessageForPLNews paramMessageForPLNews, String paramString) {}
  
  public void onClick(View paramView)
  {
    paramView = (adks)paramView.getTag();
    if (paramView == null) {
      return;
    }
    paramView = new ProfileActivity.AllInOne(paramView.jdField_a_of_type_JavaLangString, 1);
    Intent localIntent = new Intent(this.jdField_a_of_type_Adkq.jdField_a_of_type_AndroidContentContext, PersonalityLabelGalleryActivity.class);
    localIntent.putExtra("personality_label_allinone", paramView);
    localIntent.putExtra("fromType", 2);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqDataMessageForPLNews.frienduin);
    localIntent.putExtra("nickname", this.jdField_a_of_type_JavaLangString);
    if (!(this.jdField_a_of_type_Adkq.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    this.jdField_a_of_type_Adkq.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    awqx.b(this.jdField_a_of_type_Adkq.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x8009434", "0x8009434", 0, 0, "", "3", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adkr
 * JD-Core Version:    0.7.0.1
 */