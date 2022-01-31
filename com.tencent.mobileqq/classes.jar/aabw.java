import java.lang.ref.WeakReference;
import tencent.im.oidb.oidb_0x87a.RspBody;
import tencent.im.oidb.oidb_0x87c.RspBody;

public class aabw
  extends atdj
{
  private WeakReference<atdj> a;
  
  public aabw(atdj paramatdj)
  {
    this.a = new WeakReference(paramatdj);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    atdj localatdj = (atdj)this.a.get();
    if (localatdj != null)
    {
      localatdj.a(paramString1, paramInt, paramString2);
      return;
    }
    super.a(paramString1, paramInt, paramString2);
  }
  
  public void a(String paramString1, String paramString2)
  {
    atdj localatdj = (atdj)this.a.get();
    if (localatdj != null)
    {
      localatdj.a(paramString1, paramString2);
      return;
    }
    super.a(paramString1, paramString2);
  }
  
  public void a(oidb_0x87a.RspBody paramRspBody)
  {
    atdj localatdj = (atdj)this.a.get();
    if (localatdj != null)
    {
      localatdj.a(paramRspBody);
      return;
    }
    super.a(paramRspBody);
  }
  
  public void a(oidb_0x87c.RspBody paramRspBody)
  {
    atdj localatdj = (atdj)this.a.get();
    if (localatdj != null)
    {
      localatdj.a(paramRspBody);
      return;
    }
    super.a(paramRspBody);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aabw
 * JD-Core Version:    0.7.0.1
 */