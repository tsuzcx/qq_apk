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

class ajyi
  implements View.OnClickListener
{
  ajyi(ajye paramajye) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (QLog.isColorLevel()) {
      QLog.i(ajye.jdField_a_of_type_JavaLangString, 2, "onClick, id = " + i);
    }
    Object localObject = this.a.jdField_a_of_type_Ajyc;
    if (this.a.jdField_a_of_type_Ajyc == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (i)
      {
      default: 
        break;
      case 2131365147: 
        ((ClipboardManager)this.a.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(((ajyc)localObject).a.msg);
        break;
      case 2131367027: 
        Bundle localBundle = new Bundle();
        localBundle.putInt("forward_type", -1);
        localBundle.putString("forward_text", ((ajyc)localObject).a.msg);
        localObject = new Intent();
        ((Intent)localObject).putExtras(localBundle);
        aufz.a((Activity)this.a.jdField_a_of_type_AndroidContentContext, (Intent)localObject, 21);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajyi
 * JD-Core Version:    0.7.0.1
 */