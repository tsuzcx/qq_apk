package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.av.e.a;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashSet;

public final class l
  implements e.a
{
  private static l PBl;
  HashSet<Long> PBm;
  e.a PBn;
  
  private l()
  {
    AppMethodBeat.i(36338);
    this.PBm = new HashSet();
    AppMethodBeat.o(36338);
  }
  
  public static l gTf()
  {
    AppMethodBeat.i(36339);
    if (PBl == null) {
      PBl = new l();
    }
    l locall = PBl;
    AppMethodBeat.o(36339);
    return locall;
  }
  
  public final boolean NS(long paramLong)
  {
    AppMethodBeat.i(36340);
    boolean bool = this.PBm.contains(Long.valueOf(paramLong));
    AppMethodBeat.o(36340);
    return bool;
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(36343);
    if (this.PBn != null) {
      this.PBn.a(paramLong1, paramLong2, paramInt1, paramInt2, paramObject);
    }
    this.PBm.remove(Long.valueOf(paramLong2));
    AppMethodBeat.o(36343);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, q paramq)
  {
    AppMethodBeat.i(36341);
    if (this.PBn != null) {
      this.PBn.a(paramLong1, paramLong2, paramInt1, paramInt2, paramObject, paramInt3, paramInt4, paramq);
    }
    AppMethodBeat.o(36341);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, q paramq)
  {
    AppMethodBeat.i(36342);
    if (this.PBn != null) {
      this.PBn.a(paramLong1, paramLong2, paramInt1, paramInt2, paramObject, paramInt3, paramInt4, paramString, paramq);
    }
    for (;;)
    {
      this.PBm.remove(Long.valueOf(paramLong2));
      AppMethodBeat.o(36342);
      return;
      bg.aVF();
      paramObject = c.aSQ().Hb(paramLong2);
      Log.i("MicroMsg.ImageHDDownloadAndSaveMgr", "[oreh download_and_save] hdImg end at background, msgLocalId:%d", new Object[] { Long.valueOf(paramObject.field_msgId) });
      b.d(MMApplicationContext.getContext(), paramObject, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.l
 * JD-Core Version:    0.7.0.1
 */