import java.io.File;
import java.util.Comparator;

final class ajev
  implements Comparator<File>
{
  private int a(String paramString)
  {
    try
    {
      int i = paramString.lastIndexOf('.');
      if (i == -1) {
        return Integer.parseInt(paramString);
      }
      i = Integer.parseInt(paramString.substring(0, i));
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  public int a(File paramFile1, File paramFile2)
  {
    return a(paramFile1.getName()) - a(paramFile2.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajev
 * JD-Core Version:    0.7.0.1
 */