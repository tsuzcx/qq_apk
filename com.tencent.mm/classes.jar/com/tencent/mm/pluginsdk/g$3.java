package com.tencent.mm.pluginsdk;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.as.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

final class g$3
  implements as.b.a
{
  g$3(Intent paramIntent, Context paramContext) {}
  
  public final void p(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(124345);
    if (!paramBoolean)
    {
      ad.e("MicroMsg.DeepLinkHelper", "getContact fail, %s", new Object[] { paramString });
      AppMethodBeat.o(124345);
      return;
    }
    this.val$intent.putExtra("Chat_User", paramString);
    try
    {
      if (this.val$context != null)
      {
        paramString = this.val$context;
        localObject = this.val$intent;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/pluginsdk/DeepLinkHelper$3", "getContactCallBack", "(Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/pluginsdk/DeepLinkHelper$3", "getContactCallBack", "(Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(124345);
        return;
      }
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("MicroMsg.DeepLinkHelper", paramString, "", new Object[] { "" });
      AppMethodBeat.o(124345);
      return;
    }
    paramString = aj.getContext();
    Object localObject = this.val$intent;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/pluginsdk/DeepLinkHelper$3", "getContactCallBack", "(Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/pluginsdk/DeepLinkHelper$3", "getContactCallBack", "(Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(124345);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.3
 * JD-Core Version:    0.7.0.1
 */