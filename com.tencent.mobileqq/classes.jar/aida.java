import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

class aida
  implements View.OnClickListener
{
  aida(aicw paramaicw) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (QLog.isColorLevel()) {
      QLog.i(aicw.jdField_a_of_type_JavaLangString, 2, "onClick, id = " + i);
    }
    Object localObject = this.a.jdField_a_of_type_Aicu;
    if (this.a.jdField_a_of_type_Aicu == null) {
      return;
    }
    switch (i)
    {
    default: 
      return;
    case 2131364910: 
      ((ClipboardManager)this.a.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(((aicu)localObject).a.msg);
      return;
    }
    paramView = new Bundle();
    paramView.putInt("forward_type", -1);
    paramView.putString("forward_text", ((aicu)localObject).a.msg);
    localObject = new Intent();
    ((Intent)localObject).putExtras(paramView);
    arum.a((Activity)this.a.jdField_a_of_type_AndroidContentContext, (Intent)localObject, 21);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aida
 * JD-Core Version:    0.7.0.1
 */