import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;

class agmw
  implements View.OnClickListener
{
  agmw(agmv paramagmv, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    try
    {
      if (!this.jdField_a_of_type_JavaLangString.equals("0"))
      {
        agmv.a(this.jdField_a_of_type_Agmv).a.getText().clear();
        agmv.a(this.jdField_a_of_type_Agmv).c(agmv.a(this.jdField_a_of_type_Agmv));
      }
      int i = agmv.a(this.jdField_a_of_type_Agmv).a.getSelectionStart();
      Editable localEditable = agmv.a(this.jdField_a_of_type_Agmv).a.getText();
      this.jdField_a_of_type_Agmv.a = true;
      localEditable.insert(i, this.b);
      this.jdField_a_of_type_Agmv.a = false;
      agmv.a(this.jdField_a_of_type_Agmv).a.setSelection(localEditable.length());
      this.jdField_a_of_type_Agmv.a();
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
 * Qualified Name:     agmw
 * JD-Core Version:    0.7.0.1
 */