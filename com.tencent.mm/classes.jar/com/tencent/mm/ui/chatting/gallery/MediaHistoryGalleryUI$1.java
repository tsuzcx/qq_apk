package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.e.b;
import com.tencent.mm.sdk.platformtools.bo;

final class MediaHistoryGalleryUI$1
  extends b
{
  MediaHistoryGalleryUI$1(MediaHistoryGalleryUI paramMediaHistoryGalleryUI) {}
  
  public final void a(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(32405);
    super.a(paramString, paramLong, paramInt);
    if ((paramInt > 0) && (!bo.isNullOrNil(paramString)) && (paramString.endsWith(this.zNW.getClass().getSimpleName()))) {
      MediaHistoryGalleryUI.a(this.zNW, MediaHistoryGalleryUI.a(this.zNW) + paramInt);
    }
    AppMethodBeat.o(32405);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.MediaHistoryGalleryUI.1
 * JD-Core Version:    0.7.0.1
 */