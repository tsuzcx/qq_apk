import java.io.File;
import java.io.FilenameFilter;

class ajwf
  implements FilenameFilter
{
  ajwf(ajwe paramajwe) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return paramString.startsWith("[Thumb]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajwf
 * JD-Core Version:    0.7.0.1
 */