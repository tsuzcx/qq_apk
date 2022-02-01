package com.tencent.mm.plugin.sns.ad.c.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.j.d;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class c
{
  Map<String, b> PNF;
  Map<String, a> PNG;
  
  public c()
  {
    AppMethodBeat.i(309915);
    this.PNF = new ConcurrentHashMap();
    this.PNG = new ConcurrentHashMap();
    AppMethodBeat.o(309915);
  }
  
  public final b a(b paramb)
  {
    AppMethodBeat.i(309924);
    if (TextUtils.isEmpty(paramb.mhl))
    {
      AppMethodBeat.o(309924);
      return null;
    }
    int i;
    if ((paramb == null) || (TextUtils.isEmpty(paramb.mhl)))
    {
      Log.i("SnsAd.H5Prefetch", "the task info is empty!");
      i = 0;
    }
    for (;;)
    {
      if (i == 0) {
        break label287;
      }
      Log.i("SnsAd.H5Prefetch", "the task info is to prefetch, the task key  is : " + paramb.mhl);
      this.PNF.put(paramb.mhl, paramb);
      AppMethodBeat.o(309924);
      return paramb;
      if (this.PNF.containsKey(paramb.mhl))
      {
        Log.i("SnsAd.H5Prefetch", "the task key is in pending task, the task key is : " + paramb.mhl);
        break;
      }
      long l = System.currentTimeMillis();
      Object localObject = (a)this.PNG.get(paramb.mhl);
      if ((localObject != null) && (l < ((a)localObject).PNH + 600000L))
      {
        Log.i("SnsAd.H5Prefetch", "the task key has been prefetch, the task key is : " + paramb.mhl);
        break;
      }
      i = paramb.type;
      if (i == 0)
      {
        if (paramb == null) {
          break;
        }
        localObject = paramb.PNI;
        if ((localObject == null) || (!((SnsInfo)localObject).isAd()))
        {
          Log.i("SnsAd.H5Prefetch", "the sns info is not ad!");
          break;
        }
        i = 1;
        continue;
      }
      if ((i != 1) || (paramb == null)) {
        break;
      }
      if (d.y(paramb.eqg))
      {
        Log.i("SnsAd.H5Prefetch", "the urls is empty!");
        break;
      }
      i = 1;
    }
    label287:
    AppMethodBeat.o(309924);
    return null;
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(309932);
    if ((paramb != null) && (!TextUtils.isEmpty(paramb.mhl)) && (h.ahAA != null))
    {
      h.ahAA.bm(new b(this, paramb.mhl));
      AppMethodBeat.o(309932);
      return;
    }
    Log.d("SnsAd.H5Prefetch", "the task info is null");
    AppMethodBeat.o(309932);
  }
  
  public static final class a
  {
    long PNH;
    String mhl;
  }
  
  public static final class b
  {
    SnsInfo PNI;
    String[] eqg;
    String hQX;
    String mhl;
    int source;
    int type;
    
    public b(SnsInfo paramSnsInfo, int paramInt)
    {
      AppMethodBeat.i(309914);
      this.type = 0;
      this.PNI = paramSnsInfo;
      this.source = paramInt;
      this.type = 0;
      if (paramSnsInfo != null) {}
      for (paramSnsInfo = paramSnsInfo.getSnsId();; paramSnsInfo = "")
      {
        this.hQX = paramSnsInfo;
        this.mhl = gL(this.hQX, this.type);
        AppMethodBeat.o(309914);
        return;
      }
    }
    
    public b(String paramString, String[] paramArrayOfString)
    {
      AppMethodBeat.i(309923);
      this.type = 0;
      this.hQX = paramString;
      this.eqg = paramArrayOfString;
      this.type = 1;
      this.mhl = gL(paramString, this.type);
      AppMethodBeat.o(309923);
    }
    
    private static String gL(String paramString, int paramInt)
    {
      AppMethodBeat.i(309934);
      if (paramString != null)
      {
        paramString = paramString + "_" + paramInt;
        AppMethodBeat.o(309934);
        return paramString;
      }
      paramString = " _".concat(String.valueOf(paramInt));
      AppMethodBeat.o(309934);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.c.a.c
 * JD-Core Version:    0.7.0.1
 */