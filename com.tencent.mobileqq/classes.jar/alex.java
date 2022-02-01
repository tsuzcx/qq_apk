import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qrcode.activity.QRLoginMgrActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class alex
  implements View.OnClickListener
{
  alex(aldh paramaldh) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.c != null) && ("1600000104".equals(this.a.c.trim()))) {
      this.a.l();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Intent localIntent = new Intent(aldh.a(this.a), QRLoginMgrActivity.class);
      localIntent.putExtra("qrlogin_position", this.a.b);
      localIntent.putExtra("qrlogin_appid", this.a.a);
      aldh.a(this.a).startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alex
 * JD-Core Version:    0.7.0.1
 */