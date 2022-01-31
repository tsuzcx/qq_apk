import java.io.File;
import java.util.Comparator;

class acss
  implements Comparator<File>
{
  acss(acsr paramacsr) {}
  
  public int a(File paramFile1, File paramFile2)
  {
    long l = acsr.a(this.a, paramFile1) - acsr.a(this.a, paramFile2);
    if (l > 0L) {
      return 1;
    }
    if (l == 0L) {
      return 0;
    }
    return -1;
  }
  
  public boolean equals(Object paramObject)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acss
 * JD-Core Version:    0.7.0.1
 */