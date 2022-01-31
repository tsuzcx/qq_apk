import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.TextItem;
import mqq.os.MqqHandler;

public class ajld
  implements View.OnClickListener
{
  public ajld(TextItem paramTextItem) {}
  
  public void onClick(View paramView)
  {
    if (!paramView.hasFocus())
    {
      paramView.setFocusable(true);
      paramView.setFocusableInTouchMode(true);
      ThreadManager.getUIHandler().post(new ajle(this, paramView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajld
 * JD-Core Version:    0.7.0.1
 */