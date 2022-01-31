package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.bz;
import com.tencent.mm.g.a.bz.b;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.notification.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingAnimFrame;
import com.tencent.mm.ui.chatting.c.b.ad;
import com.tencent.mm.ui.chatting.c.b.v;
import com.tencent.mm.ui.chatting.x;
import com.tencent.mm.ui.chatting.z;
import java.util.List;

@com.tencent.mm.ui.chatting.c.a.a(dJy=ad.class)
public class ai
  extends a
  implements f, ad
{
  private boolean zEB = false;
  private x zHU;
  private int zHV;
  
  private void dnu()
  {
    AppMethodBeat.i(31682);
    if (this.zHU != null)
    {
      Object localObject = this.zHU;
      if (((x)localObject).zBD != null)
      {
        localObject = ((x)localObject).zBD;
        ((z)localObject).mHandler.removeMessages(0);
        if (((z)localObject).zBE != null) {
          ((z)localObject).zBE.stop();
        }
        ab.d("MicroMsg.EggMgr", "egg has been stop");
      }
    }
    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSendMsgEnable, this.zHV);
    this.zHV = 0;
    AppMethodBeat.o(31682);
  }
  
  private boolean eQ(String paramString, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(31684);
    paramString = bo.aqk(paramString);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ab.e("MicroMsg.ChattingUI.SendTextComponent", "doSendMessage null");
      AppMethodBeat.o(31684);
      return false;
    }
    this.zHU.atM(paramString);
    bz localbz = new bz();
    localbz.cpw.cpy = paramString;
    localbz.cpw.context = this.caz.zJz.getContext();
    localbz.cpw.username = this.caz.getTalkerUserName();
    com.tencent.mm.sdk.b.a.ymk.l(localbz);
    if (localbz.cpx.cpz)
    {
      AppMethodBeat.o(31684);
      return true;
    }
    boolean bool = WXHardCoderJNI.hcSendMsgEnable;
    int j = WXHardCoderJNI.hcSendMsgDelay;
    int k = WXHardCoderJNI.hcSendMsgCPU;
    int m = WXHardCoderJNI.hcSendMsgIO;
    if (WXHardCoderJNI.hcSendMsgThr) {
      i = g.RO().dtc();
    }
    this.zHV = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcSendMsgTimeout, 202, WXHardCoderJNI.hcSendMsgAction, "MicroMsg.ChattingUI.SendTextComponent");
    com.tencent.mm.ui.chatting.d.a.dJI().post(new ai.1(this, paramString, paramInt));
    this.caz.qT(true);
    AppMethodBeat.o(31684);
    return true;
  }
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(31685);
    super.a(parama);
    this.zHU = new x(this.caz);
    AppMethodBeat.o(31685);
  }
  
  public final boolean atY(String paramString)
  {
    AppMethodBeat.i(31683);
    boolean bool = eQ(paramString, 0);
    AppMethodBeat.o(31683);
    return bool;
  }
  
  public final void dBZ()
  {
    AppMethodBeat.i(31687);
    d.a(this.zHU);
    this.zEB = true;
    AppMethodBeat.o(31687);
  }
  
  public final void dCa()
  {
    AppMethodBeat.i(31688);
    aw.Rc().a(522, this);
    List localList = ((v)this.caz.ay(v.class)).dIT();
    if (localList != null)
    {
      Object localObject = this.zHU;
      if ((((x)localObject).zBD != null) && (((x)localObject).caz != null))
      {
        z localz = ((x)localObject).zBD;
        localObject = ((x)localObject).caz.zJz.getContext();
        localz.kmd = localList;
        localz.zBF = ((Activity)localObject);
        if (localz.mHandler != null) {
          localz.mHandler.sendEmptyMessageDelayed(0, 300L);
        }
      }
    }
    AppMethodBeat.o(31688);
  }
  
  public final void dCb()
  {
    AppMethodBeat.i(31689);
    if (!this.zEB) {
      d.a(this.zHU);
    }
    this.zEB = false;
    AppMethodBeat.o(31689);
  }
  
  public final void dCc()
  {
    AppMethodBeat.i(31690);
    d.b(this.zHU);
    AppMethodBeat.o(31690);
  }
  
  public final void dCd()
  {
    AppMethodBeat.i(31691);
    aw.Rc().b(522, this);
    dnu();
    AppMethodBeat.o(31691);
  }
  
  public final void dHq()
  {
    AppMethodBeat.i(31692);
    super.dHq();
    aw.Rc().b(522, this);
    dnu();
    AppMethodBeat.o(31692);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(31686);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(31686);
      return;
      eQ(paramIntent.getStringExtra("art_smiley_slelct_data"), 4);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(31693);
    if (this.caz != null) {
      this.caz.dismissDialog();
    }
    if (522 == paramm.getType())
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSendMsgEnable, this.zHV);
      this.zHV = 0;
    }
    AppMethodBeat.o(31693);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ai
 * JD-Core Version:    0.7.0.1
 */