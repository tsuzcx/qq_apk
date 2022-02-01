package com.tencent.mm.ui.chatting.component;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.cw;
import com.tencent.mm.autogen.a.cw.b;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.ch;
import com.tencent.mm.modelmulti.t;
import com.tencent.mm.modelmulti.t.b;
import com.tencent.mm.modelmulti.t.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.setting.model.o;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.co;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.aa;
import com.tencent.mm.ui.chatting.component.api.af;
import com.tencent.mm.ui.chatting.component.api.ay;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.component.api.u;
import com.tencent.mm.ui.chatting.component.api.x;
import com.tencent.threadpool.i;
import java.util.HashMap;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=ay.class)
public class bi
  extends a
  implements com.tencent.mm.am.h, ay
{
  private boolean aepE = false;
  private aa aewV;
  private int aewW;
  
  private void iKP()
  {
    AppMethodBeat.i(35583);
    com.tencent.mm.plugin.notification.h.b(this.aewV);
    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSendMsgEnable, this.aewW);
    this.aewW = 0;
    AppMethodBeat.o(35583);
  }
  
  private boolean iS(final String paramString, final int paramInt)
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
    cw localcw = new cw();
    localcw.hCN.hCP = paramString;
    localcw.hCN.context = this.hlc.aezO.getContext();
    localcw.hCN.username = this.hlc.getTalkerUserName();
    localcw.publish();
    if (localcw.hCO.hCQ)
    {
      AppMethodBeat.o(35586);
      return true;
    }
    boolean bool = WXHardCoderJNI.hcSendMsgEnable;
    int j = WXHardCoderJNI.hcSendMsgDelay;
    int k = WXHardCoderJNI.hcSendMsgCPU;
    int m = WXHardCoderJNI.hcSendMsgIO;
    if (WXHardCoderJNI.hcSendMsgThr) {
      i = com.tencent.mm.kernel.h.baH().getProcessTid();
    }
    this.aewW = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcSendMsgTimeout, 202, WXHardCoderJNI.hcSendMsgAction, "MicroMsg.ChattingUI.SendTextComponent");
    if (Log.getLogLevel() <= 1) {
      Log.d("MicroMsg.ChattingUI.SendTextComponent", "doSendMessage");
    }
    com.tencent.threadpool.h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35582);
        long l = System.currentTimeMillis();
        if (bi.this.hlc == null)
        {
          Log.w("MicroMsg.ChattingUI.SendTextComponent", "NULL == mChattingContext");
          AppMethodBeat.o(35582);
          return;
        }
        g.ahw(20);
        if (bi.a(bi.this))
        {
          bi.this.hlc.getSelfUserName();
          localObject1 = new com.tencent.mm.ar.a(bi.this.hlc.Uxa.field_username, paramString);
          bh.aZW().a((p)localObject1, 0);
          AppMethodBeat.o(35582);
          return;
        }
        if ((((m)bi.this.hlc.cm(m.class)).getCount() == 0) && (au.bwN(bi.this.hlc.getTalkerUserName()))) {
          ch.bDg().f(10076, new Object[] { Integer.valueOf(1) });
        }
        String str2 = bi.this.hlc.getTalkerUserName();
        if (Util.isNullOrNil(str2))
        {
          Log.e("MicroMsg.ChattingUI.SendTextComponent", "toUser is null or nil!");
          AppMethodBeat.o(35582);
          return;
        }
        int i = ab.IX(str2);
        String str3 = paramString;
        Object localObject1 = null;
        Object localObject2;
        ChatFooter localChatFooter;
        try
        {
          String str1 = ((af)bi.this.hlc.cm(af.class)).bAQ(str2);
          localObject1 = str1;
        }
        catch (NullPointerException localNullPointerException)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.ChattingUI.SendTextComponent", localNullPointerException, "", new Object[0]);
          }
          localObject2 = (x)bi.this.hlc.cm(x.class);
          locale = t.OH((String)localObject1).wF(i);
          locale.eQp = ((x)localObject2).jsd().iB(str2, paramInt);
          locale.content = str3;
          locale.toUser = ((String)localObject1);
          localChatFooter = ((x)localObject2).jsd();
          localObject2 = ((x)localObject2).jsd().po(str2, str3);
          if (!Util.isNullOrNil(localChatFooter.YfJ)) {
            break label613;
          }
        }
        if (Util.isNullOrNil((String)localObject1))
        {
          Log.w("MicroMsg.ChattingUI.SendTextComponent", "tempUser is null");
          AppMethodBeat.o(35582);
          return;
        }
        t.e locale;
        localObject1 = localObject2;
        for (;;)
        {
          locale.oNi = localObject1;
          locale.oNj = 5;
          localObject1 = locale.bKW();
          localObject2 = ((t.b)localObject1).oNb;
          if ((localObject2 instanceof com.tencent.mm.modelmulti.n)) {
            ((af)bi.this.hlc.cm(af.class)).g((com.tencent.mm.modelmulti.n)localObject2);
          }
          ((t.b)localObject1).aXz();
          if (au.bwx(str2))
          {
            localObject1 = new o(q.aPl(), paramString + " key " + co.jcP() + " local key " + co.jcO() + "NetType:" + NetStatusUtil.getNetTypeString(bi.this.hlc.aezO.getContext().getApplicationContext()) + " hasNeon: " + com.tencent.mm.compatible.deviceinfo.n.aOQ() + " isArmv6: " + com.tencent.mm.compatible.deviceinfo.n.aOS() + " isArmv7: " + com.tencent.mm.compatible.deviceinfo.n.aOR());
            bh.aZW().a((p)localObject1, 0);
          }
          if (Log.getLogLevel() <= 1) {
            Log.d("MicroMsg.ChattingUI.SendTextComponent", "doSendMessage run 1111 cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          }
          AppMethodBeat.o(35582);
          return;
          label613:
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = new HashMap();
          }
          ((HashMap)localObject1).put("similar_paste_seq", localChatFooter.YfJ);
        }
      }
    }, "MicroMsg.ChattingUI.SendTextComponent");
    AppMethodBeat.o(35586);
    return true;
  }
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(35587);
    super.a(parama);
    this.aewV = new aa(this.hlc);
    AppMethodBeat.o(35587);
  }
  
  public final void aHY(String paramString)
  {
    AppMethodBeat.i(35585);
    ((u)this.hlc.cm(u.class)).bAN(paramString);
    AppMethodBeat.o(35585);
  }
  
  public final boolean bAS(String paramString)
  {
    AppMethodBeat.i(35584);
    boolean bool = iS(paramString, 0);
    AppMethodBeat.o(35584);
    return bool;
  }
  
  public final void jjg()
  {
    AppMethodBeat.i(35589);
    com.tencent.mm.plugin.notification.h.a(this.aewV);
    this.aepE = true;
    AppMethodBeat.o(35589);
  }
  
  public final void jjh()
  {
    AppMethodBeat.i(35590);
    bh.aZW().a(522, this);
    AppMethodBeat.o(35590);
  }
  
  public final void jji()
  {
    AppMethodBeat.i(35591);
    if (!this.aepE) {
      com.tencent.mm.plugin.notification.h.a(this.aewV);
    }
    this.aepE = false;
    AppMethodBeat.o(35591);
  }
  
  public final void jjj()
  {
    AppMethodBeat.i(35592);
    com.tencent.mm.plugin.notification.h.b(this.aewV);
    AppMethodBeat.o(35592);
  }
  
  public final void jjk()
  {
    AppMethodBeat.i(35593);
    bh.aZW().b(522, this);
    iKP();
    AppMethodBeat.o(35593);
  }
  
  public final void jqF()
  {
    AppMethodBeat.i(35594);
    super.jqF();
    bh.aZW().b(522, this);
    iKP();
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
      iS(paramIntent.getStringExtra("art_smiley_slelct_data"), 4);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(35595);
    if (this.hlc != null) {
      this.hlc.aDM();
    }
    if (522 == paramp.getType())
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSendMsgEnable, this.aewW);
      this.aewW = 0;
    }
    AppMethodBeat.o(35595);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.bi
 * JD-Core Version:    0.7.0.1
 */