package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.modelsns.k;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.k.g;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.be;
import com.tencent.mm.plugin.sns.model.bf;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cjy;
import com.tencent.mm.protocal.protobuf.ebm;
import com.tencent.mm.protocal.protobuf.jo;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ag
  implements ad
{
  private int DPi = 1;
  private byte[] EpE = null;
  private String EpF;
  private int EpG;
  CdnImageView EpH = null;
  private TextView EpI = null;
  private k EpM = null;
  private String EpN = "";
  private boolean Ero = false;
  private boolean Erp = false;
  private WXMediaMessage Erq = null;
  private int Erv = 0;
  private k Erw = null;
  private String EsA;
  jo EsB = null;
  private String appId;
  private String appName;
  private String eag;
  private String eam;
  private final MMActivity gte;
  public String izf = "";
  public String izg = "";
  private String mSessionId;
  private View sc = null;
  private String title = "";
  private TextView titleTv = null;
  private int vjQ = 0;
  
  public ag(MMActivity paramMMActivity)
  {
    this.gte = paramMMActivity;
  }
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, cjy paramcjy, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(203303);
    paramLinkedList = new bf(33, this.gte);
    paramPInt.value = paramLinkedList.beK;
    if (paramInt3 > com.tencent.mm.plugin.sns.c.a.DCT) {
      paramLinkedList.YF(4);
    }
    paramLinkedList.aPB(this.title).aPw(paramString1);
    paramLinkedList.aPz(Util.nullAs(this.gte.getIntent().getStringExtra("ksnsupload_link_desc"), ""));
    if (this.vjQ == 15) {
      paramLinkedList.aPz(Util.nullAs(this.gte.getIntent().getStringExtra("fav_note_link_description"), ""));
    }
    if (this.EsB != null)
    {
      paramString1 = this.EsB;
      if (paramString1 != null) {
        paramLinkedList.DPd.ContentObj.Lpa = paramString1;
      }
    }
    paramLinkedList.ct(this.DPi, this.EpN);
    paramLinkedList.YK(this.EpG);
    paramLinkedList.aPE(this.eag);
    paramLinkedList.aPF(this.EpF);
    paramLinkedList.YI(paramInt1);
    if (paramBoolean) {
      paramLinkedList.YL(1);
    }
    for (;;)
    {
      paramLinkedList.gR(paramList2);
      paramString1 = new LinkedList();
      if (paramList1 == null) {
        break;
      }
      new LinkedList();
      paramList2 = com.tencent.mm.pluginsdk.i.a.gnq();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramPInt = (String)paramList1.next();
        if (!paramList2.contains(paramPInt))
        {
          ebm localebm = new ebm();
          localebm.UserName = paramPInt;
          paramString1.add(localebm);
        }
      }
      paramLinkedList.YL(0);
    }
    if (parami != null) {
      paramLinkedList.kl(parami.token, parami.Mte);
    }
    paramLinkedList.bq(paramString1);
    if (!Util.isNullOrNil(this.appId)) {
      paramLinkedList.aPC(this.appId);
    }
    if (!Util.isNullOrNil(this.appName)) {
      paramLinkedList.aPD(Util.nullAs(this.appName, ""));
    }
    if (this.Ero) {
      paramLinkedList.YK(5);
    }
    paramLinkedList.a(paramcjy);
    if ((this.Erp) && (this.Erq != null))
    {
      paramLinkedList.aPx(this.Erq.mediaTagName);
      paramLinkedList.aO(this.appId, this.Erq.messageExt, this.Erq.messageAction);
    }
    paramLinkedList.aPy(paramString2);
    paramLinkedList.aPH(this.eam);
    paramLinkedList.setSessionId(this.mSessionId);
    paramLinkedList.YG(this.Erv);
    paramInt1 = paramLinkedList.commit();
    if (this.EpM != null)
    {
      this.EpM.tQ(paramInt1);
      g.DVR.c(this.EpM);
    }
    if (this.Erw != null)
    {
      this.Erw.tQ(paramInt1);
      com.tencent.mm.plugin.sns.k.h.DVR.c(this.Erw);
      this.Erw.bfK();
    }
    aj.faK().eZn();
    this.gte.finish();
    AppMethodBeat.o(203303);
    return false;
  }
  
  public final void aC(Bundle paramBundle)
  {
    AppMethodBeat.i(203301);
    this.appId = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.EpG = this.gte.getIntent().getIntExtra("Ksnsupload_source", 0);
    this.eag = Util.nullAs(this.gte.getIntent().getStringExtra("src_username"), "");
    this.EpF = Util.nullAs(this.gte.getIntent().getStringExtra("src_displayname"), "");
    this.eam = Util.nullAs(this.gte.getIntent().getStringExtra("KPublisherId"), "");
    this.mSessionId = Util.nullAs(this.gte.getIntent().getStringExtra("reportSessionId"), "");
    this.EsA = Util.nullAs(this.gte.getIntent().getStringExtra("ksnsupload_mp_video_xml"), "");
    if (!Util.isNullOrNil(this.EsA))
    {
      paramBundle = XmlParser.parseXml(this.EsA, "mmbrandmpvideo", null);
      if (paramBundle != null) {
        this.EsB = com.tencent.mm.modelsns.h.k("", paramBundle);
      }
    }
    AppMethodBeat.o(203301);
  }
  
  public final void aD(Bundle paramBundle) {}
  
  public final boolean ffA()
  {
    return true;
  }
  
  public final View ffB()
  {
    AppMethodBeat.i(203302);
    this.sc = aa.jQ(this.gte).inflate(2131496778, null);
    this.sc.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(203300);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/MPVideoWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        if (ag.this.EsB != null)
        {
          localObject = new Rect();
          int[] arrayOfInt = new int[2];
          ag.this.EpH.getLocationOnScreen(arrayOfInt);
          ((Rect)localObject).set(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + ag.this.EpH.getMeasuredWidth(), arrayOfInt[1] + ag.this.EpH.getMeasuredHeight());
          com.tencent.mm.modelsns.h.a(paramAnonymousView.getContext(), ag.this.EsB, (Rect)localObject);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/MPVideoWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(203300);
      }
    });
    this.EpH = ((CdnImageView)this.sc.findViewById(2131302578));
    this.titleTv = ((TextView)this.sc.findViewById(2131309253));
    this.EpI = ((TextView)this.sc.findViewById(2131307116));
    Object localObject = (ImageView)this.sc.findViewById(2131308376);
    ((ImageView)localObject).setImageDrawable(ar.m(this.gte, 2131690929, -1));
    ((ImageView)localObject).setVisibility(0);
    this.EpH.setVisibility(0);
    if (this.EsB != null)
    {
      this.EpH.setUrl(this.EsB.iAo);
      this.titleTv.setText(this.EsB.title);
    }
    r.b(this.EpH, this.gte);
    localObject = this.sc;
    AppMethodBeat.o(203302);
    return localObject;
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
    return false;
  }
  
  public final boolean k(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ag
 * JD-Core Version:    0.7.0.1
 */