import com.tencent.qphone.base.util.QLog;
import oicq.wlogin_sdk.tools.MD5;
import org.json.JSONObject;

public class alvc
{
  String a;
  String b;
  String c;
  
  public static alvc a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      try
      {
        alvc localalvc = new alvc();
        paramString = new JSONObject(paramString);
        localalvc.a = paramString.getString("url");
        if (localalvc.a != null)
        {
          localalvc.a = localalvc.a.trim();
          localalvc.c = MD5.toMD5(localalvc.a);
        }
        localalvc.b = paramString.getString("md5");
        if (localalvc.b != null) {
          localalvc.b = localalvc.b.trim();
        }
        paramString = localalvc;
        if (QLog.isDevelopLevel())
        {
          auwz.a("HotchatSCMng", "parse ConfigData", new Object[] { localalvc });
          return localalvc;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("[url:").append(this.a).append(",").append("md5:").append(this.b).append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alvc
 * JD-Core Version:    0.7.0.1
 */