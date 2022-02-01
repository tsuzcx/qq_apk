package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.j.h;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ba;
import com.tencent.mm.plugin.sns.model.bb;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.brd;
import com.tencent.mm.protocal.protobuf.dbw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.b.d.i;

public final class bj
  implements ab
{
  private String appName = "";
  private String djj = "";
  private MMActivity iMV;
  private int xXU = 1;
  private boolean yAm = false;
  private boolean yAn = false;
  private WXMediaMessage yAo = null;
  private String yCj = "";
  private int yyR;
  private d yyX = null;
  private String yyY = "";
  
  public bj(MMActivity paramMMActivity)
  {
    this.iMV = paramMMActivity;
  }
  
  public final boolean a(int paramInt1, int paramInt2, i parami, String paramString1, List<String> paramList1, brd parambrd, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(99716);
    if (this.yAo != null)
    {
      this.yAo.description = paramString1;
      if ((this.yAo.mediaObject != null) && ((this.yAo.mediaObject instanceof WXTextObject))) {
        ((WXTextObject)this.yAo.mediaObject).text = paramString1;
      }
    }
    af.dHN();
    paramString1 = ba.b(this.yAo, paramString1, this.djj, this.appName);
    if (paramString1 == null)
    {
      ac.e("MicroMsg.TextWidget", "packHelper == null, %s, %s", new Object[] { this.djj, this.appName });
      AppMethodBeat.o(99716);
      return false;
    }
    paramPInt.value = paramString1.aUt;
    if (paramInt3 > a.xMh) {
      paramString1.Ou(4);
    }
    paramString1.Oy(this.yyR);
    if (this.yAm) {
      paramString1.Oy(5);
    }
    paramLinkedList = new LinkedList();
    if (paramList1 != null)
    {
      new LinkedList();
      paramPInt = com.tencent.mm.pluginsdk.g.j.fdk();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramString2 = (String)paramList1.next();
        if (!paramPInt.contains(paramString2))
        {
          dbw localdbw = new dbw();
          localdbw.ncR = paramString2;
          paramLinkedList.add(localdbw);
        }
      }
    }
    paramString1.aT(paramLinkedList);
    if (parami != null) {
      paramString1.jf(parami.token, parami.FjO);
    }
    paramString1.a(parambrd);
    if (paramBoolean) {
      paramString1.Oz(1);
    }
    for (;;)
    {
      paramString1.fy(paramList2).Ow(paramInt1);
      paramString1.g(null, null, null, paramInt4, paramInt5);
      paramString1.bV(this.xXU, this.yyY);
      if ((this.yAn) && (this.yAo != null))
      {
        paramString1.auf(this.yAo.mediaTagName);
        paramString1.aw(this.djj, this.yAo.messageExt, this.yAo.messageAction);
      }
      paramInt1 = paramString1.commit();
      if (this.yyX != null)
      {
        this.yyX.pu(paramInt1);
        h.yes.c(this.yyX);
      }
      af.dHN().dGr();
      this.iMV.finish();
      AppMethodBeat.o(99716);
      return false;
      paramString1.Oz(0);
    }
  }
  
  public final void ak(Bundle paramBundle)
  {
    AppMethodBeat.i(99715);
    this.yyX = d.w(this.iMV.getIntent());
    this.yCj = this.iMV.getIntent().getStringExtra("Kdescription");
    this.djj = bs.bG(this.iMV.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = bs.bG(this.iMV.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.yAm = this.iMV.getIntent().getBooleanExtra("KThrid_app", false);
    this.yAn = this.iMV.getIntent().getBooleanExtra("KSnsAction", false);
    this.yyR = this.iMV.getIntent().getIntExtra("Ksnsupload_source", 0);
    this.yAo = new SendMessageToWX.Req(this.iMV.getIntent().getBundleExtra("Ksnsupload_timeline")).message;
    if (this.iMV.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {}
    for (this.xXU = 1;; this.xXU = 0)
    {
      this.yyY = bs.bG(this.iMV.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
      AppMethodBeat.o(99715);
      return;
    }
  }
  
  public final void al(Bundle paramBundle) {}
  
  public final boolean dNr()
  {
    return true;
  }
  
  public final View dNs()
  {
    return null;
  }
  
  public final boolean dNt()
  {
    return false;
  }
  
  public final boolean k(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bj
 * JD-Core Version:    0.7.0.1
 */