import com.tencent.biz.videostory.config.VSConfigManager;
import org.json.JSONObject;

public class aamb
{
  private String a = VSConfigManager.MINE_VIDEOSTORY_ENTRANCE_DEFVALUE;
  private String b = "1";
  private String c = VSConfigManager.MINE_VIDEOSTORY_CHOUTI_ENTRANCE_DEFVALUE;
  
  public static aamb a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      aamb localaamb = new aamb();
      paramString = new JSONObject(paramString);
      localaamb.a = paramString.optString("mine_videostory_entrance", VSConfigManager.MINE_VIDEOSTORY_ENTRANCE_DEFVALUE);
      localaamb.b = paramString.optString("enable_click_take_picture", "1");
      localaamb.c = paramString.optString("mine_videostory_drawer_entrance", VSConfigManager.MINE_VIDEOSTORY_CHOUTI_ENTRANCE_DEFVALUE);
      return localaamb;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
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
  
  public String toString()
  {
    return "k = mine_videostory_entrance, value = " + this.a + "\n k = enableClickTakePicture, value = " + this.b + "\n k = mine_videostory_chouti_entrance, value = " + this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aamb
 * JD-Core Version:    0.7.0.1
 */