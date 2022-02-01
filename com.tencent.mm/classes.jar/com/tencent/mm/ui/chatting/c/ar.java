package com.tencent.mm.ui.chatting.c;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.b.o;
import com.tencent.mm.g.a.ph;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.bn.a;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.i;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.chatting.c.b.ae;
import com.tencent.mm.ui.chatting.c.b.ag;
import com.tencent.mm.ui.chatting.c.b.d;
import com.tencent.mm.ui.chatting.c.b.w;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.chatting.c.a.a(eYT=ag.class)
public class ar
  extends a
  implements g, h.a, ag
{
  private static boolean Gyg = false;
  private int Gyf;
  private long Gyh;
  private int fWw;
  @SuppressLint({"HandlerLeak"})
  private ap handler;
  
  public ar()
  {
    AppMethodBeat.i(35601);
    this.fWw = -1;
    this.handler = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(35597);
        if ((ar.this.cOd == null) || (!ar.this.cOd.ctF))
        {
          AppMethodBeat.o(35597);
          return;
        }
        if (!ar.this.cOd.GzO)
        {
          ad.e("MicroMsg.SignallingComponent", "current ChattingUI lose focus!");
          ar.this.cOd.GzP = true;
          AppMethodBeat.o(35597);
          return;
        }
        ar.this.cOd.GzP = false;
        if (ar.Gyg)
        {
          ar.acT();
          ((w)ar.this.cOd.be(w.class)).eXQ();
          ar.this.cOd.bCM();
        }
        AppMethodBeat.o(35597);
      }
    };
    AppMethodBeat.o(35601);
  }
  
  public final void YQ(int paramInt)
  {
    AppMethodBeat.i(35604);
    if (this.cOd == null)
    {
      ad.e("MicroMsg.SignallingComponent", "[doDirectSend] mChattingContext is null!", new Object[] { bt.eGN().toString() });
      AppMethodBeat.o(35604);
      return;
    }
    Object localObject2 = this.cOd;
    if ((((com.tencent.mm.ui.chatting.d.a)localObject2).eZa()) || (((d)((com.tencent.mm.ui.chatting.d.a)localObject2).be(d.class)).eWD())) {}
    int j;
    for (int i = 1;; i = 0)
    {
      j = ((Integer)az.arT().get(35, Integer.valueOf(10))).intValue();
      localObject1 = new LinkedList();
      ((List)localObject1).add(((com.tencent.mm.ui.chatting.d.a)localObject2).getTalkerUserName());
      if (j != -2) {
        break label212;
      }
      if ((i == 0) || ((paramInt != 1) && (paramInt != 2))) {
        break;
      }
      ad.d("MicroMsg.SignallingComponent", "oreh old logic doDirectSend not support chatStatus:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(35604);
      return;
    }
    ad.d("MicroMsg.SignallingComponent", "oreh old logic doDirectSend done chatStatus:%d", new Object[] { Integer.valueOf(paramInt) });
    Object localObject1 = new i((List)localObject1, o.hr(paramInt));
    az.aeS().a((n)localObject1, 0);
    AppMethodBeat.o(35604);
    return;
    label212:
    if ((i != 0) || (af.aHG(((com.tencent.mm.ui.chatting.d.a)localObject2).getTalkerUserName())) || (af.aHE(((com.tencent.mm.ui.chatting.d.a)localObject2).getTalkerUserName())) || (((com.tencent.mm.ui.chatting.d.a)localObject2).zgX.eKB()))
    {
      ad.d("MicroMsg.SignallingComponent", "oreh doDirectSend not support");
      AppMethodBeat.o(35604);
      return;
    }
    if (this.Gyh == 0L)
    {
      localObject2 = ((com.tencent.mm.ui.chatting.c.b.aa)this.cOd.be(com.tencent.mm.ui.chatting.c.b.aa.class)).eYo();
      if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
        this.Gyh = ((bl)((List)localObject2).get(0)).field_createTime;
      }
    }
    long l = bt.vM(this.Gyh);
    if ((j == -1) || (l > j * 1000L))
    {
      ad.d("MicroMsg.SignallingComponent", "oreh doDirectSend interval too long: %d;  interval: %d", new Object[] { Long.valueOf(l / 1000L), Integer.valueOf(j) });
      AppMethodBeat.o(35604);
      return;
    }
    ad.d("MicroMsg.SignallingComponent", "oreh doDirectSend done chatStatus:%d, delt:%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(l / 1000L) });
    localObject1 = new i((List)localObject1, o.hr(paramInt));
    az.aeS().a((n)localObject1, 0);
    AppMethodBeat.o(35604);
  }
  
  public final void a(h paramh, h.c paramc)
  {
    AppMethodBeat.i(35606);
    ad.d("MicroMsg.SignallingComponent", "on msg notify change");
    if (this.cOd == null)
    {
      ad.w("MicroMsg.SignallingComponent", "[onNotifyChange] mChattingContext is null!");
      AppMethodBeat.o(35606);
      return;
    }
    if ((this.cOd.getTalkerUserName().equals(paramc.talker)) && ("insert".equals(paramc.tyD)) && (paramc.tyE.size() > 0) && (((bl)paramc.tyE.get(0)).field_isSend == 0))
    {
      ad.i("MicroMsg.SignallingComponent", "summerbadcr oreh onNotifyChange receive a new msg flag[%d], msgSeq[%d]", new Object[] { Integer.valueOf(((bl)paramc.tyE.get(0)).field_flag), Long.valueOf(((bl)paramc.tyE.get(0)).field_msgSeq) });
      this.Gyh = bt.eGO();
    }
    AppMethodBeat.o(35606);
  }
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(35607);
    super.a(parama);
    ad.i("MicroMsg.SignallingComponent", "[onComponentInstall] hash:%s", new Object[] { this });
    az.aeS().a(new bn(new bn.a()
    {
      public final void a(e paramAnonymouse)
      {
        AppMethodBeat.i(35598);
        if (paramAnonymouse == null)
        {
          AppMethodBeat.o(35598);
          return;
        }
        ar.a(ar.this, paramAnonymouse);
        AppMethodBeat.o(35598);
      }
    }), 0);
    AppMethodBeat.o(35607);
  }
  
  public final void eQC()
  {
    AppMethodBeat.i(35609);
    az.arV();
    c.apO().a(this, Looper.getMainLooper());
    az.aeS().a(10, this);
    AppMethodBeat.o(35609);
  }
  
  public final void eQF()
  {
    AppMethodBeat.i(35610);
    az.arV();
    c.apO().a(this);
    az.aeS().b(10, this);
    AppMethodBeat.o(35610);
  }
  
  public final void eWx()
  {
    AppMethodBeat.i(35608);
    super.eWx();
    ad.i("MicroMsg.SignallingComponent", "[onComponentUnInstall] hash:%s", new Object[] { this });
    this.handler.removeCallbacksAndMessages(null);
    az.arV();
    c.apO().a(this);
    az.aeS().b(10, this);
    AppMethodBeat.o(35608);
  }
  
  public final void keepSignalling()
  {
    AppMethodBeat.i(35602);
    if (this.Gyf == -2) {
      az.aeS().a(new bn(new bn.a()
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
    if (this.cOd == null)
    {
      AppMethodBeat.o(35605);
      return;
    }
    this.cOd.dismissDialog();
    if (10 != paramn.getType())
    {
      AppMethodBeat.o(35605);
      return;
    }
    boolean bool1 = ((ae)this.cOd.be(ae.class)).eYw();
    boolean bool2 = ((ae)this.cOd.be(ae.class)).eYx();
    boolean bool3 = ((ae)this.cOd.be(ae.class)).eYA();
    if ((bool3) || (bool2) || (bool1))
    {
      ad.i("MicroMsg.SignallingComponent", "[onSceneEnd] [%s|%s|%s]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      AppMethodBeat.o(35605);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (i)paramn;
      if ((paramString.hrn != null) && (paramString.hrn.equals(this.cOd.getTalkerUserName())))
      {
        if ((paramString.content == null) || (paramString.content.length != 4))
        {
          ad.e("MicroMsg.SignallingComponent", "unknown directsend op");
          AppMethodBeat.o(35605);
          return;
        }
        paramInt1 = o.v(paramString.content, 0);
        ad.d("MicroMsg.SignallingComponent", "directsend: status=".concat(String.valueOf(paramInt1)));
        switch (paramInt1)
        {
        case 2: 
        default: 
          Gyg = false;
          ((w)this.cOd.be(w.class)).eXQ();
          if (!this.cOd.GzO)
          {
            ad.e("MicroMsg.SignallingComponent", "onSceneEnd, current ChattingUI lose focus!");
            this.cOd.GzP = true;
            AppMethodBeat.o(35605);
            return;
          }
          break;
        case 1: 
          Gyg = true;
          ((w)this.cOd.be(w.class)).setMMTitle(2131757318);
          paramString = new Message();
          this.handler.sendMessageDelayed(paramString, 15000L);
          paramString = new ph();
          com.tencent.mm.sdk.b.a.ESL.l(paramString);
          AppMethodBeat.o(35605);
          return;
        case 3: 
          Gyg = true;
          ((w)this.cOd.be(w.class)).setMMTitle(2131757319);
          paramString = new Message();
          this.handler.sendMessageDelayed(paramString, 15000L);
          AppMethodBeat.o(35605);
          return;
        }
        this.cOd.GzP = false;
        this.cOd.bCM();
      }
    }
    AppMethodBeat.o(35605);
  }
  
  public final void stopSignalling()
  {
    AppMethodBeat.i(35603);
    az.aeS().a(new bn(new bn.a()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ar
 * JD-Core Version:    0.7.0.1
 */