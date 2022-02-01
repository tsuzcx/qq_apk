package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.k;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.plugin.sns.k.g;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.be;
import com.tencent.mm.plugin.sns.model.bf;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.cjy;
import com.tencent.mm.protocal.protobuf.ebm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class bp
  implements ad
{
  private int DPi = 1;
  private int EpG;
  private k EpM = null;
  private String EpN = "";
  private boolean Ero = false;
  private boolean Erp = false;
  private WXMediaMessage Erq = null;
  private String appName = "";
  private String dNI = "";
  private MMActivity gte;
  private String trj = "";
  
  public bp(MMActivity paramMMActivity)
  {
    this.gte = paramMMActivity;
  }
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, cjy paramcjy, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(99716);
    if (this.Erq != null)
    {
      this.Erq.description = paramString1;
      if ((this.Erq.mediaObject != null) && ((this.Erq.mediaObject instanceof WXTextObject))) {
        ((WXTextObject)this.Erq.mediaObject).text = paramString1;
      }
    }
    aj.faK();
    paramString1 = be.c(this.Erq, paramString1, this.dNI, this.appName);
    if (paramString1 == null)
    {
      Log.e("MicroMsg.TextWidget", "packHelper == null, %s, %s", new Object[] { this.dNI, this.appName });
      AppMethodBeat.o(99716);
      return false;
    }
    paramPInt.value = paramString1.beK;
    if (paramInt3 > com.tencent.mm.plugin.sns.c.a.DCT) {
      paramString1.YF(4);
    }
    paramString1.YK(this.EpG);
    if (this.Ero) {
      paramString1.YK(5);
    }
    paramLinkedList = new LinkedList();
    if (paramList1 != null)
    {
      new LinkedList();
      paramPInt = com.tencent.mm.pluginsdk.i.a.gnq();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramString2 = (String)paramList1.next();
        if (!paramPInt.contains(paramString2))
        {
          ebm localebm = new ebm();
          localebm.UserName = paramString2;
          paramLinkedList.add(localebm);
        }
      }
    }
    paramString1.bq(paramLinkedList);
    if (parami != null) {
      paramString1.kl(parami.token, parami.Mte);
    }
    paramString1.a(paramcjy);
    if (paramBoolean) {
      paramString1.YL(1);
    }
    for (;;)
    {
      paramString1.gR(paramList2).YI(paramInt1);
      paramString1.g(null, null, null, paramInt4, paramInt5);
      paramString1.ct(this.DPi, this.EpN);
      if ((this.Erp) && (this.Erq != null))
      {
        paramString1.aPx(this.Erq.mediaTagName);
        paramString1.aO(this.dNI, this.Erq.messageExt, this.Erq.messageAction);
      }
      paramInt1 = paramString1.commit();
      if (this.EpM != null)
      {
        this.EpM.tQ(paramInt1);
        g.DVR.c(this.EpM);
      }
      aj.faK().eZn();
      this.gte.finish();
      AppMethodBeat.o(99716);
      return false;
      paramString1.YL(0);
    }
  }
  
  public final void aC(Bundle paramBundle)
  {
    AppMethodBeat.i(99715);
    this.EpM = k.w(this.gte.getIntent());
    this.trj = this.gte.getIntent().getStringExtra("Kdescription");
    this.dNI = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.Ero = this.gte.getIntent().getBooleanExtra("KThrid_app", false);
    this.Erp = this.gte.getIntent().getBooleanExtra("KSnsAction", false);
    this.EpG = this.gte.getIntent().getIntExtra("Ksnsupload_source", 0);
    this.Erq = new SendMessageToWX.Req(this.gte.getIntent().getBundleExtra("Ksnsupload_timeline")).message;
    if (this.gte.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {}
    for (this.DPi = 1;; this.DPi = 0)
    {
      this.EpN = Util.nullAs(this.gte.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
      AppMethodBeat.o(99715);
      return;
    }
  }
  
  public final void aD(Bundle paramBundle) {}
  
  public final boolean ffA()
  {
    return true;
  }
  
  public final View ffB()
  {
    return null;
  }
  
  public final boolean ffC()
  {
    return true;
  }
  
  public final boolean ffD()
  {
    return true;
  }
  
  public final boolean ffE()
  {
    return false;
  }
  
  public final boolean k(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bp
 * JD-Core Version:    0.7.0.1
 */