import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.HongbaoShowerActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class aazf
  implements View.OnClickListener
{
  public aazf(HongbaoShowerActivity paramHongbaoShowerActivity) {}
  
  public void onClick(View paramView)
  {
    if (System.currentTimeMillis() - this.a.a < 2000L) {
      return;
    }
    this.a.finish();
    this.a.overridePendingTransition(0, 0);
    QQAppInterface localQQAppInterface = this.a.app;
    if (HongbaoShowerActivity.a(this.a) == 0) {}
    for (paramView = "1";; paramView = "2")
    {
      awqx.b(localQQAppInterface, "dc01440", "", "", "0X80077EA", "0X80077EA", 0, 0, paramView, "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aazf
 * JD-Core Version:    0.7.0.1
 */