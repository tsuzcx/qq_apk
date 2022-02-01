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
import com.tencent.mm.ay.f;
import com.tencent.mm.g.a.mg;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.modelsns.e;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.j.g;
import com.tencent.mm.plugin.sns.model.bc;
import com.tencent.mm.plugin.sns.model.bd;
import com.tencent.mm.pluginsdk.i.d;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bwk;
import com.tencent.mm.protocal.protobuf.did;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ah
  implements ac
{
  private int Ahk;
  private CdnImageView Ahl;
  private TextView Ahm;
  private e Ahq;
  private String Ahr;
  private boolean AiJ;
  private boolean AiK;
  WXMediaMessage AiL;
  ImageView AjY;
  private Bitmap AjZ;
  private String appName;
  String dwb;
  MMActivity fNT;
  private c kzS;
  boolean lVw;
  String mediaId;
  private View rY;
  private TextView titleTv;
  private int zFi;
  
  public ah(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(97981);
    this.AiL = null;
    this.Ahl = null;
    this.titleTv = null;
    this.Ahm = null;
    this.dwb = "";
    this.appName = "";
    this.AiJ = false;
    this.AiK = false;
    this.lVw = false;
    this.Ahq = null;
    this.zFi = 1;
    this.Ahr = "";
    this.kzS = new c() {};
    this.fNT = paramMMActivity;
    com.tencent.mm.sdk.b.a.IvT.c(this.kzS);
    AppMethodBeat.o(97981);
  }
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, bwk parambwk, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(97985);
    com.tencent.mm.plugin.sns.model.ah.dXA();
    paramString1 = bc.b(this.AiL, paramString1, this.dwb, this.appName);
    if (paramString1 == null)
    {
      ae.e("MicroMsg.MusicWidget", "packHelper == null, %s, %s", new Object[] { this.dwb, this.appName });
      AppMethodBeat.o(97985);
      return false;
    }
    paramPInt.value = paramString1.beN;
    if (paramInt3 > com.tencent.mm.plugin.sns.c.a.zsC) {
      paramString1.QI(4);
    }
    paramString1.QN(this.Ahk);
    if (this.AiJ) {
      paramString1.QN(5);
    }
    paramLinkedList = new LinkedList();
    if (paramList1 != null)
    {
      new LinkedList();
      paramPInt = d.feg();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramString2 = (String)paramList1.next();
        if (!paramPInt.contains(paramString2))
        {
          did localdid = new did();
          localdid.nIJ = paramString2;
          paramLinkedList.add(localdid);
        }
      }
    }
    paramString1.aV(paramLinkedList);
    if (parami != null) {
      paramString1.jy(parami.token, parami.HmQ);
    }
    paramString1.a(parambwk);
    if (paramBoolean) {
      paramString1.QO(1);
    }
    for (;;)
    {
      paramString1.fU(paramList2).QL(paramInt1);
      paramString1.g(null, null, null, paramInt4, paramInt5);
      paramString1.cc(this.zFi, this.Ahr);
      if ((this.AiK) && (this.AiL != null))
      {
        paramString1.aAB(this.AiL.mediaTagName);
        paramString1.aD(this.dwb, this.AiL.messageExt, this.AiL.messageAction);
      }
      paramInt1 = paramString1.commit();
      if (this.Ahq != null)
      {
        this.Ahq.qa(paramInt1);
        g.zLJ.c(this.Ahq);
      }
      com.tencent.mm.plugin.sns.model.ah.dXA().dWc();
      this.fNT.finish();
      AppMethodBeat.o(97985);
      return false;
      paramString1.QO(0);
    }
  }
  
  public final void aq(Bundle paramBundle)
  {
    AppMethodBeat.i(97982);
    this.AiL = new SendMessageToWX.Req(this.fNT.getIntent().getBundleExtra("Ksnsupload_timeline")).message;
    this.mediaId = this.fNT.getIntent().getStringExtra("Ksnsupload_musicid");
    this.Ahq = e.w(this.fNT.getIntent());
    this.dwb = bu.bI(this.fNT.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = bu.bI(this.fNT.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.AiJ = this.fNT.getIntent().getBooleanExtra("KThrid_app", false);
    this.AiK = this.fNT.getIntent().getBooleanExtra("KSnsAction", false);
    this.Ahk = this.fNT.getIntent().getIntExtra("Ksnsupload_source", 0);
    if (this.fNT.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {}
    for (this.zFi = 1;; this.zFi = 0)
    {
      this.Ahr = bu.bI(this.fNT.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
      AppMethodBeat.o(97982);
      return;
    }
  }
  
  public final void ar(Bundle paramBundle) {}
  
  final void edG()
  {
    AppMethodBeat.i(97983);
    new aq(this.fNT.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97978);
        com.tencent.mm.ay.a.aJX();
        ah.this.lVw = false;
        AppMethodBeat.o(97978);
      }
    });
    AppMethodBeat.o(97983);
  }
  
  public final boolean edl()
  {
    return true;
  }
  
  public final View edm()
  {
    AppMethodBeat.i(97984);
    this.rY = z.jV(this.fNT).inflate(2131495817, null);
    this.Ahl = ((CdnImageView)this.rY.findViewById(2131300948));
    this.titleTv = ((TextView)this.rY.findViewById(2131305950));
    this.Ahm = ((TextView)this.rY.findViewById(2131304202));
    this.rY.findViewById(2131305185).setVisibility(8);
    this.titleTv.setText(this.AiL.title);
    if (this.AiL.thumbData != null) {
      this.AjZ = h.cu(this.AiL.thumbData);
    }
    this.Ahl.setImageBitmap(this.AjZ);
    if (!bu.isNullOrNil(this.AiL.description))
    {
      this.Ahm.setText(this.AiL.description);
      this.Ahm.setVisibility(0);
      this.AjY = ((ImageView)this.rY.findViewById(2131305185));
      this.AjY.setVisibility(0);
      if ((!com.tencent.mm.ay.a.aJZ()) || (!this.lVw)) {
        break label273;
      }
      this.AjY.setImageResource(2131233393);
    }
    for (;;)
    {
      this.AjY.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(97980);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/MusicWidget$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (com.tencent.mm.ay.a.aJZ()) {
            ah.this.edG();
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/MusicWidget$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(97980);
            return;
            paramAnonymousView = ah.this;
            if (paramAnonymousView.AiL == null) {
              ae.w("MicroMsg.MusicWidget", "doBeingPlayMusic: but item is null");
            } else {
              new aq(paramAnonymousView.fNT.getMainLooper()).post(new ah.3(paramAnonymousView));
            }
          }
        }
      });
      r.b(this.Ahl, this.fNT);
      View localView = this.rY;
      AppMethodBeat.o(97984);
      return localView;
      this.Ahm.setVisibility(8);
      break;
      label273:
      this.AjY.setImageResource(2131233395);
    }
  }
  
  public final boolean edn()
  {
    return true;
  }
  
  public final boolean edo()
  {
    AppMethodBeat.i(97986);
    if ((this.AjZ != null) && (!this.AjZ.isRecycled())) {
      this.AjZ.recycle();
    }
    com.tencent.mm.sdk.b.a.IvT.d(this.kzS);
    if ((com.tencent.mm.ay.a.aJZ()) && (this.lVw)) {
      edG();
    }
    boolean bool = com.tencent.mm.ay.a.aJZ();
    AppMethodBeat.o(97986);
    return bool;
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