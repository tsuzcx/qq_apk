package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;
import com.tencent.mm.plugin.fts.ui.widget.FTSMainUIEducationLayout;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.d.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.fts.widget.FTSMainUIHotWordLayout;
import com.tencent.mm.ui.fts.widget.SOSEditTextView;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

final class FTSSOSHomeWebViewUI$b
  extends com.tencent.mm.sdk.d.d
{
  com.tencent.mm.sdk.d.c ruM = new a((byte)0);
  com.tencent.mm.sdk.d.c ruN = new FTSSOSHomeWebViewUI.b.d(this, (byte)0);
  com.tencent.mm.sdk.d.c ruO = new FTSSOSHomeWebViewUI.b.b(this, (byte)0);
  com.tencent.mm.sdk.d.c ruP = new c((byte)0);
  
  protected FTSSOSHomeWebViewUI$b(FTSSOSHomeWebViewUI paramFTSSOSHomeWebViewUI, String paramString, Looper paramLooper)
  {
    super(paramString, paramLooper);
    a(this.ruM);
    a(this.ruN);
    a(this.ruO);
    a(this.ruP);
    b(this.ruM);
  }
  
  public final void cfF()
  {
    this.ruD.rtt.setSearchBarCancelTextContainerVisibile(0);
    b(this.ruM);
  }
  
  public final boolean cfG()
  {
    a locala = csl();
    return (locala == this.ruN) || (locala == this.ruO) || (locala == this.ruP);
  }
  
  private final class a
    extends com.tencent.mm.sdk.d.b
  {
    private a() {}
    
    public final void enter()
    {
      super.enter();
      FTSSOSHomeWebViewUI.F(FTSSOSHomeWebViewUI.b.this.ruD);
    }
    
    public final void exit()
    {
      super.exit();
      FTSSOSHomeWebViewUI.G(FTSSOSHomeWebViewUI.b.this.ruD).setBackgroundColor(FTSSOSHomeWebViewUI.b.this.ruD.getResources().getColor(R.e.transparent));
    }
    
    public final boolean g(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        return super.g(paramMessage);
        if ((FTSSOSHomeWebViewUI.c(FTSSOSHomeWebViewUI.b.this.ruD) != null) && (FTSSOSHomeWebViewUI.c(FTSSOSHomeWebViewUI.b.this.ruD).getVisibility() == 0))
        {
          MotionEvent localMotionEvent = (MotionEvent)paramMessage.obj;
          FTSMainUIEducationLayout localFTSMainUIEducationLayout = FTSSOSHomeWebViewUI.c(FTSSOSHomeWebViewUI.b.this.ruD);
          y.v("MicroMsg.FTS.FTSMainUIEducationLayout", "action %d", new Object[] { Integer.valueOf(localMotionEvent.getAction()) });
          switch (localMotionEvent.getAction())
          {
          default: 
            break;
          case 0: 
            Iterator localIterator = localFTSMainUIEducationLayout.kEK.values().iterator();
            TextView localTextView;
            int[] arrayOfInt;
            do
            {
              if (!localIterator.hasNext()) {
                break;
              }
              localTextView = (TextView)localIterator.next();
              arrayOfInt = new int[2];
              localTextView.getLocationOnScreen(arrayOfInt);
            } while (!new Rect(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + localTextView.getWidth(), arrayOfInt[1] + localTextView.getHeight()).contains((int)localMotionEvent.getRawX(), (int)localMotionEvent.getRawY()));
            while (localTextView != null)
            {
              localFTSMainUIEducationLayout.kEO = localTextView;
              localFTSMainUIEducationLayout.fSy = localMotionEvent.getRawX();
              localFTSMainUIEducationLayout.fSz = localMotionEvent.getRawY();
              localFTSMainUIEducationLayout.kEM = System.currentTimeMillis();
              break;
              localTextView = null;
            }
          case 1: 
          case 9: 
            if (localFTSMainUIEducationLayout.kEO != null)
            {
              float f1 = localMotionEvent.getRawX() - localFTSMainUIEducationLayout.fSy;
              float f2 = localMotionEvent.getRawY() - localFTSMainUIEducationLayout.fSz;
              y.v("MicroMsg.FTS.FTSMainUIEducationLayout", "action up deltaX %f, deltaY %f, time interval %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Long.valueOf(System.currentTimeMillis() - localFTSMainUIEducationLayout.kEM) });
              if ((Math.abs(f1) <= localFTSMainUIEducationLayout.gFU) && (Math.abs(f2) <= localFTSMainUIEducationLayout.gFU) && (System.currentTimeMillis() - localFTSMainUIEducationLayout.kEM < 200L) && (localFTSMainUIEducationLayout.kCk != null)) {
                localFTSMainUIEducationLayout.kCk.onClick(localFTSMainUIEducationLayout.kEO);
              }
              localFTSMainUIEducationLayout.kEO = null;
            }
            break;
          case 3: 
            localFTSMainUIEducationLayout.kEO = null;
            continue;
            if (FTSSOSHomeWebViewUI.b.this.ruD.getTotalQuery().length() > 0)
            {
              FTSSOSHomeWebViewUI.b.this.ruD.cfr().aWA();
              FTSSOSHomeWebViewUI.b.this.ruD.cfr().aWC();
              FTSSOSHomeWebViewUI.b.this.ruD.cfr().kEp.clearFocus();
              FTSSOSHomeWebViewUI.d(FTSSOSHomeWebViewUI.b.this.ruD, 0);
              FTSSOSHomeWebViewUI.H(FTSSOSHomeWebViewUI.b.this.ruD).b(a.b.rvE);
              FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.b.this.ruD, a.b.rvE);
              FTSSOSHomeWebViewUI.b.this.ruD.rts.setBackgroundResource(R.e.white);
              FTSSOSHomeWebViewUI.z(FTSSOSHomeWebViewUI.b.this.ruD).clear();
              continue;
              FTSSOSHomeWebViewUI.b.this.ruD.cfr().aWC();
              FTSSOSHomeWebViewUI.b.this.ruD.cfr().kEp.clearFocus();
              FTSSOSHomeWebViewUI.d(FTSSOSHomeWebViewUI.b.this.ruD, 0);
              FTSSOSHomeWebViewUI.H(FTSSOSHomeWebViewUI.b.this.ruD).a(a.b.rvE, false);
              FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.b.this.ruD, a.b.rvE);
              FTSSOSHomeWebViewUI.b.this.ruD.rts.setBackgroundResource(R.e.white);
              FTSSOSHomeWebViewUI.z(FTSSOSHomeWebViewUI.b.this.ruD).clear();
              FTSSOSHomeWebViewUI.b.this.b(FTSSOSHomeWebViewUI.b.this.ruO);
              FTSSOSHomeWebViewUI.b.this.ruD.rty = true;
              continue;
              FTSSOSHomeWebViewUI.b.this.ruD.cfr().aWA();
              FTSSOSHomeWebViewUI.b.this.ruD.cfr().aWC();
              FTSSOSHomeWebViewUI.I(FTSSOSHomeWebViewUI.b.this.ruD).b(a.b.rvE);
              FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.b.this.ruD, a.b.rvE);
              FTSSOSHomeWebViewUI.b.this.ruD.rts.setBackgroundResource(R.e.white);
              FTSSOSHomeWebViewUI.z(FTSSOSHomeWebViewUI.b.this.ruD).clear();
              FTSSOSHomeWebViewUI.J(FTSSOSHomeWebViewUI.b.this.ruD);
              continue;
              FTSSOSHomeWebViewUI.b.this.ruD.rty = true;
              FTSSOSHomeWebViewUI.b.this.b(FTSSOSHomeWebViewUI.b.this.ruN);
              continue;
              FTSSOSHomeWebViewUI.b.this.ruD.rty = true;
              FTSSOSHomeWebViewUI.b.this.b(FTSSOSHomeWebViewUI.b.this.ruO);
              continue;
              if ((FTSSOSHomeWebViewUI.b.this.ruD.cfr().getEditText().hasFocus()) && (FTSSOSHomeWebViewUI.b.this.ruD.getTotalQuery().length() > 0)) {
                FTSSOSHomeWebViewUI.A(FTSSOSHomeWebViewUI.b.this.ruD);
              }
              if ((FTSSOSHomeWebViewUI.b.this.ruD.cfr().getEditText().hasFocus()) && (FTSSOSHomeWebViewUI.b.this.ruD.getTotalQuery().length() == 0))
              {
                FTSSOSHomeWebViewUI.b.this.ruD.cfr().aWC();
                FTSSOSHomeWebViewUI.b.this.ruD.cfr().aWA();
                FTSSOSHomeWebViewUI.b.this.ruD.rts.setBackgroundResource(R.e.white);
                FTSSOSHomeWebViewUI.b.this.ruD.rtt.setSearchBarCancelTextContainerVisibile(8);
                FTSSOSHomeWebViewUI.z(FTSSOSHomeWebViewUI.b.this.ruD).clear();
                FTSSOSHomeWebViewUI.I(FTSSOSHomeWebViewUI.b.this.ruD).b(a.b.rvE);
                FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.b.this.ruD, a.b.rvE);
                FTSSOSHomeWebViewUI.b.this.ruD.P(new FTSSOSHomeWebViewUI.b.a.1(this));
                h.nFQ.f(15521, new Object[] { Integer.valueOf(FTSSOSHomeWebViewUI.b.this.ruD.scene), Integer.valueOf(3), FTSSOSHomeWebViewUI.b.this.ruD.cfr().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI.b.this.ruD.rtQ) });
              }
            }
            break;
          }
        }
      }
    }
    
    public final String getName()
    {
      return "InitSate";
    }
  }
  
  private final class c
    extends com.tencent.mm.sdk.d.b
  {
    private c() {}
    
    public final void enter()
    {
      super.enter();
      FTSSOSHomeWebViewUI.b.this.ruD.rts.setPadding(FTSSOSHomeWebViewUI.M(FTSSOSHomeWebViewUI.b.this.ruD), 0, 0, 0);
      FTSSOSHomeWebViewUI.b.this.ruD.cfr().aWC();
      FTSSOSHomeWebViewUI.b.this.ruD.mBP.setVisibility(0);
      FTSSOSHomeWebViewUI.b.this.ruD.cfr().aWA();
      FTSSOSHomeWebViewUI.b(FTSSOSHomeWebViewUI.b.this.ruD).setVisibility(0);
      FTSSOSHomeWebViewUI.c(FTSSOSHomeWebViewUI.b.this.ruD).setVisibility(8);
      FTSSOSHomeWebViewUI.q(FTSSOSHomeWebViewUI.b.this.ruD).setVisibility(8);
      FTSSOSHomeWebViewUI.U(FTSSOSHomeWebViewUI.b.this.ruD).setVisibility(8);
      FTSSOSHomeWebViewUI.O(FTSSOSHomeWebViewUI.b.this.ruD).setVisibility(0);
      FTSSOSHomeWebViewUI.b.this.ruD.rtt.setSearchBarCancelTextContainerVisibile(0);
      FTSSOSHomeWebViewUI.b.this.ruD.rtt.setVoiceImageButtonVisibile(0);
    }
    
    public final boolean g(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        return super.g(paramMessage);
        if (FTSSOSHomeWebViewUI.b.this.ruD.cfr().getEditText().hasFocus())
        {
          FTSSOSHomeWebViewUI.b.this.b(FTSSOSHomeWebViewUI.b.this.ruN);
          h.nFQ.f(15521, new Object[] { Integer.valueOf(FTSSOSHomeWebViewUI.b.this.ruD.scene), Integer.valueOf(2), FTSSOSHomeWebViewUI.b.this.ruD.cfr().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(FTSSOSHomeWebViewUI.b.this.ruD.rtQ) });
          continue;
          if (FTSSOSHomeWebViewUI.b.this.ruD.getTotalQuery().length() > 0)
          {
            FTSSOSHomeWebViewUI.b.this.b(FTSSOSHomeWebViewUI.b.this.ruO);
            continue;
            if (FTSSOSHomeWebViewUI.b.this.ruD.getTotalQuery().length() > 0)
            {
              FTSSOSHomeWebViewUI.b.this.ruD.cfr().aWC();
              FTSSOSHomeWebViewUI.b.this.ruD.cfr().kEp.clearFocus();
              FTSSOSHomeWebViewUI.z(FTSSOSHomeWebViewUI.b.this.ruD).clear();
              FTSSOSHomeWebViewUI.b.this.b(FTSSOSHomeWebViewUI.b.this.ruO);
              continue;
              if (!FTSSOSHomeWebViewUI.b.this.ruD.ruo)
              {
                FTSSOSHomeWebViewUI.T(FTSSOSHomeWebViewUI.b.this.ruD);
                FTSSOSHomeWebViewUI.U(FTSSOSHomeWebViewUI.b.this.ruD).setVisibility(8);
                FTSSOSHomeWebViewUI.d(FTSSOSHomeWebViewUI.b.this.ruD, 0);
                FTSSOSHomeWebViewUI.V(FTSSOSHomeWebViewUI.b.this.ruD).b(a.b.rvD);
                FTSSOSHomeWebViewUI.a(FTSSOSHomeWebViewUI.b.this.ruD, a.b.rvD);
              }
              else
              {
                FTSSOSHomeWebViewUI.b.this.ruD.finish();
                continue;
                FTSSOSHomeWebViewUI.b.this.b(FTSSOSHomeWebViewUI.b.this.ruM);
              }
            }
          }
        }
      }
    }
    
    public final String getName()
    {
      return "SearchWithFocusNoResultState";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.b
 * JD-Core Version:    0.7.0.1
 */