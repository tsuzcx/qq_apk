package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.z.a;
import com.tencent.mm.protocal.protobuf.egl;

final class SettingsSelectCreateAccount$3
  implements z.a
{
  SettingsSelectCreateAccount$3(SettingsSelectCreateAccount paramSettingsSelectCreateAccount) {}
  
  public final int callback(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.c paramc, p paramp)
  {
    AppMethodBeat.i(299247);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = new Intent();
      paramString.putExtra("rawUrl", ((egl)c.c.b(paramc.otC)).URL);
      paramString.putExtra("showShare", false);
      paramString.putExtra("show_bottom", false);
      com.tencent.mm.br.c.b(this.Pwj.getContext(), "webview", ".ui.tools.WebViewUI", paramString, 702);
    }
    AppMethodBeat.o(299247);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSelectCreateAccount.3
 * JD-Core Version:    0.7.0.1
 */