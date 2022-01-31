import android.view.View;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import com.tencent.mobileqq.nearby.gameroom.RecentUserInvitePanel;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;

public class aeoj
  implements aepm
{
  public aeoj(GameRoomInviteActivity paramGameRoomInviteActivity) {}
  
  public void a(View paramView)
  {
    this.a.f();
    ReportController.b(this.a.app, "dc00899", "Grp_wolf", "", "invite_page", "clk_more", 0, 0, "", "", "", "");
  }
  
  public void a(View paramView, aepr paramaepr)
  {
    if (paramaepr.jdField_a_of_type_Boolean) {
      QQToast.a(this.a, 1, "已发送邀请链接~", 1).a();
    }
    do
    {
      return;
      GameRoomInviteActivity.a(this.a, paramaepr.jdField_a_of_type_JavaLangString, paramaepr.jdField_a_of_type_Int);
      paramaepr.jdField_a_of_type_Boolean = true;
      this.a.a.a(paramView, paramaepr.jdField_a_of_type_Boolean);
      if (paramaepr.jdField_a_of_type_Int == 1)
      {
        ReportController.b(this.a.app, "dc00899", "Grp_wolf", "", "invite_page", "clk_invite", 0, 0, "1", "", "", "");
        return;
      }
    } while (paramaepr.jdField_a_of_type_Int != 0);
    ReportController.b(this.a.app, "dc00899", "Grp_wolf", "", "invite_page", "clk_invite", 0, 0, "1", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeoj
 * JD-Core Version:    0.7.0.1
 */