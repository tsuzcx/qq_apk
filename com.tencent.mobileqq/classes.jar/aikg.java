import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import org.json.JSONException;
import org.json.JSONObject;

public class aikg
  extends aiki
{
  int a = 100;
  
  public aikg(aikj paramaikj)
  {
    super(paramaikj);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has("moneylimit"))) {}
    try
    {
      this.a = paramJSONObject.getInt("moneylimit");
      BaseApplicationImpl.getApplication().getSharedPreferences("MOBILEQQ HONGBAO_SCENESRECOMMEND_INFO", 4).edit().putInt("HONGBAO_SCENES_MONEY_LIMIT", this.a).apply();
      return;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        paramJSONObject.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aikg
 * JD-Core Version:    0.7.0.1
 */