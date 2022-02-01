package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.modelimage.loader.b.k;

final class g$1
  implements k
{
  public final void onImageLoadComplete(String paramString, View paramView, Bitmap paramBitmap, Object... paramVarArgs)
  {
    AppMethodBeat.i(36860);
    if ((paramBitmap != null) && (paramString.equals(paramView.getTag(R.h.tag_1)))) {
      paramView.setBackground(g.bf(paramBitmap));
    }
    AppMethodBeat.o(36860);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.g.1
 * JD-Core Version:    0.7.0.1
 */