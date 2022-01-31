import com.tencent.mobileqq.activity.BaseChatPie;
import mqq.app.QQPermissionCallback;

public class aann
  implements QQPermissionCallback
{
  public aann(BaseChatPie paramBaseChatPie) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bbdj.a(this.a.a(), paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.bk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aann
 * JD-Core Version:    0.7.0.1
 */