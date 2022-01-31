import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.transfile.C2CPicUploadProcessor;

public class aiou
  implements Runnable
{
  public aiou(C2CPicUploadProcessor paramC2CPicUploadProcessor) {}
  
  public void run()
  {
    switch (this.a.v)
    {
    default: 
      return;
    case 0: 
      this.a.d("<BDH_LOG> sendFileNotBlockCallThread() BUT current status is INIT");
      return;
    case 2: 
      this.a.d("<BDH_LOG> sendFileNotBlockCallThread() resume HTTP channel");
      this.a.r();
      return;
    }
    if (this.a.b != null)
    {
      this.a.d("<BDH_LOG> sendFileNotBlockCallThread() resume BDH channel");
      this.a.a.getHwEngine().resumeTransactionTask(this.a.b);
      return;
    }
    this.a.d("<BDH_LOG> sendFileNotBlockCallThread() resume BDH channel, but trans == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiou
 * JD-Core Version:    0.7.0.1
 */