package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.e;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.j.g;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.bb;
import com.tencent.mm.plugin.sns.model.bc;
import com.tencent.mm.pluginsdk.i.d;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bvq;
import com.tencent.mm.protocal.protobuf.dhj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class bm
  implements ac
{
  private String appName = "";
  private String duW = "";
  private MMActivity fLP;
  private int zQd;
  private e zQj = null;
  private String zQk = "";
  private boolean zRC = false;
  private boolean zRD = false;
  private WXMediaMessage zRE = null;
  private String zTD = "";
  private int znT = 1;
  
  public bm(MMActivity paramMMActivity)
  {
    this.fLP = paramMMActivity;
  }
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, bvq parambvq, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(99716);
    if (this.zRE != null)
    {
      this.zRE.description = paramString1;
      if ((this.zRE.mediaObject != null) && ((this.zRE.mediaObject instanceof WXTextObject))) {
        ((WXTextObject)this.zRE.mediaObject).text = paramString1;
      }
    }
    ag.dUa();
    paramString1 = bb.b(this.zRE, paramString1, this.duW, this.appName);
    if (paramString1 == null)
    {
      ad.e("MicroMsg.TextWidget", "packHelper == null, %s, %s", new Object[] { this.duW, this.appName });
      AppMethodBeat.o(99716);
      return false;
    }
    paramPInt.value = paramString1.beN;
    if (paramInt3 > a.zbZ) {
      paramString1.Qb(4);
    }
    paramString1.Qg(this.zQd);
    if (this.zRC) {
      paramString1.Qg(5);
    }
    paramLinkedList = new LinkedList();
    if (paramList1 != null)
    {
      new LinkedList();
      paramPInt = d.fas();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramString2 = (String)paramList1.next();
        if (!paramPInt.contains(paramString2))
        {
          dhj localdhj = new dhj();
          localdhj.nDo = paramString2;
          paramLinkedList.add(localdhj);
        }
      }
    }
    paramString1.aU(paramLinkedList);
    if (parami != null) {
      paramString1.jr(parami.token, parami.GTp);
    }
    paramString1.a(parambvq);
    if (paramBoolean) {
      paramString1.Qh(1);
    }
    for (;;)
    {
      paramString1.fL(paramList2).Qe(paramInt1);
      paramString1.g(null, null, null, paramInt4, paramInt5);
      paramString1.cc(this.znT, this.zQk);
      if ((this.zRD) && (this.zRE != null))
      {
        paramString1.azk(this.zRE.mediaTagName);
        paramString1.aD(this.duW, this.zRE.messageExt, this.zRE.messageAction);
      }
      paramInt1 = paramString1.commit();
      if (this.zQj != null)
      {
        this.zQj.pX(paramInt1);
        g.zus.c(this.zQj);
      }
      ag.dUa().dSE();
      this.fLP.finish();
      AppMethodBeat.o(99716);
      return false;
      paramString1.Qh(0);
    }
  }
  
  public final void ap(Bundle paramBundle)
  {
    AppMethodBeat.i(99715);
    this.zQj = e.w(this.fLP.getIntent());
    this.zTD = this.fLP.getIntent().getStringExtra("Kdescription");
    this.duW = bt.bI(this.fLP.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = bt.bI(this.fLP.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.zRC = this.fLP.getIntent().getBooleanExtra("KThrid_app", false);
    this.zRD = this.fLP.getIntent().getBooleanExtra("KSnsAction", false);
    this.zQd = this.fLP.getIntent().getIntExtra("Ksnsupload_source", 0);
    this.zRE = new SendMessageToWX.Req(this.fLP.getIntent().getBundleExtra("Ksnsupload_timeline")).message;
    if (this.fLP.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {}
    for (this.znT = 1;; this.znT = 0)
    {
      this.zQk = bt.bI(this.fLP.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
      AppMethodBeat.o(99715);
      return;
    }
  }
  
  public final void aq(Bundle paramBundle) {}
  
  public final boolean dZG()
  {
    return true;
  }
  
  public final View dZH()
  {
    return null;
  }
  
  public final boolean dZI()
  {
    return false;
  }
  
  public final boolean k(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bm
 * JD-Core Version:    0.7.0.1
 */