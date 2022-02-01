import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ajxi
  implements View.OnClickListener
{
  ajxi(ajxg paramajxg) {}
  
  public void onClick(View paramView)
  {
    aobl localaobl = (aobl)this.a.a.getManager(159);
    Intent localIntent = new Intent(ajxg.a(this.a), QQBrowserActivity.class);
    localIntent.putExtra("url", localaobl.a);
    ajxg.b(this.a).startActivity(localIntent);
    bdll.b(null, "dc00899", "Grp_recom", "", "link_top", "clk_skip_page", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajxi
 * JD-Core Version:    0.7.0.1
 */