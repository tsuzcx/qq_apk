import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aisf
  implements View.OnClickListener
{
  public aisf(ClassificationSearchActivity paramClassificationSearchActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if ((TextUtils.isEmpty(this.a.jdField_a_of_type_AndroidWidgetEditText.getText())) || (this.a.f == ClassificationSearchActivity.c))
    {
      localObject = (InputMethodManager)this.a.getSystemService("input_method");
      if ((localObject != null) && (((InputMethodManager)localObject).isActive())) {
        ((InputMethodManager)localObject).hideSoftInputFromWindow(this.a.getWindow().getDecorView().getWindowToken(), 0);
      }
      this.a.setResult(0);
      this.a.finish();
      if ((this.a.f == ClassificationSearchActivity.d) || (this.a.f == ClassificationSearchActivity.e)) {
        this.a.sendBroadcast(new Intent("com.tencent.mobileqq.search.cancel"));
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      if ((this.a.f == ClassificationSearchActivity.jdField_a_of_type_Int) && (!TextUtils.isEmpty(((String)localObject).trim())))
      {
        this.a.a((String)localObject);
        ClassificationSearchActivity.a(this.a, (String)localObject);
        oat.a(null, "dc00899", "Pb_account_lifeservice", "", "0X80067C4", "0X80067C4", 0, 0, "", "", (String)localObject, "", true);
      }
      else if (this.a.f == ClassificationSearchActivity.d)
      {
        oat.a(null, "", "0X800742D", "0X800742D", 0, 0, (String)localObject, "", "", "");
        ClassificationSearchActivity.a(this.a, (String)localObject);
      }
      else
      {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.a((String)localObject, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aisf
 * JD-Core Version:    0.7.0.1
 */