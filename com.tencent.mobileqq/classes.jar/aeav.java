import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import com.tencent.mobileqq.werewolves.WerewolvesHandler.Callback;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.RspBody;

public class aeav
  implements WerewolvesHandler.Callback
{
  public aeav(GameRoomInviteActivity paramGameRoomInviteActivity, aebl paramaebl) {}
  
  public void a(int paramInt, oidb_0x8e4.RspBody paramRspBody)
  {
    if ((paramInt == 0) && (paramRspBody != null))
    {
      paramRspBody = this.jdField_a_of_type_Aebl;
      if (!this.jdField_a_of_type_Aebl.a)
      {
        bool = true;
        paramRspBody.a = bool;
        this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomInviteActivity.a();
        this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomInviteActivity.a.notifyDataSetChanged();
      }
    }
    while (paramRspBody == null) {
      for (;;)
      {
        return;
        boolean bool = false;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomInviteActivity.a(paramInt, paramRspBody, "设置失败");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeav
 * JD-Core Version:    0.7.0.1
 */