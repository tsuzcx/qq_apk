package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class i$7
  implements View.OnClickListener
{
  i$7(i parami) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(153202);
    if (this.vcB.hzQ.isShowing()) {
      this.vcB.hzQ.cre();
    }
    i locali = this.vcB;
    String str1 = this.vcB.igX;
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("preUsername", locali.ddt().getIntent().getStringExtra("preUsername"));
      localBundle.putString("preChatName", locali.ddt().getIntent().getStringExtra("preChatName"));
      localBundle.putString("rawUrl", locali.ddt().cJr);
      com.tencent.mm.plugin.webview.stub.d locald = locali.ddt().igU;
      String str2 = locali.igX;
      String str3 = locali.ddt().dek();
      if (bo.isNullOrNil(str1)) {
        paramView = "";
      }
      for (;;)
      {
        locald.a(str2, str3, paramView, locali.vcx, locali.vcy, localBundle);
        ab.i("MicroMsg.WebViewLongClickHelper", "onMenuItemClick recognize qbcode");
        AppMethodBeat.o(153202);
        return;
        paramView = str1;
        if (str1.length() > 1024) {
          paramView = str1.substring(0, 1024);
        }
      }
      return;
    }
    catch (RemoteException paramView)
    {
      ab.e("MicroMsg.WebViewLongClickHelper", "recognize qbar result failed");
      AppMethodBeat.o(153202);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.i.7
 * JD-Core Version:    0.7.0.1
 */