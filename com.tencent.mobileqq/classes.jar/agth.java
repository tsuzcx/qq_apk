import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.widget.QQToast;

class agth
  extends ClickableSpan
{
  agth(agte paramagte) {}
  
  public void onClick(View paramView)
  {
    if (!bgnt.d(this.a.a))
    {
      QQToast.a(this.a.a, anni.a(2131702017), 2000).a();
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
 * Qualified Name:     agth
 * JD-Core Version:    0.7.0.1
 */