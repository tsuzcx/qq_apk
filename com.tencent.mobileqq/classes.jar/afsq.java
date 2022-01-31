import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class afsq
{
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      atbi.a(paramQQAppInterface.getAccount(), "sp_key_card_redpoint_count", Integer.valueOf(paramInt));
    } while (!QLog.isColorLevel());
    QLog.i("CardUtil", 2, String.format("updateCardRedPoint count:%d", new Object[] { Integer.valueOf(paramInt) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afsq
 * JD-Core Version:    0.7.0.1
 */