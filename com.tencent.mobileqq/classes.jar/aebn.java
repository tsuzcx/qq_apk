import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import com.tencent.mobileqq.werewolves.WerewolvesHandler;
import java.util.List;

class aebn
  implements View.OnClickListener
{
  aebn(aebm paramaebm, int paramInt, WerewolvesHandler paramWerewolvesHandler) {}
  
  public void onClick(View paramView)
  {
    try
    {
      long l = Long.parseLong(((aebl)this.jdField_a_of_type_Aebm.a.a.get(this.jdField_a_of_type_Int)).a);
      this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHandler.a(this.jdField_a_of_type_Aebm.a.b, l, null);
      this.jdField_a_of_type_Aebm.a.a("invite_page", "kick_out");
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aebn
 * JD-Core Version:    0.7.0.1
 */