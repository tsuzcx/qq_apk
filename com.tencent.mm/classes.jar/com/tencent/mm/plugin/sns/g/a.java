package com.tencent.mm.plugin.sns.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.ww;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.model.c;
import com.tencent.mm.plugin.sns.model.c.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  implements c.b
{
  public IListener JSi;
  
  public a()
  {
    AppMethodBeat.i(95172);
    this.JSi = new IListener() {};
    EventCenter.instance.addListener(this.JSi);
    aj.fOD().a(this);
    AppMethodBeat.o(95172);
  }
  
  public final void aYK(String paramString)
  {
    AppMethodBeat.i(95173);
    Log.i("MicroMsg.FTS.FTSSnsImageDownloadLogic", "onThumbFinish mediaId=%s", new Object[] { paramString });
    ww localww = new ww();
    localww.fVS.fvK = 2;
    localww.fVS.mediaId = paramString;
    String str = aq.kD(aj.getAccSnsPath(), paramString);
    localww.fVS.path = (str + t.aZb(paramString));
    EventCenter.instance.publish(localww);
    AppMethodBeat.o(95173);
  }
  
  public final void cq(String paramString, boolean paramBoolean) {}
  
  public final void cr(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(247507);
    Log.i("MicroMsg.FTS.FTSSnsImageDownloadLogic", "onImageFinish mediaId=%s isOk=%s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    ww localww = new ww();
    localww.fVS.fvK = 5;
    localww.fVS.mediaId = paramString;
    String str = aq.kD(aj.getAccSnsPath(), paramString);
    localww.fVS.path = (str + t.aZd(paramString));
    EventCenter.instance.publish(localww);
    AppMethodBeat.o(247507);
  }
  
  public final void fLL() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.g.a
 * JD-Core Version:    0.7.0.1
 */