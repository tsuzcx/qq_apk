import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AboutActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class addj
  implements View.OnClickListener
{
  public addj(AboutActivity paramAboutActivity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.a, QQBrowserActivity.class);
    localIntent.putExtra("uin", this.a.app.getCurrentAccountUin());
    this.a.startActivity(localIntent.putExtra("url", AboutActivity.a(this.a)));
    bdla.b(this.a.app, "CliOper", "", "", "0X8005745", "0X8005745", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     addj
 * JD-Core Version:    0.7.0.1
 */