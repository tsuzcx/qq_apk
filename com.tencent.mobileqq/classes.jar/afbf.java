import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;

class afbf
  implements View.OnClickListener
{
  afbf(afbe paramafbe, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    try
    {
      if (!this.jdField_a_of_type_JavaLangString.equals("0"))
      {
        afbe.a(this.jdField_a_of_type_Afbe).a.getText().clear();
        afbe.a(this.jdField_a_of_type_Afbe).c(afbe.a(this.jdField_a_of_type_Afbe));
      }
      int i = afbe.a(this.jdField_a_of_type_Afbe).a.getSelectionStart();
      paramView = afbe.a(this.jdField_a_of_type_Afbe).a.getText();
      this.jdField_a_of_type_Afbe.a = true;
      paramView.insert(i, this.b);
      this.jdField_a_of_type_Afbe.a = false;
      afbe.a(this.jdField_a_of_type_Afbe).a.setSelection(paramView.length());
      this.jdField_a_of_type_Afbe.a();
      return;
    }
    catch (Throwable paramView)
    {
      QLog.e("QWalletAIOLifeCycleHelper", 1, "onclick  PasswdRedBagTips throw an exception: " + paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afbf
 * JD-Core Version:    0.7.0.1
 */