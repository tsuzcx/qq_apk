import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.widget.QQToast;

public class akfw
  extends CardObserver
{
  public akfw(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void onUpdateAvatar(boolean paramBoolean, String paramString, int paramInt)
  {
    if (!paramBoolean)
    {
      int i = 2131718542;
      if (paramInt == 1503) {
        i = 2131698757;
      }
      QQToast.a(BaseApplicationImpl.getApplication(), 1, i, 0).b(this.a.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akfw
 * JD-Core Version:    0.7.0.1
 */