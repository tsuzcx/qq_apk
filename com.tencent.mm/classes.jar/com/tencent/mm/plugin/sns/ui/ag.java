package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.j.h;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ba;
import com.tencent.mm.plugin.sns.model.bb;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.brd;
import com.tencent.mm.protocal.protobuf.dbw;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.b.d.i;

public final class ag
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
  private boolean yCk = false;
  private int yyR;
  private d yyX = null;
  private String yyY = "";
  
  public ag(MMActivity paramMMActivity, boolean paramBoolean)
  {
    this.iMV = paramMMActivity;
    this.yCk = paramBoolean;
  }
  
  public final boolean a(int paramInt1, int paramInt2, i parami, String paramString1, List<String> paramList1, brd parambrd, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(98012);
    if (this.iMV.isFinishing())
    {
      AppMethodBeat.o(98012);
      return false;
    }
    paramLinkedList = new bb(2);
    paramPInt.value = paramLinkedList.aUt;
    if (paramInt3 > a.xMh) {
      paramLinkedList.Ou(2);
    }
    paramPInt = new LinkedList();
    if (paramList1 != null)
    {
      new LinkedList();
      paramString2 = com.tencent.mm.pluginsdk.g.j.fdk();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        String str = (String)paramList1.next();
        if (!paramString2.contains(str))
        {
          dbw localdbw = new dbw();
          localdbw.ncR = str;
          paramPInt.add(localdbw);
        }
      }
    }
    if (paramBoolean) {
      paramLinkedList.Oz(1);
    }
    for (;;)
    {
      if (parami != null) {
        paramLinkedList.jf(parami.token, parami.FjO);
      }
      paramLinkedList.Oy(this.yyR);
      if (this.yAm) {
        paramLinkedList.Oy(5);
      }
      if ((this.yAn) && (this.yAo != null))
      {
        paramLinkedList.auf(this.yAo.mediaTagName);
        paramLinkedList.aw(this.djj, this.yAo.messageExt, this.yAo.messageAction);
      }
      paramLinkedList.bV(this.xXU, this.yyY);
      paramLinkedList.g(null, null, null, paramInt4, paramInt5);
      paramLinkedList.aue(paramString1).a(parambrd).aT(paramPInt).Ow(paramInt1).Ox(paramInt2).fy(paramList2);
      paramInt1 = paramLinkedList.commit();
      if (this.yyX != null)
      {
        this.yyX.pu(paramInt1);
        h.yes.c(this.yyX);
      }
      this.iMV.setResult(-1);
      af.dHN().dGr();
      this.iMV.finish();
      AppMethodBeat.o(98012);
      return true;
      paramLinkedList.Oz(0);
    }
  }
  
  public final void ak(Bundle paramBundle)
  {
    AppMethodBeat.i(98011);
    this.yyX = d.w(this.iMV.getIntent());
    this.yCj = this.iMV.getIntent().getStringExtra("Kdescription");
    this.djj = bs.bG(this.iMV.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = bs.bG(this.iMV.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.yAm = this.iMV.getIntent().getBooleanExtra("KThrid_app", false);
    this.yAn = this.iMV.getIntent().getBooleanExtra("KSnsAction", false);
    this.yyR = this.iMV.getIntent().getIntExtra("Ksnsupload_source", 0);
    paramBundle = this.iMV.getIntent().getBundleExtra("Ksnsupload_timeline");
    if (paramBundle != null) {
      this.yAo = new SendMessageToWX.Req(paramBundle).message;
    }
    if (this.iMV.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {}
    for (this.xXU = 1;; this.xXU = 0)
    {
      this.yyY = bs.bG(this.iMV.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
      AppMethodBeat.o(98011);
      return;
    }
  }
  
  public final void al(Bundle paramBundle) {}
  
  public final boolean dNr()
  {
    return this.yCk;
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
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ag
 * JD-Core Version:    0.7.0.1
 */