import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;

public class akmh
{
  public static akmm a(int paramInt, awge paramawge, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (paramInt == 0) {
      return new akmk(paramQQAppInterface, paramContext, paramawge);
    }
    if (paramInt == 5) {
      return new akmi(paramQQAppInterface, paramContext, paramawge);
    }
    if (paramInt == 1) {
      return new akmq(paramQQAppInterface, paramContext, paramawge);
    }
    if (paramInt == 2) {
      return new akms(paramQQAppInterface, paramContext, paramawge, 2);
    }
    if (paramInt == 3) {
      return new akms(paramQQAppInterface, paramContext, paramawge, 3);
    }
    if (paramInt == 4) {
      return new akmk(paramQQAppInterface, paramContext, paramawge);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akmh
 * JD-Core Version:    0.7.0.1
 */