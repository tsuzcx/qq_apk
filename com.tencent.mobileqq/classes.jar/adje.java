import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.AddAccountActivity;
import com.tencent.mobileqq.widget.CustomSafeEditText;

public class adje
  implements TextWatcher
{
  public adje(AddAccountActivity paramAddAccountActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    AddAccountActivity.a(this.a, null);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AddAccountActivity.a(this.a, paramCharSequence.toString());
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount != null)
    {
      paramCharSequence = paramCharSequence.toString();
      if ((paramCharSequence != null) && (AddAccountActivity.a(this.a) != null) && (AddAccountActivity.a(this.a).length() != paramCharSequence.length()) && (paramInt3 != 0)) {
        BaseApplicationImpl.sApplication.refreAccountList();
      }
      AddAccountActivity.a(this.a, null);
      if ((AddAccountActivity.a(this.a) == null) || (AddAccountActivity.a(this.a).length() == 0)) {}
      do
      {
        return;
        if ((paramCharSequence == null) || (paramCharSequence.length() == 0) || (paramCharSequence.length() != AddAccountActivity.a(this.a).length() + 1))
        {
          BaseApplicationImpl.sApplication.refreAccountList();
          return;
        }
        if ((!paramCharSequence.substring(0, AddAccountActivity.a(this.a).length()).equals(AddAccountActivity.a(this.a))) || (this.a.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText == null)) {
          break;
        }
        paramCharSequence = paramCharSequence.substring(AddAccountActivity.a(this.a).length());
      } while ((paramCharSequence == null) || (paramCharSequence.length() != 1));
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setText(paramCharSequence);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setSelection(1);
    }
    AddAccountActivity.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adje
 * JD-Core Version:    0.7.0.1
 */