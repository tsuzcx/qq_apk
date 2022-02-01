import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aglz
  implements View.OnClickListener
{
  aglz(agly paramagly) {}
  
  public void onClick(View paramView)
  {
    String str = (String)paramView.getTag();
    if (!TextUtils.isEmpty(str))
    {
      akgc.b(this.a.jdField_a_of_type_AndroidContentContext, str);
      if ((this.a.m > 0) && ((this.a.n == 2) || (this.a.n == 3))) {
        bcef.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "wrap.aiotail.click", 0, 0, "" + this.a.m, "", "", "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aglz
 * JD-Core Version:    0.7.0.1
 */