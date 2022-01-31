package com.tencent.mm.pluginsdk;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.model.am.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

final class d$3
  implements am.b.a
{
  d$3(Intent paramIntent, Context paramContext) {}
  
  public final void m(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      y.e("MicroMsg.DeepLinkHelper", "getContact fail, %s", new Object[] { paramString });
      return;
    }
    this.val$intent.putExtra("Chat_User", paramString);
    try
    {
      if (this.val$context != null)
      {
        this.val$context.startActivity(this.val$intent);
        return;
      }
    }
    catch (Exception paramString)
    {
      y.printErrStackTrace("MicroMsg.DeepLinkHelper", paramString, "", new Object[] { "" });
      return;
    }
    ae.getContext().startActivity(this.val$intent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.d.3
 * JD-Core Version:    0.7.0.1
 */