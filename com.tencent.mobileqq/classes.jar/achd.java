import android.widget.TextView;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.activity.activateFriend.BirthdayActivatePageArkView;
import com.tencent.qphone.base.util.QLog;

public class achd
  implements ArkViewImplement.LoadCallback
{
  public achd(BirthdayActivatePageArkView paramBirthdayActivatePageArkView) {}
  
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
    BirthdayActivatePageArkView.a(this.a).setText(ajjy.a(2131635357));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     achd
 * JD-Core Version:    0.7.0.1
 */