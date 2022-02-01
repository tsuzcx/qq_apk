package com.tencent.mm.plugin.sns.ad.b;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.a.ag;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.sns.ad.d.l;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
{
  public static boolean a(Context paramContext, String paramString1, String paramString2, SnsInfo paramSnsInfo, int paramInt)
  {
    AppMethodBeat.i(265724);
    try
    {
      Log.d("SnsAd.FinderTopicRequest", " encryptedTopicId is " + paramString1 + ", topicName is " + paramString2);
      if ((paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
      {
        Log.w("SnsAd.FinderTopicRequest", "the encryptedTopicId or topicName is empty or context is null");
        AppMethodBeat.o(265724);
        return false;
      }
      Object localObject = (ak)h.ag(ak.class);
      if (localObject != null) {}
      for (localObject = ((ak)localObject).getFinderUtilApi(); localObject != null; localObject = null)
      {
        if (paramSnsInfo != null)
        {
          String str = t.w(paramSnsInfo);
          l.an(paramSnsInfo.getUxinfo(), str, 3);
        }
        ((ag)localObject).d(paramContext, paramString1, paramString2, paramInt);
        AppMethodBeat.o(265724);
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
    AppMethodBeat.o(265724);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.b.c
 * JD-Core Version:    0.7.0.1
 */