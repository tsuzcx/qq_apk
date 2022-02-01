package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.e;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.bb;
import com.tencent.mm.plugin.sns.model.bc;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bvq;
import com.tencent.mm.protocal.protobuf.dhj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class r
  implements ac
{
  private String appId = "";
  private String appName = "";
  private String dHo;
  private String dyy = "";
  private MMActivity fLP;
  private int h = -1;
  private Bitmap hMs = null;
  private String link = "";
  private boolean pzW = false;
  private String rJX = "";
  private View rY = null;
  private String title = "";
  private TextView titleTv = null;
  private int w = -1;
  private byte[] zQb = null;
  private String zQc;
  private int zQd;
  private CdnImageView zQe = null;
  private TextView zQf = null;
  private int zQg;
  private String zQh = "";
  private String zQi = "";
  private e zQj = null;
  private String zQk = "";
  private int znT = 1;
  
  public r(MMActivity paramMMActivity)
  {
    this.fLP = paramMMActivity;
  }
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, bvq parambvq, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(97869);
    paramLinkedList = new bc(22);
    paramPInt.value = paramLinkedList.beN;
    if (paramInt3 > a.zbZ) {
      paramLinkedList.Qb(2);
    }
    if (parami != null) {
      paramLinkedList.jr(parami.token, parami.GTp);
    }
    paramLinkedList.azo(this.title).azm(this.zQi).azn(this.link).azj(paramString1);
    boolean bool2 = false;
    boolean bool1;
    if (!bt.isNullOrNil(this.dyy))
    {
      bool1 = paramLinkedList.a(com.tencent.mm.vfs.i.aY(this.dyy, 0, -1), this.zQi, this.title, this.zQg, this.zQh);
      bool2 = bool1;
      if (!bool1)
      {
        ad.i("MicroMsg.EmotionListShareWidget", "set userData user imgurl ");
        bool2 = paramLinkedList.c(this.rJX, this.rJX, this.zQi, this.zQg, this.zQh);
      }
      if (!bool2) {
        ad.e("MicroMsg.EmotionListShareWidget", "set userData faild");
      }
      paramLinkedList.cc(this.znT, this.zQk);
      paramLinkedList.Qg(this.zQd);
      paramLinkedList.azr(this.dHo);
      paramLinkedList.azs(this.zQc);
      paramLinkedList.Qe(paramInt1);
      paramLinkedList.g(null, null, null, paramInt4, paramInt5);
      if (!paramBoolean) {
        break label470;
      }
      paramLinkedList.Qh(1);
    }
    for (;;)
    {
      paramLinkedList.fL(paramList2);
      if (!bt.isNullOrNil(this.appId))
      {
        paramLinkedList.azp(this.appId);
        paramLinkedList.azq(this.appName);
      }
      parami = new LinkedList();
      if (paramList1 == null) {
        break label480;
      }
      new LinkedList();
      paramString1 = com.tencent.mm.pluginsdk.i.d.fas();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramList2 = (String)paramList1.next();
        if (!paramString1.contains(paramList2))
        {
          paramPInt = new dhj();
          paramPInt.nDo = paramList2;
          parami.add(paramPInt);
        }
      }
      bool1 = bool2;
      if (bt.isNullOrNil(this.rJX)) {
        break;
      }
      bool1 = bool2;
      if (com.tencent.mm.aw.q.aIE() == null) {
        break;
      }
      com.tencent.mm.aw.q.aIE();
      parami = com.tencent.mm.aw.d.vT(this.rJX);
      bool1 = bool2;
      if (parami == null) {
        break;
      }
      bool1 = paramLinkedList.a(com.tencent.mm.sdk.platformtools.g.aA(parami), this.zQi, this.title, this.zQg, this.zQh);
      break;
      label470:
      paramLinkedList.Qh(0);
    }
    label480:
    paramLinkedList.aU(parami);
    paramLinkedList.a(parambvq);
    paramInt1 = paramLinkedList.commit();
    if (this.zQj != null)
    {
      this.zQj.pX(paramInt1);
      com.tencent.mm.plugin.sns.j.g.zus.c(this.zQj);
    }
    ag.dUa().dSE();
    this.fLP.finish();
    AppMethodBeat.o(97869);
    return false;
  }
  
  public final void ap(Bundle paramBundle)
  {
    AppMethodBeat.i(97867);
    this.zQj = e.w(this.fLP.getIntent());
    this.w = this.fLP.getIntent().getIntExtra("Ksnsupload_width", -1);
    this.h = this.fLP.getIntent().getIntExtra("Ksnsupload_height", -1);
    this.zQd = this.fLP.getIntent().getIntExtra("Ksnsupload_source", 0);
    this.link = bt.bI(this.fLP.getIntent().getStringExtra("Ksnsupload_link"), "");
    this.title = bt.bI(this.fLP.getIntent().getStringExtra("Ksnsupload_title"), "");
    this.rJX = bt.bI(this.fLP.getIntent().getStringExtra("Ksnsupload_imgurl"), "");
    this.dyy = this.fLP.getIntent().getStringExtra("KsnsUpload_imgPath");
    this.pzW = this.fLP.getIntent().getBooleanExtra("ksnsis_video", false);
    this.dHo = bt.bI(this.fLP.getIntent().getStringExtra("src_username"), "");
    this.zQc = bt.bI(this.fLP.getIntent().getStringExtra("src_displayname"), "");
    this.zQi = bt.bI(this.fLP.getIntent().getStringExtra("KContentObjDesc"), "");
    this.zQh = bt.bI(this.fLP.getIntent().getStringExtra("KUploadProduct_UserData"), "");
    this.appName = bt.bI(this.fLP.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.appId = bt.bI(this.fLP.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.zQg = this.fLP.getIntent().getIntExtra("KUploadProduct_subType", 0);
    if (this.fLP.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {}
    for (this.znT = 1;; this.znT = 0)
    {
      this.zQk = bt.bI(this.fLP.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
      AppMethodBeat.o(97867);
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
    AppMethodBeat.i(97868);
    this.rY = z.jO(this.fLP).inflate(2131495816, null);
    this.zQe = ((CdnImageView)this.rY.findViewById(2131300948));
    this.titleTv = ((TextView)this.rY.findViewById(2131305950));
    this.zQf = ((TextView)this.rY.findViewById(2131304202));
    if (this.pzW)
    {
      this.rY.findViewById(2131305185).setVisibility(0);
      this.titleTv.setText(this.title);
      if (bt.isNullOrNil(this.rJX)) {
        break label178;
      }
      this.zQe.setVisibility(0);
      this.zQe.setUrl(this.rJX);
    }
    for (;;)
    {
      com.tencent.mm.plugin.sns.data.q.b(this.zQe, this.fLP);
      View localView = this.rY;
      AppMethodBeat.o(97868);
      return localView;
      this.rY.findViewById(2131305185).setVisibility(8);
      break;
      label178:
      if (!bt.cC(this.zQb))
      {
        this.zQe.setVisibility(0);
        this.hMs = com.tencent.mm.sdk.platformtools.g.cr(this.zQb);
        this.zQe.setImageBitmap(this.hMs);
      }
      else
      {
        this.zQe.setVisibility(8);
      }
    }
  }
  
  public final boolean dZI()
  {
    AppMethodBeat.i(97870);
    if ((this.hMs != null) && (!this.hMs.isRecycled())) {
      this.hMs.recycle();
    }
    AppMethodBeat.o(97870);
    return false;
  }
  
  public final boolean k(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.r
 * JD-Core Version:    0.7.0.1
 */