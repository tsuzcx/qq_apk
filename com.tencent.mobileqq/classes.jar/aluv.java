import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.debug.ArkAsyncShareMiniAppTest.1.1;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class aluv
  implements alwn
{
  public boolean needProcess(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ArkApp.ArkAsyncShareMiniAppTest", 2, new Object[] { "AAShare.mArkMessagePreprocessor needProcess=", Boolean.valueOf(true) });
    }
    return true;
  }
  
  public void process(JSONObject paramJSONObject, alwo paramalwo, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ArkApp.ArkAsyncShareMiniAppTest", 2, new Object[] { "AAShare.process msgJson=", paramJSONObject.toString() });
    }
    ThreadManager.getFileThreadHandler().postDelayed(new ArkAsyncShareMiniAppTest.1.1(this, paramJSONObject, paramalwo, paramObject), 20000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aluv
 * JD-Core Version:    0.7.0.1
 */