import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;

public class aevn
  implements View.OnFocusChangeListener
{
  public aevn(Leba paramLeba) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramView.clearFocus();
      bcjy.a(null, 0, 21, "0X8009D15", 0, 0, null, null);
      UniteSearchActivity.a(this.a.a(), null, 21, 0L, null, 3);
      bdll.b(this.a.a, "CliOper", "", "", "0x8004B21", "0x8004B21", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aevn
 * JD-Core Version:    0.7.0.1
 */