import android.view.View;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class acdr
  implements bhuk
{
  public acdr(AddRequestActivity paramAddRequestActivity, bhuf parambhuf) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_Bhuf.dismiss();
      return;
    }
    if (bdin.d(BaseApplication.getContext()))
    {
      long l1 = bafi.a().b();
      this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity.a = bafi.a().a(Long.valueOf(l1));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity.a != null)
      {
        paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity.a.msg_type.get();
        l1 = this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity.a.msg_seq.get();
        long l2 = this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity.a.req_uin.get();
        int i = this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity.a.msg.sub_type.get();
        int j = this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity.a.msg.src_id.get();
        int k = this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity.a.msg.sub_src_id.get();
        int m = this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity.a.msg.group_msg_type.get();
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity.a.msg.actions.get();
        if ((paramView != null) && (1 < paramView.size()))
        {
          ((structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)paramView.get(1)).action_info.get()).blacklist.set(true);
          AddRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity, true);
          this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity.app.a().a().a(paramInt, l1, l2, i, j, k, m, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)paramView.get(1)).action_info.get(), 1, null, false);
          AddRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity, 2131719785, 1000L, false);
        }
      }
    }
    for (;;)
    {
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity.app, "CliOper", "", "", "Verification_msg", "Vfc_shield_clk", 0, 0, "", "", "", "");
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity.app, "CliOper", "", "", "0X800AA45", "0X800AA45", 0, 0, "", "", "", "");
      break;
      StringBuilder localStringBuilder = new StringBuilder().append("shield, ");
      if (paramView != null) {}
      for (paramInt = paramView.size();; paramInt = -1)
      {
        QLog.d("Q.systemmsg.AddRequestActivity", 1, paramInt);
        break;
      }
      QLog.d("Q.systemmsg.AddRequestActivity", 1, "shield");
      continue;
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity, 2131694768, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acdr
 * JD-Core Version:    0.7.0.1
 */