package com.tencent.mm.plugin.multitalk.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.y;

public final class d
  implements f
{
  c.a cjU;
  com.tencent.mm.audio.b.c kJB;
  public com.tencent.pb.talkroom.sdk.d oTa;
  c oTb;
  com.tencent.pb.talkroom.sdk.c oTc;
  com.tencent.pb.talkroom.sdk.b oTd;
  com.tencent.mm.plugin.voip.model.b oTe;
  
  public d()
  {
    AppMethodBeat.i(53908);
    this.cjU = new d.2(this);
    this.oTe = new d.3(this);
    ab.i("MicroMsg.MT.MultiTalkEngine", "init multiTalk engine");
    Context localContext = ah.getContext();
    com.tencent.wecall.talkroom.model.e locale = com.tencent.wecall.talkroom.model.e.dXz();
    com.tencent.wecall.talkroom.model.e.jM(localContext);
    this.oTa = locale;
    this.oTa.dUa();
    this.oTb = new c();
    int i = bo.g((Integer)g.RL().eHM.get(1));
    this.oTa.a(p.bTF(), new d.1(this));
    this.oTa.bQ(i, r.Zn());
    g.Rc().a(1918, this);
    g.Rc().a(1919, this);
    g.Rc().a(1927, this);
    g.Rc().a(1928, this);
    g.Rc().a(1929, this);
    g.Rc().a(1931, this);
    g.Rc().a(1932, this);
    g.Rc().a(1933, this);
    g.Rc().a(1935, this);
    g.Rc().a(1937, this);
    g.Rc().a(1938, this);
    g.Rc().a(1939, this);
    AppMethodBeat.o(53908);
  }
  
  public final void jA(boolean paramBoolean)
  {
    AppMethodBeat.i(53910);
    ab.b("MicroMsg.MT.MultiTalkEngine", "setEngineHeadsetPlugged, %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {}
    for (int j = 1;; j = 0)
    {
      int i = (byte)j;
      this.oTa.setAppCmd(425, new byte[] { i }, 1);
      AppMethodBeat.o(53910);
      return;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(53909);
    paramString = (o)paramm;
    ab.i("MicroMsg.MT.MultiTalkEngine", "onSceneEnd errtype " + paramInt1 + " errCode " + paramInt2 + " cmdid " + paramString.mCmdId);
    this.oTa.e(paramInt2, paramString.lCr, paramString.mCmdId, paramString.cLl);
    AppMethodBeat.o(53909);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.d
 * JD-Core Version:    0.7.0.1
 */