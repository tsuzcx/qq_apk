package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.permission.a;
import com.tencent.mm.pluginsdk.permission.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

final class q$1
  implements d
{
  q$1(Context paramContext, Intent paramIntent, a parama) {}
  
  public final void De(int paramInt)
  {
    AppMethodBeat.i(79350);
    ab.i("MicroMsg.ApplicationUtil", "onRequestPermissionsResult, resultCode = %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == -1)
    {
      try
      {
        this.val$context.startActivity(this.vLt);
        if (this.kZM == null) {
          break label121;
        }
        this.kZM.eb(true);
        AppMethodBeat.o(79350);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.ApplicationUtil", localException, "install app failed! %s", new Object[] { this.vLt });
        }
      }
    }
    else
    {
      ab.e("MicroMsg.ApplicationUtil", "no get!!!");
      Toast.makeText(ah.getContext(), 2131301860, 1).show();
      if (this.kZM != null) {
        this.kZM.eb(false);
      }
    }
    label121:
    AppMethodBeat.o(79350);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.q.1
 * JD-Core Version:    0.7.0.1
 */