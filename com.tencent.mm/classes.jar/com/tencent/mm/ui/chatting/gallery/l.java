package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.aw.d.a;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.HashSet;

public final class l
  implements d.a
{
  private static l GEk;
  HashSet<Long> GEl;
  d.a GEm;
  
  private l()
  {
    AppMethodBeat.i(36338);
    this.GEl = new HashSet();
    AppMethodBeat.o(36338);
  }
  
  public static l fad()
  {
    AppMethodBeat.i(36339);
    if (GEk == null) {
      GEk = new l();
    }
    l locall = GEk;
    AppMethodBeat.o(36339);
    return locall;
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(36343);
    if (this.GEm != null) {
      this.GEm.a(paramLong1, paramLong2, paramInt1, paramInt2, paramObject);
    }
    this.GEl.remove(Long.valueOf(paramLong2));
    AppMethodBeat.o(36343);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, n paramn)
  {
    AppMethodBeat.i(36341);
    if (this.GEm != null) {
      this.GEm.a(paramLong1, paramLong2, paramInt1, paramInt2, paramObject, paramInt3, paramInt4, paramn);
    }
    AppMethodBeat.o(36341);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, n paramn)
  {
    AppMethodBeat.i(36342);
    if (this.GEm != null) {
      this.GEm.a(paramLong1, paramLong2, paramInt1, paramInt2, paramObject, paramInt3, paramInt4, paramString, paramn);
    }
    for (;;)
    {
      this.GEl.remove(Long.valueOf(paramLong2));
      AppMethodBeat.o(36342);
      return;
      az.arV();
      paramObject = c.apO().rm(paramLong2);
      ad.i("MicroMsg.ImageHDDownloadAndSaveMgr", "[oreh download_and_save] hdImg end at background, msgLocalId:%d", new Object[] { Long.valueOf(paramObject.field_msgId) });
      b.d(aj.getContext(), paramObject, false);
    }
  }
  
  public final boolean wQ(long paramLong)
  {
    AppMethodBeat.i(36340);
    boolean bool = this.GEl.contains(Long.valueOf(paramLong));
    AppMethodBeat.o(36340);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.l
 * JD-Core Version:    0.7.0.1
 */