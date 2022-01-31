import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class aakr
  extends ajuc
{
  public aakr(ChatSettingForTroop paramChatSettingForTroop) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, List<azrn> paramList, int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    while ((!paramBoolean1) || (paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    paramInt = 0;
    label31:
    azrn localazrn;
    if (paramInt < paramList.size())
    {
      localazrn = (azrn)paramList.get(paramInt);
      if ((localazrn != null) && (azzz.a(localazrn.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)))
      {
        if (localazrn.jdField_a_of_type_Long != 2L) {
          break label206;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nNewPhotoNum = localazrn.b;
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nUnreadMsgNum = localazrn.jdField_a_of_type_Int;
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
        if (paramBoolean2) {
          bfpr.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nUnreadMsgNum);
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "onUpdateTroopUnreadMsg| isPush = " + paramBoolean2 + ", " + localazrn);
      }
      paramInt += 1;
      break label31;
      break;
      label206:
      if (localazrn.jdField_a_of_type_Long == 1L)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nUnreadFileMsgnum = localazrn.jdField_a_of_type_Int;
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nNewFileMsgNum = localazrn.b;
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
      }
      else if (localazrn.jdField_a_of_type_Long == 1101236949L)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mNewTroopNotificationNum = localazrn.b;
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(9);
      }
      else if (localazrn.jdField_a_of_type_Long == 1106611799L)
      {
        Object localObject = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(19);
        ((Message)localObject).arg1 = localazrn.b;
        ((Message)localObject).sendToTarget();
        if ((localazrn.b == -1) || (localazrn.b > 0))
        {
          localObject = (ajtg)this.a.app.a(20);
          if (localObject != null) {
            ((ajtg)localObject).a(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, true, this.a.j, 3);
          }
        }
      }
      else if (localazrn.jdField_a_of_type_Long == 1106664488L)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nUnreadFileMsgnum = 1;
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nNewFileMsgNum = localazrn.b;
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aakr
 * JD-Core Version:    0.7.0.1
 */