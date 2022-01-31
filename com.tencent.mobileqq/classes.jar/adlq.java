import com.tencent.mobileqq.activity.QQIdentiferLegacy;
import mqq.app.QQPermissionCallback;

public class adlq
  implements QQPermissionCallback
{
  public adlq(QQIdentiferLegacy paramQQIdentiferLegacy) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bdcd.a(QQIdentiferLegacy.a(this.a), paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QQIdentiferLegacy.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adlq
 * JD-Core Version:    0.7.0.1
 */