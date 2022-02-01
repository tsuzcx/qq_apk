package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.aw.e.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.HashSet;

public final class l
  implements e.a
{
  private static l JTI;
  HashSet<Long> JTJ;
  e.a JTK;
  
  private l()
  {
    AppMethodBeat.i(36338);
    this.JTJ = new HashSet();
    AppMethodBeat.o(36338);
  }
  
  public static l fGC()
  {
    AppMethodBeat.i(36339);
    if (JTI == null) {
      JTI = new l();
    }
    l locall = JTI;
    AppMethodBeat.o(36339);
    return locall;
  }
  
  public final boolean El(long paramLong)
  {
    AppMethodBeat.i(36340);
    boolean bool = this.JTJ.contains(Long.valueOf(paramLong));
    AppMethodBeat.o(36340);
    return bool;
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(36343);
    if (this.JTK != null) {
      this.JTK.a(paramLong1, paramLong2, paramInt1, paramInt2, paramObject);
    }
    this.JTJ.remove(Long.valueOf(paramLong2));
    AppMethodBeat.o(36343);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, n paramn)
  {
    AppMethodBeat.i(36341);
    if (this.JTK != null) {
      this.JTK.a(paramLong1, paramLong2, paramInt1, paramInt2, paramObject, paramInt3, paramInt4, paramn);
    }
    AppMethodBeat.o(36341);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, n paramn)
  {
    AppMethodBeat.i(36342);
    if (this.JTK != null) {
      this.JTK.a(paramLong1, paramLong2, paramInt1, paramInt2, paramObject, paramInt3, paramInt4, paramString, paramn);
    }
    for (;;)
    {
      this.JTJ.remove(Long.valueOf(paramLong2));
      AppMethodBeat.o(36342);
      return;
      ba.aBQ();
      paramObject = c.azs().xY(paramLong2);
      ad.i("MicroMsg.ImageHDDownloadAndSaveMgr", "[oreh download_and_save] hdImg end at background, msgLocalId:%d", new Object[] { Long.valueOf(paramObject.field_msgId) });
      b.d(aj.getContext(), paramObject, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.l
 * JD-Core Version:    0.7.0.1
 */