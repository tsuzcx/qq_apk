import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.ad.tangram.canvas.download.AdDownloaderAdapter;
import com.tencent.ad.tangram.canvas.download.IAdDownloader;
import com.tencent.ad.tangram.canvas.download.IAdDownloader.Callback;
import com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.AdAppBtnData;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;

public class abze
  implements AdDownloaderAdapter
{
  public void doDownloadAction(Activity paramActivity, Bundle paramBundle, String paramString, int paramInt)
  {
    bjju.a().a(paramActivity, paramBundle, paramString, null, paramInt);
  }
  
  public int getCurrentPkgDownloadProgress(Context paramContext, String paramString1, String paramString2)
  {
    return acik.c(paramContext, paramString1, paramString2);
  }
  
  public Object getDownloadInfoByUrl(String paramString)
  {
    paramString = bjjq.a().b(paramString);
    if (paramString != null)
    {
      paramString.m = "biz_src_ads";
      return paramString;
    }
    return null;
  }
  
  public IAdDownloader getDownloader()
  {
    return this;
  }
  
  public int getProgress(Object paramObject)
  {
    if (!(paramObject instanceof DownloadInfo)) {
      return 0;
    }
    paramObject = (DownloadInfo)DownloadInfo.class.cast(paramObject);
    if (paramObject != null) {}
    for (int i = paramObject.f;; i = 0) {
      return i;
    }
  }
  
  public void installDownload(Object paramObject)
  {
    if ((paramObject instanceof DownloadInfo)) {
      bjjq.a().a((DownloadInfo)paramObject);
    }
    while (!(paramObject instanceof Bundle)) {
      return;
    }
    bjju.a((Bundle)paramObject);
  }
  
  public boolean isCurrentPkgTask(Pair<String, String> paramPair, Object paramObject)
  {
    if ((paramPair == null) || (TextUtils.isEmpty((CharSequence)paramPair.first)) || (TextUtils.isEmpty((CharSequence)paramPair.second)) || (!(paramObject instanceof AdAppBtnData))) {}
    do
    {
      do
      {
        return false;
        paramPair = bjjq.a().b((String)paramPair.first);
      } while (paramPair == null);
      paramObject = (AdAppBtnData)paramObject;
    } while ((TextUtils.isEmpty(paramPair.e)) || (TextUtils.isEmpty(paramPair.c)) || (TextUtils.isEmpty(paramObject.packageName)) || (TextUtils.isEmpty(paramObject.mGdtAd_appId)));
    return (paramPair.e.equals(paramObject.packageName)) && (paramPair.c.equals(paramObject.mGdtAd_appId));
  }
  
  public int isPkgDownloadPaused(Context paramContext, String paramString1, String paramString2)
  {
    return acik.b(paramContext, paramString1, paramString2);
  }
  
  public int isPkgDownloading(Context paramContext, String paramString1, String paramString2)
  {
    return acik.a(paramContext, paramString1, paramString2);
  }
  
  public boolean isPkgExist(Context paramContext, String paramString1, String paramString2)
  {
    return acik.b(paramContext, paramString2);
  }
  
  public void pauseDownload(String paramString1, String paramString2)
  {
    bjjq.a().a(paramString2);
  }
  
  public void registerListener(IAdDownloader.Callback paramCallback)
  {
    if ((paramCallback instanceof DownloadListener)) {
      bjjq.a().a((DownloadListener)paramCallback);
    }
  }
  
  public void unregisterListener(IAdDownloader.Callback paramCallback)
  {
    if ((paramCallback instanceof DownloadListener)) {
      bjjq.a().b((DownloadListener)paramCallback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abze
 * JD-Core Version:    0.7.0.1
 */