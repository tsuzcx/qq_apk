import android.app.Activity;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.AudioInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem;
import cooperation.troop_homework.TroopHomeworkHelper.UploadCallback;

public class ajkv
  implements TroopHomeworkHelper.UploadCallback
{
  AudioInfo jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelAudioInfo;
  
  public ajkv(AudioItem paramAudioItem, AudioInfo paramAudioInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelAudioInfo = paramAudioInfo;
  }
  
  public void a(int paramInt) {}
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelAudioInfo.g = 3;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelAudioInfo.c(paramString);
    ((Activity)AudioItem.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiAudioItem)).runOnUiThread(new ajkw(this));
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelAudioInfo.g = 2;
    ((Activity)AudioItem.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiAudioItem)).runOnUiThread(new ajkx(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajkv
 * JD-Core Version:    0.7.0.1
 */