import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.data.MessageForPLNews;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahds
  implements View.OnClickListener
{
  ahds(ahdr paramahdr, MessageForPLNews paramMessageForPLNews, String paramString) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (ahdt)paramView.getTag();
    if (localObject == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = new ProfileActivity.AllInOne(((ahdt)localObject).jdField_a_of_type_JavaLangString, 1);
      Intent localIntent = new Intent(this.jdField_a_of_type_Ahdr.jdField_a_of_type_AndroidContentContext, PersonalityLabelGalleryActivity.class);
      localIntent.putExtra("personality_label_allinone", (Parcelable)localObject);
      localIntent.putExtra("fromType", 2);
      localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqDataMessageForPLNews.frienduin);
      localIntent.putExtra("nickname", this.jdField_a_of_type_JavaLangString);
      if (!(this.jdField_a_of_type_Ahdr.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      this.jdField_a_of_type_Ahdr.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      bcst.b(this.jdField_a_of_type_Ahdr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x8009434", "0x8009434", 0, 0, "", "3", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahds
 * JD-Core Version:    0.7.0.1
 */