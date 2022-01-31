import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.data.Card;

public class abfh
  implements bfph
{
  public abfh(FriendProfileCardActivity paramFriendProfileCardActivity, String paramString1, String paramString2, int paramInt, boolean paramBoolean, bfpc parambfpc) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int i = 60;
    if (paramInt == 0)
    {
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, EditInfoActivity.class);
      paramView.putExtra("title", this.jdField_a_of_type_JavaLangString);
      paramView.putExtra("default_text", this.b);
      paramView.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqDataCard.uin);
      paramView.putExtra("edit_action", this.jdField_a_of_type_Int);
      paramView.putExtra("max_limit_mode", 1);
      paramView.putExtra("edit_type", 2);
      if (this.jdField_a_of_type_Boolean)
      {
        paramView.putExtra("max_num", 60);
        paramView.putExtra("isTroopNick", true);
        paramView.putExtra("troopUin", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.startActivityForResult(paramView, 1034);
      }
    }
    else
    {
      if (this.jdField_a_of_type_Bfpc != null) {
        this.jdField_a_of_type_Bfpc.dismiss();
      }
      return;
    }
    if (this.jdField_a_of_type_Int == 2) {}
    for (paramInt = i;; paramInt = 36)
    {
      paramView.putExtra("max_num", paramInt);
      paramView.putExtra("support_emotion", true);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abfh
 * JD-Core Version:    0.7.0.1
 */