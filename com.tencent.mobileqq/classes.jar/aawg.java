import java.util.Comparator;

final class aawg
  implements Comparator<aawe>
{
  public int a(aawe paramaawe1, aawe paramaawe2)
  {
    if ((paramaawe1 == null) && (paramaawe2 == null)) {}
    do
    {
      return 0;
      if ((paramaawe1 == null) && (paramaawe2 != null)) {
        return 1;
      }
      if ((paramaawe1 != null) && (paramaawe2 == null)) {
        return -1;
      }
      if (paramaawe1.a() > paramaawe2.a()) {
        return -1;
      }
    } while (paramaawe1.a() >= paramaawe2.a());
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aawg
 * JD-Core Version:    0.7.0.1
 */