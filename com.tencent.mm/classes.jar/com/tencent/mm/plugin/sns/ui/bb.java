package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.t;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.plugin.sns.model.ay;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bap;
import com.tencent.mm.protocal.protobuf.cfm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.j;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class bb
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
  
  public bb(MMActivity paramMMActivity)
  {
    this.cmc = paramMMActivity;
  }
  
  public final void V(Bundle paramBundle)
  {
    AppMethodBeat.i(39853);
    this.rGj = b.w(this.cmc.getIntent());
    this.rIT = this.cmc.getIntent().getStringExtra(e.j.yVi);
    this.cwc = bo.bf(this.cmc.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = bo.bf(this.cmc.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.rHD = this.cmc.getIntent().getBooleanExtra("KThrid_app", false);
    this.rHE = this.cmc.getIntent().getBooleanExtra("KSnsAction", false);
    this.rGd = this.cmc.getIntent().getIntExtra("Ksnsupload_source", 0);
    this.rHF = new SendMessageToWX.Req(this.cmc.getIntent().getBundleExtra("Ksnsupload_timeline")).message;
    AppMethodBeat.o(39853);
  }
  
  public final void W(Bundle paramBundle) {}
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, bap parambap, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(39854);
    if (this.rHF != null)
    {
      this.rHF.description = paramString1;
      if ((this.rHF.mediaObject != null) && ((this.rHF.mediaObject instanceof WXTextObject))) {
        ((WXTextObject)this.rHF.mediaObject).text = paramString1;
      }
    }
    ag.cpb();
    paramString1 = ax.b(this.rHF, paramString1, this.cwc, this.appName);
    if (paramString1 == null)
    {
      ab.e("MicroMsg.TextWidget", "packHelper == null, %s, %s", new Object[] { this.cwc, this.appName });
      AppMethodBeat.o(39854);
      return false;
    }
    paramPInt.value = paramString1.ayi;
    if (paramInt3 > a.raX) {
      paramString1.DS(4);
    }
    paramString1.DW(this.rGd);
    if (this.rHD) {
      paramString1.DW(5);
    }
    paramPInt = new LinkedList();
    if (paramList1 != null)
    {
      new LinkedList();
      paramString2 = t.aac();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        String str = (String)paramList1.next();
        if (!paramString2.contains(str))
        {
          cfm localcfm = new cfm();
          localcfm.jJA = str;
          paramPInt.add(localcfm);
        }
      }
    }
    paramString1.av(paramPInt);
    if (parami != null) {
      paramString1.go(parami.token, parami.xsy);
    }
    paramString1.a(parambap);
    if (paramBoolean) {
      paramString1.DX(1);
    }
    for (;;)
    {
      paramString1.dc(paramList2).DU(paramInt1);
      paramString1.g(null, null, null, paramInt4, paramInt5);
      if ((this.rHE) && (this.rHF != null))
      {
        paramString1.aaM(this.rHF.mediaTagName);
        paramString1.aj(this.cwc, this.rHF.messageExt, this.rHF.messageAction);
      }
      paramInt1 = paramString1.commit();
      if (this.rGj != null)
      {
        this.rGj.lX(paramInt1);
        g.roZ.c(this.rGj);
      }
      ag.cpb().cnP();
      this.cmc.finish();
      AppMethodBeat.o(39854);
      return false;
      paramString1.DX(0);
    }
  }
  
  public final boolean ctu()
  {
    return true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bb
 * JD-Core Version:    0.7.0.1
 */