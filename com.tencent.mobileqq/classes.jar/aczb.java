import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class aczb
  extends alox
{
  public aczb(GesturePWDUnlockActivity paramGesturePWDUnlockActivity) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString)) || (!paramString.equals(this.a.app.getCurrentAccountUin()))) {}
    while (this.a.a == null) {
      return;
    }
    paramString = this.a.app.a(this.a.app.getCurrentAccountUin(), (byte)3, false);
    this.a.a.setImageBitmap(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aczb
 * JD-Core Version:    0.7.0.1
 */