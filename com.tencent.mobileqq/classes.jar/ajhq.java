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

class ajhq
  implements View.OnClickListener
{
  ajhq(ajhm paramajhm) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (QLog.isColorLevel()) {
      QLog.i(ajhm.jdField_a_of_type_JavaLangString, 2, "onClick, id = " + i);
    }
    Object localObject = this.a.jdField_a_of_type_Ajhk;
    if (this.a.jdField_a_of_type_Ajhk == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (i)
      {
      default: 
        break;
      case 2131365216: 
        ((ClipboardManager)this.a.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(((ajhk)localObject).a.msg);
        break;
      case 2131367094: 
        Bundle localBundle = new Bundle();
        localBundle.putInt("forward_type", -1);
        localBundle.putString("forward_text", ((ajhk)localObject).a.msg);
        localObject = new Intent();
        ((Intent)localObject).putExtras(localBundle);
        atky.a((Activity)this.a.jdField_a_of_type_AndroidContentContext, (Intent)localObject, 21);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajhq
 * JD-Core Version:    0.7.0.1
 */