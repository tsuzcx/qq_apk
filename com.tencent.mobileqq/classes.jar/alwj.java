import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import org.json.JSONObject;

class alwj
  implements MediaPlayer.OnPreparedListener
{
  alwj(alwf paramalwf, JSONObject paramJSONObject, alxf paramalxf) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    this.jdField_a_of_type_Alwf.a(3);
    if (alwf.a(this.jdField_a_of_type_Alwf)) {
      this.jdField_a_of_type_Alwf.b(this.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_Alxf);
    }
    if (this.jdField_a_of_type_OrgJsonJSONObject != null) {
      alwf.a(this.jdField_a_of_type_Alwf, this.jdField_a_of_type_Alxf, this.jdField_a_of_type_OrgJsonJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alwj
 * JD-Core Version:    0.7.0.1
 */