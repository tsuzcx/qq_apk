import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;

class afuh
  implements View.OnClickListener
{
  afuh(afug paramafug) {}
  
  public void onClick(View paramView)
  {
    paramView = (String)paramView.getTag();
    if (!TextUtils.isEmpty(paramView))
    {
      ajae.b(this.a.jdField_a_of_type_AndroidContentContext, paramView);
      if ((this.a.m > 0) && ((this.a.n == 2) || (this.a.n == 3))) {
        azmj.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "wrap.aiotail.click", 0, 0, "" + this.a.m, "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afuh
 * JD-Core Version:    0.7.0.1
 */