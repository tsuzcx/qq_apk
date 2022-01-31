import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabel;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.XListView;

public class agns
  implements View.OnClickListener
{
  public agns(PersonalityLabelGalleryActivity paramPersonalityLabelGalleryActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, QQBrowserActivity.class);
    paramView.putExtra("url", "https://ti.qq.com/cgi-node/specialtag/zanlist?_wv=1027&asyncMode=3");
    this.a.startActivity(paramView);
    paramView = PersonalityLabelGalleryActivity.a(this.a);
    paramView.praiseCount += PersonalityLabelGalleryActivity.a(this.a).unreadCount;
    PersonalityLabelGalleryActivity.a(this.a).unreadCount = 0;
    PersonalityLabelGalleryActivity.a(this.a).postDelayed(new agnt(this), 500L);
    ReportController.b(this.a.app, "dc00898", "", "", "0X8007FCF", "0X8007FCF", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agns
 * JD-Core Version:    0.7.0.1
 */