package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.yw;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.u;

final class e$1
  implements i
{
  e$1(Context paramContext, String paramString, boolean paramBoolean) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    int i = 1;
    AppMethodBeat.i(33809);
    bg.azz().b(1176, this);
    Log.d("MicroMsg.AppBrandServiceHelper", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Boolean.TRUE });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      u.makeText(this.val$context, 2131763726, 0).show();
      paramString = new yw();
      paramString.efe.dCl = this.gtu;
      paramq = paramString.efe;
      paramInt1 = i;
      if (!this.OMZ) {
        paramInt1 = 2;
      }
      paramq.action = paramInt1;
      paramString.efe.option = 2;
      EventCenter.instance.publish(paramString);
      AppMethodBeat.o(33809);
      return;
    }
    AppMethodBeat.o(33809);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.e.1
 * JD-Core Version:    0.7.0.1
 */