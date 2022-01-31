import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.style.ClickableSpan;
import android.view.View;

class adou
  extends ClickableSpan
{
  adou(ador paramador) {}
  
  public void onClick(View paramView)
  {
    if (!bbev.d(this.a.a))
    {
      bcpw.a(this.a.a, ajyc.a(2131703225), 2000).a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adou
 * JD-Core Version:    0.7.0.1
 */