import com.tencent.mobileqq.unifiedebug.UnifiedDebugManager;
import java.io.File;
import java.io.FilenameFilter;

public class ajyd
  implements FilenameFilter
{
  public ajyd(UnifiedDebugManager paramUnifiedDebugManager, String paramString) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return (paramString.startsWith(this.jdField_a_of_type_JavaLangString)) && (paramString.endsWith(".localstorage"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajyd
 * JD-Core Version:    0.7.0.1
 */