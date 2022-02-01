package com.tencent.mm.ui.chatting.component;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.tk;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.b.o;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.bw.a;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.component.api.ad;
import com.tencent.mm.ui.chatting.component.api.ah;
import com.tencent.mm.ui.chatting.component.api.aw;
import com.tencent.mm.ui.chatting.component.api.e;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=aw.class)
public class bj
  extends a
  implements h, i.a, aw
{
  private static boolean aewZ = false;
  private int aewY;
  private long aexa;
  private MMHandler handler;
  private int interval;
  
  public bj()
  {
    AppMethodBeat.i(35601);
    this.interval = -1;
    this.handler = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(35597);
        if ((bj.this.hlc == null) || (!bj.this.hlc.ffv))
        {
          AppMethodBeat.o(35597);
          return;
        }
        if (!bj.this.hlc.aezU)
        {
          Log.e("MicroMsg.SignallingComponent", "current ChattingUI lose focus!");
          bj.this.hlc.aezV = true;
          AppMethodBeat.o(35597);
          return;
        }
        bj.this.hlc.aezV = false;
        if (bj.aewZ)
        {
          bj.aAs();
          ((ad)bj.this.hlc.cm(ad.class)).jrB();
          bj.this.hlc.dcZ();
        }
        AppMethodBeat.o(35597);
      }
    };
    AppMethodBeat.o(35601);
  }
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(35607);
    super.a(parama);
    Log.i("MicroMsg.SignallingComponent", "[onComponentInstall] hash:%s", new Object[] { this });
    bh.aZW().a(new bw(new bw.a()
    {
      public final void b(g paramAnonymousg)
      {
        AppMethodBeat.i(35598);
        if (paramAnonymousg == null)
        {
          AppMethodBeat.o(35598);
          return;
        }
        bj.a(bj.this, paramAnonymousg);
        AppMethodBeat.o(35598);
      }
    }), 0);
    AppMethodBeat.o(35607);
  }
  
  public final void aCk(int paramInt)
  {
    AppMethodBeat.i(35604);
    if (this.hlc == null)
    {
      Log.e("MicroMsg.SignallingComponent", "[doDirectSend] mChattingContext is null!", new Object[] { Util.getStack().toString() });
      AppMethodBeat.o(35604);
      return;
    }
    Object localObject2 = this.hlc;
    if ((((com.tencent.mm.ui.chatting.d.a)localObject2).juF()) || (((e)((com.tencent.mm.ui.chatting.d.a)localObject2).cm(e.class)).jqW())) {}
    int j;
    for (int i = 1;; i = 0)
    {
      j = ((Integer)bh.bCx().d(35, Integer.valueOf(10))).intValue();
      localObject1 = new LinkedList();
      ((List)localObject1).add(((com.tencent.mm.ui.chatting.d.a)localObject2).getTalkerUserName());
      if (j != -2) {
        break label212;
      }
      if ((i == 0) || ((paramInt != 1) && (paramInt != 2))) {
        break;
      }
      Log.d("MicroMsg.SignallingComponent", "oreh old logic doDirectSend not support chatStatus:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(35604);
      return;
    }
    Log.d("MicroMsg.SignallingComponent", "oreh old logic doDirectSend done chatStatus:%d", new Object[] { Integer.valueOf(paramInt) });
    Object localObject1 = new l((List)localObject1, o.nE(paramInt));
    bh.aZW().a((p)localObject1, 0);
    AppMethodBeat.o(35604);
    return;
    label212:
    if ((i != 0) || (com.tencent.mm.storage.au.bwN(((com.tencent.mm.ui.chatting.d.a)localObject2).getTalkerUserName())) || (com.tencent.mm.storage.au.bwL(((com.tencent.mm.ui.chatting.d.a)localObject2).getTalkerUserName())) || (((com.tencent.mm.ui.chatting.d.a)localObject2).Uxa.iZC()))
    {
      Log.d("MicroMsg.SignallingComponent", "oreh doDirectSend not support");
      AppMethodBeat.o(35604);
      return;
    }
    if (this.aexa == 0L)
    {
      localObject2 = ((ah)this.hlc.cm(ah.class)).jth();
      if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
        this.aexa = ((cc)((List)localObject2).get(0)).getCreateTime();
      }
    }
    long l = Util.milliSecondsToNow(this.aexa);
    if ((j == -1) || (l > j * 1000L))
    {
      Log.d("MicroMsg.SignallingComponent", "oreh doDirectSend interval too long: %d;  interval: %d", new Object[] { Long.valueOf(l / 1000L), Integer.valueOf(j) });
      AppMethodBeat.o(35604);
      return;
    }
    Log.d("MicroMsg.SignallingComponent", "oreh doDirectSend done chatStatus:%d, delt:%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(l / 1000L) });
    localObject1 = new l((List)localObject1, o.nE(paramInt));
    bh.aZW().a((p)localObject1, 0);
    AppMethodBeat.o(35604);
  }
  
  public final void jjh()
  {
    AppMethodBeat.i(35609);
    bh.bCz();
    c.bzD().a(this, Looper.getMainLooper());
    bh.aZW().a(10, this);
    AppMethodBeat.o(35609);
  }
  
  public final void jjk()
  {
    AppMethodBeat.i(35610);
    bh.bCz();
    c.bzD().a(this);
    bh.aZW().b(10, this);
    AppMethodBeat.o(35610);
  }
  
  public final void jqF()
  {
    AppMethodBeat.i(35608);
    super.jqF();
    Log.i("MicroMsg.SignallingComponent", "[onComponentUnInstall] hash:%s", new Object[] { this });
    this.handler.removeCallbacksAndMessages(null);
    bh.bCz();
    c.bzD().a(this);
    bh.aZW().b(10, this);
    AppMethodBeat.o(35608);
  }
  
  public final void keepSignalling()
  {
    AppMethodBeat.i(35602);
    if (this.aewY == -2) {
      bh.aZW().a(new bw(new bw.a()
      {
        public final void b(g paramAnonymousg)
        {
          AppMethodBeat.i(35599);
          if (paramAnonymousg == null)
          {
            AppMethodBeat.o(35599);
            return;
          }
          paramAnonymousg.keepSignalling();
          AppMethodBeat.o(35599);
        }
      }), 0);
    }
    AppMethodBeat.o(35602);
  }
  
  public void onNotifyChange(i parami, i.c paramc)
  {
    AppMethodBeat.i(35606);
    Log.d("MicroMsg.SignallingComponent", "on msg notify change");
    if (this.hlc == null)
    {
      Log.w("MicroMsg.SignallingComponent", "[onNotifyChange] mChattingContext is null!");
      AppMethodBeat.o(35606);
      return;
    }
    if ((this.hlc.getTalkerUserName().equals(paramc.talker)) && ("insert".equals(paramc.KRm)) && (paramc.mZo.size() > 0) && (((cc)paramc.mZo.get(0)).field_isSend == 0))
    {
      Log.i("MicroMsg.SignallingComponent", "summerbadcr oreh onNotifyChange receive a new msg flag[%d], msgSeq[%d]", new Object[] { Integer.valueOf(((cc)paramc.mZo.get(0)).field_flag), Long.valueOf(((cc)paramc.mZo.get(0)).field_msgSeq) });
      this.aexa = Util.nowMilliSecond();
    }
    AppMethodBeat.o(35606);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(35605);
    if (this.hlc == null)
    {
      AppMethodBeat.o(35605);
      return;
    }
    this.hlc.aDM();
    if (10 != paramp.getType())
    {
      AppMethodBeat.o(35605);
      return;
    }
    boolean bool1 = ((com.tencent.mm.ui.chatting.component.api.au)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.au.class)).jty();
    boolean bool2 = ((com.tencent.mm.ui.chatting.component.api.au)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.au.class)).jtz();
    boolean bool3 = ((com.tencent.mm.ui.chatting.component.api.au)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.au.class)).jtC();
    if ((bool3) || (bool2) || (bool1))
    {
      Log.i("MicroMsg.SignallingComponent", "[onSceneEnd] [%s|%s|%s]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      AppMethodBeat.o(35605);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (l)paramp;
      if ((paramString.oSj != null) && (paramString.oSj.equals(this.hlc.getTalkerUserName())))
      {
        if ((paramString.hVd == null) || (paramString.hVd.length != 4))
        {
          Log.e("MicroMsg.SignallingComponent", "unknown directsend op");
          AppMethodBeat.o(35605);
          return;
        }
        paramInt1 = o.t(paramString.hVd, 0);
        Log.d("MicroMsg.SignallingComponent", "directsend: status=".concat(String.valueOf(paramInt1)));
        switch (paramInt1)
        {
        case 2: 
        default: 
          aewZ = false;
          ((ad)this.hlc.cm(ad.class)).jrB();
          if (!this.hlc.aezU)
          {
            Log.e("MicroMsg.SignallingComponent", "onSceneEnd, current ChattingUI lose focus!");
            this.hlc.aezV = true;
            AppMethodBeat.o(35605);
            return;
          }
          break;
        case 1: 
          aewZ = true;
          ((ad)this.hlc.cm(ad.class)).setMMTitle(R.l.gzK);
          paramString = new Message();
          this.handler.sendMessageDelayed(paramString, 15000L);
          new tk().publish();
          AppMethodBeat.o(35605);
          return;
        case 3: 
          aewZ = true;
          ((ad)this.hlc.cm(ad.class)).setMMTitle(R.l.gzL);
          paramString = new Message();
          this.handler.sendMessageDelayed(paramString, 15000L);
          AppMethodBeat.o(35605);
          return;
        }
        this.hlc.aezV = false;
        this.hlc.dcZ();
      }
    }
    AppMethodBeat.o(35605);
  }
  
  public final void stopSignalling()
  {
    AppMethodBeat.i(35603);
    bh.aZW().a(new bw(new bw.a()
    {
      public final void b(g paramAnonymousg)
      {
        AppMethodBeat.i(35600);
        if (paramAnonymousg == null)
        {
          AppMethodBeat.o(35600);
          return;
        }
        paramAnonymousg.stopSignalling();
        AppMethodBeat.o(35600);
      }
    }), 0);
    AppMethodBeat.o(35603);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.bj
 * JD-Core Version:    0.7.0.1
 */