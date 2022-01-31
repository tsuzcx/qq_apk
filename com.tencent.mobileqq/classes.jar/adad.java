import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class adad
  implements DialogInterface.OnClickListener
{
  public adad(ForwardBaseOption paramForwardBaseOption) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    boolean bool = false;
    if (this.a.jdField_a_of_type_AndroidOsBundle != null) {
      bool = this.a.jdField_a_of_type_AndroidOsBundle.getBoolean("from_card", false);
    }
    if (bool)
    {
      localObject1 = this.a.jdField_a_of_type_AndroidOsBundle.getString("pubUin");
      paramDialogInterface = (DialogInterface)localObject1;
      if (localObject1 == null) {
        paramDialogInterface = "";
      }
      PublicAccountReportUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramDialogInterface, "0X8005A2C", "0X8005A2C", 0, 0, "", "", "", "", false);
    }
    int i;
    if (this.a.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_source_from_shoot_quick", false))
    {
      paramInt = this.a.jdField_a_of_type_AndroidOsBundle.getInt("forward_type");
      paramDialogInterface = "";
      if (paramInt == 21)
      {
        paramDialogInterface = "0X800780B";
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", paramDialogInterface, paramDialogInterface, 0, 0, "", "", "", "");
      }
    }
    else
    {
      if (this.a.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_source_from_pre_guide", false)) {}
      paramInt = this.a.a().getInt("key_forward_ability_type");
      localObject1 = this.a.jdField_a_of_type_AndroidOsBundle.getString("uin");
      i = this.a.jdField_a_of_type_AndroidOsBundle.getInt("uintype", 0);
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardBaseOption", 2, "-->getConfirmListener--onClick--type = " + paramInt);
      }
    }
    for (;;)
    {
      try
      {
        if ((paramInt != ForwardAbility.ForwardAbilityType.f.intValue()) && (paramInt != ForwardAbility.ForwardAbilityType.k.intValue())) {
          continue;
        }
        this.a.b(paramInt);
      }
      catch (Throwable paramDialogInterface)
      {
        Object localObject2;
        Object localObject3;
        String str;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ForwardOption.ForwardBaseOption", 2, "Throwable", paramDialogInterface);
        continue;
        if (paramInt != ForwardAbility.ForwardAbilityType.j.intValue()) {
          continue;
        }
        this.a.u();
        continue;
        if (paramInt != ForwardAbility.ForwardAbilityType.m.intValue()) {
          continue;
        }
        this.a.v();
        continue;
        if (paramInt != ForwardAbility.ForwardAbilityType.e.intValue()) {
          continue;
        }
        paramDialogInterface = null;
        if (!(this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog instanceof QQCustomDialogWtihEmoticonInput)) {
          continue;
        }
        paramDialogInterface = ((QQCustomDialogWtihEmoticonInput)this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog).a();
        this.a.a(paramDialogInterface);
        continue;
        this.a.m();
        continue;
        paramInt = 1001;
        continue;
        PublicAccountReportUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X80059DC", "0X80059DC", paramInt, 0, (String)localObject1, (String)localObject2, paramDialogInterface, (String)localObject3, false);
        continue;
        continue;
      }
      if ((this.a.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("is_need_show_toast", true)) && (this.a.a(i, (String)localObject1, paramInt))) {
        ThreadManager.getUIHandler().postDelayed(new adae(this), 300L);
      }
      if ((this.a.jdField_a_of_type_AndroidOsBundle != null) && (this.a.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_report_confirm")))
      {
        localObject1 = this.a.jdField_a_of_type_AndroidOsBundle.getString("forward_report_confirm_action_name");
        localObject2 = this.a.jdField_a_of_type_AndroidOsBundle.getString("forward_report_confirm_reverse2");
        paramDialogInterface = (DialogInterface)localObject1;
        if (localObject1 == null) {
          paramDialogInterface = "";
        }
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", paramDialogInterface, paramDialogInterface, 0, 0, (String)localObject1, "", "", "");
      }
      bool = false;
      if (this.a.jdField_a_of_type_AndroidOsBundle != null)
      {
        bool = this.a.jdField_a_of_type_AndroidOsBundle.getBoolean("from_web", false);
        if (!bool) {
          continue;
        }
        localObject1 = this.a.jdField_a_of_type_AndroidOsBundle.getString("struct_uin");
        if (localObject1 != null) {
          continue;
        }
        localObject1 = "";
        localObject2 = this.a.jdField_a_of_type_AndroidOsBundle.getString("struct_url");
        paramDialogInterface = (DialogInterface)localObject2;
        if (localObject2 == null) {
          paramDialogInterface = "";
        }
        localObject3 = this.a.jdField_a_of_type_AndroidOsBundle.getString("strurt_msgid");
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        localObject3 = AccountDetailActivity.a(paramDialogInterface);
        if (paramInt != ForwardAbility.ForwardAbilityType.e.intValue()) {
          continue;
        }
        paramInt = 1002;
        str = this.a.jdField_a_of_type_AndroidOsBundle.getString("source_puin");
        if ((str == null) || ("".equals(str))) {
          continue;
        }
        localObject1 = this.a.jdField_a_of_type_AndroidOsBundle.getString("uin");
        if ((localObject1 == null) || (paramInt == 1002)) {
          localObject1 = "";
        }
        PublicAccountReportUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", (String)localObject1, "0X8005B07", "0X8005B07", paramInt, 0, str, (String)localObject2, paramDialogInterface, (String)localObject3, false);
      }
      if ((this.a.jdField_a_of_type_AndroidOsBundle != null) && (!bool))
      {
        localObject2 = this.a.jdField_a_of_type_AndroidOsBundle.getString("source_puin");
        if (localObject2 != null)
        {
          paramDialogInterface = this.a.jdField_a_of_type_AndroidContentIntent.getByteArrayExtra("stuctmsg_bytes");
          if (paramDialogInterface != null)
          {
            localObject3 = StructMsgFactory.a(paramDialogInterface);
            if (localObject3 != null)
            {
              localObject1 = this.a.jdField_a_of_type_AndroidOsBundle.getString("uin");
              paramDialogInterface = (DialogInterface)localObject1;
              if (localObject1 == null) {
                paramDialogInterface = "";
              }
              PublicAccountReportUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramDialogInterface, "0X8005B06", "0X8005B06", 0, 0, (String)localObject2, "" + ((AbsStructMsg)localObject3).msgId, "", "", false);
              PublicAccountReportUtils.a("0X8005B06", paramDialogInterface, (String)localObject2, "" + ((AbsStructMsg)localObject3).msgId, "", "");
            }
          }
        }
      }
      if (this.a.c) {
        ReportCenter.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "", String.valueOf(this.a.jdField_a_of_type_Long), "1000", "50", "0", false);
      }
      if ((this.a.jdField_a_of_type_AndroidOsBundle != null) && (this.a.jdField_a_of_type_AndroidOsBundle.getInt("extra_key_from_apollo") > 0)) {
        VipUtils.a(null, "cmshow", "Apollo", "QQSend", 0, 0, new String[0]);
      }
      return;
      if (paramInt != 1) {
        break;
      }
      paramDialogInterface = "0X8007811";
      break;
      if (paramInt != ForwardAbility.ForwardAbilityType.g.intValue()) {
        continue;
      }
      this.a.q();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     adad
 * JD-Core Version:    0.7.0.1
 */