package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.ah.m;
import com.tencent.mm.as.d.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;

public final class l
  implements d.a
{
  private static l vxD;
  HashSet<Long> vxE = new HashSet();
  d.a vxF;
  
  public static l cGI()
  {
    if (vxD == null) {
      vxD = new l();
    }
    return vxD;
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject)
  {
    if (this.vxF != null) {
      this.vxF.a(paramLong1, paramLong2, paramInt1, paramInt2, paramObject);
    }
    this.vxE.remove(Long.valueOf(paramLong2));
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, m paramm)
  {
    if (this.vxF != null) {
      this.vxF.a(paramLong1, paramLong2, paramInt1, paramInt2, paramObject, paramInt3, paramInt4, paramm);
    }
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, m paramm)
  {
    if (this.vxF != null) {
      this.vxF.a(paramLong1, paramLong2, paramInt1, paramInt2, paramObject, paramInt3, paramInt4, paramString, paramm);
    }
    for (;;)
    {
      this.vxE.remove(Long.valueOf(paramLong2));
      return;
      au.Hx();
      paramObject = com.tencent.mm.model.c.Fy().fd(paramLong2);
      y.i("MicroMsg.ImageHDDownloadAndSaveMgr", "[oreh download_and_save] hdImg end at background, msgLocalId:%d", new Object[] { Long.valueOf(paramObject.field_msgId) });
      c.b(ae.getContext(), paramObject, false);
    }
  }
  
  public final boolean ic(long paramLong)
  {
    return this.vxE.contains(Long.valueOf(paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.l
 * JD-Core Version:    0.7.0.1
 */