import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class acld
  extends amab
{
  public acld(ChatSettingForTroop paramChatSettingForTroop) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, List<bcrz> paramList, int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    while ((!paramBoolean1) || (paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    paramInt = 0;
    label31:
    bcrz localbcrz;
    if (paramInt < paramList.size())
    {
      localbcrz = (bcrz)paramList.get(paramInt);
      if ((localbcrz != null) && (bdal.a(localbcrz.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)))
      {
        if (localbcrz.jdField_a_of_type_Long != 2L) {
          break label206;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nNewPhotoNum = localbcrz.b;
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nUnreadMsgNum = localbcrz.jdField_a_of_type_Int;
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
        if (paramBoolean2) {
          bizm.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nUnreadMsgNum);
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "onUpdateTroopUnreadMsg| isPush = " + paramBoolean2 + ", " + localbcrz);
      }
      paramInt += 1;
      break label31;
      break;
      label206:
      if (localbcrz.jdField_a_of_type_Long == 1L)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nUnreadFileMsgnum = localbcrz.jdField_a_of_type_Int;
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nNewFileMsgNum = localbcrz.b;
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
      }
      else if (localbcrz.jdField_a_of_type_Long == 1101236949L)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mNewTroopNotificationNum = localbcrz.b;
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(9);
      }
      else if (localbcrz.jdField_a_of_type_Long == 1106611799L)
      {
        Object localObject = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(19);
        ((Message)localObject).arg1 = localbcrz.b;
        ((Message)localObject).sendToTarget();
        if ((localbcrz.b == -1) || (localbcrz.b > 0))
        {
          localObject = (alzf)this.a.app.a(20);
          if (localObject != null) {
            ((alzf)localObject).a(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, true, this.a.j, 3);
          }
        }
      }
      else if (localbcrz.jdField_a_of_type_Long == 1106664488L)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nUnreadFileMsgnum = 1;
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nNewFileMsgNum = localbcrz.b;
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acld
 * JD-Core Version:    0.7.0.1
 */