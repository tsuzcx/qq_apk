import com.tencent.mobileqq.data.SysSuspiciousMsg;
import java.util.Comparator;

class alte
  implements Comparator<SysSuspiciousMsg>
{
  alte(altc paramaltc) {}
  
  public int a(SysSuspiciousMsg paramSysSuspiciousMsg1, SysSuspiciousMsg paramSysSuspiciousMsg2)
  {
    if ((paramSysSuspiciousMsg1 != null) && (paramSysSuspiciousMsg2 != null)) {
      return (int)(paramSysSuspiciousMsg2.time - paramSysSuspiciousMsg1.time);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alte
 * JD-Core Version:    0.7.0.1
 */