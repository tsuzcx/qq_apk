package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.voip.floatcard.b;
import com.tencent.mm.plugin.voip.ui.c;
import java.lang.ref.WeakReference;
import kotlin.g.b.s;

final class u$6
  implements Runnable
{
  u$6(u paramu, Context paramContext, Intent paramIntent, long paramLong, boolean paramBoolean, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(293309);
    Object localObject = u.j(this.UCe);
    Context localContext = this.val$context;
    Intent localIntent = this.val$intent;
    long l = this.SMG;
    boolean bool = this.UCf;
    String str = this.hkh;
    s.u(localContext, "context");
    s.u(localIntent, "intent");
    s.u(str, "toUser");
    s.u(localContext, "context");
    s.u(localIntent, "intent");
    s.u(str, "toUser");
    ((b)localObject).UvH = bool;
    com.tencent.mm.plugin.voip.d.d locald = com.tencent.mm.plugin.voip.d.d.UGN;
    if (bool) {}
    for (int i = 2;; i = 1)
    {
      com.tencent.mm.plugin.voip.d.d.aqG(i);
      ((b)localObject).a(localContext, localIntent, l, str);
      ((com.tencent.mm.sensitive.d)h.az(com.tencent.mm.sensitive.d.class)).markEnterBusiness(".ui.voip.VoipFloatView");
      localObject = (c)((b)localObject).UvG.get();
      if (localObject != null) {
        ((c)localObject).aF(bool, str);
      }
      AppMethodBeat.o(293309);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.u.6
 * JD-Core Version:    0.7.0.1
 */