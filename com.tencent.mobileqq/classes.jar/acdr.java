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

public class acdr
  implements View.OnClickListener
{
  public acdr(SubAccountBindActivity paramSubAccountBindActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.findViewById(2131364175);
    if ((localObject != null) && (((View)localObject).getVisibility() == 0)) {}
    ayav localayav;
    do
    {
      do
      {
        return;
        int i = ((Integer)paramView.getTag()).intValue();
        paramView = (SimpleAccount)SubAccountBindActivity.a(this.a).get(i);
        localObject = (ayax)this.a.app.getManager(61);
        if (((ayax)localObject).a(paramView.getUin()))
        {
          this.a.c(this.a.getString(2131719857));
          ayap.a(this.a.app);
          this.a.setTitle("");
          paramView = new Intent(this.a, SplashActivity.class);
          paramView.putExtra("tab_index", MainFragment.b);
          paramView.setFlags(67108864);
          this.a.startActivity(paramView);
          this.a.finish();
          return;
        }
        if (((ayax)localObject).a() >= 2)
        {
          ayaq.a(this.a.app, this.a);
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
      } while (!this.a.b());
      localObject = ((ayax)localObject).a(paramView.getUin());
      this.a.a(2131719859);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new acds(this, paramView);
        this.a.getAppRuntime().getSubAccountKey(this.a.app.getAccount(), paramView.getUin(), (SubAccountObserver)localObject);
        return;
      }
      localayav = (ayav)this.a.app.getManager(28);
    } while (localayav == null);
    localayav.a(paramView.getUin(), (String)localObject, this.a.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acdr
 * JD-Core Version:    0.7.0.1
 */