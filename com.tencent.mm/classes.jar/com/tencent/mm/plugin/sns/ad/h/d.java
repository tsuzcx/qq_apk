package com.tencent.mm.plugin.sns.ad.h;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.plugin.sns.ad.timeline.dynamic.b;
import com.tencent.mm.protocal.protobuf.ch;
import com.tencent.mm.protocal.protobuf.ci;
import com.tencent.mm.protocal.protobuf.cj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.i;
import java.util.List;

public final class d
  extends a<ci, cj>
  implements com.tencent.mm.am.h
{
  b PXO;
  
  public d(String paramString1, String paramString2, ch[] paramArrayOfch)
  {
    AppMethodBeat.i(309870);
    a(new ci(), new cj(), "/cgi-bin/mmoc-bin/adplayinfo/ad_dynamic_update", 5012, new Object[] { paramString1, paramString2, paramArrayOfch });
    AppMethodBeat.o(309870);
  }
  
  private void b(final int paramInt, final String paramString, final List<ch> paramList)
  {
    AppMethodBeat.i(309877);
    Log.d("SnsAd.AdDynamicUpdate", "onResponseFinish::the error code is " + paramInt + ", sns id " + paramString);
    final b localb = this.PXO;
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      if (localb != null)
      {
        localb.c(paramInt, paramString, paramList);
        AppMethodBeat.o(309877);
      }
    }
    else {
      com.tencent.threadpool.h.ahAA.bk(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(309878);
          if (localb != null) {
            localb.c(paramInt, paramString, paramList);
          }
          AppMethodBeat.o(309878);
        }
      });
    }
    AppMethodBeat.o(309877);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(309880);
    com.tencent.mm.kernel.h.aZW().a(5012, this);
    com.tencent.mm.kernel.h.aZW().a(this, 0);
    this.PXO = paramb;
    AppMethodBeat.o(309880);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(309883);
    com.tencent.mm.kernel.h.aZW().b(5012, this);
    Log.d("SnsAd.AdDynamicUpdate", "onSceneEnd::the error type is " + paramInt1 + ", error code is " + paramInt2);
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramp instanceof d)))
    {
      paramString = (cj)((d)paramp).hbp();
      if (paramString != null)
      {
        b(0, paramString.YEv, paramString.YEx);
        AppMethodBeat.o(309883);
        return;
      }
    }
    b(-1, "", null);
    AppMethodBeat.o(309883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.h.d
 * JD-Core Version:    0.7.0.1
 */