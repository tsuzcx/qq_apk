package com.tencent.mm.plugin.sns.ui.item;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c.h;
import com.tencent.mm.ay.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.xweb.util.d;

final class j$1
  implements h
{
  j$1(j paramj, TimeLineObject paramTimeLineObject, String paramString, j.a parama) {}
  
  public final Bitmap a(String paramString, View paramView, com.tencent.mm.av.a.d.b paramb)
  {
    return null;
  }
  
  public final void b(String paramString, View paramView) {}
  
  public final void b(String paramString, View paramView, com.tencent.mm.av.a.d.b paramb)
  {
    AppMethodBeat.i(203930);
    if ((paramb.bitmap != null) && (!paramb.bitmap.isRecycled()))
    {
      ((a)g.af(a.class)).bw(this.ECp.Id, this.EYO);
      paramString = d.getMessageDigest(paramString.getBytes());
      paramView = com.tencent.mm.plugin.comm.b.qCp;
      com.tencent.mm.plugin.comm.b.a(MMApplicationContext.getContext(), this.EYP.EYU, paramb.bitmap, paramString);
    }
    AppMethodBeat.o(203930);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.j.1
 * JD-Core Version:    0.7.0.1
 */