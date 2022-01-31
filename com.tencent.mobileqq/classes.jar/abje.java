import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PublicAccountListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;

public class abje
  implements View.OnClickListener
{
  public abje(PublicAccountListActivity paramPublicAccountListActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131302804: 
    case 2131302832: 
    case 2131298261: 
      Object localObject;
      do
      {
        return;
        this.a.finish();
        return;
        abjt.a(this.a);
        ndn.a(this.a.app, "P_CliOper", "Pb_account_lifeservice", "", "0X800573A", "0X800573A", 0, 0, "", "", "", "", false);
        paramView = (auqh)this.a.app.getManager(36);
        localObject = paramView.a("101000.101001");
        if ((localObject != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() == 1)) {
          awqx.b(this.a.app, "P_CliOper", "Pb_account_lifeservice", "", "0X80060E3", "0X80060E3", 0, 0, "", "", "", "");
        }
        paramView.b("101000.101001");
        return;
        localObject = (String)paramView.getTag(-1);
        paramView = (String)paramView.getTag(-2);
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramView))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.w("PublicAccountListActivity", 2, "onClick - uin = " + (String)localObject + ", name = " + paramView);
      return;
      mqb.a(this.a.app, this.a, paramView, (String)localObject, "IvrEnterpriseDetailEngineFalse");
      return;
    case 2131306411: 
      abjt.a(this.a, (String)this.a.d.getTag());
      ndn.a(this.a.app, "P_CliOper", "Pb_account_lifeservice", "", "0X800573D", "0X800573D", 0, 0, "", "", "", "", false);
      return;
    }
    abjt.a(this.a, (String)this.a.d.getTag());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abje
 * JD-Core Version:    0.7.0.1
 */