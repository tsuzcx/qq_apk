import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AboutActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class acac
  implements View.OnClickListener
{
  public acac(AboutActivity paramAboutActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, QQBrowserActivity.class);
    paramView.putExtra("uin", this.a.app.getCurrentAccountUin());
    this.a.startActivity(paramView.putExtra("url", AboutActivity.a(this.a)));
    azqs.b(this.a.app, "CliOper", "", "", "0X8005745", "0X8005745", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acac
 * JD-Core Version:    0.7.0.1
 */