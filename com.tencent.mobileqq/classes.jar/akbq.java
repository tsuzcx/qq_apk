import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import org.json.JSONObject;

public class akbq
  implements MediaPlayer.OnPreparedListener
{
  String jdField_a_of_type_JavaLangString;
  JSONObject jdField_a_of_type_OrgJsonJSONObject;
  boolean jdField_a_of_type_Boolean;
  
  public akbq(akbl paramakbl, JSONObject paramJSONObject, String paramString, boolean paramBoolean)
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
      this.jdField_a_of_type_Akbl.callJs(this.jdField_a_of_type_JavaLangString, new String[] { this.jdField_a_of_type_OrgJsonJSONObject.toString() });
      return;
    }
    catch (Exception localException1)
    {
      akbl.a(this.jdField_a_of_type_Akbl, "-->handleJsRequest exception:" + localException1.toString());
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("code", 2);
        localJSONObject.put("errorMessage", "exception");
        this.jdField_a_of_type_Akbl.callJs(this.jdField_a_of_type_JavaLangString, new String[] { localJSONObject.toString() });
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
    if (akbl.a(this.jdField_a_of_type_Akbl).a()) {}
    try
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        akbl.a(this.jdField_a_of_type_Akbl, "-->play failed");
        this.jdField_a_of_type_OrgJsonJSONObject.put("code", 2);
        this.jdField_a_of_type_OrgJsonJSONObject.put("errorMessage", "can't play");
      }
      for (;;)
      {
        this.jdField_a_of_type_Akbl.callJs(this.jdField_a_of_type_JavaLangString, new String[] { this.jdField_a_of_type_OrgJsonJSONObject.toString() });
        return;
        this.jdField_a_of_type_OrgJsonJSONObject.put("code", 0);
      }
      return;
    }
    catch (Exception paramMediaPlayer)
    {
      akbl.a(this.jdField_a_of_type_Akbl, "-->handleJsRequest exception:" + paramMediaPlayer.toString());
      try
      {
        paramMediaPlayer = new JSONObject();
        paramMediaPlayer.put("code", 2);
        paramMediaPlayer.put("errorMessage", "exception");
        this.jdField_a_of_type_Akbl.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramMediaPlayer.toString() });
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
 * Qualified Name:     akbq
 * JD-Core Version:    0.7.0.1
 */