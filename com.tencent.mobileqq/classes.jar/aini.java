import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.Entity;

public class aini
{
  public static ainj a(int paramInt, Entity paramEntity, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (paramInt == 0) {
      return new aipl(paramQQAppInterface, paramContext, paramEntity);
    }
    if (paramInt == 5) {
      return new aiou(paramQQAppInterface, paramContext, paramEntity);
    }
    if (paramInt == 1) {
      return new aiqg(paramQQAppInterface, paramContext, paramEntity);
    }
    if (paramInt == 2) {
      return new aisg(paramQQAppInterface, paramContext, paramEntity, 2);
    }
    if (paramInt == 3) {
      return new aisg(paramQQAppInterface, paramContext, paramEntity, 3);
    }
    if (paramInt == 4) {
      return new aipl(paramQQAppInterface, paramContext, paramEntity);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aini
 * JD-Core Version:    0.7.0.1
 */