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

class akkk
  implements View.OnClickListener
{
  akkk(akkg paramakkg) {}
  
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
      if (this.a.jdField_a_of_type_Akjl != null)
      {
        ((ClipboardManager)this.a.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(this.a.jdField_a_of_type_Akjl.a.msg);
        continue;
        if (this.a.jdField_a_of_type_Akjl != null)
        {
          Bundle localBundle = new Bundle();
          localBundle.putInt("forward_type", -1);
          localBundle.putString("forward_text", this.a.jdField_a_of_type_Akjl.a.msg);
          Intent localIntent = new Intent(this.a.jdField_a_of_type_AndroidContentContext, ForwardRecentActivity.class);
          localIntent.putExtras(localBundle);
          ((Activity)this.a.jdField_a_of_type_AndroidContentContext).startActivityForResult(localIntent, 21);
          continue;
          if (QLog.isColorLevel()) {
            QLog.i("LinkMessageSearchDialog", 2, "OnClickListener, setMessageItems");
          }
          this.a.c = false;
          akkg.a(this.a).setVisibility(8);
          akkg.a(this.a, 0, null);
          this.a.jdField_a_of_type_Akge.a(akkg.a(this.a), this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Long);
          this.a.jdField_a_of_type_Akge.notifyDataSetChanged();
          this.a.b = 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akkk
 * JD-Core Version:    0.7.0.1
 */