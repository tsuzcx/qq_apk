package com.tencent.mm.ui.chatting.c;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.o;
import com.tencent.mm.g.a.pq;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.bn.a;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.i;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.chatting.c.b.aa;
import com.tencent.mm.ui.chatting.c.b.ae;
import com.tencent.mm.ui.chatting.c.b.ag;
import com.tencent.mm.ui.chatting.c.b.d;
import com.tencent.mm.ui.chatting.c.b.w;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.chatting.c.a.a(foJ=ag.class)
public class ar
  extends a
  implements g, h.a, ag
{
  private static boolean HXX = false;
  private int HXW;
  private long HXY;
  private int gbd;
  @SuppressLint({"HandlerLeak"})
  private ao handler;
  
  public ar()
  {
    AppMethodBeat.i(35601);
    this.gbd = -1;
    this.handler = new ao()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(35597);
        if ((ar.this.cLy == null) || (!ar.this.cLy.cqM))
        {
          AppMethodBeat.o(35597);
          return;
        }
        if (!ar.this.cLy.HZJ)
        {
          ac.e("MicroMsg.SignallingComponent", "current ChattingUI lose focus!");
          ar.this.cLy.HZK = true;
          AppMethodBeat.o(35597);
          return;
        }
        ar.this.cLy.HZK = false;
        if (ar.HXX)
        {
          ar.adZ();
          ((w)ar.this.cLy.bf(w.class)).fnC();
          ar.this.cLy.bJU();
        }
        AppMethodBeat.o(35597);
      }
    };
    AppMethodBeat.o(35601);
  }
  
  public final void a(h paramh, h.c paramc)
  {
    AppMethodBeat.i(35606);
    ac.d("MicroMsg.SignallingComponent", "on msg notify change");
    if (this.cLy == null)
    {
      ac.w("MicroMsg.SignallingComponent", "[onNotifyChange] mChattingContext is null!");
      AppMethodBeat.o(35606);
      return;
    }
    if ((this.cLy.getTalkerUserName().equals(paramc.talker)) && ("insert".equals(paramc.uHb)) && (paramc.gtT.size() > 0) && (((bo)paramc.gtT.get(0)).field_isSend == 0))
    {
      ac.i("MicroMsg.SignallingComponent", "summerbadcr oreh onNotifyChange receive a new msg flag[%d], msgSeq[%d]", new Object[] { Integer.valueOf(((bo)paramc.gtT.get(0)).field_flag), Long.valueOf(((bo)paramc.gtT.get(0)).field_msgSeq) });
      this.HXY = bs.eWj();
    }
    AppMethodBeat.o(35606);
  }
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(35607);
    super.a(parama);
    ac.i("MicroMsg.SignallingComponent", "[onComponentInstall] hash:%s", new Object[] { this });
    az.agi().a(new bn(new bn.a()
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
  
  public final void abb(int paramInt)
  {
    AppMethodBeat.i(35604);
    if (this.cLy == null)
    {
      ac.e("MicroMsg.SignallingComponent", "[doDirectSend] mChattingContext is null!", new Object[] { bs.eWi().toString() });
      AppMethodBeat.o(35604);
      return;
    }
    Object localObject2 = this.cLy;
    if ((((com.tencent.mm.ui.chatting.d.a)localObject2).foP()) || (((d)((com.tencent.mm.ui.chatting.d.a)localObject2).bf(d.class)).fmp())) {}
    int j;
    for (int i = 1;; i = 0)
    {
      j = ((Integer)az.ayK().get(35, Integer.valueOf(10))).intValue();
      localObject1 = new LinkedList();
      ((List)localObject1).add(((com.tencent.mm.ui.chatting.d.a)localObject2).getTalkerUserName());
      if (j != -2) {
        break label220;
      }
      if ((i == 0) || ((paramInt != 1) && (paramInt != 2))) {
        break;
      }
      ac.d("MicroMsg.SignallingComponent", "oreh old logic doDirectSend not support chatStatus:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(35604);
      return;
    }
    ac.d("MicroMsg.SignallingComponent", "oreh old logic doDirectSend done chatStatus:%d", new Object[] { Integer.valueOf(paramInt) });
    Object localObject1 = new i((List)localObject1, o.ha(paramInt));
    az.agi().a((n)localObject1, 0);
    AppMethodBeat.o(35604);
    return;
    label220:
    if ((i != 0) || (ai.aNb(((com.tencent.mm.ui.chatting.d.a)localObject2).getTalkerUserName())) || (ai.aMZ(((com.tencent.mm.ui.chatting.d.a)localObject2).getTalkerUserName())) || (((com.tencent.mm.ui.chatting.d.a)localObject2).AzG.fad()))
    {
      ac.d("MicroMsg.SignallingComponent", "oreh doDirectSend not support");
      AppMethodBeat.o(35604);
      return;
    }
    if (this.HXY == 0L)
    {
      localObject2 = ((aa)this.cLy.bf(aa.class)).foa();
      if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
        this.HXY = ((bo)((List)localObject2).get(0)).field_createTime;
      }
    }
    long l = bs.Ap(this.HXY);
    if ((j == -1) || (l > j * 1000L))
    {
      ac.d("MicroMsg.SignallingComponent", "oreh doDirectSend interval too long: %d;  interval: %d", new Object[] { Long.valueOf(l / 1000L), Integer.valueOf(j) });
      AppMethodBeat.o(35604);
      return;
    }
    ac.d("MicroMsg.SignallingComponent", "oreh doDirectSend done chatStatus:%d, delt:%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(l / 1000L) });
    localObject1 = new i((List)localObject1, o.ha(paramInt));
    az.agi().a((n)localObject1, 0);
    AppMethodBeat.o(35604);
  }
  
  public final void fgi()
  {
    AppMethodBeat.i(35609);
    az.ayM();
    c.awD().a(this, Looper.getMainLooper());
    az.agi().a(10, this);
    AppMethodBeat.o(35609);
  }
  
  public final void fgl()
  {
    AppMethodBeat.i(35610);
    az.ayM();
    c.awD().a(this);
    az.agi().b(10, this);
    AppMethodBeat.o(35610);
  }
  
  public final void fmj()
  {
    AppMethodBeat.i(35608);
    super.fmj();
    ac.i("MicroMsg.SignallingComponent", "[onComponentUnInstall] hash:%s", new Object[] { this });
    this.handler.removeCallbacksAndMessages(null);
    az.ayM();
    c.awD().a(this);
    az.agi().b(10, this);
    AppMethodBeat.o(35608);
  }
  
  public final void keepSignalling()
  {
    AppMethodBeat.i(35602);
    if (this.HXW == -2) {
      az.agi().a(new bn(new bn.a()
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
    if (this.cLy == null)
    {
      AppMethodBeat.o(35605);
      return;
    }
    this.cLy.dismissDialog();
    if (10 != paramn.getType())
    {
      AppMethodBeat.o(35605);
      return;
    }
    boolean bool1 = ((ae)this.cLy.bf(ae.class)).foi();
    boolean bool2 = ((ae)this.cLy.bf(ae.class)).foj();
    boolean bool3 = ((ae)this.cLy.bf(ae.class)).fom();
    if ((bool3) || (bool2) || (bool1))
    {
      ac.i("MicroMsg.SignallingComponent", "[onSceneEnd] [%s|%s|%s]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      AppMethodBeat.o(35605);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (i)paramn;
      if ((paramString.hRP != null) && (paramString.hRP.equals(this.cLy.getTalkerUserName())))
      {
        if ((paramString.content == null) || (paramString.content.length != 4))
        {
          ac.e("MicroMsg.SignallingComponent", "unknown directsend op");
          AppMethodBeat.o(35605);
          return;
        }
        paramInt1 = o.t(paramString.content, 0);
        ac.d("MicroMsg.SignallingComponent", "directsend: status=".concat(String.valueOf(paramInt1)));
        switch (paramInt1)
        {
        case 2: 
        default: 
          HXX = false;
          ((w)this.cLy.bf(w.class)).fnC();
          if (!this.cLy.HZJ)
          {
            ac.e("MicroMsg.SignallingComponent", "onSceneEnd, current ChattingUI lose focus!");
            this.cLy.HZK = true;
            AppMethodBeat.o(35605);
            return;
          }
          break;
        case 1: 
          HXX = true;
          ((w)this.cLy.bf(w.class)).setMMTitle(2131757318);
          paramString = new Message();
          this.handler.sendMessageDelayed(paramString, 15000L);
          paramString = new pq();
          com.tencent.mm.sdk.b.a.GpY.l(paramString);
          AppMethodBeat.o(35605);
          return;
        case 3: 
          HXX = true;
          ((w)this.cLy.bf(w.class)).setMMTitle(2131757319);
          paramString = new Message();
          this.handler.sendMessageDelayed(paramString, 15000L);
          AppMethodBeat.o(35605);
          return;
        }
        this.cLy.HZK = false;
        this.cLy.bJU();
      }
    }
    AppMethodBeat.o(35605);
  }
  
  public final void stopSignalling()
  {
    AppMethodBeat.i(35603);
    az.agi().a(new bn(new bn.a()
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
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ar
 * JD-Core Version:    0.7.0.1
 */