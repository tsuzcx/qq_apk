package com.tencent.mm.plugin.sns.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.e;
import com.tencent.mm.i.d;
import com.tencent.mm.i.h.a;
import com.tencent.mm.modelvideo.b.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.vfs.i;

public final class ad
  implements com.tencent.mm.modelvideo.b
{
  b.a pzN;
  String tZz;
  private h.a ziU;
  
  public ad()
  {
    AppMethodBeat.i(95716);
    this.tZz = "";
    this.ziU = new h.a()
    {
      public final void a(final String paramAnonymousString, final int paramAnonymousInt, d paramAnonymousd)
      {
        AppMethodBeat.i(95715);
        if ((ad.this.pzN != null) && (ad.this.tZz.equals(paramAnonymousString))) {
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(95711);
              aj.getContext().getSharedPreferences("sns_ad_download_resource_preferences", 0).edit().putBoolean(paramAnonymousString, true).commit();
              ad.this.pzN.as(paramAnonymousString, paramAnonymousInt);
              ag.dTZ().ayz(paramAnonymousString);
              AppMethodBeat.o(95711);
            }
          });
        }
        AppMethodBeat.o(95715);
      }
      
      public final void a(final String paramAnonymousString1, final long paramAnonymousLong1, long paramAnonymousLong2, final String paramAnonymousString2)
      {
        AppMethodBeat.i(197845);
        if ((ad.this.pzN != null) && (ad.this.tZz.equals(paramAnonymousString1))) {
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(95708);
              ad.this.pzN.sp(paramAnonymousLong1);
              AppMethodBeat.o(95708);
            }
          });
        }
        AppMethodBeat.o(197845);
      }
      
      public final void i(final String paramAnonymousString, final long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(95714);
        if ((ad.this.pzN != null) && (ad.this.tZz.equals(paramAnonymousString))) {
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(95710);
              ad.this.pzN.i(paramAnonymousString, paramAnonymousLong1, this.tYW);
              AppMethodBeat.o(95710);
            }
          });
        }
        AppMethodBeat.o(95714);
      }
      
      public final void onDataAvailable(final String paramAnonymousString, final long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(95713);
        if ((ad.this.pzN != null) && (ad.this.tZz.equals(paramAnonymousString))) {
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(95709);
              ad.this.pzN.onDataAvailable(paramAnonymousString, paramAnonymousLong1, this.llK);
              AppMethodBeat.o(95709);
            }
          });
        }
        AppMethodBeat.o(95713);
      }
    };
    AppMethodBeat.o(95716);
  }
  
  public final void a(b.a parama)
  {
    this.pzN = parama;
  }
  
  public final void gj(String paramString)
  {
    AppMethodBeat.i(95718);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdStreamVideoProxy", "%s, stop stream[%s]", new Object[] { Integer.valueOf(hashCode()), paramString });
    if (this.tZz.equals(paramString)) {
      ag.dTZ().ayz(paramString);
    }
    AppMethodBeat.o(95718);
  }
  
  public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    AppMethodBeat.i(95720);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsAdStreamVideoProxy", "%s, check video data available[%s, %s, %s]", new Object[] { Integer.valueOf(hashCode()), paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.tZz.equals(paramString)) {
      bool = o.aMK().isVideoDataAvailable(paramString, paramInt1, paramInt2);
    }
    AppMethodBeat.o(95720);
    return bool;
  }
  
  public final void p(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(95717);
    this.tZz = paramString1;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdStreamVideoProxy", "%s start http stream[%s, %s, %s]", new Object[] { Integer.valueOf(hashCode()), paramString1, paramString3, paramString2 });
    SharedPreferences localSharedPreferences = aj.getContext().getSharedPreferences("sns_ad_download_resource_preferences", 0);
    boolean bool = localSharedPreferences.getBoolean(paramString1, false);
    if (i.fv(paramString2))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdStreamVideoProxy", "is already download %s", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        this.ziU.a(paramString1, 0, null);
        AppMethodBeat.o(95717);
      }
    }
    else if (bool)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAdStreamVideoProxy", "last download file was deleted");
      localSharedPreferences.edit().putBoolean(paramString1, false).commit();
    }
    if (ag.dTZ().ayC(paramString1))
    {
      com.tencent.mm.sdk.platformtools.ad.i("%s is already in downloading", paramString3);
      AppMethodBeat.o(95717);
      return;
    }
    ag.dTZ().a(paramString1, paramString3, paramString2, this.ziU);
    AppMethodBeat.o(95717);
  }
  
  public final void requestVideoData(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95719);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsAdStreamVideoProxy", "%s, request video data[%s, %s, %s]", new Object[] { Integer.valueOf(hashCode()), paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.tZz.equals(paramString))
    {
      o.aMK();
      e.r(paramString, paramInt1, paramInt2);
    }
    AppMethodBeat.o(95719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ad
 * JD-Core Version:    0.7.0.1
 */