package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.compatible.deviceinfo.n;
import com.tencent.mm.g.a.cj;
import com.tencent.mm.g.a.cj.b;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cf;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.plugin.notification.e;
import com.tencent.mm.plugin.setting.model.m;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ck;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.ac;
import com.tencent.mm.ui.chatting.d.b.aq;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.r;
import com.tencent.mm.ui.chatting.d.b.u;
import com.tencent.mm.ui.chatting.y;

@com.tencent.mm.ui.chatting.d.a.a(gRF=aq.class)
public class ay
  extends a
  implements com.tencent.mm.ak.i, aq
{
  private boolean Pnm = false;
  private y PtR;
  private int PtS;
  
  private void gpe()
  {
    AppMethodBeat.i(35583);
    e.b(this.PtR);
    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSendMsgEnable, this.PtS);
    this.PtS = 0;
    AppMethodBeat.o(35583);
  }
  
  private boolean hc(final String paramString, final int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(35586);
    paramString = Util.getFilterString(paramString);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.ChattingUI.SendTextComponent", "doSendMessage null");
      AppMethodBeat.o(35586);
      return false;
    }
    cj localcj = new cj();
    localcj.dFB.dFD = paramString;
    localcj.dFB.context = this.dom.Pwc.getContext();
    localcj.dFB.username = this.dom.getTalkerUserName();
    EventCenter.instance.publish(localcj);
    if (localcj.dFC.dFE)
    {
      AppMethodBeat.o(35586);
      return true;
    }
    boolean bool = WXHardCoderJNI.hcSendMsgEnable;
    int j = WXHardCoderJNI.hcSendMsgDelay;
    int k = WXHardCoderJNI.hcSendMsgCPU;
    int m = WXHardCoderJNI.hcSendMsgIO;
    if (WXHardCoderJNI.hcSendMsgThr) {
      i = com.tencent.mm.kernel.g.aAk().getProcessTid();
    }
    this.PtS = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcSendMsgTimeout, 202, WXHardCoderJNI.hcSendMsgAction, "MicroMsg.ChattingUI.SendTextComponent");
    com.tencent.mm.ui.chatting.e.a.gRP().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35582);
        if (ay.this.dom == null)
        {
          Log.w("MicroMsg.ChattingUI.SendTextComponent", "NULL == mChattingContext");
          AppMethodBeat.o(35582);
          return;
        }
        com.tencent.mm.plugin.report.service.g.Wl(20);
        if (ay.a(ay.this))
        {
          ay.this.dom.gRI();
          localObject1 = new com.tencent.mm.ar.a(ay.this.dom.GUe.field_username, paramString);
          bg.azz().a((com.tencent.mm.ak.q)localObject1, 0);
          AppMethodBeat.o(35582);
          return;
        }
        if ((((k)ay.this.dom.bh(k.class)).getCount() == 0) && (as.bjo(ay.this.dom.getTalkerUserName()))) {
          cf.aWl().f(10076, new Object[] { Integer.valueOf(1) });
        }
        String str2 = ay.this.dom.getTalkerUserName();
        if (Util.isNullOrNil(str2))
        {
          Log.e("MicroMsg.ChattingUI.SendTextComponent", "toUser is null or nil!");
          AppMethodBeat.o(35582);
          return;
        }
        int i = ab.JG(str2);
        String str3 = paramString;
        Object localObject1 = null;
        try
        {
          String str1 = ((ac)ay.this.dom.bh(ac.class)).bmM(str2);
          localObject1 = str1;
        }
        catch (NullPointerException localNullPointerException)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.ChattingUI.SendTextComponent", localNullPointerException, "", new Object[0]);
          }
          Object localObject2 = (u)ay.this.dom.bh(u.class);
          o.e locale = o.Pl((String)localObject1).tD(i);
          locale.cSx = ((u)localObject2).gPO().gK(str2, paramInt);
          locale.content = str3;
          locale.toUser = ((String)localObject1);
          locale.jdQ = ((u)localObject2).gPO().mD(str2, str3);
          locale.jdR = 5;
          localObject1 = locale.bdQ();
          localObject2 = ((o.b)localObject1).jdJ;
          if (!(localObject2 instanceof com.tencent.mm.modelmulti.i)) {
            break label386;
          }
          ((ac)ay.this.dom.bh(ac.class)).g((com.tencent.mm.modelmulti.i)localObject2);
          ((o.b)localObject1).execute();
          if (!ab.JA(str2)) {
            break label521;
          }
          localObject1 = new m(com.tencent.mm.compatible.deviceinfo.q.aoL(), paramString + " key " + ck.getFingerprint() + " local key " + ck.gEv() + "NetType:" + NetStatusUtil.getNetTypeString(ay.this.dom.Pwc.getContext().getApplicationContext()) + " hasNeon: " + n.aos() + " isArmv6: " + n.aou() + " isArmv7: " + n.aot());
          bg.azz().a((com.tencent.mm.ak.q)localObject1, 0);
          AppMethodBeat.o(35582);
        }
        if (Util.isNullOrNil((String)localObject1))
        {
          Log.w("MicroMsg.ChattingUI.SendTextComponent", "tempUser is null");
          AppMethodBeat.o(35582);
          return;
        }
        label386:
        label521:
        return;
      }
    });
    this.dom.BN(true);
    AppMethodBeat.o(35586);
    return true;
  }
  
  public final void a(com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(35587);
    super.a(parama);
    this.PtR = new y(this.dom);
    AppMethodBeat.o(35587);
  }
  
  public final void aBt(String paramString)
  {
    AppMethodBeat.i(35585);
    ((r)this.dom.bh(r.class)).bmJ(paramString);
    AppMethodBeat.o(35585);
  }
  
  public final boolean bmO(String paramString)
  {
    AppMethodBeat.i(35584);
    boolean bool = hc(paramString, 0);
    AppMethodBeat.o(35584);
    return bool;
  }
  
  public final void cFx()
  {
    AppMethodBeat.i(35591);
    if (!this.Pnm) {
      e.a(this.PtR);
    }
    this.Pnm = false;
    AppMethodBeat.o(35591);
  }
  
  public final void cFy()
  {
    AppMethodBeat.i(35592);
    e.b(this.PtR);
    AppMethodBeat.o(35592);
  }
  
  public final void gIl()
  {
    AppMethodBeat.i(35589);
    e.a(this.PtR);
    this.Pnm = true;
    AppMethodBeat.o(35589);
  }
  
  public final void gIm()
  {
    AppMethodBeat.i(35590);
    bg.azz().a(522, this);
    AppMethodBeat.o(35590);
  }
  
  public final void gIn()
  {
    AppMethodBeat.i(35593);
    bg.azz().b(522, this);
    gpe();
    AppMethodBeat.o(35593);
  }
  
  public final void gOK()
  {
    AppMethodBeat.i(35594);
    super.gOK();
    bg.azz().b(522, this);
    gpe();
    AppMethodBeat.o(35594);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(35588);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(35588);
      return;
      hc(paramIntent.getStringExtra("art_smiley_slelct_data"), 4);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(35595);
    if (this.dom != null) {
      this.dom.dismissDialog();
    }
    if (522 == paramq.getType())
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSendMsgEnable, this.PtS);
      this.PtS = 0;
    }
    AppMethodBeat.o(35595);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.ay
 * JD-Core Version:    0.7.0.1
 */