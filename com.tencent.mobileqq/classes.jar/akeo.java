import java.util.Comparator;

class akeo
  implements Comparator<aken>
{
  public int a(aken paramaken1, aken paramaken2)
  {
    if (paramaken1.b < paramaken2.b) {
      return -1;
    }
    if (paramaken1.b > paramaken2.b) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akeo
 * JD-Core Version:    0.7.0.1
 */