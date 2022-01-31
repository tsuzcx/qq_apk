package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.c.i;

final class f$1
  implements i
{
  public final void a(String paramString, View paramView, Bitmap paramBitmap, Object... paramVarArgs)
  {
    AppMethodBeat.i(32876);
    if ((paramBitmap != null) && (paramString.equals(paramView.getTag(2131824346)))) {
      paramView.setBackground(f.aq(paramBitmap));
    }
    AppMethodBeat.o(32876);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.f.1
 * JD-Core Version:    0.7.0.1
 */