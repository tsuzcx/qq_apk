import java.lang.ref.WeakReference;
import tencent.im.oidb.oidb_0x87a.RspBody;
import tencent.im.oidb.oidb_0x87c.RspBody;

public class adxm
  extends ayxn
{
  private WeakReference<ayxn> a;
  
  public adxm(ayxn paramayxn)
  {
    this.a = new WeakReference(paramayxn);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    ayxn localayxn = (ayxn)this.a.get();
    if (localayxn != null)
    {
      localayxn.a(paramString1, paramInt, paramString2);
      return;
    }
    super.a(paramString1, paramInt, paramString2);
  }
  
  public void a(String paramString1, String paramString2)
  {
    ayxn localayxn = (ayxn)this.a.get();
    if (localayxn != null)
    {
      localayxn.a(paramString1, paramString2);
      return;
    }
    super.a(paramString1, paramString2);
  }
  
  public void a(oidb_0x87a.RspBody paramRspBody)
  {
    ayxn localayxn = (ayxn)this.a.get();
    if (localayxn != null)
    {
      localayxn.a(paramRspBody);
      return;
    }
    super.a(paramRspBody);
  }
  
  public void a(oidb_0x87c.RspBody paramRspBody)
  {
    ayxn localayxn = (ayxn)this.a.get();
    if (localayxn != null)
    {
      localayxn.a(paramRspBody);
      return;
    }
    super.a(paramRspBody);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adxm
 * JD-Core Version:    0.7.0.1
 */