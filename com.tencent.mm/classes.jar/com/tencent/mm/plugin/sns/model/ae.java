package com.tencent.mm.plugin.sns.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.e;
import com.tencent.mm.i.d;
import com.tencent.mm.i.h.a;
import com.tencent.mm.modelvideo.b;
import com.tencent.mm.modelvideo.b.a;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;

public final class ae
  implements b
{
  b.a pGr;
  String ukB;
  private h.a zAj;
  
  public ae()
  {
    AppMethodBeat.i(95716);
    this.ukB = "";
    this.zAj = new h.a()
    {
      public final void a(final String paramAnonymousString, final int paramAnonymousInt, d paramAnonymousd)
      {
        AppMethodBeat.i(95715);
        if ((ae.this.pGr != null) && (ae.this.ukB.equals(paramAnonymousString))) {
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(95711);
              ak.getContext().getSharedPreferences("sns_ad_download_resource_preferences", 0).edit().putBoolean(paramAnonymousString, true).commit();
              ae.this.pGr.at(paramAnonymousString, paramAnonymousInt);
              ah.dXz().azQ(paramAnonymousString);
              AppMethodBeat.o(95711);
            }
          });
        }
        AppMethodBeat.o(95715);
      }
      
      public final void a(final String paramAnonymousString1, final long paramAnonymousLong1, long paramAnonymousLong2, final String paramAnonymousString2)
      {
        AppMethodBeat.i(219338);
        if ((ae.this.pGr != null) && (ae.this.ukB.equals(paramAnonymousString1))) {
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(95708);
              ae.this.pGr.sC(paramAnonymousLong1);
              AppMethodBeat.o(95708);
            }
          });
        }
        AppMethodBeat.o(219338);
      }
      
      public final void i(final String paramAnonymousString, final long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(95714);
        if ((ae.this.pGr != null) && (ae.this.ukB.equals(paramAnonymousString))) {
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(95710);
              ae.this.pGr.i(paramAnonymousString, paramAnonymousLong1, this.ujY);
              AppMethodBeat.o(95710);
            }
          });
        }
        AppMethodBeat.o(95714);
      }
      
      public final void onDataAvailable(final String paramAnonymousString, final long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(95713);
        if ((ae.this.pGr != null) && (ae.this.ukB.equals(paramAnonymousString))) {
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(95709);
              ae.this.pGr.onDataAvailable(paramAnonymousString, paramAnonymousLong1, this.lqk);
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
    this.pGr = parama;
  }
  
  public final void gp(String paramString)
  {
    AppMethodBeat.i(95718);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsAdStreamVideoProxy", "%s, stop stream[%s]", new Object[] { Integer.valueOf(hashCode()), paramString });
    if (this.ukB.equals(paramString)) {
      ah.dXz().azQ(paramString);
    }
    AppMethodBeat.o(95718);
  }
  
  public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    AppMethodBeat.i(95720);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsAdStreamVideoProxy", "%s, check video data available[%s, %s, %s]", new Object[] { Integer.valueOf(hashCode()), paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.ukB.equals(paramString)) {
      bool = com.tencent.mm.modelvideo.o.aNi().isVideoDataAvailable(paramString, paramInt1, paramInt2);
    }
    AppMethodBeat.o(95720);
    return bool;
  }
  
  public final void p(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(95717);
    this.ukB = paramString1;
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsAdStreamVideoProxy", "%s start http stream[%s, %s, %s]", new Object[] { Integer.valueOf(hashCode()), paramString1, paramString3, paramString2 });
    SharedPreferences localSharedPreferences = ak.getContext().getSharedPreferences("sns_ad_download_resource_preferences", 0);
    boolean bool = localSharedPreferences.getBoolean(paramString1, false);
    if (com.tencent.mm.vfs.o.fB(paramString2))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsAdStreamVideoProxy", "is already download %s", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        this.zAj.a(paramString1, 0, null);
        AppMethodBeat.o(95717);
      }
    }
    else if (bool)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsAdStreamVideoProxy", "last download file was deleted");
      localSharedPreferences.edit().putBoolean(paramString1, false).commit();
    }
    if (ah.dXz().azT(paramString1))
    {
      com.tencent.mm.sdk.platformtools.ae.i("%s is already in downloading", paramString3);
      AppMethodBeat.o(95717);
      return;
    }
    ah.dXz().a(paramString1, paramString3, paramString2, this.zAj);
    AppMethodBeat.o(95717);
  }
  
  public final void requestVideoData(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95719);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsAdStreamVideoProxy", "%s, request video data[%s, %s, %s]", new Object[] { Integer.valueOf(hashCode()), paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.ukB.equals(paramString))
    {
      com.tencent.mm.modelvideo.o.aNi();
      e.r(paramString, paramInt1, paramInt2);
    }
    AppMethodBeat.o(95719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ae
 * JD-Core Version:    0.7.0.1
 */