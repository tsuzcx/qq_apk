package com.tencent.mm.plugin.sns.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.e;
import com.tencent.mm.i.d;
import com.tencent.mm.i.h.a;
import com.tencent.mm.modelvideo.b.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.vfs.i;

public final class ac
  implements com.tencent.mm.modelvideo.b
{
  b.a oWd;
  String tbJ;
  private h.a xSZ;
  
  public ac()
  {
    AppMethodBeat.i(95716);
    this.tbJ = "";
    this.xSZ = new h.a()
    {
      public final void a(final String paramAnonymousString, final int paramAnonymousInt, d paramAnonymousd)
      {
        AppMethodBeat.i(95715);
        if ((ac.this.oWd != null) && (ac.this.tbJ.equals(paramAnonymousString))) {
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(95711);
              ai.getContext().getSharedPreferences("sns_ad_download_resource_preferences", 0).edit().putBoolean(paramAnonymousString, true).commit();
              ac.this.oWd.aq(paramAnonymousString, paramAnonymousInt);
              af.dHM().atu(paramAnonymousString);
              AppMethodBeat.o(95711);
            }
          });
        }
        AppMethodBeat.o(95715);
      }
      
      public final void a(final String paramAnonymousString1, final long paramAnonymousLong1, long paramAnonymousLong2, final String paramAnonymousString2)
      {
        AppMethodBeat.i(200113);
        if ((ac.this.oWd != null) && (ac.this.tbJ.equals(paramAnonymousString1))) {
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(95708);
              ac.this.oWd.qq(paramAnonymousLong1);
              AppMethodBeat.o(95708);
            }
          });
        }
        AppMethodBeat.o(200113);
      }
      
      public final void i(final String paramAnonymousString, final long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(95714);
        if ((ac.this.oWd != null) && (ac.this.tbJ.equals(paramAnonymousString))) {
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(95710);
              ac.this.oWd.i(paramAnonymousString, paramAnonymousLong1, this.tbg);
              AppMethodBeat.o(95710);
            }
          });
        }
        AppMethodBeat.o(95714);
      }
      
      public final void onDataAvailable(final String paramAnonymousString, final long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(95713);
        if ((ac.this.oWd != null) && (ac.this.tbJ.equals(paramAnonymousString))) {
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(95709);
              ac.this.oWd.onDataAvailable(paramAnonymousString, paramAnonymousLong1, this.kPh);
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
    this.oWd = parama;
  }
  
  public final void fo(String paramString)
  {
    AppMethodBeat.i(95718);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SnsAdStreamVideoProxy", "%s, stop stream[%s]", new Object[] { Integer.valueOf(hashCode()), paramString });
    if (this.tbJ.equals(paramString)) {
      af.dHM().atu(paramString);
    }
    AppMethodBeat.o(95718);
  }
  
  public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    AppMethodBeat.i(95720);
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.SnsAdStreamVideoProxy", "%s, check video data available[%s, %s, %s]", new Object[] { Integer.valueOf(hashCode()), paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.tbJ.equals(paramString)) {
      bool = o.aJz().isVideoDataAvailable(paramString, paramInt1, paramInt2);
    }
    AppMethodBeat.o(95720);
    return bool;
  }
  
  public final void q(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(95717);
    this.tbJ = paramString1;
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SnsAdStreamVideoProxy", "%s start http stream[%s, %s, %s]", new Object[] { Integer.valueOf(hashCode()), paramString1, paramString3, paramString2 });
    SharedPreferences localSharedPreferences = ai.getContext().getSharedPreferences("sns_ad_download_resource_preferences", 0);
    boolean bool = localSharedPreferences.getBoolean(paramString1, false);
    if (i.eA(paramString2))
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SnsAdStreamVideoProxy", "is already download %s", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        this.xSZ.a(paramString1, 0, null);
        AppMethodBeat.o(95717);
      }
    }
    else if (bool)
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SnsAdStreamVideoProxy", "last download file was deleted");
      localSharedPreferences.edit().putBoolean(paramString1, false).commit();
    }
    if (af.dHM().atx(paramString1))
    {
      com.tencent.mm.sdk.platformtools.ac.i("%s is already in downloading", paramString3);
      AppMethodBeat.o(95717);
      return;
    }
    af.dHM().a(paramString1, paramString3, paramString2, this.xSZ);
    AppMethodBeat.o(95717);
  }
  
  public final void requestVideoData(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95719);
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.SnsAdStreamVideoProxy", "%s, request video data[%s, %s, %s]", new Object[] { Integer.valueOf(hashCode()), paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.tbJ.equals(paramString))
    {
      o.aJz();
      e.p(paramString, paramInt1, paramInt2);
    }
    AppMethodBeat.o(95719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ac
 * JD-Core Version:    0.7.0.1
 */