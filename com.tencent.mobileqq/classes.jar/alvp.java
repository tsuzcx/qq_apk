import java.io.File;
import java.util.Comparator;

public final class alvp
  implements Comparator
{
  public int a(File paramFile1, File paramFile2)
  {
    long l = paramFile1.length() - paramFile2.length();
    if (l > 0L) {
      return 1;
    }
    if (l == 0L) {
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alvp
 * JD-Core Version:    0.7.0.1
 */