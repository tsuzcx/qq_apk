import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class agaq
{
  public static boolean a(String paramString)
  {
    if (("jpg".equals(paramString)) || ("gif".equals(paramString)) || ("png".equals(paramString)) || ("jpeg".equals(paramString))) {}
    while ((paramString.lastIndexOf("bmp") != -1) || (paramString.lastIndexOf("bitmap") != -1)) {
      return true;
    }
    return false;
  }
  
  public static String[] a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String[] arrayOfString;
    do
    {
      return null;
      arrayOfString = paramString.split("/");
      if (arrayOfString.length == 2) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("MimeHelper", 2, "Mimetype error:" + paramString);
    return null;
    return arrayOfString;
  }
  
  public static boolean b(String paramString)
  {
    return "video/mp4".equals(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agaq
 * JD-Core Version:    0.7.0.1
 */