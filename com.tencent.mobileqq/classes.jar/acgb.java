import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopAssistantActivity;

public class acgb
  implements View.OnClickListener
{
  public acgb(TroopAssistantActivity paramTroopAssistantActivity) {}
  
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
    if (asfb.a().c()) {
      asfb.a().f(this.a.app);
    }
    TroopAssistantActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acgb
 * JD-Core Version:    0.7.0.1
 */