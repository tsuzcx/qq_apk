import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.MusicPendantView;

public class akuy
  implements View.OnClickListener
{
  public akuy(MusicPendantView paramMusicPendantView) {}
  
  public void onClick(View paramView)
  {
    if (paramView == null) {
      return;
    }
    ThreadManager.post(new akuz(this), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akuy
 * JD-Core Version:    0.7.0.1
 */