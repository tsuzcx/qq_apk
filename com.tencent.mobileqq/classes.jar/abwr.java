import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.activity.AccountManageActivity.4.1;
import com.tencent.mobileqq.widget.RotateSwitchImageView;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import mqq.os.MqqHandler;

public class abwr
  implements View.OnClickListener
{
  public abwr(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.b) {
      return;
    }
    paramView = this.a;
    boolean bool;
    label102:
    int i;
    if (!this.a.jdField_a_of_type_Boolean)
    {
      bool = true;
      paramView.jdField_a_of_type_Boolean = bool;
      if (!this.a.jdField_a_of_type_Boolean) {
        break label214;
      }
      this.a.rightViewText.setVisibility(8);
      this.a.rightHighLView.setVisibility(0);
      this.a.rightViewText.setText(2131692680);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131166981));
      if (AccountManageActivity.a(this.a) != null)
      {
        paramView = AccountManageActivity.a(this.a, AccountManageActivity.a(this.a));
        if ((paramView instanceof ShaderAnimLayout)) {
          ((ShaderAnimLayout)paramView).f();
        }
        AccountManageActivity.a(this.a).a();
        AccountManageActivity.a(this.a, null);
      }
      int j = this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      i = 0;
      label173:
      if (i >= j) {
        break label321;
      }
      paramView = this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      if ((paramView != null) && (paramView.getTag() != null)) {
        break label274;
      }
    }
    for (;;)
    {
      i += 1;
      break label173;
      bool = false;
      break;
      label214:
      this.a.rightViewText.setVisibility(0);
      this.a.rightHighLView.setVisibility(8);
      this.a.rightViewText.setText(2131692016);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColorStateList(2131166909));
      break label102;
      label274:
      paramView = paramView.findViewById(2131370961);
      if (paramView != null)
      {
        ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
        localLayoutParams.width = ((int)(AccountManageActivity.a(this.a) * AccountManageActivity.b(this.a)));
        paramView.setLayoutParams(localLayoutParams);
      }
    }
    label321:
    this.a.b();
    this.a.a(this.a.jdField_a_of_type_Boolean);
    this.a.b = false;
    AccountManageActivity.a(this.a).postDelayed(new AccountManageActivity.4.1(this), 400L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abwr
 * JD-Core Version:    0.7.0.1
 */