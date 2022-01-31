import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;

public class aiqj
{
  public static aiqo a(int paramInt, aukm paramaukm, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (paramInt == 0) {
      return new aiqm(paramQQAppInterface, paramContext, paramaukm);
    }
    if (paramInt == 5) {
      return new aiqk(paramQQAppInterface, paramContext, paramaukm);
    }
    if (paramInt == 1) {
      return new aiqs(paramQQAppInterface, paramContext, paramaukm);
    }
    if (paramInt == 2) {
      return new aiqu(paramQQAppInterface, paramContext, paramaukm, 2);
    }
    if (paramInt == 3) {
      return new aiqu(paramQQAppInterface, paramContext, paramaukm, 3);
    }
    if (paramInt == 4) {
      return new aiqm(paramQQAppInterface, paramContext, paramaukm);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aiqj
 * JD-Core Version:    0.7.0.1
 */