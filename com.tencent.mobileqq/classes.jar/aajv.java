import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ark.open.ArkAppMgr.AppPathInfo;
import com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback;
import com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.6.1;

public class aajv
  implements ArkAppMgr.IGetAppPathByNameCallback
{
  aajv(aaju paramaaju) {}
  
  public void onGetAppPathByName(int paramInt, String paramString, ArkAppMgr.AppPathInfo paramAppPathInfo, Object paramObject)
  {
    AdThreadManager.INSTANCE.post(new GdtArkPreDownloadTask.6.1(this, paramAppPathInfo, paramInt, paramString), 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aajv
 * JD-Core Version:    0.7.0.1
 */