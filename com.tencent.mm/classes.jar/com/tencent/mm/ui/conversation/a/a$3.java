package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import com.tencent.mm.ay.k;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.pluginsdk.p.a;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

final class a$3
  implements a.a
{
  a$3(a parama) {}
  
  public final void SF(String paramString)
  {
    com.tencent.mm.pluginsdk.h.a.a.clQ();
    au.Hx();
    c.Fv().b(new k(3, paramString));
  }
  
  public final void gx(String paramString1, String paramString2)
  {
    com.tencent.mm.pluginsdk.h.a.a.clQ();
    au.Hx();
    c.Fv().b(new k(2, paramString1));
    y.d("MicroMsg.ADBanner", "jump to " + paramString2);
    p.a.rSH.a((Context)this.vUk.sdy.get(), paramString2, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.a.3
 * JD-Core Version:    0.7.0.1
 */