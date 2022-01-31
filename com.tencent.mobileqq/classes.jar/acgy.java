import java.lang.ref.WeakReference;
import tencent.im.oidb.oidb_0x87a.RspBody;
import tencent.im.oidb.oidb_0x87c.RspBody;

public class acgy
  extends avvc
{
  private WeakReference<avvc> a;
  
  public acgy(avvc paramavvc)
  {
    this.a = new WeakReference(paramavvc);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    avvc localavvc = (avvc)this.a.get();
    if (localavvc != null)
    {
      localavvc.a(paramString1, paramInt, paramString2);
      return;
    }
    super.a(paramString1, paramInt, paramString2);
  }
  
  public void a(String paramString1, String paramString2)
  {
    avvc localavvc = (avvc)this.a.get();
    if (localavvc != null)
    {
      localavvc.a(paramString1, paramString2);
      return;
    }
    super.a(paramString1, paramString2);
  }
  
  public void a(oidb_0x87a.RspBody paramRspBody)
  {
    avvc localavvc = (avvc)this.a.get();
    if (localavvc != null)
    {
      localavvc.a(paramRspBody);
      return;
    }
    super.a(paramRspBody);
  }
  
  public void a(oidb_0x87c.RspBody paramRspBody)
  {
    avvc localavvc = (avvc)this.a.get();
    if (localavvc != null)
    {
      localavvc.a(paramRspBody);
      return;
    }
    super.a(paramRspBody);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acgy
 * JD-Core Version:    0.7.0.1
 */