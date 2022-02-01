package com.tencent.mm.plugin.sns.ad.g;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.plugin.sns.ad.timeline.dynamic.b;
import com.tencent.mm.protocal.protobuf.bx;
import com.tencent.mm.protocal.protobuf.by;
import com.tencent.mm.protocal.protobuf.bz;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;

public final class c
  extends a<by, bz>
  implements com.tencent.mm.an.i
{
  b JGO;
  
  public c(String paramString1, String paramString2, bx[] paramArrayOfbx)
  {
    AppMethodBeat.i(245381);
    a(new by(), new bz(), "/cgi-bin/mmoc-bin/adplayinfo/ad_dynamic_update", 5012, new Object[] { paramString1, paramString2, paramArrayOfbx });
    AppMethodBeat.o(245381);
  }
  
  private void b(final int paramInt, final String paramString, final List<bx> paramList)
  {
    AppMethodBeat.i(245389);
    Log.d("SnsAd.AdDynamicUpdate", "onResponseFinish::the error code is " + paramInt + ", sns id " + paramString);
    final b localb = this.JGO;
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      if (localb != null)
      {
        localb.c(paramInt, paramString, paramList);
        AppMethodBeat.o(245389);
      }
    }
    else {
      com.tencent.e.h.ZvG.bc(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(204008);
          if (localb != null) {
            localb.c(paramInt, paramString, paramList);
          }
          AppMethodBeat.o(204008);
        }
      });
    }
    AppMethodBeat.o(245389);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(245383);
    com.tencent.mm.kernel.h.aGY().a(5012, this);
    com.tencent.mm.kernel.h.aGY().a(this, 0);
    this.JGO = paramb;
    AppMethodBeat.o(245383);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(245386);
    com.tencent.mm.kernel.h.aGY().b(5012, this);
    Log.d("SnsAd.AdDynamicUpdate", "onSceneEnd::the error type is " + paramInt1 + ", error code is " + paramInt2);
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramq instanceof c)))
    {
      paramString = (bz)((c)paramq).fKY();
      if (paramString != null)
      {
        b(0, paramString.RHs, paramString.RHu);
        AppMethodBeat.o(245386);
        return;
      }
    }
    b(-1, "", null);
    AppMethodBeat.o(245386);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.g.c
 * JD-Core Version:    0.7.0.1
 */