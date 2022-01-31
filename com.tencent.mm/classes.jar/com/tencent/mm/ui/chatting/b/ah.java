package com.tencent.mm.ui.chatting.b;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.bw;
import com.tencent.mm.h.a.bw.b;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.ChattingAnimFrame;
import com.tencent.mm.ui.chatting.b.b.u;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.chatting.z;
import java.util.List;

@com.tencent.mm.ui.chatting.b.a.a(cFA=com.tencent.mm.ui.chatting.b.b.ac.class)
public class ah
  extends a
  implements f, com.tencent.mm.ui.chatting.b.b.ac
{
  private boolean voZ = false;
  private z vsn;
  private int vso;
  
  private boolean dG(String paramString, int paramInt)
  {
    int i = 0;
    paramString = bk.aag(paramString);
    if ((paramString == null) || (paramString.length() == 0))
    {
      y.e("MicroMsg.ChattingUI.SendTextComponent", "doSendMessage null");
      return false;
    }
    Object localObject = this.vsn;
    if (!com.tencent.mm.platformtools.ah.bl(paramString))
    {
      bi localbi = new bi();
      localbi.setContent(paramString);
      localbi.fA(1);
      ((z)localObject).aE(localbi);
    }
    localObject = new bw();
    ((bw)localObject).bIb.bId = paramString;
    ((bw)localObject).bIb.context = this.byx.vtz.getContext();
    com.tencent.mm.sdk.b.a.udP.m((b)localObject);
    if (((bw)localObject).bIc.bIe) {
      return true;
    }
    boolean bool = WXHardCoderJNI.hcSendMsgEnable;
    int j = WXHardCoderJNI.hcSendMsgDelay;
    int k = WXHardCoderJNI.hcSendMsgCPU;
    int m = WXHardCoderJNI.hcSendMsgIO;
    if (WXHardCoderJNI.hcSendMsgThr) {
      i = com.tencent.mm.kernel.g.DS().crd();
    }
    this.vso = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcSendMsgTimeout, 202, WXHardCoderJNI.hcSendMsgAction, "MicroMsg.ChattingUI.SendTextComponent");
    com.tencent.mm.ui.chatting.c.a.cFG().post(new ah.1(this, paramString, paramInt));
    this.byx.cCW();
    return true;
  }
  
  public final void a(com.tencent.mm.ui.chatting.c.a parama)
  {
    super.a(parama);
    this.vsn = new z(this.byx);
  }
  
  public final boolean adw(String paramString)
  {
    return dG(paramString, 0);
  }
  
  public final void cyN()
  {
    com.tencent.mm.plugin.messenger.foundation.g.a(this.vsn);
    this.voZ = true;
  }
  
  public final void cyO()
  {
    au.Dk().a(522, this);
    List localList = ((u)this.byx.ac(u.class)).cFb();
    if (localList != null)
    {
      Object localObject = this.vsn;
      if ((((z)localObject).vmf != null) && (((z)localObject).byx != null))
      {
        com.tencent.mm.ui.chatting.ac localac = ((z)localObject).vmf;
        localObject = ((z)localObject).byx.vtz.getContext();
        localac.ilf = localList;
        localac.vmh = ((Activity)localObject);
        if (localac.mHandler != null) {
          localac.mHandler.sendEmptyMessageDelayed(0, 300L);
        }
      }
    }
  }
  
  public final void cyP()
  {
    if (!this.voZ) {
      com.tencent.mm.plugin.messenger.foundation.g.a(this.vsn);
    }
    this.voZ = false;
  }
  
  public final void cyQ()
  {
    com.tencent.mm.plugin.messenger.foundation.g.b(this.vsn);
  }
  
  public final void cyR()
  {
    au.Dk().b(522, this);
    if (this.vsn != null)
    {
      Object localObject = this.vsn;
      if (((z)localObject).vmf != null)
      {
        localObject = ((z)localObject).vmf;
        ((com.tencent.mm.ui.chatting.ac)localObject).mHandler.removeMessages(0);
        if (((com.tencent.mm.ui.chatting.ac)localObject).vmg != null) {
          ((com.tencent.mm.ui.chatting.ac)localObject).vmg.stop();
        }
        y.d("MicroMsg.EggMgr", "egg has been stop");
      }
    }
    WXHardCoderJNI.stopPerformace(WXHardCoderJNI.hcSendMsgEnable, this.vso);
    this.vso = 0;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    default: 
      return;
    }
    dG(paramIntent.getStringExtra("art_smiley_slelct_data"), 4);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (this.byx != null) {
      this.byx.dismissDialog();
    }
    if (522 == paramm.getType())
    {
      WXHardCoderJNI.stopPerformace(WXHardCoderJNI.hcSendMsgEnable, this.vso);
      this.vso = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.ah
 * JD-Core Version:    0.7.0.1
 */