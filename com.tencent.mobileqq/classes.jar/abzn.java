import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;

public class abzn
  implements View.OnClickListener
{
  public abzn(ArkFullScreenAppActivity paramArkFullScreenAppActivity) {}
  
  public void onClick(View paramView)
  {
    if (ArkFullScreenAppActivity.a(this.a) != null) {
      anjv.a(this.a.app, "FullScreenClickOper", ArkFullScreenAppActivity.a(this.a).a, null, anjv.c, 0, 0);
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abzn
 * JD-Core Version:    0.7.0.1
 */