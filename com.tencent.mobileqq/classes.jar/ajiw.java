import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopEntranceBar;

public class ajiw
  implements Runnable
{
  public ajiw(TroopEntranceBar paramTroopEntranceBar) {}
  
  public void run()
  {
    String str1 = "";
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
    {
      String str2 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
      AccountDetail localAccountDetail = PublicAccountUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);
      if (localAccountDetail != null) {
        str1 = localAccountDetail.uin;
      }
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_tribe", "", "interest_data", "exp_tribechat_aio", 0, 0, str2, str1, "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajiw
 * JD-Core Version:    0.7.0.1
 */