package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.g.a.ch.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.cb;
import com.tencent.mm.model.x;
import com.tencent.mm.modelmulti.i;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.plugin.notification.e;
import com.tencent.mm.plugin.setting.model.l;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.cd;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingAnimFrame;
import com.tencent.mm.ui.chatting.d.b.ac;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.s;
import com.tencent.mm.ui.chatting.y;
import java.util.List;

@com.tencent.mm.ui.chatting.d.a.a(fJv=com.tencent.mm.ui.chatting.d.b.an.class)
public class av
  extends a
  implements com.tencent.mm.ak.f, com.tencent.mm.ui.chatting.d.b.an
{
  private boolean KbQ = false;
  private y KhW;
  private int KhX;
  
  private void ffV()
  {
    AppMethodBeat.i(35583);
    if (this.KhW != null)
    {
      Object localObject = this.KhW;
      if (((y)localObject).JYo != null)
      {
        localObject = ((y)localObject).JYo;
        ((com.tencent.mm.ui.chatting.aa)localObject).mHandler.removeMessages(0);
        if (((com.tencent.mm.ui.chatting.aa)localObject).JYq != null) {
          ((com.tencent.mm.ui.chatting.aa)localObject).JYq.stop();
        }
        ae.i("MicroMsg.EggMgr", "egg has been stop, %s", new Object[] { ((com.tencent.mm.ui.chatting.aa)localObject).JYq });
      }
    }
    e.b(this.KhW);
    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSendMsgEnable, this.KhX);
    this.KhX = 0;
    AppMethodBeat.o(35583);
  }
  
  private boolean gJ(final String paramString, final int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(35586);
    paramString = bu.aSR(paramString);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ae.e("MicroMsg.ChattingUI.SendTextComponent", "doSendMessage null");
      AppMethodBeat.o(35586);
      return false;
    }
    this.KhW.aoa(paramString);
    ch localch = new ch();
    localch.don.dop = paramString;
    localch.don.context = this.cXJ.Kkd.getContext();
    localch.don.username = this.cXJ.getTalkerUserName();
    com.tencent.mm.sdk.b.a.IvT.l(localch);
    if (localch.doo.doq)
    {
      AppMethodBeat.o(35586);
      return true;
    }
    boolean bool = WXHardCoderJNI.hcSendMsgEnable;
    int j = WXHardCoderJNI.hcSendMsgDelay;
    int k = WXHardCoderJNI.hcSendMsgCPU;
    int m = WXHardCoderJNI.hcSendMsgIO;
    if (WXHardCoderJNI.hcSendMsgThr) {
      i = g.ajU().foN();
    }
    this.KhX = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcSendMsgTimeout, 202, WXHardCoderJNI.hcSendMsgAction, "MicroMsg.ChattingUI.SendTextComponent");
    com.tencent.mm.ui.chatting.e.a.fJE().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35582);
        if (av.this.cXJ == null)
        {
          ae.w("MicroMsg.ChattingUI.SendTextComponent", "NULL == mChattingContext");
          AppMethodBeat.o(35582);
          return;
        }
        com.tencent.mm.plugin.report.service.f.OP(20);
        if (av.a(av.this))
        {
          av.this.cXJ.fJy();
          localObject1 = new com.tencent.mm.ar.a(av.this.cXJ.Cqh.field_username, paramString);
          bc.ajj().a((com.tencent.mm.ak.n)localObject1, 0);
          AppMethodBeat.o(35582);
          return;
        }
        if ((((k)av.this.cXJ.bh(k.class)).getCount() == 0) && (com.tencent.mm.storage.an.aUp(av.this.cXJ.getTalkerUserName()))) {
          cb.aCN().d(10076, new Object[] { Integer.valueOf(1) });
        }
        String str3 = av.this.cXJ.getTalkerUserName();
        if (bu.isNullOrNil(str3))
        {
          ae.e("MicroMsg.ChattingUI.SendTextComponent", "toUser is null or nil!");
          AppMethodBeat.o(35582);
          return;
        }
        int i = x.Bb(str3);
        String str2 = paramString;
        Object localObject1 = null;
        s locals;
        int j;
        try
        {
          String str1 = ((com.tencent.mm.ui.chatting.d.b.aa)av.this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.aa.class)).aXH(str3);
          localObject1 = str1;
        }
        catch (NullPointerException localNullPointerException)
        {
          for (;;)
          {
            ae.printErrStackTrace("MicroMsg.ChattingUI.SendTextComponent", localNullPointerException, "", new Object[0]);
          }
          locals = (s)av.this.cXJ.bh(s.class);
          j = str2.lastIndexOf(' ');
          if (j <= 0) {
            break label589;
          }
        }
        if (bu.isNullOrNil((String)localObject1))
        {
          ae.w("MicroMsg.ChattingUI.SendTextComponent", "tempUser is null");
          AppMethodBeat.o(35582);
          return;
        }
        Object localObject2;
        if (j == str2.length() - 1)
        {
          localObject2 = str2.substring(0, j);
          ae.w("MicroMsg.ChattingUI.SendTextComponent", "delete @ last char! index:".concat(String.valueOf(j)));
        }
        for (;;)
        {
          o.e locale = o.Gz((String)localObject1);
          locale.type = i;
          locale.dEu = locals.fHF().gm(str3, paramInt);
          locale.content = ((String)localObject2);
          locale.toUser = ((String)localObject1);
          locale.iiU = locals.fHF().lF(str3, str2);
          locale.iiV = 5;
          localObject1 = locale.aJO();
          localObject2 = ((o.b)localObject1).iiO;
          if ((localObject2 instanceof i)) {
            ((com.tencent.mm.ui.chatting.d.b.aa)av.this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.aa.class)).g((i)localObject2);
          }
          ((o.b)localObject1).execute();
          if (x.AV(str3))
          {
            localObject1 = new l(com.tencent.mm.compatible.deviceinfo.q.aaM(), paramString + " key " + cd.fwK() + " local key " + cd.fwJ() + "NetType:" + az.getNetTypeString(av.this.cXJ.Kkd.getContext().getApplicationContext()) + " hasNeon: " + com.tencent.mm.compatible.deviceinfo.n.aat() + " isArmv6: " + com.tencent.mm.compatible.deviceinfo.n.aav() + " isArmv7: " + com.tencent.mm.compatible.deviceinfo.n.aau());
            bc.ajj().a((com.tencent.mm.ak.n)localObject1, 0);
          }
          AppMethodBeat.o(35582);
          return;
          label589:
          localObject2 = str2;
        }
      }
    });
    this.cXJ.xY(true);
    AppMethodBeat.o(35586);
    return true;
  }
  
  public final void a(com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(35587);
    super.a(parama);
    this.KhW = new y(this.cXJ);
    AppMethodBeat.o(35587);
  }
  
  public final boolean aXJ(String paramString)
  {
    AppMethodBeat.i(35584);
    boolean bool = gJ(paramString, 0);
    AppMethodBeat.o(35584);
    return bool;
  }
  
  public final void aoa(String paramString)
  {
    AppMethodBeat.i(35585);
    if (this.KhW != null) {
      this.KhW.aoa(paramString);
    }
    AppMethodBeat.o(35585);
  }
  
  public final void fAt()
  {
    AppMethodBeat.i(35589);
    e.a(this.KhW);
    this.KbQ = true;
    AppMethodBeat.o(35589);
  }
  
  public final void fAu()
  {
    AppMethodBeat.i(35590);
    if (this.KhW != null)
    {
      localObject = this.KhW;
      if (((y)localObject).JYo != null)
      {
        localObject = ((y)localObject).JYo;
        g.ajj().a(2757, (com.tencent.mm.ak.f)localObject);
      }
    }
    bc.ajj().a(522, this);
    Object localObject = ((ac)this.cXJ.bh(ac.class)).fIB();
    if (localObject != null)
    {
      y localy = this.KhW;
      if ((localy.JYo != null) && (localy.cXJ != null))
      {
        com.tencent.mm.ui.chatting.aa localaa = localy.JYo;
        Activity localActivity = localy.cXJ.Kkd.getContext();
        localaa.oEg = ((List)localObject);
        localaa.JYr = localActivity;
        if (localaa.mHandler != null) {
          localaa.mHandler.sendEmptyMessageDelayed(0, 300L);
        }
        localy.JYo.O(localy.cXJ.fJC(), localy.cXJ.getTalkerUserName());
      }
    }
    AppMethodBeat.o(35590);
  }
  
  public final void fAv()
  {
    AppMethodBeat.i(35591);
    if (!this.KbQ) {
      e.a(this.KhW);
    }
    this.KbQ = false;
    AppMethodBeat.o(35591);
  }
  
  public final void fAw()
  {
    AppMethodBeat.i(35592);
    e.b(this.KhW);
    AppMethodBeat.o(35592);
  }
  
  public final void fAx()
  {
    AppMethodBeat.i(35593);
    if (this.KhW != null)
    {
      y localy = this.KhW;
      if (localy.JYo != null) {
        localy.JYo.dic();
      }
    }
    bc.ajj().b(522, this);
    ffV();
    AppMethodBeat.o(35593);
  }
  
  public final void fGE()
  {
    AppMethodBeat.i(35594);
    super.fGE();
    if (this.KhW != null)
    {
      y localy = this.KhW;
      if (localy.JYo != null) {
        localy.JYo.dic();
      }
    }
    bc.ajj().b(522, this);
    ffV();
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
      gJ(paramIntent.getStringExtra("art_smiley_slelct_data"), 4);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(35595);
    if (this.cXJ != null) {
      this.cXJ.dismissDialog();
    }
    if (522 == paramn.getType())
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSendMsgEnable, this.KhX);
      this.KhX = 0;
    }
    AppMethodBeat.o(35595);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.av
 * JD-Core Version:    0.7.0.1
 */