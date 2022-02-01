package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.modelimage.f.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashSet;

public final class s
  implements f.a
{
  private static s aeFO;
  HashSet<Long> aeFP;
  f.a aeFQ;
  
  private s()
  {
    AppMethodBeat.i(36338);
    this.aeFP = new HashSet();
    AppMethodBeat.o(36338);
  }
  
  public static s jwr()
  {
    AppMethodBeat.i(36339);
    if (aeFO == null) {
      aeFO = new s();
    }
    s locals = aeFO;
    AppMethodBeat.o(36339);
    return locals;
  }
  
  public final boolean Ap(long paramLong)
  {
    AppMethodBeat.i(36340);
    boolean bool = this.aeFP.contains(Long.valueOf(paramLong));
    AppMethodBeat.o(36340);
    return bool;
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(36343);
    if (this.aeFQ != null) {
      this.aeFQ.a(paramLong1, paramLong2, paramInt1, paramInt2, paramObject);
    }
    this.aeFP.remove(Long.valueOf(paramLong2));
    AppMethodBeat.o(36343);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, p paramp)
  {
    AppMethodBeat.i(36341);
    if (this.aeFQ != null) {
      this.aeFQ.a(paramLong1, paramLong2, paramInt1, paramInt2, paramObject, paramInt3, paramInt4, paramp);
    }
    AppMethodBeat.o(36341);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, p paramp)
  {
    AppMethodBeat.i(36342);
    if (this.aeFQ != null) {
      this.aeFQ.a(paramLong1, paramLong2, paramInt1, paramInt2, paramObject, paramInt3, paramInt4, paramString, paramp);
    }
    for (;;)
    {
      this.aeFP.remove(Long.valueOf(paramLong2));
      AppMethodBeat.o(36342);
      return;
      bh.bCz();
      paramObject = c.bzD().sl(paramLong2);
      Log.i("MicroMsg.ImageHDDownloadAndSaveMgr", "[oreh download_and_save] hdImg end at background, msgLocalId:%d", new Object[] { Long.valueOf(paramObject.field_msgId) });
      h.c(MMApplicationContext.getContext(), paramObject, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.s
 * JD-Core Version:    0.7.0.1
 */