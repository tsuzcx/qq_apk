import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class ajal
  implements ajaw
{
  private ajbm a;
  
  public ajal(ajbm paramajbm)
  {
    this.a = paramajbm;
  }
  
  public int a()
  {
    if (this.a == null) {
      return 0;
    }
    return this.a.b;
  }
  
  public int a(int paramInt)
  {
    return 0;
  }
  
  public int a(aivw paramaivw, int paramInt1, int paramInt2, String paramString, long paramLong, int paramInt3, float paramFloat)
  {
    return 0;
  }
  
  public int a(AppInterface paramAppInterface)
  {
    return 0;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmAudioManager", 2, "pause all music");
    }
    if (ajam.a != null) {
      synchronized (ajam.a)
      {
        Iterator localIterator = ajam.a.iterator();
        while (localIterator.hasNext())
        {
          ajam localajam = (ajam)localIterator.next();
          if ((localajam != null) && (localajam.b() == a())) {
            localajam.b(new JSONObject());
          }
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(int paramInt, AppInterface paramAppInterface) {}
  
  public void a(int paramInt, String paramString) {}
  
  public int b(int paramInt)
  {
    return 0;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmAudioManager", 2, "resume all music");
    }
  }
  
  public void b(int paramInt, String paramString) {}
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmAudioManager", 2, "destroy all music");
    }
    if (ajam.a != null) {
      synchronized (ajam.a)
      {
        Iterator localIterator = ajam.a.iterator();
        while (localIterator.hasNext())
        {
          ajam localajam = (ajam)localIterator.next();
          if ((localajam != null) && (localajam.b() == a()))
          {
            localajam.a();
            localIterator.remove();
          }
        }
      }
    }
    if (this.a != null)
    {
      this.a.a();
      this.a = null;
    }
  }
  
  public void c(int paramInt, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajal
 * JD-Core Version:    0.7.0.1
 */