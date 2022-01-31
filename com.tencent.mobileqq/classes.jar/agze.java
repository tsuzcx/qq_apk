import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qrcode.activity.QRLoginMgrActivity;
import com.tencent.mobileqq.app.BaseActivity;

class agze
  implements View.OnClickListener
{
  agze(agxq paramagxq) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.c != null) && ("1600000104".equals(this.a.c.trim())))
    {
      this.a.k();
      return;
    }
    paramView = new Intent(agxq.a(this.a), QRLoginMgrActivity.class);
    paramView.putExtra("qrlogin_position", this.a.b);
    paramView.putExtra("qrlogin_appid", this.a.a);
    agxq.a(this.a).startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agze
 * JD-Core Version:    0.7.0.1
 */