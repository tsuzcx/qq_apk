import android.util.SparseIntArray;
import java.util.Comparator;

final class aisq
  implements Comparator<aisl>
{
  public int a(aisl paramaisl1, aisl paramaisl2)
  {
    if ((paramaisl1 == null) || (paramaisl2 == null)) {
      return 0;
    }
    float f1 = aiso.a().get(paramaisl1.c());
    float f2 = aiso.a().get(paramaisl2.c());
    float f3 = paramaisl1.b() * 100;
    float f4 = 1.0F / (paramaisl1.a() + 1) / 10.0F;
    return Float.compare(f2 + (paramaisl2.b() * 100 + 1.0F / (paramaisl2.a() + 1) / 10.0F), f1 + (f3 + f4));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aisq
 * JD-Core Version:    0.7.0.1
 */