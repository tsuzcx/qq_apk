package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ce;
import com.tencent.mm.g.a.ce.b;
import com.tencent.mm.g.c.av;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.az;
import com.tencent.mm.model.by;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.notification.d;
import com.tencent.mm.plugin.setting.model.k;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingAnimFrame;
import com.tencent.mm.ui.chatting.c.b.aa;
import com.tencent.mm.ui.chatting.c.b.y;
import com.tencent.mm.ui.chatting.x;
import com.tencent.mm.ui.chatting.z;
import java.util.List;

@com.tencent.mm.ui.chatting.c.a.a(foJ=com.tencent.mm.ui.chatting.c.b.ai.class)
public class aq
  extends a
  implements com.tencent.mm.ak.g, com.tencent.mm.ui.chatting.c.b.ai
{
  private boolean HSN = false;
  private x HXT;
  private int HXU;
  
  private void eNi()
  {
    AppMethodBeat.i(35583);
    if (this.HXT != null)
    {
      Object localObject = this.HXT;
      if (((x)localObject).HPJ != null)
      {
        localObject = ((x)localObject).HPJ;
        ((z)localObject).mHandler.removeMessages(0);
        if (((z)localObject).HPK != null) {
          ((z)localObject).HPK.stop();
        }
        ac.d("MicroMsg.EggMgr", "egg has been stop");
      }
    }
    d.b(this.HXT);
    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSendMsgEnable, this.HXU);
    this.HXU = 0;
    AppMethodBeat.o(35583);
  }
  
  private boolean gd(final String paramString, final int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(35586);
    paramString = bs.aLN(paramString);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ac.e("MicroMsg.ChattingUI.SendTextComponent", "doSendMessage null");
      AppMethodBeat.o(35586);
      return false;
    }
    this.HXT.aim(paramString);
    ce localce = new ce();
    localce.dbP.dbR = paramString;
    localce.dbP.context = this.cLy.HZF.getContext();
    localce.dbP.username = this.cLy.getTalkerUserName();
    com.tencent.mm.sdk.b.a.GpY.l(localce);
    if (localce.dbQ.dbS)
    {
      AppMethodBeat.o(35586);
      return true;
    }
    boolean bool = WXHardCoderJNI.hcSendMsgEnable;
    int j = WXHardCoderJNI.hcSendMsgDelay;
    int k = WXHardCoderJNI.hcSendMsgCPU;
    int m = WXHardCoderJNI.hcSendMsgIO;
    if (WXHardCoderJNI.hcSendMsgThr) {
      i = com.tencent.mm.kernel.g.agU().eVl();
    }
    this.HXU = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcSendMsgTimeout, 202, WXHardCoderJNI.hcSendMsgAction, "MicroMsg.ChattingUI.SendTextComponent");
    com.tencent.mm.ui.chatting.d.a.foS().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35582);
        if (aq.this.cLy == null)
        {
          ac.w("MicroMsg.ChattingUI.SendTextComponent", "NULL == mChattingContext");
          AppMethodBeat.o(35582);
          return;
        }
        com.tencent.mm.plugin.report.service.g.MH(20);
        if (aq.a(aq.this))
        {
          aq.this.cLy.foM();
          localObject = new com.tencent.mm.ar.a(aq.this.cLy.AzG.field_username, paramString);
          az.agi().a((com.tencent.mm.ak.n)localObject, 0);
          AppMethodBeat.o(35582);
          return;
        }
        if ((((com.tencent.mm.ui.chatting.c.b.i)aq.this.cLy.bf(com.tencent.mm.ui.chatting.c.b.i.class)).getCount() == 0) && (com.tencent.mm.storage.ai.aNb(aq.this.cLy.getTalkerUserName()))) {
          by.azu().d(10076, new Object[] { Integer.valueOf(1) });
        }
        String str4 = aq.this.cLy.getTalkerUserName();
        if (bs.isNullOrNil(str4))
        {
          ac.e("MicroMsg.ChattingUI.SendTextComponent", "toUser is null or nil!");
          AppMethodBeat.o(35582);
          return;
        }
        int i = w.xt(str4);
        String str3 = paramString;
        Object localObject = null;
        com.tencent.mm.ui.chatting.c.b.q localq;
        int j;
        try
        {
          String str1 = ((y)aq.this.cLy.bf(y.class)).aQn(str4);
          localObject = str1;
        }
        catch (NullPointerException localNullPointerException)
        {
          for (;;)
          {
            ac.printErrStackTrace("MicroMsg.ChattingUI.SendTextComponent", localNullPointerException, "", new Object[0]);
          }
          localq = (com.tencent.mm.ui.chatting.c.b.q)aq.this.cLy.bf(com.tencent.mm.ui.chatting.c.b.q.class);
          j = str3.lastIndexOf(' ');
          if (j <= 0) {
            break label537;
          }
        }
        if (bs.isNullOrNil((String)localObject))
        {
          ac.w("MicroMsg.ChattingUI.SendTextComponent", "tempUser is null");
          AppMethodBeat.o(35582);
          return;
        }
        String str2;
        if (j == str3.length() - 1)
        {
          str2 = str3.substring(0, j);
          ac.w("MicroMsg.ChattingUI.SendTextComponent", "delete @ last char! index:".concat(String.valueOf(j)));
        }
        for (;;)
        {
          localObject = new com.tencent.mm.modelmulti.i((String)localObject, str2, i, localq.fne().fG(str4, paramInt), localq.fne().la(str4, str3));
          ((y)aq.this.cLy.bf(y.class)).g((com.tencent.mm.modelmulti.i)localObject);
          az.agi().a((com.tencent.mm.ak.n)localObject, 0);
          if (w.xo(str4))
          {
            localObject = new k(com.tencent.mm.compatible.deviceinfo.q.Yb(), paramString + " key " + bw.fcC() + " local key " + bw.fcB() + "NetType:" + ax.getNetTypeString(aq.this.cLy.HZF.getContext().getApplicationContext()) + " hasNeon: " + com.tencent.mm.compatible.deviceinfo.n.XJ() + " isArmv6: " + com.tencent.mm.compatible.deviceinfo.n.XL() + " isArmv7: " + com.tencent.mm.compatible.deviceinfo.n.XK());
            az.agi().a((com.tencent.mm.ak.n)localObject, 0);
          }
          AppMethodBeat.o(35582);
          return;
          label537:
          str2 = str3;
        }
      }
    });
    this.cLy.xg(true);
    AppMethodBeat.o(35586);
    return true;
  }
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(35587);
    super.a(parama);
    this.HXT = new x(this.cLy);
    AppMethodBeat.o(35587);
  }
  
  public final boolean aQp(String paramString)
  {
    AppMethodBeat.i(35584);
    boolean bool = gd(paramString, 0);
    AppMethodBeat.o(35584);
    return bool;
  }
  
  public final void aim(String paramString)
  {
    AppMethodBeat.i(35585);
    if (this.HXT != null) {
      this.HXT.aim(paramString);
    }
    AppMethodBeat.o(35585);
  }
  
  public final void fgh()
  {
    AppMethodBeat.i(35589);
    d.a(this.HXT);
    this.HSN = true;
    AppMethodBeat.o(35589);
  }
  
  public final void fgi()
  {
    AppMethodBeat.i(35590);
    if (this.HXT != null)
    {
      localObject = this.HXT;
      if (((x)localObject).HPJ != null)
      {
        localObject = ((x)localObject).HPJ;
        com.tencent.mm.kernel.g.agi().a(2757, (com.tencent.mm.ak.g)localObject);
      }
    }
    az.agi().a(522, this);
    Object localObject = ((aa)this.cLy.bf(aa.class)).foa();
    if (localObject != null)
    {
      x localx = this.HXT;
      if ((localx.HPJ != null) && (localx.cLy != null))
      {
        z localz = localx.HPJ;
        Activity localActivity = localx.cLy.HZF.getContext();
        localz.nUj = ((List)localObject);
        localz.HPL = localActivity;
        if (localz.mHandler != null) {
          localz.mHandler.sendEmptyMessageDelayed(0, 300L);
        }
        localx.HPJ.H(localx.cLy.foQ(), localx.cLy.getTalkerUserName());
      }
    }
    AppMethodBeat.o(35590);
  }
  
  public final void fgj()
  {
    AppMethodBeat.i(35591);
    if (!this.HSN) {
      d.a(this.HXT);
    }
    this.HSN = false;
    AppMethodBeat.o(35591);
  }
  
  public final void fgk()
  {
    AppMethodBeat.i(35592);
    d.b(this.HXT);
    AppMethodBeat.o(35592);
  }
  
  public final void fgl()
  {
    AppMethodBeat.i(35593);
    if (this.HXT != null)
    {
      x localx = this.HXT;
      if (localx.HPJ != null) {
        localx.HPJ.cVZ();
      }
    }
    az.agi().b(522, this);
    eNi();
    AppMethodBeat.o(35593);
  }
  
  public final void fmj()
  {
    AppMethodBeat.i(35594);
    super.fmj();
    if (this.HXT != null)
    {
      x localx = this.HXT;
      if (localx.HPJ != null) {
        localx.HPJ.cVZ();
      }
    }
    az.agi().b(522, this);
    eNi();
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
      gd(paramIntent.getStringExtra("art_smiley_slelct_data"), 4);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(35595);
    if (this.cLy != null) {
      this.cLy.dismissDialog();
    }
    if (522 == paramn.getType())
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSendMsgEnable, this.HXU);
      this.HXU = 0;
    }
    AppMethodBeat.o(35595);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.aq
 * JD-Core Version:    0.7.0.1
 */