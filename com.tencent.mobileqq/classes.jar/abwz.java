import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.dating.HotChatFlashPicActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class abwz
  implements Runnable
{
  public abwz(HotChatFlashPicActivity paramHotChatFlashPicActivity) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = this.a.getSharedPreferences(HotChatFlashPicActivity.f(this.a), 4).edit();
    if (HotChatFlashPicActivity.b(this.a))
    {
      localEditor.putInt("HOTCHAT_FLASHPIC_SHOT", HotChatFlashPicActivity.a(this.a));
      if (HotChatFlashPicActivity.a(this.a) != 1) {
        break label115;
      }
      ReportController.b(this.a.app, "CliOper", "", "", "0X800597A", "0X800597A", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      localEditor.commit();
      return;
      localEditor.putInt("commen_flashpic_shot", HotChatFlashPicActivity.a(this.a));
      break;
      label115:
      if (HotChatFlashPicActivity.a(this.a) == 2)
      {
        if (!HotChatFlashPicActivity.b(this.a)) {
          localEditor.putLong("commen_flashpic_shot_deadlineday", HotChatFlashPicActivity.b(this.a) + 518400000L);
        }
        ReportController.b(this.a.app, "CliOper", "", "", "0X800597B", "0X800597B", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abwz
 * JD-Core Version:    0.7.0.1
 */