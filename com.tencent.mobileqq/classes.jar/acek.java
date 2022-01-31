import com.tencent.mobileqq.activity.BaseChatPie;
import mqq.app.QQPermissionCallback;

public class acek
  implements QQPermissionCallback
{
  public acek(BaseChatPie paramBaseChatPie) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bdcd.a(this.a.a(), paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.bm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acek
 * JD-Core Version:    0.7.0.1
 */