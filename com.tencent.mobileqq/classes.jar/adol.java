import java.lang.ref.WeakReference;
import tencent.im.oidb.oidb_0x87a.RspBody;
import tencent.im.oidb.oidb_0x87c.RspBody;

public class adol
  extends ayeu
{
  private WeakReference<ayeu> a;
  
  public adol(ayeu paramayeu)
  {
    this.a = new WeakReference(paramayeu);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    ayeu localayeu = (ayeu)this.a.get();
    if (localayeu != null)
    {
      localayeu.a(paramString1, paramInt, paramString2);
      return;
    }
    super.a(paramString1, paramInt, paramString2);
  }
  
  public void a(String paramString1, String paramString2)
  {
    ayeu localayeu = (ayeu)this.a.get();
    if (localayeu != null)
    {
      localayeu.a(paramString1, paramString2);
      return;
    }
    super.a(paramString1, paramString2);
  }
  
  public void a(oidb_0x87a.RspBody paramRspBody)
  {
    ayeu localayeu = (ayeu)this.a.get();
    if (localayeu != null)
    {
      localayeu.a(paramRspBody);
      return;
    }
    super.a(paramRspBody);
  }
  
  public void a(oidb_0x87c.RspBody paramRspBody)
  {
    ayeu localayeu = (ayeu)this.a.get();
    if (localayeu != null)
    {
      localayeu.a(paramRspBody);
      return;
    }
    super.a(paramRspBody);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adol
 * JD-Core Version:    0.7.0.1
 */