import java.util.Comparator;

class alys
  implements Comparator<alyt>
{
  alys(alyr paramalyr) {}
  
  public int a(alyt paramalyt1, alyt paramalyt2)
  {
    if (paramalyt1.a == paramalyt2.a) {
      return 0;
    }
    if (paramalyt1.a > paramalyt2.a) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alys
 * JD-Core Version:    0.7.0.1
 */