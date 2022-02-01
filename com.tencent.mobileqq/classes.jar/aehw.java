import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.observer.SubAccountObserver;

public class aehw
  implements View.OnClickListener
{
  public aehw(SubAccountBindActivity paramSubAccountBindActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.findViewById(2131364509);
    if ((localObject1 != null) && (((View)localObject1).getVisibility() == 0)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int i = ((Integer)paramView.getTag()).intValue();
      localObject1 = (SimpleAccount)SubAccountBindActivity.a(this.a).get(i);
      Object localObject2 = (bcqt)this.a.app.getManager(61);
      if (((bcqt)localObject2).a(((SimpleAccount)localObject1).getUin()))
      {
        this.a.c(this.a.getString(2131718657));
        bcqj.a(this.a.app);
        this.a.setTitle("");
        localObject1 = new Intent(this.a, SplashActivity.class);
        ((Intent)localObject1).putExtra("tab_index", MainFragment.b);
        ((Intent)localObject1).setFlags(67108864);
        this.a.startActivity((Intent)localObject1);
        this.a.finish();
      }
      else if (((bcqt)localObject2).a() >= 2)
      {
        bcqk.a(this.a.app, this.a);
      }
      else if (!((SimpleAccount)localObject1).isLogined())
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.subaccount.SubAccountBindActivity", 2, "onSelectAccountClick.onClick:add account");
        }
        localObject2 = new Intent(this.a, SubLoginActivity.class);
        ((Intent)localObject2).putExtra("subuin", ((SimpleAccount)localObject1).getUin());
        ((Intent)localObject2).putExtra("fromWhere", this.a.b);
        this.a.startActivity((Intent)localObject2);
      }
      else if (this.a.c())
      {
        localObject2 = ((bcqt)localObject2).a(((SimpleAccount)localObject1).getUin());
        this.a.a(2131718659);
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject2 = new aehx(this, (SimpleAccount)localObject1);
          this.a.getAppRuntime().getSubAccountKey(this.a.app.getAccount(), ((SimpleAccount)localObject1).getUin(), (SubAccountObserver)localObject2);
        }
        else
        {
          bcqq localbcqq = (bcqq)this.a.app.getManager(28);
          if (localbcqq != null) {
            localbcqq.a(((SimpleAccount)localObject1).getUin(), (String)localObject2, this.a.b);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aehw
 * JD-Core Version:    0.7.0.1
 */