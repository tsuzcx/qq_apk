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

public class acnh
  implements AdDownloaderAdapter
{
  public void doDownloadAction(Activity paramActivity, Bundle paramBundle, String paramString, int paramInt)
  {
    bjtd.a().a(paramActivity, paramBundle, paramString, null, paramInt);
  }
  
  public int getCurrentPkgDownloadProgress(Context paramContext, String paramString1, String paramString2)
  {
    return acwa.c(paramContext, paramString1, paramString2);
  }
  
  public Object getDownloadInfoByUrl(String paramString)
  {
    paramString = bjsz.a().b(paramString);
    paramString.m = "biz_src_ads";
    return paramString;
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
      bjsz.a().a((DownloadInfo)paramObject);
    }
    while (!(paramObject instanceof Bundle)) {
      return;
    }
    bjtd.a((Bundle)paramObject);
  }
  
  public boolean isCurrentPkgTask(Pair<String, String> paramPair, Object paramObject)
  {
    if ((paramPair == null) || (TextUtils.isEmpty((CharSequence)paramPair.first)) || (TextUtils.isEmpty((CharSequence)paramPair.second)) || (!(paramObject instanceof AdAppBtnData))) {}
    do
    {
      do
      {
        return false;
        paramPair = bjsz.a().b((String)paramPair.first);
      } while (paramPair == null);
      paramObject = (AdAppBtnData)paramObject;
    } while ((TextUtils.isEmpty(paramPair.e)) || (TextUtils.isEmpty(paramPair.c)) || (TextUtils.isEmpty(paramObject.packageName)) || (TextUtils.isEmpty(paramObject.mGdtAd_appId)));
    return (paramPair.e.equals(paramObject.packageName)) && (paramPair.c.equals(paramObject.mGdtAd_appId));
  }
  
  public int isPkgDownloadPaused(Context paramContext, String paramString1, String paramString2)
  {
    return acwa.b(paramContext, paramString1, paramString2);
  }
  
  public int isPkgDownloading(Context paramContext, String paramString1, String paramString2)
  {
    return acwa.a(paramContext, paramString1, paramString2);
  }
  
  public boolean isPkgExist(Context paramContext, String paramString1, String paramString2)
  {
    return acwa.b(paramContext, paramString2);
  }
  
  public void pauseDownload(String paramString1, String paramString2)
  {
    bjsz.a().a(paramString2);
  }
  
  public void registerListener(IAdDownloader.Callback paramCallback)
  {
    if ((paramCallback instanceof DownloadListener)) {
      bjsz.a().a((DownloadListener)paramCallback);
    }
  }
  
  public void unregisterListener(IAdDownloader.Callback paramCallback)
  {
    if ((paramCallback instanceof DownloadListener)) {
      bjsz.a().b((DownloadListener)paramCallback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acnh
 * JD-Core Version:    0.7.0.1
 */