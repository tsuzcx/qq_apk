import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopAssistantActivity;

public class adxh
  implements View.OnClickListener
{
  public adxh(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.isFinishing()) {
      return;
    }
    this.a.c = false;
    if (this.a.a != null)
    {
      this.a.a.a(4);
      this.a.d();
      this.a.c();
    }
    if (atwd.a().c()) {
      atwd.a().f(this.a.app);
    }
    TroopAssistantActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adxh
 * JD-Core Version:    0.7.0.1
 */