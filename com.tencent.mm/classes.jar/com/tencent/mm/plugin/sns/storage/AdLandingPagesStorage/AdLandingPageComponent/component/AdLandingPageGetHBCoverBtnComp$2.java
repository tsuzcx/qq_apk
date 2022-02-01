package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.widget.Button;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.lm;
import com.tencent.mm.autogen.a.lm.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

class AdLandingPageGetHBCoverBtnComp$2
  extends IListener<lm>
{
  AdLandingPageGetHBCoverBtnComp$2(w paramw, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(307094);
    this.__eventId = lm.class.getName().hashCode();
    AppMethodBeat.o(307094);
  }
  
  private boolean a(lm paramlm)
  {
    AppMethodBeat.i(96575);
    try
    {
      Log.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "GetHbCoverStateEvent callback, hbCoverId=" + paramlm.hNn.hNo + ", state=" + paramlm.hNn.state);
      if ((this.QQr.QQn.hNo.equals(paramlm.hNn.hNo)) && (paramlm.hNn.state == 0)) {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96574);
            AdLandingPageGetHBCoverBtnComp.2.this.QQr.QPn.setText(AdLandingPageGetHBCoverBtnComp.2.this.QQr.QQn.QJz);
            AdLandingPageGetHBCoverBtnComp.2.this.QQr.hjv();
            AppMethodBeat.o(96574);
          }
        });
      }
      AppMethodBeat.o(96575);
      return false;
    }
    catch (Exception paramlm)
    {
      for (;;)
      {
        Log.e("MicroMsg.AdLandingPageGetHBCoverBtnComp", "GetHbCoverStateEvent exp:" + paramlm.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.AdLandingPageGetHBCoverBtnComp.2
 * JD-Core Version:    0.7.0.1
 */