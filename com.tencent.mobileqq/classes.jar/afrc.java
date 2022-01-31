import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.7.1;
import com.tencent.mobileqq.app.ThreadManager;

public class afrc
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    ThreadManager.post(new MarketFaceItemBuilder.7.1(this), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afrc
 * JD-Core Version:    0.7.0.1
 */