package com.tencent.mm.plugin.record.ui.b;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gt;
import com.tencent.mm.g.a.gt.b;
import com.tencent.mm.plugin.record.b.s.a;
import com.tencent.mm.plugin.record.ui.RecordVoiceBaseView;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import java.util.Iterator;
import java.util.List;

public final class e
  implements h.b
{
  private com.tencent.mm.plugin.record.b.s wkH;
  RecordVoiceBaseView wlp;
  
  public e()
  {
    AppMethodBeat.i(28041);
    this.wkH = new com.tencent.mm.plugin.record.b.s();
    AppMethodBeat.o(28041);
  }
  
  public final void a(View paramView, int paramInt, b paramb, Object paramObject)
  {
    AppMethodBeat.i(28043);
    paramObject = paramView.findViewById(2131299480);
    this.wlp = ((RecordVoiceBaseView)paramView.findViewById(2131306503));
    if (paramb.dataType == 0)
    {
      this.wlp.setVisibility(8);
      paramObject.setVisibility(0);
      AppMethodBeat.o(28043);
      return;
    }
    if (paramb.dataType == 1)
    {
      paramObject.setVisibility(8);
      this.wlp.setVisibility(0);
      paramView = com.tencent.mm.plugin.record.b.g.a(paramb);
      gt localgt = new gt();
      localgt.dhx.type = 17;
      localgt.dhx.dhz = paramb.dhe;
      a.GpY.l(localgt);
      paramInt = localgt.dhy.ret;
      if (!i.eA(paramView))
      {
        if (!bs.isNullOrNil(paramb.dhe.Ezf)) {
          break label254;
        }
        paramObject.setVisibility(0);
        this.wlp.setVisibility(8);
      }
    }
    for (;;)
    {
      paramObject = this.wlp;
      int i = paramb.dhe.duration;
      paramObject.path = bs.bG(paramView, "");
      paramObject.dhE = paramInt;
      if (paramObject.duration != i)
      {
        paramObject.duration = i;
        paramObject.setText((int)com.tencent.mm.modelvoice.s.qw(i) + "''");
      }
      AppMethodBeat.o(28043);
      return;
      label254:
      ac.d("MicroMsg.VoiceViewWrapper", "restart voice %s, url %s", new Object[] { Long.valueOf(paramb.oOo.field_localId), paramb.dhe.Ezf });
      paramObject = new gt();
      paramObject.dhx.type = 16;
      paramObject.dhx.dcg = paramb.oOo.field_localId;
      a.GpY.l(paramObject);
    }
  }
  
  public final View createView(Context paramContext)
  {
    AppMethodBeat.i(28042);
    paramContext = View.inflate(paramContext, 2131495219, null);
    ((RecordVoiceBaseView)paramContext.findViewById(2131306503)).setVoiceHelper(this.wkH);
    AppMethodBeat.o(28042);
    return paramContext;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(28044);
    com.tencent.mm.plugin.record.b.s locals = this.wkH;
    locals.stopPlay();
    locals.caX();
    com.tencent.mm.plugin.record.b.s.oUL = null;
    locals.callbacks.clear();
    AppMethodBeat.o(28044);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(28045);
    if ((this.wkH != null) && (this.wkH.callbacks.size() > 0))
    {
      Iterator localIterator = this.wkH.callbacks.iterator();
      while (localIterator.hasNext()) {
        ((s.a)localIterator.next()).onFinish();
      }
    }
    AppMethodBeat.o(28045);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.e
 * JD-Core Version:    0.7.0.1
 */