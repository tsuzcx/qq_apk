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
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.bc;
import com.tencent.mm.plugin.sns.model.bd;
import com.tencent.mm.pluginsdk.i.d;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bwk;
import com.tencent.mm.protocal.protobuf.did;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class bm
  implements ac
{
  private int Ahk;
  private e Ahq = null;
  private String Ahr = "";
  private boolean AiJ = false;
  private boolean AiK = false;
  private WXMediaMessage AiL = null;
  private String AkK = "";
  private String appName = "";
  private String dwb = "";
  private MMActivity fNT;
  private int zFi = 1;
  
  public bm(MMActivity paramMMActivity)
  {
    this.fNT = paramMMActivity;
  }
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, bwk parambwk, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(99716);
    if (this.AiL != null)
    {
      this.AiL.description = paramString1;
      if ((this.AiL.mediaObject != null) && ((this.AiL.mediaObject instanceof WXTextObject))) {
        ((WXTextObject)this.AiL.mediaObject).text = paramString1;
      }
    }
    ah.dXA();
    paramString1 = bc.b(this.AiL, paramString1, this.dwb, this.appName);
    if (paramString1 == null)
    {
      ae.e("MicroMsg.TextWidget", "packHelper == null, %s, %s", new Object[] { this.dwb, this.appName });
      AppMethodBeat.o(99716);
      return false;
    }
    paramPInt.value = paramString1.beN;
    if (paramInt3 > a.zsC) {
      paramString1.QI(4);
    }
    paramString1.QN(this.Ahk);
    if (this.AiJ) {
      paramString1.QN(5);
    }
    paramLinkedList = new LinkedList();
    if (paramList1 != null)
    {
      new LinkedList();
      paramPInt = d.feg();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramString2 = (String)paramList1.next();
        if (!paramPInt.contains(paramString2))
        {
          did localdid = new did();
          localdid.nIJ = paramString2;
          paramLinkedList.add(localdid);
        }
      }
    }
    paramString1.aV(paramLinkedList);
    if (parami != null) {
      paramString1.jy(parami.token, parami.HmQ);
    }
    paramString1.a(parambwk);
    if (paramBoolean) {
      paramString1.QO(1);
    }
    for (;;)
    {
      paramString1.fU(paramList2).QL(paramInt1);
      paramString1.g(null, null, null, paramInt4, paramInt5);
      paramString1.cc(this.zFi, this.Ahr);
      if ((this.AiK) && (this.AiL != null))
      {
        paramString1.aAB(this.AiL.mediaTagName);
        paramString1.aD(this.dwb, this.AiL.messageExt, this.AiL.messageAction);
      }
      paramInt1 = paramString1.commit();
      if (this.Ahq != null)
      {
        this.Ahq.qa(paramInt1);
        g.zLJ.c(this.Ahq);
      }
      ah.dXA().dWc();
      this.fNT.finish();
      AppMethodBeat.o(99716);
      return false;
      paramString1.QO(0);
    }
  }
  
  public final void aq(Bundle paramBundle)
  {
    AppMethodBeat.i(99715);
    this.Ahq = e.w(this.fNT.getIntent());
    this.AkK = this.fNT.getIntent().getStringExtra("Kdescription");
    this.dwb = bu.bI(this.fNT.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = bu.bI(this.fNT.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.AiJ = this.fNT.getIntent().getBooleanExtra("KThrid_app", false);
    this.AiK = this.fNT.getIntent().getBooleanExtra("KSnsAction", false);
    this.Ahk = this.fNT.getIntent().getIntExtra("Ksnsupload_source", 0);
    this.AiL = new SendMessageToWX.Req(this.fNT.getIntent().getBundleExtra("Ksnsupload_timeline")).message;
    if (this.fNT.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {}
    for (this.zFi = 1;; this.zFi = 0)
    {
      this.Ahr = bu.bI(this.fNT.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
      AppMethodBeat.o(99715);
      return;
    }
  }
  
  public final void ar(Bundle paramBundle) {}
  
  public final boolean edl()
  {
    return true;
  }
  
  public final View edm()
  {
    return null;
  }
  
  public final boolean edn()
  {
    return true;
  }
  
  public final boolean edo()
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