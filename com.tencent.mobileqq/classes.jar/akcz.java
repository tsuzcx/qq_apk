import java.util.Comparator;

public class akcz
  implements Comparator<akda>
{
  private int a;
  
  public akcz(int paramInt)
  {
    this.a = paramInt;
  }
  
  public int a(akda paramakda1, akda paramakda2)
  {
    if (this.a == 2) {
      if (paramakda1.b <= paramakda2.b) {}
    }
    while (paramakda1.a > paramakda2.a)
    {
      return -1;
      if (paramakda1.b < paramakda2.b) {
        return 1;
      }
      return 0;
    }
    if (paramakda1.a < paramakda2.a) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akcz
 * JD-Core Version:    0.7.0.1
 */