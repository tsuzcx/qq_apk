import com.tencent.qphone.base.util.QLog;
import oicq.wlogin_sdk.tools.MD5;
import org.json.JSONObject;

public class ajyz
{
  String a;
  String b;
  String c;
  
  public static ajyz a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      try
      {
        ajyz localajyz = new ajyz();
        paramString = new JSONObject(paramString);
        localajyz.a = paramString.getString("url");
        if (localajyz.a != null)
        {
          localajyz.a = localajyz.a.trim();
          localajyz.c = MD5.toMD5(localajyz.a);
        }
        localajyz.b = paramString.getString("md5");
        if (localajyz.b != null) {
          localajyz.b = localajyz.b.trim();
        }
        paramString = localajyz;
        if (QLog.isDevelopLevel())
        {
          atbr.a("HotchatSCMng", "parse ConfigData", new Object[] { localajyz });
          return localajyz;
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
 * Qualified Name:     ajyz
 * JD-Core Version:    0.7.0.1
 */