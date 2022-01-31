package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.model.as;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h.d;

final class j$7
  implements h.d
{
  j$7(j paramj) {}
  
  public final void ca(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(7648);
    switch (paramInt2)
    {
    default: 
      ab.i("MicroMsg.WebViewMenuHelper", "do del cancel");
      AppMethodBeat.o(7648);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putLong("fav_local_id", this.vcO.ddt().getIntent().getLongExtra("fav_local_id", -1L));
    try
    {
      if (this.vcO.ddt().igU.aj(localBundle))
      {
        ab.i("MicroMsg.WebViewMenuHelper", "del fav web url ok, finish webview ui");
        this.vcO.ddt().uVh.r("mm_del_fav", Boolean.TRUE);
        this.vcO.ddt().finish();
        AppMethodBeat.o(7648);
        return;
      }
      ab.w("MicroMsg.WebViewMenuHelper", "try to del web url fail");
      AppMethodBeat.o(7648);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.WebViewMenuHelper", localException, "", new Object[0]);
      ab.e("MicroMsg.WebViewMenuHelper", "try to del web url crash");
      AppMethodBeat.o(7648);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.j.7
 * JD-Core Version:    0.7.0.1
 */