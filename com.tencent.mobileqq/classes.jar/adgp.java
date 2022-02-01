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
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class adgp
  implements View.OnClickListener
{
  public adgp(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null)
    {
      this.a.getWindow().setSoftInputMode(2);
      this.a.a.hideSoftInputFromWindow(AddFriendVerifyActivity.a(this.a).getWindowToken(), 0);
      AddFriendVerifyActivity.a(this.a).clearFocus();
    }
    if (this.a.b != 0) {
      bdla.b(null, "dc00898", "", "", "0X800B5B3", "0X800B5B3", 0, 0, "", "", "", "");
    }
    Object localObject = AddFriendVerifyActivity.a(this.a).getText().toString().trim();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      if (!this.a.isFinishing())
      {
        localObject = new nud(this.a);
        ((nud)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131699372));
        ((nud)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850471);
        ((nud)localObject).a();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (((String)localObject).length() > 90)
      {
        localObject = new ReportDialog(this.a, 2131755829);
        ((Dialog)localObject).setContentView(2131562799);
        ((TextView)((Dialog)localObject).findViewById(2131365644)).setText(this.a.getString(2131691077));
        ((ProgressBar)((Dialog)localObject).findViewById(2131367140)).setVisibility(8);
        ((ImageView)((Dialog)localObject).findViewById(2131380525)).setImageResource(2130839653);
        ((Dialog)localObject).show();
      }
      else
      {
        this.a.a((String)localObject, true);
        if (NetworkUtil.isNetSupport(this.a)) {
          AddFriendVerifyActivity.a(this.a, AddFriendVerifyActivity.a(this.a), (String)localObject, this.a.getIntent().getIntExtra("stat_option", 0), 2000);
        } else {
          QQToast.a(this.a, 1, 2131694255, 0).b(this.a.getTitleBarHeight());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adgp
 * JD-Core Version:    0.7.0.1
 */