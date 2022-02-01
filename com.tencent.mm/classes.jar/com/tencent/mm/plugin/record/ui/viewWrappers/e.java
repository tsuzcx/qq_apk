package com.tencent.mm.plugin.record.ui.viewWrappers;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.autogen.a.ht;
import com.tencent.mm.autogen.a.ht.b;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.record.model.i;
import com.tencent.mm.plugin.record.model.u;
import com.tencent.mm.plugin.record.model.u.a;
import com.tencent.mm.plugin.record.ui.RecordVoiceBaseView;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.util.Iterator;
import java.util.List;

public final class e
  implements h.b
{
  RecordVoiceBaseView NCX;
  private u NCj;
  
  public e()
  {
    AppMethodBeat.i(28041);
    this.NCj = new u();
    AppMethodBeat.o(28041);
  }
  
  public final void a(View paramView, int paramInt, b paramb, Object paramObject)
  {
    AppMethodBeat.i(28043);
    paramObject = paramView.findViewById(R.h.fGF);
    this.NCX = ((RecordVoiceBaseView)paramView.findViewById(R.h.voice_player));
    if (paramb.dataType == 0)
    {
      this.NCX.setVisibility(8);
      paramObject.setVisibility(0);
      AppMethodBeat.o(28043);
      return;
    }
    if (paramb.dataType == 1)
    {
      paramObject.setVisibility(8);
      this.NCX.setVisibility(0);
      paramView = i.a(paramb);
      ht localht = new ht();
      localht.hIR.type = 17;
      localht.hIR.hIT = paramb.hIy;
      localht.publish();
      paramInt = localht.hIS.ret;
      if (!y.ZC(paramView))
      {
        if (!Util.isNullOrNil(paramb.hIy.Ysw)) {
          break label253;
        }
        paramObject.setVisibility(0);
        this.NCX.setVisibility(8);
      }
    }
    for (;;)
    {
      paramObject = this.NCX;
      int i = paramb.hIy.duration;
      paramObject.path = Util.nullAs(paramView, "");
      paramObject.hIY = paramInt;
      if (paramObject.duration != i)
      {
        paramObject.duration = i;
        paramObject.setText((int)s.jh(i) + "''");
      }
      AppMethodBeat.o(28043);
      return;
      label253:
      Log.d("MicroMsg.VoiceViewWrapper", "restart voice %s, url %s", new Object[] { Long.valueOf(paramb.xvD.field_localId), paramb.hIy.Ysw });
      paramObject = new ht();
      paramObject.hIR.type = 16;
      paramObject.hIR.hDn = paramb.xvD.field_localId;
      paramObject.publish();
    }
  }
  
  public final View createView(Context paramContext)
  {
    AppMethodBeat.i(28042);
    paramContext = View.inflate(paramContext, R.i.gnw, null);
    ((RecordVoiceBaseView)paramContext.findViewById(R.h.voice_player)).setVoiceHelper(this.NCj);
    AppMethodBeat.o(28042);
    return paramContext;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(28044);
    u localu = this.NCj;
    localu.stopPlay();
    localu.dxD();
    u.xCV = null;
    localu.bPE.clear();
    AppMethodBeat.o(28044);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(28045);
    if ((this.NCj != null) && (this.NCj.bPE.size() > 0))
    {
      Iterator localIterator = this.NCj.bPE.iterator();
      while (localIterator.hasNext()) {
        ((u.a)localIterator.next()).onFinish();
      }
    }
    AppMethodBeat.o(28045);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.viewWrappers.e
 * JD-Core Version:    0.7.0.1
 */