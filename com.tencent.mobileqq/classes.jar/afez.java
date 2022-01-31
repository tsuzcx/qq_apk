import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment;

public class afez
  implements View.OnClickListener
{
  public afez(ClassificationSearchActivity paramClassificationSearchActivity) {}
  
  public void onClick(View paramView)
  {
    if ((TextUtils.isEmpty(this.a.jdField_a_of_type_AndroidWidgetEditText.getText())) || (this.a.f == ClassificationSearchActivity.c))
    {
      paramView = (InputMethodManager)this.a.getSystemService("input_method");
      if ((paramView != null) && (paramView.isActive())) {
        paramView.hideSoftInputFromWindow(this.a.getWindow().getDecorView().getWindowToken(), 0);
      }
      this.a.setResult(0);
      this.a.finish();
      if ((this.a.f == ClassificationSearchActivity.d) || (this.a.f == ClassificationSearchActivity.e)) {
        this.a.sendBroadcast(new Intent("com.tencent.mobileqq.search.cancel"));
      }
      return;
    }
    paramView = this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if ((this.a.f == ClassificationSearchActivity.jdField_a_of_type_Int) && (!TextUtils.isEmpty(paramView.trim())))
    {
      this.a.a(paramView);
      ClassificationSearchActivity.a(this.a, paramView);
      nol.a(null, "dc00899", "Pb_account_lifeservice", "", "0X80067C4", "0X80067C4", 0, 0, "", "", paramView, "", true);
      return;
    }
    if (this.a.f == ClassificationSearchActivity.d)
    {
      nol.a(null, "", "0X800742D", "0X800742D", 0, 0, paramView, "", "", "");
      ClassificationSearchActivity.a(this.a, paramView);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.a(paramView, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afez
 * JD-Core Version:    0.7.0.1
 */