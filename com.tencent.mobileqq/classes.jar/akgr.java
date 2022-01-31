import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.MusicPendantView;

public class akgr
  implements View.OnClickListener
{
  public akgr(MusicPendantView paramMusicPendantView) {}
  
  public void onClick(View paramView)
  {
    if (paramView == null) {
      return;
    }
    ThreadManager.post(new akgs(this), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     akgr
 * JD-Core Version:    0.7.0.1
 */