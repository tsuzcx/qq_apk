import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopAssistantActivity;

public class abvp
  implements View.OnClickListener
{
  public abvp(TroopAssistantActivity paramTroopAssistantActivity) {}
  
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
    if (ariz.a().c()) {
      ariz.a().f(this.a.app);
    }
    TroopAssistantActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abvp
 * JD-Core Version:    0.7.0.1
 */