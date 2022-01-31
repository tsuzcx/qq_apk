package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.c.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class SnsMsgUI$10
  extends a
{
  SnsMsgUI$10(SnsMsgUI paramSnsMsgUI) {}
  
  public final void a(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    super.a(paramLong1, paramLong2, paramString, paramInt);
    y.d("MicroMsg.SnsMsgUI", "summerhardcoder sync fps scene:%s vs %s, droppedFrames:%s, lastFrameNanos:%d, frameNanos:%d", new Object[] { paramString, this.paq.getClass().getSimpleName(), Integer.valueOf(paramInt), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if ((paramInt > 0) && (!bk.bl(paramString)) && (paramString.endsWith(this.paq.getClass().getSimpleName()))) {
      SnsMsgUI.a(this.paq, SnsMsgUI.b(this.paq) + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI.10
 * JD-Core Version:    0.7.0.1
 */