package com.tencent.mm.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.h.d;

final class f$1
  implements h.d
{
  f$1(Context paramContext, String paramString) {}
  
  public final void cv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(72981);
    Intent localIntent = new Intent();
    switch (paramInt1)
    {
    }
    for (;;)
    {
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("allow_mix_content_mode", false);
      d.b(this.val$context, "webview", ".ui.tools.WebViewUI", localIntent);
      AppMethodBeat.o(72981);
      return;
      localIntent.putExtra("rawUrl", this.val$context.getString(2131764961, new Object[] { ad.fom() }));
      continue;
      if (this.LWM != null)
      {
        localIntent.putExtra("rawUrl", this.val$context.getString(2131764959, new Object[] { ad.fom(), this.LWM }));
        continue;
        if (this.LWM != null)
        {
          localIntent.putExtra("rawUrl", this.val$context.getString(2131764962, new Object[] { ad.fom(), this.LWM }));
          continue;
          if (this.LWM != null) {
            localIntent.putExtra("rawUrl", this.val$context.getString(2131764963, new Object[] { ad.fom(), this.LWM }));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.f.1
 * JD-Core Version:    0.7.0.1
 */