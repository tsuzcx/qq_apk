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
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.bb;
import com.tencent.mm.plugin.sns.model.bc;
import com.tencent.mm.pluginsdk.i.d;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bvq;
import com.tencent.mm.protocal.protobuf.dhj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class aj
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
  private boolean zTE = false;
  private int znT = 1;
  
  public aj(MMActivity paramMMActivity, boolean paramBoolean)
  {
    this.fLP = paramMMActivity;
    this.zTE = paramBoolean;
  }
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, bvq parambvq, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(98012);
    if (this.fLP.isFinishing())
    {
      AppMethodBeat.o(98012);
      return false;
    }
    paramLinkedList = new bc(2);
    paramPInt.value = paramLinkedList.beN;
    if (paramInt3 > a.zbZ) {
      paramLinkedList.Qb(2);
    }
    paramPInt = new LinkedList();
    if (paramList1 != null)
    {
      new LinkedList();
      paramString2 = d.fas();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        String str = (String)paramList1.next();
        if (!paramString2.contains(str))
        {
          dhj localdhj = new dhj();
          localdhj.nDo = str;
          paramPInt.add(localdhj);
        }
      }
    }
    if (paramBoolean) {
      paramLinkedList.Qh(1);
    }
    for (;;)
    {
      if (parami != null) {
        paramLinkedList.jr(parami.token, parami.GTp);
      }
      paramLinkedList.Qg(this.zQd);
      if (this.zRC) {
        paramLinkedList.Qg(5);
      }
      if ((this.zRD) && (this.zRE != null))
      {
        paramLinkedList.azk(this.zRE.mediaTagName);
        paramLinkedList.aD(this.duW, this.zRE.messageExt, this.zRE.messageAction);
      }
      paramLinkedList.cc(this.znT, this.zQk);
      paramLinkedList.g(null, null, null, paramInt4, paramInt5);
      paramLinkedList.azj(paramString1).a(parambvq).aU(paramPInt).Qe(paramInt1).Qf(paramInt2).fL(paramList2);
      paramInt1 = paramLinkedList.commit();
      if (this.zQj != null)
      {
        this.zQj.pX(paramInt1);
        g.zus.c(this.zQj);
      }
      this.fLP.setResult(-1);
      ag.dUa().dSE();
      this.fLP.finish();
      AppMethodBeat.o(98012);
      return true;
      paramLinkedList.Qh(0);
    }
  }
  
  public final void ap(Bundle paramBundle)
  {
    AppMethodBeat.i(98011);
    this.zQj = e.w(this.fLP.getIntent());
    this.zTD = this.fLP.getIntent().getStringExtra("Kdescription");
    this.duW = bt.bI(this.fLP.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = bt.bI(this.fLP.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.zRC = this.fLP.getIntent().getBooleanExtra("KThrid_app", false);
    this.zRD = this.fLP.getIntent().getBooleanExtra("KSnsAction", false);
    this.zQd = this.fLP.getIntent().getIntExtra("Ksnsupload_source", 0);
    paramBundle = this.fLP.getIntent().getBundleExtra("Ksnsupload_timeline");
    if (paramBundle != null) {
      this.zRE = new SendMessageToWX.Req(paramBundle).message;
    }
    if (this.fLP.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {}
    for (this.znT = 1;; this.znT = 0)
    {
      this.zQk = bt.bI(this.fLP.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
      AppMethodBeat.o(98011);
      return;
    }
  }
  
  public final void aq(Bundle paramBundle) {}
  
  public final boolean dZG()
  {
    return this.zTE;
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
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.aj
 * JD-Core Version:    0.7.0.1
 */