import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;

public class aiqh
{
  public static aiqm a(int paramInt, auko paramauko, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (paramInt == 0) {
      return new aiqk(paramQQAppInterface, paramContext, paramauko);
    }
    if (paramInt == 5) {
      return new aiqi(paramQQAppInterface, paramContext, paramauko);
    }
    if (paramInt == 1) {
      return new aiqq(paramQQAppInterface, paramContext, paramauko);
    }
    if (paramInt == 2) {
      return new aiqs(paramQQAppInterface, paramContext, paramauko, 2);
    }
    if (paramInt == 3) {
      return new aiqs(paramQQAppInterface, paramContext, paramauko, 3);
    }
    if (paramInt == 4) {
      return new aiqk(paramQQAppInterface, paramContext, paramauko);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aiqh
 * JD-Core Version:    0.7.0.1
 */