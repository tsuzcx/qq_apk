package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;

final class av$1
  implements ao.b.a
{
  av$1(av.a parama, String paramString1, Context paramContext, String paramString2) {}
  
  public final void p(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(6802);
    ab.i("MicroMsg.WebviewShrotcutManager", "getContactCallBack, suc = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      if (this.uXm != null)
      {
        this.uXm.ia(false);
        AppMethodBeat.o(6802);
      }
    }
    else
    {
      paramString = ((j)g.E(j.class)).YA().arw(this.efI);
      if ((paramString == null) || (bo.isNullOrNil(paramString.Oe())))
      {
        if (this.uXm != null)
        {
          this.uXm.ia(false);
          AppMethodBeat.o(6802);
        }
      }
      else {
        av.a(this.val$context, this.efI, this.hye, paramString.Oe(), this.uXm);
      }
    }
    AppMethodBeat.o(6802);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.av.1
 * JD-Core Version:    0.7.0.1
 */