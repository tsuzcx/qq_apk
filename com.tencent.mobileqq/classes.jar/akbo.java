import java.util.Comparator;

class akbo
  implements Comparator<atza>
{
  akbo(akbn paramakbn) {}
  
  public int a(atza paramatza1, atza paramatza2)
  {
    if ((!paramatza1.a()) && (paramatza2.a())) {
      return -1;
    }
    if ((paramatza1.a()) && (!paramatza2.a())) {
      return 1;
    }
    return (int)(paramatza2.a - paramatza1.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akbo
 * JD-Core Version:    0.7.0.1
 */