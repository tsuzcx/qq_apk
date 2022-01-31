import android.util.SparseIntArray;
import java.util.Comparator;

final class aewi
  implements Comparator<aewe>
{
  public int a(aewe paramaewe1, aewe paramaewe2)
  {
    if ((paramaewe1 == null) || (paramaewe2 == null)) {
      return 0;
    }
    float f1 = aewh.a().get(paramaewe1.c());
    float f2 = aewh.a().get(paramaewe2.c());
    float f3 = paramaewe1.b() * 100;
    float f4 = 1.0F / (paramaewe1.a() + 1) / 10.0F;
    return Float.compare(f2 + (paramaewe2.b() * 100 + 1.0F / (paramaewe2.a() + 1) / 10.0F), f1 + (f3 + f4));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aewi
 * JD-Core Version:    0.7.0.1
 */