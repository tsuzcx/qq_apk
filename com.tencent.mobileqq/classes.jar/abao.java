import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;

class abao
  implements View.OnFocusChangeListener
{
  abao(abai paramabai) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramView.clearFocus();
      avsv.a(null, 0, 21, "0X8009D15", 0, 0, null, null);
      UniteSearchActivity.a(this.a.a(), null, 21, 0L, null, 3);
      awqx.b(this.a.a, "CliOper", "", "", "0x8004B21", "0x8004B21", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abao
 * JD-Core Version:    0.7.0.1
 */