import java.util.Comparator;

final class abvs
  implements Comparator<abvq>
{
  public int a(abvq paramabvq1, abvq paramabvq2)
  {
    if ((paramabvq1 == null) && (paramabvq2 == null)) {}
    do
    {
      return 0;
      if ((paramabvq1 == null) && (paramabvq2 != null)) {
        return 1;
      }
      if ((paramabvq1 != null) && (paramabvq2 == null)) {
        return -1;
      }
      if (paramabvq1.a() > paramabvq2.a()) {
        return -1;
      }
    } while (paramabvq1.a() >= paramabvq2.a());
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     abvs
 * JD-Core Version:    0.7.0.1
 */