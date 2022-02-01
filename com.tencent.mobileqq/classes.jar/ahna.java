import android.util.SparseIntArray;
import java.util.Comparator;

final class ahna
  implements Comparator<ahmv>
{
  public int a(ahmv paramahmv1, ahmv paramahmv2)
  {
    if ((paramahmv1 == null) || (paramahmv2 == null)) {
      return 0;
    }
    float f1 = ahmy.a().get(paramahmv1.c());
    float f2 = ahmy.a().get(paramahmv2.c());
    float f3 = paramahmv1.b() * 100;
    float f4 = 1.0F / (paramahmv1.a() + 1) / 10.0F;
    return Float.compare(f2 + (paramahmv2.b() * 100 + 1.0F / (paramahmv2.a() + 1) / 10.0F), f1 + (f3 + f4));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahna
 * JD-Core Version:    0.7.0.1
 */