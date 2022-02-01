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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class adkl
  implements View.OnClickListener
{
  public adkl(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null)
    {
      this.a.getWindow().setSoftInputMode(2);
      this.a.a.hideSoftInputFromWindow(AddFriendVerifyActivity.a(this.a).getWindowToken(), 0);
      AddFriendVerifyActivity.a(this.a).clearFocus();
    }
    Object localObject = AddFriendVerifyActivity.a(this.a).getText().toString();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      if (!this.a.isFinishing())
      {
        localObject = new njt(this.a);
        ((njt)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(anni.a(2131698660));
        ((njt)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846160);
        ((njt)localObject).a();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (((String)localObject).length() > 90)
      {
        localObject = new ReportDialog(this.a, 2131755823);
        ((Dialog)localObject).setContentView(2131562815);
        ((TextView)((Dialog)localObject).findViewById(2131365475)).setText(this.a.getString(2131690952));
        ((ProgressBar)((Dialog)localObject).findViewById(2131366957)).setVisibility(8);
        ((ImageView)((Dialog)localObject).findViewById(2131380280)).setImageResource(2130839586);
        ((Dialog)localObject).show();
      }
      else
      {
        this.a.a(AddFriendVerifyActivity.a(this.a).getText().toString(), true);
        if (bgnt.d(this.a)) {
          AddFriendVerifyActivity.a(this.a, AddFriendVerifyActivity.a(this.a), AddFriendVerifyActivity.a(this.a).getText().toString(), this.a.getIntent().getIntExtra("stat_option", 0), 2000);
        } else {
          QQToast.a(this.a, 1, 2131693948, 0).b(this.a.getTitleBarHeight());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adkl
 * JD-Core Version:    0.7.0.1
 */