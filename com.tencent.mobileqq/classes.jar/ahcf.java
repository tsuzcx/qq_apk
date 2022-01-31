import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment;

public class ahcf
  implements View.OnClickListener
{
  public ahcf(ClassificationSearchActivity paramClassificationSearchActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_AndroidWidgetEditText.setText("");
    if ((this.a.f == ClassificationSearchActivity.jdField_a_of_type_Int) || (this.a.f == ClassificationSearchActivity.d))
    {
      ClassificationSearchActivity.a(this.a);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahcf
 * JD-Core Version:    0.7.0.1
 */