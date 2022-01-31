import java.io.File;
import java.io.FilenameFilter;

public final class ajoo
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    return (paramString.toLowerCase().endsWith(".amr")) || (paramString.toLowerCase().endsWith(".mp3"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajoo
 * JD-Core Version:    0.7.0.1
 */