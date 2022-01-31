import android.util.SparseIntArray;
import java.util.Comparator;

final class aewk
  implements Comparator<aewg>
{
  public int a(aewg paramaewg1, aewg paramaewg2)
  {
    if ((paramaewg1 == null) || (paramaewg2 == null)) {
      return 0;
    }
    float f1 = aewj.a().get(paramaewg1.c());
    float f2 = aewj.a().get(paramaewg2.c());
    float f3 = paramaewg1.b() * 100;
    float f4 = 1.0F / (paramaewg1.a() + 1) / 10.0F;
    return Float.compare(f2 + (paramaewg2.b() * 100 + 1.0F / (paramaewg2.a() + 1) / 10.0F), f1 + (f3 + f4));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aewk
 * JD-Core Version:    0.7.0.1
 */