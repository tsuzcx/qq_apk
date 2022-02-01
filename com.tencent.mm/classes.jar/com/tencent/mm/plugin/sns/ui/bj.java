package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.w;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.plugin.sns.d.a;
import com.tencent.mm.plugin.sns.k.h;
import com.tencent.mm.plugin.sns.k.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.az;
import com.tencent.mm.plugin.sns.model.ba;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bmn;
import com.tencent.mm.protocal.protobuf.cwk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.b.d.i;

public final class bj
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
  
  public bj(MMActivity paramMMActivity)
  {
    this.imP = paramMMActivity;
  }
  
  public final boolean a(int paramInt1, int paramInt2, i parami, String paramString1, List<String> paramList1, bmn parambmn, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(99716);
    if (this.xnx != null)
    {
      this.xnx.description = paramString1;
      if ((this.xnx.mediaObject != null) && ((this.xnx.mediaObject instanceof WXTextObject))) {
        ((WXTextObject)this.xnx.mediaObject).text = paramString1;
      }
    }
    af.dtq();
    paramString1 = az.b(this.xnx, paramString1, this.dlB, this.appName);
    if (paramString1 == null)
    {
      ad.e("MicroMsg.TextWidget", "packHelper == null, %s, %s", new Object[] { this.dlB, this.appName });
      AppMethodBeat.o(99716);
      return false;
    }
    paramPInt.value = paramString1.aTB;
    if (paramInt3 > a.wzN) {
      paramString1.Ms(4);
    }
    paramString1.Mw(this.xlZ);
    if (this.xnv) {
      paramString1.Mw(5);
    }
    paramLinkedList = new LinkedList();
    if (paramList1 != null)
    {
      new LinkedList();
      paramPInt = w.arx();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramString2 = (String)paramList1.next();
        if (!paramPInt.contains(paramString2))
        {
          cwk localcwk = new cwk();
          localcwk.mAQ = paramString2;
          paramLinkedList.add(localcwk);
        }
      }
    }
    paramString1.aM(paramLinkedList);
    if (parami != null) {
      paramString1.iI(parami.token, parami.DNx);
    }
    paramString1.a(parambmn);
    if (paramBoolean) {
      paramString1.Mx(1);
    }
    for (;;)
    {
      paramString1.fq(paramList2).Mu(paramInt1);
      paramString1.g(null, null, null, paramInt4, paramInt5);
      paramString1.bR(this.wLo, this.xmg);
      if ((this.xnw) && (this.xnx != null))
      {
        paramString1.aoT(this.xnx.mediaTagName);
        paramString1.au(this.dlB, this.xnx.messageExt, this.xnx.messageAction);
      }
      paramInt1 = paramString1.commit();
      if (this.xmf != null)
      {
        this.xmf.oG(paramInt1);
        h.wRM.c(this.xmf);
      }
      af.dtq().drS();
      this.imP.finish();
      AppMethodBeat.o(99716);
      return false;
      paramString1.Mx(0);
    }
  }
  
  public final void af(Bundle paramBundle)
  {
    AppMethodBeat.i(99715);
    this.xmf = d.w(this.imP.getIntent());
    this.xpt = this.imP.getIntent().getStringExtra("Kdescription");
    this.dlB = bt.by(this.imP.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = bt.by(this.imP.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.xnv = this.imP.getIntent().getBooleanExtra("KThrid_app", false);
    this.xnw = this.imP.getIntent().getBooleanExtra("KSnsAction", false);
    this.xlZ = this.imP.getIntent().getIntExtra("Ksnsupload_source", 0);
    this.xnx = new SendMessageToWX.Req(this.imP.getIntent().getBundleExtra("Ksnsupload_timeline")).message;
    if (this.imP.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {}
    for (this.wLo = 1;; this.wLo = 0)
    {
      this.xmg = bt.by(this.imP.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
      AppMethodBeat.o(99715);
      return;
    }
  }
  
  public final void ag(Bundle paramBundle) {}
  
  public final boolean dyU()
  {
    return true;
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
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bj
 * JD-Core Version:    0.7.0.1
 */