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
import com.tencent.mm.az.f;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.modelsns.e;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.bb;
import com.tencent.mm.plugin.sns.model.bc;
import com.tencent.mm.pluginsdk.i.d;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bvq;
import com.tencent.mm.protocal.protobuf.dhj;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ah
  implements ac
{
  private String appName;
  String duW;
  MMActivity fLP;
  private c kwD;
  boolean lQV;
  String mediaId;
  private View rY;
  private TextView titleTv;
  private int zQd;
  private CdnImageView zQe;
  private TextView zQf;
  private e zQj;
  private String zQk;
  private boolean zRC;
  private boolean zRD;
  WXMediaMessage zRE;
  ImageView zSR;
  private Bitmap zSS;
  private int znT;
  
  public ah(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(97981);
    this.zRE = null;
    this.zQe = null;
    this.titleTv = null;
    this.zQf = null;
    this.duW = "";
    this.appName = "";
    this.zRC = false;
    this.zRD = false;
    this.lQV = false;
    this.zQj = null;
    this.znT = 1;
    this.zQk = "";
    this.kwD = new ah.1(this);
    this.fLP = paramMMActivity;
    com.tencent.mm.sdk.b.a.IbL.c(this.kwD);
    AppMethodBeat.o(97981);
  }
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, bvq parambvq, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(97985);
    ag.dUa();
    paramString1 = bb.b(this.zRE, paramString1, this.duW, this.appName);
    if (paramString1 == null)
    {
      ad.e("MicroMsg.MusicWidget", "packHelper == null, %s, %s", new Object[] { this.duW, this.appName });
      AppMethodBeat.o(97985);
      return false;
    }
    paramPInt.value = paramString1.beN;
    if (paramInt3 > com.tencent.mm.plugin.sns.c.a.zbZ) {
      paramString1.Qb(4);
    }
    paramString1.Qg(this.zQd);
    if (this.zRC) {
      paramString1.Qg(5);
    }
    paramLinkedList = new LinkedList();
    if (paramList1 != null)
    {
      new LinkedList();
      paramPInt = d.fas();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramString2 = (String)paramList1.next();
        if (!paramPInt.contains(paramString2))
        {
          dhj localdhj = new dhj();
          localdhj.nDo = paramString2;
          paramLinkedList.add(localdhj);
        }
      }
    }
    paramString1.aU(paramLinkedList);
    if (parami != null) {
      paramString1.jr(parami.token, parami.GTp);
    }
    paramString1.a(parambvq);
    if (paramBoolean) {
      paramString1.Qh(1);
    }
    for (;;)
    {
      paramString1.fL(paramList2).Qe(paramInt1);
      paramString1.g(null, null, null, paramInt4, paramInt5);
      paramString1.cc(this.znT, this.zQk);
      if ((this.zRD) && (this.zRE != null))
      {
        paramString1.azk(this.zRE.mediaTagName);
        paramString1.aD(this.duW, this.zRE.messageExt, this.zRE.messageAction);
      }
      paramInt1 = paramString1.commit();
      if (this.zQj != null)
      {
        this.zQj.pX(paramInt1);
        com.tencent.mm.plugin.sns.j.g.zus.c(this.zQj);
      }
      ag.dUa().dSE();
      this.fLP.finish();
      AppMethodBeat.o(97985);
      return false;
      paramString1.Qh(0);
    }
  }
  
  public final void ap(Bundle paramBundle)
  {
    AppMethodBeat.i(97982);
    this.zRE = new SendMessageToWX.Req(this.fLP.getIntent().getBundleExtra("Ksnsupload_timeline")).message;
    this.mediaId = this.fLP.getIntent().getStringExtra("Ksnsupload_musicid");
    this.zQj = e.w(this.fLP.getIntent());
    this.duW = bt.bI(this.fLP.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = bt.bI(this.fLP.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.zRC = this.fLP.getIntent().getBooleanExtra("KThrid_app", false);
    this.zRD = this.fLP.getIntent().getBooleanExtra("KSnsAction", false);
    this.zQd = this.fLP.getIntent().getIntExtra("Ksnsupload_source", 0);
    if (this.fLP.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {}
    for (this.znT = 1;; this.znT = 0)
    {
      this.zQk = bt.bI(this.fLP.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
      AppMethodBeat.o(97982);
      return;
    }
  }
  
  public final void aq(Bundle paramBundle) {}
  
  public final boolean dZG()
  {
    return true;
  }
  
  public final View dZH()
  {
    AppMethodBeat.i(97984);
    this.rY = z.jO(this.fLP).inflate(2131495817, null);
    this.zQe = ((CdnImageView)this.rY.findViewById(2131300948));
    this.titleTv = ((TextView)this.rY.findViewById(2131305950));
    this.zQf = ((TextView)this.rY.findViewById(2131304202));
    this.rY.findViewById(2131305185).setVisibility(8);
    this.titleTv.setText(this.zRE.title);
    if (this.zRE.thumbData != null) {
      this.zSS = com.tencent.mm.sdk.platformtools.g.cr(this.zRE.thumbData);
    }
    this.zQe.setImageBitmap(this.zSS);
    if (!bt.isNullOrNil(this.zRE.description))
    {
      this.zQf.setText(this.zRE.description);
      this.zQf.setVisibility(0);
      this.zSR = ((ImageView)this.rY.findViewById(2131305185));
      this.zSR.setVisibility(0);
      if ((!com.tencent.mm.az.a.aJG()) || (!this.lQV)) {
        break label273;
      }
      this.zSR.setImageResource(2131233393);
    }
    for (;;)
    {
      this.zSR.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(97980);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/MusicWidget$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (com.tencent.mm.az.a.aJG()) {
            ah.this.eaa();
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/MusicWidget$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(97980);
            return;
            paramAnonymousView = ah.this;
            if (paramAnonymousView.zRE == null) {
              ad.w("MicroMsg.MusicWidget", "doBeingPlayMusic: but item is null");
            } else {
              new ap(paramAnonymousView.fLP.getMainLooper()).post(new ah.3(paramAnonymousView));
            }
          }
        }
      });
      q.b(this.zQe, this.fLP);
      View localView = this.rY;
      AppMethodBeat.o(97984);
      return localView;
      this.zQf.setVisibility(8);
      break;
      label273:
      this.zSR.setImageResource(2131233395);
    }
  }
  
  public final boolean dZI()
  {
    AppMethodBeat.i(97986);
    if ((this.zSS != null) && (!this.zSS.isRecycled())) {
      this.zSS.recycle();
    }
    com.tencent.mm.sdk.b.a.IbL.d(this.kwD);
    if ((com.tencent.mm.az.a.aJG()) && (this.lQV)) {
      eaa();
    }
    boolean bool = com.tencent.mm.az.a.aJG();
    AppMethodBeat.o(97986);
    return bool;
  }
  
  final void eaa()
  {
    AppMethodBeat.i(97983);
    new ap(this.fLP.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97978);
        com.tencent.mm.az.a.aJE();
        ah.this.lQV = false;
        AppMethodBeat.o(97978);
      }
    });
    AppMethodBeat.o(97983);
  }
  
  public final boolean k(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ah
 * JD-Core Version:    0.7.0.1
 */