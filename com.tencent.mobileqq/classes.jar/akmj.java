import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.widget.QQToast;

public class akmj
  extends anuw
{
  public akmj(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  protected void onUpdateAvatar(boolean paramBoolean, String paramString, int paramInt)
  {
    if (!paramBoolean)
    {
      int i = 2131717917;
      if (paramInt == 1503) {
        i = 2131698292;
      }
      QQToast.a(BaseApplicationImpl.getApplication(), 1, i, 0).b(this.a.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akmj
 * JD-Core Version:    0.7.0.1
 */