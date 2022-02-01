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
import com.tencent.mm.g.a.mx;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.modelsns.k;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.k.g;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.be;
import com.tencent.mm.plugin.sns.model.bf;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.cjy;
import com.tencent.mm.protocal.protobuf.ebm;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ak
  implements ad
{
  private int DPi;
  private int EpG;
  private CdnImageView EpH;
  private TextView EpI;
  private k EpM;
  private String EpN;
  private boolean Ero;
  private boolean Erp;
  WXMediaMessage Erq;
  private Bitmap EsL;
  ImageView EsM;
  private String appName;
  String dNI;
  boolean gVd;
  MMActivity gte;
  private IListener lEl;
  String mediaId;
  private View sc;
  private TextView titleTv;
  
  public ak(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(97981);
    this.Erq = null;
    this.EpH = null;
    this.titleTv = null;
    this.EpI = null;
    this.dNI = "";
    this.appName = "";
    this.Ero = false;
    this.Erp = false;
    this.gVd = false;
    this.EpM = null;
    this.DPi = 1;
    this.EpN = "";
    this.lEl = new IListener() {};
    this.gte = paramMMActivity;
    EventCenter.instance.addListener(this.lEl);
    AppMethodBeat.o(97981);
  }
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, cjy paramcjy, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(97985);
    aj.faK();
    paramString1 = be.c(this.Erq, paramString1, this.dNI, this.appName);
    if (paramString1 == null)
    {
      Log.e("MicroMsg.MusicWidget", "packHelper == null, %s, %s", new Object[] { this.dNI, this.appName });
      AppMethodBeat.o(97985);
      return false;
    }
    paramPInt.value = paramString1.beK;
    if (paramInt3 > com.tencent.mm.plugin.sns.c.a.DCT) {
      paramString1.YF(4);
    }
    paramString1.YK(this.EpG);
    if (this.Ero) {
      paramString1.YK(5);
    }
    paramLinkedList = new LinkedList();
    if (paramList1 != null)
    {
      new LinkedList();
      paramPInt = com.tencent.mm.pluginsdk.i.a.gnq();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramString2 = (String)paramList1.next();
        if (!paramPInt.contains(paramString2))
        {
          ebm localebm = new ebm();
          localebm.UserName = paramString2;
          paramLinkedList.add(localebm);
        }
      }
    }
    paramString1.bq(paramLinkedList);
    if (parami != null) {
      paramString1.kl(parami.token, parami.Mte);
    }
    paramString1.a(paramcjy);
    if (paramBoolean) {
      paramString1.YL(1);
    }
    for (;;)
    {
      paramString1.gR(paramList2).YI(paramInt1);
      paramString1.g(null, null, null, paramInt4, paramInt5);
      paramString1.ct(this.DPi, this.EpN);
      if ((this.Erp) && (this.Erq != null))
      {
        paramString1.aPx(this.Erq.mediaTagName);
        paramString1.aO(this.dNI, this.Erq.messageExt, this.Erq.messageAction);
      }
      paramInt1 = paramString1.commit();
      if (this.EpM != null)
      {
        this.EpM.tQ(paramInt1);
        g.DVR.c(this.EpM);
      }
      aj.faK().eZn();
      this.gte.finish();
      AppMethodBeat.o(97985);
      return false;
      paramString1.YL(0);
    }
  }
  
  public final void aC(Bundle paramBundle)
  {
    AppMethodBeat.i(97982);
    this.Erq = new SendMessageToWX.Req(this.gte.getIntent().getBundleExtra("Ksnsupload_timeline")).message;
    this.mediaId = this.gte.getIntent().getStringExtra("Ksnsupload_musicid");
    this.EpM = k.w(this.gte.getIntent());
    this.dNI = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.Ero = this.gte.getIntent().getBooleanExtra("KThrid_app", false);
    this.Erp = this.gte.getIntent().getBooleanExtra("KSnsAction", false);
    this.EpG = this.gte.getIntent().getIntExtra("Ksnsupload_source", 0);
    if (this.gte.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {}
    for (this.DPi = 1;; this.DPi = 0)
    {
      this.EpN = Util.nullAs(this.gte.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
      AppMethodBeat.o(97982);
      return;
    }
  }
  
  public final void aD(Bundle paramBundle) {}
  
  public final boolean ffA()
  {
    return true;
  }
  
  public final View ffB()
  {
    AppMethodBeat.i(97984);
    this.sc = aa.jQ(this.gte).inflate(2131496779, null);
    this.EpH = ((CdnImageView)this.sc.findViewById(2131302578));
    this.titleTv = ((TextView)this.sc.findViewById(2131309253));
    this.EpI = ((TextView)this.sc.findViewById(2131307116));
    this.sc.findViewById(2131308376).setVisibility(8);
    this.titleTv.setText(this.Erq.title);
    if (this.Erq.thumbData != null) {
      this.EsL = BitmapUtil.decodeByteArray(this.Erq.thumbData);
    }
    this.EpH.setImageBitmap(this.EsL);
    if (!Util.isNullOrNil(this.Erq.description))
    {
      this.EpI.setText(this.Erq.description);
      this.EpI.setVisibility(0);
      this.EsM = ((ImageView)this.sc.findViewById(2131308376));
      this.EsM.setVisibility(0);
      if ((!com.tencent.mm.ay.a.bec()) || (!this.gVd)) {
        break label273;
      }
      this.EsM.setImageResource(2131234170);
    }
    for (;;)
    {
      this.EsM.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(97980);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/MusicWidget$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (com.tencent.mm.ay.a.bec()) {
            ak.this.ffY();
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/MusicWidget$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(97980);
            return;
            paramAnonymousView = ak.this;
            if (paramAnonymousView.Erq == null) {
              Log.w("MicroMsg.MusicWidget", "doBeingPlayMusic: but item is null");
            } else {
              new MMHandler(paramAnonymousView.gte.getMainLooper()).post(new ak.3(paramAnonymousView));
            }
          }
        }
      });
      r.b(this.EpH, this.gte);
      View localView = this.sc;
      AppMethodBeat.o(97984);
      return localView;
      this.EpI.setVisibility(8);
      break;
      label273:
      this.EsM.setImageResource(2131234185);
    }
  }
  
  public final boolean ffC()
  {
    return true;
  }
  
  public final boolean ffD()
  {
    return true;
  }
  
  public final boolean ffE()
  {
    AppMethodBeat.i(97986);
    if ((this.EsL != null) && (!this.EsL.isRecycled())) {
      this.EsL.recycle();
    }
    EventCenter.instance.removeListener(this.lEl);
    if ((com.tencent.mm.ay.a.bec()) && (this.gVd)) {
      ffY();
    }
    boolean bool = com.tencent.mm.ay.a.bec();
    AppMethodBeat.o(97986);
    return bool;
  }
  
  final void ffY()
  {
    AppMethodBeat.i(97983);
    new MMHandler(this.gte.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97978);
        com.tencent.mm.ay.a.bea();
        ak.this.gVd = false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ak
 * JD-Core Version:    0.7.0.1
 */