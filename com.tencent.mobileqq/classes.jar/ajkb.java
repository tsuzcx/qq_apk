import java.util.Comparator;

class ajkb
  implements Comparator<ajmf>
{
  ajkb(ajka paramajka) {}
  
  public int a(ajmf paramajmf1, ajmf paramajmf2)
  {
    if ((!paramajmf1.a()) && (paramajmf2.a())) {
      return -1;
    }
    if ((paramajmf1.a()) && (!paramajmf2.a())) {
      return 1;
    }
    return (int)(paramajmf2.a - paramajmf1.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajkb
 * JD-Core Version:    0.7.0.1
 */