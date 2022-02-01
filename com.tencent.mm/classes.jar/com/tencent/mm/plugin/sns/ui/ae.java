package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ln;
import com.tencent.mm.model.w;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.k.h;
import com.tencent.mm.plugin.sns.k.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.az;
import com.tencent.mm.plugin.sns.model.ba;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bmn;
import com.tencent.mm.protocal.protobuf.cwk;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.b.d.i;

public final class ae
  implements ab
{
  private String appName;
  String dlB;
  MMActivity imP;
  private c jBI;
  boolean kQm;
  String mediaId;
  private View pf;
  private TextView titleTv;
  private int wLo;
  private int xlZ;
  private CdnImageView xma;
  private TextView xmb;
  private d xmf;
  private String xmg;
  private boolean xnv;
  private boolean xnw;
  WXMediaMessage xnx;
  ImageView xoG;
  private Bitmap xoH;
  
  public ae(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(97981);
    this.xnx = null;
    this.xma = null;
    this.titleTv = null;
    this.xmb = null;
    this.dlB = "";
    this.appName = "";
    this.xnv = false;
    this.xnw = false;
    this.kQm = false;
    this.xmf = null;
    this.wLo = 1;
    this.xmg = "";
    this.jBI = new c() {};
    this.imP = paramMMActivity;
    com.tencent.mm.sdk.b.a.ESL.c(this.jBI);
    AppMethodBeat.o(97981);
  }
  
  public final boolean a(int paramInt1, int paramInt2, i parami, String paramString1, List<String> paramList1, bmn parambmn, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(97985);
    af.dtq();
    paramString1 = az.b(this.xnx, paramString1, this.dlB, this.appName);
    if (paramString1 == null)
    {
      ad.e("MicroMsg.MusicWidget", "packHelper == null, %s, %s", new Object[] { this.dlB, this.appName });
      AppMethodBeat.o(97985);
      return false;
    }
    paramPInt.value = paramString1.aTB;
    if (paramInt3 > com.tencent.mm.plugin.sns.d.a.wzN) {
      paramString1.Ms(4);
    }
    paramString1.Mw(this.xlZ);
    if (this.xnv) {
      paramString1.Mw(5);
    }
    paramLinkedList = new LinkedList();
    if (paramList1 != null)
    {
      new LinkedList();
      paramPInt = w.arx();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramString2 = (String)paramList1.next();
        if (!paramPInt.contains(paramString2))
        {
          cwk localcwk = new cwk();
          localcwk.mAQ = paramString2;
          paramLinkedList.add(localcwk);
        }
      }
    }
    paramString1.aM(paramLinkedList);
    if (parami != null) {
      paramString1.iI(parami.token, parami.DNx);
    }
    paramString1.a(parambmn);
    if (paramBoolean) {
      paramString1.Mx(1);
    }
    for (;;)
    {
      paramString1.fq(paramList2).Mu(paramInt1);
      paramString1.g(null, null, null, paramInt4, paramInt5);
      paramString1.bR(this.wLo, this.xmg);
      if ((this.xnw) && (this.xnx != null))
      {
        paramString1.aoT(this.xnx.mediaTagName);
        paramString1.au(this.dlB, this.xnx.messageExt, this.xnx.messageAction);
      }
      paramInt1 = paramString1.commit();
      if (this.xmf != null)
      {
        this.xmf.oG(paramInt1);
        h.wRM.c(this.xmf);
      }
      af.dtq().drS();
      this.imP.finish();
      AppMethodBeat.o(97985);
      return false;
      paramString1.Mx(0);
    }
  }
  
  public final void af(Bundle paramBundle)
  {
    AppMethodBeat.i(97982);
    this.xnx = new SendMessageToWX.Req(this.imP.getIntent().getBundleExtra("Ksnsupload_timeline")).message;
    this.mediaId = this.imP.getIntent().getStringExtra("Ksnsupload_musicid");
    this.xmf = d.w(this.imP.getIntent());
    this.dlB = bt.by(this.imP.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = bt.by(this.imP.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.xnv = this.imP.getIntent().getBooleanExtra("KThrid_app", false);
    this.xnw = this.imP.getIntent().getBooleanExtra("KSnsAction", false);
    this.xlZ = this.imP.getIntent().getIntExtra("Ksnsupload_source", 0);
    if (this.imP.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {}
    for (this.wLo = 1;; this.wLo = 0)
    {
      this.xmg = bt.by(this.imP.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
      AppMethodBeat.o(97982);
      return;
    }
  }
  
  public final void ag(Bundle paramBundle) {}
  
  public final boolean dyU()
  {
    return true;
  }
  
  public final View dyV()
  {
    AppMethodBeat.i(97984);
    this.pf = y.js(this.imP).inflate(2131495817, null);
    this.xma = ((CdnImageView)this.pf.findViewById(2131300948));
    this.titleTv = ((TextView)this.pf.findViewById(2131305950));
    this.xmb = ((TextView)this.pf.findViewById(2131304202));
    this.pf.findViewById(2131305185).setVisibility(8);
    this.titleTv.setText(this.xnx.title);
    if (this.xnx.thumbData != null) {
      this.xoH = com.tencent.mm.sdk.platformtools.f.cl(this.xnx.thumbData);
    }
    this.xma.setImageBitmap(this.xoH);
    if (!bt.isNullOrNil(this.xnx.description))
    {
      this.xmb.setText(this.xnx.description);
      this.xmb.setVisibility(0);
      this.xoG = ((ImageView)this.pf.findViewById(2131305185));
      this.xoG.setVisibility(0);
      if ((!com.tencent.mm.az.a.azF()) || (!this.kQm)) {
        break label273;
      }
      this.xoG.setImageResource(2131233393);
    }
    for (;;)
    {
      this.xoG.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(97980);
          if (com.tencent.mm.az.a.azF())
          {
            ae.this.dzq();
            AppMethodBeat.o(97980);
            return;
          }
          paramAnonymousView = ae.this;
          if (paramAnonymousView.xnx == null)
          {
            ad.w("MicroMsg.MusicWidget", "doBeingPlayMusic: but item is null");
            AppMethodBeat.o(97980);
            return;
          }
          new ap(paramAnonymousView.imP.getMainLooper()).post(new ae.3(paramAnonymousView));
          AppMethodBeat.o(97980);
        }
      });
      q.b(this.xma, this.imP);
      View localView = this.pf;
      AppMethodBeat.o(97984);
      return localView;
      this.xmb.setVisibility(8);
      break;
      label273:
      this.xoG.setImageResource(2131233395);
    }
  }
  
  public final boolean dyW()
  {
    AppMethodBeat.i(97986);
    if ((this.xoH != null) && (!this.xoH.isRecycled())) {
      this.xoH.recycle();
    }
    com.tencent.mm.sdk.b.a.ESL.d(this.jBI);
    if ((com.tencent.mm.az.a.azF()) && (this.kQm)) {
      dzq();
    }
    boolean bool = com.tencent.mm.az.a.azF();
    AppMethodBeat.o(97986);
    return bool;
  }
  
  final void dzq()
  {
    AppMethodBeat.i(97983);
    new ap(this.imP.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97978);
        com.tencent.mm.az.a.azD();
        ae.this.kQm = false;
        AppMethodBeat.o(97978);
      }
    });
    AppMethodBeat.o(97983);
  }
  
  public final boolean j(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ae
 * JD-Core Version:    0.7.0.1
 */