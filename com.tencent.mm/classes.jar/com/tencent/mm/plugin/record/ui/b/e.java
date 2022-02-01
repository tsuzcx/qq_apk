package com.tencent.mm.plugin.record.ui.b;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.g.a.gw.b;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.record.b.h;
import com.tencent.mm.plugin.record.b.u;
import com.tencent.mm.plugin.record.b.u.a;
import com.tencent.mm.plugin.record.ui.RecordVoiceBaseView;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.util.Iterator;
import java.util.List;

public final class e
  implements h.b
{
  private u xsB;
  RecordVoiceBaseView xtl;
  
  public e()
  {
    AppMethodBeat.i(28041);
    this.xsB = new u();
    AppMethodBeat.o(28041);
  }
  
  public final void a(View paramView, int paramInt, b paramb, Object paramObject)
  {
    AppMethodBeat.i(28043);
    paramObject = paramView.findViewById(2131299480);
    this.xtl = ((RecordVoiceBaseView)paramView.findViewById(2131306503));
    if (paramb.dataType == 0)
    {
      this.xtl.setVisibility(8);
      paramObject.setVisibility(0);
      AppMethodBeat.o(28043);
      return;
    }
    if (paramb.dataType == 1)
    {
      paramObject.setVisibility(8);
      this.xtl.setVisibility(0);
      paramView = h.a(paramb);
      gw localgw = new gw();
      localgw.dsV.type = 17;
      localgw.dsV.dsX = paramb.dsC;
      a.IbL.l(localgw);
      paramInt = localgw.dsW.ret;
      if (!i.fv(paramView))
      {
        if (!bt.isNullOrNil(paramb.dsC.GgR)) {
          break label254;
        }
        paramObject.setVisibility(0);
        this.xtl.setVisibility(8);
      }
    }
    for (;;)
    {
      paramObject = this.xtl;
      int i = paramb.dsC.duration;
      paramObject.path = bt.bI(paramView, "");
      paramObject.dtc = paramInt;
      if (paramObject.duration != i)
      {
        paramObject.duration = i;
        paramObject.setText((int)s.sv(i) + "''");
      }
      AppMethodBeat.o(28043);
      return;
      label254:
      ad.d("MicroMsg.VoiceViewWrapper", "restart voice %s, url %s", new Object[] { Long.valueOf(paramb.prW.field_localId), paramb.dsC.GgR });
      paramObject = new gw();
      paramObject.dsV.type = 16;
      paramObject.dsV.dnC = paramb.prW.field_localId;
      a.IbL.l(paramObject);
    }
  }
  
  public final View createView(Context paramContext)
  {
    AppMethodBeat.i(28042);
    paramContext = View.inflate(paramContext, 2131495219, null);
    ((RecordVoiceBaseView)paramContext.findViewById(2131306503)).setVoiceHelper(this.xsB);
    AppMethodBeat.o(28042);
    return paramContext;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(28044);
    u localu = this.xsB;
    localu.stopPlay();
    localu.cfB();
    u.pyv = null;
    localu.callbacks.clear();
    AppMethodBeat.o(28044);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(28045);
    if ((this.xsB != null) && (this.xsB.callbacks.size() > 0))
    {
      Iterator localIterator = this.xsB.callbacks.iterator();
      while (localIterator.hasNext()) {
        ((u.a)localIterator.next()).onFinish();
      }
    }
    AppMethodBeat.o(28045);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.e
 * JD-Core Version:    0.7.0.1
 */