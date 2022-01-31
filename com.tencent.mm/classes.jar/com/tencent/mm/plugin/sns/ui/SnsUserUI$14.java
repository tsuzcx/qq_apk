package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.c.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class SnsUserUI$14
  extends a
{
  SnsUserUI$14(SnsUserUI paramSnsUserUI) {}
  
  public final void a(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    super.a(paramLong1, paramLong2, paramString, paramInt);
    y.d("MicroMsg.SnsUserUI", "summerhardcoder sync fps scene:%s vs %s, droppedFrames:%s, lastFrameNanos:%d, frameNanos:%d", new Object[] { paramString, this.pjB.getClass().getSimpleName(), Integer.valueOf(paramInt), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if ((paramInt > 0) && (!bk.bl(paramString)) && (paramString.endsWith(this.pjB.getClass().getSimpleName()))) {
      SnsUserUI.a(this.pjB, SnsUserUI.j(this.pjB) + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUserUI.14
 * JD-Core Version:    0.7.0.1
 */