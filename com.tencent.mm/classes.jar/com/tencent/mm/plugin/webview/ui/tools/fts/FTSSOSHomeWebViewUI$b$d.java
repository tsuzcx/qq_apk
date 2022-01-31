package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.content.res.Resources;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import com.tencent.mm.R.e;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;
import com.tencent.mm.plugin.fts.ui.widget.FTSMainUIEducationLayout;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.fts.widget.FTSMainUIHotWordLayout;
import com.tencent.mm.ui.fts.widget.SOSEditTextView;

final class FTSSOSHomeWebViewUI$b$d
  extends com.tencent.mm.sdk.d.b
{
  private FTSSOSHomeWebViewUI$b$d(FTSSOSHomeWebViewUI.b paramb) {}
  
  public final void enter()
  {
    super.enter();
    this.ruQ.ruD.cfr().aWA();
    FTSSOSHomeWebViewUI.L(this.ruQ.ruD).setVisibility(0);
    this.ruQ.ruD.rts.setPadding(FTSSOSHomeWebViewUI.M(this.ruQ.ruD), 0, 0, 0);
    FTSSOSHomeWebViewUI.U(this.ruQ.ruD).setVisibility(8);
    this.ruQ.ruD.rtt.setSearchBarCancelTextContainerVisibile(8);
    this.ruQ.ruD.rtt.setVoiceImageButtonVisibile(8);
    FTSSOSHomeWebViewUI.i(this.ruQ.ruD);
    FTSSOSHomeWebViewUI.c(this.ruQ.ruD).setVisibility(8);
    FTSSOSHomeWebViewUI.q(this.ruQ.ruD).setVisibility(8);
    FTSSOSHomeWebViewUI.O(this.ruQ.ruD).setVisibility(0);
    if (!this.ruQ.ruD.cfr().kEp.hasFocus())
    {
      this.ruQ.ruD.cfr().aWy();
      this.ruQ.ruD.showVKB();
    }
    if ((d.gF(23)) && (!com.tencent.mm.sdk.g.b.zL())) {
      FTSSOSHomeWebViewUI.h(this.ruQ.ruD, this.ruQ.ruD.getResources().getColor(R.e.white));
    }
    if (!TextUtils.isEmpty(this.ruQ.ruD.getInEditTextQuery())) {
      this.ruQ.ruD.cfr().aWD();
    }
  }
  
  public final void exit()
  {
    super.exit();
  }
  
  public final boolean g(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.g(paramMessage);
      if (!this.ruQ.ruD.ruo)
      {
        FTSSOSHomeWebViewUI.T(this.ruQ.ruD);
        FTSSOSHomeWebViewUI.U(this.ruQ.ruD).setVisibility(8);
        FTSSOSHomeWebViewUI.d(this.ruQ.ruD, 0);
        FTSSOSHomeWebViewUI.I(this.ruQ.ruD).b(a.b.rvD);
        FTSSOSHomeWebViewUI.a(this.ruQ.ruD, a.b.rvD);
      }
      else
      {
        this.ruQ.ruD.finish();
        continue;
        this.ruQ.b(this.ruQ.ruM);
        continue;
        if (!this.ruQ.ruD.cfr().getEditText().hasFocus())
        {
          this.ruQ.b(this.ruQ.ruO);
        }
        else
        {
          h.nFQ.f(15521, new Object[] { Integer.valueOf(this.ruQ.ruD.scene), Integer.valueOf(2), this.ruQ.ruD.cfr().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(this.ruQ.ruD.rtQ) });
          continue;
          if (this.ruQ.ruD.getTotalQuery().length() > 0) {
            this.ruQ.b(this.ruQ.ruO);
          }
        }
      }
    }
  }
  
  public final String getName()
  {
    return "SearchWithFocusState";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.b.d
 * JD-Core Version:    0.7.0.1
 */