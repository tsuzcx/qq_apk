package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.l;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.k.j;
import com.tencent.mm.plugin.sns.k.k;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.bd;
import com.tencent.mm.plugin.sns.model.be;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.protocal.protobuf.elm;
import com.tencent.mm.protocal.protobuf.jd;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.au;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ai
  implements af
{
  private byte[] KCN = null;
  private String KCO;
  private int KCP;
  CdnImageView KCQ = null;
  private TextView KCR = null;
  private l KCV = null;
  private String KCW = "";
  private boolean KEH = false;
  private boolean KEI = false;
  private WXMediaMessage KEJ = null;
  private int KEO = 0;
  private l KEP = null;
  private String KFX;
  jd KFY = null;
  private int Kcp = 1;
  private String appId;
  private String appName;
  private View bvK = null;
  private String fUd;
  private String fUj;
  private final MMActivity iXq;
  public String lox = "";
  public String loy = "";
  private String mSessionId;
  private String title = "";
  private TextView titleTv = null;
  private int yAT = 0;
  
  public ai(MMActivity paramMMActivity)
  {
    this.iXq = paramMMActivity;
  }
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, cst paramcst, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(202495);
    paramLinkedList = new be(33, this.iXq);
    paramPInt.value = paramLinkedList.aOl;
    if (paramInt3 > com.tencent.mm.plugin.sns.c.a.JPj) {
      paramLinkedList.afW(4);
    }
    paramLinkedList.bax(this.title).bas(paramString1);
    paramLinkedList.bav(Util.nullAs(this.iXq.getIntent().getStringExtra("ksnsupload_link_desc"), ""));
    if (this.yAT == 15) {
      paramLinkedList.bav(Util.nullAs(this.iXq.getIntent().getStringExtra("fav_note_link_description"), ""));
    }
    if (this.KFY != null)
    {
      paramString1 = this.KFY;
      if (paramString1 != null) {
        paramLinkedList.Kck.ContentObj.Sqw = paramString1;
      }
    }
    paramLinkedList.ct(this.Kcp, this.KCW);
    paramLinkedList.agb(this.KCP);
    paramLinkedList.baA(this.fUd);
    paramLinkedList.baB(this.KCO);
    paramLinkedList.afZ(paramInt1);
    if (paramBoolean) {
      paramLinkedList.agc(1);
    }
    for (;;)
    {
      paramLinkedList.hA(paramList2);
      paramString1 = new LinkedList();
      if (paramList1 == null) {
        break;
      }
      new LinkedList();
      paramList2 = com.tencent.mm.pluginsdk.j.a.hhW();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramPInt = (String)paramList1.next();
        if (!paramList2.contains(paramPInt))
        {
          elm localelm = new elm();
          localelm.UserName = paramPInt;
          paramString1.add(localelm);
        }
      }
      paramLinkedList.agc(0);
    }
    if (parami != null) {
      paramLinkedList.kG(parami.token, parami.TEk);
    }
    paramLinkedList.bL(paramString1);
    if (!Util.isNullOrNil(this.appId)) {
      paramLinkedList.bay(this.appId);
    }
    if (!Util.isNullOrNil(this.appName)) {
      paramLinkedList.baz(Util.nullAs(this.appName, ""));
    }
    if (this.KEH) {
      paramLinkedList.agb(5);
    }
    paramLinkedList.a(paramcst);
    if ((this.KEI) && (this.KEJ != null))
    {
      paramLinkedList.bat(this.KEJ.mediaTagName);
      paramLinkedList.aI(this.appId, this.KEJ.messageExt, this.KEJ.messageAction);
    }
    paramLinkedList.bau(paramString2);
    paramLinkedList.baD(this.fUj);
    paramLinkedList.setSessionId(this.mSessionId);
    paramLinkedList.afX(this.KEO);
    paramInt1 = paramLinkedList.in();
    if (this.KCV != null)
    {
      this.KCV.wQ(paramInt1);
      com.tencent.mm.plugin.sns.k.i.Kjb.c(this.KCV);
    }
    if (this.KEP != null)
    {
      this.KEP.wQ(paramInt1);
      j.Kjb.c(this.KEP);
      this.KEP.bpa();
    }
    aj.fOE().fNd();
    this.iXq.finish();
    AppMethodBeat.o(202495);
    return false;
  }
  
  public final void ay(Bundle paramBundle)
  {
    AppMethodBeat.i(202449);
    this.appId = Util.nullAs(this.iXq.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = Util.nullAs(this.iXq.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.KCP = this.iXq.getIntent().getIntExtra("Ksnsupload_source", 0);
    this.fUd = Util.nullAs(this.iXq.getIntent().getStringExtra("src_username"), "");
    this.KCO = Util.nullAs(this.iXq.getIntent().getStringExtra("src_displayname"), "");
    this.fUj = Util.nullAs(this.iXq.getIntent().getStringExtra("KPublisherId"), "");
    this.mSessionId = Util.nullAs(this.iXq.getIntent().getStringExtra("reportSessionId"), "");
    this.KFX = Util.nullAs(this.iXq.getIntent().getStringExtra("ksnsupload_mp_video_xml"), "");
    if (!Util.isNullOrNil(this.KFX))
    {
      paramBundle = XmlParser.parseXml(this.KFX, "mmbrandmpvideo", null);
      if (paramBundle != null) {
        this.KFY = com.tencent.mm.modelsns.i.j("", paramBundle);
      }
    }
    AppMethodBeat.o(202449);
  }
  
  public final void az(Bundle paramBundle) {}
  
  public final boolean fTA()
  {
    return false;
  }
  
  public final boolean fTw()
  {
    return true;
  }
  
  public final View fTx()
  {
    AppMethodBeat.i(202464);
    this.bvK = ad.kS(this.iXq).inflate(i.g.upload_media_link, null);
    this.bvK.setOnClickListener(new ai.1(this));
    this.KCQ = ((CdnImageView)this.bvK.findViewById(i.f.image_left));
    this.titleTv = ((TextView)this.bvK.findViewById(i.f.titletext));
    this.KCR = ((TextView)this.bvK.findViewById(i.f.righttext));
    Object localObject = (ImageView)this.bvK.findViewById(i.f.state);
    ((ImageView)localObject).setImageDrawable(au.o(this.iXq, i.i.icons_outlined_video_call, -1));
    ((ImageView)localObject).setVisibility(0);
    this.KCQ.setVisibility(0);
    if (this.KFY != null)
    {
      this.KCQ.setUrl(this.KFY.lpK);
      this.titleTv.setText(this.KFY.title);
    }
    t.b(this.KCQ, this.iXq);
    localObject = this.bvK;
    AppMethodBeat.o(202464);
    return localObject;
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
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ai
 * JD-Core Version:    0.7.0.1
 */