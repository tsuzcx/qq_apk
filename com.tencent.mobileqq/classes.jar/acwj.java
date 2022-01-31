import com.tencent.mobileqq.filemanager.settings.FMSettings;
import java.io.File;

public class acwj
  implements Runnable
{
  public acwj(FMSettings paramFMSettings, String paramString) {}
  
  public void run()
  {
    try
    {
      Object localObject = new File(this.jdField_a_of_type_JavaLangString);
      if (!((File)localObject).exists()) {
        return;
      }
      if (((File)localObject).isDirectory())
      {
        localObject = ((File)localObject).listFiles();
        if ((localObject != null) && (localObject.length != 0))
        {
          int j = localObject.length;
          int i = 0;
          while (i < j)
          {
            localObject[i].delete();
            i += 1;
          }
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acwj
 * JD-Core Version:    0.7.0.1
 */