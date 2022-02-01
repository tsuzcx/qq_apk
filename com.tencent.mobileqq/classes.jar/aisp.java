import java.util.Comparator;

final class aisp
  implements Comparator<aisl>
{
  public int a(aisl paramaisl1, aisl paramaisl2)
  {
    if ((paramaisl1 == null) || (paramaisl2 == null)) {
      return 0;
    }
    return Float.compare(paramaisl1.a(), paramaisl2.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aisp
 * JD-Core Version:    0.7.0.1
 */