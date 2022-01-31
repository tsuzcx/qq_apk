import android.widget.ImageView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.mobileqq.freshnews.QQInputView;
import com.tencent.util.InputMethodUtil;

public class adws
  implements Runnable
{
  public adws(QQInputView paramQQInputView) {}
  
  public void run()
  {
    QQInputView.a(this.a).setVisibility(8);
    QQInputView.a(this.a).setImageResource(2130844609);
    if (AppSetting.b) {
      QQInputView.a(this.a).setContentDescription("键盘");
    }
    InputMethodUtil.a(QQInputView.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adws
 * JD-Core Version:    0.7.0.1
 */