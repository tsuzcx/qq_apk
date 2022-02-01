import com.tencent.mobileqq.activity.BaseChatPie;
import mqq.app.QQPermissionCallback;

public class adzf
  implements QQPermissionCallback
{
  public adzf(BaseChatPie paramBaseChatPie) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bhlq.b(this.a.a());
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    BaseChatPie.e(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adzf
 * JD-Core Version:    0.7.0.1
 */