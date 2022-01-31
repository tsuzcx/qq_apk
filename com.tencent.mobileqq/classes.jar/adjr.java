import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.8.1;
import com.tencent.mobileqq.app.ThreadManager;

public class adjr
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    ThreadManager.post(new MarketFaceItemBuilder.8.1(this), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adjr
 * JD-Core Version:    0.7.0.1
 */