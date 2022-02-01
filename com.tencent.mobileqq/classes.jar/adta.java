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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class adta
  implements View.OnClickListener
{
  public adta(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  public void onClick(View paramView)
  {
    if (!AddFriendVerifyActivity.a(this.a)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.a != null)
      {
        this.a.getWindow().setSoftInputMode(2);
        this.a.a.hideSoftInputFromWindow(AddFriendVerifyActivity.a(this.a).getWindowToken(), 0);
        AddFriendVerifyActivity.a(this.a).clearFocus();
      }
      if (AddFriendVerifyActivity.a(this.a).getText().toString().length() > 90)
      {
        ReportDialog localReportDialog = new ReportDialog(this.a, 2131755824);
        localReportDialog.setContentView(2131562849);
        ((TextView)localReportDialog.findViewById(2131365519)).setText(this.a.getString(2131690952));
        ((ProgressBar)localReportDialog.findViewById(2131367008)).setVisibility(8);
        ((ImageView)localReportDialog.findViewById(2131380466)).setImageResource(2130839595);
        localReportDialog.show();
      }
      else
      {
        this.a.a(AddFriendVerifyActivity.a(this.a).getText().toString(), true);
        if (bhnv.d(this.a))
        {
          if (AddFriendVerifyActivity.a(this.a) != null) {}
          for (int i = AddFriendVerifyActivity.a(this.a).a();; i = 2000)
          {
            QLog.e("AddFriendVerifyActivity", 1, "joinTroop templateId: " + i);
            AddFriendVerifyActivity.a(this.a, AddFriendVerifyActivity.a(this.a), AddFriendVerifyActivity.a(this.a).getText().toString(), this.a.getIntent().getIntExtra("stat_option", 0), i);
            bdll.b(null, "dc00898", "", "", "qq_vip", "0X800A62B", ahnj.a(i), 0, "", "", "", "");
            if (!"d2g".equals(this.a.getIntent().getStringExtra("jump_from"))) {
              break;
            }
            bdll.b(this.a.app, "P_CliOper", "Grp_discuss", "", "discuss_set", "send_ask", 0, 0, AddFriendVerifyActivity.a(this.a), "", "", "");
            break;
          }
        }
        QQToast.a(this.a, 1, 2131693965, 0).b(this.a.getTitleBarHeight());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adta
 * JD-Core Version:    0.7.0.1
 */