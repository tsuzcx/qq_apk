import android.media.MediaPlayer;
import android.media.MediaPlayer.OnSeekCompleteListener;
import org.json.JSONObject;

class aksa
  implements MediaPlayer.OnSeekCompleteListener
{
  aksa(akry paramakry, JSONObject paramJSONObject, aksy paramaksy) {}
  
  public void onSeekComplete(MediaPlayer paramMediaPlayer)
  {
    if (this.jdField_a_of_type_OrgJsonJSONObject != null) {
      akry.a(this.jdField_a_of_type_Akry, this.jdField_a_of_type_Aksy, this.jdField_a_of_type_OrgJsonJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aksa
 * JD-Core Version:    0.7.0.1
 */