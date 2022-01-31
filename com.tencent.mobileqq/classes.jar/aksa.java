import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatManager.HotChatStateWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.gameroom.GameRoomAVController;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.werewolves.WerewolvesHandler;
import com.tencent.mobileqq.werewolves.WerewolvesHandler.Callback;
import java.util.List;
import tencent.im.oidb.cmd0x8ed.oidb_0x8ed.RspBody;

public class aksa
  implements WerewolvesHandler.Callback
{
  public aksa(WerewolvesHandler paramWerewolvesHandler, WerewolvesHandler.Callback paramCallback1, HotChatInfo paramHotChatInfo, long paramLong, int paramInt1, int paramInt2, WerewolvesHandler.Callback paramCallback2) {}
  
  public void a(int paramInt, oidb_0x8ed.RspBody paramRspBody)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHandler$Callback != null) {
      this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHandler$Callback.a(paramInt, paramRspBody);
    }
    paramRspBody = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHandler.b.getManager(59);
    List localList = paramRspBody.a();
    if (localList != null) {
      localList.remove(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo);
    }
    paramRspBody.a(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_HOT_CHAT_IS_DISBANDED);
    GameRoomAVController.a().a(this.jdField_a_of_type_Long);
    NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHandler.b.getCurrentAccountUin(), "game_room_last_time", Long.valueOf(MessageCache.a()));
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.troopUin != null) && (!this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.troopUin.equals("0"))) {
      this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHandler.b.a().a(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.troopUin, 1);
    }
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHandler.b(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_ComTencentMobileqqWerewolvesWerewolvesHandler$Callback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aksa
 * JD-Core Version:    0.7.0.1
 */