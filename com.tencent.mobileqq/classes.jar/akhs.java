import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;

public class akhs
{
  public static akhx a(int paramInt, awbv paramawbv, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (paramInt == 0) {
      return new akhv(paramQQAppInterface, paramContext, paramawbv);
    }
    if (paramInt == 5) {
      return new akht(paramQQAppInterface, paramContext, paramawbv);
    }
    if (paramInt == 1) {
      return new akib(paramQQAppInterface, paramContext, paramawbv);
    }
    if (paramInt == 2) {
      return new akid(paramQQAppInterface, paramContext, paramawbv, 2);
    }
    if (paramInt == 3) {
      return new akid(paramQQAppInterface, paramContext, paramawbv, 3);
    }
    if (paramInt == 4) {
      return new akhv(paramQQAppInterface, paramContext, paramawbv);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akhs
 * JD-Core Version:    0.7.0.1
 */