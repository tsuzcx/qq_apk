import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;

class afgu
  implements View.OnClickListener
{
  afgu(afgs paramafgs) {}
  
  public void onClick(View paramView)
  {
    paramView = (ajls)this.a.a.getManager(159);
    Intent localIntent = new Intent(afgs.a(this.a), QQBrowserActivity.class);
    localIntent.putExtra("url", paramView.a);
    afgs.b(this.a).startActivity(localIntent);
    awqx.b(null, "dc00899", "Grp_recom", "", "link_top", "clk_skip_page", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afgu
 * JD-Core Version:    0.7.0.1
 */