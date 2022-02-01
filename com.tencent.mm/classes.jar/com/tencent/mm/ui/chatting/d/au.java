package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.g.a.ch.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.w;
import com.tencent.mm.modelmulti.i;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.plugin.notification.d;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingAnimFrame;
import com.tencent.mm.ui.chatting.d.b.aa;
import com.tencent.mm.ui.chatting.d.b.ac;
import com.tencent.mm.ui.chatting.d.b.s;
import com.tencent.mm.ui.chatting.x;
import com.tencent.mm.ui.chatting.z;
import java.util.List;

@com.tencent.mm.ui.chatting.d.a.a(fFo=com.tencent.mm.ui.chatting.d.b.am.class)
public class au
  extends a
  implements com.tencent.mm.al.f, com.tencent.mm.ui.chatting.d.b.am
{
  private boolean JGZ = false;
  private x JMZ;
  private int JNa;
  
  private void fch()
  {
    AppMethodBeat.i(35583);
    if (this.JMZ != null)
    {
      Object localObject = this.JMZ;
      if (((x)localObject).JDx != null)
      {
        localObject = ((x)localObject).JDx;
        ((z)localObject).mHandler.removeMessages(0);
        if (((z)localObject).JDz != null) {
          ((z)localObject).JDz.stop();
        }
        ad.i("MicroMsg.EggMgr", "egg has been stop, %s", new Object[] { ((z)localObject).JDz });
      }
    }
    d.b(this.JMZ);
    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSendMsgEnable, this.JNa);
    this.JNa = 0;
    AppMethodBeat.o(35583);
  }
  
  private boolean gA(final String paramString, final int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(35586);
    paramString = bt.aRu(paramString);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.e("MicroMsg.ChattingUI.SendTextComponent", "doSendMessage null");
      AppMethodBeat.o(35586);
      return false;
    }
    this.JMZ.amZ(paramString);
    ch localch = new ch();
    localch.dnl.dnn = paramString;
    localch.dnl.context = this.cWM.JOR.getContext();
    localch.dnl.username = this.cWM.getTalkerUserName();
    com.tencent.mm.sdk.b.a.IbL.l(localch);
    if (localch.dnm.dno)
    {
      AppMethodBeat.o(35586);
      return true;
    }
    boolean bool = WXHardCoderJNI.hcSendMsgEnable;
    int j = WXHardCoderJNI.hcSendMsgDelay;
    int k = WXHardCoderJNI.hcSendMsgCPU;
    int m = WXHardCoderJNI.hcSendMsgIO;
    if (WXHardCoderJNI.hcSendMsgThr) {
      i = g.ajF().fkS();
    }
    this.JNa = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcSendMsgTimeout, 202, WXHardCoderJNI.hcSendMsgAction, "MicroMsg.ChattingUI.SendTextComponent");
    com.tencent.mm.ui.chatting.e.a.fFx().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35582);
        if (au.this.cWM == null)
        {
          ad.w("MicroMsg.ChattingUI.SendTextComponent", "NULL == mChattingContext");
          AppMethodBeat.o(35582);
          return;
        }
        com.tencent.mm.plugin.report.service.f.Oj(20);
        if (au.a(au.this))
        {
          au.this.cWM.fFr();
          localObject1 = new com.tencent.mm.as.a(au.this.cWM.BYG.field_username, paramString);
          ba.aiU().a((com.tencent.mm.al.n)localObject1, 0);
          AppMethodBeat.o(35582);
          return;
        }
        if ((((com.tencent.mm.ui.chatting.d.b.k)au.this.cWM.bh(com.tencent.mm.ui.chatting.d.b.k.class)).getCount() == 0) && (com.tencent.mm.storage.am.aSP(au.this.cWM.getTalkerUserName()))) {
          bz.aCx().d(10076, new Object[] { Integer.valueOf(1) });
        }
        String str3 = au.this.cWM.getTalkerUserName();
        if (bt.isNullOrNil(str3))
        {
          ad.e("MicroMsg.ChattingUI.SendTextComponent", "toUser is null or nil!");
          AppMethodBeat.o(35582);
          return;
        }
        int i = w.Ar(str3);
        String str2 = paramString;
        Object localObject1 = null;
        s locals;
        int j;
        try
        {
          String str1 = ((aa)au.this.cWM.bh(aa.class)).aWg(str3);
          localObject1 = str1;
        }
        catch (NullPointerException localNullPointerException)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.ChattingUI.SendTextComponent", localNullPointerException, "", new Object[0]);
          }
          locals = (s)au.this.cWM.bh(s.class);
          j = str2.lastIndexOf(' ');
          if (j <= 0) {
            break label589;
          }
        }
        if (bt.isNullOrNil((String)localObject1))
        {
          ad.w("MicroMsg.ChattingUI.SendTextComponent", "tempUser is null");
          AppMethodBeat.o(35582);
          return;
        }
        Object localObject2;
        if (j == str2.length() - 1)
        {
          localObject2 = str2.substring(0, j);
          ad.w("MicroMsg.ChattingUI.SendTextComponent", "delete @ last char! index:".concat(String.valueOf(j)));
        }
        for (;;)
        {
          o.e locale = o.FX((String)localObject1);
          locale.type = i;
          locale.dDp = locals.fDC().gd(str3, paramInt);
          locale.content = ((String)localObject2);
          locale.toUser = ((String)localObject1);
          locale.igb = locals.fDC().ly(str3, str2);
          locale.igc = 5;
          localObject1 = locale.aJv();
          localObject2 = ((o.b)localObject1).ifV;
          if ((localObject2 instanceof i)) {
            ((aa)au.this.cWM.bh(aa.class)).g((i)localObject2);
          }
          ((o.b)localObject1).execute();
          if (w.Al(str3))
          {
            localObject1 = new com.tencent.mm.plugin.setting.model.k(com.tencent.mm.compatible.deviceinfo.q.aaD(), paramString + " key " + cc.fsJ() + " local key " + cc.fsI() + "NetType:" + ay.getNetTypeString(au.this.cWM.JOR.getContext().getApplicationContext()) + " hasNeon: " + com.tencent.mm.compatible.deviceinfo.n.aak() + " isArmv6: " + com.tencent.mm.compatible.deviceinfo.n.aam() + " isArmv7: " + com.tencent.mm.compatible.deviceinfo.n.aal());
            ba.aiU().a((com.tencent.mm.al.n)localObject1, 0);
          }
          AppMethodBeat.o(35582);
          return;
          label589:
          localObject2 = str2;
        }
      }
    });
    this.cWM.xR(true);
    AppMethodBeat.o(35586);
    return true;
  }
  
  public final void a(com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(35587);
    super.a(parama);
    this.JMZ = new x(this.cWM);
    AppMethodBeat.o(35587);
  }
  
  public final boolean aWi(String paramString)
  {
    AppMethodBeat.i(35584);
    boolean bool = gA(paramString, 0);
    AppMethodBeat.o(35584);
    return bool;
  }
  
  public final void amZ(String paramString)
  {
    AppMethodBeat.i(35585);
    if (this.JMZ != null) {
      this.JMZ.amZ(paramString);
    }
    AppMethodBeat.o(35585);
  }
  
  public final void fCC()
  {
    AppMethodBeat.i(35594);
    super.fCC();
    if (this.JMZ != null)
    {
      x localx = this.JMZ;
      if (localx.JDx != null) {
        localx.JDx.dfk();
      }
    }
    ba.aiU().b(522, this);
    fch();
    AppMethodBeat.o(35594);
  }
  
  public final void fwt()
  {
    AppMethodBeat.i(35589);
    d.a(this.JMZ);
    this.JGZ = true;
    AppMethodBeat.o(35589);
  }
  
  public final void fwu()
  {
    AppMethodBeat.i(35590);
    if (this.JMZ != null)
    {
      localObject = this.JMZ;
      if (((x)localObject).JDx != null)
      {
        localObject = ((x)localObject).JDx;
        g.aiU().a(2757, (com.tencent.mm.al.f)localObject);
      }
    }
    ba.aiU().a(522, this);
    Object localObject = ((ac)this.cWM.bh(ac.class)).fEx();
    if (localObject != null)
    {
      x localx = this.JMZ;
      if ((localx.JDx != null) && (localx.cWM != null))
      {
        z localz = localx.JDx;
        Activity localActivity = localx.cWM.JOR.getContext();
        localz.oxE = ((List)localObject);
        localz.JDA = localActivity;
        if (localz.mHandler != null) {
          localz.mHandler.sendEmptyMessageDelayed(0, 300L);
        }
        localx.JDx.M(localx.cWM.fFv(), localx.cWM.getTalkerUserName());
      }
    }
    AppMethodBeat.o(35590);
  }
  
  public final void fwv()
  {
    AppMethodBeat.i(35591);
    if (!this.JGZ) {
      d.a(this.JMZ);
    }
    this.JGZ = false;
    AppMethodBeat.o(35591);
  }
  
  public final void fww()
  {
    AppMethodBeat.i(35592);
    d.b(this.JMZ);
    AppMethodBeat.o(35592);
  }
  
  public final void fwx()
  {
    AppMethodBeat.i(35593);
    if (this.JMZ != null)
    {
      x localx = this.JMZ;
      if (localx.JDx != null) {
        localx.JDx.dfk();
      }
    }
    ba.aiU().b(522, this);
    fch();
    AppMethodBeat.o(35593);
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
      gA(paramIntent.getStringExtra("art_smiley_slelct_data"), 4);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(35595);
    if (this.cWM != null) {
      this.cWM.dismissDialog();
    }
    if (522 == paramn.getType())
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSendMsgEnable, this.JNa);
      this.JNa = 0;
    }
    AppMethodBeat.o(35595);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.au
 * JD-Core Version:    0.7.0.1
 */