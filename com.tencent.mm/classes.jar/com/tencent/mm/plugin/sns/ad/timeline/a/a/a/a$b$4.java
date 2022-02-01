package com.tencent.mm.plugin.sns.ad.timeline.a.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.u;

final class a$b$4
  implements Runnable
{
  a$b$4(a.b paramb, int paramInt, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(202091);
    try
    {
      if (this.val$r == 0)
      {
        localContext = this.DxC.mContext;
        if (TextUtils.isEmpty(this.DxD)) {}
        for (str = this.DxC.mContext.getString(2131765945);; str = this.DxD)
        {
          u.cG(localContext, str);
          AppMethodBeat.o(202091);
          return;
        }
      }
      Context localContext = this.DxC.mContext;
      if (TextUtils.isEmpty(this.DxD)) {}
      for (String str = this.DxC.mContext.getString(2131765944);; str = this.DxD)
      {
        u.cH(localContext, str);
        AppMethodBeat.o(202091);
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(202091);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.a.a.a.b.4
 * JD-Core Version:    0.7.0.1
 */