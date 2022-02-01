package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.bf;
import com.tencent.mm.plugin.sns.model.bg;
import com.tencent.mm.plugin.sns.statistics.n;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.djv;
import com.tencent.mm.protocal.protobuf.ffw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.b.d.i;

public final class bt
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
  private String appName = "";
  private String appid = "";
  private MMActivity lzt;
  
  public bt(MMActivity paramMMActivity)
  {
    this.lzt = paramMMActivity;
  }
  
  public final boolean a(int paramInt1, int paramInt2, i parami, String paramString1, List<String> paramList1, djv paramdjv, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(99716);
    if (this.Rek != null)
    {
      this.Rek.description = paramString1;
      if ((this.Rek.mediaObject != null) && ((this.Rek.mediaObject instanceof WXTextObject))) {
        ((WXTextObject)this.Rek.mediaObject).text = paramString1;
      }
    }
    al.hgx();
    paramString1 = bf.c(this.Rek, paramString1, this.appid, this.appName);
    if (paramString1 == null)
    {
      Log.e("MicroMsg.TextWidget", "packHelper == null, %s, %s", new Object[] { this.appid, this.appName });
      AppMethodBeat.o(99716);
      return false;
    }
    paramPInt.value = paramString1.cIh;
    if (paramInt3 > com.tencent.mm.plugin.sns.d.a.Qkq) {
      paramString1.akL(4);
    }
    paramString1.akQ(this.Rcy);
    if (this.Rei) {
      paramString1.akQ(5);
    }
    paramLinkedList = new LinkedList();
    if (paramList1 != null)
    {
      new LinkedList();
      paramPInt = com.tencent.mm.pluginsdk.platformtools.a.iIX();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramString2 = (String)paramList1.next();
        if ((paramPInt != null) && (!paramPInt.contains(paramString2)))
        {
          ffw localffw = new ffw();
          localffw.UserName = paramString2;
          paramLinkedList.add(localffw);
        }
      }
    }
    paramString1.bU(paramLinkedList);
    if (parami != null) {
      paramString1.mm(parami.token, parami.aaTQ);
    }
    paramString1.a(paramdjv);
    if (paramBoolean) {
      paramString1.akR(1);
    }
    for (;;)
    {
      paramString1.kB(paramList2).akO(paramInt1);
      paramString1.i(null, null, null, paramInt4, paramInt5);
      paramString1.df(this.QzF, this.RcE);
      if ((this.Rej) && (this.Rek != null))
      {
        paramString1.aYN(this.Rek.mediaTagName);
        paramString1.aY(this.appid, this.Rek.messageExt, this.Rek.messageAction);
      }
      paramInt1 = paramString1.FW();
      if (this.RcD != null)
      {
        this.RcD.wQ(paramInt1);
        com.tencent.mm.plugin.sns.statistics.l.QGY.c(this.RcD);
      }
      if (this.lzt.getIntent().getBooleanExtra("is_tiger2022", false)) {
        paramString1.kLL();
      }
      al.hgx().hej();
      this.lzt.finish();
      AppMethodBeat.o(99716);
      return false;
      paramString1.akR(0);
    }
  }
  
  public final void aZ(Bundle paramBundle)
  {
    AppMethodBeat.i(99715);
    this.RcD = com.tencent.mm.modelsns.l.y(this.lzt.getIntent());
    this.AuZ = this.lzt.getIntent().getStringExtra("Kdescription");
    this.appid = Util.nullAs(this.lzt.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = Util.nullAs(this.lzt.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.Rei = this.lzt.getIntent().getBooleanExtra("KThrid_app", false);
    this.Rej = this.lzt.getIntent().getBooleanExtra("KSnsAction", false);
    this.Rcy = this.lzt.getIntent().getIntExtra("Ksnsupload_source", 0);
    this.Rek = new SendMessageToWX.Req(this.lzt.getIntent().getBundleExtra("Ksnsupload_timeline")).message;
    if (this.lzt.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {}
    for (this.QzF = 1;; this.QzF = 0)
    {
      this.RcE = Util.nullAs(this.lzt.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
      AppMethodBeat.o(99715);
      return;
    }
  }
  
  public final void ba(Bundle paramBundle) {}
  
  public final boolean hlP()
  {
    return true;
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
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bt
 * JD-Core Version:    0.7.0.1
 */