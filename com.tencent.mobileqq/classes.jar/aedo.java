import android.os.Handler;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import tencent.im.oidb.cmd0x79a.oidb_0x79a.RspBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;

public class aedo
  implements nfc
{
  public aedo(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void a()
  {
    this.a.stopTitleProgress();
    if ((this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwAppPrivilegeFlag & 0x4000) != 0L) {
      TroopInfoActivity.h(this.a);
    }
  }
  
  public void a(oidb_0x79a.RspBody paramRspBody)
  {
    oidb_0x88d.GroupInfo localGroupInfo = paramRspBody.info;
    this.a.stopTitleProgress();
    this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeStatus = paramRspBody.uint32_tribe_status.get();
    this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.modifyCount = paramRspBody.uint32_modify_countdown.get();
    int j = 0;
    int i;
    if (4 != this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt)
    {
      i = j;
      if (3 != this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt) {}
    }
    else
    {
      i = j;
      if (localGroupInfo != null) {
        if (4 != localGroupInfo.uint32_group_type_flag.get())
        {
          i = j;
          if (3 != localGroupInfo.uint32_group_type_flag.get()) {}
        }
        else
        {
          this.a.a(localGroupInfo);
          i = 1;
        }
      }
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeStatus == 1) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeStatus == 2) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeStatus == 3))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId = paramRspBody.uint64_tribe_id.get();
      this.a.c = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId;
      this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeName = paramRspBody.str_tribe_name.get();
      if (i == 0) {
        this.a.a(localGroupInfo);
      }
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(7);
      return;
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwAppPrivilegeFlag & 0x4000) != 0L)
    {
      TroopInfoActivity.h(this.a);
      return;
    }
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aedo
 * JD-Core Version:    0.7.0.1
 */