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
import com.tencent.mobileqq.widget.QQToast;

public class acde
  implements View.OnClickListener
{
  public acde(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
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
        paramView = new nba(this.a);
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131700253));
        paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849839);
        paramView.a();
      }
      return;
    }
    if (paramView.length() > 90)
    {
      paramView = new Dialog(this.a, 2131755801);
      paramView.setContentView(2131562577);
      ((TextView)paramView.findViewById(2131365233)).setText(this.a.getString(2131691149));
      ((ProgressBar)paramView.findViewById(2131366695)).setVisibility(8);
      ((ImageView)paramView.findViewById(2131379354)).setImageResource(2130839407);
      paramView.show();
      return;
    }
    this.a.a(paramView, true);
    if (bdin.d(this.a))
    {
      AddFriendVerifyActivity.a(this.a, AddFriendVerifyActivity.a(this.a), paramView, this.a.getIntent().getIntExtra("stat_option", 0), 2000);
      return;
    }
    QQToast.a(this.a, 1, 2131694768, 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acde
 * JD-Core Version:    0.7.0.1
 */