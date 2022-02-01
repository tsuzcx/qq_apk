import com.tencent.biz.videostory.config.VSConfigManager;
import org.json.JSONException;
import org.json.JSONObject;

public class aamj
{
  private String a = "1";
  private String b = "1";
  private String c = VSConfigManager.SUBSCRIBE_ACCOUNT_TITLE_DEFVALUE;
  private String d = "1";
  private String e = "1";
  
  public static aamj a(String paramString)
  {
    aamj localaamj = new aamj();
    if (paramString != null) {}
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString != null)
      {
        localaamj.a = paramString.optString("subscribe_entrance_enable", "1");
        localaamj.b = paramString.optString("is_open_sharing", "1");
        localaamj.c = paramString.optString("subscribe_account_title", VSConfigManager.SUBSCRIBE_ACCOUNT_TITLE_DEFVALUE);
        localaamj.d = paramString.optString("newfollowlist", "1");
        localaamj.e = paramString.optString("subscribe_publish_entrance_enable", "1");
      }
      return localaamj;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public String e()
  {
    return this.e;
  }
  
  public String toString()
  {
    return "k =subscribe_entrance_enable , value = " + this.a + ",k =is_open_sharing , value = " + this.b + ",k =subscribe_account_title , value = " + this.c + ",k =subscribeAccountNewFollowListSwitch , value = " + this.d + ",k =subscribeAccountPublishEntranceSwitch , value = " + this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aamj
 * JD-Core Version:    0.7.0.1
 */