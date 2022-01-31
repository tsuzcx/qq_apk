package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.d.a;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashSet;

public final class l
  implements d.a
{
  private static l zNP;
  HashSet<Long> zNQ;
  d.a zNR;
  
  private l()
  {
    AppMethodBeat.i(32399);
    this.zNQ = new HashSet();
    AppMethodBeat.o(32399);
  }
  
  public static l dKQ()
  {
    AppMethodBeat.i(32400);
    if (zNP == null) {
      zNP = new l();
    }
    l locall = zNP;
    AppMethodBeat.o(32400);
    return locall;
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(32404);
    if (this.zNR != null) {
      this.zNR.a(paramLong1, paramLong2, paramInt1, paramInt2, paramObject);
    }
    this.zNQ.remove(Long.valueOf(paramLong2));
    AppMethodBeat.o(32404);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, m paramm)
  {
    AppMethodBeat.i(32402);
    if (this.zNR != null) {
      this.zNR.a(paramLong1, paramLong2, paramInt1, paramInt2, paramObject, paramInt3, paramInt4, paramm);
    }
    AppMethodBeat.o(32402);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, m paramm)
  {
    AppMethodBeat.i(32403);
    if (this.zNR != null) {
      this.zNR.a(paramLong1, paramLong2, paramInt1, paramInt2, paramObject, paramInt3, paramInt4, paramString, paramm);
    }
    for (;;)
    {
      this.zNQ.remove(Long.valueOf(paramLong2));
      AppMethodBeat.o(32403);
      return;
      aw.aaz();
      paramObject = com.tencent.mm.model.c.YC().kB(paramLong2);
      ab.i("MicroMsg.ImageHDDownloadAndSaveMgr", "[oreh download_and_save] hdImg end at background, msgLocalId:%d", new Object[] { Long.valueOf(paramObject.field_msgId) });
      c.b(ah.getContext(), paramObject, false);
    }
  }
  
  public final boolean oO(long paramLong)
  {
    AppMethodBeat.i(32401);
    boolean bool = this.zNQ.contains(Long.valueOf(paramLong));
    AppMethodBeat.o(32401);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.l
 * JD-Core Version:    0.7.0.1
 */