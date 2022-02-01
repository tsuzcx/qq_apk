package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.e;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.j.g;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.bc;
import com.tencent.mm.plugin.sns.model.bd;
import com.tencent.mm.pluginsdk.i.d;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bwk;
import com.tencent.mm.protocal.protobuf.did;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class aj
  implements ac
{
  private int Ahk;
  private e Ahq = null;
  private String Ahr = "";
  private boolean AiJ = false;
  private boolean AiK = false;
  private WXMediaMessage AiL = null;
  private String AkK = "";
  private boolean AkL = false;
  private String appName = "";
  private String dwb = "";
  private MMActivity fNT;
  private int zFi = 1;
  
  public aj(MMActivity paramMMActivity, boolean paramBoolean)
  {
    this.fNT = paramMMActivity;
    this.AkL = paramBoolean;
  }
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, bwk parambwk, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(98012);
    if (this.fNT.isFinishing())
    {
      AppMethodBeat.o(98012);
      return false;
    }
    paramLinkedList = new bd(2);
    paramPInt.value = paramLinkedList.beN;
    if (paramInt3 > a.zsC) {
      paramLinkedList.QI(2);
    }
    paramPInt = new LinkedList();
    if (paramList1 != null)
    {
      new LinkedList();
      paramString2 = d.feg();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        String str = (String)paramList1.next();
        if (!paramString2.contains(str))
        {
          did localdid = new did();
          localdid.nIJ = str;
          paramPInt.add(localdid);
        }
      }
    }
    if (paramBoolean) {
      paramLinkedList.QO(1);
    }
    for (;;)
    {
      if (parami != null) {
        paramLinkedList.jy(parami.token, parami.HmQ);
      }
      paramLinkedList.QN(this.Ahk);
      if (this.AiJ) {
        paramLinkedList.QN(5);
      }
      if ((this.AiK) && (this.AiL != null))
      {
        paramLinkedList.aAB(this.AiL.mediaTagName);
        paramLinkedList.aD(this.dwb, this.AiL.messageExt, this.AiL.messageAction);
      }
      paramLinkedList.cc(this.zFi, this.Ahr);
      paramLinkedList.g(null, null, null, paramInt4, paramInt5);
      paramLinkedList.aAA(paramString1).a(parambwk).aV(paramPInt).QL(paramInt1).QM(paramInt2).fU(paramList2);
      paramInt1 = paramLinkedList.commit();
      if (this.Ahq != null)
      {
        this.Ahq.qa(paramInt1);
        g.zLJ.c(this.Ahq);
      }
      this.fNT.setResult(-1);
      ah.dXA().dWc();
      this.fNT.finish();
      AppMethodBeat.o(98012);
      return true;
      paramLinkedList.QO(0);
    }
  }
  
  public final void aq(Bundle paramBundle)
  {
    AppMethodBeat.i(98011);
    this.Ahq = e.w(this.fNT.getIntent());
    this.AkK = this.fNT.getIntent().getStringExtra("Kdescription");
    this.dwb = bu.bI(this.fNT.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = bu.bI(this.fNT.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.AiJ = this.fNT.getIntent().getBooleanExtra("KThrid_app", false);
    this.AiK = this.fNT.getIntent().getBooleanExtra("KSnsAction", false);
    this.Ahk = this.fNT.getIntent().getIntExtra("Ksnsupload_source", 0);
    paramBundle = this.fNT.getIntent().getBundleExtra("Ksnsupload_timeline");
    if (paramBundle != null) {
      this.AiL = new SendMessageToWX.Req(paramBundle).message;
    }
    if (this.fNT.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {}
    for (this.zFi = 1;; this.zFi = 0)
    {
      this.Ahr = bu.bI(this.fNT.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
      AppMethodBeat.o(98011);
      return;
    }
  }
  
  public final void ar(Bundle paramBundle) {}
  
  public final boolean edl()
  {
    return this.AkL;
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
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.aj
 * JD-Core Version:    0.7.0.1
 */