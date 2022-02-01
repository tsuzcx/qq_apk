package com.tencent.mm.pluginsdk.ui.span;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.ui.base.h.d;

final class n$1
  implements h.d
{
  n$1(DialogInterface.OnDismissListener paramOnDismissListener, String paramString, Context paramContext) {}
  
  public final void qy(int paramInt)
  {
    AppMethodBeat.i(31921);
    if (this.Rsq != null) {
      this.Rsq.onDismiss(null);
    }
    String str1 = this.Rsr.replace(" ", "").replace("#", "@");
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(31921);
      return;
      Context localContext = this.val$context;
      Intent localIntent = new Intent();
      localIntent.putExtra("composeType", 4);
      String str2 = str1.substring(0, str1.indexOf('@'));
      localIntent.putExtra("toList", new String[] { str2 + " " + str1 });
      c.b(localContext, "qqmail", ".ui.ComposeUI", localIntent);
      AppMethodBeat.o(31921);
      return;
      n.cA(this.val$context, str1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.n.1
 * JD-Core Version:    0.7.0.1
 */