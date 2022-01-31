import android.os.Handler;
import com.tencent.mobileqq.activity.photo.MediaPlayHelper.2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;
import java.util.HashMap;

public class aioc
  implements TVK_SDKMgr.InstallListener
{
  public aioc(MediaPlayHelper.2 param2) {}
  
  public void onInstallProgress(float paramFloat) {}
  
  public void onInstalledFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(aiob.a(this.a.this$0), 2, "onInstalledFailed:" + paramInt);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_entrance", "MediaPlayHelper");
    localHashMap.put("param_erroCode", String.valueOf(paramInt));
    localHashMap.put("param_result", "0");
    azri.a(BaseApplication.getContext()).a(null, "actInstallTVK", false, 0L, 0L, localHashMap, "");
  }
  
  public void onInstalledSuccessed()
  {
    if (QLog.isColorLevel()) {
      QLog.d(aiob.a(this.a.this$0), 2, "onInstalledSuccessed");
    }
    if ((this.a.this$0.b != null) && (this.a.this$0.a != null)) {
      this.a.this$0.a.sendEmptyMessage(6);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_entrance", "MediaPlayHelper");
    localHashMap.put("param_erroCode", "0");
    localHashMap.put("param_result", "1");
    azri.a(BaseApplication.getContext()).a(null, "actInstallTVK", true, 0L, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aioc
 * JD-Core Version:    0.7.0.1
 */