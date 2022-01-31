import com.tencent.mobileqq.unifiedebug.UnifiedDebugManager;
import java.io.File;
import java.io.FilenameFilter;

public class ajjy
  implements FilenameFilter
{
  public ajjy(UnifiedDebugManager paramUnifiedDebugManager, String paramString) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.startsWith(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajjy
 * JD-Core Version:    0.7.0.1
 */