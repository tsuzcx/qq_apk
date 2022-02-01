import android.util.SparseIntArray;
import java.util.Comparator;

final class aihu
  implements Comparator<aihp>
{
  public int a(aihp paramaihp1, aihp paramaihp2)
  {
    if ((paramaihp1 == null) || (paramaihp2 == null)) {
      return 0;
    }
    float f1 = aihs.a().get(paramaihp1.c());
    float f2 = aihs.a().get(paramaihp2.c());
    float f3 = paramaihp1.b() * 100;
    float f4 = 1.0F / (paramaihp1.a() + 1) / 10.0F;
    return Float.compare(f2 + (paramaihp2.b() * 100 + 1.0F / (paramaihp2.a() + 1) / 10.0F), f1 + (f3 + f4));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aihu
 * JD-Core Version:    0.7.0.1
 */