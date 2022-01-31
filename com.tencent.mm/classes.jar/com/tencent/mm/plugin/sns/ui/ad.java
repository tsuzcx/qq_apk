package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.t;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.plugin.sns.model.ay;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bap;
import com.tencent.mm.protocal.protobuf.cfm;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.j;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ad
  implements y
{
  private String appName = "";
  private MMActivity cmc;
  private String cwc = "";
  private int rGd;
  private b rGj = null;
  private boolean rHD = false;
  private boolean rHE = false;
  private WXMediaMessage rHF = null;
  private String rIT = "";
  private boolean rIU = false;
  
  public ad(MMActivity paramMMActivity, boolean paramBoolean)
  {
    this.cmc = paramMMActivity;
    this.rIU = paramBoolean;
  }
  
  public final void V(Bundle paramBundle)
  {
    AppMethodBeat.i(38358);
    this.rGj = b.w(this.cmc.getIntent());
    this.rIT = this.cmc.getIntent().getStringExtra(e.j.yVi);
    this.cwc = bo.bf(this.cmc.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = bo.bf(this.cmc.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.rHD = this.cmc.getIntent().getBooleanExtra("KThrid_app", false);
    this.rHE = this.cmc.getIntent().getBooleanExtra("KSnsAction", false);
    this.rGd = this.cmc.getIntent().getIntExtra("Ksnsupload_source", 0);
    paramBundle = this.cmc.getIntent().getBundleExtra("Ksnsupload_timeline");
    if (paramBundle != null) {
      this.rHF = new SendMessageToWX.Req(paramBundle).message;
    }
    AppMethodBeat.o(38358);
  }
  
  public final void W(Bundle paramBundle) {}
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, bap parambap, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(38359);
    if (this.cmc.isFinishing())
    {
      AppMethodBeat.o(38359);
      return false;
    }
    paramString2 = new ay(2);
    paramPInt.value = paramString2.ayi;
    if (paramInt3 > a.raX) {
      paramString2.DS(2);
    }
    paramPInt = new LinkedList();
    if (paramList1 != null)
    {
      new LinkedList();
      List localList = t.aac();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        String str = (String)paramList1.next();
        if (!localList.contains(str))
        {
          cfm localcfm = new cfm();
          localcfm.jJA = str;
          paramPInt.add(localcfm);
        }
      }
    }
    if (paramBoolean) {
      paramString2.DX(1);
    }
    for (;;)
    {
      if (parami != null) {
        paramString2.go(parami.token, parami.xsy);
      }
      paramString2.DW(this.rGd);
      if (this.rHD) {
        paramString2.DW(5);
      }
      if ((this.rHE) && (this.rHF != null))
      {
        paramString2.aaM(this.rHF.mediaTagName);
        paramString2.aj(this.cwc, this.rHF.messageExt, this.rHF.messageAction);
      }
      paramString2.g(null, null, null, paramInt4, paramInt5);
      paramString2.aaL(paramString1).a(parambap).av(paramPInt).DU(paramInt1).DV(paramInt2).dc(paramList2);
      paramInt1 = paramString2.commit();
      if (this.rGj != null)
      {
        this.rGj.lX(paramInt1);
        g.roZ.c(this.rGj);
      }
      this.cmc.setResult(-1);
      ag.cpb().cnP();
      this.cmc.finish();
      AppMethodBeat.o(38359);
      return true;
      paramString2.DX(0);
    }
  }
  
  public final boolean ctu()
  {
    return this.rIU;
  }
  
  public final View ctv()
  {
    return null;
  }
  
  public final boolean ctw()
  {
    return false;
  }
  
  public final boolean j(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ad
 * JD-Core Version:    0.7.0.1
 */