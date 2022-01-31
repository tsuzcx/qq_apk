import java.io.File;
import java.io.FileFilter;

class acsp
  implements FileFilter
{
  acsp(acsn paramacsn) {}
  
  public boolean accept(File paramFile)
  {
    return paramFile.getName().startsWith(acsn.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acsp
 * JD-Core Version:    0.7.0.1
 */