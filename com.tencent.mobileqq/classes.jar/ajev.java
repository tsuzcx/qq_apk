import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.troop.utils.TroopRobotManager.Callback;
import com.tencent.mobileqq.troop.widget.TroopAIORobotPanel;
import com.tencent.mobileqq.troop.widget.TroopAIORobotPanel.DataListAdapter;
import com.tencent.mobileqq.troop.widget.TroopAIORobotPanel.GetListDataCallback;
import com.tencent.mobileqq.troop.widget.TroopAIORobotPanel.RobotPanelListData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x934.cmd0x934.List;
import tencent.im.oidb.cmd0x934.cmd0x934.RspBody;

public class ajev
  implements TroopRobotManager.Callback
{
  public ajev(TroopAIORobotPanel paramTroopAIORobotPanel, int paramInt, String paramString1, String paramString2, String paramString3, TroopAIORobotPanel.GetListDataCallback paramGetListDataCallback) {}
  
  public void a(int paramInt, cmd0x934.RspBody paramRspBody)
  {
    boolean bool2 = false;
    if (paramInt == 0)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotPanel.a();
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TroopAIORobotPanel", 2, "troopRobotManager = null");
        }
        return;
      }
      paramInt = paramRspBody.version.get();
      if ((this.jdField_a_of_type_Int != paramInt) && (paramRspBody.robot_uin.get() == Long.parseLong(this.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotPanel.jdField_a_of_type_JavaLangString = this.b;
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotPanel.b = this.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotPanel.c = this.c;
        ((TroopRobotManager)localObject).a(this.b, this.jdField_a_of_type_JavaLangString, paramRspBody);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotPanel.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramRspBody.lists.size());
        paramInt = 0;
        while (paramInt < paramRspBody.lists.size())
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotPanel.jdField_a_of_type_JavaUtilArrayList.add(TroopAIORobotPanel.RobotPanelListData.a((cmd0x934.List)paramRspBody.lists.get(paramInt)));
          paramInt += 1;
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotPanel.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotPanel$DataListAdapter.c();
      }
      for (;;)
      {
        paramRspBody = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotPanel$GetListDataCallback;
        boolean bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotPanel.jdField_a_of_type_JavaUtilArrayList != null)
        {
          bool1 = bool2;
          if (!this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotPanel.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
            bool1 = true;
          }
        }
        paramRspBody.a(bool1, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotPanel.b);
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotPanel.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotPanel.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
        {
          localObject = ((TroopRobotManager)localObject).a(this.b, this.jdField_a_of_type_JavaLangString);
          if (localObject != null)
          {
            try
            {
              paramRspBody.mergeFrom((byte[])localObject);
              this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotPanel.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramRspBody.lists.size());
              paramInt = 0;
              while (paramInt < paramRspBody.lists.size())
              {
                this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotPanel.jdField_a_of_type_JavaUtilArrayList.add(TroopAIORobotPanel.RobotPanelListData.a((cmd0x934.List)paramRspBody.lists.get(paramInt)));
                paramInt += 1;
              }
              this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotPanel.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotPanel$DataListAdapter.c();
              this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotPanel.jdField_a_of_type_JavaLangString = this.b;
              this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotPanel.b = this.jdField_a_of_type_JavaLangString;
              this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotPanel.c = this.c;
            }
            catch (InvalidProtocolBufferMicroException paramRspBody) {}
            if (QLog.isColorLevel()) {
              QLog.d("TroopAIORobotPanel", 2, paramRspBody.getMessage());
            }
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotPanel.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotPanel$DataListAdapter.c();
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopAIORobotPanel", 2, "initData->reqPanelList: errorCode = " + paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotPanel$GetListDataCallback.a(false, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajev
 * JD-Core Version:    0.7.0.1
 */