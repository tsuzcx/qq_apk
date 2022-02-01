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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

public class acog
  implements View.OnClickListener
{
  public acog(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.b) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = this.a;
      boolean bool;
      label111:
      int i;
      if (!this.a.jdField_a_of_type_Boolean)
      {
        bool = true;
        ((AccountManageActivity)localObject).jdField_a_of_type_Boolean = bool;
        if (!this.a.jdField_a_of_type_Boolean) {
          break label229;
        }
        this.a.rightViewText.setVisibility(8);
        this.a.rightHighLView.setVisibility(0);
        this.a.rightViewText.setText(2131692310);
        this.a.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131167098));
        if (AccountManageActivity.a(this.a) != null)
        {
          localObject = AccountManageActivity.a(this.a, AccountManageActivity.a(this.a));
          if ((localObject instanceof ShaderAnimLayout)) {
            ((ShaderAnimLayout)localObject).hideIgnoreVisible();
          }
          AccountManageActivity.a(this.a).a();
          AccountManageActivity.a(this.a, null);
        }
        int j = this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
        i = 0;
        label185:
        if (i >= j) {
          break label341;
        }
        localObject = this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
        if ((localObject != null) && (((View)localObject).getTag() != null)) {
          break label289;
        }
      }
      for (;;)
      {
        i += 1;
        break label185;
        bool = false;
        break;
        label229:
        this.a.rightViewText.setVisibility(0);
        this.a.rightHighLView.setVisibility(8);
        this.a.rightViewText.setText(2131691727);
        this.a.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColorStateList(2131167020));
        break label111;
        label289:
        localObject = ((View)localObject).findViewById(2131371618);
        if (localObject != null)
        {
          ViewGroup.LayoutParams localLayoutParams = ((View)localObject).getLayoutParams();
          localLayoutParams.width = ((int)(AccountManageActivity.a(this.a) * AccountManageActivity.b(this.a)));
          ((View)localObject).setLayoutParams(localLayoutParams);
        }
      }
      label341:
      this.a.b();
      this.a.a(this.a.jdField_a_of_type_Boolean);
      this.a.b = false;
      AccountManageActivity.a(this.a).postDelayed(new AccountManageActivity.4.1(this), 400L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acog
 * JD-Core Version:    0.7.0.1
 */