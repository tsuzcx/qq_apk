import java.util.Comparator;

class alfx
  implements Comparator<alfy>
{
  alfx(alfw paramalfw) {}
  
  public int a(alfy paramalfy1, alfy paramalfy2)
  {
    if (paramalfy2.a - paramalfy1.a > 0.0F) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alfx
 * JD-Core Version:    0.7.0.1
 */