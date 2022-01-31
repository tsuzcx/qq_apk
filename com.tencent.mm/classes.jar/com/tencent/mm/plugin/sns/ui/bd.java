package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.model.s;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.h.f;
import com.tencent.mm.plugin.sns.h.h;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.aui;
import com.tencent.mm.protocal.c.buw;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.h;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.c.d.i;

public final class bd
  implements y
{
  private String appName = "";
  private MMActivity bER;
  private String bOL = "";
  private int oOs;
  private b oOy = null;
  private boolean oPR = false;
  private boolean oPS = false;
  private WXMediaMessage oPT = null;
  private String oRh = "";
  
  public bd(MMActivity paramMMActivity)
  {
    this.bER = paramMMActivity;
  }
  
  public final void E(Bundle paramBundle)
  {
    this.oOy = b.i(this.bER.getIntent());
    this.oRh = this.bER.getIntent().getStringExtra(e.h.uHV);
    this.bOL = bk.aM(this.bER.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = bk.aM(this.bER.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.oPR = this.bER.getIntent().getBooleanExtra("KThrid_app", false);
    this.oPS = this.bER.getIntent().getBooleanExtra("KSnsAction", false);
    this.oOs = this.bER.getIntent().getIntExtra("Ksnsupload_source", 0);
    this.oPT = new SendMessageToWX.Req(this.bER.getIntent().getBundleExtra("Ksnsupload_timeline")).message;
  }
  
  public final void F(Bundle paramBundle) {}
  
  public final boolean a(int paramInt1, int paramInt2, i parami, String paramString1, List<String> paramList1, aui paramaui, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    if (this.oPT != null)
    {
      this.oPT.description = paramString1;
      if ((this.oPT.mediaObject != null) && ((this.oPT.mediaObject instanceof WXTextObject))) {
        ((WXTextObject)this.oPT.mediaObject).text = paramString1;
      }
    }
    af.bDB();
    paramString1 = aw.b(this.oPT, paramString1, this.bOL, this.appName);
    if (paramString1 == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.TextWidget", "packHelper == null, %s, %s", new Object[] { this.bOL, this.appName });
      return false;
    }
    paramPInt.value = paramString1.avS;
    if (paramInt3 > a.omJ) {
      paramString1.xS(4);
    }
    paramString1.xW(this.oOs);
    if (this.oPR) {
      paramString1.xW(5);
    }
    paramPInt = new LinkedList();
    if (paramList1 != null)
    {
      new LinkedList();
      paramString2 = s.Ha();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        String str = (String)paramList1.next();
        if (!paramString2.contains(str))
        {
          buw localbuw = new buw();
          localbuw.hPY = str;
          paramPInt.add(localbuw);
        }
      }
    }
    paramString1.am(paramPInt);
    if (parami != null) {
      paramString1.eM(parami.token, parami.tsv);
    }
    paramString1.a(paramaui);
    if (paramBoolean) {
      paramString1.xX(1);
    }
    for (;;)
    {
      paramString1.cx(paramList2).xU(paramInt1);
      paramString1.f(null, null, null, paramInt4, paramInt5);
      if ((this.oPS) && (this.oPT != null))
      {
        paramString1.NS(this.oPT.mediaTagName);
        paramString1.Y(this.bOL, this.oPT.messageExt, this.oPT.messageAction);
      }
      paramInt1 = paramString1.commit();
      if (this.oOy != null)
      {
        this.oOy.jf(paramInt1);
        f.ozP.c(this.oOy);
      }
      af.bDB().bCp();
      this.bER.finish();
      return false;
      paramString1.xX(0);
    }
  }
  
  public final boolean bHq()
  {
    return true;
  }
  
  public final View bHr()
  {
    return null;
  }
  
  public final boolean bHs()
  {
    return false;
  }
  
  public final boolean d(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bd
 * JD-Core Version:    0.7.0.1
 */