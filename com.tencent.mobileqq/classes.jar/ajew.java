import com.tencent.mobileqq.troop.utils.TroopRobotManager.Callback;
import com.tencent.mobileqq.troop.widget.TroopAIORobotPanel;
import com.tencent.mobileqq.troop.widget.TroopAIORobotPanel.RobotPanelItemData;
import com.tencent.mobileqq.widget.QQToast;
import tencent.im.oidb.cmd0x934.cmd0x934.RspBody;

public class ajew
  implements TroopRobotManager.Callback
{
  public ajew(TroopAIORobotPanel paramTroopAIORobotPanel, TroopAIORobotPanel.RobotPanelItemData paramRobotPanelItemData) {}
  
  public void a(int paramInt, cmd0x934.RspBody paramRspBody)
  {
    if (paramInt == 0) {
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotPanel.getContext(), 1, "操作失败" + "", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajew
 * JD-Core Version:    0.7.0.1
 */