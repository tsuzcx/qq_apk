package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h.c;

final class ComposeUI$8$1
  implements h.c
{
  ComposeUI$8$1(ComposeUI.8 param8) {}
  
  public final void iA(int paramInt)
  {
    AppMethodBeat.i(68175);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(68175);
      return;
      boolean bool = b.a(this.pMa.pLX.getContext(), "android.permission.CAMERA", 16, "", "");
      ab.i("MicroMsg.ComposeUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bo.dtY(), this.pMa.pLX.getContext() });
      if (!bool)
      {
        AppMethodBeat.o(68175);
        return;
      }
      ComposeUI.C(this.pMa.pLX);
      AppMethodBeat.o(68175);
      return;
      n.a(this.pMa.pLX, 4, null);
      AppMethodBeat.o(68175);
      return;
      Intent localIntent = new Intent(this.pMa.pLX, FileExplorerUI.class);
      this.pMa.pLX.startActivityForResult(localIntent, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI.8.1
 * JD-Core Version:    0.7.0.1
 */