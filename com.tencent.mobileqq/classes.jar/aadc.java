import java.io.File;
import java.io.FileFilter;

public final class aadc
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    paramFile = paramFile.getName();
    if (paramFile.startsWith("cpu"))
    {
      int i = 3;
      while (i < paramFile.length())
      {
        if ((paramFile.charAt(i) < '0') || (paramFile.charAt(i) > '9')) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aadc
 * JD-Core Version:    0.7.0.1
 */