import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class aegg
  extends aojs
{
  public aegg(ChatSettingForTroop paramChatSettingForTroop) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, List<bhau> paramList, int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    while ((!paramBoolean1) || (paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    paramInt = 0;
    label31:
    bhau localbhau;
    if (paramInt < paramList.size())
    {
      localbhau = (bhau)paramList.get(paramInt);
      if ((localbhau != null) && (bhjx.a(localbhau.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)))
      {
        if (localbhau.jdField_a_of_type_Long != 2L) {
          break label206;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nNewPhotoNum = localbhau.b;
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nUnreadMsgNum = localbhau.jdField_a_of_type_Int;
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
        if (paramBoolean2) {
          bmtd.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nUnreadMsgNum);
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "onUpdateTroopUnreadMsg| isPush = " + paramBoolean2 + ", " + localbhau);
      }
      paramInt += 1;
      break label31;
      break;
      label206:
      if (localbhau.jdField_a_of_type_Long == 1L)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nUnreadFileMsgnum = localbhau.jdField_a_of_type_Int;
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nNewFileMsgNum = localbhau.b;
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
      }
      else if (localbhau.jdField_a_of_type_Long == 1101236949L)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mNewTroopNotificationNum = localbhau.b;
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(9);
      }
      else if (localbhau.jdField_a_of_type_Long == 1106611799L)
      {
        Object localObject = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(19);
        ((Message)localObject).arg1 = localbhau.b;
        ((Message)localObject).sendToTarget();
        if ((localbhau.b == -1) || (localbhau.b > 0))
        {
          localObject = (aoip)this.a.app.a(20);
          if (localObject != null) {
            ((aoip)localObject).a(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, true, this.a.j, 3);
          }
        }
      }
      else if (localbhau.jdField_a_of_type_Long == 1106664488L)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nUnreadFileMsgnum = 1;
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nNewFileMsgNum = localbhau.b;
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aegg
 * JD-Core Version:    0.7.0.1
 */