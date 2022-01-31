import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.troop.utils.TroopRobotManager.Callback;
import com.tencent.mobileqq.widget.QQToast;
import tencent.im.oidb.cmd0x934.cmd0x934.RspBody;

public class ajxx
  implements TroopRobotManager.Callback
{
  public ajxx(TroopRobotManager paramTroopRobotManager, String paramString) {}
  
  public void a(int paramInt, cmd0x934.RspBody paramRspBody)
  {
    if (paramInt == 0) {
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopRobotManager.a.getApp(), 1, "操作失败" + "", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajxx
 * JD-Core Version:    0.7.0.1
 */