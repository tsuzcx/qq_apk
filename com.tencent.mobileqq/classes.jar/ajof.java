import android.util.SparseArray;
import com.tencent.mobileqq.troop.utils.TroopAppMgr;
import com.tencent.mobileqq.troop.utils.TroopAppMgr.ClickReportObserver;

public class ajof
  extends TroopAppMgr.ClickReportObserver
{
  public ajof(TroopAppMgr paramTroopAppMgr) {}
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    synchronized (this.a.a)
    {
      this.a.a.clear();
      this.a.b();
      TroopAppMgr.a(this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajof
 * JD-Core Version:    0.7.0.1
 */