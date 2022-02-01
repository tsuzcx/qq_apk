package com.tencent.mm.plugin.record.ui.b;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.g.a.hb.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.record.b.h;
import com.tencent.mm.plugin.record.b.u;
import com.tencent.mm.plugin.record.b.u.a;
import com.tencent.mm.plugin.record.ui.RecordVoiceBaseView;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.List;

public final class e
  implements h.b
{
  private u BIz;
  RecordVoiceBaseView BJl;
  
  public e()
  {
    AppMethodBeat.i(28041);
    this.BIz = new u();
    AppMethodBeat.o(28041);
  }
  
  public final void a(View paramView, int paramInt, b paramb, Object paramObject)
  {
    AppMethodBeat.i(28043);
    paramObject = paramView.findViewById(2131300113);
    this.BJl = ((RecordVoiceBaseView)paramView.findViewById(2131309963));
    if (paramb.dataType == 0)
    {
      this.BJl.setVisibility(8);
      paramObject.setVisibility(0);
      AppMethodBeat.o(28043);
      return;
    }
    if (paramb.dataType == 1)
    {
      paramObject.setVisibility(8);
      this.BJl.setVisibility(0);
      paramView = h.a(paramb);
      hb localhb = new hb();
      localhb.dLm.type = 17;
      localhb.dLm.dLo = paramb.dKT;
      EventCenter.instance.publish(localhb);
      paramInt = localhb.dLn.ret;
      if (!com.tencent.mm.vfs.s.YS(paramView))
      {
        if (!Util.isNullOrNil(paramb.dKT.KuR)) {
          break label254;
        }
        paramObject.setVisibility(0);
        this.BJl.setVisibility(8);
      }
    }
    for (;;)
    {
      paramObject = this.BJl;
      int i = paramb.dKT.duration;
      paramObject.path = Util.nullAs(paramView, "");
      paramObject.dLt = paramInt;
      if (paramObject.duration != i)
      {
        paramObject.duration = i;
        paramObject.setText((int)com.tencent.mm.modelvoice.s.AO(i) + "''");
      }
      AppMethodBeat.o(28043);
      return;
      label254:
      Log.d("MicroMsg.VoiceViewWrapper", "restart voice %s, url %s", new Object[] { Long.valueOf(paramb.qNT.field_localId), paramb.dKT.KuR });
      paramObject = new hb();
      paramObject.dLm.type = 16;
      paramObject.dLm.dFW = paramb.qNT.field_localId;
      EventCenter.instance.publish(paramObject);
    }
  }
  
  public final View createView(Context paramContext)
  {
    AppMethodBeat.i(28042);
    paramContext = View.inflate(paramContext, 2131496062, null);
    ((RecordVoiceBaseView)paramContext.findViewById(2131309963)).setVoiceHelper(this.BIz);
    AppMethodBeat.o(28042);
    return paramContext;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(28044);
    u localu = this.BIz;
    localu.stopPlay();
    localu.cEE();
    u.qUq = null;
    localu.callbacks.clear();
    AppMethodBeat.o(28044);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(28045);
    if ((this.BIz != null) && (this.BIz.callbacks.size() > 0))
    {
      Iterator localIterator = this.BIz.callbacks.iterator();
      while (localIterator.hasNext()) {
        ((u.a)localIterator.next()).onFinish();
      }
    }
    AppMethodBeat.o(28045);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.e
 * JD-Core Version:    0.7.0.1
 */