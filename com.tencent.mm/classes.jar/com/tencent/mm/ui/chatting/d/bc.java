package com.tencent.mm.ui.chatting.d;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.b.o;
import com.tencent.mm.f.a.rv;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.j;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.d.b.aa;
import com.tencent.mm.ui.chatting.d.b.ae;
import com.tencent.mm.ui.chatting.d.b.ap;
import com.tencent.mm.ui.chatting.d.b.d;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.chatting.d.a.a(hRc=ap.class)
public class bc
  extends a
  implements com.tencent.mm.an.i, i.a, ap
{
  private static boolean WOy = false;
  private int WOx;
  private long WOz;
  @SuppressLint({"HandlerLeak"})
  private MMHandler handler;
  private int interval;
  
  public bc()
  {
    AppMethodBeat.i(35601);
    this.interval = -1;
    this.handler = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(35597);
        if ((bc.this.fgR == null) || (!bc.this.fgR.dgo))
        {
          AppMethodBeat.o(35597);
          return;
        }
        if (!bc.this.fgR.WQB)
        {
          Log.e("MicroMsg.SignallingComponent", "current ChattingUI lose focus!");
          bc.this.fgR.WQC = true;
          AppMethodBeat.o(35597);
          return;
        }
        bc.this.fgR.WQC = false;
        if (bc.WOy)
        {
          bc.Yy();
          ((aa)bc.this.fgR.bC(aa.class)).hOL();
          bc.this.fgR.cAe();
        }
        AppMethodBeat.o(35597);
      }
    };
    AppMethodBeat.o(35601);
  }
  
  public final void a(com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(35607);
    super.a(parama);
    Log.i("MicroMsg.SignallingComponent", "[onComponentInstall] hash:%s", new Object[] { this });
    bh.aGY().a(new bv(new bv.a()
    {
      public final void a(g paramAnonymousg)
      {
        AppMethodBeat.i(35598);
        if (paramAnonymousg == null)
        {
          AppMethodBeat.o(35598);
          return;
        }
        bc.a(bc.this, paramAnonymousg);
        AppMethodBeat.o(35598);
      }
    }), 0);
    AppMethodBeat.o(35607);
  }
  
  public final void avG(int paramInt)
  {
    AppMethodBeat.i(35604);
    if (this.fgR == null)
    {
      Log.e("MicroMsg.SignallingComponent", "[doDirectSend] mChattingContext is null!", new Object[] { Util.getStack().toString() });
      AppMethodBeat.o(35604);
      return;
    }
    Object localObject2 = this.fgR;
    if ((((com.tencent.mm.ui.chatting.e.a)localObject2).hRh()) || (((d)((com.tencent.mm.ui.chatting.e.a)localObject2).bC(d.class)).hOf())) {}
    int j;
    for (int i = 1;; i = 0)
    {
      j = ((Integer)bh.beG().b(35, Integer.valueOf(10))).intValue();
      localObject1 = new LinkedList();
      ((List)localObject1).add(((com.tencent.mm.ui.chatting.e.a)localObject2).getTalkerUserName());
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
    Object localObject1 = new j((List)localObject1, o.jO(paramInt));
    bh.aGY().a((q)localObject1, 0);
    AppMethodBeat.o(35604);
    return;
    label212:
    if ((i != 0) || (as.bvJ(((com.tencent.mm.ui.chatting.e.a)localObject2).getTalkerUserName())) || (as.bvH(((com.tencent.mm.ui.chatting.e.a)localObject2).getTalkerUserName())) || (((com.tencent.mm.ui.chatting.e.a)localObject2).NKq.hxX()))
    {
      Log.d("MicroMsg.SignallingComponent", "oreh doDirectSend not support");
      AppMethodBeat.o(35604);
      return;
    }
    if (this.WOz == 0L)
    {
      localObject2 = ((ae)this.fgR.bC(ae.class)).hQi();
      if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
        this.WOz = ((ca)((List)localObject2).get(0)).field_createTime;
      }
    }
    long l = Util.milliSecondsToNow(this.WOz);
    if ((j == -1) || (l > j * 1000L))
    {
      Log.d("MicroMsg.SignallingComponent", "oreh doDirectSend interval too long: %d;  interval: %d", new Object[] { Long.valueOf(l / 1000L), Integer.valueOf(j) });
      AppMethodBeat.o(35604);
      return;
    }
    Log.d("MicroMsg.SignallingComponent", "oreh doDirectSend done chatStatus:%d, delt:%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(l / 1000L) });
    localObject1 = new j((List)localObject1, o.jO(paramInt));
    bh.aGY().a((q)localObject1, 0);
    AppMethodBeat.o(35604);
  }
  
  public final void hGW()
  {
    AppMethodBeat.i(35609);
    bh.beI();
    c.bbO().a(this, Looper.getMainLooper());
    bh.aGY().a(10, this);
    AppMethodBeat.o(35609);
  }
  
  public final void hGZ()
  {
    AppMethodBeat.i(35610);
    bh.beI();
    c.bbO().a(this);
    bh.aGY().b(10, this);
    AppMethodBeat.o(35610);
  }
  
  public final void hNZ()
  {
    AppMethodBeat.i(35608);
    super.hNZ();
    Log.i("MicroMsg.SignallingComponent", "[onComponentUnInstall] hash:%s", new Object[] { this });
    this.handler.removeCallbacksAndMessages(null);
    bh.beI();
    c.bbO().a(this);
    bh.aGY().b(10, this);
    AppMethodBeat.o(35608);
  }
  
  public final void keepSignalling()
  {
    AppMethodBeat.i(35602);
    if (this.WOx == -2) {
      bh.aGY().a(new bv(new bv.a()
      {
        public final void a(g paramAnonymousg)
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
  
  public void onNotifyChange(com.tencent.mm.plugin.messenger.foundation.a.a.i parami, i.c paramc)
  {
    AppMethodBeat.i(35606);
    Log.d("MicroMsg.SignallingComponent", "on msg notify change");
    if (this.fgR == null)
    {
      Log.w("MicroMsg.SignallingComponent", "[onNotifyChange] mChattingContext is null!");
      AppMethodBeat.o(35606);
      return;
    }
    if ((this.fgR.getTalkerUserName().equals(paramc.talker)) && ("insert".equals(paramc.EVM)) && (paramc.kvM.size() > 0) && (((ca)paramc.kvM.get(0)).field_isSend == 0))
    {
      Log.i("MicroMsg.SignallingComponent", "summerbadcr oreh onNotifyChange receive a new msg flag[%d], msgSeq[%d]", new Object[] { Integer.valueOf(((ca)paramc.kvM.get(0)).field_flag), Long.valueOf(((ca)paramc.kvM.get(0)).field_msgSeq) });
      this.WOz = Util.nowMilliSecond();
    }
    AppMethodBeat.o(35606);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(35605);
    if (this.fgR == null)
    {
      AppMethodBeat.o(35605);
      return;
    }
    this.fgR.dismissDialog();
    if (10 != paramq.getType())
    {
      AppMethodBeat.o(35605);
      return;
    }
    boolean bool1 = ((com.tencent.mm.ui.chatting.d.b.an)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.an.class)).hQw();
    boolean bool2 = ((com.tencent.mm.ui.chatting.d.b.an)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.an.class)).hQx();
    boolean bool3 = ((com.tencent.mm.ui.chatting.d.b.an)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.an.class)).hQA();
    if ((bool3) || (bool2) || (bool1))
    {
      Log.i("MicroMsg.SignallingComponent", "[onSceneEnd] [%s|%s|%s]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      AppMethodBeat.o(35605);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (j)paramq;
      if ((paramString.lZa != null) && (paramString.lZa.equals(this.fgR.getTalkerUserName())))
      {
        if ((paramString.fPk == null) || (paramString.fPk.length != 4))
        {
          Log.e("MicroMsg.SignallingComponent", "unknown directsend op");
          AppMethodBeat.o(35605);
          return;
        }
        paramInt1 = o.v(paramString.fPk, 0);
        Log.d("MicroMsg.SignallingComponent", "directsend: status=".concat(String.valueOf(paramInt1)));
        switch (paramInt1)
        {
        case 2: 
        default: 
          WOy = false;
          ((aa)this.fgR.bC(aa.class)).hOL();
          if (!this.fgR.WQB)
          {
            Log.e("MicroMsg.SignallingComponent", "onSceneEnd, current ChattingUI lose focus!");
            this.fgR.WQC = true;
            AppMethodBeat.o(35605);
            return;
          }
          break;
        case 1: 
          WOy = true;
          ((aa)this.fgR.bC(aa.class)).setMMTitle(R.l.exg);
          paramString = new Message();
          this.handler.sendMessageDelayed(paramString, 15000L);
          paramString = new rv();
          EventCenter.instance.publish(paramString);
          AppMethodBeat.o(35605);
          return;
        case 3: 
          WOy = true;
          ((aa)this.fgR.bC(aa.class)).setMMTitle(R.l.exh);
          paramString = new Message();
          this.handler.sendMessageDelayed(paramString, 15000L);
          AppMethodBeat.o(35605);
          return;
        }
        this.fgR.WQC = false;
        this.fgR.cAe();
      }
    }
    AppMethodBeat.o(35605);
  }
  
  public final void stopSignalling()
  {
    AppMethodBeat.i(35603);
    bh.aGY().a(new bv(new bv.a()
    {
      public final void a(g paramAnonymousg)
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
 * Qualified Name:     com.tencent.mm.ui.chatting.d.bc
 * JD-Core Version:    0.7.0.1
 */