import com.tencent.qphone.base.util.QLog;
import oicq.wlogin_sdk.tools.MD5;
import org.json.JSONObject;

public class alqn
{
  String a;
  String b;
  String c;
  
  public static alqn a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      try
      {
        alqn localalqn = new alqn();
        paramString = new JSONObject(paramString);
        localalqn.a = paramString.getString("url");
        if (localalqn.a != null)
        {
          localalqn.a = localalqn.a.trim();
          localalqn.c = MD5.toMD5(localalqn.a);
        }
        localalqn.b = paramString.getString("md5");
        if (localalqn.b != null) {
          localalqn.b = localalqn.b.trim();
        }
        paramString = localalqn;
        if (QLog.isDevelopLevel())
        {
          ausq.a("HotchatSCMng", "parse ConfigData", new Object[] { localalqn });
          return localalqn;
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
 * Qualified Name:     alqn
 * JD-Core Version:    0.7.0.1
 */