import java.util.Comparator;

class ajcn
  implements Comparator<ajco>
{
  ajcn(ajcm paramajcm) {}
  
  public int a(ajco paramajco1, ajco paramajco2)
  {
    if (paramajco2.a - paramajco1.a > 0.0F) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajcn
 * JD-Core Version:    0.7.0.1
 */