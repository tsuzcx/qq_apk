import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ajnu
  implements View.OnClickListener
{
  ajnu(ajns paramajns) {}
  
  public void onClick(View paramView)
  {
    anyb localanyb = (anyb)this.a.a.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
    Intent localIntent = new Intent(ajns.a(this.a), QQBrowserActivity.class);
    localIntent.putExtra("url", localanyb.a);
    ajns.b(this.a).startActivity(localIntent);
    bdla.b(null, "dc00899", "Grp_recom", "", "link_top", "clk_skip_page", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajnu
 * JD-Core Version:    0.7.0.1
 */