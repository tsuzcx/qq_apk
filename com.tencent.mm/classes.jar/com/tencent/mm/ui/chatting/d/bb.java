package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.compatible.deviceinfo.n;
import com.tencent.mm.f.a.cn;
import com.tencent.mm.f.a.cn.b;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.cg;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.plugin.notification.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.setting.model.m;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.cl;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.ac;
import com.tencent.mm.ui.chatting.d.b.ar;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.r;
import com.tencent.mm.ui.chatting.d.b.u;
import com.tencent.mm.ui.chatting.y;

@com.tencent.mm.ui.chatting.d.a.a(hRc=ar.class)
public class bb
  extends a
  implements com.tencent.mm.an.i, ar
{
  private boolean WHy = false;
  private y WOu;
  private int WOv;
  
  private boolean hL(final String paramString, final int paramInt)
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
    cn localcn = new cn();
    localcn.fyi.fyk = paramString;
    localcn.fyi.context = this.fgR.WQv.getContext();
    localcn.fyi.username = this.fgR.getTalkerUserName();
    EventCenter.instance.publish(localcn);
    if (localcn.fyj.fyl)
    {
      AppMethodBeat.o(35586);
      return true;
    }
    boolean bool = WXHardCoderJNI.hcSendMsgEnable;
    int j = WXHardCoderJNI.hcSendMsgDelay;
    int k = WXHardCoderJNI.hcSendMsgCPU;
    int m = WXHardCoderJNI.hcSendMsgIO;
    if (WXHardCoderJNI.hcSendMsgThr) {
      i = h.aHJ().getProcessTid();
    }
    this.WOv = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcSendMsgTimeout, 202, WXHardCoderJNI.hcSendMsgAction, "MicroMsg.ChattingUI.SendTextComponent");
    com.tencent.mm.ui.chatting.e.a.hRl().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35582);
        if (bb.this.fgR == null)
        {
          Log.w("MicroMsg.ChattingUI.SendTextComponent", "NULL == mChattingContext");
          AppMethodBeat.o(35582);
          return;
        }
        g.ada(20);
        if (bb.a(bb.this))
        {
          bb.this.fgR.getSelfUserName();
          localObject1 = new com.tencent.mm.au.a(bb.this.fgR.NKq.field_username, paramString);
          bh.aGY().a((com.tencent.mm.an.q)localObject1, 0);
          AppMethodBeat.o(35582);
          return;
        }
        if ((((k)bb.this.fgR.bC(k.class)).getCount() == 0) && (as.bvJ(bb.this.fgR.getTalkerUserName()))) {
          cg.bfp().e(10076, new Object[] { Integer.valueOf(1) });
        }
        String str2 = bb.this.fgR.getTalkerUserName();
        if (Util.isNullOrNil(str2))
        {
          Log.e("MicroMsg.ChattingUI.SendTextComponent", "toUser is null or nil!");
          AppMethodBeat.o(35582);
          return;
        }
        int i = ab.QZ(str2);
        String str3 = paramString;
        Object localObject1 = null;
        try
        {
          String str1 = ((ac)bb.this.fgR.bC(ac.class)).bzn(str2);
          localObject1 = str1;
        }
        catch (NullPointerException localNullPointerException)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.ChattingUI.SendTextComponent", localNullPointerException, "", new Object[0]);
          }
          Object localObject2 = (u)bb.this.fgR.bC(u.class);
          o.e locale = o.WI((String)localObject1).wD(i);
          locale.cUP = ((u)localObject2).hPj().ht(str2, paramInt);
          locale.content = str3;
          locale.toUser = ((String)localObject1);
          locale.lUp = ((u)localObject2).hPj().nt(str2, str3);
          locale.lUq = 5;
          localObject1 = locale.bnl();
          localObject2 = ((o.b)localObject1).lUi;
          if (!(localObject2 instanceof com.tencent.mm.modelmulti.i)) {
            break label386;
          }
          ((ac)bb.this.fgR.bC(ac.class)).g((com.tencent.mm.modelmulti.i)localObject2);
          ((o.b)localObject1).aEv();
          if (!ab.QT(str2)) {
            break label521;
          }
          localObject1 = new m(com.tencent.mm.compatible.deviceinfo.q.auR(), paramString + " key " + cl.hAM() + " local key " + cl.hAL() + "NetType:" + NetStatusUtil.getNetTypeString(bb.this.fgR.WQv.getContext().getApplicationContext()) + " hasNeon: " + n.aux() + " isArmv6: " + n.auz() + " isArmv7: " + n.auy());
          bh.aGY().a((com.tencent.mm.an.q)localObject1, 0);
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
    this.fgR.Gi(true);
    AppMethodBeat.o(35586);
    return true;
  }
  
  private void hjX()
  {
    AppMethodBeat.i(35583);
    f.b(this.WOu);
    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSendMsgEnable, this.WOv);
    this.WOv = 0;
    AppMethodBeat.o(35583);
  }
  
  public final void a(com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(35587);
    super.a(parama);
    this.WOu = new y(this.fgR);
    AppMethodBeat.o(35587);
  }
  
  public final void aLh(String paramString)
  {
    AppMethodBeat.i(35585);
    ((r)this.fgR.bC(r.class)).bzj(paramString);
    AppMethodBeat.o(35585);
  }
  
  public final boolean bzp(String paramString)
  {
    AppMethodBeat.i(35584);
    boolean bool = hL(paramString, 0);
    AppMethodBeat.o(35584);
    return bool;
  }
  
  public final void hGV()
  {
    AppMethodBeat.i(35589);
    f.a(this.WOu);
    this.WHy = true;
    AppMethodBeat.o(35589);
  }
  
  public final void hGW()
  {
    AppMethodBeat.i(35590);
    bh.aGY().a(522, this);
    AppMethodBeat.o(35590);
  }
  
  public final void hGX()
  {
    AppMethodBeat.i(35591);
    if (!this.WHy) {
      f.a(this.WOu);
    }
    this.WHy = false;
    AppMethodBeat.o(35591);
  }
  
  public final void hGY()
  {
    AppMethodBeat.i(35592);
    f.b(this.WOu);
    AppMethodBeat.o(35592);
  }
  
  public final void hGZ()
  {
    AppMethodBeat.i(35593);
    bh.aGY().b(522, this);
    hjX();
    AppMethodBeat.o(35593);
  }
  
  public final void hNZ()
  {
    AppMethodBeat.i(35594);
    super.hNZ();
    bh.aGY().b(522, this);
    hjX();
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
      hL(paramIntent.getStringExtra("art_smiley_slelct_data"), 4);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(35595);
    if (this.fgR != null) {
      this.fgR.dismissDialog();
    }
    if (522 == paramq.getType())
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSendMsgEnable, this.WOv);
      this.WOv = 0;
    }
    AppMethodBeat.o(35595);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.bb
 * JD-Core Version:    0.7.0.1
 */