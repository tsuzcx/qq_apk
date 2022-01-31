import java.util.Comparator;

class alxs
  implements Comparator<avun>
{
  alxs(alxr paramalxr) {}
  
  public int a(avun paramavun1, avun paramavun2)
  {
    if ((!paramavun1.a()) && (paramavun2.a())) {
      return -1;
    }
    if ((paramavun1.a()) && (!paramavun2.a())) {
      return 1;
    }
    return (int)(paramavun2.a - paramavun1.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alxs
 * JD-Core Version:    0.7.0.1
 */