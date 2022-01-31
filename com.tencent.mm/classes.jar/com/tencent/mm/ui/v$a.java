package com.tencent.mm.ui;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.h.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.network.ac;
import com.tencent.mm.pluginsdk.ui.tools.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;

public final class v$a
{
  public static boolean a(Context paramContext, int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    AppMethodBeat.i(29608);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(29608);
      return false;
      if (((paramInt3 & 0x2) != 0) && (aw.Rc().adu()))
      {
        aw.Rc().getNetworkServerIp();
        new StringBuilder().append(paramInt2);
      }
      for (;;)
      {
        AppMethodBeat.o(29608);
        return true;
        if ((((paramInt3 & 0x1) == 0) || (!ac.cm(paramContext)) || (!h.fY(paramContext))) && (((paramInt3 & 0x4) == 0) || (!at.isWap(paramContext)) || (!MMAppMgr.hJ(paramContext)))) {
          Toast.makeText(paramContext, paramContext.getString(2131300043, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt2) }), 1).show();
        }
      }
      Toast.makeText(paramContext, paramContext.getString(2131300044, new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt2) }), 1).show();
      AppMethodBeat.o(29608);
      return true;
      AppMethodBeat.o(29608);
      return true;
      a locala = a.kO(paramString);
      if (locala != null)
      {
        ab.i("MicroMsg.MMErrorProcessor", "summertips errCode[%d], showType[%d], url[%s], desc[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(locala.showType), locala.url, locala.desc });
        if (!bo.isNullOrNil(locala.url)) {}
        for (paramString = new v.a.1(locala, paramContext); locala.a(paramContext, paramString, null); paramString = null)
        {
          AppMethodBeat.o(29608);
          return true;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.v.a
 * JD-Core Version:    0.7.0.1
 */