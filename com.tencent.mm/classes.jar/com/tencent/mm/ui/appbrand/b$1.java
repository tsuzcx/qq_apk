package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.un;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.t;

final class b$1
  implements f
{
  b$1(Context paramContext, String paramString, boolean paramBoolean) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    int i = 1;
    AppMethodBeat.i(29952);
    aw.Rc().b(1176, this);
    ab.d("MicroMsg.AppBrandServiceHelper", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Boolean.TRUE });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      t.makeText(this.val$context, 2131301984, 0).show();
      paramString = new un();
      paramString.cLa.cmx = this.efI;
      paramm = paramString.cLa;
      paramInt1 = i;
      if (!this.zgm) {
        paramInt1 = 2;
      }
      paramm.action = paramInt1;
      paramString.cLa.option = 2;
      a.ymk.l(paramString);
      AppMethodBeat.o(29952);
      return;
    }
    AppMethodBeat.o(29952);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.b.1
 * JD-Core Version:    0.7.0.1
 */