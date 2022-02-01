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
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akdx
  implements View.OnClickListener
{
  akdx(akdt paramakdt) {}
  
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
        if (this.a.jdField_a_of_type_Akcy != null)
        {
          Bundle localBundle = new Bundle();
          localBundle.putInt("forward_type", -1);
          localBundle.putString("forward_text", this.a.jdField_a_of_type_Akcy.a.msg);
          Intent localIntent = new Intent(this.a.jdField_a_of_type_AndroidContentContext, ForwardRecentActivity.class);
          localIntent.putExtras(localBundle);
          ((Activity)this.a.jdField_a_of_type_AndroidContentContext).startActivityForResult(localIntent, 21);
          continue;
          if (QLog.isColorLevel()) {
            QLog.i("LinkMessageSearchDialog", 2, "OnClickListener, setMessageItems");
          }
          this.a.c = false;
          akdt.a(this.a).setVisibility(8);
          akdt.a(this.a, 0, null);
          this.a.jdField_a_of_type_Ajwt.a(akdt.a(this.a), this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Long);
          this.a.jdField_a_of_type_Ajwt.notifyDataSetChanged();
          this.a.b = 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akdx
 * JD-Core Version:    0.7.0.1
 */