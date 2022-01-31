import java.util.Comparator;

final class aarr
  implements Comparator<aarp>
{
  public int a(aarp paramaarp1, aarp paramaarp2)
  {
    if ((paramaarp1 == null) && (paramaarp2 == null)) {}
    do
    {
      return 0;
      if ((paramaarp1 == null) && (paramaarp2 != null)) {
        return 1;
      }
      if ((paramaarp1 != null) && (paramaarp2 == null)) {
        return -1;
      }
      if (paramaarp1.a() > paramaarp2.a()) {
        return -1;
      }
    } while (paramaarp1.a() >= paramaarp2.a());
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aarr
 * JD-Core Version:    0.7.0.1
 */