import android.media.MediaPlayer;
import android.media.MediaPlayer.OnSeekCompleteListener;
import org.json.JSONObject;

class ajao
  implements MediaPlayer.OnSeekCompleteListener
{
  ajao(ajam paramajam, JSONObject paramJSONObject, ajbm paramajbm) {}
  
  public void onSeekComplete(MediaPlayer paramMediaPlayer)
  {
    if (this.jdField_a_of_type_OrgJsonJSONObject != null) {
      ajam.a(this.jdField_a_of_type_Ajam, this.jdField_a_of_type_Ajbm, this.jdField_a_of_type_OrgJsonJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajao
 * JD-Core Version:    0.7.0.1
 */