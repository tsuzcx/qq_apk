package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.e.a;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashSet;

public final class q
  implements e.a
{
  private static q WWi;
  HashSet<Long> WWj;
  e.a WWk;
  
  private q()
  {
    AppMethodBeat.i(36338);
    this.WWj = new HashSet();
    AppMethodBeat.o(36338);
  }
  
  public static q hSM()
  {
    AppMethodBeat.i(36339);
    if (WWi == null) {
      WWi = new q();
    }
    q localq = WWi;
    AppMethodBeat.o(36339);
    return localq;
  }
  
  public final boolean We(long paramLong)
  {
    AppMethodBeat.i(36340);
    boolean bool = this.WWj.contains(Long.valueOf(paramLong));
    AppMethodBeat.o(36340);
    return bool;
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(36343);
    if (this.WWk != null) {
      this.WWk.a(paramLong1, paramLong2, paramInt1, paramInt2, paramObject);
    }
    this.WWj.remove(Long.valueOf(paramLong2));
    AppMethodBeat.o(36343);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(36341);
    if (this.WWk != null) {
      this.WWk.a(paramLong1, paramLong2, paramInt1, paramInt2, paramObject, paramInt3, paramInt4, paramq);
    }
    AppMethodBeat.o(36341);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(36342);
    if (this.WWk != null) {
      this.WWk.a(paramLong1, paramLong2, paramInt1, paramInt2, paramObject, paramInt3, paramInt4, paramString, paramq);
    }
    for (;;)
    {
      this.WWj.remove(Long.valueOf(paramLong2));
      AppMethodBeat.o(36342);
      return;
      bh.beI();
      paramObject = c.bbO().Oq(paramLong2);
      Log.i("MicroMsg.ImageHDDownloadAndSaveMgr", "[oreh download_and_save] hdImg end at background, msgLocalId:%d", new Object[] { Long.valueOf(paramObject.field_msgId) });
      f.d(MMApplicationContext.getContext(), paramObject, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.q
 * JD-Core Version:    0.7.0.1
 */