import java.io.File;
import java.io.FileFilter;

public final class alee
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    return paramFile.getName().startsWith("hc_");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alee
 * JD-Core Version:    0.7.0.1
 */