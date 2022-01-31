import android.widget.ImageView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.mobileqq.freshnews.QQInputView;

public class adem
  implements Runnable
{
  public adem(QQInputView paramQQInputView) {}
  
  public void run()
  {
    QQInputView.a(this.a).setVisibility(0);
    QQInputView.a(this.a).setImageResource(2130844422);
    if (AppSetting.b) {
      QQInputView.a(this.a).setContentDescription("表情");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adem
 * JD-Core Version:    0.7.0.1
 */