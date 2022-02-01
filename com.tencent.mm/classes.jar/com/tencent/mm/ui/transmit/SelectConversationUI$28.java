package com.tencent.mm.ui.transmit;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c.h;
import com.tencent.xweb.util.d;

final class SelectConversationUI$28
  implements h
{
  SelectConversationUI$28(SelectConversationUI paramSelectConversationUI, View paramView, boolean[] paramArrayOfBoolean) {}
  
  public final Bitmap a(String paramString, View paramView, com.tencent.mm.av.a.d.b paramb)
  {
    return null;
  }
  
  public final void b(String paramString, View paramView) {}
  
  public final void b(String paramString, View paramView, com.tencent.mm.av.a.d.b paramb)
  {
    AppMethodBeat.i(234495);
    if ((paramb.bitmap != null) && (!paramb.bitmap.isRecycled()))
    {
      paramString = d.getMessageDigest(paramString.getBytes());
      paramView = com.tencent.mm.plugin.comm.b.qCp;
      com.tencent.mm.plugin.comm.b.a(this.QzH.getContext(), this.ECr, paramb.bitmap, paramString);
      AppMethodBeat.o(234495);
      return;
    }
    this.QzP[0] = true;
    AppMethodBeat.o(234495);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SelectConversationUI.28
 * JD-Core Version:    0.7.0.1
 */