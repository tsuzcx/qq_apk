import android.os.Message;
import com.tencent.mobileqq.campuscircle.CampusCircleObserver;
import com.tencent.mobileqq.campuscircle.CampusCircleSelTopicFragment;
import java.util.List;

public class abpy
  extends CampusCircleObserver
{
  public abpy(CampusCircleSelTopicFragment paramCampusCircleSelTopicFragment) {}
  
  public void a(boolean paramBoolean, List paramList1, List paramList2, List paramList3, List paramList4)
  {
    if (!paramBoolean) {}
    do
    {
      return;
      if (paramList2 != null) {
        Message.obtain(this.a.a, 1, 0, 0, paramList2).sendToTarget();
      }
      if (paramList3 != null) {
        Message.obtain(this.a.a, 2, 0, 0, paramList3).sendToTarget();
      }
    } while ((paramList4 == null) || (paramList4.size() <= 0));
    Message.obtain(this.a.a, 3, 0, 0, paramList4).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abpy
 * JD-Core Version:    0.7.0.1
 */