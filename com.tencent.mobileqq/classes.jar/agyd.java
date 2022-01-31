import java.util.Comparator;

final class agyd
  implements Comparator<agxy>
{
  public int a(agxy paramagxy1, agxy paramagxy2)
  {
    if ((paramagxy1 == null) || (paramagxy2 == null)) {
      return 0;
    }
    return Float.compare(paramagxy1.a(), paramagxy2.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agyd
 * JD-Core Version:    0.7.0.1
 */