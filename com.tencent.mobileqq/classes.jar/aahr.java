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

public class aahr
  implements View.OnClickListener
{
  public aahr(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null)
    {
      this.a.getWindow().setSoftInputMode(2);
      this.a.a.hideSoftInputFromWindow(AddFriendVerifyActivity.a(this.a).getWindowToken(), 0);
      AddFriendVerifyActivity.a(this.a).clearFocus();
    }
    paramView = AddFriendVerifyActivity.a(this.a).getText().toString();
    if (TextUtils.isEmpty(paramView))
    {
      if (!this.a.isFinishing())
      {
        paramView = new myj(this.a);
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText(ajyc.a(2131699842));
        paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845301);
        paramView.a();
      }
      return;
    }
    if (paramView.length() > 90)
    {
      paramView = new Dialog(this.a, 2131755791);
      paramView.setContentView(2131562356);
      ((TextView)paramView.findViewById(2131365147)).setText(this.a.getString(2131691095));
      ((ProgressBar)paramView.findViewById(2131366570)).setVisibility(8);
      ((ImageView)paramView.findViewById(2131378673)).setImageResource(2130839317);
      paramView.show();
      return;
    }
    this.a.a(AddFriendVerifyActivity.a(this.a).getText().toString(), true);
    if (bbev.d(this.a))
    {
      AddFriendVerifyActivity.a(this.a, AddFriendVerifyActivity.a(this.a), AddFriendVerifyActivity.a(this.a).getText().toString(), this.a.getIntent().getIntExtra("stat_option", 0), 2000);
      return;
    }
    bcpw.a(this.a, 1, 2131694609, 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aahr
 * JD-Core Version:    0.7.0.1
 */