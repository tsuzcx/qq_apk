import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class agxv
  implements View.OnClickListener
{
  agxv(agxq paramagxq) {}
  
  public void onClick(View paramView)
  {
    try
    {
      babr.a(agxq.a(this.a), 0, null, ajjy.a(2131635123), 2131625035, 2131629116, new agxw(this), new agxx(this)).show();
      return;
    }
    catch (Throwable paramView)
    {
      QLog.e("Q.recent.banner", 1, "show dialog err, errInfo->" + paramView.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agxv
 * JD-Core Version:    0.7.0.1
 */