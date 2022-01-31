import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

public class acfb
  implements CompoundButton.OnCheckedChangeListener
{
  public acfb(AssistantSettingActivity paramAssistantSettingActivity, SharedPreferences paramSharedPreferences, String paramString) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("sticker_switch_" + this.jdField_a_of_type_JavaLangString, paramBoolean).commit();
    if ((paramBoolean) && (EmojiStickerManager.a())) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      EmojiStickerManager.e = paramBoolean;
      if (EmojiStickerManager.e) {
        VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqActivityAssistantSettingActivity.app.c(), "Stick", "ClickSwitchOn", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acfb
 * JD-Core Version:    0.7.0.1
 */