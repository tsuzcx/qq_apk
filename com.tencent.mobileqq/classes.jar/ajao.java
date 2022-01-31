import java.io.File;
import java.io.FilenameFilter;

class ajao
  implements FilenameFilter
{
  ajao(ajan paramajan) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return paramString.startsWith("[Thumb]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajao
 * JD-Core Version:    0.7.0.1
 */