import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.widget.QQToast;

class afhc
  extends ClickableSpan
{
  afhc(afgz paramafgz) {}
  
  public void onClick(View paramView)
  {
    if (!bdee.d(this.a.a))
    {
      QQToast.a(this.a.a, alpo.a(2131703608), 2000).a();
      return;
    }
    paramView = new Intent();
    paramView.setFlags(268435456);
    paramView.setAction("android.intent.action.VIEW");
    paramView.putExtra("devlock_open_source", "SmartDeviceMsg");
    paramView.setData(Uri.parse("mqqdevlock://devlock/open?"));
    this.a.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afhc
 * JD-Core Version:    0.7.0.1
 */