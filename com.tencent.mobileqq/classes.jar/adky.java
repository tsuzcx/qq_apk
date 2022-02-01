import java.lang.ref.WeakReference;
import tencent.im.oidb.oidb_0x87a.RspBody;
import tencent.im.oidb.oidb_0x87c.RspBody;

public class adky
  extends ayra
{
  private WeakReference<ayra> a;
  
  public adky(ayra paramayra)
  {
    this.a = new WeakReference(paramayra);
  }
  
  public void getTmpKeySuccess(String paramString1, String paramString2)
  {
    ayra localayra = (ayra)this.a.get();
    if (localayra != null)
    {
      localayra.getTmpKeySuccess(paramString1, paramString2);
      return;
    }
    super.getTmpKeySuccess(paramString1, paramString2);
  }
  
  public void onFailedResponse(String paramString1, int paramInt, String paramString2)
  {
    ayra localayra = (ayra)this.a.get();
    if (localayra != null)
    {
      localayra.onFailedResponse(paramString1, paramInt, paramString2);
      return;
    }
    super.onFailedResponse(paramString1, paramInt, paramString2);
  }
  
  public void sendSmsCodeSuccess(oidb_0x87a.RspBody paramRspBody)
  {
    ayra localayra = (ayra)this.a.get();
    if (localayra != null)
    {
      localayra.sendSmsCodeSuccess(paramRspBody);
      return;
    }
    super.sendSmsCodeSuccess(paramRspBody);
  }
  
  public void verifySmsCodeSuccess(oidb_0x87c.RspBody paramRspBody)
  {
    ayra localayra = (ayra)this.a.get();
    if (localayra != null)
    {
      localayra.verifySmsCodeSuccess(paramRspBody);
      return;
    }
    super.verifySmsCodeSuccess(paramRspBody);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adky
 * JD-Core Version:    0.7.0.1
 */