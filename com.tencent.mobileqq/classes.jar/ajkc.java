import com.tencent.mobileqq.data.SysSuspiciousMsg;
import java.util.Comparator;

class ajkc
  implements Comparator<SysSuspiciousMsg>
{
  ajkc(ajka paramajka) {}
  
  public int a(SysSuspiciousMsg paramSysSuspiciousMsg1, SysSuspiciousMsg paramSysSuspiciousMsg2)
  {
    if ((paramSysSuspiciousMsg1 != null) && (paramSysSuspiciousMsg2 != null)) {
      return (int)(paramSysSuspiciousMsg2.time - paramSysSuspiciousMsg1.time);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajkc
 * JD-Core Version:    0.7.0.1
 */