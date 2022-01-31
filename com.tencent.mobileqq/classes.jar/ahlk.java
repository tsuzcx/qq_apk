import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.recent.BannerManager.37.1;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.ADView;
import java.util.LinkedList;
import java.util.List;
import mqq.os.MqqHandler;

public class ahlk
  implements View.OnClickListener
{
  ahlk(ahkd paramahkd) {}
  
  public void onClick(View paramView)
  {
    ahkd.a(this.a).getSharedPreferences("mobileQQ", 0).edit().putBoolean("push_banner_display" + ahkd.a(this.a).app.getAccount(), false).commit();
    paramView = ahkd.a(this.a)[21];
    ADView localADView;
    if ((paramView != null) && (paramView.a != null))
    {
      localADView = (ADView)paramView.a.findViewById(2131362147);
      if (localADView == null) {
        break label292;
      }
    }
    label292:
    for (paramView = localADView.a(0);; paramView = null)
    {
      if (paramView != null)
      {
        int j = paramView.getChildCount();
        LinkedList localLinkedList = new LinkedList();
        int i = 0;
        while (i < j)
        {
          View localView = paramView.getChildAt(i);
          if (localView != null) {
            localLinkedList.add((axuj)localView.getTag());
          }
          i += 1;
        }
        ThreadManager.getFileThreadHandler().post(new BannerManager.37.1(this, j, localLinkedList));
        if (localADView != null) {
          localADView.h();
        }
      }
      this.a.a(21, 0);
      this.a.a(-1, null);
      this.a.e = false;
      axqy.b(ahkd.a(this.a).app, "dc00898", "", "", "0X80087C3", "0X80087C3", 0, 0, "", "", "", "");
      axqy.a(ahkd.a(this.a).app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 12, 0, "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahlk
 * JD-Core Version:    0.7.0.1
 */