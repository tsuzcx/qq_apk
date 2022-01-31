package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bd.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.fts.widget.SOSEditTextView;
import java.util.List;
import org.json.JSONObject;

final class FTSSOSHomeWebViewUI$18
  implements View.OnClickListener
{
  FTSSOSHomeWebViewUI$18(FTSSOSHomeWebViewUI paramFTSSOSHomeWebViewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(153302);
    FTSSOSHomeWebViewUI.i(this.vkS);
    if (!this.vkS.vjF)
    {
      AppMethodBeat.o(153302);
      return;
    }
    FTSSOSHomeWebViewUI.a(this.vkS).sendMessage(1);
    String str = ((TextView)paramView).getText().toString();
    int i = a.a((JSONObject)paramView.getTag(), str, this.vkS);
    if (i == 64)
    {
      FTSSOSHomeWebViewUI.j(this.vkS);
      FTSSOSHomeWebViewUI.k(this.vkS).setVisibility(0);
      paramView = FTSSOSHomeWebViewUI.m(this.vkS);
      int j = FTSSOSHomeWebViewUI.l(this.vkS).getHeight();
      ViewGroup.LayoutParams localLayoutParams = paramView.vmb.getLayoutParams();
      localLayoutParams.height = j;
      paramView.vmb.setLayoutParams(localLayoutParams);
      FTSSOSHomeWebViewUI.l(this.vkS).setVisibility(8);
    }
    if (i != 0)
    {
      FTSSOSHomeWebViewUI.a(this.vkS, str);
      if (this.vkS.vjX != i) {
        h.qsU.e(15521, new Object[] { Integer.valueOf(this.vkS.scene), Integer.valueOf(4), this.vkS.dfA().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(this.vkS.vjX) });
      }
      if ((this.vkS.vjX != i) && (!this.vkS.dfA().getTagList().isEmpty()))
      {
        paramView = this.vkS.getTotalQuery();
        this.vkS.dfA().clearText();
        this.vkS.dfA().o(paramView, null);
        this.vkS.dfA().bDj();
      }
      this.vkS.vjX = i;
      this.vkS.dfv();
      FTSSOSHomeWebViewUI.d(this.vkS, i);
    }
    for (;;)
    {
      try
      {
        FTSSOSHomeWebViewUI.e(this.vkS, 0);
        paramView = new Bundle();
        paramView.putInt("type", i);
        if (i == 0)
        {
          bool = true;
          paramView.putBoolean("isHomePage", bool);
          if ((this.vkS.getScene() != 20) || (FTSSOSHomeWebViewUI.a(this.vkS).dfE())) {
            break label508;
          }
          if (i == 0) {
            continue;
          }
          this.vkS.vjW = 22;
          paramView.putInt("scene", 22);
          paramView = this.vkS.igU.s(4, paramView);
          FTSSOSHomeWebViewUI.o(this.vkS).post(new FTSSOSHomeWebViewUI.18.1(this, i, paramView));
          AppMethodBeat.o(153302);
          return;
          FTSSOSHomeWebViewUI.a(this.vkS, "");
          break;
        }
        boolean bool = false;
        continue;
        this.vkS.vjW = 20;
        paramView.putInt("scene", 20);
        continue;
        this.vkS.vjW = this.vkS.getScene();
      }
      catch (Exception paramView)
      {
        AppMethodBeat.o(153302);
        return;
      }
      label508:
      paramView.putInt("scene", this.vkS.getScene());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.18
 * JD-Core Version:    0.7.0.1
 */