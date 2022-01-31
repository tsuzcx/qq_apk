import android.view.View;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import com.tencent.mobileqq.nearby.gameroom.RecentUserInvitePanel;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;

public class aebd
  implements aecg
{
  public aebd(GameRoomInviteActivity paramGameRoomInviteActivity) {}
  
  public void a(View paramView)
  {
    this.a.f();
    ReportController.b(this.a.app, "dc00899", "Grp_wolf", "", "invite_page", "clk_more", 0, 0, "", "", "", "");
  }
  
  public void a(View paramView, aecl paramaecl)
  {
    if (paramaecl.jdField_a_of_type_Boolean) {
      QQToast.a(this.a, 1, "已发送邀请链接~", 1).a();
    }
    do
    {
      return;
      GameRoomInviteActivity.a(this.a, paramaecl.jdField_a_of_type_JavaLangString, paramaecl.jdField_a_of_type_Int);
      paramaecl.jdField_a_of_type_Boolean = true;
      this.a.a.a(paramView, paramaecl.jdField_a_of_type_Boolean);
      if (paramaecl.jdField_a_of_type_Int == 1)
      {
        ReportController.b(this.a.app, "dc00899", "Grp_wolf", "", "invite_page", "clk_invite", 0, 0, "1", "", "", "");
        return;
      }
    } while (paramaecl.jdField_a_of_type_Int != 0);
    ReportController.b(this.a.app, "dc00899", "Grp_wolf", "", "invite_page", "clk_invite", 0, 0, "1", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aebd
 * JD-Core Version:    0.7.0.1
 */