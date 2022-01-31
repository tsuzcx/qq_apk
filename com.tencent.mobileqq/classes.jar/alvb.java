import java.util.Comparator;

class alvb
  implements Comparator<alve>
{
  alvb(alva paramalva) {}
  
  public int a(alve paramalve1, alve paramalve2)
  {
    if ((paramalve1 == null) || (paramalve2 == null)) {}
    do
    {
      return 0;
      if (paramalve1.a > paramalve2.a) {
        return 1;
      }
    } while (paramalve1.a >= paramalve2.a);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alvb
 * JD-Core Version:    0.7.0.1
 */