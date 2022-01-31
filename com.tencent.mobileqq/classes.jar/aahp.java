import android.app.Dialog;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.widget.ClearableEditText;

public class aahp
  implements View.OnClickListener
{
  public aahp(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null)
    {
      this.a.getWindow().setSoftInputMode(2);
      this.a.a.hideSoftInputFromWindow(AddFriendVerifyActivity.a(this.a).getWindowToken(), 0);
      AddFriendVerifyActivity.a(this.a).clearFocus();
    }
    paramView = AddFriendVerifyActivity.a(this.a).getText().toString().trim();
    if (TextUtils.isEmpty(paramView))
    {
      if (!this.a.isFinishing())
      {
        paramView = new myg(this.a);
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131699872));
        paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849333);
        paramView.a();
      }
      return;
    }
    if (paramView.length() > 90)
    {
      paramView = new Dialog(this.a, 2131755791);
      paramView.setContentView(2131562355);
      ((TextView)paramView.findViewById(2131365146)).setText(this.a.getString(2131691095));
      ((ProgressBar)paramView.findViewById(2131366570)).setVisibility(8);
      ((ImageView)paramView.findViewById(2131378678)).setImageResource(2130839317);
      paramView.show();
      return;
    }
    this.a.a(paramView, true);
    if (bbfj.d(this.a))
    {
      AddFriendVerifyActivity.a(this.a, AddFriendVerifyActivity.a(this.a), paramView, this.a.getIntent().getIntExtra("stat_option", 0), 2000);
      return;
    }
    bcql.a(this.a, 1, 2131694610, 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aahp
 * JD-Core Version:    0.7.0.1
 */