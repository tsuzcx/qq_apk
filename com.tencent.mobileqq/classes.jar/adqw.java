import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.widget.RotateSwitchImageView;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adqw
  implements View.OnClickListener
{
  public adqw(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    if (!(paramView instanceof RotateSwitchImageView)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      View localView1 = AccountManageActivity.a(this.a, paramView);
      View localView2 = AccountManageActivity.b(this.a, paramView);
      ViewGroup.LayoutParams localLayoutParams;
      if (AccountManageActivity.a(this.a) == null)
      {
        AccountManageActivity.a(this.a, (RotateSwitchImageView)paramView);
        ((RotateSwitchImageView)paramView).b();
        localLayoutParams = localView2.getLayoutParams();
        localLayoutParams.width = ((int)(AccountManageActivity.a(this.a) - AccountManageActivity.g(this.a) * 75.0F));
        localView2.setLayoutParams(localLayoutParams);
        if ((localView1 instanceof ShaderAnimLayout)) {
          ((ShaderAnimLayout)localView1).b();
        }
        if (AppSetting.c) {
          paramView.setContentDescription(this.a.getString(2131690963));
        }
      }
      else if (AccountManageActivity.a(this.a) == paramView)
      {
        AccountManageActivity.a(this.a).a();
        localLayoutParams = localView2.getLayoutParams();
        localLayoutParams.width = ((int)(AccountManageActivity.a(this.a) - AccountManageActivity.h(this.a) * 40.0F));
        localView2.setLayoutParams(localLayoutParams);
        if ((localView1 instanceof ShaderAnimLayout)) {
          ((ShaderAnimLayout)localView1).f();
        }
        AccountManageActivity.a(this.a, null);
        if (AppSetting.c) {
          paramView.setContentDescription(this.a.getString(2131690975));
        }
      }
      else
      {
        AccountManageActivity.a(this.a).a();
        ((RotateSwitchImageView)paramView).b();
        AccountManageActivity.b(this.a, AccountManageActivity.a(this.a)).getLayoutParams().width = ((int)(AccountManageActivity.a(this.a) - AccountManageActivity.i(this.a) * 40.0F));
        localLayoutParams = localView2.getLayoutParams();
        localLayoutParams.width = ((int)(AccountManageActivity.a(this.a) - AccountManageActivity.j(this.a) * 75.0F));
        localView2.setLayoutParams(localLayoutParams);
        if ((localView1 instanceof ShaderAnimLayout)) {
          ((ShaderAnimLayout)localView1).b();
        }
        localView1 = AccountManageActivity.a(this.a, AccountManageActivity.a(this.a));
        if ((localView1 instanceof ShaderAnimLayout)) {
          ((ShaderAnimLayout)localView1).f();
        }
        AccountManageActivity.a(this.a, (RotateSwitchImageView)paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adqw
 * JD-Core Version:    0.7.0.1
 */