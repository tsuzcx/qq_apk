import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qrcode.activity.QRLoginMgrActivity;
import com.tencent.mobileqq.app.BaseActivity;

class ajhp
  implements View.OnClickListener
{
  ajhp(ajgb paramajgb) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.c != null) && ("1600000104".equals(this.a.c.trim())))
    {
      this.a.k();
      return;
    }
    paramView = new Intent(ajgb.a(this.a), QRLoginMgrActivity.class);
    paramView.putExtra("qrlogin_position", this.a.b);
    paramView.putExtra("qrlogin_appid", this.a.a);
    ajgb.a(this.a).startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajhp
 * JD-Core Version:    0.7.0.1
 */