import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;

public class aair
  implements View.OnClickListener
{
  public aair(ArkFullScreenAppActivity paramArkFullScreenAppActivity) {}
  
  public void onClick(View paramView)
  {
    if (ArkFullScreenAppActivity.a(this.a) != null) {
      altd.a(this.a.app, "FullScreenClickOper", ArkFullScreenAppActivity.a(this.a).a, null, altd.c, 0, 0);
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aair
 * JD-Core Version:    0.7.0.1
 */