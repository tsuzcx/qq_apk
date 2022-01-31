package com.tencent.mm.ui.chatting.i;

import android.support.v7.widget.GridLayoutManager.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.chatting.a.b.c;
import java.util.ArrayList;

final class e$1
  extends GridLayoutManager.b
{
  e$1(e parame) {}
  
  public final int bF(int paramInt)
  {
    AppMethodBeat.i(32552);
    if (((b.c)e.a(this.zPs).get(paramInt)).type == 2147483647)
    {
      AppMethodBeat.o(32552);
      return 4;
    }
    AppMethodBeat.o(32552);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.i.e.1
 * JD-Core Version:    0.7.0.1
 */