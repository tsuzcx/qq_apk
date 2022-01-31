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

class aigj
  implements View.OnClickListener
{
  aigj(aigf paramaigf) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (QLog.isColorLevel()) {
      QLog.i("LinkMessageSearchDialog", 2, "onClick, id = " + i);
    }
    switch (i)
    {
    }
    do
    {
      do
      {
        return;
      } while (this.a.jdField_a_of_type_Aihj == null);
      ((ClipboardManager)this.a.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(this.a.jdField_a_of_type_Aihj.a.msg);
      return;
    } while ((this.a.jdField_a_of_type_Aihj == null) || (this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing == null) || (this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.structingMsg == null) || (!(this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.structingMsg instanceof AbsShareMsg)));
    paramView = (AbsShareMsg)this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.structingMsg;
    Intent localIntent = new Intent(this.a.jdField_a_of_type_AndroidContentContext, ForwardRecentActivity.class);
    localIntent.putExtra("forward_type", -3);
    localIntent.putExtra("stuctmsg_bytes", paramView.getBytes());
    localIntent.putExtra("is_need_show_sources", false);
    aryv.a((Activity)this.a.jdField_a_of_type_AndroidContentContext, localIntent, 21);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aigj
 * JD-Core Version:    0.7.0.1
 */