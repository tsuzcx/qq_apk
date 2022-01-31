import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity.13.1;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class aihe
  implements TVK_SDKMgr.InstallListener
{
  public aihe(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void onInstallProgress(float paramFloat) {}
  
  public void onInstalledFailed(int paramInt)
  {
    ShortVideoPlayActivity.a(this.a, false);
    ShortVideoPlayActivity.d(this.a, System.currentTimeMillis() - ShortVideoPlayActivity.c(this.a));
    this.a.a(this.a.a.getResources().getString(2131697970));
    ShortVideoPlayActivity.c(this.a, 3000);
    ShortVideoPlayActivity.d(this.a, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "onInstalledFailed:" + paramInt);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_entrance", "ShortVideoPlayActivity");
    localHashMap.put("param_erroCode", String.valueOf(paramInt));
    localHashMap.put("param_result", "0");
    axrl.a(BaseApplication.getContext()).a(null, "actInstallTVK", false, 0L, 0L, localHashMap, "");
  }
  
  public void onInstalledSuccessed()
  {
    ShortVideoPlayActivity.a(this.a, true);
    ShortVideoPlayActivity.d(this.a, System.currentTimeMillis() - ShortVideoPlayActivity.c(this.a));
    if (this.a.b.get() != null) {
      ((MqqHandler)this.a.b.get()).post(new ShortVideoPlayActivity.13.1(this));
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_entrance", "ShortVideoPlayActivity");
    localHashMap.put("param_erroCode", "0");
    localHashMap.put("param_result", "1");
    axrl.a(BaseApplication.getContext()).a(null, "actInstallTVK", true, 0L, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aihe
 * JD-Core Version:    0.7.0.1
 */