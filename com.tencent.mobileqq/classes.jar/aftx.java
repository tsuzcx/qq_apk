import java.io.File;
import java.io.FileFilter;

class aftx
  implements FileFilter
{
  aftx(aftv paramaftv) {}
  
  public boolean accept(File paramFile)
  {
    return paramFile.getName().startsWith(aftv.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aftx
 * JD-Core Version:    0.7.0.1
 */