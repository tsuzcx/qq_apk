import java.util.Comparator;

final class aiht
  implements Comparator<aihp>
{
  public int a(aihp paramaihp1, aihp paramaihp2)
  {
    if ((paramaihp1 == null) || (paramaihp2 == null)) {
      return 0;
    }
    return Float.compare(paramaihp1.a(), paramaihp2.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiht
 * JD-Core Version:    0.7.0.1
 */