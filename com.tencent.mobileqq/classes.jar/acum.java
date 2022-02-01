import java.lang.ref.WeakReference;
import tencent.im.oidb.oidb_0x87a.RspBody;
import tencent.im.oidb.oidb_0x87c.RspBody;

public class acum
  extends axkv
{
  private WeakReference<axkv> a;
  
  public acum(axkv paramaxkv)
  {
    this.a = new WeakReference(paramaxkv);
  }
  
  public void getTmpKeySuccess(String paramString1, String paramString2)
  {
    axkv localaxkv = (axkv)this.a.get();
    if (localaxkv != null)
    {
      localaxkv.getTmpKeySuccess(paramString1, paramString2);
      return;
    }
    super.getTmpKeySuccess(paramString1, paramString2);
  }
  
  public void onFailedResponse(String paramString1, int paramInt, String paramString2)
  {
    axkv localaxkv = (axkv)this.a.get();
    if (localaxkv != null)
    {
      localaxkv.onFailedResponse(paramString1, paramInt, paramString2);
      return;
    }
    super.onFailedResponse(paramString1, paramInt, paramString2);
  }
  
  public void sendSmsCodeSuccess(oidb_0x87a.RspBody paramRspBody)
  {
    axkv localaxkv = (axkv)this.a.get();
    if (localaxkv != null)
    {
      localaxkv.sendSmsCodeSuccess(paramRspBody);
      return;
    }
    super.sendSmsCodeSuccess(paramRspBody);
  }
  
  public void verifySmsCodeSuccess(oidb_0x87c.RspBody paramRspBody)
  {
    axkv localaxkv = (axkv)this.a.get();
    if (localaxkv != null)
    {
      localaxkv.verifySmsCodeSuccess(paramRspBody);
      return;
    }
    super.verifySmsCodeSuccess(paramRspBody);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acum
 * JD-Core Version:    0.7.0.1
 */