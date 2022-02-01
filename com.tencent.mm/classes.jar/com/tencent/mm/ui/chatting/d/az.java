package com.tencent.mm.ui.chatting.d;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.b.o;
import com.tencent.mm.g.a.qv;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.bu.a;
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
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.d.b.aa;
import com.tencent.mm.ui.chatting.d.b.ae;
import com.tencent.mm.ui.chatting.d.b.am;
import com.tencent.mm.ui.chatting.d.b.ao;
import com.tencent.mm.ui.chatting.d.b.d;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.chatting.d.a.a(gRF=ao.class)
public class az
  extends a
  implements com.tencent.mm.ak.i, i.a, ao
{
  private static boolean PtV = false;
  private int PtU;
  private long PtW;
  private int gTn;
  @SuppressLint({"HandlerLeak"})
  private MMHandler handler;
  
  public az()
  {
    AppMethodBeat.i(35601);
    this.gTn = -1;
    this.handler = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(35597);
        if ((az.this.dom == null) || (!az.this.dom.cQp))
        {
          AppMethodBeat.o(35597);
          return;
        }
        if (!az.this.dom.Pwi)
        {
          Log.e("MicroMsg.SignallingComponent", "current ChattingUI lose focus!");
          az.this.dom.Pwj = true;
          AppMethodBeat.o(35597);
          return;
        }
        az.this.dom.Pwj = false;
        if (az.PtV)
        {
          az.TT();
          ((aa)az.this.dom.bh(aa.class)).gPx();
          az.this.dom.cmy();
        }
        AppMethodBeat.o(35597);
      }
    };
    AppMethodBeat.o(35601);
  }
  
  public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.i parami, i.c paramc)
  {
    AppMethodBeat.i(35606);
    Log.d("MicroMsg.SignallingComponent", "on msg notify change");
    if (this.dom == null)
    {
      Log.w("MicroMsg.SignallingComponent", "[onNotifyChange] mChattingContext is null!");
      AppMethodBeat.o(35606);
      return;
    }
    if ((this.dom.getTalkerUserName().equals(paramc.talker)) && ("insert".equals(paramc.zqn)) && (paramc.hIs.size() > 0) && (((ca)paramc.hIs.get(0)).field_isSend == 0))
    {
      Log.i("MicroMsg.SignallingComponent", "summerbadcr oreh onNotifyChange receive a new msg flag[%d], msgSeq[%d]", new Object[] { Integer.valueOf(((ca)paramc.hIs.get(0)).field_flag), Long.valueOf(((ca)paramc.hIs.get(0)).field_msgSeq) });
      this.PtW = Util.nowMilliSecond();
    }
    AppMethodBeat.o(35606);
  }
  
  public final void a(com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(35607);
    super.a(parama);
    Log.i("MicroMsg.SignallingComponent", "[onComponentInstall] hash:%s", new Object[] { this });
    bg.azz().a(new bu(new bu.a()
    {
      public final void a(g paramAnonymousg)
      {
        AppMethodBeat.i(35598);
        if (paramAnonymousg == null)
        {
          AppMethodBeat.o(35598);
          return;
        }
        az.a(az.this, paramAnonymousg);
        AppMethodBeat.o(35598);
      }
    }), 0);
    AppMethodBeat.o(35607);
  }
  
  public final void amF(int paramInt)
  {
    AppMethodBeat.i(35604);
    if (this.dom == null)
    {
      Log.e("MicroMsg.SignallingComponent", "[doDirectSend] mChattingContext is null!", new Object[] { Util.getStack().toString() });
      AppMethodBeat.o(35604);
      return;
    }
    Object localObject2 = this.dom;
    if ((((com.tencent.mm.ui.chatting.e.a)localObject2).gRL()) || (((d)((com.tencent.mm.ui.chatting.e.a)localObject2).bh(d.class)).gOQ())) {}
    int j;
    for (int i = 1;; i = 0)
    {
      j = ((Integer)bg.aVD().get(35, Integer.valueOf(10))).intValue();
      localObject1 = new LinkedList();
      ((List)localObject1).add(((com.tencent.mm.ui.chatting.e.a)localObject2).getTalkerUserName());
      if (j != -2) {
        break label220;
      }
      if ((i == 0) || ((paramInt != 1) && (paramInt != 2))) {
        break;
      }
      Log.d("MicroMsg.SignallingComponent", "oreh old logic doDirectSend not support chatStatus:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(35604);
      return;
    }
    Log.d("MicroMsg.SignallingComponent", "oreh old logic doDirectSend done chatStatus:%d", new Object[] { Integer.valueOf(paramInt) });
    Object localObject1 = new j((List)localObject1, o.iC(paramInt));
    bg.azz().a((q)localObject1, 0);
    AppMethodBeat.o(35604);
    return;
    label220:
    if ((i != 0) || (as.bjo(((com.tencent.mm.ui.chatting.e.a)localObject2).getTalkerUserName())) || (as.bjm(((com.tencent.mm.ui.chatting.e.a)localObject2).getTalkerUserName())) || (((com.tencent.mm.ui.chatting.e.a)localObject2).GUe.gBM()))
    {
      Log.d("MicroMsg.SignallingComponent", "oreh doDirectSend not support");
      AppMethodBeat.o(35604);
      return;
    }
    if (this.PtW == 0L)
    {
      localObject2 = ((ae)this.dom.bh(ae.class)).gQL();
      if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
        this.PtW = ((ca)((List)localObject2).get(0)).field_createTime;
      }
    }
    long l = Util.milliSecondsToNow(this.PtW);
    if ((j == -1) || (l > j * 1000L))
    {
      Log.d("MicroMsg.SignallingComponent", "oreh doDirectSend interval too long: %d;  interval: %d", new Object[] { Long.valueOf(l / 1000L), Integer.valueOf(j) });
      AppMethodBeat.o(35604);
      return;
    }
    Log.d("MicroMsg.SignallingComponent", "oreh doDirectSend done chatStatus:%d, delt:%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(l / 1000L) });
    localObject1 = new j((List)localObject1, o.iC(paramInt));
    bg.azz().a((q)localObject1, 0);
    AppMethodBeat.o(35604);
  }
  
  public final void gIm()
  {
    AppMethodBeat.i(35609);
    bg.aVF();
    c.aSQ().a(this, Looper.getMainLooper());
    bg.azz().a(10, this);
    AppMethodBeat.o(35609);
  }
  
  public final void gIn()
  {
    AppMethodBeat.i(35610);
    bg.aVF();
    c.aSQ().a(this);
    bg.azz().b(10, this);
    AppMethodBeat.o(35610);
  }
  
  public final void gOK()
  {
    AppMethodBeat.i(35608);
    super.gOK();
    Log.i("MicroMsg.SignallingComponent", "[onComponentUnInstall] hash:%s", new Object[] { this });
    this.handler.removeCallbacksAndMessages(null);
    bg.aVF();
    c.aSQ().a(this);
    bg.azz().b(10, this);
    AppMethodBeat.o(35608);
  }
  
  public final void keepSignalling()
  {
    AppMethodBeat.i(35602);
    if (this.PtU == -2) {
      bg.azz().a(new bu(new bu.a()
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(35605);
    if (this.dom == null)
    {
      AppMethodBeat.o(35605);
      return;
    }
    this.dom.dismissDialog();
    if (10 != paramq.getType())
    {
      AppMethodBeat.o(35605);
      return;
    }
    boolean bool1 = ((am)this.dom.bh(am.class)).gQZ();
    boolean bool2 = ((am)this.dom.bh(am.class)).gRa();
    boolean bool3 = ((am)this.dom.bh(am.class)).gRd();
    if ((bool3) || (bool2) || (bool1))
    {
      Log.i("MicroMsg.SignallingComponent", "[onSceneEnd] [%s|%s|%s]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      AppMethodBeat.o(35605);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (j)paramq;
      if ((paramString.jje != null) && (paramString.jje.equals(this.dom.getTalkerUserName())))
      {
        if ((paramString.content == null) || (paramString.content.length != 4))
        {
          Log.e("MicroMsg.SignallingComponent", "unknown directsend op");
          AppMethodBeat.o(35605);
          return;
        }
        paramInt1 = o.v(paramString.content, 0);
        Log.d("MicroMsg.SignallingComponent", "directsend: status=".concat(String.valueOf(paramInt1)));
        switch (paramInt1)
        {
        case 2: 
        default: 
          PtV = false;
          ((aa)this.dom.bh(aa.class)).gPx();
          if (!this.dom.Pwi)
          {
            Log.e("MicroMsg.SignallingComponent", "onSceneEnd, current ChattingUI lose focus!");
            this.dom.Pwj = true;
            AppMethodBeat.o(35605);
            return;
          }
          break;
        case 1: 
          PtV = true;
          ((aa)this.dom.bh(aa.class)).setMMTitle(2131757532);
          paramString = new Message();
          this.handler.sendMessageDelayed(paramString, 15000L);
          paramString = new qv();
          EventCenter.instance.publish(paramString);
          AppMethodBeat.o(35605);
          return;
        case 3: 
          PtV = true;
          ((aa)this.dom.bh(aa.class)).setMMTitle(2131757533);
          paramString = new Message();
          this.handler.sendMessageDelayed(paramString, 15000L);
          AppMethodBeat.o(35605);
          return;
        }
        this.dom.Pwj = false;
        this.dom.cmy();
      }
    }
    AppMethodBeat.o(35605);
  }
  
  public final void stopSignalling()
  {
    AppMethodBeat.i(35603);
    bg.azz().a(new bu(new bu.a()
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
 * Qualified Name:     com.tencent.mm.ui.chatting.d.az
 * JD-Core Version:    0.7.0.1
 */