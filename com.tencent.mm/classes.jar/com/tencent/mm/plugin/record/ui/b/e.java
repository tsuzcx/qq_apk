package com.tencent.mm.plugin.record.ui.b;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gx;
import com.tencent.mm.g.a.gx.b;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.record.b.h;
import com.tencent.mm.plugin.record.b.u;
import com.tencent.mm.plugin.record.b.u.a;
import com.tencent.mm.plugin.record.ui.RecordVoiceBaseView;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import java.util.Iterator;
import java.util.List;

public final class e
  implements h.b
{
  private u xIy;
  RecordVoiceBaseView xJi;
  
  public e()
  {
    AppMethodBeat.i(28041);
    this.xIy = new u();
    AppMethodBeat.o(28041);
  }
  
  public final void a(View paramView, int paramInt, b paramb, Object paramObject)
  {
    AppMethodBeat.i(28043);
    paramObject = paramView.findViewById(2131299480);
    this.xJi = ((RecordVoiceBaseView)paramView.findViewById(2131306503));
    if (paramb.dataType == 0)
    {
      this.xJi.setVisibility(8);
      paramObject.setVisibility(0);
      AppMethodBeat.o(28043);
      return;
    }
    if (paramb.dataType == 1)
    {
      paramObject.setVisibility(8);
      this.xJi.setVisibility(0);
      paramView = h.a(paramb);
      gx localgx = new gx();
      localgx.dub.type = 17;
      localgx.dub.dud = paramb.dtI;
      a.IvT.l(localgx);
      paramInt = localgx.duc.ret;
      if (!o.fB(paramView))
      {
        if (!bu.isNullOrNil(paramb.dtI.GzA)) {
          break label254;
        }
        paramObject.setVisibility(0);
        this.xJi.setVisibility(8);
      }
    }
    for (;;)
    {
      paramObject = this.xJi;
      int i = paramb.dtI.duration;
      paramObject.path = bu.bI(paramView, "");
      paramObject.dui = paramInt;
      if (paramObject.duration != i)
      {
        paramObject.duration = i;
        paramObject.setText((int)s.sI(i) + "''");
      }
      AppMethodBeat.o(28043);
      return;
      label254:
      ae.d("MicroMsg.VoiceViewWrapper", "restart voice %s, url %s", new Object[] { Long.valueOf(paramb.pyC.field_localId), paramb.dtI.GzA });
      paramObject = new gx();
      paramObject.dub.type = 16;
      paramObject.dub.doH = paramb.pyC.field_localId;
      a.IvT.l(paramObject);
    }
  }
  
  public final View createView(Context paramContext)
  {
    AppMethodBeat.i(28042);
    paramContext = View.inflate(paramContext, 2131495219, null);
    ((RecordVoiceBaseView)paramContext.findViewById(2131306503)).setVoiceHelper(this.xIy);
    AppMethodBeat.o(28042);
    return paramContext;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(28044);
    u localu = this.xIy;
    localu.stopPlay();
    localu.cgR();
    u.pEZ = null;
    localu.callbacks.clear();
    AppMethodBeat.o(28044);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(28045);
    if ((this.xIy != null) && (this.xIy.callbacks.size() > 0))
    {
      Iterator localIterator = this.xIy.callbacks.iterator();
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