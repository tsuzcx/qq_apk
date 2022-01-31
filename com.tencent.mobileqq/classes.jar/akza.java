import java.util.Comparator;

class akza
  implements Comparator<akzb>
{
  akza(akyz paramakyz) {}
  
  public int a(akzb paramakzb1, akzb paramakzb2)
  {
    if (paramakzb1.a == paramakzb2.a) {
      return 0;
    }
    if (paramakzb1.a > paramakzb2.a) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akza
 * JD-Core Version:    0.7.0.1
 */