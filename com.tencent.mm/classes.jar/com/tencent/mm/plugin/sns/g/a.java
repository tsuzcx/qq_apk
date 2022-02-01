package com.tencent.mm.plugin.sns.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vr;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.model.c;
import com.tencent.mm.plugin.sns.model.c.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  implements c.b
{
  public IListener DFm;
  
  public a()
  {
    AppMethodBeat.i(95172);
    this.DFm = new IListener() {};
    EventCenter.instance.addListener(this.DFm);
    aj.faJ().a(this);
    AppMethodBeat.o(95172);
  }
  
  public final void aOG(String paramString)
  {
    AppMethodBeat.i(95173);
    Log.i("MicroMsg.FTS.FTSSnsImageDownloadLogic", "onThumbFinish mediaId=%s", new Object[] { paramString });
    vr localvr = new vr();
    localvr.ebQ.dDe = 2;
    localvr.ebQ.mediaId = paramString;
    String str = ar.ki(aj.getAccSnsPath(), paramString);
    localvr.ebQ.path = (str + r.aOf(paramString));
    EventCenter.instance.publish(localvr);
    AppMethodBeat.o(95173);
  }
  
  public final void ci(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(202663);
    Log.i("MicroMsg.FTS.FTSSnsImageDownloadLogic", "onImageFinish mediaId=%s isOk=%s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    vr localvr = new vr();
    localvr.ebQ.dDe = 5;
    localvr.ebQ.mediaId = paramString;
    String str = ar.ki(aj.getAccSnsPath(), paramString);
    localvr.ebQ.path = (str + r.aOh(paramString));
    EventCenter.instance.publish(localvr);
    AppMethodBeat.o(202663);
  }
  
  public final void cj(String paramString, boolean paramBoolean) {}
  
  public final void eZJ() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.g.a
 * JD-Core Version:    0.7.0.1
 */