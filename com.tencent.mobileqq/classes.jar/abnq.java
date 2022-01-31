import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.qphone.base.util.QLog;

public class abnq
  implements Runnable
{
  public abnq(MessageForPic paramMessageForPic) {}
  
  public void run()
  {
    try
    {
      this.a.checkIsGIF();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MessageForPic", 1, "checkIsGIF exception :", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abnq
 * JD-Core Version:    0.7.0.1
 */