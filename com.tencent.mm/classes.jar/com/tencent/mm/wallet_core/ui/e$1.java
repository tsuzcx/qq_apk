package com.tencent.mm.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.ui.base.h.d;

final class e$1
  implements h.d
{
  e$1(Context paramContext, String paramString) {}
  
  public final void ca(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49256);
    Intent localIntent = new Intent();
    switch (paramInt1)
    {
    }
    for (;;)
    {
      localIntent.putExtra("showShare", false);
      d.b(this.val$context, "webview", ".ui.tools.WebViewUI", localIntent);
      AppMethodBeat.o(49256);
      return;
      localIntent.putExtra("rawUrl", this.val$context.getString(2131304778, new Object[] { aa.dsG() }));
      continue;
      if (this.AYE != null)
      {
        localIntent.putExtra("rawUrl", this.val$context.getString(2131304776, new Object[] { aa.dsG(), this.AYE }));
        continue;
        if (this.AYE != null)
        {
          localIntent.putExtra("rawUrl", this.val$context.getString(2131304779, new Object[] { aa.dsG(), this.AYE }));
          continue;
          if (this.AYE != null) {
            localIntent.putExtra("rawUrl", this.val$context.getString(2131304780, new Object[] { aa.dsG(), this.AYE }));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.e.1
 * JD-Core Version:    0.7.0.1
 */