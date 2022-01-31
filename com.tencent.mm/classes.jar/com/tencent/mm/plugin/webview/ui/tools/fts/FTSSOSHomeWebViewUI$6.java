package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.fts.widget.SOSEditTextView;

final class FTSSOSHomeWebViewUI$6
  implements View.OnClickListener
{
  FTSSOSHomeWebViewUI$6(FTSSOSHomeWebViewUI paramFTSSOSHomeWebViewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(153289);
    paramView = (FTSSOSHomeWebViewUI.c)paramView.getTag();
    Bundle localBundle;
    if (paramView.type == 1)
    {
      localBundle = new Bundle();
      localBundle.putString("history", paramView.content);
    }
    try
    {
      this.vkS.igU.r(5, localBundle);
      label54:
      al.d(new FTSSOSHomeWebViewUI.a.2(FTSSOSHomeWebViewUI.v(this.vkS), paramView));
      AppMethodBeat.o(153289);
      return;
      if (paramView.type == 2)
      {
        FTSSOSHomeWebViewUI.v(this.vkS).clear();
        this.vkS.dfA().o(paramView.content, null);
        FTSSOSHomeWebViewUI.a(this.vkS, paramView, 2);
        FTSSOSHomeWebViewUI.e(this.vkS, 2);
        FTSSOSHomeWebViewUI.w(this.vkS);
      }
      AppMethodBeat.o(153289);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      break label54;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.6
 * JD-Core Version:    0.7.0.1
 */