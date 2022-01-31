import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import org.json.JSONException;
import org.json.JSONObject;

public class aadl
  extends aabq
{
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull aabm paramaabm)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    paramString = BaseApplicationImpl.getApplication().getRuntime();
    paramJSONObject = (TicketManager)paramString.getManager(2);
    paramString = paramString.getAccount();
    paramJSONObject = paramJSONObject.getSkey(paramString);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uin", paramString);
      localJSONObject.put("skey", paramJSONObject);
      aaet.a(paramaabm, localJSONObject);
      return true;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramJSONObject = paramString.getMessage();
        if (QLog.isColorLevel()) {
          QLog.w("DoraemonOpenAPI.innerApi", 2, paramJSONObject, paramString);
        }
        paramString = paramJSONObject;
        if (paramJSONObject == null) {
          paramString = "";
        }
        aaet.a(paramaabm, -1, paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aadl
 * JD-Core Version:    0.7.0.1
 */