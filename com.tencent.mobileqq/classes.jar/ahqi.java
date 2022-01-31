import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ahqi
{
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      aush.a(paramQQAppInterface.getAccount(), "sp_key_card_redpoint_count", Integer.valueOf(paramInt));
    } while (!QLog.isColorLevel());
    QLog.i("CardUtil", 2, String.format("updateCardRedPoint count:%d", new Object[] { Integer.valueOf(paramInt) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahqi
 * JD-Core Version:    0.7.0.1
 */