package com.tencent.mm.plugin.sns.ui;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c.h;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.xweb.util.d;

final class SnsCommentDetailUI$30
  implements h
{
  SnsCommentDetailUI$30(SnsCommentDetailUI paramSnsCommentDetailUI, View paramView) {}
  
  public final Bitmap a(String paramString, View paramView, com.tencent.mm.av.a.d.b paramb)
  {
    return null;
  }
  
  public final void b(String paramString, View paramView) {}
  
  public final void b(String paramString, View paramView, com.tencent.mm.av.a.d.b paramb)
  {
    AppMethodBeat.i(203525);
    if ((paramb.bitmap != null) && (!paramb.bitmap.isRecycled()))
    {
      paramString = d.getMessageDigest(paramString.getBytes());
      paramView = com.tencent.mm.plugin.comm.b.qCp;
      com.tencent.mm.plugin.comm.b.a(MMApplicationContext.getContext(), this.ECr, paramb.bitmap, paramString);
    }
    AppMethodBeat.o(203525);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.30
 * JD-Core Version:    0.7.0.1
 */