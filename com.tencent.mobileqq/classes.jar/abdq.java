import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

public class abdq
  extends bblk
{
  public abdq(FriendProfileCardActivity paramFriendProfileCardActivity, int paramInt)
  {
    super(paramInt);
  }
  
  public void a()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.e == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (this.a.jdField_a_of_type_Abgw != null) {
        this.a.jdField_a_of_type_Abgw.a(bool);
      }
      VasWebviewUtil.reportCommercialDrainage(this.a.app.getCurrentAccountUin(), "defaultcard", "click_customized", "", 1, 0, 0, "", "", "");
      this.a.b(3);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abdq
 * JD-Core Version:    0.7.0.1
 */