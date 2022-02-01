package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.l;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.k.k;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.bd;
import com.tencent.mm.plugin.sns.model.be;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.protocal.protobuf.elm;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ao
  implements af
{
  private int KCP;
  private l KCV = null;
  private String KCW = "";
  private boolean KEH = false;
  private boolean KEI = false;
  private WXMediaMessage KEJ = null;
  private boolean KGU = false;
  private int Kcp = 1;
  private String appName = "";
  private String appid = "";
  private MMActivity iXq;
  private String wZt = "";
  
  public ao(MMActivity paramMMActivity, boolean paramBoolean)
  {
    this.iXq = paramMMActivity;
    this.KGU = paramBoolean;
  }
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, cst paramcst, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(98012);
    if (this.iXq.isFinishing())
    {
      AppMethodBeat.o(98012);
      return false;
    }
    paramLinkedList = new be(2, this.iXq);
    paramPInt.value = paramLinkedList.aOl;
    if (paramInt3 > com.tencent.mm.plugin.sns.c.a.JPj) {
      paramLinkedList.afW(2);
    }
    paramPInt = new LinkedList();
    if (paramList1 != null)
    {
      new LinkedList();
      paramString2 = com.tencent.mm.pluginsdk.j.a.hhW();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        String str = (String)paramList1.next();
        if (!paramString2.contains(str))
        {
          elm localelm = new elm();
          localelm.UserName = str;
          paramPInt.add(localelm);
        }
      }
    }
    if (paramBoolean) {
      paramLinkedList.agc(1);
    }
    for (;;)
    {
      if (parami != null) {
        paramLinkedList.kG(parami.token, parami.TEk);
      }
      paramLinkedList.agb(this.KCP);
      if (this.KEH) {
        paramLinkedList.agb(5);
      }
      if ((this.KEI) && (this.KEJ != null))
      {
        paramLinkedList.bat(this.KEJ.mediaTagName);
        paramLinkedList.aI(this.appid, this.KEJ.messageExt, this.KEJ.messageAction);
      }
      paramLinkedList.ct(this.Kcp, this.KCW);
      paramLinkedList.i(null, null, null, paramInt4, paramInt5);
      paramLinkedList.bas(paramString1).a(paramcst).bL(paramPInt).afZ(paramInt1).aga(paramInt2).hA(paramList2);
      paramInt1 = paramLinkedList.in();
      if (this.KCV != null)
      {
        this.KCV.wQ(paramInt1);
        com.tencent.mm.plugin.sns.k.i.Kjb.c(this.KCV);
      }
      this.iXq.setResult(-1);
      aj.fOE().fNd();
      this.iXq.finish();
      AppMethodBeat.o(98012);
      return true;
      paramLinkedList.agc(0);
    }
  }
  
  public final void ay(Bundle paramBundle)
  {
    AppMethodBeat.i(98011);
    this.KCV = l.x(this.iXq.getIntent());
    this.wZt = this.iXq.getIntent().getStringExtra("Kdescription");
    this.appid = Util.nullAs(this.iXq.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = Util.nullAs(this.iXq.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.KEH = this.iXq.getIntent().getBooleanExtra("KThrid_app", false);
    this.KEI = this.iXq.getIntent().getBooleanExtra("KSnsAction", false);
    this.KCP = this.iXq.getIntent().getIntExtra("Ksnsupload_source", 0);
    paramBundle = this.iXq.getIntent().getBundleExtra("Ksnsupload_timeline");
    if (paramBundle != null) {
      this.KEJ = new SendMessageToWX.Req(paramBundle).message;
    }
    if (this.iXq.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {}
    for (this.Kcp = 1;; this.Kcp = 0)
    {
      this.KCW = Util.nullAs(this.iXq.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
      AppMethodBeat.o(98011);
      return;
    }
  }
  
  public final void az(Bundle paramBundle) {}
  
  public final boolean fTA()
  {
    return false;
  }
  
  public final boolean fTw()
  {
    return this.KGU;
  }
  
  public final View fTx()
  {
    return null;
  }
  
  public final boolean fTy()
  {
    return true;
  }
  
  public final boolean fTz()
  {
    return true;
  }
  
  public final boolean k(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ao
 * JD-Core Version:    0.7.0.1
 */