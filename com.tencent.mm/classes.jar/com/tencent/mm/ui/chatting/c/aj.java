package com.tencent.mm.ui.chatting.c;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.o;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.nu;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.bk.a;
import com.tencent.mm.model.c;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.y;
import com.tencent.mm.ui.chatting.c.b.d;
import com.tencent.mm.ui.chatting.c.b.r;
import com.tencent.mm.ui.chatting.c.b.v;
import com.tencent.mm.ui.chatting.c.b.z;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.chatting.c.a.a(dJy=com.tencent.mm.ui.chatting.c.b.ab.class)
public class aj
  extends a
  implements f, h.a, com.tencent.mm.ui.chatting.c.b.ab
{
  private static boolean zHY = false;
  private int eAS;
  @SuppressLint({"HandlerLeak"})
  private ak handler;
  private int zHX;
  private long zHZ;
  
  public aj()
  {
    AppMethodBeat.i(31699);
    this.eAS = -1;
    this.handler = new ak()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(31695);
        if ((aj.this.caz == null) || (!aj.this.caz.bSe))
        {
          AppMethodBeat.o(31695);
          return;
        }
        if (aj.zHY)
        {
          aj.Pt();
          ((r)aj.this.caz.ay(r.class)).dIv();
          aj.this.caz.aWN();
        }
        AppMethodBeat.o(31695);
      }
    };
    AppMethodBeat.o(31699);
  }
  
  public final void PJ(int paramInt)
  {
    AppMethodBeat.i(31702);
    if (this.caz == null)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.SignallingComponent", "[doDirectSend] mChattingContext is null!", new Object[] { bo.dtY().toString() });
      AppMethodBeat.o(31702);
      return;
    }
    Object localObject2 = this.caz;
    if ((((com.tencent.mm.ui.chatting.d.a)localObject2).dJF()) || (((d)((com.tencent.mm.ui.chatting.d.a)localObject2).ay(d.class)).dHw())) {}
    int j;
    for (int i = 1;; i = 0)
    {
      j = ((Integer)aw.aax().get(35, Integer.valueOf(10))).intValue();
      localObject1 = new LinkedList();
      ((List)localObject1).add(((com.tencent.mm.ui.chatting.d.a)localObject2).getTalkerUserName());
      if (j != -2) {
        break label216;
      }
      if ((i == 0) || ((paramInt != 1) && (paramInt != 2))) {
        break;
      }
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.SignallingComponent", "oreh old logic doDirectSend not support chatStatus:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(31702);
      return;
    }
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.SignallingComponent", "oreh old logic doDirectSend done chatStatus:%d", new Object[] { Integer.valueOf(paramInt) });
    Object localObject1 = new com.tencent.mm.modelsimple.h((List)localObject1, o.fT(paramInt));
    aw.Rc().a((m)localObject1, 0);
    AppMethodBeat.o(31702);
    return;
    label216:
    if ((i != 0) || (ad.are(((com.tencent.mm.ui.chatting.d.a)localObject2).getTalkerUserName())) || (ad.arc(((com.tencent.mm.ui.chatting.d.a)localObject2).getTalkerUserName())) || (((com.tencent.mm.ui.chatting.d.a)localObject2).txj.dwz()))
    {
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.SignallingComponent", "oreh doDirectSend not support");
      AppMethodBeat.o(31702);
      return;
    }
    if (this.zHZ == 0L)
    {
      localObject2 = ((v)this.caz.ay(v.class)).dIT();
      if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
        this.zHZ = ((bi)((List)localObject2).get(0)).field_createTime;
      }
    }
    long l = bo.hl(this.zHZ);
    if ((j == -1) || (l > j * 1000L))
    {
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.SignallingComponent", "oreh doDirectSend interval too long: %d;  interval: %d", new Object[] { Long.valueOf(l / 1000L), Integer.valueOf(j) });
      AppMethodBeat.o(31702);
      return;
    }
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.SignallingComponent", "oreh doDirectSend done chatStatus:%d, delt:%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(l / 1000L) });
    localObject1 = new com.tencent.mm.modelsimple.h((List)localObject1, o.fT(paramInt));
    aw.Rc().a((m)localObject1, 0);
    AppMethodBeat.o(31702);
  }
  
  public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.h paramh, h.c paramc)
  {
    AppMethodBeat.i(31704);
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.SignallingComponent", "on msg notify change");
    if (this.caz == null)
    {
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.SignallingComponent", "[onNotifyChange] mChattingContext is null!");
      AppMethodBeat.o(31704);
      return;
    }
    if ((this.caz.getTalkerUserName().equals(paramc.talker)) && ("insert".equals(paramc.oDP)) && (paramc.oDQ.size() > 0) && (((bi)paramc.oDQ.get(0)).field_isSend == 0))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SignallingComponent", "summerbadcr oreh onNotifyChange receive a new msg flag[%d], msgSeq[%d]", new Object[] { Integer.valueOf(((bi)paramc.oDQ.get(0)).field_flag), Long.valueOf(((bi)paramc.oDQ.get(0)).field_msgSeq) });
      this.zHZ = bo.aoy();
    }
    AppMethodBeat.o(31704);
  }
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(31705);
    super.a(parama);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SignallingComponent", "[onComponentInstall] hash:%s", new Object[] { this });
    aw.Rc().a(new bk(new bk.a()
    {
      public final void a(e paramAnonymouse)
      {
        AppMethodBeat.i(31696);
        if (paramAnonymouse == null)
        {
          AppMethodBeat.o(31696);
          return;
        }
        aj.a(aj.this, paramAnonymouse);
        AppMethodBeat.o(31696);
      }
    }), 0);
    AppMethodBeat.o(31705);
  }
  
  public final void dCa()
  {
    AppMethodBeat.i(31707);
    aw.aaz();
    c.YC().a(this, Looper.getMainLooper());
    aw.Rc().a(10, this);
    AppMethodBeat.o(31707);
  }
  
  public final void dCd()
  {
    AppMethodBeat.i(31708);
    aw.aaz();
    c.YC().a(this);
    aw.Rc().b(10, this);
    AppMethodBeat.o(31708);
  }
  
  public final void dHq()
  {
    AppMethodBeat.i(31706);
    super.dHq();
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SignallingComponent", "[onComponentUnInstall] hash:%s", new Object[] { this });
    this.handler.removeCallbacksAndMessages(null);
    aw.aaz();
    c.YC().a(this);
    aw.Rc().b(10, this);
    AppMethodBeat.o(31706);
  }
  
  public final void keepSignalling()
  {
    AppMethodBeat.i(31700);
    if (this.zHX == -2) {
      aw.Rc().a(new bk(new bk.a()
      {
        public final void a(e paramAnonymouse)
        {
          AppMethodBeat.i(31697);
          if (paramAnonymouse == null)
          {
            AppMethodBeat.o(31697);
            return;
          }
          paramAnonymouse.keepSignalling();
          AppMethodBeat.o(31697);
        }
      }), 0);
    }
    AppMethodBeat.o(31700);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(31703);
    if (this.caz == null)
    {
      AppMethodBeat.o(31703);
      return;
    }
    this.caz.dismissDialog();
    if (10 != paramm.getType())
    {
      AppMethodBeat.o(31703);
      return;
    }
    boolean bool1 = ((z)this.caz.ay(z.class)).dJb();
    boolean bool2 = ((z)this.caz.ay(z.class)).dJc();
    boolean bool3 = ((z)this.caz.ay(z.class)).dJf();
    if ((bool3) || (bool2) || (bool1))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SignallingComponent", "[onSceneEnd] [%s|%s|%s]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      AppMethodBeat.o(31703);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (com.tencent.mm.modelsimple.h)paramm;
      if ((paramString.fOJ != null) && (paramString.fOJ.equals(this.caz.getTalkerUserName())))
      {
        if ((paramString.content == null) || (paramString.content.length != 4))
        {
          com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.SignallingComponent", "unknown directsend op");
          AppMethodBeat.o(31703);
          return;
        }
        paramInt1 = o.r(paramString.content, 0);
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.SignallingComponent", "directsend: status=".concat(String.valueOf(paramInt1)));
      }
    }
    switch (paramInt1)
    {
    case 2: 
    default: 
      zHY = false;
      ((r)this.caz.ay(r.class)).dIv();
      this.caz.aWN();
      AppMethodBeat.o(31703);
      return;
    case 1: 
      zHY = true;
      ((r)this.caz.ay(r.class)).setMMTitle(2131298327);
      paramString = new Message();
      this.handler.sendMessageDelayed(paramString, 15000L);
      paramString = new nu();
      com.tencent.mm.sdk.b.a.ymk.l(paramString);
      AppMethodBeat.o(31703);
      return;
    }
    zHY = true;
    ((r)this.caz.ay(r.class)).setMMTitle(2131298328);
    paramString = new Message();
    this.handler.sendMessageDelayed(paramString, 15000L);
    AppMethodBeat.o(31703);
  }
  
  public final void stopSignalling()
  {
    AppMethodBeat.i(31701);
    aw.Rc().a(new bk(new aj.4(this)), 0);
    AppMethodBeat.o(31701);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.aj
 * JD-Core Version:    0.7.0.1
 */