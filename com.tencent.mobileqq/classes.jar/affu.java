import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;

class affu
  implements View.OnClickListener
{
  affu(afft paramafft, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    try
    {
      if (!this.jdField_a_of_type_JavaLangString.equals("0"))
      {
        afft.a(this.jdField_a_of_type_Afft).a.getText().clear();
        afft.a(this.jdField_a_of_type_Afft).c(afft.a(this.jdField_a_of_type_Afft));
      }
      int i = afft.a(this.jdField_a_of_type_Afft).a.getSelectionStart();
      paramView = afft.a(this.jdField_a_of_type_Afft).a.getText();
      this.jdField_a_of_type_Afft.a = true;
      paramView.insert(i, this.b);
      this.jdField_a_of_type_Afft.a = false;
      afft.a(this.jdField_a_of_type_Afft).a.setSelection(paramView.length());
      this.jdField_a_of_type_Afft.a();
      return;
    }
    catch (Throwable paramView)
    {
      QLog.e("QWalletAIOLifeCycleHelper", 1, "onclick  PasswdRedBagTips throw an exception: " + paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     affu
 * JD-Core Version:    0.7.0.1
 */