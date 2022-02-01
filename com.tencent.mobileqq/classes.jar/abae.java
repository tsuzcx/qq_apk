import org.json.JSONObject;

public class abae
{
  private String a = abac.b;
  private String b = "1";
  private String c = abac.a;
  
  public static abae a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      abae localabae = new abae();
      paramString = new JSONObject(paramString);
      localabae.a = paramString.optString("mine_videostory_entrance", abac.b);
      localabae.b = paramString.optString("enable_click_take_picture", "1");
      localabae.c = paramString.optString("mine_videostory_drawer_entrance", abac.a);
      return localabae;
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
 * Qualified Name:     abae
 * JD-Core Version:    0.7.0.1
 */