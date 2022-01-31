import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;

public class ajya
{
  public static BaseApplicationImpl a = BaseApplicationImpl.sApplication;
  
  public static String a(int paramInt)
  {
    try
    {
      String str = a.getResources().getString(paramInt);
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajya
 * JD-Core Version:    0.7.0.1
 */