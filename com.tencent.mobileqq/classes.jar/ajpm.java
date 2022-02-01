import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URLEncoder;

public class ajpm
  implements View.OnClickListener
{
  public ajpm(ShowExternalTroopListActivity paramShowExternalTroopListActivity) {}
  
  public void onClick(View paramView)
  {
    if (!bhnv.g(this.a.jdField_a_of_type_AndroidAppActivity))
    {
      QQToast.a(this.a, 1, this.a.getString(2131691919), 0).b(this.a.getTitleBarHeight());
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    String str1 = ((TextView)paramView).getText().toString();
    Object localObject = new Intent(this.a.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", "https://qqweb.qq.com/m/relativegroup/index.html?_bid=165&_wv=4194304&source=qun_tag&keyword=" + URLEncoder.encode(str1));
    ((Intent)localObject).putExtra("hide_operation_bar", true);
    ((Intent)localObject).putExtra("hide_more_button", true);
    this.a.startActivity((Intent)localObject);
    localObject = this.a.app;
    String str2 = this.a.jdField_a_of_type_JavaLangString;
    if (this.a.jdField_a_of_type_Boolean) {}
    for (str1 = "0";; str1 = "1")
    {
      bdll.b((QQAppInterface)localObject, "P_CliOper", "Grp_join", "", "person_data", "Clk_quntag", 0, 0, str2, str1, "", "");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajpm
 * JD-Core Version:    0.7.0.1
 */