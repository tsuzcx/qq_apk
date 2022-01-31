import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.observer.SubAccountObserver;

public class adzp
  implements View.OnClickListener
{
  public adzp(SubAccountBindActivity paramSubAccountBindActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.findViewById(2131364239);
    if ((localObject != null) && (((View)localObject).getVisibility() == 0)) {}
    bada localbada;
    do
    {
      do
      {
        return;
        int i = ((Integer)paramView.getTag()).intValue();
        paramView = (SimpleAccount)SubAccountBindActivity.a(this.a).get(i);
        localObject = (badd)this.a.app.getManager(61);
        if (((badd)localObject).a(paramView.getUin()))
        {
          this.a.c(this.a.getString(2131720400));
          bact.a(this.a.app);
          this.a.setTitle("");
          paramView = new Intent(this.a, SplashActivity.class);
          paramView.putExtra("tab_index", MainFragment.b);
          paramView.setFlags(67108864);
          this.a.startActivity(paramView);
          this.a.finish();
          return;
        }
        if (((badd)localObject).a() >= 2)
        {
          bacu.a(this.a.app, this.a);
          return;
        }
        if (!paramView.isLogined())
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.subaccount.SubAccountBindActivity", 2, "onSelectAccountClick.onClick:add account");
          }
          localObject = new Intent(this.a, SubLoginActivity.class);
          ((Intent)localObject).putExtra("subuin", paramView.getUin());
          ((Intent)localObject).putExtra("fromWhere", this.a.b);
          this.a.startActivity((Intent)localObject);
          return;
        }
      } while (!this.a.c());
      localObject = ((badd)localObject).a(paramView.getUin());
      this.a.a(2131720402);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new adzq(this, paramView);
        this.a.getAppRuntime().getSubAccountKey(this.a.app.getAccount(), paramView.getUin(), (SubAccountObserver)localObject);
        return;
      }
      localbada = (bada)this.a.app.getManager(28);
    } while (localbada == null);
    localbada.a(paramView.getUin(), (String)localObject, this.a.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adzp
 * JD-Core Version:    0.7.0.1
 */