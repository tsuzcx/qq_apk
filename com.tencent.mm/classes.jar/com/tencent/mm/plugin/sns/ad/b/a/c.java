package com.tencent.mm.plugin.sns.ad.b.a;

import android.text.TextUtils;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class c
{
  Map<String, b> znj;
  Map<String, a> znk;
  
  public c()
  {
    AppMethodBeat.i(218993);
    this.znj = new ConcurrentHashMap();
    this.znk = new ConcurrentHashMap();
    AppMethodBeat.o(218993);
  }
  
  public final b a(b paramb)
  {
    AppMethodBeat.i(218994);
    if (TextUtils.isEmpty(paramb.glT))
    {
      AppMethodBeat.o(218994);
      return null;
    }
    int i;
    if (TextUtils.isEmpty(paramb.glT))
    {
      ae.i("SnsAd.H5Prefetch", "the task info is empty!");
      i = 0;
    }
    for (;;)
    {
      if (i == 0) {
        break label277;
      }
      ae.i("SnsAd.H5Prefetch", "the task info is to prefetch, the task key  is : " + paramb.glT);
      this.znj.put(paramb.glT, paramb);
      AppMethodBeat.o(218994);
      return paramb;
      if (this.znj.containsKey(paramb.glT))
      {
        ae.i("SnsAd.H5Prefetch", "the task key is in pending task, the task key is : " + paramb.glT);
        break;
      }
      long l = System.currentTimeMillis();
      Object localObject = (a)this.znk.get(paramb.glT);
      if ((localObject != null) && (l < ((a)localObject).znl + 600000L))
      {
        ae.i("SnsAd.H5Prefetch", "the task key has been prefetch, the task key is : " + paramb.glT);
        break;
      }
      i = paramb.type;
      if (i == 0)
      {
        localObject = paramb.znm;
        if ((localObject == null) || (!((p)localObject).Rt(32)))
        {
          ae.i("SnsAd.H5Prefetch", "the sns info is not ad!");
          break;
        }
        i = 1;
        continue;
      }
      if (i != 1) {
        break;
      }
      if (com.tencent.mm.plugin.sns.ad.f.c.w(paramb.cni))
      {
        ae.i("SnsAd.H5Prefetch", "the urls is empty!");
        break;
      }
      i = 1;
    }
    label277:
    AppMethodBeat.o(218994);
    return null;
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(218995);
    if ((paramb != null) && (!TextUtils.isEmpty(paramb.glT)) && (h.MqF != null))
    {
      h.MqF.aO(new b(this, paramb.glT));
      AppMethodBeat.o(218995);
      return;
    }
    ae.d("SnsAd.H5Prefetch", "the task info is null");
    AppMethodBeat.o(218995);
  }
  
  public static final class a
  {
    String glT;
    long znl;
  }
  
  public static final class b
  {
    String[] cni;
    String dAg;
    int doj;
    String glT;
    int type;
    p znm;
    
    public b(p paramp, int paramInt)
    {
      AppMethodBeat.i(218990);
      this.type = 0;
      this.znm = paramp;
      this.doj = paramInt;
      this.type = 0;
      if (paramp != null) {}
      for (paramp = paramp.getSnsId();; paramp = "")
      {
        this.dAg = paramp;
        this.glT = eX(this.dAg, this.type);
        AppMethodBeat.o(218990);
        return;
      }
    }
    
    public b(String paramString, String[] paramArrayOfString)
    {
      AppMethodBeat.i(218991);
      this.type = 0;
      this.dAg = paramString;
      this.cni = paramArrayOfString;
      this.type = 1;
      this.glT = eX(paramString, this.type);
      AppMethodBeat.o(218991);
    }
    
    private static String eX(String paramString, int paramInt)
    {
      AppMethodBeat.i(218992);
      if (paramString != null)
      {
        paramString = paramString + "_" + paramInt;
        AppMethodBeat.o(218992);
        return paramString;
      }
      paramString = " _".concat(String.valueOf(paramInt));
      AppMethodBeat.o(218992);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.b.a.c
 * JD-Core Version:    0.7.0.1
 */