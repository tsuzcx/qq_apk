import java.util.Comparator;

class akep
  implements Comparator<akeo>
{
  public int a(akeo paramakeo1, akeo paramakeo2)
  {
    if (paramakeo1.b < paramakeo2.b) {
      return -1;
    }
    if (paramakeo1.b > paramakeo2.b) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akep
 * JD-Core Version:    0.7.0.1
 */