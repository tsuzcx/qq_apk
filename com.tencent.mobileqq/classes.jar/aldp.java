import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aldp
  implements View.OnClickListener
{
  aldp(aldh paramaldh) {}
  
  public void onClick(View paramView)
  {
    try
    {
      bhdj.a(aldh.a(this.a), 0, null, anvx.a(2131700416), 2131690697, 2131694399, new aldq(this), new aldr(this)).show();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("Q.recent.banner", 1, "show dialog err, errInfo->" + localThrowable.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aldp
 * JD-Core Version:    0.7.0.1
 */