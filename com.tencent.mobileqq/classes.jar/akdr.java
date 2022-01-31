import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatManager.HotChatStateWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.werewolves.WerewolvesHandler;
import com.tencent.mobileqq.werewolves.WerewolvesHandler.Callback;
import java.util.List;
import tencent.im.oidb.cmd0x8ed.oidb_0x8ed.RspBody;

public class akdr
  implements WerewolvesHandler.Callback
{
  public akdr(WerewolvesHandler paramWerewolvesHandler, WerewolvesHandler.Callback paramCallback, HotChatInfo paramHotChatInfo) {}
  
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     akdr
 * JD-Core Version:    0.7.0.1
 */