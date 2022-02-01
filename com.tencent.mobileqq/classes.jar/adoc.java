import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.soso.SosoInterface;
import org.json.JSONObject;

public class adoc
  extends adnc
{
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull admy paramadmy)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 7: 
      SosoInterface.a(new adof(paramadmy, paramJSONObject.optInt("allowCacheTime", 10) * 1000L));
    }
    for (;;)
    {
      return true;
      SosoInterface.a(new adoe(paramadmy, paramJSONObject.optInt("allowCacheTime", 10) * 1000L));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adoc
 * JD-Core Version:    0.7.0.1
 */