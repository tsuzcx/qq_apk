import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;

public class abkl
  implements View.OnFocusChangeListener
{
  public abkl(Leba paramLeba) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramView.clearFocus();
      awso.a(null, 0, 21, "0X8009D15", 0, 0, null, null);
      UniteSearchActivity.a(this.a.a(), null, 21, 0L, null, 3);
      axqw.b(this.a.a, "CliOper", "", "", "0x8004B21", "0x8004B21", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abkl
 * JD-Core Version:    0.7.0.1
 */