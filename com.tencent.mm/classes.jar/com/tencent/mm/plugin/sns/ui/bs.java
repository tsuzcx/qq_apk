package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.l;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.plugin.sns.k.k;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.bd;
import com.tencent.mm.plugin.sns.model.be;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.protocal.protobuf.elm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class bs
  implements af
{
  private int KCP;
  private l KCV = null;
  private String KCW = "";
  private boolean KEH = false;
  private boolean KEI = false;
  private WXMediaMessage KEJ = null;
  private int Kcp = 1;
  private String appName = "";
  private String appid = "";
  private MMActivity iXq;
  private String wZt = "";
  
  public bs(MMActivity paramMMActivity)
  {
    this.iXq = paramMMActivity;
  }
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, cst paramcst, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(99716);
    if (this.KEJ != null)
    {
      this.KEJ.description = paramString1;
      if ((this.KEJ.mediaObject != null) && ((this.KEJ.mediaObject instanceof WXTextObject))) {
        ((WXTextObject)this.KEJ.mediaObject).text = paramString1;
      }
    }
    aj.fOE();
    paramString1 = bd.c(this.KEJ, paramString1, this.appid, this.appName);
    if (paramString1 == null)
    {
      Log.e("MicroMsg.TextWidget", "packHelper == null, %s, %s", new Object[] { this.appid, this.appName });
      AppMethodBeat.o(99716);
      return false;
    }
    paramPInt.value = paramString1.aOl;
    if (paramInt3 > com.tencent.mm.plugin.sns.c.a.JPj) {
      paramString1.afW(4);
    }
    paramString1.agb(this.KCP);
    if (this.KEH) {
      paramString1.agb(5);
    }
    paramLinkedList = new LinkedList();
    if (paramList1 != null)
    {
      new LinkedList();
      paramPInt = com.tencent.mm.pluginsdk.j.a.hhW();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramString2 = (String)paramList1.next();
        if (!paramPInt.contains(paramString2))
        {
          elm localelm = new elm();
          localelm.UserName = paramString2;
          paramLinkedList.add(localelm);
        }
      }
    }
    paramString1.bL(paramLinkedList);
    if (parami != null) {
      paramString1.kG(parami.token, parami.TEk);
    }
    paramString1.a(paramcst);
    if (paramBoolean) {
      paramString1.agc(1);
    }
    for (;;)
    {
      paramString1.hA(paramList2).afZ(paramInt1);
      paramString1.i(null, null, null, paramInt4, paramInt5);
      paramString1.ct(this.Kcp, this.KCW);
      if ((this.KEI) && (this.KEJ != null))
      {
        paramString1.bat(this.KEJ.mediaTagName);
        paramString1.aI(this.appid, this.KEJ.messageExt, this.KEJ.messageAction);
      }
      paramInt1 = paramString1.in();
      if (this.KCV != null)
      {
        this.KCV.wQ(paramInt1);
        com.tencent.mm.plugin.sns.k.i.Kjb.c(this.KCV);
      }
      aj.fOE().fNd();
      this.iXq.finish();
      AppMethodBeat.o(99716);
      return false;
      paramString1.agc(0);
    }
  }
  
  public final void ay(Bundle paramBundle)
  {
    AppMethodBeat.i(99715);
    this.KCV = l.x(this.iXq.getIntent());
    this.wZt = this.iXq.getIntent().getStringExtra("Kdescription");
    this.appid = Util.nullAs(this.iXq.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = Util.nullAs(this.iXq.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.KEH = this.iXq.getIntent().getBooleanExtra("KThrid_app", false);
    this.KEI = this.iXq.getIntent().getBooleanExtra("KSnsAction", false);
    this.KCP = this.iXq.getIntent().getIntExtra("Ksnsupload_source", 0);
    this.KEJ = new SendMessageToWX.Req(this.iXq.getIntent().getBundleExtra("Ksnsupload_timeline")).message;
    if (this.iXq.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {}
    for (this.Kcp = 1;; this.Kcp = 0)
    {
      this.KCW = Util.nullAs(this.iXq.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
      AppMethodBeat.o(99715);
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
    return true;
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
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bs
 * JD-Core Version:    0.7.0.1
 */