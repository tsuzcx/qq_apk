import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.qphone.base.remote.ToServiceMsg;

final class alsx
  extends amky
{
  alsx(String paramString, ToServiceMsg paramToServiceMsg)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo arg2)
  {
    synchronized (this.a)
    {
      this.a.notify();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alsx
 * JD-Core Version:    0.7.0.1
 */