import java.util.Comparator;

final class ahmz
  implements Comparator<ahmv>
{
  public int a(ahmv paramahmv1, ahmv paramahmv2)
  {
    if ((paramahmv1 == null) || (paramahmv2 == null)) {
      return 0;
    }
    return Float.compare(paramahmv1.a(), paramahmv2.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahmz
 * JD-Core Version:    0.7.0.1
 */