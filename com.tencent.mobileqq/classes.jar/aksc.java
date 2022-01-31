import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import org.json.JSONObject;

class aksc
  implements MediaPlayer.OnPreparedListener
{
  aksc(akry paramakry, JSONObject paramJSONObject, aksy paramaksy) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    this.jdField_a_of_type_Akry.a(3);
    if (akry.a(this.jdField_a_of_type_Akry)) {
      this.jdField_a_of_type_Akry.b(this.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_Aksy);
    }
    if (this.jdField_a_of_type_OrgJsonJSONObject != null) {
      akry.a(this.jdField_a_of_type_Akry, this.jdField_a_of_type_Aksy, this.jdField_a_of_type_OrgJsonJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aksc
 * JD-Core Version:    0.7.0.1
 */