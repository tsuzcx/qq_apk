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
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.bf;
import com.tencent.mm.plugin.sns.model.bg;
import com.tencent.mm.plugin.sns.statistics.m;
import com.tencent.mm.plugin.sns.statistics.n;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.djv;
import com.tencent.mm.protocal.protobuf.ffw;
import com.tencent.mm.protocal.protobuf.jz;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.bb;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class aj
  implements ag
{
  private int DnR = 0;
  private int QzF = 1;
  private com.tencent.mm.modelsns.l RcD = null;
  private String RcE = "";
  private byte[] Rcw = null;
  private String Rcx;
  private int Rcy;
  CdnImageView Rcz = null;
  private boolean Rei = false;
  private boolean Rej = false;
  private WXMediaMessage Rek = null;
  private int Rep = 0;
  private com.tencent.mm.modelsns.l Req = null;
  private String Rfx;
  jz Rfy = null;
  private String appId;
  private String appName;
  private View doN = null;
  private String iaa;
  private String iag;
  private final MMActivity lzt;
  private String mSessionId;
  public String nTA = "";
  public String nTB = "";
  private String title = "";
  private TextView titleTv = null;
  private TextView ycd = null;
  
  public aj(MMActivity paramMMActivity)
  {
    this.lzt = paramMMActivity;
  }
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, djv paramdjv, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(308492);
    paramLinkedList = new bg(33, this.lzt);
    paramPInt.value = paramLinkedList.cIh;
    if (paramInt3 > com.tencent.mm.plugin.sns.d.a.Qkq) {
      paramLinkedList.akL(4);
    }
    paramLinkedList.aYR(this.title).aYM(paramString1);
    paramLinkedList.aYP(Util.nullAs(this.lzt.getIntent().getStringExtra("ksnsupload_link_desc"), ""));
    if (this.DnR == 15) {
      paramLinkedList.aYP(Util.nullAs(this.lzt.getIntent().getStringExtra("fav_note_link_description"), ""));
    }
    if (this.Rfy != null)
    {
      paramString1 = this.Rfy;
      if (paramString1 != null) {
        paramLinkedList.QzA.ContentObj.Zpw = paramString1;
      }
    }
    paramLinkedList.df(this.QzF, this.RcE);
    paramLinkedList.akQ(this.Rcy);
    paramLinkedList.aYU(this.iaa);
    paramLinkedList.aYV(this.Rcx);
    paramLinkedList.akO(paramInt1);
    if (paramBoolean) {
      paramLinkedList.akR(1);
    }
    for (;;)
    {
      paramLinkedList.kB(paramList2);
      paramString1 = new LinkedList();
      if (paramList1 == null) {
        break;
      }
      new LinkedList();
      paramList2 = com.tencent.mm.pluginsdk.platformtools.a.iIX();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramPInt = (String)paramList1.next();
        if ((paramList2 != null) && (!paramList2.contains(paramPInt)))
        {
          ffw localffw = new ffw();
          localffw.UserName = paramPInt;
          paramString1.add(localffw);
        }
      }
      paramLinkedList.akR(0);
    }
    if (parami != null) {
      paramLinkedList.mm(parami.token, parami.aaTQ);
    }
    paramLinkedList.bU(paramString1);
    if (!Util.isNullOrNil(this.appId)) {
      paramLinkedList.aYS(this.appId);
    }
    if (!Util.isNullOrNil(this.appName)) {
      paramLinkedList.aYT(Util.nullAs(this.appName, ""));
    }
    if (this.Rei) {
      paramLinkedList.akQ(5);
    }
    paramLinkedList.a(paramdjv);
    if ((this.Rej) && (this.Rek != null))
    {
      paramLinkedList.aYN(this.Rek.mediaTagName);
      paramLinkedList.aY(this.appId, this.Rek.messageExt, this.Rek.messageAction);
    }
    paramLinkedList.aYO(paramString2);
    paramLinkedList.aYX(this.iag);
    paramLinkedList.setSessionId(this.mSessionId);
    paramLinkedList.akM(this.Rep);
    paramInt1 = paramLinkedList.FW();
    if (this.RcD != null)
    {
      this.RcD.wQ(paramInt1);
      com.tencent.mm.plugin.sns.statistics.l.QGY.c(this.RcD);
    }
    if (this.Req != null)
    {
      this.Req.wQ(paramInt1);
      m.QGY.c(this.Req);
      this.Req.bMH();
    }
    al.hgx().hej();
    this.lzt.finish();
    AppMethodBeat.o(308492);
    return false;
  }
  
  public final void aZ(Bundle paramBundle)
  {
    AppMethodBeat.i(308482);
    this.appId = Util.nullAs(this.lzt.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = Util.nullAs(this.lzt.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.Rcy = this.lzt.getIntent().getIntExtra("Ksnsupload_source", 0);
    this.iaa = Util.nullAs(this.lzt.getIntent().getStringExtra("src_username"), "");
    this.Rcx = Util.nullAs(this.lzt.getIntent().getStringExtra("src_displayname"), "");
    this.iag = Util.nullAs(this.lzt.getIntent().getStringExtra("KPublisherId"), "");
    this.mSessionId = Util.nullAs(this.lzt.getIntent().getStringExtra("reportSessionId"), "");
    this.Rfx = Util.nullAs(this.lzt.getIntent().getStringExtra("ksnsupload_mp_video_xml"), "");
    if (!Util.isNullOrNil(this.Rfx))
    {
      paramBundle = XmlParser.parseXml(this.Rfx, "mmbrandmpvideo", null);
      if (paramBundle != null) {
        this.Rfy = com.tencent.mm.modelsns.i.j("", paramBundle);
      }
    }
    AppMethodBeat.o(308482);
  }
  
  public final void ba(Bundle paramBundle) {}
  
  public final boolean hlP()
  {
    return true;
  }
  
  public final View hlQ()
  {
    AppMethodBeat.i(308487);
    this.doN = af.mU(this.lzt).inflate(b.g.upload_media_link, null);
    this.doN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(308289);
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/MPVideoWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
        if (aj.this.Rfy != null)
        {
          localObject = new Rect();
          int[] arrayOfInt = new int[2];
          aj.this.Rcz.getLocationOnScreen(arrayOfInt);
          ((Rect)localObject).set(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + aj.this.Rcz.getMeasuredWidth(), arrayOfInt[1] + aj.this.Rcz.getMeasuredHeight());
          com.tencent.mm.modelsns.i.a(paramAnonymousView.getContext(), aj.this.Rfy, (Rect)localObject);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/MPVideoWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(308289);
      }
    });
    this.Rcz = ((CdnImageView)this.doN.findViewById(b.f.image_left));
    this.titleTv = ((TextView)this.doN.findViewById(b.f.titletext));
    this.ycd = ((TextView)this.doN.findViewById(b.f.righttext));
    Object localObject = (ImageView)this.doN.findViewById(b.f.state);
    ((ImageView)localObject).setImageDrawable(bb.m(this.lzt, b.i.icons_outlined_video_call, -1));
    ((ImageView)localObject).setVisibility(0);
    this.Rcz.setVisibility(0);
    if (this.Rfy != null)
    {
      this.Rcz.setUrl(this.Rfy.nUM);
      this.titleTv.setText(this.Rfy.title);
    }
    t.c(this.Rcz, this.lzt);
    localObject = this.doN;
    AppMethodBeat.o(308487);
    return localObject;
  }
  
  public final boolean hlR()
  {
    return true;
  }
  
  public final boolean hlS()
  {
    return true;
  }
  
  public final boolean hlT()
  {
    return false;
  }
  
  public final boolean n(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.aj
 * JD-Core Version:    0.7.0.1
 */