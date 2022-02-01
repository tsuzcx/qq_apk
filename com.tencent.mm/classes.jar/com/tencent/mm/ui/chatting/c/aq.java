package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ce;
import com.tencent.mm.g.a.ce.b;
import com.tencent.mm.g.c.au;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.az;
import com.tencent.mm.model.by;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.notification.d;
import com.tencent.mm.plugin.setting.model.k;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.storage.af;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingAnimFrame;
import com.tencent.mm.ui.chatting.c.b.aa;
import com.tencent.mm.ui.chatting.c.b.ai;
import com.tencent.mm.ui.chatting.c.b.y;
import com.tencent.mm.ui.chatting.x;
import com.tencent.mm.ui.chatting.z;
import java.util.List;

@com.tencent.mm.ui.chatting.c.a.a(eYT=ai.class)
public class aq
  extends a
  implements com.tencent.mm.al.g, ai
{
  private boolean GsV = false;
  private x Gyc;
  private int Gyd;
  
  private void exO()
  {
    AppMethodBeat.i(35583);
    if (this.Gyc != null)
    {
      Object localObject = this.Gyc;
      if (((x)localObject).GpR != null)
      {
        localObject = ((x)localObject).GpR;
        ((z)localObject).mHandler.removeMessages(0);
        if (((z)localObject).GpS != null) {
          ((z)localObject).GpS.stop();
        }
        ad.d("MicroMsg.EggMgr", "egg has been stop");
      }
    }
    d.b(this.Gyc);
    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSendMsgEnable, this.Gyd);
    this.Gyd = 0;
    AppMethodBeat.o(35583);
  }
  
  private boolean fZ(final String paramString, final int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(35586);
    paramString = com.tencent.mm.sdk.platformtools.bt.aGw(paramString);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.e("MicroMsg.ChattingUI.SendTextComponent", "doSendMessage null");
      AppMethodBeat.o(35586);
      return false;
    }
    this.Gyc.adu(paramString);
    ce localce = new ce();
    localce.det.dev = paramString;
    localce.det.context = this.cOd.GzJ.getContext();
    localce.det.username = this.cOd.getTalkerUserName();
    com.tencent.mm.sdk.b.a.ESL.l(localce);
    if (localce.deu.dew)
    {
      AppMethodBeat.o(35586);
      return true;
    }
    boolean bool = WXHardCoderJNI.hcSendMsgEnable;
    int j = WXHardCoderJNI.hcSendMsgDelay;
    int k = WXHardCoderJNI.hcSendMsgCPU;
    int m = WXHardCoderJNI.hcSendMsgIO;
    if (WXHardCoderJNI.hcSendMsgThr) {
      i = com.tencent.mm.kernel.g.afE().eFQ();
    }
    this.Gyd = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcSendMsgTimeout, 202, WXHardCoderJNI.hcSendMsgAction, "MicroMsg.ChattingUI.SendTextComponent");
    com.tencent.mm.ui.chatting.d.a.eZd().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35582);
        if (aq.this.cOd == null)
        {
          ad.w("MicroMsg.ChattingUI.SendTextComponent", "NULL == mChattingContext");
          AppMethodBeat.o(35582);
          return;
        }
        com.tencent.mm.plugin.report.service.g.KI(20);
        if (aq.a(aq.this))
        {
          aq.this.cOd.eYX();
          localObject = new com.tencent.mm.as.a(aq.this.cOd.zgX.field_username, paramString);
          az.aeS().a((com.tencent.mm.al.n)localObject, 0);
          AppMethodBeat.o(35582);
          return;
        }
        if ((((com.tencent.mm.ui.chatting.c.b.i)aq.this.cOd.be(com.tencent.mm.ui.chatting.c.b.i.class)).getCount() == 0) && (af.aHG(aq.this.cOd.getTalkerUserName()))) {
          by.asD().d(10076, new Object[] { Integer.valueOf(1) });
        }
        String str4 = aq.this.cOd.getTalkerUserName();
        if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(str4))
        {
          ad.e("MicroMsg.ChattingUI.SendTextComponent", "toUser is null or nil!");
          AppMethodBeat.o(35582);
          return;
        }
        int i = w.tq(str4);
        String str3 = paramString;
        Object localObject = null;
        com.tencent.mm.ui.chatting.c.b.q localq;
        int j;
        try
        {
          String str1 = ((y)aq.this.cOd.be(y.class)).aKK(str4);
          localObject = str1;
        }
        catch (NullPointerException localNullPointerException)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.ChattingUI.SendTextComponent", localNullPointerException, "", new Object[0]);
          }
          localq = (com.tencent.mm.ui.chatting.c.b.q)aq.this.cOd.be(com.tencent.mm.ui.chatting.c.b.q.class);
          j = str3.lastIndexOf(' ');
          if (j <= 0) {
            break label537;
          }
        }
        if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil((String)localObject))
        {
          ad.w("MicroMsg.ChattingUI.SendTextComponent", "tempUser is null");
          AppMethodBeat.o(35582);
          return;
        }
        String str2;
        if (j == str3.length() - 1)
        {
          str2 = str3.substring(0, j);
          ad.w("MicroMsg.ChattingUI.SendTextComponent", "delete @ last char! index:".concat(String.valueOf(j)));
        }
        for (;;)
        {
          localObject = new com.tencent.mm.modelmulti.i((String)localObject, str2, i, localq.eXs().fB(str4, paramInt), localq.eXs().kD(str4, str3));
          ((y)aq.this.cOd.be(y.class)).g((com.tencent.mm.modelmulti.i)localObject);
          az.aeS().a((com.tencent.mm.al.n)localObject, 0);
          if (w.tl(str4))
          {
            localObject = new k(com.tencent.mm.compatible.deviceinfo.q.Xe(), paramString + " key " + com.tencent.mm.storage.bt.eMY() + " local key " + com.tencent.mm.storage.bt.eMX() + "NetType:" + ay.getNetTypeString(aq.this.cOd.GzJ.getContext().getApplicationContext()) + " hasNeon: " + com.tencent.mm.compatible.deviceinfo.n.WL() + " isArmv6: " + com.tencent.mm.compatible.deviceinfo.n.WN() + " isArmv7: " + com.tencent.mm.compatible.deviceinfo.n.WM());
            az.aeS().a((com.tencent.mm.al.n)localObject, 0);
          }
          AppMethodBeat.o(35582);
          return;
          label537:
          str2 = str3;
        }
      }
    });
    this.cOd.wc(true);
    AppMethodBeat.o(35586);
    return true;
  }
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(35587);
    super.a(parama);
    this.Gyc = new x(this.cOd);
    AppMethodBeat.o(35587);
  }
  
  public final boolean aKM(String paramString)
  {
    AppMethodBeat.i(35584);
    boolean bool = fZ(paramString, 0);
    AppMethodBeat.o(35584);
    return bool;
  }
  
  public final void adu(String paramString)
  {
    AppMethodBeat.i(35585);
    if (this.Gyc != null) {
      this.Gyc.adu(paramString);
    }
    AppMethodBeat.o(35585);
  }
  
  public final void eQB()
  {
    AppMethodBeat.i(35589);
    d.a(this.Gyc);
    this.GsV = true;
    AppMethodBeat.o(35589);
  }
  
  public final void eQC()
  {
    AppMethodBeat.i(35590);
    if (this.Gyc != null)
    {
      localObject = this.Gyc;
      if (((x)localObject).GpR != null)
      {
        localObject = ((x)localObject).GpR;
        com.tencent.mm.kernel.g.aeS().a(2757, (com.tencent.mm.al.g)localObject);
      }
    }
    az.aeS().a(522, this);
    Object localObject = ((aa)this.cOd.be(aa.class)).eYo();
    if (localObject != null)
    {
      x localx = this.Gyc;
      if ((localx.GpR != null) && (localx.cOd != null))
      {
        z localz = localx.GpR;
        Activity localActivity = localx.cOd.GzJ.getContext();
        localz.nrj = ((List)localObject);
        localz.GpT = localActivity;
        if (localz.mHandler != null) {
          localz.mHandler.sendEmptyMessageDelayed(0, 300L);
        }
        localx.GpR.G(localx.cOd.eZb(), localx.cOd.getTalkerUserName());
      }
    }
    AppMethodBeat.o(35590);
  }
  
  public final void eQD()
  {
    AppMethodBeat.i(35591);
    if (!this.GsV) {
      d.a(this.Gyc);
    }
    this.GsV = false;
    AppMethodBeat.o(35591);
  }
  
  public final void eQE()
  {
    AppMethodBeat.i(35592);
    d.b(this.Gyc);
    AppMethodBeat.o(35592);
  }
  
  public final void eQF()
  {
    AppMethodBeat.i(35593);
    if (this.Gyc != null)
    {
      x localx = this.Gyc;
      if (localx.GpR != null) {
        localx.GpR.cIO();
      }
    }
    az.aeS().b(522, this);
    exO();
    AppMethodBeat.o(35593);
  }
  
  public final void eWx()
  {
    AppMethodBeat.i(35594);
    super.eWx();
    if (this.Gyc != null)
    {
      x localx = this.Gyc;
      if (localx.GpR != null) {
        localx.GpR.cIO();
      }
    }
    az.aeS().b(522, this);
    exO();
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
      fZ(paramIntent.getStringExtra("art_smiley_slelct_data"), 4);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(35595);
    if (this.cOd != null) {
      this.cOd.dismissDialog();
    }
    if (522 == paramn.getType())
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSendMsgEnable, this.Gyd);
      this.Gyd = 0;
    }
    AppMethodBeat.o(35595);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.aq
 * JD-Core Version:    0.7.0.1
 */