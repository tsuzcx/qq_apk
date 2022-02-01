import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

class aguf
  extends ClickableSpan
{
  aguf(agtf paramagtf, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, Bundle paramBundle, String paramString4, int paramInt3, long paramLong, String paramString5, int paramInt4, String paramString6) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_JavaLangString.compareToIgnoreCase("makePhoneCall") == 0)
    {
      bdla.b(this.jdField_a_of_type_Agtf.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Safe_SensMsg", this.jdField_b_of_type_JavaLangString, "Tips_Click", "makePhoneCall", this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, "", "", "", "");
      paramView = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.jdField_c_of_type_JavaLangString));
      this.jdField_a_of_type_Agtf.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
    }
    do
    {
      return;
      if (this.jdField_a_of_type_JavaLangString.compareToIgnoreCase("showAlert") == 0)
      {
        paramView = this.jdField_a_of_type_AndroidOsBundle.getString("AlertTitle");
        String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("AlertText");
        String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("AlertOtherBtnText");
        String str3 = this.jdField_a_of_type_AndroidOsBundle.getString("AlertCancelBtnText");
        biyt.a(this.jdField_d_of_type_JavaLangString, this.jdField_c_of_type_Int, this.jdField_a_of_type_Long, paramView, str1, str2, str3);
        return;
      }
      if (this.jdField_a_of_type_JavaLangString.compareToIgnoreCase("openURL") == 0)
      {
        bdla.b(this.jdField_a_of_type_Agtf.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Safe_SensMsg", this.jdField_b_of_type_JavaLangString, "Tips_Click", "openURL", this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, "", "", "", "");
        agtf.a(this.jdField_a_of_type_Agtf, this.jdField_a_of_type_AndroidOsBundle);
        return;
      }
      if (this.jdField_a_of_type_JavaLangString.compareToIgnoreCase("transfer") == 0)
      {
        bdla.b(this.jdField_a_of_type_Agtf.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Safe_SensMsg", this.jdField_b_of_type_JavaLangString, "Tips_Click", "transfer", this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, "", "", "", "");
        agtf.a(this.jdField_a_of_type_Agtf, this.e, this.jdField_d_of_type_Int, this.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString);
        return;
      }
      if (this.jdField_a_of_type_JavaLangString.compareToIgnoreCase("openDeviceLock") == 0)
      {
        bdla.b(this.jdField_a_of_type_Agtf.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Safe_SensMsg", this.jdField_b_of_type_JavaLangString, "Tips_Click", "openDeviceLock", this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, "", "", "", "");
        paramView = new Intent();
        paramView.setFlags(268435456);
        paramView.setAction("android.intent.action.VIEW");
        paramView.putExtra("devlock_open_source", "Graytips");
        paramView.putExtra("enable_open_allowset_dev", true);
        paramView.setData(Uri.parse("mqqdevlock://devlock/open?"));
        this.jdField_a_of_type_Agtf.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
        return;
      }
      if (this.jdField_a_of_type_JavaLangString.compareToIgnoreCase("tipOff") == 0)
      {
        bdla.b(this.jdField_a_of_type_Agtf.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Safe_SensMsg", this.jdField_b_of_type_JavaLangString, "Tips_Click", "tipOff", this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, "", "", "", "");
        aaqo.a((BaseActivity)this.jdField_a_of_type_Agtf.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Agtf.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, this.jdField_a_of_type_Agtf.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_Agtf.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        return;
      }
      if ((this.jdField_a_of_type_JavaLangString.compareToIgnoreCase("QQCall") == 0) || (this.jdField_a_of_type_JavaLangString.compareToIgnoreCase("videoCall") == 0))
      {
        bdla.b(this.jdField_a_of_type_Agtf.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Safe_SensMsg", this.jdField_b_of_type_JavaLangString, "Tips_Click", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, "", "", "", "");
        agtf.a(this.jdField_a_of_type_Agtf, this.e, this.jdField_d_of_type_Int, this.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, this.f, this.jdField_a_of_type_JavaLangString);
        return;
      }
    } while (this.jdField_a_of_type_JavaLangString.compareToIgnoreCase("luckyMoney") != 0);
    bdla.b(this.jdField_a_of_type_Agtf.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Safe_SensMsg", this.jdField_b_of_type_JavaLangString, "Tips_Click", "luckyMoney", this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, "", "", "", "");
    agtf.a(this.jdField_a_of_type_Agtf, this.jdField_d_of_type_Int);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aguf
 * JD-Core Version:    0.7.0.1
 */