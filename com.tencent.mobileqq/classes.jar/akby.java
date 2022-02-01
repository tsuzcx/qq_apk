import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akby
  implements View.OnClickListener
{
  akby(akbu paramakbu) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (QLog.isColorLevel()) {
      QLog.i("LinkMessageSearchDialog", 2, "onClick, id = " + i);
    }
    switch (i)
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.jdField_a_of_type_Akcy != null)
      {
        ((ClipboardManager)this.a.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(this.a.jdField_a_of_type_Akcy.a.msg);
        continue;
        if ((this.a.jdField_a_of_type_Akcy != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.structingMsg != null) && ((this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.structingMsg instanceof AbsShareMsg)))
        {
          AbsShareMsg localAbsShareMsg = (AbsShareMsg)this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.structingMsg;
          Intent localIntent = new Intent(this.a.jdField_a_of_type_AndroidContentContext, ForwardRecentActivity.class);
          localIntent.putExtra("forward_type", -3);
          localIntent.putExtra("stuctmsg_bytes", localAbsShareMsg.getBytes());
          localIntent.putExtra("is_need_show_sources", false);
          aupt.a((Activity)this.a.jdField_a_of_type_AndroidContentContext, localIntent, 21);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akby
 * JD-Core Version:    0.7.0.1
 */