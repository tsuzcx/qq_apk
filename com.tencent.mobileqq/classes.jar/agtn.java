import android.util.SparseIntArray;
import java.util.Comparator;

final class agtn
  implements Comparator<agtj>
{
  public int a(agtj paramagtj1, agtj paramagtj2)
  {
    if ((paramagtj1 == null) || (paramagtj2 == null)) {
      return 0;
    }
    float f1 = agtm.a().get(paramagtj1.c());
    float f2 = agtm.a().get(paramagtj2.c());
    float f3 = paramagtj1.b() * 100;
    float f4 = 1.0F / (paramagtj1.a() + 1) / 10.0F;
    return Float.compare(f2 + (paramagtj2.b() * 100 + 1.0F / (paramagtj2.a() + 1) / 10.0F), f1 + (f3 + f4));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agtn
 * JD-Core Version:    0.7.0.1
 */