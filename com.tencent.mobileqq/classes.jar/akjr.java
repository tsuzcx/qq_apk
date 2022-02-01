import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akjr
  implements View.OnClickListener
{
  akjr(akjn paramakjn) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (QLog.isColorLevel()) {
      QLog.i(akjn.jdField_a_of_type_JavaLangString, 2, "onClick, id = " + i);
    }
    Object localObject = this.a.jdField_a_of_type_Akjl;
    if (this.a.jdField_a_of_type_Akjl == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (i)
      {
      default: 
        break;
      case 2131365191: 
        ((ClipboardManager)this.a.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(((akjl)localObject).a.msg);
        break;
      case 2131367078: 
        Bundle localBundle = new Bundle();
        localBundle.putInt("forward_type", -1);
        localBundle.putString("forward_text", ((akjl)localObject).a.msg);
        localObject = new Intent();
        ((Intent)localObject).putExtras(localBundle);
        auxu.a((Activity)this.a.jdField_a_of_type_AndroidContentContext, (Intent)localObject, 21);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akjr
 * JD-Core Version:    0.7.0.1
 */