import android.text.TextUtils;
import android.widget.Button;
import com.tencent.mobileqq.freshnews.QQInputView;
import com.tencent.mobileqq.freshnews.QQInputView.IQQInputCallback;
import com.tencent.widget.XEditTextEx;

public class adoj
  implements Runnable
{
  public adoj(QQInputView paramQQInputView) {}
  
  public void run()
  {
    String str1 = null;
    String str2;
    if (QQInputView.a(this.a) != null)
    {
      str2 = QQInputView.a(this.a).a();
      str1 = QQInputView.a(this.a).b();
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str2))
      {
        QQInputView.a(this.a).setText(str2);
        QQInputView.a(this.a).setSelection(str2.length());
        QQInputView.a(this.a).setEnabled(true);
        QQInputView.a(this.a).setSelected(true);
      }
      while (TextUtils.isEmpty(str1)) {
        return;
      }
      QQInputView.a(this.a).setHint(str1);
      QQInputView.a(this.a).setEnabled(false);
      QQInputView.a(this.a).setSelected(false);
      return;
      str2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adoj
 * JD-Core Version:    0.7.0.1
 */