import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.armap.ArMapInterface;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class aazr
  implements ActionSheet.OnButtonClickListener
{
  public aazr(ARMapActivity paramARMapActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (ARMapActivity.g(this.a)) {
      return;
    }
    if (paramInt == 0) {
      this.a.g();
    }
    for (;;)
    {
      ARMapActivity.f(this.a, true);
      ARMapActivity.a(this.a).dismiss();
      return;
      if (paramInt == 1)
      {
        paramView = new Intent(this.a, QQBrowserActivity.class);
        paramView.putExtra("uin", this.a.app.getCurrentAccountUin());
        paramView.putExtra("url", "https://wa.qq.com/help/rule.html");
        this.a.startActivity(paramView);
      }
      else if (paramInt == 2)
      {
        paramView = new Intent(this.a, QQBrowserActivity.class);
        paramView.putExtra("uin", this.a.app.getCurrentAccountUin());
        paramView.putExtra("url", "https://mma.qq.com/poi_feedback/index.html?_wv=1&poiid=10001");
        this.a.startActivity(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aazr
 * JD-Core Version:    0.7.0.1
 */