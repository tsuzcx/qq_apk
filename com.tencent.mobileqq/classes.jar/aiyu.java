import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.qwallet.fragment.ThemeHbFragment;

public class aiyu
  extends Handler
{
  public aiyu(ThemeHbFragment paramThemeHbFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
    } while (TextUtils.isEmpty(ThemeHbFragment.a(this.a)));
    ThemeHbFragment.a(this.a).setText(ThemeHbFragment.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiyu
 * JD-Core Version:    0.7.0.1
 */