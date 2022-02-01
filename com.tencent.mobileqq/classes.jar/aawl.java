import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class aawl
{
  String a = "";
  
  public static aawl a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.videostory.capture", 2, "config TextUtils.isEmpty(config) return");
      }
      return null;
    }
    aawl localaawl = new aawl();
    localaawl.a(paramString);
    return localaawl;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aawl
 * JD-Core Version:    0.7.0.1
 */