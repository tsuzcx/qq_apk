import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;

class acxy
  implements View.OnClickListener
{
  acxy(acxx paramacxx, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    try
    {
      if (!this.jdField_a_of_type_JavaLangString.equals("0"))
      {
        acxx.a(this.jdField_a_of_type_Acxx).a.getText().clear();
        acxx.a(this.jdField_a_of_type_Acxx).c(acxx.a(this.jdField_a_of_type_Acxx));
      }
      int i = acxx.a(this.jdField_a_of_type_Acxx).a.getSelectionStart();
      paramView = acxx.a(this.jdField_a_of_type_Acxx).a.getText();
      this.jdField_a_of_type_Acxx.a = true;
      paramView.insert(i, this.b);
      this.jdField_a_of_type_Acxx.a = false;
      acxx.a(this.jdField_a_of_type_Acxx).a.setSelection(paramView.length());
      this.jdField_a_of_type_Acxx.a();
      return;
    }
    catch (Throwable paramView)
    {
      QLog.e("QWalletAIOLifeCycleHelper", 1, "onclick  PasswdRedBagTips throw an exception: " + paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acxy
 * JD-Core Version:    0.7.0.1
 */