import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ajgu
  implements View.OnClickListener
{
  ajgu(ajgq paramajgq) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (QLog.isColorLevel()) {
      QLog.i("C2CMessageSearchDialog", 2, "onClick, id = " + i);
    }
    switch (i)
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.jdField_a_of_type_Ajhk != null)
      {
        ((ClipboardManager)this.a.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(this.a.jdField_a_of_type_Ajhk.a.msg);
        continue;
        if (this.a.jdField_a_of_type_Ajhk != null)
        {
          Bundle localBundle = new Bundle();
          localBundle.putInt("forward_type", -1);
          localBundle.putString("forward_text", this.a.jdField_a_of_type_Ajhk.a.msg);
          Intent localIntent = new Intent(this.a.jdField_a_of_type_AndroidContentContext, ForwardRecentActivity.class);
          localIntent.putExtras(localBundle);
          ((Activity)this.a.jdField_a_of_type_AndroidContentContext).startActivityForResult(localIntent, 21);
          continue;
          if (QLog.isColorLevel()) {
            QLog.i("C2CMessageSearchDialog", 2, "OnClickListener, setMessageItems");
          }
          this.a.c = false;
          ajgq.a(this.a).setVisibility(8);
          ajgq.a(this.a, 0, null);
          this.a.jdField_a_of_type_Ajgo.a(ajgq.a(this.a), this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Long);
          this.a.jdField_a_of_type_Ajgo.notifyDataSetChanged();
          this.a.b = 1;
          VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history", "ChatSearch", "Clk_cloudtips", 0, 0, new String[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajgu
 * JD-Core Version:    0.7.0.1
 */