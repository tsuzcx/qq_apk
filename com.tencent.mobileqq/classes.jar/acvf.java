import java.util.Comparator;

final class acvf
  implements Comparator<acvd>
{
  public int a(acvd paramacvd1, acvd paramacvd2)
  {
    if ((paramacvd1 == null) && (paramacvd2 == null)) {}
    do
    {
      return 0;
      if ((paramacvd1 == null) && (paramacvd2 != null)) {
        return 1;
      }
      if ((paramacvd1 != null) && (paramacvd2 == null)) {
        return -1;
      }
      if (paramacvd1.a() > paramacvd2.a()) {
        return -1;
      }
    } while (paramacvd1.a() >= paramacvd2.a());
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     acvf
 * JD-Core Version:    0.7.0.1
 */