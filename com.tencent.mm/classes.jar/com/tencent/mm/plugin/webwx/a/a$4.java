package com.tencent.mm.plugin.webwx.a;

import com.tencent.mm.ah.m;
import com.tencent.mm.as.d.a;
import com.tencent.mm.sdk.platformtools.y;

final class a$4
  implements d.a
{
  a$4(a parama) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, m paramm) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, m paramm)
  {
    y.i("MicroMsg.MultiTerminalSyncMgr", "download image msgid:%d, [%d,%d]", new Object[] { Long.valueOf(paramLong2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    if ((paramInt3 == 0) && (paramInt4 == 0)) {
      this.rDE.gV(paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.a.a.4
 * JD-Core Version:    0.7.0.1
 */