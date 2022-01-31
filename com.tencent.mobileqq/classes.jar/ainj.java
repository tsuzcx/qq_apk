import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;

class ainj
  implements View.OnClickListener
{
  ainj(ainh paramainh, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.jdField_a_of_type_Ainh.a, QQBrowserActivity.class).putExtra("url", String.format("https://buluo.qq.com/mobile/detail.html?bid=%s&pid=%s&_wv=1027&webview=1&from=reliao", new Object[] { this.jdField_a_of_type_JavaLangString, this.b }));
    this.jdField_a_of_type_Ainh.a.startActivity(paramView);
    axqy.b(null, "dc00899", "grp_lbs", "", "hot_room", "clk_tribe_post", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ainj
 * JD-Core Version:    0.7.0.1
 */