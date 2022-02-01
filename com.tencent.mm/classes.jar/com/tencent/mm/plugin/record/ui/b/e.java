package com.tencent.mm.plugin.record.ui.b;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gs;
import com.tencent.mm.g.a.gs.b;
import com.tencent.mm.plugin.record.b.s.a;
import com.tencent.mm.plugin.record.ui.RecordVoiceBaseView;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.util.Iterator;
import java.util.List;

public final class e
  implements h.b
{
  private com.tencent.mm.plugin.record.b.s vbT;
  RecordVoiceBaseView vcw;
  
  public e()
  {
    AppMethodBeat.i(28041);
    this.vbT = new com.tencent.mm.plugin.record.b.s();
    AppMethodBeat.o(28041);
  }
  
  public final void a(View paramView, int paramInt, b paramb, Object paramObject)
  {
    AppMethodBeat.i(28043);
    paramObject = paramView.findViewById(2131299480);
    this.vcw = ((RecordVoiceBaseView)paramView.findViewById(2131306503));
    if (paramb.dataType == 0)
    {
      this.vcw.setVisibility(8);
      paramObject.setVisibility(0);
      AppMethodBeat.o(28043);
      return;
    }
    if (paramb.dataType == 1)
    {
      paramObject.setVisibility(8);
      this.vcw.setVisibility(0);
      paramView = com.tencent.mm.plugin.record.b.g.a(paramb);
      gs localgs = new gs();
      localgs.dkc.type = 17;
      localgs.dkc.dke = paramb.djJ;
      a.ESL.l(localgs);
      paramInt = localgs.dkd.ret;
      if (!i.eK(paramView))
      {
        if (!bt.isNullOrNil(paramb.djJ.DfZ)) {
          break label254;
        }
        paramObject.setVisibility(0);
        this.vcw.setVisibility(8);
      }
    }
    for (;;)
    {
      paramObject = this.vcw;
      int i = paramb.djJ.duration;
      paramObject.path = bt.by(paramView, "");
      paramObject.dkj = paramInt;
      if (paramObject.duration != i)
      {
        paramObject.duration = i;
        paramObject.setText((int)com.tencent.mm.modelvoice.s.mI(i) + "''");
      }
      AppMethodBeat.o(28043);
      return;
      label254:
      ad.d("MicroMsg.VoiceViewWrapper", "restart voice %s, url %s", new Object[] { Long.valueOf(paramb.okO.field_localId), paramb.djJ.DfZ });
      paramObject = new gs();
      paramObject.dkc.type = 16;
      paramObject.dkc.deL = paramb.okO.field_localId;
      a.ESL.l(paramObject);
    }
  }
  
  public final View createView(Context paramContext)
  {
    AppMethodBeat.i(28042);
    paramContext = View.inflate(paramContext, 2131495219, null);
    ((RecordVoiceBaseView)paramContext.findViewById(2131306503)).setVoiceHelper(this.vbT);
    AppMethodBeat.o(28042);
    return paramContext;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(28044);
    com.tencent.mm.plugin.record.b.s locals = this.vbT;
    locals.stopPlay();
    locals.bTJ();
    com.tencent.mm.plugin.record.b.s.orl = null;
    locals.callbacks.clear();
    AppMethodBeat.o(28044);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(28045);
    if ((this.vbT != null) && (this.vbT.callbacks.size() > 0))
    {
      Iterator localIterator = this.vbT.callbacks.iterator();
      while (localIterator.hasNext()) {
        ((s.a)localIterator.next()).onFinish();
      }
    }
    AppMethodBeat.o(28045);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.e
 * JD-Core Version:    0.7.0.1
 */