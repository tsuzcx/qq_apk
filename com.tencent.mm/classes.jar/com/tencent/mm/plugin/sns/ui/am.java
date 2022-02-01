package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.k;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.k.g;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.be;
import com.tencent.mm.plugin.sns.model.bf;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.cjy;
import com.tencent.mm.protocal.protobuf.ebm;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class am
  implements ad
{
  private int DPi = 1;
  private int EpG;
  private k EpM = null;
  private String EpN = "";
  private boolean Ero = false;
  private boolean Erp = false;
  private WXMediaMessage Erq = null;
  private boolean Etx = false;
  private String appName = "";
  private String dNI = "";
  private MMActivity gte;
  private String trj = "";
  
  public am(MMActivity paramMMActivity, boolean paramBoolean)
  {
    this.gte = paramMMActivity;
    this.Etx = paramBoolean;
  }
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, cjy paramcjy, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(98012);
    if (this.gte.isFinishing())
    {
      AppMethodBeat.o(98012);
      return false;
    }
    paramLinkedList = new bf(2, this.gte);
    paramPInt.value = paramLinkedList.beK;
    if (paramInt3 > com.tencent.mm.plugin.sns.c.a.DCT) {
      paramLinkedList.YF(2);
    }
    paramPInt = new LinkedList();
    if (paramList1 != null)
    {
      new LinkedList();
      paramString2 = com.tencent.mm.pluginsdk.i.a.gnq();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        String str = (String)paramList1.next();
        if (!paramString2.contains(str))
        {
          ebm localebm = new ebm();
          localebm.UserName = str;
          paramPInt.add(localebm);
        }
      }
    }
    if (paramBoolean) {
      paramLinkedList.YL(1);
    }
    for (;;)
    {
      if (parami != null) {
        paramLinkedList.kl(parami.token, parami.Mte);
      }
      paramLinkedList.YK(this.EpG);
      if (this.Ero) {
        paramLinkedList.YK(5);
      }
      if ((this.Erp) && (this.Erq != null))
      {
        paramLinkedList.aPx(this.Erq.mediaTagName);
        paramLinkedList.aO(this.dNI, this.Erq.messageExt, this.Erq.messageAction);
      }
      paramLinkedList.ct(this.DPi, this.EpN);
      paramLinkedList.g(null, null, null, paramInt4, paramInt5);
      paramLinkedList.aPw(paramString1).a(paramcjy).bq(paramPInt).YI(paramInt1).YJ(paramInt2).gR(paramList2);
      paramInt1 = paramLinkedList.commit();
      if (this.EpM != null)
      {
        this.EpM.tQ(paramInt1);
        g.DVR.c(this.EpM);
      }
      this.gte.setResult(-1);
      aj.faK().eZn();
      this.gte.finish();
      AppMethodBeat.o(98012);
      return true;
      paramLinkedList.YL(0);
    }
  }
  
  public final void aC(Bundle paramBundle)
  {
    AppMethodBeat.i(98011);
    this.EpM = k.w(this.gte.getIntent());
    this.trj = this.gte.getIntent().getStringExtra("Kdescription");
    this.dNI = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.Ero = this.gte.getIntent().getBooleanExtra("KThrid_app", false);
    this.Erp = this.gte.getIntent().getBooleanExtra("KSnsAction", false);
    this.EpG = this.gte.getIntent().getIntExtra("Ksnsupload_source", 0);
    paramBundle = this.gte.getIntent().getBundleExtra("Ksnsupload_timeline");
    if (paramBundle != null) {
      this.Erq = new SendMessageToWX.Req(paramBundle).message;
    }
    if (this.gte.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {}
    for (this.DPi = 1;; this.DPi = 0)
    {
      this.EpN = Util.nullAs(this.gte.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
      AppMethodBeat.o(98011);
      return;
    }
  }
  
  public final void aD(Bundle paramBundle) {}
  
  public final boolean ffA()
  {
    return this.Etx;
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
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.am
 * JD-Core Version:    0.7.0.1
 */