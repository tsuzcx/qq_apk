package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.fts.widget.SOSEditTextView;

final class FTSSOSHomeWebViewUI$6
  implements View.OnClickListener
{
  FTSSOSHomeWebViewUI$6(FTSSOSHomeWebViewUI paramFTSSOSHomeWebViewUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = (FTSSOSHomeWebViewUI.c)paramView.getTag();
    Bundle localBundle;
    if (paramView.type == 1)
    {
      localBundle = new Bundle();
      localBundle.putString("history", paramView.content);
    }
    try
    {
      FTSSOSHomeWebViewUI.y(this.ruD).i(5, localBundle);
      label48:
      ai.d(new FTSSOSHomeWebViewUI.a.2(FTSSOSHomeWebViewUI.z(this.ruD), paramView));
      do
      {
        return;
      } while (paramView.type != 2);
      FTSSOSHomeWebViewUI.z(this.ruD).clear();
      this.ruD.cfr().n(paramView.content, null);
      FTSSOSHomeWebViewUI.a(this.ruD, paramView, 2);
      FTSSOSHomeWebViewUI.e(this.ruD, 2);
      FTSSOSHomeWebViewUI.A(this.ruD);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      break label48;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.6
 * JD-Core Version:    0.7.0.1
 */