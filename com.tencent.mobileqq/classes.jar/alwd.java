import java.util.Comparator;

class alwd
  implements Comparator<alwc>
{
  public int a(alwc paramalwc1, alwc paramalwc2)
  {
    if (paramalwc1.b < paramalwc2.b) {
      return -1;
    }
    if (paramalwc1.b > paramalwc2.b) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alwd
 * JD-Core Version:    0.7.0.1
 */