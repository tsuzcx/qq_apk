import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.profile.like.PraiseManager.OnPraiseSetCallback;
import java.lang.ref.WeakReference;

class abvd
  implements PraiseManager.OnPraiseSetCallback
{
  abvd(abue paramabue) {}
  
  public void a(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    MessengerService localMessengerService = (MessengerService)this.a.a.get();
    if (localMessengerService != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("id", paramInt2);
      localBundle.putInt("code", paramInt1);
      localBundle.putString("url", paramString);
      paramBundle.putBundle("response", localBundle);
      localMessengerService.a(paramBundle);
      if ((paramInt1 == 0) && (MessengerService.e(localMessengerService) != null) && ((MessengerService.f(localMessengerService) instanceof QQAppInterface))) {
        ((PraiseManager)((QQAppInterface)MessengerService.g(localMessengerService)).getManager(208)).a(paramInt2, true, "from_praise_mall");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abvd
 * JD-Core Version:    0.7.0.1
 */