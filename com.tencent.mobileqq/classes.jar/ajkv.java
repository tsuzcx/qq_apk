import com.tencent.qphone.base.util.QLog;
import oicq.wlogin_sdk.tools.MD5;
import org.json.JSONObject;

public class ajkv
{
  String a;
  String b;
  String c;
  
  public static ajkv a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      try
      {
        ajkv localajkv = new ajkv();
        paramString = new JSONObject(paramString);
        localajkv.a = paramString.getString("url");
        if (localajkv.a != null)
        {
          localajkv.a = localajkv.a.trim();
          localajkv.c = MD5.toMD5(localajkv.a);
        }
        localajkv.b = paramString.getString("md5");
        if (localajkv.b != null) {
          localajkv.b = localajkv.b.trim();
        }
        paramString = localajkv;
        if (QLog.isDevelopLevel())
        {
          asfl.a("HotchatSCMng", "parse ConfigData", new Object[] { localajkv });
          return localajkv;
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
 * Qualified Name:     ajkv
 * JD-Core Version:    0.7.0.1
 */