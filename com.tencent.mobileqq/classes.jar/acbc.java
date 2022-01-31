import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.activity.AccountManageActivity.3.1;
import com.tencent.mobileqq.widget.RotateSwitchImageView;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import mqq.os.MqqHandler;

public class acbc
  implements View.OnClickListener
{
  public acbc(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.b) {
      return;
    }
    paramView = this.a;
    boolean bool;
    if (!this.a.jdField_a_of_type_Boolean)
    {
      bool = true;
      paramView.jdField_a_of_type_Boolean = bool;
      if (!this.a.jdField_a_of_type_Boolean) {
        break label245;
      }
      this.a.rightViewText.setVisibility(8);
      this.a.rightHighLView.setVisibility(0);
      this.a.rightViewText.setText(2131692682);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131166983));
    }
    for (;;)
    {
      if (AccountManageActivity.a(this.a) != null)
      {
        paramView = AccountManageActivity.a(this.a, AccountManageActivity.a(this.a));
        if ((paramView instanceof ShaderAnimLayout)) {
          ((ShaderAnimLayout)paramView).f();
        }
        AccountManageActivity.a(this.a).a();
        AccountManageActivity.a(this.a, null);
      }
      this.a.b();
      this.a.a(this.a.jdField_a_of_type_Boolean);
      this.a.b = false;
      AccountManageActivity.a(this.a).postDelayed(new AccountManageActivity.3.1(this), 400L);
      azqs.b(this.a.app, "CliOper", "", "", "Setting_tab", "Clk_acc_edit", 0, 0, "", "", "", "");
      return;
      bool = false;
      break;
      label245:
      this.a.rightViewText.setVisibility(0);
      this.a.rightHighLView.setVisibility(8);
      this.a.rightViewText.setText(2131692017);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColorStateList(2131166911));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acbc
 * JD-Core Version:    0.7.0.1
 */