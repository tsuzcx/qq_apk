import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class ahcp
{
  private BaseActivity a;
  public QQAppInterface a;
  
  public ahcp(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a(RecentBaseData paramRecentBaseData, boolean paramBoolean)
  {
    if (paramRecentBaseData == null) {
      return;
    }
    ariz.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBoolean);
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    String str = paramRecentBaseData.a();
    if (paramBoolean) {}
    for (paramRecentBaseData = "1";; paramRecentBaseData = "0")
    {
      awqx.b(localQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_top_right", 0, 0, str, "4", paramRecentBaseData, "");
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahcp
 * JD-Core Version:    0.7.0.1
 */