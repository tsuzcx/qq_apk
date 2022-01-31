import java.util.Comparator;

class ajcr
  implements Comparator<ajct>
{
  ajcr(ajcq paramajcq) {}
  
  public int a(ajct paramajct1, ajct paramajct2)
  {
    if (paramajct1.a == paramajct2.a) {
      return 0;
    }
    if (paramajct1.a > paramajct2.a) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajcr
 * JD-Core Version:    0.7.0.1
 */