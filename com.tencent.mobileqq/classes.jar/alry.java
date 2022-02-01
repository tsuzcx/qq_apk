import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.PastablePwdEditText;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.List;

public class alry
  implements TextWatcher
{
  public alry(LoginView paramLoginView) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount != null) {
      LoginView.a(this.a, null);
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
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      paramCharSequence = localSimpleAccount.getUin();
      label126:
      if (!str.equals(paramCharSequence)) {
        break label308;
      }
      if ((localSimpleAccount != null) && (localSimpleAccount.isLogined())) {
        if (!LoginView.i(this.a))
        {
          LoginView.i(this.a, true);
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
          paramCharSequence = this.a.c;
          if ((!LoginView.d(this.a)) && (!LoginView.e(this.a)) && (!LoginView.f(this.a)) && (!LoginView.g(this.a))) {
            break label310;
          }
        }
      }
    }
    label308:
    label310:
    for (paramInt1 = 2130846982;; paramInt1 = 2130844711)
    {
      paramCharSequence.setImageResource(paramInt1);
      this.a.c.setContentDescription(anzj.a(2131705243));
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setText("!@#ewaGbhkc$!!=");
      this.a.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = localSimpleAccount;
      LoginView.c(this.a);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setClearButtonVisible(false);
      return;
      paramCharSequence = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(localSimpleAccount.getUin());
      break label126;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alry
 * JD-Core Version:    0.7.0.1
 */