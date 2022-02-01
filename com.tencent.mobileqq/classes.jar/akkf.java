import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import cooperation.qzone.util.QZLog;

public class akkf
{
  public String a;
  public String b;
  public String c;
  
  public void a(boolean paramBoolean)
  {
    if (QZLog.isColorLevel()) {
      QZLog.i("QbossADBannerConfigInfo", 2, " qboss resources down response resUrl = " + this.a + " isSuccess = " + paramBoolean);
    }
  }
  
  public boolean a()
  {
    if (TextUtils.isEmpty(this.c)) {
      return false;
    }
    return FileUtil.isFileExists(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akkf
 * JD-Core Version:    0.7.0.1
 */