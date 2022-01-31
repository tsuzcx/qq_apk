import com.tencent.qphone.base.util.QLog;
import oicq.wlogin_sdk.tools.MD5;
import org.json.JSONObject;

public class ajzb
{
  String a;
  String b;
  String c;
  
  public static ajzb a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      try
      {
        ajzb localajzb = new ajzb();
        paramString = new JSONObject(paramString);
        localajzb.a = paramString.getString("url");
        if (localajzb.a != null)
        {
          localajzb.a = localajzb.a.trim();
          localajzb.c = MD5.toMD5(localajzb.a);
        }
        localajzb.b = paramString.getString("md5");
        if (localajzb.b != null) {
          localajzb.b = localajzb.b.trim();
        }
        paramString = localajzb;
        if (QLog.isDevelopLevel())
        {
          atbp.a("HotchatSCMng", "parse ConfigData", new Object[] { localajzb });
          return localajzb;
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
 * Qualified Name:     ajzb
 * JD-Core Version:    0.7.0.1
 */