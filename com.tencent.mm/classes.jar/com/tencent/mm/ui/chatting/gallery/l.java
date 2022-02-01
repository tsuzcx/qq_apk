package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.av.d.a;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.HashSet;

public final class l
  implements d.a
{
  private static l Ieh;
  HashSet<Long> Iei;
  d.a Iej;
  
  private l()
  {
    AppMethodBeat.i(36338);
    this.Iei = new HashSet();
    AppMethodBeat.o(36338);
  }
  
  public static l fpT()
  {
    AppMethodBeat.i(36339);
    if (Ieh == null) {
      Ieh = new l();
    }
    l locall = Ieh;
    AppMethodBeat.o(36339);
    return locall;
  }
  
  public final boolean Bt(long paramLong)
  {
    AppMethodBeat.i(36340);
    boolean bool = this.Iei.contains(Long.valueOf(paramLong));
    AppMethodBeat.o(36340);
    return bool;
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(36343);
    if (this.Iej != null) {
      this.Iej.a(paramLong1, paramLong2, paramInt1, paramInt2, paramObject);
    }
    this.Iei.remove(Long.valueOf(paramLong2));
    AppMethodBeat.o(36343);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, n paramn)
  {
    AppMethodBeat.i(36341);
    if (this.Iej != null) {
      this.Iej.a(paramLong1, paramLong2, paramInt1, paramInt2, paramObject, paramInt3, paramInt4, paramn);
    }
    AppMethodBeat.o(36341);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, n paramn)
  {
    AppMethodBeat.i(36342);
    if (this.Iej != null) {
      this.Iej.a(paramLong1, paramLong2, paramInt1, paramInt2, paramObject, paramInt3, paramInt4, paramString, paramn);
    }
    for (;;)
    {
      this.Iei.remove(Long.valueOf(paramLong2));
      AppMethodBeat.o(36342);
      return;
      az.ayM();
      paramObject = c.awD().vP(paramLong2);
      ac.i("MicroMsg.ImageHDDownloadAndSaveMgr", "[oreh download_and_save] hdImg end at background, msgLocalId:%d", new Object[] { Long.valueOf(paramObject.field_msgId) });
      b.d(ai.getContext(), paramObject, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.l
 * JD-Core Version:    0.7.0.1
 */