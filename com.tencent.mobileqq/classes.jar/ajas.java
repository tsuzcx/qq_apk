import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import org.json.JSONObject;

class ajas
  implements MediaPlayer.OnPreparedListener
{
  ajas(ajao paramajao, JSONObject paramJSONObject, ajbo paramajbo) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    this.jdField_a_of_type_Ajao.a(3);
    if (ajao.a(this.jdField_a_of_type_Ajao)) {
      this.jdField_a_of_type_Ajao.b(this.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_Ajbo);
    }
    if (this.jdField_a_of_type_OrgJsonJSONObject != null) {
      ajao.a(this.jdField_a_of_type_Ajao, this.jdField_a_of_type_Ajbo, this.jdField_a_of_type_OrgJsonJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajas
 * JD-Core Version:    0.7.0.1
 */