import com.tencent.mobileqq.hotpic.HotPicManager;
import java.io.File;
import java.util.Comparator;

public class adgb
  implements Comparator
{
  public adgb(HotPicManager paramHotPicManager) {}
  
  public int a(File paramFile1, File paramFile2)
  {
    if (paramFile1.lastModified() > paramFile2.lastModified()) {}
    do
    {
      return -1;
      if (paramFile1.lastModified() != paramFile2.lastModified()) {
        break;
      }
      if (paramFile1.length() > paramFile2.length()) {
        return 1;
      }
    } while (paramFile1.length() < paramFile2.length());
    return 0;
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adgb
 * JD-Core Version:    0.7.0.1
 */