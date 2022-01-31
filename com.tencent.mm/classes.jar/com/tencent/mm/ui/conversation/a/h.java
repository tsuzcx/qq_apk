package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  public h(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(34656);
    if (this.view != null) {
      this.view.findViewById(2131823965).setOnClickListener(new h.1(this));
    }
    AppMethodBeat.o(34656);
  }
  
  public final void destroy() {}
  
  public final int getLayoutId()
  {
    AppMethodBeat.i(34657);
    com.tencent.mm.au.b.aif();
    AppMethodBeat.o(34657);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.h
 * JD-Core Version:    0.7.0.1
 */