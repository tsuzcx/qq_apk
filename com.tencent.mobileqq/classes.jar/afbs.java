import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.net.URLEncoder;

public class afbs
  implements View.OnClickListener
{
  public afbs(ShowExternalTroopListActivity paramShowExternalTroopListActivity) {}
  
  public void onClick(View paramView)
  {
    if (!badq.g(this.a.jdField_a_of_type_AndroidAppActivity))
    {
      bbmy.a(this.a, 1, this.a.getString(2131626647), 0).b(this.a.getTitleBarHeight());
      return;
    }
    paramView = ((TextView)paramView).getText().toString();
    Object localObject = new Intent(this.a.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", "http://qqweb.qq.com/m/relativegroup/index.html?_bid=165&_wv=4194304&source=qun_tag&keyword=" + URLEncoder.encode(paramView));
    ((Intent)localObject).putExtra("hide_operation_bar", true);
    ((Intent)localObject).putExtra("hide_more_button", true);
    this.a.startActivity((Intent)localObject);
    localObject = this.a.app;
    String str = this.a.jdField_a_of_type_JavaLangString;
    if (this.a.jdField_a_of_type_Boolean) {}
    for (paramView = "0";; paramView = "1")
    {
      awqx.b((QQAppInterface)localObject, "P_CliOper", "Grp_join", "", "person_data", "Clk_quntag", 0, 0, str, paramView, "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afbs
 * JD-Core Version:    0.7.0.1
 */