package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class m$a$c
  extends com.tencent.mm.sdk.d.b
{
  AdLandingPagesProxy.a rvW;
  
  m$a$c(m.a parama) {}
  
  public final void enter()
  {
    AppMethodBeat.i(37119);
    super.enter();
    al.d(new m.a.c.1(this));
    if ((AdLandingPagesProxy.getInstance().isPaused(m.b(this.rvU.rvI).cwc)) || (AdLandingPagesProxy.getInstance().isDownloading(m.b(this.rvU.rvI).cwc)))
    {
      if (this.rvW == null) {
        this.rvW = new m.a.c.a(this, (byte)0);
      }
      al.d(new m.a.c.2(this));
      if (!AdLandingPagesProxy.getInstance().resumeTask(m.b(this.rvU.rvI).cwc, this.rvW, this.rvU.rvI.crc().rpv, this.rvU.rvI.crc().heu))
      {
        AdLandingPagesProxy.getInstance().stopTask(m.b(this.rvU.rvI).cwc);
        this.rvU.b(this.rvU.rvL);
        AppMethodBeat.o(37119);
      }
    }
    else
    {
      if (TextUtils.isEmpty(m.b(this.rvU.rvI).downloadUrl))
      {
        this.rvU.b(this.rvU.rvR);
        AppMethodBeat.o(37119);
        return;
      }
      if (AdLandingPagesProxy.getInstance().isApkExist(m.b(this.rvU.rvI).cwc))
      {
        al.d(new m.a.c.3(this));
        this.rvU.b(this.rvU.rvO);
        AppMethodBeat.o(37119);
        return;
      }
      AdLandingPagesProxy.getInstance().stopTask(m.b(this.rvU.rvI).cwc);
      this.rvW = new m.a.c.a(this, (byte)0);
      AdLandingPagesProxy.getInstance().startDownload(m.b(this.rvU.rvI).cwc, m.b(this.rvU.rvI).Ca, m.b(this.rvU.rvI).cqq, m.b(this.rvU.rvI).downloadUrl, m.b(this.rvU.rvI).rrD, m.b(this.rvU.rvI).rrE, this.rvW, this.rvU.rvI.crc().rpv, this.rvU.rvI.crc().heu);
    }
    AppMethodBeat.o(37119);
  }
  
  public final boolean k(Message paramMessage)
  {
    AppMethodBeat.i(37120);
    ab.i("LogStateTransitionState", hashCode() + "[DownloadingState] recv msg.what " + paramMessage.what);
    switch (paramMessage.what)
    {
    case 2: 
    case 4: 
    case 5: 
    case 6: 
    default: 
      AppMethodBeat.o(37120);
      return false;
    case 0: 
      if ((AdLandingPagesProxy.getInstance().pauseTask(m.b(this.rvU.rvI).cwc)) && (AdLandingPagesProxy.getInstance().isPaused(m.b(this.rvU.rvI).cwc))) {
        this.rvU.b(this.rvU.rvN);
      }
      AppMethodBeat.o(37120);
      return true;
    case 1: 
      al.d(new m.a.c.4(this, paramMessage.arg1));
      AppMethodBeat.o(37120);
      return true;
    case 3: 
      this.rvU.b(this.rvU.rvP);
      AppMethodBeat.o(37120);
      return true;
    case 7: 
      this.rvU.b(this.rvU.rvN);
      AppMethodBeat.o(37120);
      return true;
    case 8: 
      m.a.a(this.rvU, this.rvU.rvI.context.getString(2131303749));
      this.rvU.b(this.rvU.rvQ);
      AppMethodBeat.o(37120);
      return true;
    }
    this.rvU.rvI.crl();
    this.rvU.b(this.rvU.rvO);
    AppMethodBeat.o(37120);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m.a.c
 * JD-Core Version:    0.7.0.1
 */