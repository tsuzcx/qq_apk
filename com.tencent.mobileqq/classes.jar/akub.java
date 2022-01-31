import java.util.Comparator;

class akub
  implements Comparator<akud>
{
  akub(akua paramakua) {}
  
  public int a(akud paramakud1, akud paramakud2)
  {
    if (paramakud1.a == paramakud2.a) {
      return 0;
    }
    if (paramakud1.a > paramakud2.a) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akub
 * JD-Core Version:    0.7.0.1
 */