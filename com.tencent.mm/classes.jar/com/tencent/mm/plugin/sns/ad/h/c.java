package com.tencent.mm.plugin.sns.ad.h;

import android.os.Looper;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.ad.timeline.dynamic.b;
import com.tencent.mm.protocal.protobuf.bz;
import com.tencent.mm.protocal.protobuf.ca;
import com.tencent.mm.protocal.protobuf.cb;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;

public final class c
  extends a<ca, cb>
  implements com.tencent.mm.ak.i
{
  b Dxh;
  
  public c(String paramString1, String paramString2, bz[] paramArrayOfbz)
  {
    AppMethodBeat.i(202057);
    a(new ca(), new cb(), "/cgi-bin/mmoc-bin/adplayinfo/ad_dynamic_update", 5012, new Object[] { paramString1, paramString2, paramArrayOfbz });
    AppMethodBeat.o(202057);
  }
  
  private void b(final int paramInt, final String paramString, final List<bz> paramList)
  {
    AppMethodBeat.i(202060);
    Log.d("SnsAd.AdDynamicUpdate", "onResponseFinish::the error code is " + paramInt + ", sns id " + paramString);
    final b localb = this.Dxh;
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      if (localb != null)
      {
        localb.c(paramInt, paramString, paramList);
        AppMethodBeat.o(202060);
      }
    }
    else {
      h.RTc.aV(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(202056);
          if (localb != null) {
            localb.c(paramInt, paramString, paramList);
          }
          AppMethodBeat.o(202056);
        }
      });
    }
    AppMethodBeat.o(202060);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(202058);
    g.azz().a(5012, this);
    g.azz().a(this, 0);
    this.Dxh = paramb;
    AppMethodBeat.o(202058);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(202059);
    g.azz().b(5012, this);
    Log.d("SnsAd.AdDynamicUpdate", "onSceneEnd::the error type is " + paramInt1 + ", error code is " + paramInt2);
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramq instanceof c)))
    {
      paramString = (cb)((c)paramq).eXx();
      if (paramString != null)
      {
        b(0, paramString.KFZ, paramString.KGb);
        AppMethodBeat.o(202059);
        return;
      }
    }
    b(-1, "", null);
    AppMethodBeat.o(202059);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.h.c
 * JD-Core Version:    0.7.0.1
 */