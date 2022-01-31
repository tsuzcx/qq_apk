import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;

class afsr
  implements View.OnClickListener
{
  afsr(afsp paramafsp) {}
  
  public void onClick(View paramView)
  {
    paramView = (akac)this.a.a.getManager(159);
    Intent localIntent = new Intent(afsp.a(this.a), QQBrowserActivity.class);
    localIntent.putExtra("url", paramView.a);
    afsp.b(this.a).startActivity(localIntent);
    axqw.b(null, "dc00899", "Grp_recom", "", "link_top", "clk_skip_page", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afsr
 * JD-Core Version:    0.7.0.1
 */