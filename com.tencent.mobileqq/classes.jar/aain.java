import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;

public class aain
  implements View.OnClickListener
{
  public aain(ArkFullScreenAppActivity paramArkFullScreenAppActivity) {}
  
  public void onClick(View paramView)
  {
    if (ArkFullScreenAppActivity.a(this.a) != null) {
      altc.a(this.a.app, "FullScreenClickOper", ArkFullScreenAppActivity.a(this.a).a, null, altc.c, 0, 0);
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aain
 * JD-Core Version:    0.7.0.1
 */