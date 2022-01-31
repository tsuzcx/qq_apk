import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;

class ahqh
  implements View.OnClickListener
{
  ahqh(ahqf paramahqf) {}
  
  public void onClick(View paramView)
  {
    paramView = (alro)this.a.a.getManager(159);
    Intent localIntent = new Intent(ahqf.a(this.a), QQBrowserActivity.class);
    localIntent.putExtra("url", paramView.a);
    ahqf.b(this.a).startActivity(localIntent);
    azmj.b(null, "dc00899", "Grp_recom", "", "link_top", "clk_skip_page", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahqh
 * JD-Core Version:    0.7.0.1
 */