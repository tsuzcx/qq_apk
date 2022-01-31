import android.os.Bundle;
import com.tencent.open.appcommon.js.BaseJsCallBack;
import cooperation.qappcenter.remote.RemoteServiceProxy;
import cooperation.qappcenter.remote.SendMsg;
import org.json.JSONException;
import org.json.JSONObject;

public class aldy
  implements Runnable
{
  public aldy(BaseJsCallBack paramBaseJsCallBack, String paramString) {}
  
  public void run()
  {
    try
    {
      if (BaseJsCallBack.access$000(this.jdField_a_of_type_ComTencentOpenAppcommonJsBaseJsCallBack) != null)
      {
        JSONObject localJSONObject = new JSONObject(this.jdField_a_of_type_JavaLangString);
        SendMsg localSendMsg = new SendMsg("setActionButton");
        localSendMsg.a.putString("iconType", localJSONObject.optString("iconType"));
        localSendMsg.a.putString("visible", localJSONObject.optString("visible"));
        localSendMsg.a.putString("callBackKey", localJSONObject.optString("callBackKey"));
        localSendMsg.a.putString("rightText", localJSONObject.optString("text"));
        BaseJsCallBack.access$000(this.jdField_a_of_type_ComTencentOpenAppcommonJsBaseJsCallBack).b(localSendMsg);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aldy
 * JD-Core Version:    0.7.0.1
 */