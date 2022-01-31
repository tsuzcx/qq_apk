import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PublicAccountListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;

public class adki
  implements View.OnClickListener
{
  public adki(PublicAccountListActivity paramPublicAccountListActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131368613: 
    case 2131368644: 
    case 2131363871: 
      Object localObject;
      do
      {
        return;
        this.a.finish();
        return;
        adkx.a(this.a);
        nrt.a(this.a.app, "P_CliOper", "Pb_account_lifeservice", "", "0X800573A", "0X800573A", 0, 0, "", "", "", "", false);
        paramView = (axho)this.a.app.getManager(36);
        localObject = paramView.a("101000.101001");
        if ((localObject != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() == 1)) {
          azmj.b(this.a.app, "P_CliOper", "Pb_account_lifeservice", "", "0X80060E3", "0X80060E3", 0, 0, "", "", "", "");
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
      ndv.a(this.a.app, this.a, paramView, (String)localObject, "IvrEnterpriseDetailEngineFalse");
      return;
    case 2131372426: 
      adkx.a(this.a, (String)this.a.d.getTag());
      nrt.a(this.a.app, "P_CliOper", "Pb_account_lifeservice", "", "0X800573D", "0X800573D", 0, 0, "", "", "", "", false);
      return;
    }
    adkx.a(this.a, (String)this.a.d.getTag());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adki
 * JD-Core Version:    0.7.0.1
 */