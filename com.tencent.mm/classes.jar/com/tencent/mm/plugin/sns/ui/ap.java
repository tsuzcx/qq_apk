package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.bf;
import com.tencent.mm.plugin.sns.model.bg;
import com.tencent.mm.plugin.sns.statistics.n;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.djv;
import com.tencent.mm.protocal.protobuf.ffw;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.b.d.i;

public final class ap
  implements ag
{
  private String AuZ = "";
  private int QzF = 1;
  private com.tencent.mm.modelsns.l RcD = null;
  private String RcE = "";
  private int Rcy;
  private boolean Rei = false;
  private boolean Rej = false;
  private WXMediaMessage Rek = null;
  private boolean Rgu = false;
  private String appName = "";
  private String appid = "";
  private MMActivity lzt;
  
  public ap(MMActivity paramMMActivity, boolean paramBoolean)
  {
    this.lzt = paramMMActivity;
    this.Rgu = paramBoolean;
  }
  
  public final boolean a(int paramInt1, int paramInt2, i parami, String paramString1, List<String> paramList1, djv paramdjv, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(98012);
    if (this.lzt.isFinishing())
    {
      AppMethodBeat.o(98012);
      return false;
    }
    paramLinkedList = new bg(2, this.lzt);
    paramPInt.value = paramLinkedList.cIh;
    if (paramInt3 > com.tencent.mm.plugin.sns.d.a.Qkq) {
      paramLinkedList.akL(2);
    }
    paramPInt = new LinkedList();
    if (paramList1 != null)
    {
      new LinkedList();
      paramString2 = com.tencent.mm.pluginsdk.platformtools.a.iIX();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        String str = (String)paramList1.next();
        if ((paramString2 != null) && (!paramString2.contains(str)))
        {
          ffw localffw = new ffw();
          localffw.UserName = str;
          paramPInt.add(localffw);
        }
      }
    }
    if (paramBoolean) {
      paramLinkedList.akR(1);
    }
    for (;;)
    {
      if (parami != null) {
        paramLinkedList.mm(parami.token, parami.aaTQ);
      }
      paramLinkedList.akQ(this.Rcy);
      if (this.Rei) {
        paramLinkedList.akQ(5);
      }
      if ((this.Rej) && (this.Rek != null))
      {
        paramLinkedList.aYN(this.Rek.mediaTagName);
        paramLinkedList.aY(this.appid, this.Rek.messageExt, this.Rek.messageAction);
      }
      paramLinkedList.df(this.QzF, this.RcE);
      paramLinkedList.i(null, null, null, paramInt4, paramInt5);
      paramLinkedList.aYM(paramString1).a(paramdjv).bU(paramPInt).akO(paramInt1).akP(paramInt2).kB(paramList2);
      if (this.lzt.getIntent().getBooleanExtra("is_tiger2022", false)) {
        paramLinkedList.kLL();
      }
      paramInt1 = paramLinkedList.FW();
      if (this.RcD != null)
      {
        this.RcD.wQ(paramInt1);
        com.tencent.mm.plugin.sns.statistics.l.QGY.c(this.RcD);
      }
      this.lzt.setResult(-1);
      al.hgx().hej();
      this.lzt.finish();
      AppMethodBeat.o(98012);
      return true;
      paramLinkedList.akR(0);
    }
  }
  
  public final void aZ(Bundle paramBundle)
  {
    AppMethodBeat.i(98011);
    this.RcD = com.tencent.mm.modelsns.l.y(this.lzt.getIntent());
    this.AuZ = this.lzt.getIntent().getStringExtra("Kdescription");
    this.appid = Util.nullAs(this.lzt.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = Util.nullAs(this.lzt.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.Rei = this.lzt.getIntent().getBooleanExtra("KThrid_app", false);
    this.Rej = this.lzt.getIntent().getBooleanExtra("KSnsAction", false);
    this.Rcy = this.lzt.getIntent().getIntExtra("Ksnsupload_source", 0);
    paramBundle = this.lzt.getIntent().getBundleExtra("Ksnsupload_timeline");
    if (paramBundle != null) {
      this.Rek = new SendMessageToWX.Req(paramBundle).message;
    }
    if (this.lzt.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {}
    for (this.QzF = 1;; this.QzF = 0)
    {
      this.RcE = Util.nullAs(this.lzt.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
      AppMethodBeat.o(98011);
      return;
    }
  }
  
  public final void ba(Bundle paramBundle) {}
  
  public final boolean hlP()
  {
    return this.Rgu;
  }
  
  public final View hlQ()
  {
    return null;
  }
  
  public final boolean hlR()
  {
    return true;
  }
  
  public final boolean hlS()
  {
    return true;
  }
  
  public final boolean hlT()
  {
    return false;
  }
  
  public final boolean n(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ap
 * JD-Core Version:    0.7.0.1
 */