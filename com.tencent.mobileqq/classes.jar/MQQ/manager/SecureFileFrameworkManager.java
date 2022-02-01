package mqq.manager;

import android.support.annotation.Nullable;
import java.io.File;
import mqq.app.ISecurityFileHelper;

public abstract interface SecureFileFrameworkManager
  extends Manager
{
  public abstract String getEncryptUIN();
  
  @Nullable
  public abstract File getUINRootFile(@Nullable ISecurityFileHelper paramISecurityFileHelper);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mqq.manager.SecureFileFrameworkManager
 * JD-Core Version:    0.7.0.1
 */