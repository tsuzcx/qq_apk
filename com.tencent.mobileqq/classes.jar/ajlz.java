import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ajlz
  implements View.OnClickListener
{
  ajlz(ajlx paramajlx) {}
  
  public void onClick(View paramView)
  {
    anpk localanpk = (anpk)this.a.a.getManager(159);
    Intent localIntent = new Intent(ajlx.a(this.a), QQBrowserActivity.class);
    localIntent.putExtra("url", localanpk.a);
    ajlx.b(this.a).startActivity(localIntent);
    bcst.b(null, "dc00899", "Grp_recom", "", "link_top", "clk_skip_page", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajlz
 * JD-Core Version:    0.7.0.1
 */