package com.tencent.mm.ui.chatting.b;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.R.l;
import com.tencent.mm.a.n;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.mx;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bi.a;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.g.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.g.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.chatting.b.b.aa;
import com.tencent.mm.ui.chatting.b.b.q;
import com.tencent.mm.ui.chatting.b.b.u;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.chatting.b.a.a(cFA=aa.class)
public class ai
  extends a
  implements com.tencent.mm.ah.f, g.a, aa
{
  private static boolean vsr = false;
  private int dDr = -1;
  @SuppressLint({"HandlerLeak"})
  private ah handler = new ai.1(this);
  private int vsq;
  private long vss;
  
  public final void Hf(int paramInt)
  {
    if (this.byx == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SignallingComponent", "[doDirectSend] mChattingContext is null!", new Object[] { bk.csb().toString() });
      return;
    }
    Object localObject2 = this.byx;
    if ((((com.tencent.mm.ui.chatting.c.a)localObject2).cFD()) || (((com.tencent.mm.ui.chatting.b.b.c)((com.tencent.mm.ui.chatting.c.a)localObject2).ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDH())) {}
    int j;
    for (int i = 1;; i = 0)
    {
      j = ((Integer)au.Hv().get(35, Integer.valueOf(10))).intValue();
      localObject1 = new LinkedList();
      ((List)localObject1).add(((com.tencent.mm.ui.chatting.c.a)localObject2).getTalkerUserName());
      if (j != -2) {
        break label192;
      }
      if ((i == 0) || ((paramInt != 1) && (paramInt != 2))) {
        break;
      }
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SignallingComponent", "oreh old logic doDirectSend not support chatStatus:%d", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SignallingComponent", "oreh old logic doDirectSend done chatStatus:%d", new Object[] { Integer.valueOf(paramInt) });
    Object localObject1 = new com.tencent.mm.modelsimple.f((List)localObject1, n.eg(paramInt));
    au.Dk().a((m)localObject1, 0);
    return;
    label192:
    if ((i != 0) || (ad.aaT(((com.tencent.mm.ui.chatting.c.a)localObject2).getTalkerUserName())) || (ad.aaR(((com.tencent.mm.ui.chatting.c.a)localObject2).getTalkerUserName())) || (((com.tencent.mm.ui.chatting.c.a)localObject2).pSb.cua()))
    {
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SignallingComponent", "oreh doDirectSend not support");
      return;
    }
    if (this.vss == 0L)
    {
      localObject2 = ((u)this.byx.ac(u.class)).cFb();
      if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
        this.vss = ((com.tencent.mm.storage.bi)((List)localObject2).get(0)).field_createTime;
      }
    }
    long l = bk.co(this.vss);
    if ((j == -1) || (l > j * 1000L))
    {
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SignallingComponent", "oreh doDirectSend interval too long: %d;  interval: %d", new Object[] { Long.valueOf(l / 1000L), Integer.valueOf(j) });
      return;
    }
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SignallingComponent", "oreh doDirectSend done chatStatus:%d, delt:%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(l / 1000L) });
    localObject1 = new com.tencent.mm.modelsimple.f((List)localObject1, n.eg(paramInt));
    au.Dk().a((m)localObject1, 0);
  }
  
  public final void a(g paramg, g.c paramc)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SignallingComponent", "on msg notify change");
    if (this.byx == null) {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.SignallingComponent", "[onNotifyChange] mChattingContext is null!");
    }
    while ((!this.byx.getTalkerUserName().equals(paramc.talker)) || (!"insert".equals(paramc.mdt)) || (paramc.mdu.size() <= 0) || (((com.tencent.mm.storage.bi)paramc.mdu.get(0)).field_isSend != 0)) {
      return;
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SignallingComponent", "summerbadcr oreh onNotifyChange receive a new msg flag[%d], msgSeq[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.storage.bi)paramc.mdu.get(0)).field_flag), Long.valueOf(((com.tencent.mm.storage.bi)paramc.mdu.get(0)).field_msgSeq) });
    this.vss = bk.UY();
  }
  
  public final void a(com.tencent.mm.ui.chatting.c.a parama)
  {
    super.a(parama);
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SignallingComponent", "[onComponentInstall] hash:%s", new Object[] { this });
    au.Dk().a(new com.tencent.mm.model.bi(new bi.a()
    {
      public final void a(e paramAnonymouse)
      {
        if (paramAnonymouse == null) {
          return;
        }
        ai.a(ai.this, paramAnonymouse);
      }
    }), 0);
  }
  
  public final void cDC()
  {
    super.cDC();
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SignallingComponent", "[onComponentUnInstall] hash:%s", new Object[] { this });
    this.handler.removeCallbacksAndMessages(null);
  }
  
  public final void cyO()
  {
    au.Hx();
    com.tencent.mm.model.c.Fy().a(this, Looper.getMainLooper());
    au.Dk().a(10, this);
  }
  
  public final void cyR()
  {
    au.Hx();
    com.tencent.mm.model.c.Fy().a(this);
    au.Dk().b(10, this);
  }
  
  public final void keepSignalling()
  {
    if (this.vsq == -2) {
      au.Dk().a(new com.tencent.mm.model.bi(new ai.3(this)), 0);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (this.byx == null) {}
    do
    {
      do
      {
        do
        {
          return;
          this.byx.dismissDialog();
        } while (10 != paramm.getType());
        boolean bool1 = ((com.tencent.mm.ui.chatting.b.b.y)this.byx.ac(com.tencent.mm.ui.chatting.b.b.y.class)).cFj();
        boolean bool2 = ((com.tencent.mm.ui.chatting.b.b.y)this.byx.ac(com.tencent.mm.ui.chatting.b.b.y.class)).cFk();
        boolean bool3 = ((com.tencent.mm.ui.chatting.b.b.y)this.byx.ac(com.tencent.mm.ui.chatting.b.b.y.class)).cFm();
        if ((bool3) || (bool2) || (bool1))
        {
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SignallingComponent", "[onSceneEnd] [%s|%s|%s]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          return;
        }
      } while ((paramInt1 != 0) || (paramInt2 != 0));
      paramString = (com.tencent.mm.modelsimple.f)paramm;
    } while ((paramString.eyU == null) || (!paramString.eyU.equals(this.byx.getTalkerUserName())));
    if ((paramString.content == null) || (paramString.content.length != 4))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SignallingComponent", "unknown directsend op");
      return;
    }
    paramInt1 = n.q(paramString.content, 0);
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SignallingComponent", "directsend: status=" + paramInt1);
    switch (paramInt1)
    {
    case 2: 
    default: 
      vsr = false;
      ((q)this.byx.ac(q.class)).cEE();
      this.byx.axW();
      return;
    case 1: 
      vsr = true;
      ((q)this.byx.ac(q.class)).setMMTitle(R.l.chatting_status_typing);
      paramString = new Message();
      this.handler.sendMessageDelayed(paramString, 15000L);
      paramString = new mx();
      com.tencent.mm.sdk.b.a.udP.m(paramString);
      return;
    }
    vsr = true;
    ((q)this.byx.ac(q.class)).setMMTitle(R.l.chatting_status_voice_typing);
    paramString = new Message();
    this.handler.sendMessageDelayed(paramString, 15000L);
  }
  
  public final void stopSignalling()
  {
    au.Dk().a(new com.tencent.mm.model.bi(new ai.4(this)), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.ai
 * JD-Core Version:    0.7.0.1
 */