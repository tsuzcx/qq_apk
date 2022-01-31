import com.tencent.mobileqq.data.SysSuspiciousMsg;
import java.util.Comparator;

class akbq
  implements Comparator<SysSuspiciousMsg>
{
  akbq(akbo paramakbo) {}
  
  public int a(SysSuspiciousMsg paramSysSuspiciousMsg1, SysSuspiciousMsg paramSysSuspiciousMsg2)
  {
    if ((paramSysSuspiciousMsg1 != null) && (paramSysSuspiciousMsg2 != null)) {
      return (int)(paramSysSuspiciousMsg2.time - paramSysSuspiciousMsg1.time);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akbq
 * JD-Core Version:    0.7.0.1
 */