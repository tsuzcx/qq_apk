package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.bc.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.fts.widget.SOSEditTextView;
import java.util.List;
import org.json.JSONObject;

final class FTSSOSHomeWebViewUI$18
  implements View.OnClickListener
{
  FTSSOSHomeWebViewUI$18(FTSSOSHomeWebViewUI paramFTSSOSHomeWebViewUI) {}
  
  public final void onClick(View paramView)
  {
    FTSSOSHomeWebViewUI.i(this.ruD);
    if (!this.ruD.rtz) {
      return;
    }
    FTSSOSHomeWebViewUI.a(this.ruD).Ff(1);
    String str = ((TextView)paramView).getText().toString();
    int i = a.a((JSONObject)paramView.getTag(), str, this.ruD);
    if (i != 0)
    {
      FTSSOSHomeWebViewUI.a(this.ruD, str);
      if (this.ruD.rtQ != i) {
        h.nFQ.f(15521, new Object[] { Integer.valueOf(this.ruD.scene), Integer.valueOf(4), this.ruD.cfr().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(this.ruD.rtQ) });
      }
      if ((this.ruD.rtQ != i) && (!this.ruD.cfr().getTagList().isEmpty()))
      {
        paramView = this.ruD.getTotalQuery();
        this.ruD.cfr().clearText();
        this.ruD.cfr().n(paramView, null);
        this.ruD.cfr().aWC();
      }
      this.ruD.rtQ = i;
      this.ruD.cfm();
      FTSSOSHomeWebViewUI.d(this.ruD, i);
    }
    for (;;)
    {
      try
      {
        FTSSOSHomeWebViewUI.e(this.ruD, 0);
        paramView = new Bundle();
        paramView.putInt("type", i);
        if (i != 0) {
          break label380;
        }
        bool = true;
        paramView.putBoolean("isHomePage", bool);
        if ((this.ruD.aZY() != 20) || (FTSSOSHomeWebViewUI.a(this.ruD).cfG())) {
          break label405;
        }
        if (i == 0) {
          break label385;
        }
        this.ruD.rtP = 22;
        paramView.putInt("scene", 22);
        paramView = FTSSOSHomeWebViewUI.j(this.ruD).o(4, paramView);
        FTSSOSHomeWebViewUI.n(this.ruD).post(new FTSSOSHomeWebViewUI.18.1(this, i, paramView));
        return;
      }
      catch (Exception paramView)
      {
        return;
      }
      FTSSOSHomeWebViewUI.a(this.ruD, "");
      break;
      label380:
      boolean bool = false;
      continue;
      label385:
      this.ruD.rtP = 20;
      paramView.putInt("scene", 20);
      continue;
      label405:
      this.ruD.rtP = this.ruD.aZY();
      paramView.putInt("scene", this.ruD.aZY());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.18
 * JD-Core Version:    0.7.0.1
 */