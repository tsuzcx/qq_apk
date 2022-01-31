import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui.SpringHbTranslucentBrowserActivity;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui.SpringHbVideoView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ahhk
  implements View.OnClickListener
{
  public ahhk(SpringHbTranslucentBrowserActivity paramSpringHbTranslucentBrowserActivity) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("springHb_SpringHbTranslucentBrowserActivity", 2, "user click skip video");
    }
    try
    {
      if (SpringHbTranslucentBrowserActivity.a(this.a) != null) {
        SpringHbTranslucentBrowserActivity.a(this.a).e();
      }
      if (SpringHbTranslucentBrowserActivity.a(this.a) != null)
      {
        long l1 = SpringHbTranslucentBrowserActivity.a(this.a).a() / 1000L;
        long l2 = SpringHbTranslucentBrowserActivity.a(this.a).b() / 1000L;
        paramView = new HashMap();
        paramView.put("ext1", l1 + "");
        paramView.put("ext2", l2 + "");
        ahih.a("sq.kcsp.bw", 0, 0, paramView);
        if (QLog.isColorLevel()) {
          QLog.i("springHb_SpringHbTranslucentBrowserActivity", 2, "onCompletion...duration:" + l1 + ",position:" + l2);
        }
      }
      SpringHbTranslucentBrowserActivity.a(this.a);
      ahih.a("sq.kcsp.tg", 1, 0, null);
      return;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        QLog.e("springHb_SpringHbTranslucentBrowserActivity", 1, "pauseVideo exception", paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahhk
 * JD-Core Version:    0.7.0.1
 */