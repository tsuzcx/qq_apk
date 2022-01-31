package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.WebView;
import com.tencent.xweb.t;
import com.tencent.xweb.x5.sdk.f;

public final class v$a
{
  private static boolean rTV = false;
  
  static
  {
    y.i("TBSDownloadChecker", "TRACE_ORDER:TBSHelper.java");
    t.a(ae.getContext(), new v.a.1(), null, null);
  }
  
  public static void R(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName(ae.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
    localIntent.putExtra("intent_extra_download_type", paramInt);
    paramContext.startService(localIntent);
    y.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download xwalk now");
  }
  
  public static void ckF()
  {
    if (e.cqq()) {
      y.d("MicroMsg.TBSDownloadChecker", "preCheck isGPVersion, ignore this request");
    }
    while ((!f.in(ae.getContext())) || (WebView.getInstalledTbsCoreVersion(ae.getContext()) > 0)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClassName(ae.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
    localIntent.putExtra("intent_extra_download_type", 1);
    ae.getContext().startService(localIntent);
    y.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download tbs");
  }
  
  public static boolean ckG()
  {
    boolean bool1 = f.isDownloading();
    boolean bool2 = com.tencent.xweb.x5.sdk.d.getTBSInstalling();
    boolean bool3 = rTV;
    return (bool1) || (bool2) || (bool3);
  }
  
  public static int ckH()
  {
    if (e.cqq())
    {
      if (com.tencent.mm.compatible.util.d.gG(17))
      {
        y.i("MicroMsg.TBSDownloadChecker", "is GP version can not download");
        return 2;
      }
      y.i("MicroMsg.TBSDownloadChecker", "is GP version no need download");
      return 0;
    }
    int i = com.tencent.xweb.x5.sdk.d.getTbsVersion(ae.getContext());
    if (i < 36824)
    {
      y.i("MicroMsg.TBSDownloadChecker", "tbsCoreVersion %d should download", new Object[] { Integer.valueOf(i) });
      return 1;
    }
    if (com.tencent.xweb.x5.sdk.d.canOpenWebPlus(ae.getContext()))
    {
      y.i("MicroMsg.TBSDownloadChecker", "tbsCoreVersion %d can load x5", new Object[] { Integer.valueOf(i) });
      return 0;
    }
    y.i("MicroMsg.TBSDownloadChecker", "tbsCoreVersion %d can not load x5", new Object[] { Integer.valueOf(i) });
    return 1;
  }
  
  public static int ckI()
  {
    int i = 4;
    if ((com.tencent.mm.compatible.util.d.gF(19)) || (com.tencent.mm.compatible.util.d.gG(16))) {
      i = 1;
    }
    while (WebView.getInstalledTbsCoreVersion(ae.getContext()) > 0) {
      return i;
    }
    if (f.isDownloading()) {
      return 2;
    }
    if (com.tencent.xweb.x5.sdk.d.getTBSInstalling()) {
      return 3;
    }
    boolean bool = ae.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("tbs_download_oversea", false);
    y.i("MicroMsg.TBSDownloadChecker", "oversea = %b", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      return 2;
    }
    y.e("MicroMsg.TBSDownloadChecker", "WTF, how could it be?");
    return 0;
  }
  
  public static void eO(Context paramContext)
  {
    y.i("MicroMsg.TBSDownloadChecker", "webview start check tbs");
    Object localObject1 = paramContext.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
    long l1;
    long l2;
    Object localObject2;
    if (localObject1 != null)
    {
      l1 = ((SharedPreferences)localObject1).getLong("last_check_xwalk", 0L);
      l2 = System.currentTimeMillis();
      if (l2 - l1 >= 1800000L)
      {
        localObject2 = ((SharedPreferences)localObject1).edit();
        ((SharedPreferences.Editor)localObject2).putLong("last_check_xwalk", l2);
        ((SharedPreferences.Editor)localObject2).apply();
        R(paramContext, 4);
      }
    }
    int i = 1;
    boolean bool = ((SharedPreferences)localObject1).getBoolean("tbs_download_oversea", false);
    y.i("MicroMsg.TBSDownloadChecker", "user hasDownloadOverSea = %b", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      i = 2;
    }
    while (!e.cqq())
    {
      localObject2 = ((SharedPreferences)localObject1).getString("tbs_download", null);
      if ("1".equals(localObject2)) {
        break;
      }
      y.i("MicroMsg.TBSDownloadChecker", "tbsDownload switch is off, value = %s", new Object[] { localObject2 });
      return;
    }
    y.i("MicroMsg.TBSDownloadChecker", "isGPVersion, ignore this request");
    return;
    com.tencent.xweb.x5.sdk.d.setUploadCode(ae.getContext(), 130);
    bool = aq.isWifi(paramContext);
    y.i("MicroMsg.TBSDownloadChecker", "check, tbsDownload = %s, isWifi = %b", new Object[] { localObject2, Boolean.valueOf(bool) });
    if (!bool)
    {
      y.i("MicroMsg.TBSDownloadChecker", "check, net type is not wifi");
      com.tencent.xweb.x5.sdk.d.setUploadCode(ae.getContext(), 131);
      return;
    }
    if (localObject1 == null) {
      y.e("MicroMsg.TBSDownloadChecker", "sp is null");
    }
    for (int j = 0;; j = 1)
    {
      if (j != 0) {
        break label350;
      }
      j = WebView.getInstalledTbsCoreVersion(paramContext);
      y.i("MicroMsg.TBSDownloadChecker", "check expired false, tbsCoreVersion = %d", new Object[] { Integer.valueOf(j) });
      if (j <= 0) {
        break label350;
      }
      com.tencent.xweb.x5.sdk.d.setUploadCode(ae.getContext(), 132);
      return;
      l1 = ((SharedPreferences)localObject1).getLong("last_check_ts", 0L);
      l2 = System.currentTimeMillis();
      if (l2 - l1 <= 7200000L) {
        break;
      }
      localObject1 = ((SharedPreferences)localObject1).edit();
      ((SharedPreferences.Editor)localObject1).putLong("last_check_ts", l2);
      ((SharedPreferences.Editor)localObject1).apply();
    }
    label350:
    localObject1 = new Intent();
    ((Intent)localObject1).setClassName(ae.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
    ((Intent)localObject1).putExtra("intent_extra_download_type", i);
    paramContext.startService((Intent)localObject1);
    y.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download tbs");
  }
  
  public static void eP(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName(ae.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
    localIntent.putExtra("intent_extra_download_type", 2);
    localIntent.putExtra("intent_extra_download_ignore_network_type", true);
    paramContext.startService(localIntent);
    y.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download tbs");
    paramContext = ae.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
    if (paramContext != null) {
      paramContext.edit().putBoolean("tbs_download_oversea", true).apply();
    }
  }
  
  public static void lN(boolean paramBoolean)
  {
    rTV = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.v.a
 * JD-Core Version:    0.7.0.1
 */