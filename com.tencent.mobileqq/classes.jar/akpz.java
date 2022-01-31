import com.tencent.open.business.base.OpenConfig;
import org.json.JSONException;
import org.json.JSONObject;

public class akpz
  implements Runnable
{
  public akpz(OpenConfig paramOpenConfig) {}
  
  public void run()
  {
    String str = this.a.a("com.tencent.open.config.json");
    try
    {
      this.a.a = new JSONObject(str);
      OpenConfig.a(this.a, true);
      return;
    }
    catch (JSONException localJSONException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     akpz
 * JD-Core Version:    0.7.0.1
 */