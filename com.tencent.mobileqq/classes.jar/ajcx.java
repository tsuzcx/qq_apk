import android.view.View;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.util.InputMethodUtil;

public class ajcx
  implements Runnable
{
  public ajcx(TroopBarPublishActivity paramTroopBarPublishActivity) {}
  
  public void run()
  {
    this.a.d.requestFocus();
    InputMethodUtil.a(this.a.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajcx
 * JD-Core Version:    0.7.0.1
 */