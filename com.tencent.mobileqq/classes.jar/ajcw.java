import java.util.Comparator;

class ajcw
  implements Comparator
{
  ajcw(ajcv paramajcv) {}
  
  public int a(Long paramLong1, Long paramLong2)
  {
    int i = 0;
    if (paramLong1.longValue() - paramLong2.longValue() > 0L) {
      i = 1;
    }
    while (paramLong1.longValue() - paramLong2.longValue() >= 0L) {
      return i;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajcw
 * JD-Core Version:    0.7.0.1
 */