import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class alwe
  implements alwp
{
  private alxf a;
  
  public alwe(alxf paramalxf)
  {
    this.a = paramalxf;
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
  
  public int a(alrr paramalrr, int paramInt1, int paramInt2, String paramString, long paramLong, int paramInt3, float paramFloat)
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
    if (alwf.a != null) {
      synchronized (alwf.a)
      {
        Iterator localIterator = alwf.a.iterator();
        while (localIterator.hasNext())
        {
          alwf localalwf = (alwf)localIterator.next();
          if ((localalwf != null) && (localalwf.b() == a())) {
            localalwf.b(new JSONObject());
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
    if (alwf.a != null) {
      synchronized (alwf.a)
      {
        Iterator localIterator = alwf.a.iterator();
        while (localIterator.hasNext())
        {
          alwf localalwf = (alwf)localIterator.next();
          if ((localalwf != null) && (localalwf.b() == a()))
          {
            localalwf.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alwe
 * JD-Core Version:    0.7.0.1
 */