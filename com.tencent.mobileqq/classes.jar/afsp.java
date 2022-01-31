import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;

class afsp
  implements View.OnClickListener
{
  afsp(afsn paramafsn) {}
  
  public void onClick(View paramView)
  {
    paramView = (akaa)this.a.a.getManager(159);
    Intent localIntent = new Intent(afsn.a(this.a), QQBrowserActivity.class);
    localIntent.putExtra("url", paramView.a);
    afsn.b(this.a).startActivity(localIntent);
    axqy.b(null, "dc00899", "Grp_recom", "", "link_top", "clk_skip_page", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afsp
 * JD-Core Version:    0.7.0.1
 */