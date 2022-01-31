import java.lang.ref.WeakReference;
import tencent.im.oidb.oidb_0x87a.RspBody;
import tencent.im.oidb.oidb_0x87c.RspBody;

public class accj
  extends avqt
{
  private WeakReference<avqt> a;
  
  public accj(avqt paramavqt)
  {
    this.a = new WeakReference(paramavqt);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    avqt localavqt = (avqt)this.a.get();
    if (localavqt != null)
    {
      localavqt.a(paramString1, paramInt, paramString2);
      return;
    }
    super.a(paramString1, paramInt, paramString2);
  }
  
  public void a(String paramString1, String paramString2)
  {
    avqt localavqt = (avqt)this.a.get();
    if (localavqt != null)
    {
      localavqt.a(paramString1, paramString2);
      return;
    }
    super.a(paramString1, paramString2);
  }
  
  public void a(oidb_0x87a.RspBody paramRspBody)
  {
    avqt localavqt = (avqt)this.a.get();
    if (localavqt != null)
    {
      localavqt.a(paramRspBody);
      return;
    }
    super.a(paramRspBody);
  }
  
  public void a(oidb_0x87c.RspBody paramRspBody)
  {
    avqt localavqt = (avqt)this.a.get();
    if (localavqt != null)
    {
      localavqt.a(paramRspBody);
      return;
    }
    super.a(paramRspBody);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     accj
 * JD-Core Version:    0.7.0.1
 */