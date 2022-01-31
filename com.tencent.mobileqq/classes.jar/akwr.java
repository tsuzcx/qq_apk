import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import org.json.JSONObject;

class akwr
  implements MediaPlayer.OnPreparedListener
{
  akwr(akwn paramakwn, JSONObject paramJSONObject, akxn paramakxn) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    this.jdField_a_of_type_Akwn.a(3);
    if (akwn.a(this.jdField_a_of_type_Akwn)) {
      this.jdField_a_of_type_Akwn.b(this.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_Akxn);
    }
    if (this.jdField_a_of_type_OrgJsonJSONObject != null) {
      akwn.a(this.jdField_a_of_type_Akwn, this.jdField_a_of_type_Akxn, this.jdField_a_of_type_OrgJsonJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akwr
 * JD-Core Version:    0.7.0.1
 */