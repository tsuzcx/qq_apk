import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class abww
{
  public static final JSONObject a = new JSONObject();
  
  public static JSONObject a(Bundle paramBundle)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramBundle == null) {
      return a;
    }
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject2 = paramBundle.get(str);
      Object localObject1 = localObject2;
      if ((localObject2 instanceof Bundle)) {
        localObject1 = a((Bundle)localObject2);
      }
      try
      {
        localJSONObject.put(str, localObject1);
      }
      catch (JSONException localJSONException) {}
      if (QLog.isColorLevel()) {
        QLog.e("APIParam", 2, localJSONException.getMessage(), localJSONException);
      }
    }
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abww
 * JD-Core Version:    0.7.0.1
 */