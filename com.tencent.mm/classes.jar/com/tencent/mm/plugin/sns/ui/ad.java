package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.model.s;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
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

public final class ad
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
  private boolean oRi = false;
  
  public ad(MMActivity paramMMActivity, boolean paramBoolean)
  {
    this.bER = paramMMActivity;
    this.oRi = paramBoolean;
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
    paramBundle = this.bER.getIntent().getBundleExtra("Ksnsupload_timeline");
    if (paramBundle != null) {
      this.oPT = new SendMessageToWX.Req(paramBundle).message;
    }
  }
  
  public final void F(Bundle paramBundle) {}
  
  public final boolean a(int paramInt1, int paramInt2, i parami, String paramString1, List<String> paramList1, aui paramaui, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    if (this.bER.isFinishing()) {
      return false;
    }
    paramString2 = new ax(2);
    paramPInt.value = paramString2.avS;
    if (paramInt3 > a.omJ) {
      paramString2.xS(2);
    }
    paramPInt = new LinkedList();
    if (paramList1 != null)
    {
      new LinkedList();
      List localList = s.Ha();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        String str = (String)paramList1.next();
        if (!localList.contains(str))
        {
          buw localbuw = new buw();
          localbuw.hPY = str;
          paramPInt.add(localbuw);
        }
      }
    }
    if (paramBoolean) {
      paramString2.xX(1);
    }
    for (;;)
    {
      if (parami != null) {
        paramString2.eM(parami.token, parami.tsv);
      }
      paramString2.xW(this.oOs);
      if (this.oPR) {
        paramString2.xW(5);
      }
      if ((this.oPS) && (this.oPT != null))
      {
        paramString2.NS(this.oPT.mediaTagName);
        paramString2.Y(this.bOL, this.oPT.messageExt, this.oPT.messageAction);
      }
      paramString2.f(null, null, null, paramInt4, paramInt5);
      paramString2.NR(paramString1).a(paramaui).am(paramPInt).xU(paramInt1).xV(paramInt2).cx(paramList2);
      paramInt1 = paramString2.commit();
      if (this.oOy != null)
      {
        this.oOy.jf(paramInt1);
        f.ozP.c(this.oOy);
      }
      this.bER.setResult(-1);
      af.bDB().bCp();
      this.bER.finish();
      return true;
      paramString2.xX(0);
    }
  }
  
  public final boolean bHq()
  {
    return this.oRi;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ad
 * JD-Core Version:    0.7.0.1
 */