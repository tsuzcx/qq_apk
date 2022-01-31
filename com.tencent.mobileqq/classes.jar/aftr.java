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

class aftr
  implements View.OnClickListener
{
  aftr(aftn paramaftn) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (QLog.isColorLevel()) {
      QLog.i("LinkMessageSearchDialog", 2, "onClick, id = " + i);
    }
    switch (i)
    {
    default: 
    case 2131299262: 
    case 2131301021: 
      do
      {
        do
        {
          return;
        } while (this.a.jdField_a_of_type_Afss == null);
        ((ClipboardManager)this.a.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(this.a.jdField_a_of_type_Afss.a.msg);
        return;
      } while (this.a.jdField_a_of_type_Afss == null);
      paramView = new Bundle();
      paramView.putInt("forward_type", -1);
      paramView.putString("forward_text", this.a.jdField_a_of_type_Afss.a.msg);
      Intent localIntent = new Intent(this.a.jdField_a_of_type_AndroidContentContext, ForwardRecentActivity.class);
      localIntent.putExtras(paramView);
      ((Activity)this.a.jdField_a_of_type_AndroidContentContext).startActivityForResult(localIntent, 21);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("LinkMessageSearchDialog", 2, "OnClickListener, setMessageItems");
    }
    this.a.c = false;
    aftn.a(this.a).setVisibility(8);
    aftn.a(this.a, 0, null);
    this.a.jdField_a_of_type_Afpr.a(aftn.a(this.a), this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Long);
    this.a.jdField_a_of_type_Afpr.notifyDataSetChanged();
    this.a.b = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aftr
 * JD-Core Version:    0.7.0.1
 */