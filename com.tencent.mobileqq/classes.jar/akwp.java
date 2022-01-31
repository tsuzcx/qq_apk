import android.media.MediaPlayer;
import android.media.MediaPlayer.OnSeekCompleteListener;
import org.json.JSONObject;

class akwp
  implements MediaPlayer.OnSeekCompleteListener
{
  akwp(akwn paramakwn, JSONObject paramJSONObject, akxn paramakxn) {}
  
  public void onSeekComplete(MediaPlayer paramMediaPlayer)
  {
    if (this.jdField_a_of_type_OrgJsonJSONObject != null) {
      akwn.a(this.jdField_a_of_type_Akwn, this.jdField_a_of_type_Akxn, this.jdField_a_of_type_OrgJsonJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akwp
 * JD-Core Version:    0.7.0.1
 */