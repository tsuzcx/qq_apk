import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.activity.AccountManageActivity.3.1;
import com.tencent.mobileqq.widget.RotateSwitchImageView;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

public class adij
  implements View.OnClickListener
{
  public adij(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.b)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    Object localObject = this.a;
    boolean bool;
    if (!this.a.jdField_a_of_type_Boolean)
    {
      bool = true;
      label35:
      ((AccountManageActivity)localObject).jdField_a_of_type_Boolean = bool;
      if (!this.a.jdField_a_of_type_Boolean) {
        break label254;
      }
      this.a.rightViewText.setVisibility(8);
      this.a.rightHighLView.setVisibility(0);
      this.a.rightViewText.setText(2131692257);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131167066));
    }
    for (;;)
    {
      if (AccountManageActivity.a(this.a) != null)
      {
        localObject = AccountManageActivity.a(this.a, AccountManageActivity.a(this.a));
        if ((localObject instanceof ShaderAnimLayout)) {
          ((ShaderAnimLayout)localObject).f();
        }
        AccountManageActivity.a(this.a).a();
        AccountManageActivity.a(this.a, null);
      }
      this.a.b();
      this.a.a(this.a.jdField_a_of_type_Boolean);
      this.a.b = false;
      AccountManageActivity.a(this.a).postDelayed(new AccountManageActivity.3.1(this), 400L);
      bcst.b(this.a.app, "CliOper", "", "", "Setting_tab", "Clk_acc_edit", 0, 0, "", "", "", "");
      break;
      bool = false;
      break label35;
      label254:
      this.a.rightViewText.setVisibility(0);
      this.a.rightHighLView.setVisibility(8);
      this.a.rightViewText.setText(2131691679);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColorStateList(2131166994));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adij
 * JD-Core Version:    0.7.0.1
 */