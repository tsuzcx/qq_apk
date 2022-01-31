import android.content.Context;
import android.media.AudioManager;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;

public class ahzp
{
  public static long a;
  public static Context a;
  public static String a;
  
  static
  {
    jdField_a_of_type_AndroidContentContext = MobileQQ.getContext();
    jdField_a_of_type_Long = -1L;
  }
  
  public static void a()
  {
    try
    {
      ((AudioManager)MobileQQ.getContext().getSystemService("audio")).requestAudioFocus(null, 3, 1);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static boolean a(long paramLong)
  {
    if ((jdField_a_of_type_Long > 0L) && (jdField_a_of_type_Long == paramLong)) {}
    Object localObject;
    do
    {
      return true;
      localObject = ahzq.a().a();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return false;
      }
      jdField_a_of_type_JavaLangString = (String)localObject + File.separator + "cover" + File.separator + paramLong;
      localObject = new File(jdField_a_of_type_JavaLangString);
    } while ((((File)localObject).mkdirs()) || (((File)localObject).isDirectory()));
    QLog.e("GloableValue", 2, "make cover dir: " + jdField_a_of_type_JavaLangString + " failed.");
    return false;
  }
  
  public static void b()
  {
    try
    {
      ((AudioManager)MobileQQ.getContext().getSystemService("audio")).abandonAudioFocus(null);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahzp
 * JD-Core Version:    0.7.0.1
 */