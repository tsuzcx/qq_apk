import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PublicAccountListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aeof
  implements View.OnClickListener
{
  public aeof(PublicAccountListActivity paramPublicAccountListActivity) {}
  
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
      aeou.a(this.a);
      olh.a(this.a.app, "P_CliOper", "Pb_account_lifeservice", "", "0X800573A", "0X800573A", 0, 0, "", "", "", "", false);
      Object localObject1 = (bbbq)this.a.app.getManager(QQManagerFactory.MGR_RED_TOUCH);
      Object localObject2 = ((bbbq)localObject1).a("101000.101001");
      if ((localObject2 != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get() == 1)) {
        bdla.b(this.a.app, "P_CliOper", "Pb_account_lifeservice", "", "0X80060E3", "0X80060E3", 0, 0, "", "", "", "");
      }
      ((bbbq)localObject1).b("101000.101001");
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
        nwu.a(this.a.app, this.a, (String)localObject2, (String)localObject1, "IvrEnterpriseDetailEngineFalse");
        continue;
        aeou.a(this.a, (String)this.a.d.getTag());
        olh.a(this.a.app, "P_CliOper", "Pb_account_lifeservice", "", "0X800573D", "0X800573D", 0, 0, "", "", "", "", false);
        continue;
        aeou.a(this.a, (String)this.a.d.getTag());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeof
 * JD-Core Version:    0.7.0.1
 */