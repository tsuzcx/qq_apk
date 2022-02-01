package com.tencent.mm.plugin.sns.ad.landingpage;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;

public final class a
{
  SnsAdNativeLandingPagesUI POJ;
  TextView PPA;
  public View plc;
  ProgressBar qgC;
  
  public a(SnsAdNativeLandingPagesUI paramSnsAdNativeLandingPagesUI)
  {
    this.POJ = paramSnsAdNativeLandingPagesUI;
  }
  
  public final void hideLoading()
  {
    AppMethodBeat.i(310627);
    h.ahAA.bk(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(310634);
        if (a.this.plc != null) {
          a.this.plc.setVisibility(8);
        }
        AppMethodBeat.o(310634);
      }
    });
    AppMethodBeat.o(310627);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.a
 * JD-Core Version:    0.7.0.1
 */