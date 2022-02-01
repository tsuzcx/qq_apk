import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import java.util.List;

public class adse
  extends aofu
{
  public adse(ChatSettingForTroop paramChatSettingForTroop) {}
  
  protected void onUpdateTroopUnreadMsg(boolean paramBoolean1, boolean paramBoolean2, List<bgsx> paramList, int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    while ((!paramBoolean1) || (paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    paramInt = 0;
    label31:
    bgsx localbgsx;
    if (paramInt < paramList.size())
    {
      localbgsx = (bgsx)paramList.get(paramInt);
      if ((localbgsx != null) && (bhbx.a(localbgsx.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)))
      {
        if (localbgsx.jdField_a_of_type_Long != 2L) {
          break label206;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nNewPhotoNum = localbgsx.b;
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nUnreadMsgNum = localbgsx.jdField_a_of_type_Int;
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
        if (paramBoolean2) {
          QZoneHelper.sendBroadcastQunMsgUnreadCount(this.a, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nUnreadMsgNum);
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "onUpdateTroopUnreadMsg| isPush = " + paramBoolean2 + ", " + localbgsx);
      }
      paramInt += 1;
      break label31;
      break;
      label206:
      if (localbgsx.jdField_a_of_type_Long == 1L)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nUnreadFileMsgnum = localbgsx.jdField_a_of_type_Int;
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nNewFileMsgNum = localbgsx.b;
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
      }
      else if (localbgsx.jdField_a_of_type_Long == 1101236949L)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mNewTroopNotificationNum = localbgsx.b;
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(9);
      }
      else if (localbgsx.jdField_a_of_type_Long == 1106611799L)
      {
        Object localObject = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(19);
        ((Message)localObject).arg1 = localbgsx.b;
        ((Message)localObject).sendToTarget();
        if ((localbgsx.b == -1) || (localbgsx.b > 0))
        {
          localObject = (aoep)this.a.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
          if (localObject != null) {
            ((aoep)localObject).a(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, true, this.a.j, 3);
          }
        }
      }
      else if (localbgsx.jdField_a_of_type_Long == 1106664488L)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nUnreadFileMsgnum = 1;
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nNewFileMsgNum = localbgsx.b;
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adse
 * JD-Core Version:    0.7.0.1
 */