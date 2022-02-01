import com.tencent.mobileqq.activity.BaseChatPie;
import mqq.app.QQPermissionCallback;

public class adze
  implements QQPermissionCallback
{
  public adze(BaseChatPie paramBaseChatPie) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bhlq.b(this.a.a());
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.l(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adze
 * JD-Core Version:    0.7.0.1
 */