package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.s;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.h.f;
import com.tencent.mm.plugin.sns.h.h;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.aui;
import com.tencent.mm.protocal.c.buw;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ab
  implements y
{
  private String appName = "";
  MMActivity bER;
  String bOL = "";
  String bUi;
  private TextView eXr = null;
  private com.tencent.mm.sdk.b.c giK = new ab.1(this);
  private View hNa;
  boolean isPlaying = false;
  private int oOs;
  private CdnImageView oOt = null;
  private TextView oOu = null;
  private b oOy = null;
  private boolean oPR = false;
  private boolean oPS = false;
  WXMediaMessage oPT = null;
  ImageView oQG;
  private Bitmap oQH;
  
  public ab(MMActivity paramMMActivity)
  {
    this.bER = paramMMActivity;
    com.tencent.mm.sdk.b.a.udP.c(this.giK);
  }
  
  public final void E(Bundle paramBundle)
  {
    this.oPT = new SendMessageToWX.Req(this.bER.getIntent().getBundleExtra("Ksnsupload_timeline")).message;
    this.bUi = this.bER.getIntent().getStringExtra("Ksnsupload_musicid");
    this.oOy = b.i(this.bER.getIntent());
    this.bOL = bk.aM(this.bER.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = bk.aM(this.bER.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.oPR = this.bER.getIntent().getBooleanExtra("KThrid_app", false);
    this.oPS = this.bER.getIntent().getBooleanExtra("KSnsAction", false);
    this.oOs = this.bER.getIntent().getIntExtra("Ksnsupload_source", 0);
  }
  
  public final void F(Bundle paramBundle) {}
  
  public final boolean a(int paramInt1, int paramInt2, org.c.d.i parami, String paramString1, List<String> paramList1, aui paramaui, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    af.bDB();
    paramString1 = aw.b(this.oPT, paramString1, this.bOL, this.appName);
    if (paramString1 == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MusicWidget", "packHelper == null, %s, %s", new Object[] { this.bOL, this.appName });
      return false;
    }
    paramPInt.value = paramString1.avS;
    if (paramInt3 > com.tencent.mm.plugin.sns.c.a.omJ) {
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
  
  final void bHG()
  {
    new ah(this.bER.getMainLooper()).post(new ab.2(this));
  }
  
  public final boolean bHq()
  {
    return true;
  }
  
  public final View bHr()
  {
    this.hNa = com.tencent.mm.ui.y.gt(this.bER).inflate(i.g.upload_media_music, null);
    this.oOt = ((CdnImageView)this.hNa.findViewById(i.f.image_left));
    this.eXr = ((TextView)this.hNa.findViewById(i.f.titletext));
    this.oOu = ((TextView)this.hNa.findViewById(i.f.righttext));
    this.hNa.findViewById(i.f.state).setVisibility(8);
    this.eXr.setText(this.oPT.title);
    if (this.oPT.thumbData != null) {
      this.oQH = com.tencent.mm.sdk.platformtools.c.bu(this.oPT.thumbData);
    }
    this.oOt.setImageBitmap(this.oQH);
    if (!bk.bl(this.oPT.description))
    {
      this.oOu.setText(this.oPT.description);
      this.oOu.setVisibility(0);
      this.oQG = ((ImageView)this.hNa.findViewById(i.f.state));
      this.oQG.setVisibility(0);
      if ((!com.tencent.mm.av.a.Pu()) || (!this.isPlaying)) {
        break label259;
      }
      this.oQG.setImageResource(i.e.music_pauseicon);
    }
    for (;;)
    {
      this.oQG.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          if (com.tencent.mm.av.a.Pu())
          {
            ab.this.bHG();
            return;
          }
          paramAnonymousView = ab.this;
          if (paramAnonymousView.oPT == null)
          {
            com.tencent.mm.sdk.platformtools.y.w("MicroMsg.MusicWidget", "doBeingPlayMusic: but item is null");
            return;
          }
          new ah(paramAnonymousView.bER.getMainLooper()).post(new ab.3(paramAnonymousView));
        }
      });
      com.tencent.mm.plugin.sns.data.i.b(this.oOt, this.bER);
      return this.hNa;
      this.oOu.setVisibility(8);
      break;
      label259:
      this.oQG.setImageResource(i.e.music_playicon);
    }
  }
  
  public final boolean bHs()
  {
    if ((this.oQH != null) && (!this.oQH.isRecycled())) {
      this.oQH.recycle();
    }
    com.tencent.mm.sdk.b.a.udP.d(this.giK);
    if ((com.tencent.mm.av.a.Pu()) && (this.isPlaying)) {
      bHG();
    }
    return com.tencent.mm.av.a.Pu();
  }
  
  public final boolean d(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ab
 * JD-Core Version:    0.7.0.1
 */