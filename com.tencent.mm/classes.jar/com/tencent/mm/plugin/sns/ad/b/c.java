package com.tencent.mm.plugin.sns.ad.b;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.a.ca;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.sns.ad.d.n;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
{
  public static boolean a(Context paramContext, String paramString1, String paramString2, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(309688);
    boolean bool = a(paramContext, paramString1, paramString2, paramSnsInfo, 6, "", "");
    AppMethodBeat.o(309688);
    return bool;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, SnsInfo paramSnsInfo, int paramInt, String paramString3, String paramString4)
  {
    AppMethodBeat.i(309700);
    try
    {
      Log.d("SnsAd.FinderTopicRequest", " encryptedTopicId is " + paramString1 + ", topicName is " + paramString2);
      if ((paramContext == null) || (TextUtils.isEmpty(paramString1)))
      {
        Log.w("SnsAd.FinderTopicRequest", "the encryptedTopicId or topicName is empty or context is null");
        AppMethodBeat.o(309700);
        return false;
      }
      Object localObject = (cn)h.az(cn.class);
      if (localObject != null) {}
      for (localObject = ((cn)localObject).getFinderUtilApi(); localObject != null; localObject = null)
      {
        if (paramSnsInfo != null)
        {
          String str = t.x(paramSnsInfo);
          n.aw(paramSnsInfo.getUxinfo(), str, 3);
        }
        ((ca)localObject).a(paramContext, paramString1, paramString2, paramInt, paramString3, paramString4);
        AppMethodBeat.o(309700);
        return true;
      }
      Log.w("SnsAd.FinderTopicRequest", "the IFinderUtilApi object is null!!");
    }
    finally
    {
      for (;;)
      {
        Log.e("SnsAd.FinderTopicRequest", "the enterTopicProfileUI has something wrong!!!");
      }
    }
    AppMethodBeat.o(309700);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.b.c
 * JD-Core Version:    0.7.0.1
 */