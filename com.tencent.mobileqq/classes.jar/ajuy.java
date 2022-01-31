import android.os.Bundle;
import com.tencent.mobileqq.troop.utils.ChangeMachineManager;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ajuy
  implements HttpWebCgiAsyncTask.Callback
{
  public ajuy(ChangeMachineManager paramChangeMachineManager) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.change_machine", 2, "getChangeMachineFlag result:" + paramJSONObject);
    }
    int j = 0;
    int k = -1;
    paramInt = k;
    int i = j;
    if (paramJSONObject != null)
    {
      if (paramJSONObject.has("code")) {
        break label88;
      }
      i = j;
      paramInt = k;
    }
    for (;;)
    {
      if ((paramInt == 0) && (i != 0))
      {
        ChangeMachineManager.a(this.a);
        this.a.b();
      }
      return;
      label88:
      k = paramJSONObject.optInt("code");
      paramInt = k;
      i = j;
      if (k == 0)
      {
        i = paramJSONObject.optInt("flag");
        paramInt = k;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajuy
 * JD-Core Version:    0.7.0.1
 */