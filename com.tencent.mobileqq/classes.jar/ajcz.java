import java.util.Comparator;

class ajcz
  implements Comparator<ajda>
{
  ajcz(ajcy paramajcy) {}
  
  public int a(ajda paramajda1, ajda paramajda2)
  {
    if (paramajda1.a == paramajda2.a) {
      return 0;
    }
    if (paramajda1.a > paramajda2.a) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajcz
 * JD-Core Version:    0.7.0.1
 */