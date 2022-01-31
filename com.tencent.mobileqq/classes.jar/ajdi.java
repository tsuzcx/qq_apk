import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class ajdi
  implements ajnm
{
  ajdi(ajdf paramajdf, String paramString) {}
  
  public void a(int paramInt)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameSubRscHandler", 2, new Object[] { "[onVerifyResult], retCode:", Integer.valueOf(paramInt) });
      }
      ApolloCmdChannel localApolloCmdChannel = ajac.a();
      if (localApolloCmdChannel != null)
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("packName", this.jdField_a_of_type_JavaLangString);
        localJSONObject.put("result", paramInt);
        localApolloCmdChannel.callbackFromRequest(ajdf.a(this.jdField_a_of_type_Ajdf), 0, "cs.file_correctness_check.local", localJSONObject.toString());
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmgame_process.CmGameSubRscHandler", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajdi
 * JD-Core Version:    0.7.0.1
 */