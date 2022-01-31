import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.soso.SosoInterface;
import org.json.JSONObject;

public class aacm
  extends aabm
{
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull aabi paramaabi)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 7: 
      SosoInterface.a(new aacp(paramaabi, paramJSONObject.optInt("allowCacheTime", 10) * 1000L));
    }
    for (;;)
    {
      return true;
      SosoInterface.a(new aaco(paramaabi, paramJSONObject.optInt("allowCacheTime", 10) * 1000L));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aacm
 * JD-Core Version:    0.7.0.1
 */