package com.tencent.mm.ui.chatting.d;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.b.o;
import com.tencent.mm.g.a.qa;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bo;
import com.tencent.mm.model.bo.a;
import com.tencent.mm.model.c;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.chatting.d.b.ac;
import com.tencent.mm.ui.chatting.d.b.ai;
import com.tencent.mm.ui.chatting.d.b.ak;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.d.b.y;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.chatting.d.a.a(fFo=ak.class)
public class av
  extends a
  implements f, i.a, ak
{
  private static boolean JNd = false;
  private int JNc;
  private long JNe;
  private int guN;
  @SuppressLint({"HandlerLeak"})
  private ap handler;
  
  public av()
  {
    AppMethodBeat.i(35601);
    this.guN = -1;
    this.handler = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(35597);
        if ((av.this.cWM == null) || (!av.this.cWM.cBJ))
        {
          AppMethodBeat.o(35597);
          return;
        }
        if (!av.this.cWM.JOX)
        {
          ad.e("MicroMsg.SignallingComponent", "current ChattingUI lose focus!");
          av.this.cWM.JOY = true;
          AppMethodBeat.o(35597);
          return;
        }
        av.this.cWM.JOY = false;
        if (av.JNd)
        {
          av.Jy();
          ((y)av.this.cWM.bh(y.class)).fDo();
          av.this.cWM.bOo();
        }
        AppMethodBeat.o(35597);
      }
    };
    AppMethodBeat.o(35601);
  }
  
  public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.i parami, i.c paramc)
  {
    AppMethodBeat.i(35606);
    ad.d("MicroMsg.SignallingComponent", "on msg notify change");
    if (this.cWM == null)
    {
      ad.w("MicroMsg.SignallingComponent", "[onNotifyChange] mChattingContext is null!");
      AppMethodBeat.o(35606);
      return;
    }
    if ((this.cWM.getTalkerUserName().equals(paramc.talker)) && ("insert".equals(paramc.vKe)) && (paramc.gNE.size() > 0) && (((bu)paramc.gNE.get(0)).field_isSend == 0))
    {
      ad.i("MicroMsg.SignallingComponent", "summerbadcr oreh onNotifyChange receive a new msg flag[%d], msgSeq[%d]", new Object[] { Integer.valueOf(((bu)paramc.gNE.get(0)).field_flag), Long.valueOf(((bu)paramc.gNE.get(0)).field_msgSeq) });
      this.JNe = bt.flT();
    }
    AppMethodBeat.o(35606);
  }
  
  public final void a(com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(35607);
    super.a(parama);
    ad.i("MicroMsg.SignallingComponent", "[onComponentInstall] hash:%s", new Object[] { this });
    ba.aiU().a(new bo(new bo.a()
    {
      public final void a(e paramAnonymouse)
      {
        AppMethodBeat.i(35598);
        if (paramAnonymouse == null)
        {
          AppMethodBeat.o(35598);
          return;
        }
        av.a(av.this, paramAnonymouse);
        AppMethodBeat.o(35598);
      }
    }), 0);
    AppMethodBeat.o(35607);
  }
  
  public final void adn(int paramInt)
  {
    AppMethodBeat.i(35604);
    if (this.cWM == null)
    {
      ad.e("MicroMsg.SignallingComponent", "[doDirectSend] mChattingContext is null!", new Object[] { bt.flS().toString() });
      AppMethodBeat.o(35604);
      return;
    }
    Object localObject2 = this.cWM;
    if ((((com.tencent.mm.ui.chatting.e.a)localObject2).fFu()) || (((d)((com.tencent.mm.ui.chatting.e.a)localObject2).bh(d.class)).fCI())) {}
    int j;
    for (int i = 1;; i = 0)
    {
      j = ((Integer)ba.aBO().get(35, Integer.valueOf(10))).intValue();
      localObject1 = new LinkedList();
      ((List)localObject1).add(((com.tencent.mm.ui.chatting.e.a)localObject2).getTalkerUserName());
      if (j != -2) {
        break label220;
      }
      if ((i == 0) || ((paramInt != 1) && (paramInt != 2))) {
        break;
      }
      ad.d("MicroMsg.SignallingComponent", "oreh old logic doDirectSend not support chatStatus:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(35604);
      return;
    }
    ad.d("MicroMsg.SignallingComponent", "oreh old logic doDirectSend done chatStatus:%d", new Object[] { Integer.valueOf(paramInt) });
    Object localObject1 = new com.tencent.mm.modelsimple.i((List)localObject1, o.hh(paramInt));
    ba.aiU().a((n)localObject1, 0);
    AppMethodBeat.o(35604);
    return;
    label220:
    if ((i != 0) || (am.aSP(((com.tencent.mm.ui.chatting.e.a)localObject2).getTalkerUserName())) || (am.aSN(((com.tencent.mm.ui.chatting.e.a)localObject2).getTalkerUserName())) || (((com.tencent.mm.ui.chatting.e.a)localObject2).BYG.fqg()))
    {
      ad.d("MicroMsg.SignallingComponent", "oreh doDirectSend not support");
      AppMethodBeat.o(35604);
      return;
    }
    if (this.JNe == 0L)
    {
      localObject2 = ((ac)this.cWM.bh(ac.class)).fEx();
      if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
        this.JNe = ((bu)((List)localObject2).get(0)).field_createTime;
      }
    }
    long l = bt.Df(this.JNe);
    if ((j == -1) || (l > j * 1000L))
    {
      ad.d("MicroMsg.SignallingComponent", "oreh doDirectSend interval too long: %d;  interval: %d", new Object[] { Long.valueOf(l / 1000L), Integer.valueOf(j) });
      AppMethodBeat.o(35604);
      return;
    }
    ad.d("MicroMsg.SignallingComponent", "oreh doDirectSend done chatStatus:%d, delt:%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(l / 1000L) });
    localObject1 = new com.tencent.mm.modelsimple.i((List)localObject1, o.hh(paramInt));
    ba.aiU().a((n)localObject1, 0);
    AppMethodBeat.o(35604);
  }
  
  public final void fCC()
  {
    AppMethodBeat.i(35608);
    super.fCC();
    ad.i("MicroMsg.SignallingComponent", "[onComponentUnInstall] hash:%s", new Object[] { this });
    this.handler.removeCallbacksAndMessages(null);
    ba.aBQ();
    c.azs().a(this);
    ba.aiU().b(10, this);
    AppMethodBeat.o(35608);
  }
  
  public final void fwu()
  {
    AppMethodBeat.i(35609);
    ba.aBQ();
    c.azs().a(this, Looper.getMainLooper());
    ba.aiU().a(10, this);
    AppMethodBeat.o(35609);
  }
  
  public final void fwx()
  {
    AppMethodBeat.i(35610);
    ba.aBQ();
    c.azs().a(this);
    ba.aiU().b(10, this);
    AppMethodBeat.o(35610);
  }
  
  public final void keepSignalling()
  {
    AppMethodBeat.i(35602);
    if (this.JNc == -2) {
      ba.aiU().a(new bo(new bo.a()
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
    if (this.cWM == null)
    {
      AppMethodBeat.o(35605);
      return;
    }
    this.cWM.dismissDialog();
    if (10 != paramn.getType())
    {
      AppMethodBeat.o(35605);
      return;
    }
    boolean bool1 = ((ai)this.cWM.bh(ai.class)).fEM();
    boolean bool2 = ((ai)this.cWM.bh(ai.class)).fEN();
    boolean bool3 = ((ai)this.cWM.bh(ai.class)).fEQ();
    if ((bool3) || (bool2) || (bool1))
    {
      ad.i("MicroMsg.SignallingComponent", "[onSceneEnd] [%s|%s|%s]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      AppMethodBeat.o(35605);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (com.tencent.mm.modelsimple.i)paramn;
      if ((paramString.ild != null) && (paramString.ild.equals(this.cWM.getTalkerUserName())))
      {
        if ((paramString.content == null) || (paramString.content.length != 4))
        {
          ad.e("MicroMsg.SignallingComponent", "unknown directsend op");
          AppMethodBeat.o(35605);
          return;
        }
        paramInt1 = o.t(paramString.content, 0);
        ad.d("MicroMsg.SignallingComponent", "directsend: status=".concat(String.valueOf(paramInt1)));
        switch (paramInt1)
        {
        case 2: 
        default: 
          JNd = false;
          ((y)this.cWM.bh(y.class)).fDo();
          if (!this.cWM.JOX)
          {
            ad.e("MicroMsg.SignallingComponent", "onSceneEnd, current ChattingUI lose focus!");
            this.cWM.JOY = true;
            AppMethodBeat.o(35605);
            return;
          }
          break;
        case 1: 
          JNd = true;
          ((y)this.cWM.bh(y.class)).setMMTitle(2131757318);
          paramString = new Message();
          this.handler.sendMessageDelayed(paramString, 15000L);
          paramString = new qa();
          com.tencent.mm.sdk.b.a.IbL.l(paramString);
          AppMethodBeat.o(35605);
          return;
        case 3: 
          JNd = true;
          ((y)this.cWM.bh(y.class)).setMMTitle(2131757319);
          paramString = new Message();
          this.handler.sendMessageDelayed(paramString, 15000L);
          AppMethodBeat.o(35605);
          return;
        }
        this.cWM.JOY = false;
        this.cWM.bOo();
      }
    }
    AppMethodBeat.o(35605);
  }
  
  public final void stopSignalling()
  {
    AppMethodBeat.i(35603);
    ba.aiU().a(new bo(new bo.a()
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
 * Qualified Name:     com.tencent.mm.ui.chatting.d.av
 * JD-Core Version:    0.7.0.1
 */