import java.util.Comparator;

class ajqf
  implements Comparator<ajqe>
{
  public int a(ajqe paramajqe1, ajqe paramajqe2)
  {
    if (paramajqe1.b < paramajqe2.b) {
      return -1;
    }
    if (paramajqe1.b > paramajqe2.b) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajqf
 * JD-Core Version:    0.7.0.1
 */