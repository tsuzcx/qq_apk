import android.os.Handler;
import com.tencent.mobileqq.search.fragment.GroupSearchFragment;
import com.tencent.mobileqq.search.searchengine.ISearchEngine;

public class ahtd
  implements Runnable
{
  public ahtd(GroupSearchFragment paramGroupSearchFragment) {}
  
  public void run()
  {
    if (!this.a.c)
    {
      this.a.a.a();
      this.a.c = true;
    }
    this.a.b.removeMessages(100);
    this.a.b.sendEmptyMessage(100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahtd
 * JD-Core Version:    0.7.0.1
 */