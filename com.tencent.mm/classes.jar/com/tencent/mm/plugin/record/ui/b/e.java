package com.tencent.mm.plugin.record.ui.b;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gi;
import com.tencent.mm.g.a.gi.b;
import com.tencent.mm.plugin.record.b.s.a;
import com.tencent.mm.plugin.record.ui.RecordVoiceBaseView;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.List;

public final class e
  implements h.b
{
  private com.tencent.mm.plugin.record.b.s pZX;
  RecordVoiceBaseView qaz;
  
  public e()
  {
    AppMethodBeat.i(24374);
    this.pZX = new com.tencent.mm.plugin.record.b.s();
    AppMethodBeat.o(24374);
  }
  
  public final void a(View paramView, int paramInt, b paramb, Object paramObject)
  {
    AppMethodBeat.i(153645);
    paramObject = paramView.findViewById(2131827118);
    this.qaz = ((RecordVoiceBaseView)paramView.findViewById(2131824122));
    if (paramb.dataType == 0)
    {
      this.qaz.setVisibility(8);
      paramObject.setVisibility(0);
      AppMethodBeat.o(153645);
      return;
    }
    if (paramb.dataType == 1)
    {
      paramObject.setVisibility(8);
      this.qaz.setVisibility(0);
      paramView = com.tencent.mm.plugin.record.b.g.a(paramb);
      gi localgi = new gi();
      localgi.cuX.type = 17;
      localgi.cuX.cuZ = paramb.cuL;
      a.ymk.l(localgi);
      paramInt = localgi.cuY.ret;
      if (!com.tencent.mm.a.e.cN(paramView))
      {
        if (!bo.isNullOrNil(paramb.cuL.wSC)) {
          break label251;
        }
        paramObject.setVisibility(0);
        this.qaz.setVisibility(8);
      }
    }
    for (;;)
    {
      paramObject = this.qaz;
      int i = paramb.cuL.duration;
      paramObject.path = bo.bf(paramView, "");
      paramObject.cve = paramInt;
      if (paramObject.duration != i)
      {
        paramObject.duration = i;
        paramObject.setText((int)com.tencent.mm.modelvoice.s.hi(i) + "''");
      }
      AppMethodBeat.o(153645);
      return;
      label251:
      ab.d("MicroMsg.VoiceViewWrapper", "restart voice %s, url %s", new Object[] { Long.valueOf(paramb.mCk.field_localId), paramb.cuL.wSC });
      paramObject = new gi();
      paramObject.cuX.type = 16;
      paramObject.cuX.cpM = paramb.mCk.field_localId;
      a.ymk.l(paramObject);
    }
  }
  
  public final View createView(Context paramContext)
  {
    AppMethodBeat.i(24375);
    paramContext = View.inflate(paramContext, 2130970544, null);
    ((RecordVoiceBaseView)paramContext.findViewById(2131824122)).setVoiceHelper(this.pZX);
    AppMethodBeat.o(24375);
    return paramContext;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(24377);
    com.tencent.mm.plugin.record.b.s locals = this.pZX;
    locals.stopPlay();
    locals.bwC();
    com.tencent.mm.plugin.record.b.s.mub = null;
    locals.callbacks.clear();
    AppMethodBeat.o(24377);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(24378);
    if ((this.pZX != null) && (this.pZX.callbacks.size() > 0))
    {
      Iterator localIterator = this.pZX.callbacks.iterator();
      while (localIterator.hasNext()) {
        ((s.a)localIterator.next()).onFinish();
      }
    }
    AppMethodBeat.o(24378);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.e
 * JD-Core Version:    0.7.0.1
 */