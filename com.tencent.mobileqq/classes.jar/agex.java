import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

class agex
  implements View.OnClickListener
{
  agex(aget paramaget) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (QLog.isColorLevel()) {
      QLog.i(aget.jdField_a_of_type_JavaLangString, 2, "onClick, id = " + i);
    }
    Object localObject = this.a.jdField_a_of_type_Ager;
    if (this.a.jdField_a_of_type_Ager == null) {
      return;
    }
    switch (i)
    {
    default: 
      return;
    case 2131364825: 
      ((ClipboardManager)this.a.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(((ager)localObject).a.msg);
      return;
    }
    paramView = new Bundle();
    paramView.putInt("forward_type", -1);
    paramView.putString("forward_text", ((ager)localObject).a.msg);
    localObject = new Intent();
    ((Intent)localObject).putExtras(paramView);
    aqbc.a((Activity)this.a.jdField_a_of_type_AndroidContentContext, (Intent)localObject, 21);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agex
 * JD-Core Version:    0.7.0.1
 */