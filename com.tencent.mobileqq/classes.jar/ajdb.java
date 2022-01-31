import java.util.Comparator;

class ajdb
  implements Comparator<ajdc>
{
  ajdb(ajda paramajda) {}
  
  public int a(ajdc paramajdc1, ajdc paramajdc2)
  {
    if (paramajdc1.a == paramajdc2.a) {
      return 0;
    }
    if (paramajdc1.a > paramajdc2.a) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajdb
 * JD-Core Version:    0.7.0.1
 */