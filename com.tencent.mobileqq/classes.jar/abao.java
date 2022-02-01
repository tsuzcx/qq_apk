import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class abao
{
  String a = "";
  
  public static abao a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.videostory.capture", 2, "config TextUtils.isEmpty(config) return");
      }
      return null;
    }
    abao localabao = new abao();
    localabao.a(paramString);
    return localabao;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abao
 * JD-Core Version:    0.7.0.1
 */