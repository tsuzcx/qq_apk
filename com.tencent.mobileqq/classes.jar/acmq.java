import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmotionPanelViewPagerAdapter;
import com.tencent.qphone.base.util.QLog;

public class acmq
  implements Runnable
{
  public acmq(EmoticonMainPanel paramEmoticonMainPanel) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "func updateLastEmoticonPanel begins.");
    }
    if (this.a.a != null) {
      this.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acmq
 * JD-Core Version:    0.7.0.1
 */