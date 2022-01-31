import com.tencent.mobileqq.werewolves.WerewolvesHandler;
import com.tencent.mobileqq.werewolves.WerewolvesHandler.Callback;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x8ed.oidb_0x8ed.RspBody;

public class akzq
  implements WerewolvesHandler.Callback
{
  public akzq(WerewolvesHandler paramWerewolvesHandler, WerewolvesHandler.Callback paramCallback) {}
  
  public void a(int paramInt, oidb_0x8ed.RspBody paramRspBody)
  {
    if (paramInt == 0) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WerewolvesHandler", 2, "startAnotherRound, quitFailed: errorCode :" + paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHandler$Callback.a(-1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akzq
 * JD-Core Version:    0.7.0.1
 */