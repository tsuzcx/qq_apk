import com.tencent.tgpa.vendorpd.GameCallback;
import org.json.JSONObject;

public final class acef
  implements GameCallback
{
  public acef(JSONObject paramJSONObject) {}
  
  public int getPreDownloadVersionInfo(String paramString)
  {
    bize.c("GameCenterCheck", "checkGameRes.getGameVersionUpdateInfo res =" + paramString);
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.optInt("ret") == 0)
      {
        paramString = paramString.optJSONObject("data");
        bmxq.a().a(paramString, this.a);
      }
      return 0;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        bize.c("GameCenterCheck", "checkGameRes.getPreDownloadVersionInfo e=" + paramString.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acef
 * JD-Core Version:    0.7.0.1
 */