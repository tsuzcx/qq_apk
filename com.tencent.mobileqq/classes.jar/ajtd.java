import android.os.Message;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.HWReciteInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem;
import com.tencent.util.WeakReferenceHandler;
import cooperation.troop_homework.TroopHomeworkHelper;
import java.lang.ref.WeakReference;

public class ajtd
  implements Runnable
{
  private final WeakReference a;
  private final WeakReference b;
  
  public ajtd(HWReciteItem paramHWReciteItem, HWReciteInfo paramHWReciteInfo)
  {
    this.a = new WeakReference(paramHWReciteItem);
    this.b = new WeakReference(paramHWReciteInfo);
  }
  
  public void run()
  {
    HWReciteInfo localHWReciteInfo = (HWReciteInfo)this.b.get();
    if (localHWReciteInfo != null)
    {
      localHWReciteInfo.d = TroopHomeworkHelper.a(localHWReciteInfo.e);
      Object localObject = (HWReciteItem)this.a.get();
      if ((localObject != null) && (HWReciteItem.a((HWReciteItem)localObject) != null))
      {
        localObject = HWReciteItem.a((HWReciteItem)localObject).obtainMessage();
        ((Message)localObject).what = 233;
        ((Message)localObject).obj = localHWReciteInfo;
        ((Message)localObject).sendToTarget();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajtd
 * JD-Core Version:    0.7.0.1
 */