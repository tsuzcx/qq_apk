import java.io.File;
import java.util.Comparator;

class alvh
  implements Comparator<File>
{
  alvh(alvg paramalvg) {}
  
  public int a(File paramFile1, File paramFile2)
  {
    long l2 = 0L;
    if (paramFile1 != null) {}
    for (long l1 = paramFile1.lastModified();; l1 = 0L)
    {
      if (paramFile2 != null) {
        l2 = paramFile2.lastModified();
      }
      if (l2 >= l1) {
        break;
      }
      return -1;
    }
    if (l2 > l1) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alvh
 * JD-Core Version:    0.7.0.1
 */