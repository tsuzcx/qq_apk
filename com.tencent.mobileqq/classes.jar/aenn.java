import android.widget.TextView;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.activity.activateFriend.BirthdayActivatePageArkView;
import com.tencent.qphone.base.util.QLog;

public class aenn
  implements ArkViewImplement.LoadCallback
{
  public aenn(BirthdayActivatePageArkView paramBirthdayActivatePageArkView) {}
  
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    onLoadState(paramInt1);
  }
  
  public void onLoadState(int paramInt)
  {
    if (paramInt == 1) {
      if (QLog.isColorLevel()) {
        QLog.i("BirthdayActivatePageArkView", 1, "@arkgif  onLoadFinish  SUCCESS");
      }
    }
    while (paramInt != -1) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("BirthdayActivatePageArkView", 1, "@arkgif  onLoadFinish  failed");
    }
    this.a.a(false);
    BirthdayActivatePageArkView.a(this.a).setText(alud.a(2131701533));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aenn
 * JD-Core Version:    0.7.0.1
 */