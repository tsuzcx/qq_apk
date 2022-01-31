import java.util.Comparator;

public class akrl
  implements Comparator<akrm>
{
  private int a;
  
  public akrl(int paramInt)
  {
    this.a = paramInt;
  }
  
  public int a(akrm paramakrm1, akrm paramakrm2)
  {
    if (this.a == 2) {
      if (paramakrm1.b <= paramakrm2.b) {}
    }
    while (paramakrm1.a > paramakrm2.a)
    {
      return -1;
      if (paramakrm1.b < paramakrm2.b) {
        return 1;
      }
      return 0;
    }
    if (paramakrm1.a < paramakrm2.a) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akrl
 * JD-Core Version:    0.7.0.1
 */