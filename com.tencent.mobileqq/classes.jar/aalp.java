import java.lang.ref.WeakReference;
import tencent.im.oidb.oidb_0x87a.RspBody;
import tencent.im.oidb.oidb_0x87c.RspBody;

public class aalp
  extends atzn
{
  private WeakReference<atzn> a;
  
  public aalp(atzn paramatzn)
  {
    this.a = new WeakReference(paramatzn);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    atzn localatzn = (atzn)this.a.get();
    if (localatzn != null)
    {
      localatzn.a(paramString1, paramInt, paramString2);
      return;
    }
    super.a(paramString1, paramInt, paramString2);
  }
  
  public void a(String paramString1, String paramString2)
  {
    atzn localatzn = (atzn)this.a.get();
    if (localatzn != null)
    {
      localatzn.a(paramString1, paramString2);
      return;
    }
    super.a(paramString1, paramString2);
  }
  
  public void a(oidb_0x87a.RspBody paramRspBody)
  {
    atzn localatzn = (atzn)this.a.get();
    if (localatzn != null)
    {
      localatzn.a(paramRspBody);
      return;
    }
    super.a(paramRspBody);
  }
  
  public void a(oidb_0x87c.RspBody paramRspBody)
  {
    atzn localatzn = (atzn)this.a.get();
    if (localatzn != null)
    {
      localatzn.a(paramRspBody);
      return;
    }
    super.a(paramRspBody);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aalp
 * JD-Core Version:    0.7.0.1
 */