import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

public class acup
  extends bdke
{
  public acup(FriendProfileCardActivity paramFriendProfileCardActivity, int paramInt)
  {
    super(paramInt);
  }
  
  public void a()
  {
    bcyw.a(this.a, this.a.app.getCurrentAccountUin(), "inside.myCardButton", 1, 3, 1, "", true);
    azmj.b(this.a.app, "CliOper", "", "", "card_mall", "0X8004DBF", 0, 0, "", "", "", "");
    VasWebviewUtil.reportCommercialDrainage(this.a.app.getCurrentAccountUin(), "defaultcard", "click_card_mine", "", 1, 0, 0, "", "", "");
    this.a.b(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acup
 * JD-Core Version:    0.7.0.1
 */