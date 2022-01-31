import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.qphone.base.remote.ToServiceMsg;

final class akbj
  extends akuj
{
  akbj(String paramString, ToServiceMsg paramToServiceMsg)
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
 * Qualified Name:     akbj
 * JD-Core Version:    0.7.0.1
 */