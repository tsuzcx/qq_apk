import android.util.SparseIntArray;
import java.util.Comparator;

final class agyc
  implements Comparator<agxy>
{
  public int a(agxy paramagxy1, agxy paramagxy2)
  {
    if ((paramagxy1 == null) || (paramagxy2 == null)) {
      return 0;
    }
    float f1 = agyb.a().get(paramagxy1.c());
    float f2 = agyb.a().get(paramagxy2.c());
    float f3 = paramagxy1.b() * 100;
    float f4 = 1.0F / (paramagxy1.a() + 1) / 10.0F;
    return Float.compare(f2 + (paramagxy2.b() * 100 + 1.0F / (paramagxy2.a() + 1) / 10.0F), f1 + (f3 + f4));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agyc
 * JD-Core Version:    0.7.0.1
 */