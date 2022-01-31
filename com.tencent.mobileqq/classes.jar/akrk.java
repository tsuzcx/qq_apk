import java.util.Comparator;

public class akrk
  implements Comparator<akrl>
{
  private int a;
  
  public akrk(int paramInt)
  {
    this.a = paramInt;
  }
  
  public int a(akrl paramakrl1, akrl paramakrl2)
  {
    if (this.a == 2) {
      if (paramakrl1.b <= paramakrl2.b) {}
    }
    while (paramakrl1.a > paramakrl2.a)
    {
      return -1;
      if (paramakrl1.b < paramakrl2.b) {
        return 1;
      }
      return 0;
    }
    if (paramakrl1.a < paramakrl2.a) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akrk
 * JD-Core Version:    0.7.0.1
 */