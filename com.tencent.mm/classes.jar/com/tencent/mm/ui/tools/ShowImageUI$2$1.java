package com.tencent.mm.ui.tools;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.pluginsdk.model.e;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h.d;

final class ShowImageUI$2$1
  implements h.d
{
  ShowImageUI$2$1(ShowImageUI.2 param2) {}
  
  public final void ca(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(34992);
    switch (paramInt2)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(34992);
      return;
      ShowImageUI.b(this.AxO.AxN);
      AppMethodBeat.o(34992);
      return;
      ShowImageUI localShowImageUI = this.AxO.AxN;
      cm localcm = new cm();
      long l = localShowImageUI.getIntent().getLongExtra("key_message_id", -1L);
      if (-1L == l)
      {
        ab.w("MicroMsg.ShowImageUI", "msg id error, try fav simple data");
        e.a(localcm, localShowImageUI.getIntent().getIntExtra("key_favorite_source_type", 1), localShowImageUI.getIntent().getStringExtra("key_image_path"));
      }
      for (;;)
      {
        localcm.cpR.activity = localShowImageUI;
        a.ymk.l(localcm);
        AppMethodBeat.o(34992);
        return;
        e.a(localcm, l);
      }
      ShowImageUI.c(this.AxO.AxN);
      AppMethodBeat.o(34992);
      return;
      ShowImageUI.d(this.AxO.AxN);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ShowImageUI.2.1
 * JD-Core Version:    0.7.0.1
 */