import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;

class afse
  implements View.OnClickListener
{
  afse(afsd paramafsd, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    try
    {
      if (!this.jdField_a_of_type_JavaLangString.equals("0"))
      {
        afsd.a(this.jdField_a_of_type_Afsd).input.getText().clear();
        afsd.a(this.jdField_a_of_type_Afsd).c(afsd.a(this.jdField_a_of_type_Afsd));
      }
      int i = afsd.a(this.jdField_a_of_type_Afsd).input.getSelectionStart();
      Editable localEditable = afsd.a(this.jdField_a_of_type_Afsd).input.getText();
      this.jdField_a_of_type_Afsd.a = true;
      localEditable.insert(i, this.b);
      this.jdField_a_of_type_Afsd.a = false;
      afsd.a(this.jdField_a_of_type_Afsd).input.setSelection(localEditable.length());
      this.jdField_a_of_type_Afsd.a();
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("QWalletAIOLifeCycleHelper", 1, "onclick  PasswdRedBagTips throw an exception: " + localThrowable);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afse
 * JD-Core Version:    0.7.0.1
 */