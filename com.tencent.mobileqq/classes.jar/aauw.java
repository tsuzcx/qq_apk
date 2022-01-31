import java.io.File;
import java.io.FileFilter;

public final class aauw
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    return (paramFile.isFile()) && (paramFile.exists());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aauw
 * JD-Core Version:    0.7.0.1
 */