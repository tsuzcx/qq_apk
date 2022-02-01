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
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.vfs.s;

public final class af
  implements b
{
  private h.a DJU;
  b.a qWn;
  String xCU;
  
  public af()
  {
    AppMethodBeat.i(95716);
    this.xCU = "";
    this.DJU = new h.a()
    {
      public final void Ds(String paramAnonymousString) {}
      
      public final void a(final String paramAnonymousString, final int paramAnonymousInt, d paramAnonymousd)
      {
        AppMethodBeat.i(95715);
        if ((af.this.qWn != null) && (af.this.xCU.equals(paramAnonymousString))) {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(95711);
              MMApplicationContext.getContext().getSharedPreferences("sns_ad_download_resource_preferences", 0).edit().putBoolean(paramAnonymousString, true).commit();
              af.this.qWn.ax(paramAnonymousString, paramAnonymousInt);
              aj.faJ().aOM(paramAnonymousString);
              AppMethodBeat.o(95711);
            }
          });
        }
        AppMethodBeat.o(95715);
      }
      
      public final void a(final String paramAnonymousString1, final long paramAnonymousLong1, long paramAnonymousLong2, final String paramAnonymousString2)
      {
        AppMethodBeat.i(202731);
        if ((af.this.qWn != null) && (af.this.xCU.equals(paramAnonymousString1))) {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(95708);
              af.this.qWn.AI(paramAnonymousLong1);
              AppMethodBeat.o(95708);
            }
          });
        }
        AppMethodBeat.o(202731);
      }
      
      public final void i(final String paramAnonymousString, final long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(95714);
        if ((af.this.qWn != null) && (af.this.xCU.equals(paramAnonymousString))) {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(95710);
              af.this.qWn.i(paramAnonymousString, paramAnonymousLong1, this.xCr);
              AppMethodBeat.o(95710);
            }
          });
        }
        AppMethodBeat.o(95714);
      }
      
      public final void onDataAvailable(final String paramAnonymousString, final long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(95713);
        if ((af.this.qWn != null) && (af.this.xCU.equals(paramAnonymousString))) {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(95709);
              af.this.qWn.onDataAvailable(paramAnonymousString, paramAnonymousLong1, this.mwP);
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
    this.qWn = parama;
  }
  
  public final void he(String paramString)
  {
    AppMethodBeat.i(95718);
    Log.i("MicroMsg.SnsAdStreamVideoProxy", "%s, stop stream[%s]", new Object[] { Integer.valueOf(hashCode()), paramString });
    if (this.xCU.equals(paramString)) {
      aj.faJ().aOM(paramString);
    }
    AppMethodBeat.o(95718);
  }
  
  public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    AppMethodBeat.i(95720);
    Log.d("MicroMsg.SnsAdStreamVideoProxy", "%s, check video data available[%s, %s, %s]", new Object[] { Integer.valueOf(hashCode()), paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.xCU.equals(paramString)) {
      bool = o.bhk().isVideoDataAvailable(paramString, paramInt1, paramInt2);
    }
    AppMethodBeat.o(95720);
    return bool;
  }
  
  public final void p(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(95717);
    this.xCU = paramString1;
    Log.i("MicroMsg.SnsAdStreamVideoProxy", "%s start http stream[%s, %s, %s]", new Object[] { Integer.valueOf(hashCode()), paramString1, paramString3, paramString2 });
    SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("sns_ad_download_resource_preferences", 0);
    boolean bool = localSharedPreferences.getBoolean(paramString1, false);
    if (s.YS(paramString2))
    {
      Log.i("MicroMsg.SnsAdStreamVideoProxy", "is already download %s", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        this.DJU.a(paramString1, 0, null);
        AppMethodBeat.o(95717);
      }
    }
    else if (bool)
    {
      Log.i("MicroMsg.SnsAdStreamVideoProxy", "last download file was deleted");
      localSharedPreferences.edit().putBoolean(paramString1, false).commit();
    }
    if (aj.faJ().aOP(paramString1))
    {
      Log.i("%s is already in downloading", paramString3);
      AppMethodBeat.o(95717);
      return;
    }
    aj.faJ().a(paramString1, paramString3, paramString2, this.DJU);
    AppMethodBeat.o(95717);
  }
  
  public final void requestVideoData(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95719);
    Log.d("MicroMsg.SnsAdStreamVideoProxy", "%s, request video data[%s, %s, %s]", new Object[] { Integer.valueOf(hashCode()), paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.xCU.equals(paramString))
    {
      o.bhk();
      e.r(paramString, paramInt1, paramInt2);
    }
    AppMethodBeat.o(95719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.af
 * JD-Core Version:    0.7.0.1
 */