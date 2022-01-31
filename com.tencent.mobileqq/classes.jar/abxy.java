import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.soso.SosoInterface;
import org.json.JSONObject;

public class abxy
  extends abwy
{
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull abwu paramabwu)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 7: 
      SosoInterface.a(new abyb(paramabwu, paramJSONObject.optInt("allowCacheTime", 10) * 1000L));
    }
    for (;;)
    {
      return true;
      SosoInterface.a(new abya(paramabwu, paramJSONObject.optInt("allowCacheTime", 10) * 1000L));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abxy
 * JD-Core Version:    0.7.0.1
 */