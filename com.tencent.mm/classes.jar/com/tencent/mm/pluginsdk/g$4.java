package com.tencent.mm.pluginsdk;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ay.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class g$4
  implements ay.b.a
{
  g$4(Intent paramIntent, Context paramContext) {}
  
  public final void p(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(212214);
    if (!paramBoolean)
    {
      Log.e("MicroMsg.DeepLinkHelper", "getContact fail, %s", new Object[] { paramString });
      AppMethodBeat.o(212214);
      return;
    }
    this.val$intent.putExtra("Chat_User", paramString);
    try
    {
      if (this.val$context != null)
      {
        paramString = this.val$context;
        localObject = this.val$intent;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/pluginsdk/DeepLinkHelper$4", "getContactCallBack", "(Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/pluginsdk/DeepLinkHelper$4", "getContactCallBack", "(Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(212214);
        return;
      }
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.DeepLinkHelper", paramString, "", new Object[] { "" });
      AppMethodBeat.o(212214);
      return;
    }
    paramString = MMApplicationContext.getContext();
    Object localObject = this.val$intent;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/pluginsdk/DeepLinkHelper$4", "getContactCallBack", "(Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/pluginsdk/DeepLinkHelper$4", "getContactCallBack", "(Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(212214);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.4
 * JD-Core Version:    0.7.0.1
 */