import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.agent.report.ReportDef.RepUtil;

class adtw
  implements Runnable
{
  adtw(adtv paramadtv) {}
  
  public void run()
  {
    this.a.a.a(1004, ForwardAbility.ForwardAbilityType.b.intValue());
    Bundle localBundle = new Bundle();
    localBundle.putString("report_type", "102");
    localBundle.putString("act_type", "84");
    localBundle.putString("intext_1", "" + ReportDef.RepUtil.a(this.a.a.b));
    localBundle.putString("intext_2", "" + ReportDef.RepUtil.a(this.a.a.jdField_a_of_type_AndroidOsBundle.getInt("uintype"), this.a.a.jdField_a_of_type_AndroidOsBundle.getString("uin")));
    localBundle.putString("intext_3", "0");
    localBundle.putString("intext_4", "5");
    ReportCenter.a().a(localBundle, "", this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adtw
 * JD-Core Version:    0.7.0.1
 */