import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.recent.BannerManager.40.1;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.ADView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.LinkedList;
import java.util.List;
import mqq.os.MqqHandler;

public class allh
  implements View.OnClickListener
{
  allh(aljw paramaljw) {}
  
  public void onClick(View paramView)
  {
    aljw.a(this.a).getSharedPreferences("mobileQQ", 0).edit().putBoolean("push_banner_display" + aljw.a(this.a).app.getAccount(), false).commit();
    Object localObject = aljw.a(this.a)[22];
    ADView localADView;
    if ((localObject != null) && (((aljs)localObject).a != null))
    {
      localADView = (ADView)((aljs)localObject).a.findViewById(2131362236);
      if (localADView == null) {
        break label307;
      }
    }
    label307:
    for (localObject = localADView.a(0);; localObject = null)
    {
      if (localObject != null)
      {
        int j = ((ViewGroup)localObject).getChildCount();
        LinkedList localLinkedList = new LinkedList();
        int i = 0;
        while (i < j)
        {
          View localView = ((ViewGroup)localObject).getChildAt(i);
          if (localView != null) {
            localLinkedList.add((bdof)localView.getTag());
          }
          i += 1;
        }
        ThreadManager.getFileThreadHandler().post(new BannerManager.40.1(this, j, localLinkedList));
        if (localADView != null) {
          localADView.h();
        }
      }
      this.a.a(22, 0);
      this.a.a(-1, null);
      this.a.e = false;
      bdll.b(aljw.a(this.a).app, "dc00898", "", "", "0X80087C3", "0X80087C3", 0, 0, "", "", "", "");
      bdll.a(aljw.a(this.a).app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 12, 0, "", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     allh
 * JD-Core Version:    0.7.0.1
 */