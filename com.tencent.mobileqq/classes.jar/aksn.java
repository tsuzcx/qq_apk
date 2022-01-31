import java.io.File;
import java.io.FileFilter;

final class aksn
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
        if (!Character.isDigit(paramFile.charAt(i))) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aksn
 * JD-Core Version:    0.7.0.1
 */