import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import org.json.JSONObject;

public class akgf
  implements MediaPlayer.OnPreparedListener
{
  String jdField_a_of_type_JavaLangString;
  JSONObject jdField_a_of_type_OrgJsonJSONObject;
  boolean jdField_a_of_type_Boolean;
  
  public akgf(akga paramakga, JSONObject paramJSONObject, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put("code", 2);
      this.jdField_a_of_type_OrgJsonJSONObject.put("errorMessage", "can't play");
      this.jdField_a_of_type_Akga.callJs(this.jdField_a_of_type_JavaLangString, new String[] { this.jdField_a_of_type_OrgJsonJSONObject.toString() });
      return;
    }
    catch (Exception localException1)
    {
      akga.a(this.jdField_a_of_type_Akga, "-->handleJsRequest exception:" + localException1.toString());
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("code", 2);
        localJSONObject.put("errorMessage", "exception");
        this.jdField_a_of_type_Akga.callJs(this.jdField_a_of_type_JavaLangString, new String[] { localJSONObject.toString() });
        return;
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
    }
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (akga.a(this.jdField_a_of_type_Akga).a()) {}
    try
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        akga.a(this.jdField_a_of_type_Akga, "-->play failed");
        this.jdField_a_of_type_OrgJsonJSONObject.put("code", 2);
        this.jdField_a_of_type_OrgJsonJSONObject.put("errorMessage", "can't play");
      }
      for (;;)
      {
        this.jdField_a_of_type_Akga.callJs(this.jdField_a_of_type_JavaLangString, new String[] { this.jdField_a_of_type_OrgJsonJSONObject.toString() });
        return;
        this.jdField_a_of_type_OrgJsonJSONObject.put("code", 0);
      }
      return;
    }
    catch (Exception paramMediaPlayer)
    {
      akga.a(this.jdField_a_of_type_Akga, "-->handleJsRequest exception:" + paramMediaPlayer.toString());
      try
      {
        paramMediaPlayer = new JSONObject();
        paramMediaPlayer.put("code", 2);
        paramMediaPlayer.put("errorMessage", "exception");
        this.jdField_a_of_type_Akga.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramMediaPlayer.toString() });
        return;
      }
      catch (Exception paramMediaPlayer)
      {
        paramMediaPlayer.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akgf
 * JD-Core Version:    0.7.0.1
 */