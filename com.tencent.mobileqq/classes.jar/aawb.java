import org.json.JSONObject;

public class aawb
{
  private String a = aavz.b;
  private String b = "1";
  private String c = aavz.a;
  
  public static aawb a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      aawb localaawb = new aawb();
      paramString = new JSONObject(paramString);
      localaawb.a = paramString.optString("mine_videostory_entrance", aavz.b);
      localaawb.b = paramString.optString("enable_click_take_picture", "1");
      localaawb.c = paramString.optString("mine_videostory_drawer_entrance", aavz.a);
      return localaawb;
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
 * Qualified Name:     aawb
 * JD-Core Version:    0.7.0.1
 */