import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class alsp
{
  private int a;
  
  public static alsp a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      try
      {
        alsp localalsp = new alsp();
        localalsp.a = new JSONObject(paramString).getInt("ifrecent");
        return localalsp;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("ColorNoteRecentConfBean", 2, "ColorNoteRecentConfBean parse err: ", paramString);
    return null;
  }
  
  public boolean a()
  {
    return this.a == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alsp
 * JD-Core Version:    0.7.0.1
 */