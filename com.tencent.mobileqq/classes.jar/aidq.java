import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;

public class aidq
{
  public static aidv a(int paramInt, atmo paramatmo, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (paramInt == 0) {
      return new aidt(paramQQAppInterface, paramContext, paramatmo);
    }
    if (paramInt == 5) {
      return new aidr(paramQQAppInterface, paramContext, paramatmo);
    }
    if (paramInt == 1) {
      return new aidz(paramQQAppInterface, paramContext, paramatmo);
    }
    if (paramInt == 2) {
      return new aieb(paramQQAppInterface, paramContext, paramatmo, 2);
    }
    if (paramInt == 3) {
      return new aieb(paramQQAppInterface, paramContext, paramatmo, 3);
    }
    if (paramInt == 4) {
      return new aidt(paramQQAppInterface, paramContext, paramatmo);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aidq
 * JD-Core Version:    0.7.0.1
 */