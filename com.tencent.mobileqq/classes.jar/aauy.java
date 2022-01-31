import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import java.io.File;
import java.io.FileFilter;

public final class aauy
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    if (!paramFile.isDirectory()) {}
    while (!ArkLocalAppMgr.a(paramFile.getName())) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aauy
 * JD-Core Version:    0.7.0.1
 */