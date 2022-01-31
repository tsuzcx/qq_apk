import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class accs
  implements View.OnClickListener
{
  public accs(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  public void onClick(View paramView)
  {
    if (!AddFriendVerifyActivity.a(this.a)) {
      return;
    }
    if (this.a.a != null)
    {
      this.a.getWindow().setSoftInputMode(2);
      this.a.a.hideSoftInputFromWindow(AddFriendVerifyActivity.a(this.a).getWindowToken(), 0);
      AddFriendVerifyActivity.a(this.a).clearFocus();
    }
    if (AddFriendVerifyActivity.a(this.a).getText().toString().length() > 90)
    {
      paramView = new Dialog(this.a, 2131755801);
      paramView.setContentView(2131562577);
      ((TextView)paramView.findViewById(2131365233)).setText(this.a.getString(2131691149));
      ((ProgressBar)paramView.findViewById(2131366695)).setVisibility(8);
      ((ImageView)paramView.findViewById(2131379354)).setImageResource(2130839407);
      paramView.show();
      return;
    }
    this.a.a(AddFriendVerifyActivity.a(this.a).getText().toString(), true);
    if (bdin.d(this.a))
    {
      if (AddFriendVerifyActivity.a(this.a) != null) {}
      for (int i = AddFriendVerifyActivity.a(this.a).a();; i = 2000)
      {
        QLog.e("AddFriendVerifyActivity", 1, "joinTroop templateId: " + i);
        AddFriendVerifyActivity.a(this.a, AddFriendVerifyActivity.a(this.a), AddFriendVerifyActivity.a(this.a).getText().toString(), this.a.getIntent().getIntExtra("stat_option", 0), i);
        azqs.b(null, "dc00898", "", "", "qq_vip", "0X800A62B", afxb.a(i), 0, "", "", "", "");
        if (!"d2g".equals(this.a.getIntent().getStringExtra("jump_from"))) {
          break;
        }
        azqs.b(this.a.app, "P_CliOper", "Grp_discuss", "", "discuss_set", "send_ask", 0, 0, AddFriendVerifyActivity.a(this.a), "", "", "");
        return;
      }
    }
    QQToast.a(this.a, 1, 2131694768, 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     accs
 * JD-Core Version:    0.7.0.1
 */