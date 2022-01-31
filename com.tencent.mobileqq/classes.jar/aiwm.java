import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.AudioInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem;
import cooperation.troop_homework.TroopHomeworkHelper;

public class aiwm
  implements Runnable
{
  public aiwm(AudioItem paramAudioItem, AudioInfo paramAudioInfo) {}
  
  public void run()
  {
    String str = TroopHomeworkHelper.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelAudioInfo.b);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelAudioInfo.b(str);
    if (!TextUtils.isEmpty(str)) {
      ((Activity)AudioItem.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiAudioItem)).runOnUiThread(new aiwn(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aiwm
 * JD-Core Version:    0.7.0.1
 */