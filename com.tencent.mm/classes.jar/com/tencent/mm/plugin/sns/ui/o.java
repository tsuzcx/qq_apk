package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsns.l;
import com.tencent.mm.plugin.sns.data.t;
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
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ad;
import com.tencent.mm.vfs.u;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class o
  implements af
{
  private byte[] KCN = null;
  private String KCO;
  private int KCP;
  private CdnImageView KCQ = null;
  private TextView KCR = null;
  private int KCS;
  private String KCT = "";
  private String KCU = "";
  private l KCV = null;
  private String KCW = "";
  private int Kcp = 1;
  private String appId = "";
  private String appName = "";
  private View bvK = null;
  private String fKH = "";
  private String fUd;
  private int h = -1;
  private MMActivity iXq;
  private Bitmap lAx = null;
  private String link = "";
  private String title = "";
  private TextView titleTv = null;
  private int w = -1;
  private boolean wRb = false;
  private String xei = "";
  
  public o(MMActivity paramMMActivity)
  {
    this.iXq = paramMMActivity;
  }
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, cst paramcst, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(97857);
    paramLinkedList = new be(17, this.iXq);
    paramPInt.value = paramLinkedList.aOl;
    if (paramInt3 > com.tencent.mm.plugin.sns.c.a.JPj) {
      paramLinkedList.afW(2);
    }
    if (parami != null) {
      paramLinkedList.kG(parami.token, parami.TEk);
    }
    paramLinkedList.bax(this.title).bav(this.KCU).baw(this.link).bas(paramString1);
    boolean bool2 = false;
    boolean bool1;
    if (!Util.isNullOrNil(this.fKH))
    {
      bool1 = paramLinkedList.a(u.aY(this.fKH, 0, -1), this.KCU, this.title, this.KCS, this.KCT);
      bool2 = bool1;
      if (!bool1)
      {
        Log.i("MicroMsg.EmojiDesignerShareWidget", "set userData user imgurl ");
        bool2 = paramLinkedList.c(this.xei, this.xei, this.KCU, this.KCS, this.KCT);
      }
      if (!bool2) {
        Log.e("MicroMsg.EmojiDesignerShareWidget", "set userData faild");
      }
      paramLinkedList.ct(this.Kcp, this.KCW);
      paramLinkedList.agb(this.KCP);
      paramLinkedList.baA(this.fUd);
      paramLinkedList.baB(this.KCO);
      paramLinkedList.i(null, null, null, paramInt4, paramInt5);
      paramLinkedList.afZ(paramInt1);
      if (!paramBoolean) {
        break label474;
      }
      paramLinkedList.agc(1);
    }
    for (;;)
    {
      paramLinkedList.hA(paramList2);
      if (!Util.isNullOrNil(this.appId))
      {
        paramLinkedList.bay(this.appId);
        paramLinkedList.baz(this.appName);
      }
      parami = new LinkedList();
      if (paramList1 == null) {
        break label484;
      }
      new LinkedList();
      paramString1 = com.tencent.mm.pluginsdk.j.a.hhW();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramList2 = (String)paramList1.next();
        if (!paramString1.contains(paramList2))
        {
          paramPInt = new elm();
          paramPInt.UserName = paramList2;
          parami.add(paramPInt);
        }
      }
      bool1 = bool2;
      if (Util.isNullOrNil(this.xei)) {
        break;
      }
      bool1 = bool2;
      if (q.bmg() == null) {
        break;
      }
      q.bmg();
      parami = com.tencent.mm.ay.d.LI(this.xei);
      bool1 = bool2;
      if (parami == null) {
        break;
      }
      bool1 = paramLinkedList.a(BitmapUtil.Bitmap2PngBytes(parami), this.KCU, this.title, this.KCS, this.KCT);
      break;
      label474:
      paramLinkedList.agc(0);
    }
    label484:
    paramLinkedList.bL(parami);
    paramLinkedList.a(paramcst);
    paramInt1 = paramLinkedList.in();
    if (this.KCV != null)
    {
      this.KCV.wQ(paramInt1);
      com.tencent.mm.plugin.sns.k.i.Kjb.c(this.KCV);
    }
    aj.fOE().fNd();
    this.iXq.finish();
    ((com.tencent.mm.plugin.emoji.b.d)h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aum(this.KCT);
    ((com.tencent.mm.plugin.emoji.b.d)h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aun(this.KCT);
    AppMethodBeat.o(97857);
    return false;
  }
  
  public final void ay(Bundle paramBundle)
  {
    AppMethodBeat.i(97855);
    this.KCV = l.x(this.iXq.getIntent());
    this.w = this.iXq.getIntent().getIntExtra("Ksnsupload_width", -1);
    this.h = this.iXq.getIntent().getIntExtra("Ksnsupload_height", -1);
    this.KCP = this.iXq.getIntent().getIntExtra("Ksnsupload_source", 0);
    this.link = Util.nullAs(this.iXq.getIntent().getStringExtra("Ksnsupload_link"), "");
    this.title = Util.nullAs(this.iXq.getIntent().getStringExtra("Ksnsupload_title"), "");
    this.xei = Util.nullAs(this.iXq.getIntent().getStringExtra("Ksnsupload_imgurl"), "");
    this.fKH = this.iXq.getIntent().getStringExtra("KsnsUpload_imgPath");
    this.wRb = this.iXq.getIntent().getBooleanExtra("ksnsis_video", false);
    this.fUd = Util.nullAs(this.iXq.getIntent().getStringExtra("src_username"), "");
    this.KCO = Util.nullAs(this.iXq.getIntent().getStringExtra("src_displayname"), "");
    this.KCU = Util.nullAs(this.iXq.getIntent().getStringExtra("KContentObjDesc"), "");
    this.KCT = Util.nullAs(this.iXq.getIntent().getStringExtra("KUploadProduct_UserData"), "");
    this.appName = Util.nullAs(this.iXq.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.appId = Util.nullAs(this.iXq.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.KCS = this.iXq.getIntent().getIntExtra("KUploadProduct_subType", 0);
    if (this.iXq.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {}
    for (this.Kcp = 1;; this.Kcp = 0)
    {
      this.KCW = Util.nullAs(this.iXq.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
      AppMethodBeat.o(97855);
      return;
    }
  }
  
  public final void az(Bundle paramBundle) {}
  
  public final boolean fTA()
  {
    AppMethodBeat.i(97858);
    if ((this.lAx != null) && (!this.lAx.isRecycled())) {
      this.lAx.recycle();
    }
    AppMethodBeat.o(97858);
    return false;
  }
  
  public final boolean fTw()
  {
    return true;
  }
  
  public final View fTx()
  {
    AppMethodBeat.i(97856);
    this.bvK = ad.kS(this.iXq).inflate(i.g.upload_media_link, null);
    this.KCQ = ((CdnImageView)this.bvK.findViewById(i.f.image_left));
    this.titleTv = ((TextView)this.bvK.findViewById(i.f.titletext));
    this.KCR = ((TextView)this.bvK.findViewById(i.f.righttext));
    if (this.wRb)
    {
      this.bvK.findViewById(i.f.state).setVisibility(0);
      this.titleTv.setText(this.title);
      if (Util.isNullOrNil(this.xei)) {
        break label178;
      }
      this.KCQ.setVisibility(0);
      this.KCQ.setUrl(this.xei);
    }
    for (;;)
    {
      t.b(this.KCQ, this.iXq);
      View localView = this.bvK;
      AppMethodBeat.o(97856);
      return localView;
      this.bvK.findViewById(i.f.state).setVisibility(8);
      break;
      label178:
      if (!Util.isNullOrNil(this.KCN))
      {
        this.KCQ.setVisibility(0);
        this.lAx = BitmapUtil.decodeByteArray(this.KCN);
        this.KCQ.setImageBitmap(this.lAx);
      }
      else
      {
        this.KCQ.setVisibility(8);
      }
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
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.o
 * JD-Core Version:    0.7.0.1
 */