package com.tencent.mm.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.base.h.e;

final class f$1
  implements h.e
{
  f$1(Context paramContext, String paramString) {}
  
  public final void cy(int paramInt1, int paramInt2)
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
      c.b(this.val$context, "webview", ".ui.tools.WebViewUI", localIntent);
      AppMethodBeat.o(72981);
      return;
      localIntent.putExtra("rawUrl", this.val$context.getString(2131767402, new Object[] { LocaleUtil.getApplicationLanguage() }));
      continue;
      if (this.RvC != null)
      {
        localIntent.putExtra("rawUrl", this.val$context.getString(2131767400, new Object[] { LocaleUtil.getApplicationLanguage(), this.RvC }));
        continue;
        if (this.RvC != null)
        {
          localIntent.putExtra("rawUrl", this.val$context.getString(2131767403, new Object[] { LocaleUtil.getApplicationLanguage(), this.RvC }));
          continue;
          if (this.RvC != null) {
            localIntent.putExtra("rawUrl", this.val$context.getString(2131767404, new Object[] { LocaleUtil.getApplicationLanguage(), this.RvC }));
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