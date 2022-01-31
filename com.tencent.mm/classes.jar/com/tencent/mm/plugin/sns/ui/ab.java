package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.t;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.plugin.sns.model.ay;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bap;
import com.tencent.mm.protocal.protobuf.cfm;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.w;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ab
  implements y
{
  private String appName;
  String cBO;
  MMActivity cmc;
  String cwc;
  private c hCe;
  boolean isPlaying;
  private View jIo;
  private int rGd;
  private CdnImageView rGe;
  private TextView rGf;
  private b rGj;
  private boolean rHD;
  private boolean rHE;
  WXMediaMessage rHF;
  ImageView rIs;
  private Bitmap rIt;
  private TextView titleTv;
  
  public ab(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(38329);
    this.rHF = null;
    this.rGe = null;
    this.titleTv = null;
    this.rGf = null;
    this.cwc = "";
    this.appName = "";
    this.rHD = false;
    this.rHE = false;
    this.isPlaying = false;
    this.rGj = null;
    this.hCe = new ab.1(this);
    this.cmc = paramMMActivity;
    com.tencent.mm.sdk.b.a.ymk.c(this.hCe);
    AppMethodBeat.o(38329);
  }
  
  public final void V(Bundle paramBundle)
  {
    AppMethodBeat.i(38330);
    this.rHF = new SendMessageToWX.Req(this.cmc.getIntent().getBundleExtra("Ksnsupload_timeline")).message;
    this.cBO = this.cmc.getIntent().getStringExtra("Ksnsupload_musicid");
    this.rGj = b.w(this.cmc.getIntent());
    this.cwc = bo.bf(this.cmc.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = bo.bf(this.cmc.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.rHD = this.cmc.getIntent().getBooleanExtra("KThrid_app", false);
    this.rHE = this.cmc.getIntent().getBooleanExtra("KSnsAction", false);
    this.rGd = this.cmc.getIntent().getIntExtra("Ksnsupload_source", 0);
    AppMethodBeat.o(38330);
  }
  
  public final void W(Bundle paramBundle) {}
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, bap parambap, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(38333);
    ag.cpb();
    paramString1 = ax.b(this.rHF, paramString1, this.cwc, this.appName);
    if (paramString1 == null)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.MusicWidget", "packHelper == null, %s, %s", new Object[] { this.cwc, this.appName });
      AppMethodBeat.o(38333);
      return false;
    }
    paramPInt.value = paramString1.ayi;
    if (paramInt3 > com.tencent.mm.plugin.sns.c.a.raX) {
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
      AppMethodBeat.o(38333);
      return false;
      paramString1.DX(0);
    }
  }
  
  final void ctM()
  {
    AppMethodBeat.i(38331);
    new ak(this.cmc.getMainLooper()).post(new ab.2(this));
    AppMethodBeat.o(38331);
  }
  
  public final boolean ctu()
  {
    return true;
  }
  
  public final View ctv()
  {
    AppMethodBeat.i(38332);
    this.jIo = w.hM(this.cmc).inflate(2130971052, null);
    this.rGe = ((CdnImageView)this.jIo.findViewById(2131825855));
    this.titleTv = ((TextView)this.jIo.findViewById(2131825857));
    this.rGf = ((TextView)this.jIo.findViewById(2131825858));
    this.jIo.findViewById(2131824765).setVisibility(8);
    this.titleTv.setText(this.rHF.title);
    if (this.rHF.thumbData != null) {
      this.rIt = d.bT(this.rHF.thumbData);
    }
    this.rGe.setImageBitmap(this.rIt);
    if (!bo.isNullOrNil(this.rHF.description))
    {
      this.rGf.setText(this.rHF.description);
      this.rGf.setVisibility(0);
      this.rIs = ((ImageView)this.jIo.findViewById(2131824765));
      this.rIs.setVisibility(0);
      if ((!com.tencent.mm.aw.a.aiw()) || (!this.isPlaying)) {
        break label273;
      }
      this.rIs.setImageResource(2130839751);
    }
    for (;;)
    {
      this.rIs.setOnClickListener(new ab.4(this));
      com.tencent.mm.plugin.sns.data.i.b(this.rGe, this.cmc);
      View localView = this.jIo;
      AppMethodBeat.o(38332);
      return localView;
      this.rGf.setVisibility(8);
      break;
      label273:
      this.rIs.setImageResource(2130839753);
    }
  }
  
  public final boolean ctw()
  {
    AppMethodBeat.i(38334);
    if ((this.rIt != null) && (!this.rIt.isRecycled())) {
      this.rIt.recycle();
    }
    com.tencent.mm.sdk.b.a.ymk.d(this.hCe);
    if ((com.tencent.mm.aw.a.aiw()) && (this.isPlaying)) {
      ctM();
    }
    boolean bool = com.tencent.mm.aw.a.aiw();
    AppMethodBeat.o(38334);
    return bool;
  }
  
  public final boolean j(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ab
 * JD-Core Version:    0.7.0.1
 */