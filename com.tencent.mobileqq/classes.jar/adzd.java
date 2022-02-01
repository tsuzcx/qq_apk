import com.tencent.mobileqq.activity.BaseChatPie;
import mqq.app.QQPermissionCallback;

public class adzd
  implements QQPermissionCallback
{
  public adzd(BaseChatPie paramBaseChatPie) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bhlq.a(this.a.a(), paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.bi();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adzd
 * JD-Core Version:    0.7.0.1
 */