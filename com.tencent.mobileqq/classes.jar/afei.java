import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PublicAccountListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afei
  implements View.OnClickListener
{
  public afei(PublicAccountListActivity paramPublicAccountListActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.finish();
      continue;
      afex.a(this.a);
      ocd.a(this.a.app, "P_CliOper", "Pb_account_lifeservice", "", "0X800573A", "0X800573A", 0, 0, "", "", "", "", false);
      Object localObject1 = (bbav)this.a.app.getManager(36);
      Object localObject2 = ((bbav)localObject1).a("101000.101001");
      if ((localObject2 != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get() == 1)) {
        bdll.b(this.a.app, "P_CliOper", "Pb_account_lifeservice", "", "0X80060E3", "0X80060E3", 0, 0, "", "", "", "");
      }
      ((bbav)localObject1).b("101000.101001");
      continue;
      localObject1 = (String)paramView.getTag(-1);
      localObject2 = (String)paramView.getTag(-2);
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2)))
      {
        if (QLog.isColorLevel()) {
          QLog.w("PublicAccountListActivity", 2, "onClick - uin = " + (String)localObject1 + ", name = " + (String)localObject2);
        }
      }
      else
      {
        nok.a(this.a.app, this.a, (String)localObject2, (String)localObject1, "IvrEnterpriseDetailEngineFalse");
        continue;
        afex.a(this.a, (String)this.a.d.getTag());
        ocd.a(this.a.app, "P_CliOper", "Pb_account_lifeservice", "", "0X800573D", "0X800573D", 0, 0, "", "", "", "", false);
        continue;
        afex.a(this.a, (String)this.a.d.getTag());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afei
 * JD-Core Version:    0.7.0.1
 */