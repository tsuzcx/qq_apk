package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;
import com.tencent.mm.plugin.fts.ui.widget.FTSMainUIEducationLayout;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.d.b;
import com.tencent.mm.ui.fts.widget.FTSMainUIHotWordLayout;
import com.tencent.mm.ui.fts.widget.SOSEditTextView;

final class FTSSOSHomeWebViewUI$b$c
  extends b
{
  private FTSSOSHomeWebViewUI$b$c(FTSSOSHomeWebViewUI.b paramb) {}
  
  public final void enter()
  {
    AppMethodBeat.i(8465);
    super.enter();
    this.vlf.vkS.vjy.setPadding(FTSSOSHomeWebViewUI.H(this.vlf.vkS), 0, 0, 0);
    this.vlf.vkS.dfA().bDj();
    this.vlf.vkS.pbT.setVisibility(0);
    this.vlf.vkS.dfA().bDh();
    FTSSOSHomeWebViewUI.b(this.vlf.vkS).setVisibility(0);
    FTSSOSHomeWebViewUI.c(this.vlf.vkS).setVisibility(8);
    FTSSOSHomeWebViewUI.q(this.vlf.vkS).setVisibility(8);
    FTSSOSHomeWebViewUI.P(this.vlf.vkS).setVisibility(8);
    FTSSOSHomeWebViewUI.J(this.vlf.vkS).setVisibility(0);
    this.vlf.vkS.vjz.setSearchBarCancelTextContainerVisibile(0);
    this.vlf.vkS.vjz.setVoiceImageButtonVisibile(0);
    AppMethodBeat.o(8465);
  }
  
  public final void exit()
  {
    AppMethodBeat.i(8466);
    super.exit();
    this.vlf.vkS.hideVKB();
    AppMethodBeat.o(8466);
  }
  
  public final String getName()
  {
    return "SearchWithFocusNoResultState";
  }
  
  public final boolean k(Message paramMessage)
  {
    AppMethodBeat.i(8467);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      boolean bool = super.k(paramMessage);
      AppMethodBeat.o(8467);
      return bool;
      if (this.vlf.vkS.dfA().getEditText().hasFocus())
      {
        this.vlf.b(this.vlf.vlc);
        h.qsU.e(15521, new Object[] { Integer.valueOf(this.vlf.vkS.scene), Integer.valueOf(2), this.vlf.vkS.dfA().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(this.vlf.vkS.vjX) });
        continue;
        if (this.vlf.vkS.getTotalQuery().length() > 0)
        {
          this.vlf.b(this.vlf.vld);
          continue;
          if (this.vlf.vkS.getTotalQuery().length() > 0)
          {
            this.vlf.vkS.dfA().bDj();
            this.vlf.vkS.dfA().naN.clearFocus();
            FTSSOSHomeWebViewUI.v(this.vlf.vkS).clear();
            this.vlf.b(this.vlf.vld);
            continue;
            if (!this.vlf.vkS.vkB)
            {
              FTSSOSHomeWebViewUI.O(this.vlf.vkS);
              FTSSOSHomeWebViewUI.P(this.vlf.vkS).setVisibility(8);
              FTSSOSHomeWebViewUI.d(this.vlf.vkS, 0);
              FTSSOSHomeWebViewUI.Q(this.vlf.vkS).b(a.b.vlT);
              FTSSOSHomeWebViewUI.a(this.vlf.vkS, a.b.vlT);
            }
            else
            {
              this.vlf.vkS.finish();
              continue;
              this.vlf.b(this.vlf.vlb);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.b.c
 * JD-Core Version:    0.7.0.1
 */