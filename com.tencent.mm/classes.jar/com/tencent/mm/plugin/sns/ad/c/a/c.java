package com.tencent.mm.plugin.sns.ad.c.a;

import android.text.TextUtils;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.d;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class c
{
  Map<String, b> Jzh;
  Map<String, a> Jzi;
  
  public c()
  {
    AppMethodBeat.i(201130);
    this.Jzh = new ConcurrentHashMap();
    this.Jzi = new ConcurrentHashMap();
    AppMethodBeat.o(201130);
  }
  
  public final b a(b paramb)
  {
    AppMethodBeat.i(201140);
    if (TextUtils.isEmpty(paramb.jHH))
    {
      AppMethodBeat.o(201140);
      return null;
    }
    int i;
    if ((paramb == null) || (TextUtils.isEmpty(paramb.jHH)))
    {
      Log.i("SnsAd.H5Prefetch", "the task info is empty!");
      i = 0;
    }
    for (;;)
    {
      if (i == 0) {
        break label287;
      }
      Log.i("SnsAd.H5Prefetch", "the task info is to prefetch, the task key  is : " + paramb.jHH);
      this.Jzh.put(paramb.jHH, paramb);
      AppMethodBeat.o(201140);
      return paramb;
      if (this.Jzh.containsKey(paramb.jHH))
      {
        Log.i("SnsAd.H5Prefetch", "the task key is in pending task, the task key is : " + paramb.jHH);
        break;
      }
      long l = System.currentTimeMillis();
      Object localObject = (a)this.Jzi.get(paramb.jHH);
      if ((localObject != null) && (l < ((a)localObject).Jzj + 600000L))
      {
        Log.i("SnsAd.H5Prefetch", "the task key has been prefetch, the task key is : " + paramb.jHH);
        break;
      }
      i = paramb.type;
      if (i == 0)
      {
        if (paramb == null) {
          break;
        }
        localObject = paramb.Jzk;
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
      if (d.w(paramb.cxM))
      {
        Log.i("SnsAd.H5Prefetch", "the urls is empty!");
        break;
      }
      i = 1;
    }
    label287:
    AppMethodBeat.o(201140);
    return null;
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(201142);
    if ((paramb != null) && (!TextUtils.isEmpty(paramb.jHH)) && (h.ZvG != null))
    {
      h.ZvG.be(new b(this, paramb.jHH));
      AppMethodBeat.o(201142);
      return;
    }
    Log.d("SnsAd.H5Prefetch", "the task info is null");
    AppMethodBeat.o(201142);
  }
  
  public static final class a
  {
    long Jzj;
    String jHH;
  }
  
  public static final class b
  {
    SnsInfo Jzk;
    String[] cxM;
    String fLp;
    String jHH;
    int source;
    int type;
    
    public b(SnsInfo paramSnsInfo, int paramInt)
    {
      AppMethodBeat.i(196604);
      this.type = 0;
      this.Jzk = paramSnsInfo;
      this.source = paramInt;
      this.type = 0;
      if (paramSnsInfo != null) {}
      for (paramSnsInfo = paramSnsInfo.getSnsId();; paramSnsInfo = "")
      {
        this.fLp = paramSnsInfo;
        this.jHH = fS(this.fLp, this.type);
        AppMethodBeat.o(196604);
        return;
      }
    }
    
    public b(String paramString, String[] paramArrayOfString)
    {
      AppMethodBeat.i(196605);
      this.type = 0;
      this.fLp = paramString;
      this.cxM = paramArrayOfString;
      this.type = 1;
      this.jHH = fS(paramString, this.type);
      AppMethodBeat.o(196605);
    }
    
    private static String fS(String paramString, int paramInt)
    {
      AppMethodBeat.i(196608);
      if (paramString != null)
      {
        paramString = paramString + "_" + paramInt;
        AppMethodBeat.o(196608);
        return paramString;
      }
      paramString = " _".concat(String.valueOf(paramInt));
      AppMethodBeat.o(196608);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.c.a.c
 * JD-Core Version:    0.7.0.1
 */