import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class aaml
{
  String a = "";
  
  public static aaml a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.videostory.capture", 2, "config TextUtils.isEmpty(config) return");
      }
      return null;
    }
    aaml localaaml = new aaml();
    localaaml.a(paramString);
    return localaaml;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaml
 * JD-Core Version:    0.7.0.1
 */