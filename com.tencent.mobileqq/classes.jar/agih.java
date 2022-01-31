import com.tencent.mobileqq.olympic.ShuayishuaConfig;
import java.util.Comparator;

public final class agih
  implements Comparator
{
  public int a(ShuayishuaConfig paramShuayishuaConfig1, ShuayishuaConfig paramShuayishuaConfig2)
  {
    long l = paramShuayishuaConfig1.realBegin - paramShuayishuaConfig2.realBegin;
    if (l > 0L) {
      return 1;
    }
    if (l < 0L) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agih
 * JD-Core Version:    0.7.0.1
 */