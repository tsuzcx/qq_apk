import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.QWalletAIOLifeCycleHelper.2.1;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class affv
  implements View.OnClickListener
{
  affv(afft paramafft) {}
  
  public void onClick(View paramView)
  {
    try
    {
      azqs.b(afft.a(this.a), "P_CliOper", "Vip_pay_mywallet", "", "500", "idiom.tips.click", 0, 0, "", "", "", "");
      afft.a(this.a).a().postDelayed(new QWalletAIOLifeCycleHelper.2.1(this), 200L);
      this.a.a();
      return;
    }
    catch (Throwable paramView)
    {
      QLog.e("QWalletAIOLifeCycleHelper", 1, "onclick  IdiomRedBagTips throw an exception: " + paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     affv
 * JD-Core Version:    0.7.0.1
 */