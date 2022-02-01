import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;

class agjs
  implements View.OnClickListener
{
  agjs(agjr paramagjr, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    try
    {
      if (!this.jdField_a_of_type_JavaLangString.equals("0"))
      {
        agjr.a(this.jdField_a_of_type_Agjr).input.getText().clear();
        agjr.a(this.jdField_a_of_type_Agjr).c(agjr.a(this.jdField_a_of_type_Agjr));
      }
      int i = agjr.a(this.jdField_a_of_type_Agjr).input.getSelectionStart();
      Editable localEditable = agjr.a(this.jdField_a_of_type_Agjr).input.getText();
      this.jdField_a_of_type_Agjr.a = true;
      localEditable.insert(i, this.b);
      this.jdField_a_of_type_Agjr.a = false;
      agjr.a(this.jdField_a_of_type_Agjr).input.setSelection(localEditable.length());
      this.jdField_a_of_type_Agjr.a();
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
 * Qualified Name:     agjs
 * JD-Core Version:    0.7.0.1
 */