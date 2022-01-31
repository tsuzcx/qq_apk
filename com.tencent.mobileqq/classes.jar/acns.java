import android.support.v4.util.ArraySet;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

public class acns
{
  private static ArraySet<Long> a = new ArraySet();
  
  public static void a()
  {
    a.clear();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (!a.contains(Long.valueOf(paramMessageRecord.uniseq)))
    {
      a.add(Long.valueOf(paramMessageRecord.uniseq));
      awqx.b(paramQQAppInterface, "dc00898", "", "", "0X800A52B", "0X800A52B", 0, 0, "", "", "", "");
    }
  }
  
  public static void a(MessageRecord paramMessageRecord)
  {
    a.add(Long.valueOf(paramMessageRecord.uniseq));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acns
 * JD-Core Version:    0.7.0.1
 */