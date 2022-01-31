import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;

public class abkh
  implements View.OnFocusChangeListener
{
  public abkh(Leba paramLeba) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramView.clearFocus();
      awsq.a(null, 0, 21, "0X8009D15", 0, 0, null, null);
      UniteSearchActivity.a(this.a.a(), null, 21, 0L, null, 3);
      axqy.b(this.a.a, "CliOper", "", "", "0x8004B21", "0x8004B21", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abkh
 * JD-Core Version:    0.7.0.1
 */