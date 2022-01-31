package com.tencent.mm.plugin.record.ui.b;

import android.content.Context;
import android.view.View;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.h.a.gf;
import com.tencent.mm.h.a.gf.b;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.record.b.m;
import com.tencent.mm.plugin.record.b.m.a;
import com.tencent.mm.plugin.record.ui.RecordVoiceBaseView;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.List;

public final class e
  implements h.b
{
  RecordVoiceBaseView nuH;
  private m nup = new m();
  
  public final void a(View paramView, int paramInt, com.tencent.mm.plugin.record.ui.a.b paramb)
  {
    Object localObject = paramView.findViewById(R.h.empty_voice);
    this.nuH = ((RecordVoiceBaseView)paramView.findViewById(R.h.voice_player));
    if (paramb.aYU == 0)
    {
      this.nuH.setVisibility(8);
      ((View)localObject).setVisibility(0);
    }
    while (paramb.aYU != 1) {
      return;
    }
    ((View)localObject).setVisibility(8);
    this.nuH.setVisibility(0);
    paramView = com.tencent.mm.plugin.record.b.b.a(paramb);
    gf localgf = new gf();
    localgf.bNF.type = 17;
    localgf.bNF.bNH = paramb.bNt;
    a.udP.m(localgf);
    paramInt = localgf.bNG.ret;
    if (!com.tencent.mm.a.e.bK(paramView))
    {
      if (!bk.bl(paramb.bNt.sUG)) {
        break label238;
      }
      ((View)localObject).setVisibility(0);
      this.nuH.setVisibility(8);
    }
    for (;;)
    {
      localObject = this.nuH;
      int i = paramb.bNt.duration;
      ((RecordVoiceBaseView)localObject).path = bk.aM(paramView, "");
      ((RecordVoiceBaseView)localObject).bNM = paramInt;
      if (((RecordVoiceBaseView)localObject).duration == i) {
        break;
      }
      ((RecordVoiceBaseView)localObject).duration = i;
      ((RecordVoiceBaseView)localObject).setText((int)q.ck(i) + "''");
      return;
      label238:
      y.d("MicroMsg.VoiceViewWrapper", "restart voice %s, url %s", new Object[] { Long.valueOf(paramb.khA.field_localId), paramb.bNt.sUG });
      localObject = new gf();
      ((gf)localObject).bNF.type = 16;
      ((gf)localObject).bNF.bIr = paramb.khA.field_localId;
      a.udP.m((com.tencent.mm.sdk.b.b)localObject);
    }
  }
  
  public final View dZ(Context paramContext)
  {
    paramContext = View.inflate(paramContext, R.i.record_listitem_voice, null);
    ((RecordVoiceBaseView)paramContext.findViewById(R.h.voice_player)).setVoiceHelper(this.nup);
    return paramContext;
  }
  
  public final void destroy()
  {
    m localm = this.nup;
    localm.stopPlay();
    localm.axa();
    m.iah = null;
    localm.dhm.clear();
  }
  
  public final void pause()
  {
    if ((this.nup != null) && (this.nup.dhm.size() > 0))
    {
      Iterator localIterator = this.nup.dhm.iterator();
      while (localIterator.hasNext()) {
        ((m.a)localIterator.next()).onFinish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.e
 * JD-Core Version:    0.7.0.1
 */