import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.style.ClickableSpan;
import android.view.View;

class adds
  extends ClickableSpan
{
  adds(addp paramaddp) {}
  
  public void onClick(View paramView)
  {
    if (!badq.d(this.a.a))
    {
      bbmy.a(this.a.a, ajjy.a(2131637440), 2000).a();
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
 * Qualified Name:     adds
 * JD-Core Version:    0.7.0.1
 */