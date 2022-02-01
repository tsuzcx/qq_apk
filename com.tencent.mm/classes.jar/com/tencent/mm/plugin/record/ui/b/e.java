package com.tencent.mm.plugin.record.ui.b;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.f.a.hi;
import com.tencent.mm.f.a.hi.b;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.record.b.h;
import com.tencent.mm.plugin.record.b.u.a;
import com.tencent.mm.plugin.record.ui.RecordVoiceBaseView;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.List;

public final class e
  implements h.b
{
  private com.tencent.mm.plugin.record.b.u HEH;
  RecordVoiceBaseView HFv;
  
  public e()
  {
    AppMethodBeat.i(28041);
    this.HEH = new com.tencent.mm.plugin.record.b.u();
    AppMethodBeat.o(28041);
  }
  
  public final void a(View paramView, int paramInt, b paramb, Object paramObject)
  {
    AppMethodBeat.i(28043);
    paramObject = paramView.findViewById(R.h.dFz);
    this.HFv = ((RecordVoiceBaseView)paramView.findViewById(R.h.voice_player));
    if (paramb.dataType == 0)
    {
      this.HFv.setVisibility(8);
      paramObject.setVisibility(0);
      AppMethodBeat.o(28043);
      return;
    }
    if (paramb.dataType == 1)
    {
      paramObject.setVisibility(8);
      this.HFv.setVisibility(0);
      paramView = h.a(paramb);
      hi localhi = new hi();
      localhi.fEb.type = 17;
      localhi.fEb.fEd = paramb.fDI;
      EventCenter.instance.publish(localhi);
      paramInt = localhi.fEc.ret;
      if (!com.tencent.mm.vfs.u.agG(paramView))
      {
        if (!Util.isNullOrNil(paramb.fDI.Rwb)) {
          break label256;
        }
        paramObject.setVisibility(0);
        this.HFv.setVisibility(8);
      }
    }
    for (;;)
    {
      paramObject = this.HFv;
      int i = paramb.fDI.duration;
      paramObject.path = Util.nullAs(paramView, "");
      paramObject.fEi = paramInt;
      if (paramObject.duration != i)
      {
        paramObject.duration = i;
        paramObject.setText((int)s.GW(i) + "''");
      }
      AppMethodBeat.o(28043);
      return;
      label256:
      Log.d("MicroMsg.VoiceViewWrapper", "restart voice %s, url %s", new Object[] { Long.valueOf(paramb.upg.field_localId), paramb.fDI.Rwb });
      paramObject = new hi();
      paramObject.fEb.type = 16;
      paramObject.fEb.fyE = paramb.upg.field_localId;
      EventCenter.instance.publish(paramObject);
    }
  }
  
  public final View createView(Context paramContext)
  {
    AppMethodBeat.i(28042);
    paramContext = View.inflate(paramContext, R.i.ekr, null);
    ((RecordVoiceBaseView)paramContext.findViewById(R.h.voice_player)).setVoiceHelper(this.HEH);
    AppMethodBeat.o(28042);
    return paramContext;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(28044);
    com.tencent.mm.plugin.record.b.u localu = this.HEH;
    localu.stopPlay();
    localu.cTk();
    com.tencent.mm.plugin.record.b.u.uww = null;
    localu.callbacks.clear();
    AppMethodBeat.o(28044);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(28045);
    if ((this.HEH != null) && (this.HEH.callbacks.size() > 0))
    {
      Iterator localIterator = this.HEH.callbacks.iterator();
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