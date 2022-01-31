import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

class aihp
  implements View.OnClickListener
{
  aihp(aihl paramaihl) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (QLog.isColorLevel()) {
      QLog.i(aihl.jdField_a_of_type_JavaLangString, 2, "onClick, id = " + i);
    }
    Object localObject = this.a.jdField_a_of_type_Aihj;
    if (this.a.jdField_a_of_type_Aihj == null) {
      return;
    }
    switch (i)
    {
    default: 
      return;
    case 2131364912: 
      ((ClipboardManager)this.a.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(((aihj)localObject).a.msg);
      return;
    }
    paramView = new Bundle();
    paramView.putInt("forward_type", -1);
    paramView.putString("forward_text", ((aihj)localObject).a.msg);
    localObject = new Intent();
    ((Intent)localObject).putExtras(paramView);
    aryv.a((Activity)this.a.jdField_a_of_type_AndroidContentContext, (Intent)localObject, 21);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aihp
 * JD-Core Version:    0.7.0.1
 */