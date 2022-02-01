package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.av.e.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashSet;

public final class l
  implements e.a
{
  private static l Kpi;
  HashSet<Long> Kpj;
  e.a Kpk;
  
  private l()
  {
    AppMethodBeat.i(36338);
    this.Kpj = new HashSet();
    AppMethodBeat.o(36338);
  }
  
  public static l fKN()
  {
    AppMethodBeat.i(36339);
    if (Kpi == null) {
      Kpi = new l();
    }
    l locall = Kpi;
    AppMethodBeat.o(36339);
    return locall;
  }
  
  public final boolean EN(long paramLong)
  {
    AppMethodBeat.i(36340);
    boolean bool = this.Kpj.contains(Long.valueOf(paramLong));
    AppMethodBeat.o(36340);
    return bool;
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(36343);
    if (this.Kpk != null) {
      this.Kpk.a(paramLong1, paramLong2, paramInt1, paramInt2, paramObject);
    }
    this.Kpj.remove(Long.valueOf(paramLong2));
    AppMethodBeat.o(36343);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, n paramn)
  {
    AppMethodBeat.i(36341);
    if (this.Kpk != null) {
      this.Kpk.a(paramLong1, paramLong2, paramInt1, paramInt2, paramObject, paramInt3, paramInt4, paramn);
    }
    AppMethodBeat.o(36341);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, n paramn)
  {
    AppMethodBeat.i(36342);
    if (this.Kpk != null) {
      this.Kpk.a(paramLong1, paramLong2, paramInt1, paramInt2, paramObject, paramInt3, paramInt4, paramString, paramn);
    }
    for (;;)
    {
      this.Kpj.remove(Long.valueOf(paramLong2));
      AppMethodBeat.o(36342);
      return;
      bc.aCg();
      paramObject = c.azI().ys(paramLong2);
      ae.i("MicroMsg.ImageHDDownloadAndSaveMgr", "[oreh download_and_save] hdImg end at background, msgLocalId:%d", new Object[] { Long.valueOf(paramObject.field_msgId) });
      b.d(ak.getContext(), paramObject, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.l
 * JD-Core Version:    0.7.0.1
 */