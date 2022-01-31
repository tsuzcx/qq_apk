import com.tencent.mobileqq.utils.SecUtil;
import java.util.concurrent.ConcurrentHashMap;

public class abux
{
  private static ConcurrentHashMap<String, String> a = new ConcurrentHashMap();
  
  public static String a(String paramString)
  {
    String str2 = (String)a.get(paramString);
    String str1 = str2;
    if (str2 == null)
    {
      str2 = SecUtil.getFileMd5(paramString);
      str1 = str2;
      if (str2 != null)
      {
        a.put(paramString, str2);
        str1 = str2;
      }
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abux
 * JD-Core Version:    0.7.0.1
 */