import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.style.ClickableSpan;
import android.view.View;

class ados
  extends ClickableSpan
{
  ados(adop paramadop) {}
  
  public void onClick(View paramView)
  {
    if (!bbfj.d(this.a.a))
    {
      bcql.a(this.a.a, ajya.a(2131703236), 2000).a();
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
 * Qualified Name:     ados
 * JD-Core Version:    0.7.0.1
 */