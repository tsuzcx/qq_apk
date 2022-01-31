package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.c.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class MediaHistoryGalleryUI$1
  extends a
{
  MediaHistoryGalleryUI$1(MediaHistoryGalleryUI paramMediaHistoryGalleryUI) {}
  
  public final void a(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    super.a(paramLong1, paramLong2, paramString, paramInt);
    y.d("MicroMsg.MediaHistoryGalleryUI", "summerhardcoder sync fps scene:%s vs %s, droppedFrames:%s, lastFrameNanos:%d, frameNanos:%d", new Object[] { paramString, this.vxK.getClass().getSimpleName(), Integer.valueOf(paramInt), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if ((paramInt > 0) && (!bk.bl(paramString)) && (paramString.endsWith(this.vxK.getClass().getSimpleName()))) {
      MediaHistoryGalleryUI.a(this.vxK, MediaHistoryGalleryUI.a(this.vxK) + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.MediaHistoryGalleryUI.1
 * JD-Core Version:    0.7.0.1
 */