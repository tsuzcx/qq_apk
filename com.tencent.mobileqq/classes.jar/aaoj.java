import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import java.io.File;
import java.io.FileFilter;

public final class aaoj
  implements FileFilter
{
  public aaoj(String paramString, boolean paramBoolean) {}
  
  public boolean accept(File paramFile)
  {
    String str = paramFile.getName();
    int i = str.lastIndexOf('.');
    if (i <= 0) {}
    do
    {
      do
      {
        return false;
      } while (!str.substring(i).equalsIgnoreCase(".app"));
      str = str.substring(0, i);
    } while ((!ArkLocalAppMgr.b(str)) || (ArkLocalAppMgr.a(str, this.jdField_a_of_type_JavaLangString) >= 0));
    if (this.jdField_a_of_type_Boolean) {
      paramFile.deleteOnExit();
    }
    for (;;)
    {
      return true;
      paramFile.delete();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaoj
 * JD-Core Version:    0.7.0.1
 */