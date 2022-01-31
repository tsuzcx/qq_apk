package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.text.TextUtils;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.a.c;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  public ConcurrentHashMap<Long, WeakReference<a.a>> oBW = new ConcurrentHashMap();
  public ConcurrentHashMap<String, a.b> oBX = new ConcurrentHashMap();
  
  private a()
  {
    d.aFP();
    com.tencent.mm.plugin.downloader.model.b.a(new a.1(this));
  }
  
  public static long queryIdByAppid(String paramString)
  {
    paramString = d.aFP().zL(paramString);
    if (paramString != null) {
      return paramString.id;
    }
    return 9223372036854775807L;
  }
  
  private static String r(Object... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < 4)
    {
      localStringBuilder.append(String.valueOf(paramVarArgs[i])).append(',');
      i += 1;
    }
    localStringBuilder.append(System.currentTimeMillis() / 1000L);
    return localStringBuilder.toString();
  }
  
  public static void stopTask(long paramLong)
  {
    d.aFP().dc(paramLong);
  }
  
  public final void N(int paramInt, long paramLong)
  {
    Object localObject = ((c)g.r(c.class)).FC().dr(paramLong);
    if (localObject == null) {
      return;
    }
    localObject = ((com.tencent.mm.plugin.downloader.f.a)localObject).field_appId;
    com.tencent.mm.plugin.downloader.f.a locala = ((c)g.r(c.class)).FC().zH((String)localObject);
    if (locala == null)
    {
      y.i("MicroMsg.AdDownloadApkMgr", "downloadinfo not found");
      return;
    }
    String str1 = locala.field_packageName;
    String str2 = locala.field_md5;
    e(paramInt, (String)localObject, str1, locala.field_downloadUrl);
  }
  
  public final void e(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    System.currentTimeMillis();
    a.b localb = (a.b)this.oBX.get(paramString1);
    String str = paramString2;
    if (!TextUtils.isEmpty(paramString2)) {
      str = paramString2.replaceAll("\\.", "_");
    }
    if (localb == null) {}
    for (paramString2 = "";; paramString2 = localb.oAl + "." + localb.fLi + "." + str + ".0.20.0")
    {
      paramString1 = r(new Object[] { paramString1, Integer.valueOf(paramInt), paramString3, paramString2 });
      y.i("MicroMsg.AdDownloadApkMgr", "reporting %d  %s", new Object[] { Integer.valueOf(14542), paramString1 });
      y.d("MicroMsg.AdDownloadApkMgr", "14542  extinfo : " + paramString2);
      h.nFQ.a(14542, paramString1, true, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a
 * JD-Core Version:    0.7.0.1
 */