import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.activity.AddAccountActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.CustomSafeEditText;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.List;

public class aagn
  implements TextWatcher
{
  public aagn(AddAccountActivity paramAddAccountActivity) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount != null) {
      AddAccountActivity.a(this.a, null);
    }
    String str;
    SimpleAccount localSimpleAccount;
    for (;;)
    {
      return;
      if (paramCharSequence != null)
      {
        str = paramCharSequence.toString();
        if ((str == null) || (str.length() == 0) || (this.a.jdField_a_of_type_JavaUtilList == null)) {
          break;
        }
        paramInt1 = 0;
        while (paramInt1 < this.a.jdField_a_of_type_JavaUtilList.size())
        {
          localSimpleAccount = (SimpleAccount)this.a.jdField_a_of_type_JavaUtilList.get(paramInt1);
          if ((localSimpleAccount != null) && (localSimpleAccount.getUin() != null)) {
            break label110;
          }
          paramInt1 += 1;
        }
      }
    }
    label110:
    if (this.a.app == null)
    {
      paramCharSequence = localSimpleAccount.getUin();
      label126:
      if (!str.equals(paramCharSequence)) {
        break label198;
      }
      if ((localSimpleAccount == null) || (!localSimpleAccount.isLogined())) {
        break label200;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setText("!@#ewaGbhkc$!!=");
      this.a.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = localSimpleAccount;
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setClearButtonVisible(false);
      return;
      paramCharSequence = this.a.app.b(localSimpleAccount.getUin());
      break label126;
      label198:
      break;
      label200:
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setText("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aagn
 * JD-Core Version:    0.7.0.1
 */