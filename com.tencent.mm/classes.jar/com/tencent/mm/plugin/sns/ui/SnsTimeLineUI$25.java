package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.c.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class SnsTimeLineUI$25
  extends a
{
  SnsTimeLineUI$25(SnsTimeLineUI paramSnsTimeLineUI) {}
  
  public final void a(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    super.a(paramLong1, paramLong2, paramString, paramInt);
    y.d("MicroMsg.SnsTimeLineUI", "summerhardcoder sync fps scene:%s vs %s, droppedFrames:%s, lastFrameNanos:%d, frameNanos:%d", new Object[] { paramString, this.pfC.getClass().getSimpleName(), Integer.valueOf(paramInt), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if ((paramInt > 0) && (!bk.bl(paramString)) && (paramString.endsWith(this.pfC.getClass().getSimpleName()))) {
      SnsTimeLineUI.b(this.pfC, SnsTimeLineUI.B(this.pfC) + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.25
 * JD-Core Version:    0.7.0.1
 */