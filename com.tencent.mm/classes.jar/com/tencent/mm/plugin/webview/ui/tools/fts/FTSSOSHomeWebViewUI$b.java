package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;
import com.tencent.mm.plugin.fts.ui.widget.FTSMainUIEducationLayout;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.d.a;
import com.tencent.mm.sdk.d.d;
import com.tencent.mm.ui.fts.widget.SOSEditTextView;

final class FTSSOSHomeWebViewUI$b
  extends d
{
  com.tencent.mm.sdk.d.c vlb;
  com.tencent.mm.sdk.d.c vlc;
  com.tencent.mm.sdk.d.c vld;
  com.tencent.mm.sdk.d.c vle;
  
  protected FTSSOSHomeWebViewUI$b(FTSSOSHomeWebViewUI paramFTSSOSHomeWebViewUI, String paramString, Looper paramLooper)
  {
    super(paramString, paramLooper);
    AppMethodBeat.i(8471);
    this.vlb = new a((byte)0);
    this.vlc = new FTSSOSHomeWebViewUI.b.d(this, (byte)0);
    this.vld = new FTSSOSHomeWebViewUI.b.b(this, (byte)0);
    this.vle = new FTSSOSHomeWebViewUI.b.c(this, (byte)0);
    a(this.vlb);
    a(this.vlc);
    a(this.vld);
    a(this.vle);
    b(this.vlb);
    AppMethodBeat.o(8471);
  }
  
  public final boolean dfE()
  {
    AppMethodBeat.i(8473);
    a locala = dui();
    if ((locala == this.vlc) || (locala == this.vld) || (locala == this.vle))
    {
      AppMethodBeat.o(8473);
      return true;
    }
    AppMethodBeat.o(8473);
    return false;
  }
  
  public final void dfP()
  {
    AppMethodBeat.i(8472);
    this.vkS.vjz.setSearchBarCancelTextContainerVisibile(0);
    b(this.vlb);
    AppMethodBeat.o(8472);
  }
  
  final class a
    extends com.tencent.mm.sdk.d.b
  {
    private a() {}
    
    public final void enter()
    {
      AppMethodBeat.i(8459);
      super.enter();
      FTSSOSHomeWebViewUI.B(FTSSOSHomeWebViewUI.b.this.vkS);
      AppMethodBeat.o(8459);
    }
    
    public final void exit()
    {
      AppMethodBeat.i(8460);
      super.exit();
      FTSSOSHomeWebViewUI.C(FTSSOSHomeWebViewUI.b.this.vkS).setBackgroundColor(FTSSOSHomeWebViewUI.b.this.vkS.getResources().getColor(2131690605));
      AppMethodBeat.o(8460);
    }
    
    public final String getName()
    {
      return "InitSate";
    }
    
    public final boolean k(Message paramMessage)
    {
      AppMethodBeat.i(8461);
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        boolean bool = super.k(paramMessage);
        AppMethodBeat.o(8461);
        return bool;
        if ((FTSSOSHomeWebViewUI.c(FTSSOSHomeWebViewUI.b.this.vkS) != null) && (FTSSOSHomeWebViewUI.c(FTSSOSHomeWebViewUI.b.this.vkS).getVisibility() == 0))
        {
          MotionEvent localMotionEvent = (MotionEvent)paramMessage.obj;
          FTSSOSHomeWebViewUI.c(FTSSOSHomeWebViewUI.b.this.vkS).L(localMotionEvent);
          continue;
          if (FTSSOSHomeWebViewUI.b.this.vkS.getTotalQuery().length() > 0)
          {
            FTSSOSHomeWebViewUI.b.this.vkS.dfA().bDh();
            FTSSOSHomeWebViewUI.b.this.vkS.dfA().bDj();
            FTSSOSHomeWebViewUI.b.this.vkS.dfA().naN.clearFocus();
            FTSSOSHomeWebViewUI.d(FTSSOSHomeWebViewUI.b.this.vkS, 0);
            FTSSOSHomeWebViewUI.D(FTSSOSHomeWebViewUI.b.this.vkS).b(a.b.vlU);
            FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.b.this.vkS, a.b.vlU);
            FTSSOSHomeWebViewUI.b.this.vkS.vjy.setBackgroundResource(2131690709);
            FTSSOSHomeWebViewUI.v(FTSSOSHomeWebViewUI.b.this.vkS).clear();
            continue;
            FTSSOSHomeWebViewUI.b.this.vkS.dfA().bDj();
            FTSSOSHomeWebViewUI.b.this.vkS.dfA().naN.clearFocus();
            FTSSOSHomeWebViewUI.d(FTSSOSHomeWebViewUI.b.this.vkS, 0);
            FTSSOSHomeWebViewUI.D(FTSSOSHomeWebViewUI.b.this.vkS).a(a.b.vlU, false);
            FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.b.this.vkS, a.b.vlU);
            FTSSOSHomeWebViewUI.b.this.vkS.vjy.setBackgroundResource(2131690709);
            FTSSOSHomeWebViewUI.v(FTSSOSHomeWebViewUI.b.this.vkS).clear();
            FTSSOSHomeWebViewUI.b.this.b(FTSSOSHomeWebViewUI.b.this.vld);
            FTSSOSHomeWebViewUI.b.this.vkS.vjE = true;
            continue;
            FTSSOSHomeWebViewUI.b.this.vkS.dfA().bDh();
            FTSSOSHomeWebViewUI.b.this.vkS.dfA().bDj();
            FTSSOSHomeWebViewUI.E(FTSSOSHomeWebViewUI.b.this.vkS).b(a.b.vlU);
            FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.b.this.vkS, a.b.vlU);
            FTSSOSHomeWebViewUI.b.this.vkS.vjy.setBackgroundResource(2131690709);
            FTSSOSHomeWebViewUI.v(FTSSOSHomeWebViewUI.b.this.vkS).clear();
            FTSSOSHomeWebViewUI.F(FTSSOSHomeWebViewUI.b.this.vkS);
            continue;
            FTSSOSHomeWebViewUI.b.this.vkS.vjE = true;
            FTSSOSHomeWebViewUI.b.this.b(FTSSOSHomeWebViewUI.b.this.vlc);
            continue;
            FTSSOSHomeWebViewUI.b.this.vkS.vjE = true;
            FTSSOSHomeWebViewUI.b.this.b(FTSSOSHomeWebViewUI.b.this.vld);
            continue;
            if ((FTSSOSHomeWebViewUI.b.this.vkS.dfA().getEditText().hasFocus()) && (FTSSOSHomeWebViewUI.b.this.vkS.getTotalQuery().length() > 0)) {
              FTSSOSHomeWebViewUI.w(FTSSOSHomeWebViewUI.b.this.vkS);
            }
            if ((FTSSOSHomeWebViewUI.b.this.vkS.dfA().getEditText().hasFocus()) && (FTSSOSHomeWebViewUI.b.this.vkS.getTotalQuery().length() == 0))
            {
              FTSSOSHomeWebViewUI.b.this.vkS.dfA().bDj();
              FTSSOSHomeWebViewUI.b.this.vkS.dfA().bDh();
              FTSSOSHomeWebViewUI.b.this.vkS.vjy.setBackgroundResource(2131690709);
              FTSSOSHomeWebViewUI.b.this.vkS.vjz.setSearchBarCancelTextContainerVisibile(8);
              FTSSOSHomeWebViewUI.v(FTSSOSHomeWebViewUI.b.this.vkS).clear();
              FTSSOSHomeWebViewUI.E(FTSSOSHomeWebViewUI.b.this.vkS).b(a.b.vlU);
              FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.b.this.vkS, a.b.vlU);
              FTSSOSHomeWebViewUI.b.this.vkS.Y(new FTSSOSHomeWebViewUI.b.a.1(this));
              h.qsU.e(15521, new Object[] { Integer.valueOf(FTSSOSHomeWebViewUI.b.this.vkS.scene), Integer.valueOf(3), FTSSOSHomeWebViewUI.b.this.vkS.dfA().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI.b.this.vkS.vjX) });
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.b
 * JD-Core Version:    0.7.0.1
 */