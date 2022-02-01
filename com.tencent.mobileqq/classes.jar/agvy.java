import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;

class agvy
  implements View.OnClickListener
{
  agvy(agvx paramagvx, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    try
    {
      if (!this.jdField_a_of_type_JavaLangString.equals("0"))
      {
        agvx.a(this.jdField_a_of_type_Agvx).a.getText().clear();
        agvx.a(this.jdField_a_of_type_Agvx).c(agvx.a(this.jdField_a_of_type_Agvx));
      }
      int i = agvx.a(this.jdField_a_of_type_Agvx).a.getSelectionStart();
      Editable localEditable = agvx.a(this.jdField_a_of_type_Agvx).a.getText();
      this.jdField_a_of_type_Agvx.a = true;
      localEditable.insert(i, this.b);
      this.jdField_a_of_type_Agvx.a = false;
      agvx.a(this.jdField_a_of_type_Agvx).a.setSelection(localEditable.length());
      this.jdField_a_of_type_Agvx.a();
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
 * Qualified Name:     agvy
 * JD-Core Version:    0.7.0.1
 */