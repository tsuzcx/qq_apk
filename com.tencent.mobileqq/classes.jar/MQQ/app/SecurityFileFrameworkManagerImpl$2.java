package mqq.app;

import java.io.File;
import java.io.FileFilter;

class SecurityFileFrameworkManagerImpl$2
  implements FileFilter
{
  SecurityFileFrameworkManagerImpl$2(SecurityFileFrameworkManagerImpl paramSecurityFileFrameworkManagerImpl, String paramString) {}
  
  public boolean accept(File paramFile)
  {
    return (paramFile.isDirectory()) && ((paramFile.getName().length() == 32) || (paramFile.getName().equals(this.val$UIN)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mqq.app.SecurityFileFrameworkManagerImpl.2
 * JD-Core Version:    0.7.0.1
 */