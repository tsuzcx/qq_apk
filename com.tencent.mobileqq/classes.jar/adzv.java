import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.leba.LebaWithFeeds;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class adzv
  implements AdapterView.OnItemClickListener
{
  public adzv(LebaWithFeeds paramLebaWithFeeds) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.c()) {
      ThreadManager.post(new adzw(this, paramView, paramInt), 8, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adzv
 * JD-Core Version:    0.7.0.1
 */