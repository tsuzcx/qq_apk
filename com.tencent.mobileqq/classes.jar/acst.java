import java.io.File;
import java.io.FileFilter;

class acst
  implements FileFilter
{
  acst(acsr paramacsr) {}
  
  public boolean accept(File paramFile)
  {
    return paramFile.getName().startsWith(acsr.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acst
 * JD-Core Version:    0.7.0.1
 */