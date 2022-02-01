package com.tencent.mm.plugin.sns.ad.c;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.a.af;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.sns.ad.e.h;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
{
  public static boolean a(Context paramContext, String paramString1, String paramString2, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(201872);
    try
    {
      Log.d("SnsAd.FinderTopicRequest", " encryptedTopicId is " + paramString1 + ", topicName is " + paramString2);
      if ((paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
      {
        Log.w("SnsAd.FinderTopicRequest", "the encryptedTopicId or topicName is empty or context is null");
        AppMethodBeat.o(201872);
        return false;
      }
      Object localObject = (aj)g.ah(aj.class);
      if (localObject != null) {}
      for (localObject = ((aj)localObject).getFinderUtilApi(); localObject != null; localObject = null)
      {
        if (paramSnsInfo != null)
        {
          String str = r.v(paramSnsInfo);
          h.jU(paramSnsInfo.getUxinfo(), str);
        }
        ((af)localObject).B(paramContext, paramString1, paramString2);
        AppMethodBeat.o(201872);
        return true;
      }
      Log.w("SnsAd.FinderTopicRequest", "the IFinderUtilApi object is null!!");
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        Log.e("SnsAd.FinderTopicRequest", "the enterTopicProfileUI has something wrong!!!");
      }
    }
    AppMethodBeat.o(201872);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.c.c
 * JD-Core Version:    0.7.0.1
 */