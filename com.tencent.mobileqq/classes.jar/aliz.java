import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aliz
  implements alja
{
  public final String a = aliy.a + "." + getClass().getSimpleName();
  
  public static final String a(String paramString1, String paramString2)
  {
    return alka.a() + File.separator + "_res/" + paramString1;
  }
  
  public String a(aljd paramaljd)
  {
    return alka.a() + File.separator + "_res/" + paramaljd.b + File.separator;
  }
  
  public boolean a(aljd paramaljd)
  {
    String str = b(paramaljd);
    try
    {
      boolean bool = new File(str).exists();
      if (QLog.isColorLevel()) {
        QLog.d(this.a, 2, "needDownload.file exist|" + bool + "|" + paramaljd + "|" + str);
      }
      if (!bool) {
        return true;
      }
    }
    catch (Throwable paramaljd)
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.a, 2, "isNeedDownload.exception happen.e=" + paramaljd.getMessage());
      }
      paramaljd.printStackTrace();
    }
    return false;
  }
  
  public boolean a(aljd paramaljd, boolean paramBoolean)
  {
    return true;
  }
  
  public String b(aljd paramaljd)
  {
    return a(paramaljd.b, paramaljd.c);
  }
  
  public boolean b(aljd paramaljd)
  {
    boolean bool = true;
    String str = attn.a(b(paramaljd));
    if (!paramaljd.b.equalsIgnoreCase(str))
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.a, 1, "checkDownloadFile.verify failed|" + str + "|" + paramaljd);
      }
      bool = false;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aliz
 * JD-Core Version:    0.7.0.1
 */