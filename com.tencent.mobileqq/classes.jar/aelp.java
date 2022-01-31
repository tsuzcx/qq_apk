import android.util.SparseIntArray;
import java.util.Comparator;

final class aelp
  implements Comparator<aell>
{
  public int a(aell paramaell1, aell paramaell2)
  {
    if ((paramaell1 == null) || (paramaell2 == null)) {
      return 0;
    }
    float f1 = aelo.a().get(paramaell1.c());
    float f2 = aelo.a().get(paramaell2.c());
    float f3 = paramaell1.b() * 100;
    float f4 = 1.0F / (paramaell1.a() + 1) / 10.0F;
    return Float.compare(f2 + (paramaell2.b() * 100 + 1.0F / (paramaell2.a() + 1) / 10.0F), f1 + (f3 + f4));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aelp
 * JD-Core Version:    0.7.0.1
 */