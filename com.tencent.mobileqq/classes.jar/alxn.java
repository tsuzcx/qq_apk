import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class alxn
  implements alxo
{
  public final String a = alxm.a + "." + getClass().getSimpleName();
  
  public static final String a(String paramString1, String paramString2)
  {
    return alyo.a() + File.separator + "_res/" + paramString1;
  }
  
  public String a(alxr paramalxr)
  {
    return alyo.a() + File.separator + "_res/" + paramalxr.b + File.separator;
  }
  
  public boolean a(alxr paramalxr)
  {
    String str = b(paramalxr);
    try
    {
      boolean bool = new File(str).exists();
      if (QLog.isColorLevel()) {
        QLog.d(this.a, 2, "needDownload.file exist|" + bool + "|" + paramalxr + "|" + str);
      }
      if (!bool) {
        return true;
      }
    }
    catch (Throwable paramalxr)
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.a, 2, "isNeedDownload.exception happen.e=" + paramalxr.getMessage());
      }
      paramalxr.printStackTrace();
    }
    return false;
  }
  
  public boolean a(alxr paramalxr, boolean paramBoolean)
  {
    return true;
  }
  
  public String b(alxr paramalxr)
  {
    return a(paramalxr.b, paramalxr.c);
  }
  
  public boolean b(alxr paramalxr)
  {
    boolean bool = true;
    String str = aurl.a(b(paramalxr));
    if (!paramalxr.b.equalsIgnoreCase(str))
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.a, 1, "checkDownloadFile.verify failed|" + str + "|" + paramalxr);
      }
      bool = false;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alxn
 * JD-Core Version:    0.7.0.1
 */