import java.io.File;
import java.io.FilenameFilter;

class ajos
  implements FilenameFilter
{
  ajos(ajor paramajor) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return paramString.startsWith("[Thumb]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajos
 * JD-Core Version:    0.7.0.1
 */