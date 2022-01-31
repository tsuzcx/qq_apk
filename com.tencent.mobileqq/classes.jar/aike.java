import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class aike
  extends aylo
{
  aike(aikb paramaikb, String paramString) {}
  
  public void onComplete(String paramString, int paramInt)
  {
    QLog.e("QVipSpecialSoundWebViewPlugin", 1, "onComplete: " + paramString + "," + paramInt);
    try
    {
      paramString = new JSONObject();
      paramString.put("code", 2);
      paramString.put("errorCode", paramInt);
      this.jdField_a_of_type_Aikb.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramString.toString() });
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("QVipSpecialSoundWebViewPlugin", 1, "onComplete: ", paramString);
    }
  }
  
  public void onProgress(String paramString, long paramLong1, long paramLong2)
  {
    int i = (int)(100.0F * (float)paramLong1 / (float)paramLong2);
    try
    {
      paramString = new JSONObject();
      paramString.put("code", 1);
      paramString.put("progress", i);
      this.jdField_a_of_type_Aikb.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramString.toString() });
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("QVipSpecialSoundWebViewPlugin", 1, "onComplete: ", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aike
 * JD-Core Version:    0.7.0.1
 */