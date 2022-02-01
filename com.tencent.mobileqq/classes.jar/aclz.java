import java.util.Comparator;

final class aclz
  implements Comparator<aclx>
{
  public int a(aclx paramaclx1, aclx paramaclx2)
  {
    if ((paramaclx1 == null) && (paramaclx2 == null)) {}
    do
    {
      return 0;
      if ((paramaclx1 == null) && (paramaclx2 != null)) {
        return 1;
      }
      if ((paramaclx1 != null) && (paramaclx2 == null)) {
        return -1;
      }
      if (paramaclx1.a() > paramaclx2.a()) {
        return -1;
      }
    } while (paramaclx1.a() >= paramaclx2.a());
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aclz
 * JD-Core Version:    0.7.0.1
 */