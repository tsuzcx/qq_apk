import java.util.Comparator;

final class aczj
  implements Comparator<aczh>
{
  public int a(aczh paramaczh1, aczh paramaczh2)
  {
    if ((paramaczh1 == null) && (paramaczh2 == null)) {}
    do
    {
      return 0;
      if ((paramaczh1 == null) && (paramaczh2 != null)) {
        return 1;
      }
      if ((paramaczh1 != null) && (paramaczh2 == null)) {
        return -1;
      }
      if (paramaczh1.a() > paramaczh2.a()) {
        return -1;
      }
    } while (paramaczh1.a() >= paramaczh2.a());
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aczj
 * JD-Core Version:    0.7.0.1
 */