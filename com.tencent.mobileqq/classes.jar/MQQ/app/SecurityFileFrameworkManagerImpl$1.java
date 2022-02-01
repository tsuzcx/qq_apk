package mqq.app;

import java.io.File;
import java.io.FileFilter;

final class SecurityFileFrameworkManagerImpl$1
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    boolean bool3 = paramFile.isDirectory();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (paramFile.getName().startsWith("NoRename#"))
      {
        paramFile = paramFile.getName().replaceAll("NoRename#", "");
        bool1 = bool2;
        if (paramFile.length() == 9)
        {
          bool1 = bool2;
          if (paramFile.charAt(0) == SecurityFileFrameworkManagerImpl.generateVerifyChar(paramFile.substring(1))) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mqq.app.SecurityFileFrameworkManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */