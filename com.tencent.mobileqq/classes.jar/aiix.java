import android.util.SparseIntArray;
import java.util.Comparator;

final class aiix
  implements Comparator<aiis>
{
  public int a(aiis paramaiis1, aiis paramaiis2)
  {
    if ((paramaiis1 == null) || (paramaiis2 == null)) {
      return 0;
    }
    float f1 = aiiv.a().get(paramaiis1.c());
    float f2 = aiiv.a().get(paramaiis2.c());
    float f3 = paramaiis1.b() * 100;
    float f4 = 1.0F / (paramaiis1.a() + 1) / 10.0F;
    return Float.compare(f2 + (paramaiis2.b() * 100 + 1.0F / (paramaiis2.a() + 1) / 10.0F), f1 + (f3 + f4));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiix
 * JD-Core Version:    0.7.0.1
 */