import com.tencent.mobileqq.activity.QQIdentiferLegacy;
import mqq.app.QQPermissionCallback;

public class abkl
  implements QQPermissionCallback
{
  public abkl(QQIdentiferLegacy paramQQIdentiferLegacy) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    babr.a(QQIdentiferLegacy.a(this.a), paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QQIdentiferLegacy.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abkl
 * JD-Core Version:    0.7.0.1
 */