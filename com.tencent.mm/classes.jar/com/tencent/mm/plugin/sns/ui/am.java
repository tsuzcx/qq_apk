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
import com.tencent.mm.bb.f;
import com.tencent.mm.f.a.np;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.modelsns.l;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.k.k;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.bd;
import com.tencent.mm.plugin.sns.model.be;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.protocal.protobuf.elm;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ad;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class am
  implements af
{
  private int KCP;
  private CdnImageView KCQ;
  private TextView KCR;
  private l KCV;
  private String KCW;
  private boolean KEH;
  private boolean KEI;
  WXMediaMessage KEJ;
  private Bitmap KGi;
  ImageView KGj;
  private int Kcp;
  private String appName;
  String appid;
  private View bvK;
  boolean fGh;
  MMActivity iXq;
  String mediaId;
  private IListener ozM;
  private TextView titleTv;
  
  public am(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(97981);
    this.KEJ = null;
    this.KCQ = null;
    this.titleTv = null;
    this.KCR = null;
    this.appid = "";
    this.appName = "";
    this.KEH = false;
    this.KEI = false;
    this.fGh = false;
    this.KCV = null;
    this.Kcp = 1;
    this.KCW = "";
    this.ozM = new IListener() {};
    this.iXq = paramMMActivity;
    EventCenter.instance.addListener(this.ozM);
    AppMethodBeat.o(97981);
  }
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, cst paramcst, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(97985);
    aj.fOE();
    paramString1 = bd.c(this.KEJ, paramString1, this.appid, this.appName);
    if (paramString1 == null)
    {
      Log.e("MicroMsg.MusicWidget", "packHelper == null, %s, %s", new Object[] { this.appid, this.appName });
      AppMethodBeat.o(97985);
      return false;
    }
    paramPInt.value = paramString1.aOl;
    if (paramInt3 > com.tencent.mm.plugin.sns.c.a.JPj) {
      paramString1.afW(4);
    }
    paramString1.agb(this.KCP);
    if (this.KEH) {
      paramString1.agb(5);
    }
    paramLinkedList = new LinkedList();
    if (paramList1 != null)
    {
      new LinkedList();
      paramPInt = com.tencent.mm.pluginsdk.j.a.hhW();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramString2 = (String)paramList1.next();
        if (!paramPInt.contains(paramString2))
        {
          elm localelm = new elm();
          localelm.UserName = paramString2;
          paramLinkedList.add(localelm);
        }
      }
    }
    paramString1.bL(paramLinkedList);
    if (parami != null) {
      paramString1.kG(parami.token, parami.TEk);
    }
    paramString1.a(paramcst);
    if (paramBoolean) {
      paramString1.agc(1);
    }
    for (;;)
    {
      paramString1.hA(paramList2).afZ(paramInt1);
      paramString1.i(null, null, null, paramInt4, paramInt5);
      paramString1.ct(this.Kcp, this.KCW);
      if ((this.KEI) && (this.KEJ != null))
      {
        paramString1.bat(this.KEJ.mediaTagName);
        paramString1.aI(this.appid, this.KEJ.messageExt, this.KEJ.messageAction);
      }
      paramInt1 = paramString1.in();
      if (this.KCV != null)
      {
        this.KCV.wQ(paramInt1);
        com.tencent.mm.plugin.sns.k.i.Kjb.c(this.KCV);
      }
      aj.fOE().fNd();
      this.iXq.finish();
      AppMethodBeat.o(97985);
      return false;
      paramString1.agc(0);
    }
  }
  
  public final void ay(Bundle paramBundle)
  {
    AppMethodBeat.i(97982);
    this.KEJ = new SendMessageToWX.Req(this.iXq.getIntent().getBundleExtra("Ksnsupload_timeline")).message;
    this.mediaId = this.iXq.getIntent().getStringExtra("Ksnsupload_musicid");
    this.KCV = l.x(this.iXq.getIntent());
    this.appid = Util.nullAs(this.iXq.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = Util.nullAs(this.iXq.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.KEH = this.iXq.getIntent().getBooleanExtra("KThrid_app", false);
    this.KEI = this.iXq.getIntent().getBooleanExtra("KSnsAction", false);
    this.KCP = this.iXq.getIntent().getIntExtra("Ksnsupload_source", 0);
    if (this.iXq.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {}
    for (this.Kcp = 1;; this.Kcp = 0)
    {
      this.KCW = Util.nullAs(this.iXq.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
      AppMethodBeat.o(97982);
      return;
    }
  }
  
  public final void az(Bundle paramBundle) {}
  
  public final boolean fTA()
  {
    AppMethodBeat.i(97986);
    if ((this.KGi != null) && (!this.KGi.isRecycled())) {
      this.KGi.recycle();
    }
    EventCenter.instance.removeListener(this.ozM);
    if ((com.tencent.mm.bb.a.bnx()) && (this.fGh)) {
      fTV();
    }
    boolean bool = com.tencent.mm.bb.a.bnx();
    AppMethodBeat.o(97986);
    return bool;
  }
  
  final void fTV()
  {
    AppMethodBeat.i(97983);
    new MMHandler(this.iXq.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97978);
        com.tencent.mm.bb.a.bnv();
        am.this.fGh = false;
        AppMethodBeat.o(97978);
      }
    });
    AppMethodBeat.o(97983);
  }
  
  public final boolean fTw()
  {
    return true;
  }
  
  public final View fTx()
  {
    AppMethodBeat.i(97984);
    this.bvK = ad.kS(this.iXq).inflate(i.g.upload_media_music, null);
    this.KCQ = ((CdnImageView)this.bvK.findViewById(i.f.image_left));
    this.titleTv = ((TextView)this.bvK.findViewById(i.f.titletext));
    this.KCR = ((TextView)this.bvK.findViewById(i.f.righttext));
    this.bvK.findViewById(i.f.state).setVisibility(8);
    this.titleTv.setText(this.KEJ.title);
    if (this.KEJ.thumbData != null) {
      this.KGi = BitmapUtil.decodeByteArray(this.KEJ.thumbData);
    }
    this.KCQ.setImageBitmap(this.KGi);
    if (!Util.isNullOrNil(this.KEJ.description))
    {
      this.KCR.setText(this.KEJ.description);
      this.KCR.setVisibility(0);
      this.KGj = ((ImageView)this.bvK.findViewById(i.f.state));
      this.KGj.setVisibility(0);
      if ((!com.tencent.mm.bb.a.bnx()) || (!this.fGh)) {
        break label273;
      }
      this.KGj.setImageResource(i.e.music_pauseicon);
    }
    for (;;)
    {
      this.KGj.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(97980);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/MusicWidget$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (com.tencent.mm.bb.a.bnx()) {
            am.this.fTV();
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/MusicWidget$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(97980);
            return;
            paramAnonymousView = am.this;
            if (paramAnonymousView.KEJ == null) {
              Log.w("MicroMsg.MusicWidget", "doBeingPlayMusic: but item is null");
            } else {
              new MMHandler(paramAnonymousView.iXq.getMainLooper()).post(new am.3(paramAnonymousView));
            }
          }
        }
      });
      t.b(this.KCQ, this.iXq);
      View localView = this.bvK;
      AppMethodBeat.o(97984);
      return localView;
      this.KCR.setVisibility(8);
      break;
      label273:
      this.KGj.setImageResource(i.e.music_playicon);
    }
  }
  
  public final boolean fTy()
  {
    return true;
  }
  
  public final boolean fTz()
  {
    return true;
  }
  
  public final boolean k(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.am
 * JD-Core Version:    0.7.0.1
 */