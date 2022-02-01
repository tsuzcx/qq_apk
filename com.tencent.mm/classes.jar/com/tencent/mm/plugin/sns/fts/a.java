package com.tencent.mm.plugin.sns.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.yp;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.as;
import com.tencent.mm.plugin.sns.model.c;
import com.tencent.mm.plugin.sns.model.c.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  implements c.b
{
  public IListener QoU;
  
  public a()
  {
    AppMethodBeat.i(95172);
    this.QoU = new FTSSnsImageDownloadLogic.1(this, f.hfK);
    this.QoU.alive();
    al.hgw().a(this);
    AppMethodBeat.o(95172);
  }
  
  public final void EE(String paramString)
  {
    AppMethodBeat.i(95173);
    Log.i("MicroMsg.FTS.FTSSnsImageDownloadLogic", "onThumbFinish mediaId=%s", new Object[] { paramString });
    yp localyp = new yp();
    localyp.ibS.hAf = 2;
    localyp.ibS.mediaId = paramString;
    String str = as.mg(al.getAccSnsPath(), paramString);
    localyp.ibS.path = (str + t.aXm(paramString));
    localyp.publish();
    AppMethodBeat.o(95173);
  }
  
  public final void aXr() {}
  
  public final void w(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(306298);
    Log.i("MicroMsg.FTS.FTSSnsImageDownloadLogic", "onImageFinish mediaId=%s isOk=%s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    yp localyp = new yp();
    localyp.ibS.hAf = 5;
    localyp.ibS.mediaId = paramString;
    String str = as.mg(al.getAccSnsPath(), paramString);
    localyp.ibS.path = (str + t.aXo(paramString));
    localyp.publish();
    AppMethodBeat.o(306298);
  }
  
  public final void x(String paramString, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.fts.a
 * JD-Core Version:    0.7.0.1
 */