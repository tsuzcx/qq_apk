package com.tencent.mm.pluginsdk;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ao.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

final class e$3
  implements ao.b.a
{
  e$3(Intent paramIntent, Context paramContext) {}
  
  public final void p(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(11657);
    if (!paramBoolean)
    {
      ab.e("MicroMsg.DeepLinkHelper", "getContact fail, %s", new Object[] { paramString });
      AppMethodBeat.o(11657);
      return;
    }
    this.val$intent.putExtra("Chat_User", paramString);
    try
    {
      if (this.val$context != null)
      {
        this.val$context.startActivity(this.val$intent);
        AppMethodBeat.o(11657);
        return;
      }
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace("MicroMsg.DeepLinkHelper", paramString, "", new Object[] { "" });
      AppMethodBeat.o(11657);
      return;
    }
    ah.getContext().startActivity(this.val$intent);
    AppMethodBeat.o(11657);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.e.3
 * JD-Core Version:    0.7.0.1
 */