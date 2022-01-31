import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;

class adix
  implements View.OnClickListener
{
  adix(adiw paramadiw, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    try
    {
      if (!this.jdField_a_of_type_JavaLangString.equals("0"))
      {
        adiw.a(this.jdField_a_of_type_Adiw).a.getText().clear();
        adiw.a(this.jdField_a_of_type_Adiw).c(adiw.a(this.jdField_a_of_type_Adiw));
      }
      int i = adiw.a(this.jdField_a_of_type_Adiw).a.getSelectionStart();
      paramView = adiw.a(this.jdField_a_of_type_Adiw).a.getText();
      this.jdField_a_of_type_Adiw.a = true;
      paramView.insert(i, this.b);
      this.jdField_a_of_type_Adiw.a = false;
      adiw.a(this.jdField_a_of_type_Adiw).a.setSelection(paramView.length());
      this.jdField_a_of_type_Adiw.a();
      return;
    }
    catch (Throwable paramView)
    {
      QLog.e("QWalletAIOLifeCycleHelper", 1, "onclick  PasswdRedBagTips throw an exception: " + paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adix
 * JD-Core Version:    0.7.0.1
 */