import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class akwm
  implements akwx
{
  private akxn a;
  
  public akwm(akxn paramakxn)
  {
    this.a = paramakxn;
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
  
  public int a(akrx paramakrx, int paramInt1, int paramInt2, String paramString, long paramLong, int paramInt3, float paramFloat)
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
    if (akwn.a != null) {
      synchronized (akwn.a)
      {
        Iterator localIterator = akwn.a.iterator();
        while (localIterator.hasNext())
        {
          akwn localakwn = (akwn)localIterator.next();
          if ((localakwn != null) && (localakwn.b() == a())) {
            localakwn.b(new JSONObject());
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
    if (akwn.a != null) {
      synchronized (akwn.a)
      {
        Iterator localIterator = akwn.a.iterator();
        while (localIterator.hasNext())
        {
          akwn localakwn = (akwn)localIterator.next();
          if ((localakwn != null) && (localakwn.b() == a()))
          {
            localakwn.a();
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
 * Qualified Name:     akwm
 * JD-Core Version:    0.7.0.1
 */