import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class alxm
  implements alxn
{
  public final String a = alxl.a + "." + getClass().getSimpleName();
  
  public static final String a(String paramString1, String paramString2)
  {
    return alyn.a() + File.separator + "_res/" + paramString1;
  }
  
  public String a(alxq paramalxq)
  {
    return alyn.a() + File.separator + "_res/" + paramalxq.b + File.separator;
  }
  
  public boolean a(alxq paramalxq)
  {
    String str = b(paramalxq);
    try
    {
      boolean bool = new File(str).exists();
      if (QLog.isColorLevel()) {
        QLog.d(this.a, 2, "needDownload.file exist|" + bool + "|" + paramalxq + "|" + str);
      }
      if (!bool) {
        return true;
      }
    }
    catch (Throwable paramalxq)
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.a, 2, "isNeedDownload.exception happen.e=" + paramalxq.getMessage());
      }
      paramalxq.printStackTrace();
    }
    return false;
  }
  
  public boolean a(alxq paramalxq, boolean paramBoolean)
  {
    return true;
  }
  
  public String b(alxq paramalxq)
  {
    return a(paramalxq.b, paramalxq.c);
  }
  
  public boolean b(alxq paramalxq)
  {
    boolean bool = true;
    String str = aurn.a(b(paramalxq));
    if (!paramalxq.b.equalsIgnoreCase(str))
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.a, 1, "checkDownloadFile.verify failed|" + str + "|" + paramalxq);
      }
      bool = false;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alxm
 * JD-Core Version:    0.7.0.1
 */