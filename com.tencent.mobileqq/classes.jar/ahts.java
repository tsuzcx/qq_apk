import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contacts.fragment.PublicAccountFragment;
import com.tencent.qphone.base.util.QLog;

class ahts
  implements View.OnClickListener
{
  ahts(ahtr paramahtr) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    String str;
    do
    {
      return;
      str = (String)paramView.getTag(-1);
      paramView = (String)paramView.getTag(-2);
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramView))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("Contacts.PublicAccountFragment", 2, "onClick - uin = " + str + ", name = " + paramView);
    return;
    ndv.a(this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramView, str, "IvrEnterpriseDetailEngineFalse");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahts
 * JD-Core Version:    0.7.0.1
 */