package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.w;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.d.a;
import com.tencent.mm.plugin.sns.k.h;
import com.tencent.mm.plugin.sns.k.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.az;
import com.tencent.mm.plugin.sns.model.ba;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bmn;
import com.tencent.mm.protocal.protobuf.cwk;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.b.d.i;

public final class ag
  implements ab
{
  private String appName = "";
  private String dlB = "";
  private MMActivity imP;
  private int wLo = 1;
  private int xlZ;
  private d xmf = null;
  private String xmg = "";
  private boolean xnv = false;
  private boolean xnw = false;
  private WXMediaMessage xnx = null;
  private String xpt = "";
  private boolean xpu = false;
  
  public ag(MMActivity paramMMActivity, boolean paramBoolean)
  {
    this.imP = paramMMActivity;
    this.xpu = paramBoolean;
  }
  
  public final boolean a(int paramInt1, int paramInt2, i parami, String paramString1, List<String> paramList1, bmn parambmn, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(98012);
    if (this.imP.isFinishing())
    {
      AppMethodBeat.o(98012);
      return false;
    }
    paramLinkedList = new ba(2);
    paramPInt.value = paramLinkedList.aTB;
    if (paramInt3 > a.wzN) {
      paramLinkedList.Ms(2);
    }
    paramPInt = new LinkedList();
    if (paramList1 != null)
    {
      new LinkedList();
      paramString2 = w.arx();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        String str = (String)paramList1.next();
        if (!paramString2.contains(str))
        {
          cwk localcwk = new cwk();
          localcwk.mAQ = str;
          paramPInt.add(localcwk);
        }
      }
    }
    if (paramBoolean) {
      paramLinkedList.Mx(1);
    }
    for (;;)
    {
      if (parami != null) {
        paramLinkedList.iI(parami.token, parami.DNx);
      }
      paramLinkedList.Mw(this.xlZ);
      if (this.xnv) {
        paramLinkedList.Mw(5);
      }
      if ((this.xnw) && (this.xnx != null))
      {
        paramLinkedList.aoT(this.xnx.mediaTagName);
        paramLinkedList.au(this.dlB, this.xnx.messageExt, this.xnx.messageAction);
      }
      paramLinkedList.bR(this.wLo, this.xmg);
      paramLinkedList.g(null, null, null, paramInt4, paramInt5);
      paramLinkedList.aoS(paramString1).a(parambmn).aM(paramPInt).Mu(paramInt1).Mv(paramInt2).fq(paramList2);
      paramInt1 = paramLinkedList.commit();
      if (this.xmf != null)
      {
        this.xmf.oG(paramInt1);
        h.wRM.c(this.xmf);
      }
      this.imP.setResult(-1);
      af.dtq().drS();
      this.imP.finish();
      AppMethodBeat.o(98012);
      return true;
      paramLinkedList.Mx(0);
    }
  }
  
  public final void af(Bundle paramBundle)
  {
    AppMethodBeat.i(98011);
    this.xmf = d.w(this.imP.getIntent());
    this.xpt = this.imP.getIntent().getStringExtra("Kdescription");
    this.dlB = bt.by(this.imP.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = bt.by(this.imP.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.xnv = this.imP.getIntent().getBooleanExtra("KThrid_app", false);
    this.xnw = this.imP.getIntent().getBooleanExtra("KSnsAction", false);
    this.xlZ = this.imP.getIntent().getIntExtra("Ksnsupload_source", 0);
    paramBundle = this.imP.getIntent().getBundleExtra("Ksnsupload_timeline");
    if (paramBundle != null) {
      this.xnx = new SendMessageToWX.Req(paramBundle).message;
    }
    if (this.imP.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {}
    for (this.wLo = 1;; this.wLo = 0)
    {
      this.xmg = bt.by(this.imP.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
      AppMethodBeat.o(98011);
      return;
    }
  }
  
  public final void ag(Bundle paramBundle) {}
  
  public final boolean dyU()
  {
    return this.xpu;
  }
  
  public final View dyV()
  {
    return null;
  }
  
  public final boolean dyW()
  {
    return false;
  }
  
  public final boolean j(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ag
 * JD-Core Version:    0.7.0.1
 */