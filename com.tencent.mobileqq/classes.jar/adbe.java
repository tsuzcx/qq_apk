import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.soso.SosoInterface;
import org.json.JSONObject;

public class adbe
  extends adae
{
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull adaa paramadaa)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 7: 
      SosoInterface.startLocation(new adbh(paramadaa, paramJSONObject.optInt("allowCacheTime", 10) * 1000L));
    }
    for (;;)
    {
      return true;
      SosoInterface.startLocation(new adbg(paramadaa, paramJSONObject.optInt("allowCacheTime", 10) * 1000L));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adbe
 * JD-Core Version:    0.7.0.1
 */