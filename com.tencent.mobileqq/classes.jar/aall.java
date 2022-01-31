import java.lang.ref.WeakReference;
import tencent.im.oidb.oidb_0x87a.RspBody;
import tencent.im.oidb.oidb_0x87c.RspBody;

public class aall
  extends atzp
{
  private WeakReference<atzp> a;
  
  public aall(atzp paramatzp)
  {
    this.a = new WeakReference(paramatzp);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    atzp localatzp = (atzp)this.a.get();
    if (localatzp != null)
    {
      localatzp.a(paramString1, paramInt, paramString2);
      return;
    }
    super.a(paramString1, paramInt, paramString2);
  }
  
  public void a(String paramString1, String paramString2)
  {
    atzp localatzp = (atzp)this.a.get();
    if (localatzp != null)
    {
      localatzp.a(paramString1, paramString2);
      return;
    }
    super.a(paramString1, paramString2);
  }
  
  public void a(oidb_0x87a.RspBody paramRspBody)
  {
    atzp localatzp = (atzp)this.a.get();
    if (localatzp != null)
    {
      localatzp.a(paramRspBody);
      return;
    }
    super.a(paramRspBody);
  }
  
  public void a(oidb_0x87c.RspBody paramRspBody)
  {
    atzp localatzp = (atzp)this.a.get();
    if (localatzp != null)
    {
      localatzp.a(paramRspBody);
      return;
    }
    super.a(paramRspBody);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aall
 * JD-Core Version:    0.7.0.1
 */