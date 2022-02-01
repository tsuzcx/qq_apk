package com.tencent.mm.plugin.sns.ad.d.a;

import android.text.TextUtils;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class c
{
  Map<String, a> DsA;
  Map<String, b> Dsz;
  
  public c()
  {
    AppMethodBeat.i(201883);
    this.Dsz = new ConcurrentHashMap();
    this.DsA = new ConcurrentHashMap();
    AppMethodBeat.o(201883);
  }
  
  private boolean a(b paramb)
  {
    AppMethodBeat.i(201884);
    if ((paramb == null) || (TextUtils.isEmpty(paramb.gWK)))
    {
      Log.i("SnsAd.H5Prefetch", "the task info is empty!");
      AppMethodBeat.o(201884);
      return false;
    }
    if (this.Dsz.containsKey(paramb.gWK))
    {
      Log.i("SnsAd.H5Prefetch", "the task key is in pending task, the task key is : " + paramb.gWK);
      AppMethodBeat.o(201884);
      return false;
    }
    long l = System.currentTimeMillis();
    a locala = (a)this.DsA.get(paramb.gWK);
    if ((locala != null) && (l < locala.DsB + 600000L))
    {
      Log.i("SnsAd.H5Prefetch", "the task key has been prefetch, the task key is : " + paramb.gWK);
      AppMethodBeat.o(201884);
      return false;
    }
    int i = paramb.type;
    if (i == 0)
    {
      if (paramb == null)
      {
        AppMethodBeat.o(201884);
        return false;
      }
      paramb = paramb.DsC;
      if ((paramb == null) || (!paramb.isAd()))
      {
        Log.i("SnsAd.H5Prefetch", "the sns info is not ad!");
        AppMethodBeat.o(201884);
        return false;
      }
      AppMethodBeat.o(201884);
      return true;
    }
    if (i == 1)
    {
      if (paramb == null)
      {
        AppMethodBeat.o(201884);
        return false;
      }
      if (com.tencent.mm.plugin.sns.ad.i.c.w(paramb.cze))
      {
        Log.i("SnsAd.H5Prefetch", "the urls is empty!");
        AppMethodBeat.o(201884);
        return false;
      }
      AppMethodBeat.o(201884);
      return true;
    }
    AppMethodBeat.o(201884);
    return false;
  }
  
  public final b b(b paramb)
  {
    AppMethodBeat.i(201885);
    if (TextUtils.isEmpty(paramb.gWK))
    {
      AppMethodBeat.o(201885);
      return null;
    }
    if (a(paramb))
    {
      Log.i("SnsAd.H5Prefetch", "the task info is to prefetch, the task key  is : " + paramb.gWK);
      this.Dsz.put(paramb.gWK, paramb);
      AppMethodBeat.o(201885);
      return paramb;
    }
    AppMethodBeat.o(201885);
    return null;
  }
  
  public final void c(b paramb)
  {
    AppMethodBeat.i(201886);
    if ((paramb != null) && (!TextUtils.isEmpty(paramb.gWK)) && (h.RTc != null))
    {
      h.RTc.aX(new b(this, paramb.gWK));
      AppMethodBeat.o(201886);
      return;
    }
    Log.d("SnsAd.H5Prefetch", "the task info is null");
    AppMethodBeat.o(201886);
  }
  
  public static final class a
  {
    long DsB;
    String gWK;
  }
  
  public static final class b
  {
    SnsInfo DsC;
    String[] cze;
    String dRS;
    String gWK;
    int source;
    int type;
    
    public b(SnsInfo paramSnsInfo, int paramInt)
    {
      AppMethodBeat.i(201880);
      this.type = 0;
      this.DsC = paramSnsInfo;
      this.source = paramInt;
      this.type = 0;
      if (paramSnsInfo != null) {}
      for (paramSnsInfo = paramSnsInfo.getSnsId();; paramSnsInfo = "")
      {
        this.dRS = paramSnsInfo;
        this.gWK = fq(this.dRS, this.type);
        AppMethodBeat.o(201880);
        return;
      }
    }
    
    public b(String paramString, String[] paramArrayOfString)
    {
      AppMethodBeat.i(201881);
      this.type = 0;
      this.dRS = paramString;
      this.cze = paramArrayOfString;
      this.type = 1;
      this.gWK = fq(paramString, this.type);
      AppMethodBeat.o(201881);
    }
    
    private static String fq(String paramString, int paramInt)
    {
      AppMethodBeat.i(201882);
      if (paramString != null)
      {
        paramString = paramString + "_" + paramInt;
        AppMethodBeat.o(201882);
        return paramString;
      }
      paramString = " _".concat(String.valueOf(paramInt));
      AppMethodBeat.o(201882);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.a.c
 * JD-Core Version:    0.7.0.1
 */