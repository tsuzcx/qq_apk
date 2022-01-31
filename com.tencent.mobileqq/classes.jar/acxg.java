import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.util.Comparator;

public final class acxg
  implements Comparator
{
  public int a(FileInfo paramFileInfo1, FileInfo paramFileInfo2)
  {
    return -Long.valueOf(paramFileInfo1.b()).compareTo(Long.valueOf(paramFileInfo2.b()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acxg
 * JD-Core Version:    0.7.0.1
 */