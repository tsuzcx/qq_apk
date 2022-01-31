import android.graphics.Color;
import android.os.Build.VERSION;
import android.widget.TextView;
import com.tencent.biz.qqstory.view.widget.TipsView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tribe.view.TEditText;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;

public class aije
  implements Runnable
{
  public aije(TroopBarPublishActivity paramTroopBarPublishActivity) {}
  
  public void run()
  {
    TroopBarPublishActivity localTroopBarPublishActivity = this.a;
    TEditText localTEditText = this.a.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText;
    int j = DisplayUtil.a(this.a, 71.0F);
    if (Build.VERSION.SDK_INT < 19)
    {
      i = DisplayUtil.a(this.a, 20.0F);
      TipsView.a(localTroopBarPublishActivity, localTEditText, "添加话题，更快上热门", 1, 1, j, i, DisplayUtil.a(this.a, 20.0F), 5000, Color.argb(204, 0, 0, 0));
      SharedPreUtils.a(this.a, this.a.app.getCurrentAccountUin(), "tribe_video_post_has_show_tips", true);
      if ((this.a.jdField_b_of_type_AndroidWidgetTextView == null) || (this.a.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0)) {
        break label150;
      }
    }
    label150:
    for (int i = 2;; i = 1)
    {
      ReportController.b(null, "dc00899", "Grp_tribe", "", "post", "Clk_guide", i, 0, "", "", "", "");
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aije
 * JD-Core Version:    0.7.0.1
 */