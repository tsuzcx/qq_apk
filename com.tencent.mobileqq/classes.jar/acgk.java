import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.biz.qqstory.troop.activity.TroopStoryMainActivity;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.qphone.base.util.QLog;

public class acgk
  implements View.OnClickListener
{
  public acgk(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public void onClick(View paramView)
  {
    if (System.currentTimeMillis() - this.a.jdField_a_of_type_Long >= 1500L) {
      try
      {
        this.a.jdField_a_of_type_Long = System.currentTimeMillis();
        switch (paramView.getId())
        {
        case 2131377737: 
          TroopStoryMainActivity.a(this.a);
          if (QLog.isColorLevel()) {
            QLog.d("TroopAssistantFeedsJsHandler", 2, "feedsTitle onClick, url:http://qqweb.qq.com/m/qunfeeds/index.html?_wv=1031&_bid=200");
          }
          if (this.a.jdField_a_of_type_AndroidWidgetImageView != null) {
            this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          }
          vel.a("grp_help", "clk_video", 0, 0, new String[] { "", "", "", "" });
          return;
        }
      }
      catch (Exception paramView)
      {
        if (QLog.isColorLevel())
        {
          QLog.e("TroopAssistantFeedsJsHandler", 2, "feedsTitle onClick:" + paramView.toString());
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acgk
 * JD-Core Version:    0.7.0.1
 */