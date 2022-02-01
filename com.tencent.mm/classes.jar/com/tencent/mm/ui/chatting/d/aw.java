package com.tencent.mm.ui.chatting.d;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.o;
import com.tencent.mm.g.a.qb;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bq.a;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.j;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.chatting.d.b.ac;
import com.tencent.mm.ui.chatting.d.b.aj;
import com.tencent.mm.ui.chatting.d.b.al;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.d.b.y;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.chatting.d.a.a(fJv=al.class)
public class aw
  extends a
  implements f, i.a, al
{
  private static boolean Kia = false;
  private int KhZ;
  private long Kib;
  private int gxu;
  @SuppressLint({"HandlerLeak"})
  private aq handler;
  
  public aw()
  {
    AppMethodBeat.i(35601);
    this.gxu = -1;
    this.handler = new aq()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(35597);
        if ((aw.this.cXJ == null) || (!aw.this.cXJ.cCq))
        {
          AppMethodBeat.o(35597);
          return;
        }
        if (!aw.this.cXJ.Kkj)
        {
          ae.e("MicroMsg.SignallingComponent", "current ChattingUI lose focus!");
          aw.this.cXJ.Kkk = true;
          AppMethodBeat.o(35597);
          return;
        }
        aw.this.cXJ.Kkk = false;
        if (aw.Kia)
        {
          aw.JG();
          ((y)aw.this.cXJ.bh(y.class)).fHr();
          aw.this.cXJ.bPl();
        }
        AppMethodBeat.o(35597);
      }
    };
    AppMethodBeat.o(35601);
  }
  
  public final void a(i parami, i.c paramc)
  {
    AppMethodBeat.i(35606);
    ae.d("MicroMsg.SignallingComponent", "on msg notify change");
    if (this.cXJ == null)
    {
      ae.w("MicroMsg.SignallingComponent", "[onNotifyChange] mChattingContext is null!");
      AppMethodBeat.o(35606);
      return;
    }
    if ((this.cXJ.getTalkerUserName().equals(paramc.talker)) && ("insert".equals(paramc.vWi)) && (paramc.gQn.size() > 0) && (((bv)paramc.gQn.get(0)).field_isSend == 0))
    {
      ae.i("MicroMsg.SignallingComponent", "summerbadcr oreh onNotifyChange receive a new msg flag[%d], msgSeq[%d]", new Object[] { Integer.valueOf(((bv)paramc.gQn.get(0)).field_flag), Long.valueOf(((bv)paramc.gQn.get(0)).field_msgSeq) });
      this.Kib = bu.fpO();
    }
    AppMethodBeat.o(35606);
  }
  
  public final void a(com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(35607);
    super.a(parama);
    ae.i("MicroMsg.SignallingComponent", "[onComponentInstall] hash:%s", new Object[] { this });
    bc.ajj().a(new bq(new bq.a()
    {
      public final void a(e paramAnonymouse)
      {
        AppMethodBeat.i(35598);
        if (paramAnonymouse == null)
        {
          AppMethodBeat.o(35598);
          return;
        }
        aw.a(aw.this, paramAnonymouse);
        AppMethodBeat.o(35598);
      }
    }), 0);
    AppMethodBeat.o(35607);
  }
  
  public final void adU(int paramInt)
  {
    AppMethodBeat.i(35604);
    if (this.cXJ == null)
    {
      ae.e("MicroMsg.SignallingComponent", "[doDirectSend] mChattingContext is null!", new Object[] { bu.fpN().toString() });
      AppMethodBeat.o(35604);
      return;
    }
    Object localObject2 = this.cXJ;
    if ((((com.tencent.mm.ui.chatting.e.a)localObject2).fJB()) || (((d)((com.tencent.mm.ui.chatting.e.a)localObject2).bh(d.class)).fGK())) {}
    int j;
    for (int i = 1;; i = 0)
    {
      j = ((Integer)bc.aCe().get(35, Integer.valueOf(10))).intValue();
      localObject1 = new LinkedList();
      ((List)localObject1).add(((com.tencent.mm.ui.chatting.e.a)localObject2).getTalkerUserName());
      if (j != -2) {
        break label220;
      }
      if ((i == 0) || ((paramInt != 1) && (paramInt != 2))) {
        break;
      }
      ae.d("MicroMsg.SignallingComponent", "oreh old logic doDirectSend not support chatStatus:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(35604);
      return;
    }
    ae.d("MicroMsg.SignallingComponent", "oreh old logic doDirectSend done chatStatus:%d", new Object[] { Integer.valueOf(paramInt) });
    Object localObject1 = new j((List)localObject1, o.hi(paramInt));
    bc.ajj().a((n)localObject1, 0);
    AppMethodBeat.o(35604);
    return;
    label220:
    if ((i != 0) || (an.aUp(((com.tencent.mm.ui.chatting.e.a)localObject2).getTalkerUserName())) || (an.aUn(((com.tencent.mm.ui.chatting.e.a)localObject2).getTalkerUserName())) || (((com.tencent.mm.ui.chatting.e.a)localObject2).Cqh.fug()))
    {
      ae.d("MicroMsg.SignallingComponent", "oreh doDirectSend not support");
      AppMethodBeat.o(35604);
      return;
    }
    if (this.Kib == 0L)
    {
      localObject2 = ((ac)this.cXJ.bh(ac.class)).fIB();
      if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
        this.Kib = ((bv)((List)localObject2).get(0)).field_createTime;
      }
    }
    long l = bu.DD(this.Kib);
    if ((j == -1) || (l > j * 1000L))
    {
      ae.d("MicroMsg.SignallingComponent", "oreh doDirectSend interval too long: %d;  interval: %d", new Object[] { Long.valueOf(l / 1000L), Integer.valueOf(j) });
      AppMethodBeat.o(35604);
      return;
    }
    ae.d("MicroMsg.SignallingComponent", "oreh doDirectSend done chatStatus:%d, delt:%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(l / 1000L) });
    localObject1 = new j((List)localObject1, o.hi(paramInt));
    bc.ajj().a((n)localObject1, 0);
    AppMethodBeat.o(35604);
  }
  
  public final void fAu()
  {
    AppMethodBeat.i(35609);
    bc.aCg();
    c.azI().a(this, Looper.getMainLooper());
    bc.ajj().a(10, this);
    AppMethodBeat.o(35609);
  }
  
  public final void fAx()
  {
    AppMethodBeat.i(35610);
    bc.aCg();
    c.azI().a(this);
    bc.ajj().b(10, this);
    AppMethodBeat.o(35610);
  }
  
  public final void fGE()
  {
    AppMethodBeat.i(35608);
    super.fGE();
    ae.i("MicroMsg.SignallingComponent", "[onComponentUnInstall] hash:%s", new Object[] { this });
    this.handler.removeCallbacksAndMessages(null);
    bc.aCg();
    c.azI().a(this);
    bc.ajj().b(10, this);
    AppMethodBeat.o(35608);
  }
  
  public final void keepSignalling()
  {
    AppMethodBeat.i(35602);
    if (this.KhZ == -2) {
      bc.ajj().a(new bq(new bq.a()
      {
        public final void a(e paramAnonymouse)
        {
          AppMethodBeat.i(35599);
          if (paramAnonymouse == null)
          {
            AppMethodBeat.o(35599);
            return;
          }
          paramAnonymouse.keepSignalling();
          AppMethodBeat.o(35599);
        }
      }), 0);
    }
    AppMethodBeat.o(35602);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(35605);
    if (this.cXJ == null)
    {
      AppMethodBeat.o(35605);
      return;
    }
    this.cXJ.dismissDialog();
    if (10 != paramn.getType())
    {
      AppMethodBeat.o(35605);
      return;
    }
    boolean bool1 = ((aj)this.cXJ.bh(aj.class)).fIP();
    boolean bool2 = ((aj)this.cXJ.bh(aj.class)).fIQ();
    boolean bool3 = ((aj)this.cXJ.bh(aj.class)).fIT();
    if ((bool3) || (bool2) || (bool1))
    {
      ae.i("MicroMsg.SignallingComponent", "[onSceneEnd] [%s|%s|%s]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      AppMethodBeat.o(35605);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (j)paramn;
      if ((paramString.inW != null) && (paramString.inW.equals(this.cXJ.getTalkerUserName())))
      {
        if ((paramString.content == null) || (paramString.content.length != 4))
        {
          ae.e("MicroMsg.SignallingComponent", "unknown directsend op");
          AppMethodBeat.o(35605);
          return;
        }
        paramInt1 = o.t(paramString.content, 0);
        ae.d("MicroMsg.SignallingComponent", "directsend: status=".concat(String.valueOf(paramInt1)));
        switch (paramInt1)
        {
        case 2: 
        default: 
          Kia = false;
          ((y)this.cXJ.bh(y.class)).fHr();
          if (!this.cXJ.Kkj)
          {
            ae.e("MicroMsg.SignallingComponent", "onSceneEnd, current ChattingUI lose focus!");
            this.cXJ.Kkk = true;
            AppMethodBeat.o(35605);
            return;
          }
          break;
        case 1: 
          Kia = true;
          ((y)this.cXJ.bh(y.class)).setMMTitle(2131757318);
          paramString = new Message();
          this.handler.sendMessageDelayed(paramString, 15000L);
          paramString = new qb();
          com.tencent.mm.sdk.b.a.IvT.l(paramString);
          AppMethodBeat.o(35605);
          return;
        case 3: 
          Kia = true;
          ((y)this.cXJ.bh(y.class)).setMMTitle(2131757319);
          paramString = new Message();
          this.handler.sendMessageDelayed(paramString, 15000L);
          AppMethodBeat.o(35605);
          return;
        }
        this.cXJ.Kkk = false;
        this.cXJ.bPl();
      }
    }
    AppMethodBeat.o(35605);
  }
  
  public final void stopSignalling()
  {
    AppMethodBeat.i(35603);
    bc.ajj().a(new bq(new bq.a()
    {
      public final void a(e paramAnonymouse)
      {
        AppMethodBeat.i(35600);
        if (paramAnonymouse == null)
        {
          AppMethodBeat.o(35600);
          return;
        }
        paramAnonymouse.stopSignalling();
        AppMethodBeat.o(35600);
      }
    }), 0);
    AppMethodBeat.o(35603);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.aw
 * JD-Core Version:    0.7.0.1
 */