import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class aiqm
  implements aizm
{
  aiqm(aiqj paramaiqj, String paramString) {}
  
  public void a(int paramInt)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameSubRscHandler", 2, new Object[] { "[onVerifyResult], retCode:", Integer.valueOf(paramInt) });
      }
      ApolloCmdChannel localApolloCmdChannel = aing.a();
      if (localApolloCmdChannel != null)
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("packName", this.jdField_a_of_type_JavaLangString);
        localJSONObject.put("result", paramInt);
        localApolloCmdChannel.callbackFromRequest(aiqj.a(this.jdField_a_of_type_Aiqj), 0, "cs.file_correctness_check.local", localJSONObject.toString());
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
 * Qualified Name:     aiqm
 * JD-Core Version:    0.7.0.1
 */