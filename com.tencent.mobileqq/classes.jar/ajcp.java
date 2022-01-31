import java.util.Comparator;

class ajcp
  implements Comparator<ajcr>
{
  ajcp(ajco paramajco) {}
  
  public int a(ajcr paramajcr1, ajcr paramajcr2)
  {
    if (paramajcr1.a == paramajcr2.a) {
      return 0;
    }
    if (paramajcr1.a > paramajcr2.a) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajcp
 * JD-Core Version:    0.7.0.1
 */