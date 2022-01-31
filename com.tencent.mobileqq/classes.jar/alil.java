import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.open.agent.AuthorityLoginView;
import com.tencent.open.agent.QuickLoginAuthorityActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.Login;
import java.util.ArrayList;

class alil
  implements Runnable
{
  alil(alik paramalik) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityLoginView.c(this.a.jdField_a_of_type_JavaLangString);
    Object localObject = ((TextView)this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityLoginView.jdField_a_of_type_AndroidViewView.findViewById(2131365731)).getText().toString();
    if ((localObject != null) && (((String)localObject).equals(this.a.jdField_a_of_type_JavaLangString)))
    {
      if (this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityLoginView.jdField_a_of_type_JavaUtilArrayList.size() != 1) {
        break label294;
      }
      if ((AuthorityLoginView.a(this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityLoginView) == null) || (!(AuthorityLoginView.a(this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityLoginView) instanceof AuthorityActivity))) {
        break label228;
      }
      localObject = new Intent(AuthorityLoginView.a(this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityLoginView), Login.class);
      ((Intent)localObject).putExtra("key_req_src", 1);
      ((Intent)localObject).putExtra("is_first_login", true);
      ((AuthorityActivity)AuthorityLoginView.a(this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityLoginView)).jdField_a_of_type_JavaLangString = null;
      ((AuthorityActivity)AuthorityLoginView.a(this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityLoginView)).startActivityForResult((Intent)localObject, 1);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AuthorityLoginView", 2, "--> after delete account");
      }
      this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityLoginView.b();
      ((BaseActivity)AuthorityLoginView.a(this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityLoginView)).runOnUiThread(new alin(this));
      return;
      label228:
      if ((AuthorityLoginView.a(this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityLoginView) != null) && ((AuthorityLoginView.a(this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityLoginView) instanceof QuickLoginAuthorityActivity)))
      {
        ((QuickLoginAuthorityActivity)AuthorityLoginView.a(this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityLoginView)).jdField_a_of_type_JavaLangString = null;
        ((QuickLoginAuthorityActivity)AuthorityLoginView.a(this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityLoginView)).a(null);
      }
    }
    label294:
    int i = 0;
    label296:
    if (i < this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityLoginView.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localObject = (String)this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityLoginView.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (this.a.jdField_a_of_type_JavaLangString.equals(localObject)) {}
    }
    for (;;)
    {
      ((BaseActivity)AuthorityLoginView.a(this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityLoginView)).runOnUiThread(new alim(this, (String)localObject));
      break;
      i += 1;
      break label296;
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alil
 * JD-Core Version:    0.7.0.1
 */