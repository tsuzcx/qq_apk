import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment;

public class afga
  implements View.OnClickListener
{
  public afga(SearchBaseActivity paramSearchBaseActivity) {}
  
  public void onClick(View paramView)
  {
    if (TextUtils.isEmpty(this.a.jdField_a_of_type_AndroidWidgetEditText.getText()))
    {
      this.a.setResult(0);
      this.a.finish();
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.a(this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afga
 * JD-Core Version:    0.7.0.1
 */