import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import java.util.Map;

final class akug
  extends akuo
{
  akug(int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString, akui paramakui)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onConsecutiveFailure(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    for (;;)
    {
      synchronized (akuf.a())
      {
        if (akuf.b().containsKey(this))
        {
          if (QLog.isColorLevel()) {
            QLog.i("SOSO.LBS.LbsManagerService", 0, "onConsecutiveFailure reverseListenerMap contains. business id: " + this.tag + " fail count: " + paramInt2);
          }
          if (paramInt2 > 5)
          {
            localakui = (akui)akuf.b().remove(this);
            akuf.a().remove(localakui);
            if (paramInt2 > 5) {
              SosoInterface.b(this);
            }
            return;
          }
          akui localakui = (akui)akuf.b().get(this);
          if (paramInt2 == 5) {
            bool = true;
          }
          localakui.onConsecutiveFailure(paramInt1, paramInt2, bool);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("SOSO.LBS.LbsManagerService", 0, "onConsecutiveFailure reverseListenerMap not contains. business id: " + this.tag + " fail count: " + paramInt2);
      }
    }
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    for (;;)
    {
      synchronized ()
      {
        if (akuf.b().containsKey(this))
        {
          if (QLog.isColorLevel()) {
            QLog.i("SOSO.LBS.LbsManagerService", 0, "onLocationFinish reverseListenerMap contains. business id: " + this.tag);
          }
          if (this.goonListener)
          {
            localakui = (akui)akuf.b().get(this);
            localakui.onLocationFinish(paramInt, akuf.a(paramSosoLbsInfo, this.a.businessId));
            return;
          }
          akui localakui = (akui)akuf.b().remove(this);
          akuf.a().remove(localakui);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("SOSO.LBS.LbsManagerService", 0, "onLocationFinish reverseListenerMap not contains. business id: " + this.tag + " this is: " + this);
      }
    }
  }
  
  public void onStatusUpdate(String paramString1, int paramInt, String paramString2)
  {
    synchronized ()
    {
      if (akuf.b().containsKey(this)) {
        ((akui)akuf.b().get(this)).onStatusUpdate(paramString1, paramInt, paramString2);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akug
 * JD-Core Version:    0.7.0.1
 */