import java.util.Comparator;

class alqm
  implements Comparator<alqp>
{
  alqm(alql paramalql) {}
  
  public int a(alqp paramalqp1, alqp paramalqp2)
  {
    if ((paramalqp1 == null) || (paramalqp2 == null)) {}
    do
    {
      return 0;
      if (paramalqp1.a > paramalqp2.a) {
        return 1;
      }
    } while (paramalqp1.a >= paramalqp2.a);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alqm
 * JD-Core Version:    0.7.0.1
 */